package de.itemis.gmf.runtime.commons.highlighting;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.widgets.Display;
/**
 * 
 * @author Alexander Nyssen
 *
 */
public class HighlightingSupportAdapter implements IHighlightingSupport {

	private class ColorMemento {
		private final Color foregroundColor;
		private final Color backgroundColor;
		private final IFigure figure;

		protected ColorMemento(IFigure figure) {
			this.figure = figure;
			this.foregroundColor = figure.getForegroundColor();
			this.backgroundColor = figure.getBackgroundColor();
		}

		protected void restore() {
			figure.setForegroundColor(foregroundColor);
			figure.setBackgroundColor(backgroundColor);
		}
	}

	private class Fader implements Runnable {

		private final int fadingTime;
		private final Color sourceForegroundColor;
		private final Color targetForegroundColor;
		private final IFigure figure;
		private final boolean shouldFadeBack;
		private final Color sourceBackgroundColor;
		private final Color targetBackgroundColor;

		private Fader(IFigure figure, Color sourceForegroundColor,
				Color targetForegroundColor, Color sourceBackgroundColor,
				Color targetBackgroundColor, int fadingTime,
				boolean shouldFadeBack) {
			this.figure = figure;
			this.sourceForegroundColor = sourceForegroundColor;
			this.targetForegroundColor = targetForegroundColor;
			this.sourceBackgroundColor = sourceBackgroundColor;
			this.targetBackgroundColor = targetBackgroundColor;
			this.shouldFadeBack = shouldFadeBack;
			this.fadingTime = fadingTime;
		}

		public void run() {
			if (!locked) {
				// if we were started as "back-fader" via timer and editor
				// was released in the meantime, don't perform fading back
				return;
			}

			figure.setForegroundColor(targetForegroundColor);
			figure.setBackgroundColor(targetBackgroundColor);
			figure.invalidate();
			if (shouldFadeBack) {
				Display.getCurrent().timerExec(
						fadingTime,
						new Fader(figure, targetForegroundColor,
								sourceForegroundColor, targetBackgroundColor,
								sourceBackgroundColor, fadingTime, false));
			}
		}
	}

	private final Map<IFigure, ColorMemento> figureStates = new HashMap<IFigure, ColorMemento>();
	private final Map<Color, Color> greyscaleColors = new HashMap<Color, Color>();
	private boolean locked = false;
	private final IDiagramWorkbenchPart diagramWorkbenchPart;

	public HighlightingSupportAdapter(IDiagramWorkbenchPart diagramWorkbenchPart) {
		this.diagramWorkbenchPart = diagramWorkbenchPart;
	}

	public synchronized void fadeIn(EObject semanticElement,
			HighlightingParameters parameters) {
		if (!locked) {
			throw new IllegalStateException(
					"May only highlight if editor is locked");
		}

		IGraphicalEditPart editPart = getEditPartForSemanticElement(semanticElement);
		Assert.isNotNull(editPart, "Could not find a matching edit part");
		// ensure the edit part is made visible.
		diagramWorkbenchPart.getDiagramGraphicalViewer().reveal(editPart);
		IFigure figure = getTargetFigure(editPart);
		Assert.isNotNull(figure, "Could not obtain target figure");
		// store fore and background color
		Display.getCurrent().asyncExec(
				new Fader(figure, figure.getForegroundColor(),
						parameters.foregroundFadingColor, figure
								.getBackgroundColor(),
						parameters.backgroundFadingColor,
						(int) parameters.fadingTime, false));
	}

	public synchronized void fadeOut(EObject semanticElement,
			HighlightingParameters parameters) {
		if (!locked) {
			throw new IllegalStateException(
					"May only highlight if editor is locked");
		}

		IGraphicalEditPart editPart = getEditPartForSemanticElement(semanticElement);
		Assert.isNotNull(editPart, "Could not find a matching edit part");
		IFigure figure = getTargetFigure(editPart);
		Assert.isNotNull(figure, "Could not obtain target figure");
		Display.getCurrent()
				.asyncExec(
						new Fader(
								figure,
								parameters.foregroundFadingColor,
								getGreyscaled(figureStates.get(figure).foregroundColor),
								parameters.backgroundFadingColor,
								getGreyscaled(figureStates.get(figure).backgroundColor),
								(int) parameters.fadingTime, false));
	}

	@SuppressWarnings("unchecked")
	private IGraphicalEditPart findEditPartForSemanticElement(
			EditPart editPart, EObject semanticElement) {
		if (editPart instanceof IGraphicalEditPart) {
			EObject resolveSemanticElement = ((IGraphicalEditPart) editPart)
					.resolveSemanticElement();

			if (EcoreUtil.equals(resolveSemanticElement, semanticElement)) {
				return (IGraphicalEditPart) editPart;
			}
		}

		for (Object child : editPart.getChildren()) {
			IGraphicalEditPart recursiveEditPart = findEditPartForSemanticElement(
					(EditPart) child, semanticElement);
			if (recursiveEditPart != null) {
				return recursiveEditPart;
			}
		}

		if (editPart instanceof NodeEditPart) {
			List<Connection> connections = new ArrayList<Connection>();
			connections
					.addAll(((NodeEditPart) editPart).getSourceConnections());
			connections
					.addAll(((NodeEditPart) editPart).getTargetConnections());
			for (Object connection : connections) {
				EObject resolveSemanticElement = ((IGraphicalEditPart) connection)
						.resolveSemanticElement();
				if (EcoreUtil.equals(resolveSemanticElement, semanticElement)) {
					return (IGraphicalEditPart) connection;
				}
			}
		}
		return null;
	}

