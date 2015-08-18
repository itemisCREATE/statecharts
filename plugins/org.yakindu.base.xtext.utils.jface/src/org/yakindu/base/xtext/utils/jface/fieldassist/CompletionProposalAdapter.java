package org.yakindu.base.xtext.utils.jface.fieldassist;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * This is a stripped copy from {@link ContentProposalAdapter} that delegates
 * the popup to a {@link CompletionProposal} managed by a
 * {@link IContentAssistant}.
 * 
 * @author patrick.koenemann@itemis.de
 * 
 */
public class CompletionProposalAdapter implements ICompletionListener {

	private final IContentAssistant contentAssistant;

	/**
	 * <p>
	 * This adapter installs listener on the given control and delegates the
	 * completion proposal popup request to the given {@link IContentAssistant}.
	 * </p>
	 * 
	 * <p>
	 * FIXME: Parameter <code>autoActivationCharacters</code> is untested.
	 * </p>
	 * 
	 * @param control
	 * @param contentAssistant
	 * @param keyStroke
	 * @param autoActivationCharacters
	 */
	public CompletionProposalAdapter(Control control,
			IContentAssistant contentAssistant, KeyStroke keyStroke,
			char[] autoActivationCharacters) {

		this.control = control;

		this.triggerKeyStroke = keyStroke;
		if (autoActivationCharacters != null) {
			this.autoActivateString = new String(autoActivationCharacters);
		}

		this.contentAssistant = contentAssistant;
		addControlListener(control);
	}

	/**
	 * Flag that controls the printing of debug info.
	 */
	public static final boolean DEBUG = false;

	/*
	 * The control for which content proposals are provided.
	 */
	private Control control;

	/*
	 * The keystroke that signifies content proposals should be shown.
	 */
	private KeyStroke triggerKeyStroke;

	/*
	 * The String containing characters that auto-activate the popup.
	 */
	private String autoActivateString;

	/*
	 * The listener we install on the control.
	 */
	private Listener controlListener;

	/*
	 * The list of IContentProposalListener2 listeners.
	 */
	private ListenerList proposalListeners2 = new ListenerList();

	/*
	 * Flag that indicates whether the adapter is enabled. In some cases,
	 * adapters may be installed but depend upon outside state.
	 */
	private boolean isEnabled = true;

	/*
	 * The delay in milliseconds used when autoactivating the popup.
	 */
	private int autoActivationDelay = 0;

	/*
	 * A boolean indicating whether a keystroke has been received. Used to see
	 * if an autoactivation delay was interrupted by a keystroke.
	 */
	private boolean receivedKeyDown;

	/**
	 * Get the control on which the content proposal adapter is installed.
	 * 
	 * @return the control on which the proposal adapter is installed.
	 */
	public Control getControl() {
		return control;
	}

	/**
	 * Return a boolean indicating whether the receiver is enabled.
	 * 
	 * @return <code>true</code> if the adapter is enabled, and
	 *         <code>false</code> if it is not.
	 */
	public boolean isEnabled() {
		return isEnabled;
	}

	/**
	 * Return the array of characters on which the popup is autoactivated.
	 * 
	 * @return An array of characters that trigger auto-activation of content
	 *         proposal. If specified, these characters will trigger
	 *         auto-activation of the proposal popup, regardless of whether an
	 *         explicit invocation keyStroke was specified. If this parameter is
	 *         <code>null</code>, then only a specified keyStroke will invoke
	 *         content proposal. If this value is <code>null</code> and the
	 *         keyStroke value is <code>null</code>, then all alphanumeric
	 *         characters will auto-activate content proposal.
	 */
	public char[] getAutoActivationCharacters() {
		if (autoActivateString == null) {
			return null;
		}
		return autoActivateString.toCharArray();
	}

	/**
	 * Set the array of characters that will trigger autoactivation of the
	 * popup.
	 * 
	 * @param autoActivationCharacters
	 *            An array of characters that trigger auto-activation of content
	 *            proposal. If specified, these characters will trigger
	 *            auto-activation of the proposal popup, regardless of whether
	 *            an explicit invocation keyStroke was specified. If this
	 *            parameter is <code>null</code>, then only a specified
	 *            keyStroke will invoke content proposal. If this parameter is
	 *            <code>null</code> and the keyStroke value is <code>null</code>
	 *            , then all alphanumeric characters will auto-activate content
	 *            proposal.
	 * 
	 */
	public void setAutoActivationCharacters(char[] autoActivationCharacters) {
		if (autoActivationCharacters == null) {
			this.autoActivateString = null;
		} else {
			this.autoActivateString = new String(autoActivationCharacters);
		}
	}

