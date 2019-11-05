/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editor;

import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.ACTION_AUTOSIZE;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.ACTION_COPY_APPEARANCE_PROPERTIES;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.ACTION_FONT_BOLD;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.ACTION_FONT_ITALIC;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.ACTION_HIDE_CONNECTION_LABELS;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.ACTION_SHOW_CONNECTION_LABELS;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.CUSTOM_FILL_COLOR;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.CUSTOM_FONT_COLOR;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.CUSTOM_FONT_NAME;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.CUSTOM_FONT_SIZE;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.CUSTOM_LINE_COLOR;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.CUSTOM_ZOOM;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.MENU_ALIGN;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.MENU_COMPARTMENT;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.MENU_ROUTER;
import static org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.MENU_SELECT;
import static org.yakindu.sct.ui.perspectives.IYakinduSctPerspectives.ID_PERSPECTIVE_SCT_SIMULATION;

import java.util.List;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWorkbenchPage;

import com.google.common.collect.Lists;

/**
 * @author tobias angele - Initial contribution and API
 */
public class DisableButtonsByPerspectiveListener implements IPerspectiveListener {

	public static final String TESTING_PERSPECTIVE = "com.yakindu.sct.ui.TestingPerspective";

	private static final List<String> BUTTON_IDS = Lists.newArrayList(
			CUSTOM_FONT_NAME,
			CUSTOM_FONT_SIZE,
			CUSTOM_ZOOM,
			CUSTOM_FILL_COLOR,
			CUSTOM_LINE_COLOR,
			CUSTOM_FONT_COLOR,
			ACTION_FONT_BOLD,
			ACTION_FONT_ITALIC,
			ACTION_AUTOSIZE,
			MENU_ROUTER,
			MENU_SELECT,
			MENU_COMPARTMENT,
			MENU_ALIGN,
			ACTION_HIDE_CONNECTION_LABELS,
			ACTION_SHOW_CONNECTION_LABELS,
			ACTION_COPY_APPEARANCE_PROPERTIES
	);
	
	private IActionBars bars;

	public DisableButtonsByPerspectiveListener(IActionBars bars) {
		this.bars = bars;
	}

	@Override
	public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
		setToolbarButtons(bars, perspective);
	}

	@Override
	public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective, String changeId) {
		setToolbarButtons(bars, perspective);
	}

	void setToolbarButtons(IActionBars bars, IPerspectiveDescriptor perspective) {
		enableEditingButtons(bars.getToolBarManager(), !relevantPerspective(perspective));
	}

	public boolean relevantPerspective(IPerspectiveDescriptor perspective) {
		return ID_PERSPECTIVE_SCT_SIMULATION.equals(perspective.getId())
				|| TESTING_PERSPECTIVE.equals(perspective.getId());
	}

	private void enableEditingButtons(IToolBarManager tb, boolean isVisible) {
		for (String id : BUTTON_IDS) {
			IContributionItem item = tb.find(id);
			if (item != null) {
				item.setVisible(isVisible);
			}
		}
		tb.update(true);
	}
}
