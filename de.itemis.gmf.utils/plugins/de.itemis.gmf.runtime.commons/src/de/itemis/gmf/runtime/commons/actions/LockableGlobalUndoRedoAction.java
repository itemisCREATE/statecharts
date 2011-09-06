package de.itemis.gmf.runtime.commons.actions;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.operations.OperationHistoryActionHandler;

import de.itemis.gmf.runtime.commons.actions.ILockableAction;

/**
 * Code is based on {@link GlobalUndoAction} and {@link GlobalRedoAction} merged
 * to an abstract class to avoid duplicate code and extended to deal with
 * editors which support yakindu simulation.
 * 
 * @author muehlbrandt
 * 
 */
public abstract class LockableGlobalUndoRedoAction extends GlobalAction implements ILockableAction {

	/**
	 * My operation framework action handler delegate.
	 */
	private OperationHistoryActionHandler delegate;

	/**
	 * My undo context.
	 */
	private IUndoContext undoContext;

	/**
	 * Property change listener to listen for changes in my delegate.
	 */
	private IPropertyChangeListener listener;

	/**
	 * Flag to block the execution of this action if simulation is enabled
	 */
	private boolean isLocked = false;
	
	/**
	 * Initializes me with a workbench page.
	 * 
	 * @param workbenchPage
	 *            the page
	 */
	
	public LockableGlobalUndoRedoAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
	}

	/**
	 * Initilizes me with a workbench part.
	 * 
	 * @param workbenchPart
	 *            the part
	 */
	public LockableGlobalUndoRedoAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);
	}

	/**
	 * Extends the superclass implementation to update the operation history
	 * undo action handler to which I delegate.
	 */
	protected void setWorkbenchPart(IWorkbenchPart workbenchPart) {
		super.setWorkbenchPart(workbenchPart);
		initializeWithContext(getUndoContext());
	}
	
	protected abstract OperationHistoryActionHandler getOperationHistoryActionHandler(IWorkbenchPartSite site, IUndoContext context);
	
    /**
     * Initializes me with a new undo <code>context</code>.
     * 
     * @param context
     *            the undo context
     */
    protected void initializeWithContext(IUndoContext context) {
		if (delegate != null) {
			delegate.removePropertyChangeListener(getDelegateListener());
			delegate.dispose();
			delegate = null;
		}

		if (context != null) {
			IWorkbenchPart part = getWorkbenchPart();

			if (part != null) {
				delegate = getOperationHistoryActionHandler(part.getSite(), context);
				delegate.setPruneHistory(true);
				delegate.addPropertyChangeListener(getDelegateListener());
			}
		}
		
		// force enablement update in UI
		boolean enabled = isEnabled();
		firePropertyChange(IAction.ENABLED, Boolean.valueOf(!enabled), Boolean
				.valueOf(enabled));
    }

	/**
	 * Gets my property change listener to listen for changes in my delegate.
	 */
	private IPropertyChangeListener getDelegateListener() {
		if (listener == null) {
			listener = new IPropertyChangeListener() {

				public void propertyChange(PropertyChangeEvent event) {
					// propagate to my own listeners
					firePropertyChange(event.getProperty(),
							event.getOldValue(), event.getNewValue());
				}
			};
		}
		return listener;
	}

	/**
	 * Delegates to the operation framework action handler.
	 */
	public ImageDescriptor getImageDescriptor() {
		if (delegate != null) {
			return delegate.getImageDescriptor();
		} else {
			return null;
		}
	}

	/**
	 * Delegates to the operation framework action handler.
	 */
	public ImageDescriptor getDisabledImageDescriptor() {
		if (delegate != null) {
			return delegate.getDisabledImageDescriptor();
		} else {
			return null;
		}
	}

	/**
	 * Delegates to the operation framework action handler.
	 */
	public ImageDescriptor getHoverImageDescriptor() {
		if (delegate != null) {
			return delegate.getHoverImageDescriptor();
		} else {
			return null;
		}
	}

	/**
	 * Delegates to the operation framework action handler.
	 */
	public String getText() {
		if (delegate != null) {
			return delegate.getText();
		} else {
			return null;
		}
	}

	/**
	 * Delegates to the operation framework action handler.
	 */
	public String getToolTipText() {
		if (delegate != null) {
			return delegate.getToolTipText();
		} else {
			return null;
		}
	}

	/**
	 * Delegates to the operation framework action handler.
	 */
	public String getDescription() {
		if (delegate != null) {
			return delegate.getDescription();
		} else {
			return null;
		}
	}

	/**
	 * Delegates to the operation framework action handler.
	 */
	public boolean isEnabled() {
		if (delegate != null) {
			return delegate.isEnabled();
		}
		return false;
	}

	/**
	 * Delegates to the operation framework action handler.
	 */
	public boolean isHandled() {
		if (delegate != null) {
			return delegate.isHandled();
		} else {
			return false;
		}
	}

	/**
	 * Delegates to the operation framework action handler.
	 */
	public void setChecked(boolean checked) {
		if (delegate != null) {
			delegate.setChecked(checked);
		}
	}

	/**
	 * Delegates to the operation framework action handler.
	 */
	protected void doRun(IProgressMonitor progressMonitor) {
		if (delegate != null && !isLocked) {
			Object key = new Object();
			if (GlobalUndoRedoLock.INSTANCE.acquire(key)) {
				try {
					delegate.run();
				} finally {
					GlobalUndoRedoLock.INSTANCE.release(key);
				}
			}
		}
	}

	/**
	 * Delegates to the operation framework action handler.
	 */
	public void refresh() {
		if (delegate != null) {
			delegate.update();
		}
		setText(getText());
	}

	/**
	 * Sets my undo context.
	 * 
	 * @param undoContext
	 *            my undo context
	 */
	public final void setUndoContext(IUndoContext context) {
		this.undoContext = context;
		initializeWithContext(context);
	}

	/**
	 * Gets my undo context. If it has not been explicitly set, derives the undo
	 * context from my workbench part.
	 * 
	 * @return my undo context. May be <code>null</code> if no one has set my
	 *         undo context and my workbench part does not adapt to
	 *         {@link IUndoContext}.
	 */
	public final IUndoContext getUndoContext() {

		if (undoContext == null) {
			IWorkbenchPart part = getWorkbenchPart();

			if (part != null) {
				return (IUndoContext) part.getAdapter(IUndoContext.class);
			}
		}
		return undoContext;
	}

	/**
	 * Listens to the operation history events.
	 */
	protected boolean isOperationHistoryListener() {
		return true;
	}

    /**
     * Sets my delegate to <code>null</code>.
     */
	public void dispose() {

		if (delegate != null) {
            // Doesn't call delegate.dispose() because the delegate is itself a
            // part listener and will dispose of itself when its part closes.
            // See https://bugs.eclipse.org/bugs/show_bug.cgi?id=131781
			delegate.removePropertyChangeListener(getDelegateListener());
			delegate = null;
		}

		super.dispose();
	}
	
	/**
	 * No work indicator type since my delegate takes care of showing progress.
	 */
	public WorkIndicatorType getWorkIndicatorType() {
		return WorkIndicatorType.NONE;
	}

	public void setLocked(Boolean lock) {
		isLocked = lock;
	}
}
