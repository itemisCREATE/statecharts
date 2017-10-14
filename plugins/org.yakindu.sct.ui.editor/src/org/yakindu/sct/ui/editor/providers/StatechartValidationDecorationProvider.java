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
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.Issue.IssueImpl;
import org.yakindu.base.gmf.runtime.decorators.AbstractDecoratorProvider;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Pseudostate;
import org.yakindu.sct.model.sgraph.ui.validation.SCTIssue;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.editparts.BorderItemEditPart;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;
import org.yakindu.sct.ui.editor.validation.IValidationIssueStore;
import org.yakindu.sct.ui.editor.validation.IValidationIssueStore.IValidationIssueStoreListener;

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
		if (editPart instanceof BorderItemEditPart)
			return;
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
		// This is required for OffscreenEditPartFactory to render problem markers into
		// the preview image
		if (part == null)
			return true;
		return false;
	}

	protected String getDecoratorKey() {
		return KEY;
	}

	protected ValidationDecorator createStatusDecorator(IDecoratorTarget decoratorTarget, IValidationIssueStore store) {
		return new ValidationDecorator(decoratorTarget, store);
	}

	public static class ValidationDecorator extends AbstractDecorator implements IValidationIssueStoreListener {

		private static final String SUB_DIAGRAM_ERRORS = "The subdiagram contains errors.";
		private IValidationIssueStore store;
		private String semanticID;

		public ValidationDecorator(IDecoratorTarget decoratorTarget, IValidationIssueStore store) {
			super(decoratorTarget);
			this.store = store;
		}

		public void refresh() {
			EObject element = getTargetEObject();
			if (element == null) {
				return;
			}
			if (element != null)
				semanticID = element.eResource().getURIFragment(element);
			removeDecoration();
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
			if (editPart == null || editPart.getViewer() == null || !(editPart instanceof IPrimaryEditPart)) {
				return;
			}
			decorate(getTargetView());
		}

		protected EObject getTargetEObject() {
			View view = getTargetView();
			return view.getElement();
		}

		private View getTargetView() {
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if (view == null || view.eResource() == null) {
				return null;
			}
			return view;
		}

		public void activate() {
			store.addIssueStoreListener(this);
		}

		public void deactivate() {
			store.removeIssueStoreListener(this);
			super.deactivate();
		}

		protected void decorate(View view) {
			List<SCTIssue> issues = store.getIssues(semanticID);
			SCTIssue subDiagramIssue = getSubDiagramIssue(view);
			if (subDiagramIssue != null)
				issues.add(subDiagramIssue);
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
						IDecoratorTarget.Direction.NORTH_EAST, margin, false));
				getDecoration().setToolTip(toolTip);
			}
		}

		protected SCTIssue getSubDiagramIssue(View view) {
			if (SemanticHints.STATE.equals(view.getType())) {
				BooleanValueStyle style = GMFNotationUtil.getBooleanValueStyle(view,
						DiagramPartitioningUtil.INLINE_STYLE);
				if (style == null ? false : !style.isBooleanValue()) {
					EObject element = view.getElement();
					TreeIterator<EObject> eAllContents = element.eAllContents();
					while (eAllContents.hasNext()) {
						EObject next = eAllContents.next();
						String semanticURI = getSemanticURI(next);
						List<SCTIssue> issues = store.getIssues(semanticURI);
						for (final SCTIssue issue : issues) {
							if (Severity.ERROR.equals(issue.getSeverity())) {
								IssueImpl result = new Issue.IssueImpl();
								result.setMessage(SUB_DIAGRAM_ERRORS);
								result.setSeverity(Severity.ERROR);
								return new SCTIssue(result, issue.getSemanticURI());
							}
						}
					}
				}
			}
			return null;
		}

		private String getSemanticURI(EObject next) {
			return EcoreUtil.getURI(next).fragment();
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
		public Stream<String> getSemanticURIsStream() {

			EObject element = getTargetEObject();
			if (element == null) {
				return null;
			}

			View view = getTargetView();
			if (SemanticHints.STATE.equals(view.getType())) {
				BooleanValueStyle style = GMFNotationUtil.getBooleanValueStyle(view,
						DiagramPartitioningUtil.INLINE_STYLE);
				if (style == null ? false : !style.isBooleanValue()) {
					Stream<String> stream = StreamSupport.stream(() -> {
						return Spliterators.spliteratorUnknownSize(element.eAllContents(), Spliterator.CONCURRENT);
					}, Characteristics.CONCURRENT.ordinal(), true).map(e -> getSemanticURI(e));
					return Stream.concat(Stream.of(semanticID), stream);
				}
			}

			return Stream.of(semanticID);
		}

	}
}