	/**
	 * Set the delay, in milliseconds, used before any autoactivation is
	 * triggered.
	 * 
	 * @return the time in milliseconds that will pass before a popup is
	 *         automatically opened
	 */
	public int getAutoActivationDelay() {
		return autoActivationDelay;

	}

	/**
	 * Set the delay, in milliseconds, used before autoactivation is triggered.
	 * 
	 * @param delay
	 *            the time in milliseconds that will pass before a popup is
	 *            automatically opened
	 */
	public void setAutoActivationDelay(int delay) {
		autoActivationDelay = delay;

	}

	/**
	 * Set the boolean flag that determines whether the adapter is enabled.
	 * 
	 * @param enabled
	 *            <code>true</code> if the adapter is enabled and responding to
	 *            user input, <code>false</code> if it is ignoring user input.
	 * 
	 */
	public void setEnabled(boolean enabled) {
		// If we are disabling it while it's proposing content, close the
		// content proposal popup.
		if (isEnabled && !enabled) {
			// if (popup != null) {
			// popup.close();
			// }
		}
		isEnabled = enabled;
	}

	/**
	 * Add the specified listener to the list of content proposal listeners that
	 * are notified when a content proposal popup is opened or closed.
	 */
	public void addContentProposalListener(ICompletionProposalListener listener) {
		proposalListeners2.add(listener);
	}

	/**
	 * Remove the specified listener from the list of content proposal listeners
	 * that are notified when a content proposal popup is opened or closed.
	 */
	public void removeContentProposalListener(
			ICompletionProposalListener listener) {
		proposalListeners2.remove(listener);
	}

