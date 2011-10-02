/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.dialogs;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.dialogs.NewWizard;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.StatechartImages;

/**
 * Basic resource selection dialog for Statecharts with a link that opens the
 * new project wizard.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SelectSubmachineDialog extends WorkspaceResourceDialog {

	public final static int CLEAR_BUTTON = IDialogConstants.CLIENT_ID + 1;

	private final ViewerFilter filter;

	private boolean clearSelected = false;

	public SelectSubmachineDialog(Shell parent, ViewerFilter filter) {
		super(parent, new WorkbenchLabelProvider(),
				new WorkbenchContentProvider());
		this.filter = filter;
		initDialog();
	}

	protected void initDialog() {
		setAllowMultiple(false);
		setTitle("Select Submachine");
		setMessage("Select the Submachine to include include into the Submachine State.");
		setImage(StatechartImages.LOGO.image());
		addFilter(filter);
		loadContents();
		clearSelected = false;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, CLEAR_BUTTON, "None", false);
		super.createButtonsForButtonBar(parent);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		Link link = new Link(composite, SWT.NONE);
		link.setText("Open the new project wizard to <a>create new statechart</a>.");
		link.addListener(SWT.Selection, new OpenCreationWizardListener(
				getSelection()));
		return composite;
	}

	private IStructuredSelection getSelection() {
		return new StructuredSelection(getSelectedContainers());
	}

	public Statechart getSelectedSubmachine() {
		Object[] result = getResult();
		if (result.length == 1 && result[0] instanceof IFile) {
			IFile selectedFile = (IFile) result[0];
			return loadFromFile(selectedFile);
		}
		return null;
	}

	public static Statechart loadFromFile(IFile fileResource) {
		URI platformURI = URI.createPlatformResourceURI(fileResource
				.getFullPath().toString(), true);
		Factory factory = ResourceFactoryRegistryImpl.INSTANCE
				.getFactory(platformURI);
		Resource resource = factory.createResource(platformURI);
		if (resource == null)
			return null;
		try {
			resource.load(Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Statechart statechart = (Statechart) EcoreUtil.getObjectByType(
				resource.getContents(), SGraphPackage.Literals.STATECHART);
		return statechart;
	}

	protected static class OpenCreationWizardListener implements Listener {

		private final IStructuredSelection selection;

		public OpenCreationWizardListener(IStructuredSelection selection) {
			this.selection = selection;
		}

		public void handleEvent(Event event) {
			NewWizard wizard = new NewWizard();
			wizard.init(PlatformUI.getWorkbench(), selection);
			WizardDialog wd = new WizardDialog(Display.getDefault()
					.getActiveShell(), wizard);
			wd.setTitle(wizard.getWindowTitle());
			IDialogSettings workbenchSettings = IDEWorkbenchPlugin.getDefault()
					.getDialogSettings();
			IDialogSettings wizardSettings = workbenchSettings
					.getSection("NewWizardAction"); //$NON-NLS-1$
			if (wizardSettings == null) {
				wizardSettings = workbenchSettings
						.addNewSection("NewWizardAction"); //$NON-NLS-1$
			}
			wizard.setDialogSettings(wizardSettings);
			wizard.setForcePreviousAndNextButtons(true);
			wd.open();
		}
	}

	public static class StatechartViewerFilter extends ViewerFilter {

		private final String fileExtension;

		public StatechartViewerFilter(String fileExtension) {
			this.fileExtension = fileExtension;
		}

		public StatechartViewerFilter(EObject eobject) {
			this.fileExtension = eobject.eResource().getURI().fileExtension();
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {
			if (element instanceof IFile) {
				return ((IFile) element).getFileExtension().endsWith(
						fileExtension);
			}
			return true;
		}
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == CLEAR_BUTTON) {
			clearPressed();
		} else {
			super.buttonPressed(buttonId);
		}
	}

	protected void clearPressed() {
		clearSelected = true;
		setReturnCode(OK);
		close();
	}

	public boolean isClearSelected() {
		return clearSelected;
	}
}