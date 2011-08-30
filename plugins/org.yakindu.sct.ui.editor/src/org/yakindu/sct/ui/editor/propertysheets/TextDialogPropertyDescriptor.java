/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *         itemis AG - initial API and implementation
 *
 */
package org.yakindu.sct.ui.editor.propertysheets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;

import de.itemis.gmf.runtime.commons.properties.descriptors.AbstractPropertyDescriptor;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TextDialogPropertyDescriptor extends AbstractPropertyDescriptor {

	private EObject eObject;
	private Label text;

	public TextDialogPropertyDescriptor(EStructuralFeature feature,
			String labelName) {
		super(feature, labelName);
	}

	@Override
	protected Control createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(composite);
		composite.setBackground(ColorConstants.white);
		GridLayout layout = new GridLayout(2, false);
		layout.marginLeft = 0;
		layout.marginRight = 0;
		composite.setLayout(layout);
		text = new Label(composite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(text);
		Button openDialog = new Button(composite, SWT.NONE);
		GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 10)
				.applyTo(openDialog);
		openDialog.setText("...");

		openDialog.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent arg0) {
				ResourceDialog dialog = new ResourceDialog(new Shell(),
						"Title", SWT.SINGLE | SWT.OPEN);

				if (dialog.open() == Dialog.OK) {
					List<URI> urIs = dialog.getURIs();
					if (urIs.size() == 1) {
						String string = urIs.get(0).toString();
						Statechart statechart = loadFromResource(string);
						if (statechart != null) {
							executeSetCommand(new SetRequest(
									eObject,
									SGraphPackage.Literals.STATE__SUBSTATECHART,
									statechart));
							getControl().setText(string);
						}
					}
				}
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		return text;
	}

	protected void executeSetCommand(SetRequest request) {
		SetValueCommand command = new SetValueCommand(request);
		System.out.println("Can execute: " + command.canExecute());
		IOperationHistory operationHistory = OperationHistoryFactory
				.getOperationHistory();
		try {
			operationHistory.execute(command, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Label getControl() {
		return (Label) super.getControl();
	}

	@Override
	protected IObservableValue getWidgetValue() {
		return WidgetProperties.text(SWT.Modify | SWT.FocusOut).observe(
				getControl());
	}

	@Override
	public void bindToModel(EObject eObject) {
		this.eObject = eObject;
		State state = (State) eObject;
		Statechart substatechart = state.getSubstatechart();
		//TODO: Handle unresolvable proxy
		if (substatechart != null && !substatechart.eIsProxy())
			text.setText(substatechart.eResource().getURI().toString());

	}

	private Statechart loadFromResource(String resourceUriString) {
		String uri = (String) resourceUriString;
		if (uri == null || uri.trim().length() == 0)
			return null;
		URI platformURI = URI.createURI(uri, true);
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

}
