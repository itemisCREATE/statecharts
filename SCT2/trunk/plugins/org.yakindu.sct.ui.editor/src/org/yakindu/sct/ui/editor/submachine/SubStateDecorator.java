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
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.render.util.DiagramRenderUtil;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.graphics.Image;
import org.yakindu.sct.model.sgraph.State;

import de.itemis.gmf.runtime.commons.decorators.InteractiveDecorator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class SubStateDecorator extends InteractiveDecorator {

	public SubStateDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}

	protected abstract boolean shouldDecorate(State state);

	@Override
	public boolean shouldDecorate(EObject element) {
		return (element instanceof State) ? shouldDecorate((State) element) : false;
	}

	protected abstract Image getDecorationImage(State state);

	@Override
	public Image getDecorationImage(EObject element) {
		return (element instanceof State) ? getDecorationImage((State) element) : null;
	}

	protected abstract Diagram getTooltipDiagramToRender(State state);

	@Override
	protected IFigure getToolTipFigure(EObject element) {
		if (element instanceof State) {
			Diagram diagram = getTooltipDiagramToRender((State) element);
			if (diagram != null) {
				Image renderImage = renderImage(diagram);
				return new ImageFigure(renderImage);

			}
		}
		return null;
	}

	protected Image renderImage(Diagram diagram) {
		Assert.isNotNull(diagram);
		Image renderImage = DiagramRenderUtil.renderToSWTImage(diagram);
		Image resize = resize(renderImage, (int) (0.7071 * renderImage.getBounds().width),
				(int) (0.7071 * renderImage.getBounds().height));
		return resize;
	}

}
