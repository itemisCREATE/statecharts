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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.BasicNotifierImpl.EAdapterList;
import org.eclipse.emf.common.notify.impl.BasicNotifierImpl.EObservableAdapterList.Listener;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
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
import org.yakindu.base.gmf.runtime.decorators.AbstractMarkerBasedDecorationProvider;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Pseudostate;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.validation.LiveValidationIssueProcessor.IssueAdapter;

public class StatechartValidationDecorationProvider extends AbstractMarkerBasedDecorationProvider
		implements IDecoratorProvider {

	private static final String KEY = "org.yakindu.sct.ui.editor.validation";

	protected boolean shouldInstall(IEditorPart part) {
		return part instanceof StatechartDiagramEditor;
	}

	protected String getDecoratorKey() {
		return KEY;
	}

	protected ValidationDecorator createStatusDecorator(IDecoratorTarget decoratorTarget) {
		return new ValidationDecorator(decoratorTarget);
	}

	public class ValidationDecorator extends AbstractDecorator implements Listener {

		private String viewId;

		public ValidationDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
			try {
				final View view = (View) getDecoratorTarget().getAdapter(View.class);
				TransactionUtil.getEditingDomain(view).runExclusive(new Runnable() {
					public void run() {
						ValidationDecorator.this.viewId = view != null ? ViewUtil.getIdStr(view) : null;
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void refresh() {
			removeDecoration();
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if (view == null || view.eResource() == null) {
				return;
			}
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
			if (editPart == null || editPart.getViewer() == null || !(editPart instanceof IPrimaryEditPart)) {
				return;
			}
			decorate(view);
		}

		public void activate() {
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if (view == null || view.eResource() == null) {
				return;
			}
			// add self to global decorators registry
			List<IDecorator> list = allDecorators.get(viewId);
			if (list == null) {
				list = new ArrayList<IDecorator>(2);
				list.add(this);
				allDecorators.put(viewId, list);
			} else if (!list.contains(this)) {
				list.add(this);
			}
			EAdapterList<?> adapterList = (EAdapterList<?>) view.getElement().eAdapters();
			adapterList.addListener(this);
		}

		public void deactivate() {
			if (viewId == null) {
				return;
			}
			List<IDecorator> list = allDecorators.get(viewId);
			if (list != null) {
				list.remove(this);
				if (list.isEmpty()) {
					allDecorators.remove(viewId);
				}
			}
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if (view == null || view.eResource() == null) {
				return;
			}
			EAdapterList<?> adapterList = (EAdapterList<?>) view.getElement().eAdapters();
			adapterList.removeListener(this);
			super.deactivate();
		}

		protected void decorate(View view) {
			String elementId = ViewUtil.getIdStr(view);
			if (elementId == null) {
				return;
			}

			IssueAdapter existingAdapter = (IssueAdapter) EcoreUtil.getExistingAdapter(view.getElement(),
					IssueAdapter.class);
			if (existingAdapter == null)
				return;
			Severity severity = Severity.INFO;
			Label toolTip = null;
			List<Issue> issues = existingAdapter.getIssues();
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
		public void added(Notifier notifier, Adapter adapter) {
			refresh();
		}

		@Override
		public void removed(Notifier notifier, Adapter adapter) {
			refresh();
		}
	}
}
