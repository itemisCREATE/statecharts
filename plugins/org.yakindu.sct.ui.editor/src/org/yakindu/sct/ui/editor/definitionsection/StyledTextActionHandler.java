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
package org.yakindu.sct.ui.editor.definitionsection;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionFactory;

/**
 * This class is a modified copy of <code>TextActionHandler</code>. This handler
 * is needed to hook a <code>StyledText</code> widget into the global action
 * handling. It handles the redirection of the global Copy, Cut, Paste and
 * Select All action to either the hooked Styledtext widget or another action
 * handler.
 * 
 * @author robert rudi - Initial contribution and API
 *
 */
public class StyledTextActionHandler {
	private CopyActionHandler styledTextCopyAction = new CopyActionHandler();
	private CutActionHandler styledTextCutAction = new CutActionHandler();
	private PasteActionHandler styledTextPasteAction = new PasteActionHandler();
	private SelectAllActionHandler styledTextSelectAllAction = new SelectAllActionHandler();

	private IPropertyChangeListener copyActionListener = new PropertyChangeListener(styledTextCopyAction);
	private IPropertyChangeListener cutActionListener = new PropertyChangeListener(styledTextCutAction);
	private IPropertyChangeListener pasteActionListener = new PropertyChangeListener(styledTextPasteAction);
	private IPropertyChangeListener selectAllActionListener = new PropertyChangeListener(styledTextSelectAllAction);

	private IAction copyAction;
	private IAction cutAction;
	private IAction pasteAction;
	private IAction selectAllAction;

	private StyledText styledText;

	private Listener textControlListener = new TextControlListener();

	protected MouseAdapter mouseAdapter = new MouseAdapter() {
		public void mouseUp(MouseEvent e) {
			updateActionsEnableState();
		}
	};

	protected KeyAdapter keyAdapter = new KeyAdapter() {
		public void keyReleased(KeyEvent e) {
			updateActionsEnableState();
		}
	};

	protected class TextControlListener implements Listener {
		public void handleEvent(Event event) {
			switch (event.type) {
				case SWT.Activate :
					styledText = (StyledText) event.widget;
					updateActionsEnableState();
					break;
				case SWT.Deactivate :
					if (styledText != null && !styledText.isDisposed())
						styledText.setSelection(0);
					styledText = null;
					updateActionsEnableState();
					break;
				default :
					break;
			}
		}
	}

	protected class PropertyChangeListener implements IPropertyChangeListener {
		private IAction actionHandler;

		protected PropertyChangeListener(IAction actionHandler) {
			super();
			this.actionHandler = actionHandler;
		}

		public void propertyChange(PropertyChangeEvent event) {
			if (styledText != null)
				return;
			if (event.getProperty().equals(IAction.ENABLED)) {
				Boolean bool = (Boolean) event.getNewValue();
				actionHandler.setEnabled(bool.booleanValue());
			}
		}
	};

	protected class CopyActionHandler extends Action {
		protected CopyActionHandler() {
			super("Copy");
			setId("StyledTextCopyActionHandler");
			setEnabled(false);
		}

		public void runWithEvent(Event event) {
			if (styledText != null && !styledText.isDisposed()) {
				styledText.copy();
				return;
			}
			if (copyAction != null) {
				copyAction.runWithEvent(event);
				return;
			}
		}

		public void updateEnabledState() {
			if (styledText != null && !styledText.isDisposed()) {
				setEnabled(!styledText.getSelectionText().isEmpty());
				return;
			}
			if (copyAction != null) {
				setEnabled(copyAction.isEnabled());
				return;
			}
			setEnabled(false);
		}
	}

	protected class CutActionHandler extends Action {
		protected CutActionHandler() {
			super("Cut");
			setId("StyledTextCutActionHandler");
			setEnabled(false);
		}

		public void runWithEvent(Event event) {
			if (styledText != null && !styledText.isDisposed()) {
				styledText.cut();
				return;
			}
			if (cutAction != null) {
				cutAction.runWithEvent(event);
				return;
			}
		}

		public void updateEnabledState() {
			if (styledText != null && !styledText.isDisposed()) {
				setEnabled(!styledText.getSelectionText().isEmpty());
				return;
			}
			if (cutAction != null) {
				setEnabled(cutAction.isEnabled());
				return;
			}
			setEnabled(false);
		}
	}

	protected class PasteActionHandler extends Action {
		protected PasteActionHandler() {
			super("Paste");
			setId("StyledTextPasteActionHandler");
			setEnabled(false);
		}

		public void runWithEvent(Event event) {
			if (styledText != null && !styledText.isDisposed()) {
				styledText.paste();
				return;
			}
			if (pasteAction != null) {
				pasteAction.runWithEvent(event);
				return;
			}
		}

		public void updateEnabledState() {
			if (styledText != null && !styledText.isDisposed()) {
				setEnabled(true);
				return;
			}
			if (pasteAction != null) {
				setEnabled(pasteAction.isEnabled());
				return;
			}
			setEnabled(false);
		}
	}

	protected class SelectAllActionHandler extends Action {
		protected SelectAllActionHandler() {
			super("Select All");
			setId("StyledTextSelectAllActionHandler");
			setEnabled(false);
		}

		public void runWithEvent(Event event) {
			if (styledText != null && !styledText.isDisposed()) {
				styledText.selectAll();
				return;
			}
			if (selectAllAction != null) {
				selectAllAction.runWithEvent(event);
				return;
			}
		}

