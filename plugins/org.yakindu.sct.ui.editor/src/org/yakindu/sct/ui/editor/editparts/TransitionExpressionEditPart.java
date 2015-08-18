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
package org.yakindu.sct.ui.editor.editparts;

import static org.yakindu.base.base.BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION;
import static org.yakindu.sct.model.sgraph.SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Handle;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableLabelEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.xtext.utils.gmf.directedit.IXtextAwareEditPart;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.ui.editor.commands.ToggleShowDocumentationCommand;
import org.yakindu.sct.ui.editor.editparts.SpecificationElementEditPart.MultilineTextCellEditor;
import org.yakindu.sct.ui.editor.policies.ContextSensitiveHelpPolicy;
import org.yakindu.sct.ui.editor.policies.TransitionExpressionComponentEditPolicy;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;
import org.yakindu.sct.ui.editor.utils.HelpContextIds;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TransitionExpressionEditPart extends PlugableExternalXtextLabelEditPart implements IXtextAwareEditPart {

	public TransitionExpressionEditPart(View view) {
		super(view, Transition.class.getName());
	}

	@Override
	protected DirectEditManager createDirectEditManager() {
		if (getAttribute() == BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION)
			return new TextDirectEditManager(this, MultilineTextCellEditor.class,
					TextDirectEditManager.getTextCellEditorLocator(this));
		return super.createDirectEditManager();
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new TransitionExpressionComponentEditPolicy());
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new ContextSensitiveHelpPolicy(
				HelpContextIds.SC_PROPERTIES_TRANSITION_EXPRESSION));
		// BUGFIX:
		// https://code.google.com/a/eclipselabs.org/p/yakindu/issues/detail?id=26
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new NonResizableLabelEditPolicy() {
			@Override
			protected void replaceHandleDragEditPartsTracker(Handle handle) {
				if (handle instanceof AbstractHandle) {
					AbstractHandle h = (AbstractHandle) handle;
					h.setDragTracker(new DragEditPartsTrackerEx(getHost()) {
						protected boolean isMove() {
							return true;
						};
					});
				}
			}
		});
	}

	@Override
	protected int getEditorStyles() {
		return SWT.MULTI;
	}

	@Override
	public Transition resolveSemanticElement() {
		return (Transition) super.resolveSemanticElement();
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		updateTooltip();
	}

	protected void updateTooltip() {
		String documentation = (String) resolveSemanticElement().eGet(DOCUMENTED_ELEMENT__DOCUMENTATION);
		if (getAttribute() == DOCUMENTED_ELEMENT__DOCUMENTATION)
			documentation = (String) resolveSemanticElement().eGet(SPECIFICATION_ELEMENT__SPECIFICATION);
		if (documentation != null && !documentation.isEmpty())
			getFigure().setToolTip(new Label(documentation));
	}

	public EAttribute getAttribute() {
		StringValueStyle featureStyle = GMFNotationUtil.getStringValueStyle(getPrimaryView(),
				ToggleShowDocumentationCommand.FEATURE_TO_SHOW);
		if (featureStyle == null) {
			return SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION;
		}
		String feature = featureStyle.getStringValue();
		if (feature.equals(BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION.getName())) {
			return BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION;
		}
		return SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION;
	}
}
