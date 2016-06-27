/**
 * Copyright (c) 2016 committers of YAKINDU and others.
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IEditorPart;
import org.yakindu.base.gmf.runtime.decorators.AbstractDecoratorProvider;
import org.yakindu.base.gmf.runtime.decorators.BaseDecorator;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.editor.figures.PriorityFigure;
import org.yakindu.sct.ui.editor.editparts.TransitionEditPart;
import org.yakindu.sct.ui.editor.preferences.StatechartPreferenceConstants;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TransitionPriorityDecorationProvider extends AbstractDecoratorProvider implements IPropertyChangeListener {

	private static final String PRIORITY_ID = TransitionPriorityDecorationProvider.class.getSimpleName();
	private List<IDecorator> decorators;

	public TransitionPriorityDecorationProvider() {
		decorators = new ArrayList<>();
		DiagramActivator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	@Override
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart) decoratorTarget.getAdapter(EditPart.class);
		if (editPart instanceof GraphicalEditPart || editPart instanceof AbstractConnectionEditPart) {
			EditDomain ed = editPart.getViewer().getEditDomain();
			if (!(ed instanceof DiagramEditDomain)) {
				return;
			}
			if (shouldInstall(((DiagramEditDomain) ed).getEditorPart()) && editPart instanceof TransitionEditPart) {
				IDecorator decorator = createStatusDecorator(decoratorTarget);
				decorators.add(decorator);
				decoratorTarget.installDecorator(getDecoratorKey(), decorator);
			}
		}
	}

	protected IDecorator createStatusDecorator(IDecoratorTarget decoratorTarget) {
		return new PriorityDecorator(decoratorTarget);
	}

	protected Object getDecoratorKey() {
		return PRIORITY_ID;
	}

	protected boolean shouldInstall(IEditorPart editorPart) {
		return (editorPart instanceof StatechartDiagramEditor);
	}

	public static class PriorityDecorator extends BaseDecorator {

		public PriorityDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}

		protected NotificationListener transitionPriorityChangeListener = new NotificationListener() {

			public void notifyChanged(Notification notification) {
				if (notification.getFeatureID(State.class) == SGraphPackage.STATE__OUTGOING_TRANSITIONS)
					refresh();
			}
		};

		@Override
		public void activate() {
			super.activate();
			// priorities will be changed via reordering the list of transitions
			// within the owning element
			Vertex owningElement = (Vertex) ((Transition) semanticElement).eContainer();
			DiagramEventBroker.getInstance(gep.getEditingDomain()).addNotificationListener(owningElement,
					transitionPriorityChangeListener);
		}

		@Override
		public void deactivate() {
			Vertex owningElement = (Vertex) ((Transition) semanticElement).eContainer();
			DiagramEventBroker.getInstance(gep.getEditingDomain()).removeNotificationListener(owningElement,
					transitionPriorityChangeListener);
			super.deactivate();
		}

		@Override
		public void refresh() {
			removeDecoration();
			boolean showLabels = DiagramActivator.getDefault().getPreferenceStore()
					.getBoolean(StatechartPreferenceConstants.PREF_PRIORITY_LABELS);
			if (!showLabels)
				return;
			View view = (View) getDecoratorTarget().getAdapter(View.class);
			if (view == null || view.eResource() == null) {
				return;
			}
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
			if (editPart == null || editPart.getViewer() == null) {
				return;
			}
			if (editPart instanceof TransitionEditPart && (needsDecoration((TransitionEditPart) editPart)))
				createDecorators((TransitionEditPart) editPart);
		}

		public boolean needsDecoration(TransitionEditPart editPart) {
			Transition transition = (Transition) editPart.resolveSemanticElement();
			Vertex container = (Vertex) transition.eContainer();
			return container.getOutgoingTransitions().size() > 1;

		}

		public void createDecorators(TransitionEditPart editPart) {
			PriorityFigure figure = new PriorityFigure(MapModeUtil.getMapMode(), getPriority(editPart));
			figure.setSize(10, 10);
			setDecoration(getDecoratorTarget().addConnectionDecoration(figure, 5, false));
		}

		public int getPriority(TransitionEditPart editPart) {
			Transition transition = ((Transition) editPart.resolveSemanticElement());
			Vertex container = (Vertex) transition.eContainer();
			int indexOf = container.getOutgoingTransitions().indexOf(transition);
			// visible priorities should start with 1
			return indexOf + 1;
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (StatechartPreferenceConstants.PREF_PRIORITY_LABELS.equals(event.getProperty())) {
			for (IDecorator decorator : decorators) {
				decorator.refresh();
			}
		}
	}
}