		public void updateEnabledState() {
			if (styledText != null && !styledText.isDisposed()) {
				setEnabled(!styledText.getText().isEmpty());
				return;
			}
			if (selectAllAction != null) {
				setEnabled(selectAllAction.isEnabled());
				return;
			}
			setEnabled(false);
		}
	}

	/**
	 * Creates a <code>StyledText</code> widget action handler for the global Copy,
	 * Cut, Paste and Select All of the action bar.
	 *
	 * @param actionBars
	 *            the actionbars to register global action handlers for Copy, Cut
	 *            Paste and Select All actions
	 */
	public StyledTextActionHandler(IActionBars actionBars) {
		super();
		actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), styledTextCopyAction);
		actionBars.setGlobalActionHandler(ActionFactory.CUT.getId(), styledTextCutAction);
		actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(), styledTextPasteAction);
		actionBars.setGlobalActionHandler(ActionFactory.SELECT_ALL.getId(), styledTextSelectAllAction);
	}

	/**
	 * Adapts a <code>StyledText</code> widget to the handler so that the Copy, Cut,
	 * Paste and Select All actions are redirected to it when focused.
	 *
	 * @param textWidget
	 *            the <code>StyledText</code> widget
	 */
	public void adaptStyledText(StyledText textWidget) {
		if (textWidget == null)
			return;

		styledText = textWidget;
		textWidget.addListener(SWT.Activate, textControlListener);
		textWidget.addListener(SWT.Deactivate, textControlListener);

		textWidget.addKeyListener(keyAdapter);
		textWidget.addMouseListener(mouseAdapter);
	}

	public boolean isHooked() {
		return styledText != null && !styledText.isDisposed();
	}

	/**
	 * Dispose this action handler
	 */
	public void dispose() {
		setCopyAction(null);
		setCutAction(null);
		setPasteAction(null);
		setSelectAllAction(null);
	}

	/**
	 * Removes a <code>StyledText</code> widget from the handler so that the Copy,
	 * Cut, Paste and Select All actions are no longer redirected to it when
	 * focused.
	 *
	 * @param textWidget
	 *            the <code>StyledText</code> widget
	 */
	public void removeStyledText(StyledText textWidget) {
		if (textWidget == null)
			return;

		textWidget.removeListener(SWT.Activate, textControlListener);
		textWidget.removeListener(SWT.Deactivate, textControlListener);

		textWidget.removeMouseListener(mouseAdapter);
		textWidget.removeKeyListener(keyAdapter);

		styledText = null;
		updateActionsEnableState();
	}

	/**
	 * Sets the default <code>IAction</code> handler for the Copy action. This
	 * <code>IAction</code> is only active if the <code>StyledText</code> is not in
	 * focus.
	 *
	 * @param action
	 *            the <code>IAction</code> to run for the Copy action, or
	 *            <code>null</null> if not interested.
	 */
	public void setCopyAction(IAction action) {
		if (copyAction == action)
			return;

		if (copyAction != null)
			copyAction.removePropertyChangeListener(copyActionListener);

		copyAction = action;

		if (copyAction != null)
			copyAction.addPropertyChangeListener(copyActionListener);

		styledTextCopyAction.updateEnabledState();
	}

	/**
	 * Sets the default <code>IAction</code> handler for the Cut action. This
	 * <code>IAction</code> is only active if the <code>StyledText</code> is not in
	 * focus.
	 *
	 * @param action
	 *            the <code>IAction</code> to run for the Cut action, or
	 *            <code>null</null> if not interested.
	 */
	public void setCutAction(IAction action) {
		if (cutAction == action)
			return;

		if (cutAction != null)
			cutAction.removePropertyChangeListener(cutActionListener);

		cutAction = action;

		if (cutAction != null)
			cutAction.addPropertyChangeListener(cutActionListener);

		styledTextCutAction.updateEnabledState();
	}

	/**
	 * Sets the default <code>IAction</code> handler for the Paste action. This
	 * <code>IAction</code> is only active if the <code>StyledText</code> is not in
	 * focus.
	 *
	 * @param action
	 *            the <code>IAction</code> to run for the Paste action, or
	 *            <code>null</null> if not interested.
	 */
	public void setPasteAction(IAction action) {
		if (pasteAction == action)
			return;

		if (pasteAction != null)
			pasteAction.removePropertyChangeListener(pasteActionListener);

		pasteAction = action;

		if (pasteAction != null)
			pasteAction.addPropertyChangeListener(pasteActionListener);

		styledTextPasteAction.updateEnabledState();
	}

	/**
	 * Set the default <code>IAction</code> handler for the Select All action. This
	 * <code>IAction</code> is only active if the <code>StyledText</code> is not in
	 * focus.
	 *
	 * @param action
	 *            the <code>IAction</code> to run for the Select All action, or
	 *            <code>null</null> if not interested.
	 */
	public void setSelectAllAction(IAction action) {
		if (selectAllAction == action)
			return;

		if (selectAllAction != null)
			selectAllAction.removePropertyChangeListener(selectAllActionListener);

		selectAllAction = action;

		if (selectAllAction != null)
			selectAllAction.addPropertyChangeListener(selectAllActionListener);

		styledTextSelectAllAction.updateEnabledState();
	}

	/**
	 * Update the enable state of the Copy, Cut, Paste and Select All action
	 * handlers
	 */
	private void updateActionsEnableState() {
		styledTextCopyAction.updateEnabledState();
		styledTextCutAction.updateEnabledState();
		styledTextPasteAction.updateEnabledState();
		styledTextSelectAllAction.updateEnabledState();
	}
}