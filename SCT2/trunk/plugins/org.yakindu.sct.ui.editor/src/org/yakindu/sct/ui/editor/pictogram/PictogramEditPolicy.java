/*******************************************************************************
 * Copyright (c) 2010  itemis AG (http://www.itemis.de)
 * All rights reserved. 
 * 
 * Contributors:
 *     itemis AG - initial API and implementation
 *******************************************************************************/
package org.yakindu.sct.ui.editor.pictogram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.RelativeLocator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.ISources;

/**
 * This is a pictogram edit policy which locates the icon and updates it inside
 * the host figure.
 * 
 * @author Alexander Nyssen
 * @author Andreas Muelder
 */
public class PictogramEditPolicy extends AbstractEditPolicy {

	public static final String ROLE = "Pictograms";

	protected static final int DEFAULT_Y_ABSOLUTE_OFFSET = -5;

	protected static final double DEFAULT_Y_RELATIVE_OFFSET = 0.0;

	protected static final int DEFAULT_X_ABSOLUTE_OFFSET = 5;

	protected static final double DEFAULT_X_RELATIVE_OFFSET = 0.0;

	private IFigure pictogramContainerFigure;

	private final FigureListener hostFigureListener = new FigureListener() {
		public void figureMoved(final IFigure arg0) {
			layoutPictogramContainer();
			updatePictogramFigureStates();
		}
	};

	private final AncestorListener hostFigureAncestorListener = new AncestorListener() {
		public void ancestorMoved(IFigure ancestor) {
			layoutPictogramContainer();
			updatePictogramFigureStates();
		}

		public void ancestorAdded(IFigure ancestor) {
		}

		public void ancestorRemoved(IFigure ancestor) {
		}
	};

	private final Adapter modelListener = new Adapter() {

		public Notifier getTarget() {
			return null;
		}

		public boolean isAdapterForType(final Object arg0) {
			return false;
		}

		public void notifyChanged(final Notification notification) {
			switch (notification.getEventType()) {
			case Notification.REMOVING_ADAPTER:
				return;
			default:
				if (notification.getNewValue() != null) {
					updatePictogramFigureStates();
				}
			}
		}

		public void setTarget(final Notifier arg0) {
		}
	};

	private Locator pictogramContainerFigureLocator;

	private final List<Pictogram> pictograms = new ArrayList<Pictogram>();

	private final Map<Pictogram, PictogramFigure> pictogramFigures = new HashMap<Pictogram, PictogramFigure>();

	private final Map<PictogramFigure, MouseListener> figureListeners = new HashMap<PictogramFigure, MouseListener>();

	private EObject registeredSemanticModelElement;

	/**
	 * positions the given figure at the bottom left corner of the reference
	 * figure.
	 * 
	 * @author Alexander Nyssen
	 */
	public static final class BottomLeftRelativeLocator extends RelativeLocator {

		private final double relativeX;

		private final double relativeY;

		private final int absoluteX;

		private final int absoluteY;

		public BottomLeftRelativeLocator(final IFigure reference,
				final double relativeX, final int absoluteX,
				final double relativeY, final int absoluteY) {
			super(reference, relativeX, relativeY);
			this.relativeX = relativeX;
			this.absoluteX = absoluteX;
			this.relativeY = relativeY;
			this.absoluteY = absoluteY;
		}

		@Override
		public void relocate(final IFigure targetFigure) {
			final Rectangle referenceBox = getReferenceBox().getCopy();
			getReferenceFigure().translateToAbsolute(referenceBox);
			targetFigure.translateToRelative(referenceBox);
			final Rectangle targetFigureBounds = new Rectangle(
					referenceBox
							.getBottomLeft()
							.getTranslated(
									new Dimension(
											(int) (relativeX * referenceBox.width)
													+ absoluteX,
											(int) (relativeY * referenceBox.height)
													+ absoluteY
													- targetFigure
															.getPreferredSize().height)),
					targetFigure.getPreferredSize());
			targetFigure.setBounds(targetFigureBounds);
		}
	}

	/**
	 * A pictogram container figure with flow layout.
	 * 
	 * @author Alexander Nyssen
	 */
	private static class PictogramContainerFigure extends Figure {
		public PictogramContainerFigure() {
			setLayoutManager(new FlowLayout());
		}
	}

	public PictogramEditPolicy(final List<? extends Pictogram> pictograms) {
		this.pictograms.addAll(pictograms);
	}

	protected void updatePictogramFigureStates() {
		// enable/disable figures dependent on the execution context
		for (final Pictogram pictogram : pictogramFigures.keySet()) {
			final PictogramFigure pictogramFigure = pictogramFigures
					.get(pictogram);
			final boolean validContext = pictogram.getHandlerContextValidator()
					.isValidContext(createExecutionEvent(null));
			pictogramFigure.setEnabled(validContext);
			pictogramFigure.repaint();
		}
	}

