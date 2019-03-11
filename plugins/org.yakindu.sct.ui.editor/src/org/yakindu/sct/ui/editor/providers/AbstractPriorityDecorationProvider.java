/**
 * Copyright (c) 2018 committers of YAKINDU and others.
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IEditorPart;
import org.yakindu.base.gmf.runtime.decorators.AbstractDecoratorProvider;
import org.yakindu.base.gmf.runtime.decorators.BaseDecorator;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.preferences.StatechartPreferenceConstants;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractPriorityDecorationProvider extends AbstractDecoratorProvider
		implements IPropertyChangeListener {

	protected static final String PRIORITY_ID = AbstractPriorityDecorationProvider.class.getSimpleName();
	protected List<IDecorator> decorators;

	public AbstractPriorityDecorationProvider() {
		decorators = new ArrayList<>();
		DiagramActivator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	protected Object getDecoratorKey() {
		return PRIORITY_ID;
	}

	protected boolean shouldInstall(IEditorPart editorPart) {
		return (editorPart == null) || (editorPart instanceof StatechartDiagramEditor);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (StatechartPreferenceConstants.PREF_PRIORITY_LABELS.equals(event.getProperty())
				|| StatechartPreferenceConstants.PREF_FONT_SCALING.equals(event.getProperty())) {
			for (IDecorator decorator : decorators) {
				decorator.refresh();
			}
		}
	}

	public abstract static class AbstractPriorityDecorator extends BaseDecorator {

		public abstract int getPriority(IGraphicalEditPart editPart);

		public abstract boolean needsDecoration(IGraphicalEditPart editPart);

		public abstract void createDecorators(IGraphicalEditPart editPart);

		protected EObject owningElement;

		private EReference owningReference;

		public AbstractPriorityDecorator(IDecoratorTarget decoratorTarget, EReference owningReference) {
			super(decoratorTarget);
			this.owningReference = owningReference;
		}

		protected NotificationListener prioChangedListener = new NotificationListener() {

			public void notifyChanged(Notification notification) {
				if (notification.getFeature() == owningReference)
					refresh();
			}
		};

		@Override
		public void activate() {
			super.activate();
			if (owningElement != null) {
				DiagramEventBroker.getInstance(gep.getEditingDomain()).addNotificationListener(owningElement,
						prioChangedListener);
			}
		}

		@Override
		public void deactivate() {
			if (owningElement != null) {
				DiagramEventBroker.getInstance(gep.getEditingDomain()).removeNotificationListener(owningElement,
						prioChangedListener);
			}
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
			IGraphicalEditPart editPart = (IGraphicalEditPart) getDecoratorTarget().getAdapter(EditPart.class);
			if (editPart == null || editPart.getViewer() == null) {
				return;
			}
			if (needsDecoration(editPart))
				createDecorators(editPart);
		}

	}

}
