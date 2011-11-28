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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.internal.dialogs.NewWizard;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.ui.Activator;
import org.yakindu.sct.ui.editor.StatechartImages;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Injector;

/**
 * Basic resource selection dialog for Statecharts with a link that opens the
 * new project wizard.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SelectSubmachineDialog extends ElementListSelectionDialog {

	public final static int CLEAR_BUTTON = IDialogConstants.CLIENT_ID + 1;

	private boolean clearSelected = false;

	private EObject context;

	private final Resource resource;

	public SelectSubmachineDialog(Shell parent, Resource resource) {
		super(parent, getLabelProvider(resource));
		this.resource = resource;
		initDialog();
	}

	private static Injector getInjector(Resource resource) {
		return Activator.getDefault().getInjector();
	}

	private static ILabelProvider getLabelProvider(Resource resource) {
		// return new AdapterFactoryLabelProvider(
		// new SGraphItemProviderAdapterFactory());
		return getInjector(resource).getInstance(ILabelProvider.class);
	}

	private IGlobalScopeProvider getGlobalScopeProvider(Resource resource) {
		return getInjector(resource).getInstance(IGlobalScopeProvider.class);
	}

	private Object[] getStatemachines(EObject context) {
		IScope scope = getGlobalScopeProvider(resource).getScope(
				context.eResource(),
				SGraphPackage.Literals.STATE__SUBSTATECHART,
				Predicates.<IEObjectDescription> alwaysTrue());
		Iterable<IEObjectDescription> statecharts = scope.getAllElements();
		return Iterables.toArray(statecharts, IEObjectDescription.class);
	}

	protected void initDialog() {
		setTitle("Select Submachine");
		setMessage("Select the Submachine to include include into the Submachine State.");
		setImage(StatechartImages.LOGO.image());
		clearSelected = false;
	}

	@Override
	public void setElements(Object[] elements) {
		if (elements == null || elements.length != 1) {
			throw new IllegalStateException("No element was given");
		}
		Object object = elements[0];
		if (!(object instanceof EObject)) {
			throw new IllegalStateException("The element must be an EObject");
		}
		EObject element = (EObject) object;
		this.context = element;
		super.setElements(getStatemachines(element));
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

	@SuppressWarnings("rawtypes")
	@Override
	protected List getInitialElementSelections() {
		if (context instanceof Statechart) {
			return Collections.singletonList(context);
		}
		return super.getInitialElementSelections();
	}

	private IStructuredSelection getSelection() {
		QualifiedName selectedSubmachine = getSelectedSubmachine();
		if (selectedSubmachine != null) {
			return new StructuredSelection(selectedSubmachine);
		} else {
			return StructuredSelection.EMPTY;
		}

	}

	public QualifiedName getSelectedSubmachine() {
		Object[] result = getResult();
		if (result != null && result.length == 1) {
			QualifiedName statechart = null;
			if (result[0] instanceof IEObjectDescription) {
				statechart = ((IEObjectDescription) result[0])
						.getQualifiedName();
			}
			return statechart;
		}
		return null;
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