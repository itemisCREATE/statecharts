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

import org.eclipse.core.commands.contexts.Context;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
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

	protected static final String CHILD_CONTEXT_SCOPE_DESCRIPTION = "Embedded text editor scope";
	protected static final String DIALOG_AND_WINDOW_SCOPE = "org.eclipse.ui.contexts.dialogAndWindow";
	protected static final String EMBEDDED_TEXT_EDITOR_SCOPE = "org.eclipse.xtext.ui.embeddedTextEditorScope";
	protected static final String TEXT_EDITOR_SCOPE = "org.eclipse.ui.textEditorScope";
	private IAction copyAction;
	private IAction cutAction;
	private IAction pasteAction;
	private IAction selectAllAction;
	private IAction printAction;
	private StyledTextActionHandler actionHandler;
	private IContextActivation embeddedEditorCtx;
	private IContextService contextService;

	public StyledTextSelectionListener(IWorkbenchPartSite site, StyledText widget,
			ISelectionProvider selectionProviderOnFocusGain) {
		super(site, selectionProviderOnFocusGain, widget);
		contextService = site.getService(IContextService.class);
		site.setSelectionProvider(selectionProviderOnFocusGain);
		widget.addFocusListener(this);
		widget.addDisposeListener(this);
	}

	@Override
	public void focusLost(FocusEvent e) {
		super.focusLost(e);
		unhookActions(e);
		redefineParentContext(EMBEDDED_TEXT_EDITOR_SCOPE, DIALOG_AND_WINDOW_SCOPE);
	}

	@Override
	public void focusGained(FocusEvent e) {
		releaseSelection();
		hookActions(e);
		redefineParentContext(EMBEDDED_TEXT_EDITOR_SCOPE, TEXT_EDITOR_SCOPE);
		super.focusGained(e);
	}

	protected void redefineParentContext(String childContext, String parentContext) {
		if (embeddedEditorCtx != null) { // deactivates the context on focus
											// lost
			contextService.deactivateContext(embeddedEditorCtx);
			embeddedEditorCtx = null;
		} else { // redefines the parent of the child context, to avoid
					// keybinding conflicts
			final Context childCtx = contextService.getContext(childContext);
			if (childCtx != null) {
				childCtx.define(childContext, CHILD_CONTEXT_SCOPE_DESCRIPTION, parentContext);
				embeddedEditorCtx = contextService.activateContext(childContext);
			}
		}
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
		actionHandler.setPrintAction(printAction);
	}

	protected IActionBars saveDiagramActions() {
		final StatechartDiagramActionbarContributor contributor = (StatechartDiagramActionbarContributor) ((IEditorSite) site)
				.getActionBarContributor();
		copyAction = contributor.getActionBars().getGlobalActionHandler(ActionFactory.COPY.getId());
		cutAction = contributor.getActionBars().getGlobalActionHandler(ActionFactory.CUT.getId());
		pasteAction = contributor.getActionBars().getGlobalActionHandler(ActionFactory.PASTE.getId());
		selectAllAction = contributor.getActionBars().getGlobalActionHandler(ActionFactory.SELECT_ALL.getId());
		printAction = contributor.getActionBars().getGlobalActionHandler(ActionFactory.PRINT.getId());
		return contributor.getActionBars();
	}

	protected void unhookActions(FocusEvent e) {
		if (actionHandler != null && actionHandler.isHooked())
			actionHandler.removeStyledText((StyledText) e.widget);
	}
}
