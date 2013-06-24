/**
 * Copyright (c) 2013 committers of YAKINDU and others.
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
import static org.yakindu.sct.ui.editor.commands.ToggleShowDocumentationCommand.FEATURE_TO_SHOW;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.gef.ui.internal.parts.TextCellEditorEx;
import org.eclipse.gmf.runtime.gef.ui.internal.parts.WrapTextCellEditor;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public abstract class SpecificationElementEditPart extends PlugableXtextLabelEditPart {

	/**
	 * Initially copied from {@link WrapTextCellEditor}, removed
	 * keyReleaseOccured
	 * 
	 */
	public static final class MultilineTextCellEditor extends TextCellEditorEx {

		private static final int defaultStyle = SWT.WRAP | SWT.MULTI;

		public MultilineTextCellEditor() {
			setStyle(defaultStyle);
		}

		public MultilineTextCellEditor(Composite parent) {
			this(parent, defaultStyle);
		}

		public MultilineTextCellEditor(Composite parent, int style) {
			super(parent, style);
		}
	}

	public SpecificationElementEditPart(View view, SemanticTarget target) {
		super(view, target);
	}

	@Override
	protected DirectEditManager createDirectEditManager() {
		if (getAttribute() == DOCUMENTED_ELEMENT__DOCUMENTATION)
			return new TextDirectEditManager(this, MultilineTextCellEditor.class,
					TextDirectEditManager.getTextCellEditorLocator(this));
		return super.createDirectEditManager();
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
		StringValueStyle featureStyle = GMFNotationUtil.getStringValueStyle(getPrimaryView(), FEATURE_TO_SHOW);
		if (featureStyle == null) {
			return SPECIFICATION_ELEMENT__SPECIFICATION;
		}
		String feature = featureStyle.getStringValue();
		if (feature.equals(DOCUMENTED_ELEMENT__DOCUMENTATION.getName())) {
			return DOCUMENTED_ELEMENT__DOCUMENTATION;
		}
		return SPECIFICATION_ELEMENT__SPECIFICATION;
	}

}