	/*
	 * Add our listener to the control. Debug information to be left in until
	 * this support is stable on all platforms.
	 */
	private void addControlListener(Control control) {
		if (DEBUG) {
			System.out
					.println("ContentProposalListener#installControlListener()"); //$NON-NLS-1$
		}

		if (controlListener != null) {
			return;
		}
		controlListener = new Listener() {
			public void handleEvent(Event e) {
				if (!isEnabled) {
					return;
				}

				switch (e.type) {
				case SWT.Traverse:
				case SWT.KeyDown:
					if (DEBUG) {
						StringBuffer sb;
						if (e.type == SWT.Traverse) {
							sb = new StringBuffer("Traverse"); //$NON-NLS-1$
						} else {
							sb = new StringBuffer("KeyDown"); //$NON-NLS-1$
						}
						sb.append(" received by adapter"); //$NON-NLS-1$
						dump(sb.toString(), e);
					}
					// If the popup is open, it gets first shot at the
					// keystroke and should set the doit flags appropriately.
					// if (popup != null) {
					// popup.getTargetControlListener().handleEvent(e);
					// if (DEBUG) {
					// StringBuffer sb;
					// if (e.type == SWT.Traverse) {
					//								sb = new StringBuffer("Traverse"); //$NON-NLS-1$
					// } else {
					//								sb = new StringBuffer("KeyDown"); //$NON-NLS-1$
					// }
					//							sb.append(" after being handled by popup"); //$NON-NLS-1$
					// dump(sb.toString(), e);
					// }
					// // See
					// https://bugs.eclipse.org/bugs/show_bug.cgi?id=192633
					// // If the popup is open and this is a valid character, we
					// // want to watch for the modified text.
					// if (propagateKeys && e.character != 0)
					// watchModify = true;
					//
					// return;
					// }

					// We were only listening to traverse events for the popup
					if (e.type == SWT.Traverse) {
						return;
					}

					// The popup is not open. We are looking at keydown events
					// for a trigger to open the popup.
					if (triggerKeyStroke != null) {
						// Either there are no modifiers for the trigger and we
						// check the character field...
						if ((triggerKeyStroke.getModifierKeys() == KeyStroke.NO_KEY && triggerKeyStroke
								.getNaturalKey() == e.character) ||
						// ...or there are modifiers, in which case the
						// keycode and state must match
								(triggerKeyStroke.getNaturalKey() == e.keyCode && ((triggerKeyStroke
										.getModifierKeys() & e.stateMask) == triggerKeyStroke
										.getModifierKeys()))) {
							// We never propagate the keystroke for an explicit
							// keystroke invocation of the popup
							e.doit = false;
							openProposalPopup(false);
							return;
						}
					}
					/*
					 * The triggering keystroke was not invoked. If a character
					 * was typed, compare it to the autoactivation characters.
					 */
					if (e.character != 0) {
						if (autoActivateString != null) {
							if (autoActivateString.indexOf(e.character) >= 0) {
								autoActivate();
							} else {
								// No autoactivation occurred, so record the key
								// down as a means to interrupt any
								// autoactivation that is pending due to
								// autoactivation delay.
								receivedKeyDown = true;
								// watch the modify so we can close the popup in
								// cases where there is no longer a trigger
								// character in the content
								// watchModify = true;
							}
						} else {
							// The autoactivate string is null. If the trigger
							// is also null, we want to act on any modification
							// to the content. Set a flag so we'll catch this
							// in the modify event.
							if (triggerKeyStroke == null) {
								// watchModify = true;
							}
						}
					} else {
						// A non-character key has been pressed. Interrupt any
						// autoactivation that is pending due to autoactivation
						// delay.
						receivedKeyDown = true;
					}
					break;

				// There are times when we want to monitor content changes
				// rather than individual keystrokes to determine whether
				// the popup should be closed or opened based on the entire
				// content of the control.
				// The watchModify flag ensures that we don't autoactivate if
				// the content change was caused by something other than typing.
				// See https://bugs.eclipse.org/bugs/show_bug.cgi?id=183650
				// case SWT.Modify:
				// if (allowsAutoActivate() && watchModify) {
				// if (DEBUG) {
				//								dump("Modify event triggers popup open or close", e); //$NON-NLS-1$
				// }
				// watchModify = false;
				// // We are in autoactivation mode, either for specific
				// // characters or for all characters. In either case,
				// // we should close the proposal popup when there is no
				// // content in the control.
				// if (isControlContentEmpty()) {
				// // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=192633
				// closeProposalPopup();
				// } else {
				// // See https://bugs.eclipse.org/bugs/show_bug.cgi?id=147377
				// // Given that we will close the popup when there are
				// // no valid proposals, we must consider reopening it on any
				// // content change when there are no particular autoActivation
				// // characters
				// if (autoActivateString == null) {
				// autoActivate();
				// } else {
				// // Autoactivation characters are defined, but this
				// // modify event does not involve one of them. See
				// // if any of the autoactivation characters are left
				// // in the content and close the popup if none remain.
				// if (!shouldPopupRemainOpen())
				// closeProposalPopup();
				// }
				// }
				// }
				// break;
				default:
					break;
				}
			}

			/**
			 * Dump the given events to "standard" output.
			 * 
			 * @param who
			 *            who is dumping the event
			 * @param e
			 *            the event
			 */
			private void dump(String who, Event e) {
				StringBuffer sb = new StringBuffer(
						"--- [ContentProposalAdapter]\n"); //$NON-NLS-1$
				sb.append(who);
				sb.append(" - e: keyCode=" + e.keyCode + hex(e.keyCode)); //$NON-NLS-1$
				sb.append("; character=" + e.character + hex(e.character)); //$NON-NLS-1$
				sb.append("; stateMask=" + e.stateMask + hex(e.stateMask)); //$NON-NLS-1$
				sb.append("; doit=" + e.doit); //$NON-NLS-1$
				sb.append("; detail=" + e.detail + hex(e.detail)); //$NON-NLS-1$
				sb.append("; widget=" + e.widget); //$NON-NLS-1$
				System.out.println(sb);
			}

			private String hex(int i) {
				return "[0x" + Integer.toHexString(i) + ']'; //$NON-NLS-1$
			}
		};
		control.addListener(SWT.KeyDown, controlListener);
		control.addListener(SWT.Traverse, controlListener);
		control.addListener(SWT.Modify, controlListener);

		if (DEBUG) {
			System.out
					.println("ContentProposalAdapter#installControlListener() - installed"); //$NON-NLS-1$
		}
	}

