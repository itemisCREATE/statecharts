package de.itemis.gmf.runtime.commons.decorators;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.Decoration;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget.Direction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * @author terfloth - Initial contribution
 * 
 * TODO: extract margin property
 *
 */
public abstract class InteractiveDecorator extends BaseDecorator {

	public InteractiveDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}

	protected abstract Direction getDecoratorPosition();

	public void refresh() {
		removeDecoration();
		if (getDecoratorTarget().getAdapter(EditPart.class) instanceof IPrimaryEditPart) {
			final EObject semanticElement = (EObject) getDecoratorTarget()
					.getAdapter(EObject.class);
			if (shouldDecorate(semanticElement)) {
				final Decoration decoration = (Decoration) getDecoratorTarget()
						.addShapeDecoration(getDecorationImage(semanticElement),
								getDecoratorPosition(), -5, false);
				renderToolTip(decoration, semanticElement);
				decoration.addMouseListener(new MouseListener() {
					public void mousePressed(MouseEvent me) {
						InteractiveDecorator.this.mousePressed(decoration, semanticElement);
					}
	
					public void mouseReleased(MouseEvent me) {
						InteractiveDecorator.this.mouseReleased(decoration, semanticElement);
					}
	
					
					public void mouseDoubleClicked(MouseEvent me) {
						InteractiveDecorator.this.mouseDoubleClicked(decoration, semanticElement);
					}
				});
				setDecoration(decoration);
			}
		}
	}

	/**
	 * TODO: move to UtilityClass
	 * 
	 * This method disposes the input image and returns a new Image.
	 * 
	 * @param image
	 * @param width
	 * @param height
	 * @return
	 */
	protected Image resize(Image image, int width, int height) {
		Image scaled = new Image(image.getDevice(), width, height);
		GC gc = new GC(scaled);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(image, 0, 0, image.getBounds().width,
				image.getBounds().height, 0, 0, width, height);
		gc.dispose();
		image.dispose();
		return scaled;
	}

	protected void renderToolTip(final Decoration decoration, final EObject semanticElement) {
		decoration.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent me) {
			}
	
			public void mouseEntered(MouseEvent me) {
				IFigure toolTip = getToolTipFigure(semanticElement);
				if (toolTip != null) decoration.setToolTip(toolTip);
	
			}
	
			public void mouseExited(MouseEvent me) {
			}
	
			public void mouseHover(MouseEvent me) {
			}
	
			public void mouseMoved(MouseEvent me) {
			}
		});
	}

	protected abstract IFigure getToolTipFigure(EObject element);

	protected abstract Image getDecorationImage(EObject element);

	protected abstract boolean shouldDecorate(EObject element);

	protected void mousePressed(Decoration decoration, EObject element) {
	}
	
	protected void mouseReleased(Decoration decoration, EObject element) {
	}
	
	protected void mouseDoubleClicked(Decoration decoration, EObject element) {
	}
	
	
}
