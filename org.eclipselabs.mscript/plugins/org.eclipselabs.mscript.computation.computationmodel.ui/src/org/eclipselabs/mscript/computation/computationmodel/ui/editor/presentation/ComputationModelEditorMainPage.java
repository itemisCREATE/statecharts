/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.computation.computationmodel.ui.editor.presentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;

/**
 * @author Andreas Unger
 *
 */
public class ComputationModelEditorMainPage {
	
	private FormToolkit toolkit;
	
	public Control createPartControl(ComputationModelEditor editor, Composite parent) {
		toolkit = new FormToolkit(parent.getDisplay());
		ScrolledForm scrolledForm = toolkit.createScrolledForm(parent);
		toolkit.decorateFormHeading(scrolledForm.getForm());
		scrolledForm.setText("Computation Model");
		
		Composite body = scrolledForm.getBody();
		GridLayout layout = new GridLayout(1, true);
		body.setLayout(layout);
				
		Composite composite = toolkit.createComposite(body);
		layout = new GridLayout();
		composite.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		composite.setLayoutData(gridData);
		
		Section section = toolkit.createSection(composite, Section.EXPANDED | Section.TITLE_BAR);
		section.setText("Number Formats");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		GridLayout gridLayout = new GridLayout();
		section.setLayout(gridLayout);
		section.setLayoutData(gridData);
		
		Table tree = toolkit.createTable(section, SWT.MULTI);
		section.setClient(tree);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		tree.setLayoutData(gridData);
		TableViewer selectionViewer = new TableViewer(tree);
		editor.setCurrentViewer(selectionViewer);
		
		EObject object = editor.getEditingDomain().getResourceSet().getResources().get(0).getContents().get(0);

		selectionViewer.setContentProvider(new ArrayContentProvider());
		selectionViewer.setLabelProvider(new AdapterFactoryLabelProvider(editor.getAdapterFactory()));
		selectionViewer.setInput(((ComputationModel) object).getNumberFormats());
		selectionViewer.setSelection(new StructuredSelection(object), true);

//		editor.createContextMenuFor(selectionViewer);

		return scrolledForm;
	}
	
	public void dispose() {
		toolkit.dispose();
	}
	
}
