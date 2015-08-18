package org.yakindu.base.xtext.utils.jface.viewers.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Get the last active editor in general or of a specific type.
 * 
 * Please note that the ActiveEditorTracker currently only supports one single
 * workbench window properly.
 * 
 * @author patrick.koenemann@itemis.de
 * @author alexander.nyssen@itemis.de
 * 
 */
public class ActiveEditorTracker implements IPageListener, IPartListener,
		IStartup, IWindowListener {

	private static final String SINGLETON_MSG = "This class is a singleton and may only be instantiated once!";

	private IWorkbenchWindow workbenchWindow;

	private Map<String, IEditorPart> activeEditors = new HashMap<String, IEditorPart>();

	private String lastActiveEditorId;

	private IWorkbenchPage activePage;

	private static ActiveEditorTracker INSTANCE;

	public ActiveEditorTracker() {
		if (INSTANCE != null)
			throw new IllegalStateException(SINGLETON_MSG);
		INSTANCE = this;
	}

	public void earlyStartup() {
		PlatformUI.getWorkbench().addWindowListener(this);
	}

	/**
	 * @return The last active editor in the current active workbench page.
	 */
	public static IEditorPart getLastActiveEditor() {
		if (INSTANCE == null) {
			// not yet initialized, e.g. when another early startups blocks us!
			// Let's try to get the current active editor instead.
			if (PlatformUI.getWorkbench() != null) {
				if (PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null) {
					return PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().getActiveEditor();
				}
			}
			return null;
		}
		return INSTANCE.getLastActiveEditorInternal();
	}

	/**
	 * @return The last active editor with the given editor ID in the current
	 *         active workbench page.
	 */
	public static IEditorPart getLastEditor(String editorId) {
		if (INSTANCE == null) {
			// not yet initialized, e.g. when another early startups blocks us!
			// Let's try to get any editor with the specified id instead.
			if (PlatformUI.getWorkbench() != null) {
				final IWorkbenchWindow window = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow();
				if (window != null) {
					final IWorkbenchPage page = window.getActivePage();
					if (page != null) {
						for (IEditorReference ref : page.getEditorReferences()) {
							if (ref.getId().equals(editorId)) {
								return ref.getEditor(false);
							}
						}
					}
				}
			}
			return null;
		}
		return INSTANCE.getEditorById(editorId);
	}

	/**
	 * 
	 * @return The EMF resource set of the last active editor (if it is still
	 *         open).
	 */
	public static ResourceSet getLastActiveEditorResourceSet() {
		final IEditorPart editor = getLastActiveEditor();
		if (editor == null)
			return null;
		EditingDomain domain = null;
		if (editor instanceof IEditingDomainProvider) {
			domain = ((IEditingDomainProvider) editor).getEditingDomain();
		} else if (editor.getAdapter(IEditingDomainProvider.class) != null) {
			domain = ((IEditingDomainProvider) editor
					.getAdapter(IEditingDomainProvider.class))
					.getEditingDomain();
		} else if (editor.getAdapter(EditingDomain.class) != null) {
			domain = (EditingDomain) editor.getAdapter(EditingDomain.class);
		}
		if (domain == null) {
			return null;
		}

		return domain.getResourceSet();
	}

	/**
	 * @return The project which contains the file that is open in the last
	 *         active editor in the current workbench page.
	 */
	public static IProject getLastActiveEditorProject() {
		final IEditorPart editor = getLastActiveEditor();
		if (editor == null)
			return null;
		final IEditorInput editorInput = editor.getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			final IFileEditorInput input = (IFileEditorInput) editorInput;
			return input.getFile().getProject();
		}
		return null;
	}

	public void pageActivated(IWorkbenchPage page) {
		this.activePage = page;
	}

	public void pageClosed(IWorkbenchPage page) {
		if (page == activePage) {
			activePage = null;
		}
		lastActiveEditorId = null;
	}

	public void pageOpened(IWorkbenchPage page) {
		// do nothing
	}

	public void partActivated(IWorkbenchPart part) {
		if (part instanceof IEditorPart) {
			setActiveEditor((IEditorPart) part);
		}
	}

	public void partBroughtToTop(IWorkbenchPart part) {
		if (part instanceof IEditorPart) {
			setActiveEditor((IEditorPart) part);
		}
	}

	public void partClosed(IWorkbenchPart part) {
		if (part instanceof IEditorPart) {
			String id = null;
			for (Entry<String, IEditorPart> entry : activeEditors.entrySet()) {
				if (entry.getValue().equals(part)) {
					id = entry.getKey();
					break;
				}
			}
			if (id != null) {
				activeEditors.remove(id);
				if (id.equals(lastActiveEditorId)) {
					lastActiveEditorId = null;
				}
			}
		}
	}

	public void partDeactivated(IWorkbenchPart part) {
		if (part instanceof IEditorPart) {
			// do nothing
		}
	}

	private IEditorPart getLastActiveEditorInternal() {
		if (activePage == null) {
			initialize(PlatformUI.getWorkbench().getActiveWorkbenchWindow());
			if (activePage == null)
				return null;
		}
		boolean updated = false;
		if (lastActiveEditorId == null) {
			final IEditorPart editor = activePage.getActiveEditor();
			if (editor != null) {
				setActiveEditor(editor);
			}
			updated = true;
		}
		IEditorPart editor = getEditorById(lastActiveEditorId);
		if (editor == null && !updated) {
			editor = activePage.getActiveEditor();
			if (editor != null) {
				setActiveEditor(editor);
			}
		}
		return editor;
	}

	private IEditorPart getEditorById(String editorId) {
		if (activePage == null || editorId == null)
			return null;
		final IEditorPart editor = activeEditors.get(editorId);
		final String id = checkEditorAndGetId(editor);
		if (id != null && id.equals(editorId)) {
			return editor;
		}
		return null;
	}

	private String checkEditorAndGetId(IEditorPart editor) {
		if (editor == null)
			return null;
		for (IEditorReference ref : activePage.getEditorReferences()) {
			if (editor.equals(ref.getEditor(false))) {
				return ref.getId();
			}
		}
		return null;
	}

	public IWorkbenchPage getActivePage() {
		return activePage;
	}

	/**
	 * Set the active editor
	 */
	private void setActiveEditor(IEditorPart part) {
		if (part == null) {
			lastActiveEditorId = null;
			return;
		}
		final IWorkbenchPartReference reference = activePage.getReference(part);
		if (reference == null)
			throw new IllegalStateException("Impossible?!");
		lastActiveEditorId = reference.getId();
		activeEditors.put(lastActiveEditorId, part);
	}

	public void partOpened(IWorkbenchPart part) {
		if (part instanceof IEditorPart) {
			setActiveEditor((IEditorPart) part);
		}
	}

	public void dispose() {
		if (workbenchWindow == null) {
			return;
		}
		workbenchWindow.removePageListener(this);
		workbenchWindow.getPartService().removePartListener(this);
		workbenchWindow = null;
	}

	public void windowActivated(IWorkbenchWindow window) {
		initialize(window);
	}

	protected void initialize(IWorkbenchWindow window) {
		if (workbenchWindow != null && !workbenchWindow.equals(window)) {
			/*
			 * TODO: implement logic for keeping track of editors in multiple
			 * workbench windows!
			 */
		}
		this.workbenchWindow = window;
		if (window == null)
			return;
		this.activePage = window.getActivePage();
		final IEditorPart editor = this.activePage.getActiveEditor();
		if (editor != null) {
			lastActiveEditorId = checkEditorAndGetId(editor);
			activeEditors.put(lastActiveEditorId, editor);
		}
		window.addPageListener(this);
		window.getPartService().addPartListener(this);
	}

	public void windowDeactivated(IWorkbenchWindow window) {
		// not of interest
	}

	public void windowClosed(IWorkbenchWindow window) {
		dispose();
	}

	public void windowOpened(IWorkbenchWindow window) {
		// not of interest
	}
}