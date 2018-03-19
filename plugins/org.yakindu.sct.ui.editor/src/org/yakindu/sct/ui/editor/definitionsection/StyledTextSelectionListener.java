/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.definitionsection;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionFactory;
import org.yakindu.base.xtext.utils.jface.viewers.StyledTextXtextAdapter;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramActionbarContributor;

/**
 * Extends {@link StyledTextXtextAdapter.ChangeSelectionProviderOnFocusGain} to
 * be able to release selection of previous selection provider. This in needed
 * to be able to perform keyboard shortcuts on the text in the statechart
 * definition section without interacting with the elements of the diagram. 
 * 
 * This class does also hook the default clipboard actions Copy, Cut, Paste and
 * Select All for text widgets to a <code>StyledText</code> widget, which gets a
 * focus. The hook is for retargeting global actions, which are mapped to
 * diagram actions by default.
 * 
 * @author robert rudi - Initial contribution and API
 */
public class StyledTextSelectionListener extends StyledTextXtextAdapter.ChangeSelectionProviderOnFocusGain {

	private IAction copyAction;
	private IAction cutAction;
	private IAction pasteAction;
	private IAction selectAllAction;
	private StyledTextActionHandler actionHandler;

	public StyledTextSelectionListener(IWorkbenchPartSite site, StyledText widget, ISelectionProvider selectionProviderOnFocusGain) {
		super(site, selectionProviderOnFocusGain);
		site.setSelectionProvider(selectionProviderOnFocusGain);
		widget.addFocusListener(this);
		widget.addDisposeListener(this);
	}

	@Override
	public void focusLost(FocusEvent e) {
		super.focusLost(e);
		unhookActions(e);
	}

	public void focusGained(FocusEvent e) {
		releaseSelection();
		hookActions(e);
		super.focusGained(e);
	}

	protected void releaseSelection() {
		if (site != null && this.selectionProviderOnFocusGain != null
				&& !site.getSelectionProvider().equals(selectionProviderOnFocusGain))
			site.getSelectionProvider().setSelection(StructuredSelection.EMPTY);
	}

	protected void hookActions(FocusEvent e) {
		if (actionHandler == null) {
			final IActionBars bars = saveDiagramActions();
			actionHandler = new StyledTextActionHandler(bars);
		}
		if (!actionHandler.isHooked()) {
			actionHandler.adaptStyledText((StyledText) e.widget);
			restoreDiagramActions();
		}
	}

	protected void restoreDiagramActions() {
		actionHandler.setCopyAction(copyAction);
		actionHandler.setCutAction(cutAction);
		actionHandler.setPasteAction(pasteAction);
		actionHandler.setSelectAllAction(selectAllAction);
	}

	protected IActionBars saveDiagramActions() {
		final StatechartDiagramActionbarContributor contributor = (StatechartDiagramActionbarContributor) ((IEditorSite) site)
				.getActionBarContributor();
		copyAction = contributor.getActionBars().getGlobalActionHandler(ActionFactory.COPY.getId());
		cutAction = contributor.getActionBars().getGlobalActionHandler(ActionFactory.CUT.getId());
		pasteAction = contributor.getActionBars().getGlobalActionHandler(ActionFactory.PASTE.getId());
		selectAllAction = contributor.getActionBars().getGlobalActionHandler(ActionFactory.SELECT_ALL.getId());
		return contributor.getActionBars();
	}

	protected void unhookActions(FocusEvent e) {
		if (actionHandler != null && actionHandler.isHooked())
			actionHandler.removeStyledText((StyledText) e.widget);
	}
}