	protected void executePictogramHandler(final Pictogram pictogram,
			MouseEvent mouseEvent) {
		final IHandler handler = pictogram.getHandler();
		final ExecutionEvent executionEvent = createExecutionEvent(mouseEvent);
		if (pictogram.getHandlerContextValidator().isValidContext(
				executionEvent)) {
			try {
				handler.execute(executionEvent);
			} catch (final ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void activate() {
		super.activate();
		pictogramContainerFigure = new PictogramContainerFigure();
		for (final Pictogram pictogram : getPictograms()) {
			final PictogramFigure pictogramFigure = new PictogramFigure(
					pictogram, getHost().getFigure());
			pictogramFigures.put(pictogram, pictogramFigure);
			pictogramContainerFigure.add(pictogramFigure);
			figureListeners.put(pictogramFigure, new MouseListener() {

				public void mouseDoubleClicked(final MouseEvent event) {
				}

				public void mousePressed(final MouseEvent event) {
					executePictogramHandler(pictogram, event);
				}

				public void mouseReleased(final MouseEvent event) {
				}

			});
			pictogramFigure.addMouseListener(figureListeners
					.get(pictogramFigure));
		}
		// add pictogram figure to layer, keep it attached to the original
		// figure using a locator
		getFeedbackLayer().add(pictogramContainerFigure);
		registerFigureListener(hostFigureListener);
		registerAncestorListener(hostFigureAncestorListener);
		registerSemanticModelListener(modelListener);
		registerGraphModelListener(modelListener);
		layoutPictogramContainer();
		if (getHost().resolveSemanticElement() != null) {
			updatePictogramFigureStates();
		}
	}

	private void registerAncestorListener(AncestorListener listener) {
		getHostFigure().addAncestorListener(listener);
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	protected void registerFigureListener(final FigureListener figureListener) {
		getHostFigure().addFigureListener(figureListener);
	}

	protected void unregisterFigureListener(final FigureListener figureListener) {
		getHostFigure().removeFigureListener(figureListener);
	}

	protected void unregisterAncestorListener(
			final AncestorListener figureListener) {
		getHostFigure().removeAncestorListener(figureListener);
	}

	protected void registerSemanticModelListener(final Adapter modelListener) {
		// be default register a listener at the host's semantic model
		registeredSemanticModelElement = getHostSemanticModel();
		if (registeredSemanticModelElement != null) {
			registeredSemanticModelElement.eAdapters().add(modelListener);
		}
	}

	protected void registerGraphModelListener(final Adapter modelListener) {
		((View) getHost().getModel()).eAdapters().add(modelListener);
	}

	protected void unregisterGraphModelListener(final Adapter modelListener) {
		((View) getHost().getModel()).eAdapters().remove(modelListener);
	}

	@Override
	public void deactivate() {
		unregisterGraphModelListener(modelListener);
		unregisterSemanticModelListener(modelListener);
		unregisterFigureListener(hostFigureListener);
		unregisterAncestorListener(hostFigureAncestorListener);
		getFeedbackLayer().remove(pictogramContainerFigure);
		for (final Pictogram pictogram : getPictograms()) {
			final PictogramFigure pictogramFigure = pictogramFigures
					.get(pictogram);
			pictogramFigure.removeMouseListener(figureListeners
					.get(pictogramFigure));
		}
		super.deactivate();
	}

	protected void unregisterSemanticModelListener(final Adapter modelListener) {
		if (registeredSemanticModelElement != null) {
			registeredSemanticModelElement.eAdapters().remove(modelListener);
		}
	}

	protected void layoutPictogramContainer() {
		getPictogramContainerFigureLocator().relocate(pictogramContainerFigure);
	}

	protected Locator getPictogramContainerFigureLocator() {
		if (pictogramContainerFigureLocator == null) {
			pictogramContainerFigureLocator = createPictogramContainerFigureLocator();
		}
		return pictogramContainerFigureLocator;
	}

	protected BottomLeftRelativeLocator createPictogramContainerFigureLocator() {
		// (5, -5) offset from bottom left corner of parent
		return new BottomLeftRelativeLocator(getHostFigure(),
				DEFAULT_X_RELATIVE_OFFSET, DEFAULT_X_ABSOLUTE_OFFSET,
				DEFAULT_Y_RELATIVE_OFFSET, DEFAULT_Y_ABSOLUTE_OFFSET);
	}

	protected IFigure getFeedbackLayer() {
		return LayerManager.Helper.find(getHost()).getLayer(
				LayerConstants.CONNECTION_LAYER);
	}

	protected IFigure getHostFigure() {
		return getHost().getFigure();
	}

	protected EObject getHostSemanticModel() {
		final Object model = getHost().getModel();
		if (model instanceof View) {
			return ((View) model).getElement();
		} else if (model instanceof EObject) {
			return (EObject) model;
		}
		throw new IllegalStateException("Could not find semantic model");
	}

	public List<Pictogram> getPictograms() {
		return pictograms;
	}

	private ExecutionEvent createExecutionEvent(MouseEvent mouseEvent) {
		// assume the host's parent edit part is selected when executing the
		// handler
		return createExecutionEvent(getHost(), mouseEvent);
	}

	public static ExecutionEvent createExecutionEvent(
			final IGraphicalEditPart editPart, MouseEvent mouseEvent) {
		final IEvaluationContext context = new EvaluationContext(null, editPart);
		context.addVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME,
				new StructuredSelection(Collections.singletonList(editPart)));

		final Map<String, String> parameters = new HashMap<String, String>();
		if (mouseEvent != null) {
			parameters.put("x", String.valueOf(mouseEvent.x));
			parameters.put("y", String.valueOf(mouseEvent.y));
		}

		return new ExecutionEvent(null, parameters, null, context);
	}

}
