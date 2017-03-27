/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.providers;

import java.util.List;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.base.gmf.runtime.decorators.AbstractDecoratorProvider;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Pseudostate;
import org.yakindu.sct.model.sgraph.ui.validation.SCTIssue;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.validation.IValidationIssueStore;
import org.yakindu.sct.ui.editor.validation.IValidationIssueStore.IResourceIssueStoreListener;

/**
 * 
 * @author Andreas Muelder - Initial contribution and API
 *
 */
public class StatechartValidationDecorationProvider extends AbstractDecoratorProvider implements IDecoratorProvider {

	private static final String KEY = "org.yakindu.sct.ui.editor.validation";

	private IValidationIssueStore issueStore;

	public void createDecorators(IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart) decoratorTarget.getAdapter(EditPart.class);
		if (editPart instanceof IPrimaryEditPart
				&& (editPart instanceof GraphicalEditPart || editPart instanceof AbstractConnectionEditPart)) {
			EditDomain ed = editPart.getViewer().getEditDomain();
			if (!(ed instanceof DiagramEditDomain)) {
				return;
			}
			if (shouldInstall(((DiagramEditDomain) ed).getEditorPart())) {
				decoratorTarget.installDecorator(getDecoratorKey(), createStatusDecorator(decoratorTarget, issueStore));
			}
		}
	}

	protected boolean shouldInstall(IEditorPart part) {
		if (part instanceof StatechartDiagramEditor) {
			issueStore = (IValidationIssueStore) part.getAdapter(IValidationIssueStore.class);
			return true;
		}
		return false;
	}

	protected String getDecoratorKey() {
		return KEY;
	}

	protected ValidationDecorator createStatusDecorator(IDecoratorTarget decoratorTarget, IValidationIssueStore store) {
		return new ValidationDecorator(decoratorTarget, store);
	}

	public static class ValidationDecorator extends AbstractDecorator implements IResourceIssueStoreListener {

		private IValidationIssueStore store;
		private String semanticID;

		public ValidationDecorator(IDecoratorTarget decoratorTarget, IValidationIssueStore store) {
			super(decoratorTarget);
			this.store = store;
		}

		public void refresh() {
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if (view == null || view.eResource() == null) {
				return;
			}
			EObject element = view.getElement();
			if (element != null)
				semanticID = element.eResource().getURIFragment(element);
			removeDecoration();
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
			if (editPart == null || editPart.getViewer() == null || !(editPart instanceof IPrimaryEditPart)) {
				return;
			}
			decorate(view);
		}

		public void activate() {
			store.addIssueStoreListener(this);
		}

		public void deactivate() {
			super.deactivate();
		}

		protected void decorate(View view) {
			List<SCTIssue> issues = store.getIssues(semanticID);
			Severity severity = Severity.INFO;
			Label toolTip = null;
			if (issues.isEmpty())
				return;
			for (int i = 0; i < issues.size(); i++) {
				Issue issue = issues.get(i);
				Severity nextSeverity = issue.getSeverity();
				Image nextImage = getImage(nextSeverity);
				if (toolTip == null) {
					toolTip = new Label(issue.getMessage(), nextImage);
				} else {
					if (toolTip.getChildren().isEmpty()) {
						Label comositeLabel = new Label();
						FlowLayout fl = new FlowLayout(false);
						fl.setMinorSpacing(0);
						comositeLabel.setLayoutManager(fl);
						comositeLabel.add(toolTip);
						toolTip = comositeLabel;
					}
					toolTip.add(new Label(issue.getMessage(), nextImage));
				}
				severity = (nextSeverity.ordinal() < severity.ordinal()) ? nextSeverity : severity;
			}

			if (view instanceof Edge) {
				setDecoration(getDecoratorTarget().addConnectionDecoration(getImage(severity), 50, true));
				getDecoration().setToolTip(toolTip);
			} else {
				int margin = view.getElement() instanceof Pseudostate || view.getElement() instanceof FinalState ? 0
						: -1;
				setDecoration(getDecoratorTarget().addShapeDecoration(getImage(severity),
						IDecoratorTarget.Direction.NORTH_EAST, margin, true));
				getDecoration().setToolTip(toolTip);
			}
		}

		protected Image getImage(Severity severity) {
			String imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
			switch (severity) {
			case ERROR:
				imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
				break;
			case WARNING:
				imageName = ISharedImages.IMG_OBJS_WARN_TSK;
				break;
			default:
				imageName = ISharedImages.IMG_OBJS_INFO_TSK;
			}
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageName);
		}

		@Override
		public void issuesChanged() {
			refresh();
		}

		@Override
		public String getSemanticURI() {
			return semanticID;
		}
	}
}
