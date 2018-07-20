/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	itemis AG - initial API and implementation
 *
 */
package org.yakindu.base.xtext.utils.jface.viewers;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.yakindu.base.utils.jface.viewers.StyledTextCellEditor;
import org.yakindu.base.xtext.utils.jface.fieldassist.CompletionProposalAdapter;
import org.yakindu.base.xtext.utils.jface.viewers.context.IXtextFakeContextResourcesProvider;

import com.google.inject.Injector;

/**
 * This class integrates Xtext features into a {@link CellEditor} and can be
 * used e.g. in jFace {@link StructuredViewer}s or in GMF EditParts via
 * DirectEditManager.
 *
 * The current implementation supports, code completion, syntax highlighting and
 * validation
 *
 * @see XtextStyledTextProvider
 *
 * @author andreas.muelder@itemis.de
 * @author alexander.nyssen@itemis.de
 * @author patrick.koenemann@itemis.de
 */
public class XtextStyledTextCellEditor extends StyledTextCellEditor {

	private final Injector injector;
	private StyledTextXtextAdapter xtextAdapter;
	private IXtextFakeContextResourcesProvider contextFakeResourceProvider;
	private final static String CONTEXTMENUID = "org.yakindu.base.xtext.utils.jface.viewers.StyledTextXtextAdapterContextMenu";

	public XtextStyledTextCellEditor(int style, Injector injector,
			IXtextFakeContextResourcesProvider contextFakeResourceProvider) {
		this(style, injector);
		this.contextFakeResourceProvider = contextFakeResourceProvider;
	}

	public XtextStyledTextCellEditor(int style, Injector injector) {
		setStyle(style);
		this.injector = injector;
	}

	/**
	 * Creates an {@link SourceViewer} and returns the {@link StyledText} widget
	 * of the viewer as the cell editors control. Some code is copied from
	 * {@link XtextEditor}.
	 */
	@Override
	protected Control createControl(Composite parent) {
		StyledText styledText = (StyledText) super.createControl(parent);
		styledText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				XtextStyledTextCellEditor.this.focusLost();
			}
		});

		// adapt to xtext
		this.xtextAdapter = createXtextAdapter();
		getXtextAdapter().adapt(styledText);

		// configure content assist
		final IContentAssistant contentAssistant = getXtextAdapter().getContentAssistant();

		this.completionProposalAdapter = createCompletionProposalAdapter(styledText, contentAssistant);

		// This listener notifies the modification, when text is selected via
		// proposal. A ModifyEvent is not thrown by the StyledText in this case.
		getXtextAdapter().getXtextSourceviewer().addTextListener(new ITextListener() {
			@Override
			public void textChanged(TextEvent event) {
				editOccured(null);
			}
		});

		if ((styledText.getStyle() & SWT.SINGLE) != 0) {
			// The regular key down event is too late (after popup is closed
			// again).
			// when using the StyledText.VerifyKey event (3005), we get the
			// event early enough!
			styledText.addListener(3005, new Listener() {
				@Override
				public void handleEvent(Event event) {
					if (event.character == SWT.CR && !getCompletionProposalAdapter().isProposalPopupOpen()) {
						focusLost();
					}
				}
			});
		}
		styledText.addListener(3005, new Listener() {
			@Override
			public void handleEvent(Event event) {
				if (event.character == '\u001b' // ESC
						&& !getCompletionProposalAdapter().isProposalPopupOpen()) {
					XtextStyledTextCellEditor.this.fireCancelEditor();
				}
			}
		});

		initContextMenu(styledText);

		return styledText;
	}

	protected void initContextMenu(Control control) {
		MenuManager menuManager = createMenuManager();
		Menu contextMenu = menuManager.createContextMenu(control);
		control.setMenu(contextMenu);
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPartSite site = window.getActivePage().getActiveEditor().getSite();
		site.registerContextMenu(CONTEXTMENUID, menuManager, site.getSelectionProvider());
	}

	protected MenuManager createMenuManager() {
		return new FilteringMenuManager();
	}

	@Override
	protected void keyReleaseOccured(KeyEvent keyEvent) {
		if (keyEvent.character == '\u001b') { // ESC
			return;
		}
		super.keyReleaseOccured(keyEvent);
	}

	@Override
	protected void doSetValue(Object value) {
		super.doSetValue(value);
		// Reset the undo manager to prevent deletion of complete text if the
		// user hits ctrl+z after cell editor opens
		getXtextAdapter().getXtextSourceviewer().getUndoManager().reset();
	}

	@Override
	public boolean isUndoEnabled() {
		return true;
	}

	@Override
	public void performUndo() {
		getXtextAdapter().getXtextSourceviewer().getUndoManager().undo();
	}

	@Override
	public boolean isRedoEnabled() {
		return true;
	}

	@Override
	public void performRedo() {
		getXtextAdapter().getXtextSourceviewer().getUndoManager().redo();
	}

	@Override
	public boolean isFindEnabled() {
		return true;
	}

	// in gtk, we need this flag to let one focus lost event pass. See
	// focusLost() for details.
	private boolean ignoreNextFocusLost = false;
	private CompletionProposalAdapter completionProposalAdapter;

	/*
	 * In gtk, the focus lost event is fired _after_ the CR event, so we need to
	 * remember the state when the proposal popup window is open.
	 */
	@Override
	protected void focusLost() {
		if (SWT.getPlatform().equals("gtk")) {
			if (isIgnoreNextFocusLost()) {
				setIgnoreNextFocusLost(false);
				return;
			}
			if (getCompletionProposalAdapter().isProposalPopupOpen() || text.getMenu().isVisible()) {
				setIgnoreNextFocusLost(true);
				return;
			}
		}

		if (!getCompletionProposalAdapter().isProposalPopupOpen()) {
			super.focusLost();
		}
	}

	@Override
	public void dispose() {
		getXtextAdapter().dispose();
		super.dispose();
	}

	/*
	 * This is damn important! If we don't return false here, the
	 * ColumnEditorViewer calls applyEditorValue on FocusLostEvents!
	 */
	@Override
	protected boolean dependsOnExternalFocusListener() {
		return false;
	}

	public void setVisibleRegion(int start, int length) {
		getXtextAdapter().setVisibleRegion(start, length);
	}

	public StyledTextXtextAdapter getXtextAdapter() {
		return this.xtextAdapter;
	}

	protected CompletionProposalAdapter getCompletionProposalAdapter() {
		return this.completionProposalAdapter;
	}

	protected IXtextFakeContextResourcesProvider getContextFakeResourceProvider() {
		return this.contextFakeResourceProvider;
	}

	protected CompletionProposalAdapter createCompletionProposalAdapter(StyledText styledText,
			final IContentAssistant contentAssistant) {
		return new CompletionProposalAdapter(styledText, contentAssistant, KeyStroke.getInstance(SWT.CTRL, SWT.SPACE),
				null);
	}

	protected StyledTextXtextAdapter createXtextAdapter() {
		return new StyledTextXtextAdapter(this.getInjector(),
				getContextFakeResourceProvider() == null
						? IXtextFakeContextResourcesProvider.NULL_CONTEXT_PROVIDER
						: getContextFakeResourceProvider());
	}

	protected boolean isIgnoreNextFocusLost() {
		return this.ignoreNextFocusLost;
	}

	protected void setIgnoreNextFocusLost(boolean ignoreNextFocusLost) {
		this.ignoreNextFocusLost = ignoreNextFocusLost;
	}

	protected Injector getInjector() {
		return this.injector;
	}
}