	/**
	 * Open the proposal popup and display the proposals provided by the
	 * proposal provider. If there are no proposals to be shown, do not show the
	 * popup. This method returns immediately. That is, it does not wait for the
	 * popup to open or a proposal to be selected.
	 * 
	 * @param autoActivated
	 *            a boolean indicating whether the popup was autoactivated. If
	 *            false, a beep will sound when no proposals can be shown.
	 */
	private void openProposalPopup(boolean autoActivated) {
		if (isValid() && isEnabled()) {

			// XXX here we delegate the request!
			contentAssistant.showPossibleCompletions();

			((ContentAssistant) contentAssistant).addCompletionListener(this);
		}
	}

	/**
	 * Open the proposal popup and display the proposals provided by the
	 * proposal provider. This method returns immediately. That is, it does not
	 * wait for a proposal to be selected. This method is used by subclasses to
	 * explicitly invoke the opening of the popup. If there are no proposals to
	 * show, the popup will not open and a beep will be sounded.
	 */
	protected void openProposalPopup() {
		openProposalPopup(false);
	}

	/*
	 * Check that the control and content adapter are valid.
	 */
	private boolean isValid() {
		return control != null && !control.isDisposed();
	}

	/**
	 * Autoactivation has been triggered. Open the popup using any specified
	 * delay.
	 */
	private void autoActivate() {
		if (autoActivationDelay > 0) {
			Runnable runnable = new Runnable() {
				public void run() {
					receivedKeyDown = false;
					try {
						Thread.sleep(autoActivationDelay);
					} catch (InterruptedException e) {
					}
					if (!isValid() || receivedKeyDown) {
						return;
					}
					getControl().getDisplay().syncExec(new Runnable() {
						public void run() {
							openProposalPopup(true);
						}
					});
				}
			};
			Thread t = new Thread(runnable);
			t.start();
		} else {
			// Since we do not sleep, we must open the popup
			// in an async exec. This is necessary because
			// this method may be called in the middle of handling
			// some event that will cause the cursor position or
			// other important info to change as a result of this
			// event occurring.
			getControl().getDisplay().asyncExec(new Runnable() {
				public void run() {
					if (isValid()) {
						openProposalPopup(true);
					}
				}
			});
		}
	}

	/*
	 * The proposal popup has opened. Notify interested listeners.
	 */
	private void notifyPopupOpened() {
		if (DEBUG) {
			System.out.println("Notify listeners - popup opened."); //$NON-NLS-1$
		}
		final Object[] listenerArray = proposalListeners2.getListeners();
		for (int i = 0; i < listenerArray.length; i++) {
			((ICompletionProposalListener) listenerArray[i])
					.proposalPopupOpened(this);
		}
	}

	/*
	 * The proposal popup has closed. Notify interested listeners.
	 */
	private void notifyPopupClosed() {
		if (DEBUG) {
			System.out.println("Notify listeners - popup closed."); //$NON-NLS-1$
		}
		final Object[] listenerArray = proposalListeners2.getListeners();
		for (int i = 0; i < listenerArray.length; i++) {
			((ICompletionProposalListener) listenerArray[i])
					.proposalPopupClosed(this);
		}
	}

	/**
	 * Answers a boolean indicating whether the main proposal popup is open.
	 * 
	 * @return <code>true</code> if the proposal popup is open, and
	 *         <code>false</code> if it is not.
	 * 
	 * @since 3.6
	 */
	public boolean isProposalPopupOpen() {
		if (isValid() && isProposalPopupActive())
			return true;
		return false;
	}

	/**
	 * @return <code>true</code> if the content assistant has the completion
	 *         proposal popup open; <code>false</code> otherwise.
	 */
	private boolean isProposalPopupActive() {
		/*
		 * Unfortunately, the method is protected so we use java reflection to
		 * access it.
		 */
		try {
			final Method m = ContentAssistant.class
					.getDeclaredMethod("isProposalPopupActive");
			m.setAccessible(true);
			try {
				final Object result = m.invoke(contentAssistant);
				if (result != null && result instanceof Boolean) {
					return (Boolean) result;
				} else {
					throw new IllegalStateException(
							"Method is expected to return boolean!");
				}
			} catch (InvocationTargetException e) {
				throw e.getCause(); // cause was thrown by method m.
			}
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}

	public void assistSessionStarted(ContentAssistEvent event) {
		notifyPopupOpened();
	}

	public void assistSessionEnded(ContentAssistEvent event) {
		notifyPopupClosed();
	}

	public void selectionChanged(ICompletionProposal proposal,
			boolean smartToggle) {
		// do nothing
	}

}
