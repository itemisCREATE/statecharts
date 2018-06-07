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
package org.yakindu.sct.ui.editor.propertysheets.appearance;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ConnectionAppearancePropertySection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPart;
import org.yakindu.sct.ui.editor.editparts.TransitionEditPart;
import org.yakindu.sct.ui.editor.editparts.TransitionExpressionEditPart;
import org.yakindu.sct.ui.editor.propertysheets.util.SelectionUnwrapperUtil;

import com.google.common.collect.Lists;

/**
 *
 * @author robert rudi - Initial contribution and API
 *
 */
@SuppressWarnings("restriction")
public class TransitionAppearancePropertySection extends ConnectionAppearancePropertySection {
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, SelectionUnwrapperUtil.unwrapSelectionForType(selection, TransitionEditPart.class));
	}

	@Override
	public List<ConnectionEditPart> getInput() {
		List<?> elements = super.getInput();
		List<ConnectionEditPart> connectionEditParts = Lists.newArrayList();
		if(elements != null)
			elements.forEach(e -> {
				if (e instanceof TransitionExpressionEditPart) {
					connectionEditParts.add((TransitionEditPart) ((TransitionExpressionEditPart) e).getParent());
				}else if(e instanceof TransitionEditPart) {
					connectionEditParts.add((TransitionEditPart) e);
				}
			});
		return connectionEditParts;
	}

	@Override
	protected void initializeControls(Composite parent) {
		composite = getWidgetFactory().createFlatFormComposite(parent);
		FormLayout layout = (FormLayout) composite.getLayout();
		layout.spacing = 3;

		Composite groups = getWidgetFactory().createComposite(composite);
		groups.setLayout(new GridLayout(2, false));
		createFontsAndColorsGroups(groups);
		colorsAndFontsGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		createConnectionPropertyGroups(groups);
		createLineStylesGroup(groups);
		killChildren(groups);
	}

	protected void killChildren(Composite groups) {
		Control[] children = groups.getChildren();
		for (Control child : children) {
			if (child instanceof Group) {
				Group group = (Group) child;
				if (group.getText().equals("Jump links")) {
					group.setVisible(false);
				}
			}
		}
	}

	@Override
	protected Group createFontsAndColorsGroups(Composite parent) {
		colorsAndFontsGroup = getWidgetFactory().createGroup(parent, FONTS_AND_COLORS_LABEL);
		GridLayout layout = new GridLayout(1, true);
		colorsAndFontsGroup.setLayout(layout);

		createFontsGroup(colorsAndFontsGroup);

		return colorsAndFontsGroup;
	}

	@Override
	protected void createLineStylesGroup(Composite parent) {
		/*
		 * Do not show the line styles section when the diagram root is
		 * selected. Clients can override.
		 */
		super.createLineStylesGroup(parent);
		lineStylesGroup.setVisible(false);
	}

	@Override
	protected void createRadioGroup(Composite parent, Iterator iterator, Object propertyId, String commandName,
			String propertyName, int rows) {
		if (propertyId.equals(Properties.ID_SMOOTHNESS)) {
			return;
		}
		super.createRadioGroup(parent, iterator, propertyId, commandName, propertyName, rows);
	}

}
