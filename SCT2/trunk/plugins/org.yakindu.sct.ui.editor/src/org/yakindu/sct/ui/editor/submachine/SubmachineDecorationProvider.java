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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.Decoration;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget.Direction;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.StatechartImages;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;

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

	// TODO: Move to common class
	private static final String INLINE_STYLE = "isInline";

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
			IGraphicalEditPart adapter = (IGraphicalEditPart) getDecoratorTarget()
					.getAdapter(IGraphicalEditPart.class);
			BooleanValueStyle style = GMFNotationUtil.getBooleanValueStyle(
					adapter.getNotationView(), INLINE_STYLE);
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
			Collection<Diagram> diagrams = EcoreUtil2.getObjectsByType(state
					.eResource().getContents(),
					NotationPackage.Literals.DIAGRAM);
			for (Diagram diagram : diagrams) {
				if (EcoreUtil.equals(diagram.getElement(), state)) {
					return diagram;
				}
			}
			return null;
		}

		@Override
		protected void mousePressed(Decoration decoration,
				EObject semanticElement) {
			Diagram diagramToOpen = getDiagramForSemanticElement(semanticElement);
			URI uri = EcoreUtil.getURI(diagramToOpen);
			IFile file = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(new Path(uri.toPlatformString(true)));
			try {
				IEditorDescriptor desc = PlatformUI.getWorkbench()
						.getEditorRegistry().getDefaultEditor(file.getName());

				final IWorkbenchPage wbPage = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				wbPage.openEditor(new DiagramEditorInput(diagramToOpen),
						desc.getId());
			} catch (PartInitException e) {
				e.printStackTrace();
			}

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
