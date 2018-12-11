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
package org.yakindu.sct.generator.builder.resources;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.yakindu.sct.generator.builder.BuilderActivator;

/**
 * @author johannes dicks - Initial contribution and API
 */
public class BuilderPropertyPage extends PropertyPage {
	
	private DefaultResourceBlacklist blacklist;
	private TableViewer blackListViewer;
	private List<IResource> values;
	
	public BuilderPropertyPage() {
		super();
		blacklist = new DefaultResourceBlacklist();
	}
	
	@Override
	protected Control createContents(Composite parent) {
		Group group = createGroup(parent);
		createBlacklist(group);
		return group;
	}
	
	protected void createBlacklist(final Composite parent) {
		blackListViewer = createBlackListViewer(parent);
		
		Composite btnComposite = new Composite(parent, SWT.None);
		btnComposite.setLayout(new GridLayout(1, false));
		GridDataFactory.fillDefaults().grab(false, true).align(GridData.CENTER, GridData.BEGINNING)
		.applyTo(btnComposite);
		addAddBtn(btnComposite);
		addRemoveBtn(btnComposite);
		
	}
	
	protected Group createGroup(final Composite blacklistComposite) {
		Group group = new Group(blacklistComposite, SWT.None);
		group.setText("Exclude generator models");
		group.setLayout(new GridLayout(2, false));
		GridDataFactory.fillDefaults().grab(true, true).applyTo(group);
		return group;
	}
	
	protected TableViewer createBlackListViewer(Composite group) {
		TableViewer result = new TableViewer(group, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		result.getTable().setLinesVisible(true);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(result.getControl());
		result.setContentProvider(new ArrayContentProvider());
		result.setLabelProvider(new WorkbenchLabelProvider());
		values = blacklist.getValues(getActualProject());
		result.setInput(values);
		return result;
	}
	
	protected void addAddBtn(final Composite btnComposite) {
		Button add = new Button(btnComposite, SWT.FLAT);
		GridDataFactory.fillDefaults().grab(true, false).hint(100, SWT.DEFAULT).applyTo(add);
		add.setText("Add...");
		add.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(btnComposite.getShell(),
						new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());
				
				dialog.setValidator(new CheaderBlacklistSelectionStatusValidator());
				
				dialog.setTitle("Add blacklist item");
				dialog.setMessage("Select a blacklist item:");
				dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
				dialog.addFilter(new CHeaderViewerFilter(getActualProject()));
				
				if (!values.isEmpty())
					dialog.setInitialSelection(values.get(values.size() - 1));
				
				dialog.setDialogBoundsSettings(BuilderActivator.getDefault().getDialogSettings(),
						Dialog.DIALOG_PERSISTLOCATION);
				dialog.open();
				Object[] result = dialog.getResult();
				if (result != null) {
					for (Object selection : result) {
						if (selection instanceof IResource) {
							values.add((IResource) selection);
						}
					}
					blackListViewer.refresh();
				}
			}
		});
		
	}
	
	protected void addRemoveBtn(Composite btnComposite) {
		Button remove = new Button(btnComposite, SWT.FLAT);
		GridDataFactory.fillDefaults().grab(true, false).hint(100, SWT.DEFAULT).applyTo(remove);
		remove.setText("Remove");
		remove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				ISelection selection = blackListViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					@SuppressWarnings("unchecked")
					Iterator<IResource> iterator = ((IStructuredSelection) selection).iterator();
					while (iterator.hasNext()) {
						IResource object = iterator.next();
						values.remove(object);
					}
					blackListViewer.refresh();
				}
			}
		});
	}
	
	@Override
	protected void performDefaults() {
		super.performDefaults();
		values.clear();
		blackListViewer.refresh();
	}
	
	@Override
	public boolean performOk() {
		IProject project = getActualProject();
		@SuppressWarnings("unchecked")
		List<IResource> input = (List<IResource>) blackListViewer.getInput();
		boolean save = blacklist.save(project, input);
		return save;
		
	}
	
	private IProject getActualProject() {
		// cast necessary for Luna, in Mars&Neon getAdapter is generic
		return getElement().getAdapter(IProject.class);
	}
	
	protected final class CheaderBlacklistSelectionStatusValidator implements ISelectionStatusValidator {
		@Override
		public IStatus validate(Object[] selection) {
			for (Object object : selection) {
				if (object instanceof IProject) {
					return new Status(IStatus.ERROR, BuilderActivator.PLUGIN_ID,
							"Project can not be selected.");
				}
				if (values.contains(object)) {
					return new Status(IStatus.ERROR, BuilderActivator.PLUGIN_ID,
							"Can not add duplicate.");
				}
			}
			return Status.OK_STATUS;
		}
	}
	
	protected final class CHeaderViewerFilter extends ViewerFilter {
		private IResource actualProject;
		
		public CHeaderViewerFilter(IResource project) {
			this.actualProject = project;
		}
		
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			// just show files of the current project
			if (element instanceof IResource) {
				IResource resource = (IResource) element;
				IProject projectOfResource = resource.getProject();
				if (!projectOfResource.equals(actualProject)) {
					return false;
				}
			}
			// just show header files
			if (element instanceof IFile) {
				IFile iFile = (IFile) element;
				if (!getFileExtension().equals(iFile.getFileExtension())) {
					return false;
				}
			}
			
			return true;
		}
		
	}
	protected String getFileExtension() {
		return "sgen";
	}
	
	protected static class ResourceLabelProvider extends LabelProvider {
		
		@Override
		public String getText(Object element) {
			if (element instanceof IResource) {
				IResource iResource = (IResource) element;
				return iResource.getFullPath().toPortableString();
			}
			
			return super.getText(element);
		}
		
		@Override
		public Image getImage(Object element) {
			ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
			return element instanceof IFile
					? sharedImages.getImage(ISharedImages.IMG_OBJ_FILE)
							: sharedImages.getImage(ISharedImages.IMG_OBJ_FOLDER);
		}
	}
}