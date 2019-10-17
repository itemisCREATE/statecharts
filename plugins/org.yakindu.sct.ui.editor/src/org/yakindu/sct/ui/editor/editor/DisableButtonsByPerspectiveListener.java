package org.yakindu.sct.ui.editor.editor;

import static org.yakindu.sct.ui.perspectives.IYakinduSctPerspectives.ID_PERSPECTIVE_SCT_SIMULATION;

import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWorkbenchPage;

public class DisableButtonsByPerspectiveListener implements IPerspectiveListener {
	
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
		enableAppearanceButtons(bars.getToolBarManager(), !simulationPerspective(perspective));
	}
	
	public boolean simulationPerspective(IPerspectiveDescriptor perspective) {
		return ID_PERSPECTIVE_SCT_SIMULATION.equals(perspective.getId());
	}

	private void enableAppearanceButtons(IToolBarManager tb, boolean b) {
		tb.find(ActionIds.CUSTOM_FONT_NAME).setVisible(b);
		tb.find(ActionIds.CUSTOM_FONT_SIZE).setVisible(b);
		tb.find(ActionIds.CUSTOM_ZOOM).setVisible(b);
		tb.find(ActionIds.CUSTOM_FILL_COLOR).setVisible(b);
		tb.find(ActionIds.CUSTOM_LINE_COLOR).setVisible(b);
		tb.find(ActionIds.CUSTOM_FONT_COLOR).setVisible(b);
		tb.find(ActionIds.ACTION_FONT_BOLD).setVisible(b);
		tb.find(ActionIds.ACTION_FONT_ITALIC).setVisible(b);
		tb.find(ActionIds.ACTION_AUTOSIZE).setVisible(b);
		tb.find(ActionIds.MENU_ROUTER).setVisible(b);
		tb.find(ActionIds.MENU_SELECT).setVisible(b);
		tb.find(ActionIds.MENU_COMPARTMENT).setVisible(b);
		tb.find(ActionIds.MENU_ALIGN).setVisible(b);
		tb.find(ActionIds.ACTION_HIDE_CONNECTION_LABELS).setVisible(b);
		tb.find(ActionIds.ACTION_SHOW_CONNECTION_LABELS).setVisible(b);
		tb.find(ActionIds.ACTION_COPY_APPEARANCE_PROPERTIES).setVisible(b);
		tb.update(true);
	}
}
