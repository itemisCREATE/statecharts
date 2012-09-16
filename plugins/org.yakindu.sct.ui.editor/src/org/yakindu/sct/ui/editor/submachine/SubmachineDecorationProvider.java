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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.Decoration;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget.Direction;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.StatechartImages;
import org.yakindu.sct.ui.editor.utils.InteractionUtil;

import de.itemis.gmf.runtime.commons.decorators.AbstractDecoratorProvider;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SubmachineDecorationProvider extends AbstractDecoratorProvider
		implements IDecoratorProvider {

	private static final String DECORATOR_KEY = SubmachineDecorator.class
			.getSimpleName();

	public void createDecorators(IDecoratorTarget decoratorTarget) {
		Object adapter = decoratorTarget.getAdapter(EObject.class);
		if (adapter instanceof State)
			decoratorTarget.installDecorator(DECORATOR_KEY,
					new SubmachineDecorator(decoratorTarget));
	}

	public static class SubmachineDecorator extends SubStateDecorator {

		public SubmachineDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}

		@Override
		protected boolean shouldDecorate(State state) {
			return state.getSubstatechart() != null;
		}

		@Override
		protected Image getDecorationImage(State state) {
			return StatechartImages.SUB_STATECHART_PICTOGRAM.image();
		}

		@Override
		protected Diagram getTooltipDiagramToRender(State state) {
			Statechart substatechart = state.getSubstatechart();
			if (substatechart == null) {
				return null;
			}
			Resource eResource = substatechart.eResource();
			if (eResource == null) {
				return null;
			}
			EList<EObject> contents = eResource.getContents();
			if (contents == null) {
				return null;
			}
			return (Diagram) EcoreUtil2.getObjectByType(contents,
					NotationPackage.Literals.DIAGRAM);
		}

		@Override
		protected void mousePressed(Decoration decoration, EObject semanticElement) {
			InteractionUtil.openElement(((State)semanticElement).getSubstatechart());
		}

		@Override
		protected Direction getDecoratorPosition() {
			return IDecoratorTarget.Direction.SOUTH_EAST;
		}

		
		State asState(EObject o) {
			return (o instanceof State) ? (State)o : null;
		}

	}

}
