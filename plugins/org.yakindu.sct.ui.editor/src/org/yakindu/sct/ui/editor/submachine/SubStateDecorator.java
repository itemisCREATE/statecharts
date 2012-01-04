/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.submachine;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.util.DiagramRenderUtil;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.Decoration;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget.Direction;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.model.sgraph.State;

import de.itemis.gmf.runtime.commons.decorators.BaseDecorator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class SubStateDecorator extends BaseDecorator {

	protected abstract boolean shouldDecorate(State state);

	protected abstract Image getDecorationImage(State state);

	protected abstract Diagram getTooltipDiagramToRender(State state);

	protected abstract void mouseClicked(Decoration decoration,
			State semanticElement);

	protected abstract Direction getDecoratorPosition();

	public SubStateDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}

	public void refresh() {
		removeDecoration();
		if (getDecoratorTarget().getAdapter(EditPart.class) instanceof IPrimaryEditPart) {
			EObject semanticElement = (EObject) getDecoratorTarget()
					.getAdapter(EObject.class);
			if (semanticElement instanceof State) {
				final State state = (State) semanticElement;
				if (shouldDecorate(state)) {
					final Decoration decoration = (Decoration) getDecoratorTarget()
							.addShapeDecoration(getDecorationImage(state),
									getDecoratorPosition(), -5, false);
					renderToolTip(decoration, state);
					decoration.addMouseListener(new MouseListener() {
						public void mousePressed(MouseEvent me) {
							mouseClicked(decoration, state);
						}

						public void mouseReleased(MouseEvent me) {
						}

						public void mouseDoubleClicked(MouseEvent me) {
						}
					});
					setDecoration(decoration);
				}
			}
		}
	}

	protected Image resize(Image image, int width, int height) {
		Image scaled = new Image(Display.getDefault(), width, height);
		GC gc = new GC(scaled);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(image, 0, 0, image.getBounds().width,
				image.getBounds().height, 0, 0, width, height);
		gc.dispose();
		image.dispose();
		return scaled;
	}

	protected void renderToolTip(final Decoration decoration,
			final State semanticElement) {
		decoration.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent me) {
			}

			public void mouseEntered(MouseEvent me) {
				Diagram diagram = getTooltipDiagramToRender(semanticElement);
				if (diagram != null) {
					Image renderImage = renderImage(diagram);
					ImageFigure toolTip = new ImageFigure(renderImage);
					decoration.setToolTip(toolTip);
				}
			}

			public void mouseExited(MouseEvent me) {
			}

			public void mouseHover(MouseEvent me) {
			}

			public void mouseMoved(MouseEvent me) {
			}
		});
	}

	protected Image renderImage(Diagram diagram) {
		Assert.isNotNull(diagram);
		Image renderImage = DiagramRenderUtil.renderToSWTImage(diagram);
		Image resize = resize(renderImage,
				(int) (0.7071 * renderImage.getBounds().width),
				(int) (0.7071 * renderImage.getBounds().height));
		return resize;
	}

}
