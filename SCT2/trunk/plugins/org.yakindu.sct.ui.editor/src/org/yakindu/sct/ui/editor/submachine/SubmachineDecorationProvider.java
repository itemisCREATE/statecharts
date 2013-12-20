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

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.Decoration;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget.Direction;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.StatechartImages;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;

import de.itemis.gmf.runtime.commons.decorators.AbstractDecoratorProvider;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SubmachineDecorationProvider extends AbstractDecoratorProvider implements IDecoratorProvider {

	protected static final String DECORATOR_KEY = SubmachineDecorator.class.getSimpleName();

	public void createDecorators(IDecoratorTarget decoratorTarget) {
		Object adapter = decoratorTarget.getAdapter(EObject.class);
		if (adapter instanceof State)
			decoratorTarget.installDecorator(DECORATOR_KEY, new SubmachineDecorator(decoratorTarget));
	}

	public static class SubmachineDecorator extends SubStateDecorator {

		public SubmachineDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}

		@Override
		protected boolean shouldDecorate(State state) {
			IGraphicalEditPart adapter = (IGraphicalEditPart) getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
			BooleanValueStyle style = GMFNotationUtil.getBooleanValueStyle(adapter.getNotationView(),
					DiagramPartitioningUtil.INLINE_STYLE);
			return style == null ? false : !style.isBooleanValue();
		}

		@Override
		protected Image getDecorationImage(State state) {
			return StatechartImages.SUB_STATECHART_PICTOGRAM.image();
		}

		@Override
		protected Diagram getTooltipDiagramToRender(State state) {
			return getDiagramForSemanticElement(state);
		}

		private Diagram getDiagramForSemanticElement(EObject state) {
			Collection<Diagram> diagrams = EcoreUtil2.getObjectsByType(state.eResource().getContents(),
					NotationPackage.Literals.DIAGRAM);
			for (Diagram diagram : diagrams) {
				if (EcoreUtil.equals(diagram.getElement(), state)) {
					return diagram;
				}
			}
			return null;
		}

		@Override
		protected void mousePressed(Decoration decoration, EObject semanticElement) {
			Diagram diagramToOpen = getDiagramForSemanticElement(semanticElement);
			DiagramPartitioningUtil.openEditor(diagramToOpen);

		}

		@Override
		protected Direction getDecoratorPosition() {
			return IDecoratorTarget.Direction.SOUTH_EAST;
		}

		State asState(EObject o) {
			return (o instanceof State) ? (State) o : null;
		}

	}

}