	public synchronized void flash(final EObject semanticElement,
			final HighlightingParameters parameters) {
		if (!locked) {
			throw new IllegalStateException(
					"May only highlight if editor is locked");
		}
		final IGraphicalEditPart editPart = getEditPartForSemanticElement(semanticElement);
		Assert.isNotNull(editPart, "Could not find a matching edit part");

		// ensure the edit part is made visible.
		diagramWorkbenchPart.getDiagramGraphicalViewer().reveal(editPart);

		final IFigure figure = editPart.getFigure();
		Display.getCurrent().asyncExec(
				new Fader(figure, figure.getForegroundColor(),
						parameters.foregroundFadingColor, figure
								.getBackgroundColor(),
						parameters.backgroundFadingColor,
						(int) parameters.fadingTime, true));
	}

	private IGraphicalEditPart getEditPartForSemanticElement(
			EObject semanticElement) {
		return findEditPartForSemanticElement(diagramWorkbenchPart
				.getDiagramGraphicalViewer().getRootEditPart(), semanticElement);
	}

	private Color getGreyscaled(Color color) {
		// check cache (if color has already be computed)
		if (greyscaleColors.containsKey(color)) {
			return greyscaleColors.get(color);
		}

		// use image to convert colors to greyscale
		ImageData imageData = new ImageData(1, 1, 24, new PaletteData(0xFF,
				0xFF00, 0xFF0000));
		imageData.setPixel(0, 0, imageData.palette.getPixel(color.getRGB()));
		Image image = new Image(Display.getCurrent(), imageData);
		Image convertedImage = new Image(Display.getCurrent(), image,
				SWT.IMAGE_DISABLE);
		Color newColor = new Color(Display.getCurrent(),
				convertedImage.getImageData().palette.getRGB(convertedImage
						.getImageData().getPixel(0, 0)));
		greyscaleColors.put(color, newColor);
		convertedImage.dispose();
		image.dispose();
		return newColor;
	}

	private IFigure getTargetFigure(IGraphicalEditPart editPart) {
		IFigure figure = editPart.getFigure();
		if (figure instanceof BorderedNodeFigure) {
			figure = (IFigure) figure.getChildren().get(0);
		}
		if (figure instanceof DefaultSizeNodeFigure) {
			figure = (IFigure) figure.getChildren().get(0);
		}
		return figure;
	}

	public synchronized void lockEditor() {
		if (locked) {
			throw new IllegalStateException("Editor already locked!");
		}

		setSanityCheckEnablementState(false);
		diagramWorkbenchPart.getDiagramEditPart().disableEditMode();

		for (Object editPart : diagramWorkbenchPart.getDiagramGraphicalViewer()
				.getEditPartRegistry().values()) {
			if (editPart instanceof IGraphicalEditPart) {
				IGraphicalEditPart graphicalEditPart = (IGraphicalEditPart) editPart;
				IFigure figure = getTargetFigure(graphicalEditPart);
				figureStates.put(figure, new ColorMemento(figure));
			}
		}

		// greyscale figures after all colors have been stored
		for (IFigure figure : figureStates.keySet()) {
			// calculate fore and background colors as greyscaled
			if (figure.getLocalForegroundColor() != null) {
				figure.setForegroundColor(getGreyscaled(figure
						.getForegroundColor()));
			}
			if (figure.getLocalBackgroundColor() != null) {
				figure.setBackgroundColor(getGreyscaled(figure
						.getBackgroundColor()));
			}
		}

		locked = true;
	}

	private void setSanityCheckEnablementState(boolean state) {
		try {
			Method enableMethod = DiagramDocumentEditor.class
					.getDeclaredMethod("enableSanityChecking",
							new Class[] { boolean.class });
			enableMethod.setAccessible(true);
			enableMethod.invoke(diagramWorkbenchPart, new Object[] { state });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void releaseEditor() {
		if (!locked) {
			throw new IllegalStateException("Editor not locked!");
		}

		// restore all elements still being highlighted
		for (ColorMemento figureState : figureStates.values()) {
			figureState.restore();
		}
		figureStates.clear();

		for (Color color : greyscaleColors.values()) {
			color.dispose();
		}
		greyscaleColors.clear();

		diagramWorkbenchPart.getDiagramEditPart().enableEditMode();
		setSanityCheckEnablementState(true);

		locked = false;
	}

}