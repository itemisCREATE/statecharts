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
package org.yakindu.sct.generator.genmodel.ui.wizard;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;

import com.google.common.collect.Iterables;

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class SGenWizardPage2 extends WizardPage {

	private ComboViewer generators;
	private CheckboxTreeViewer statecharts;
	private final IResourceDescriptions resourceDescriptions;

	/**
	 * @param pageName
	 * @param resourceDescriptions
	 */
	protected SGenWizardPage2(String pageName,
			IResourceDescriptions resourceDescriptions) {
		super(pageName);
		this.resourceDescriptions = resourceDescriptions;
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(1, false));

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1));
		lblNewLabel.setText("Statecharts");

		statecharts = new CheckboxTreeViewer(container, SWT.BORDER);
		statecharts.getTree().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Label lblGenerator = new Label(container, SWT.NONE);
		lblGenerator.setText("Generator");

		generators = new ComboViewer(container, SWT.READ_ONLY);
		generators.getCombo().setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		generators.setLabelProvider(new GeneratorDescriptorLabelProvider());
		generators.setContentProvider(new ArrayContentProvider());
		GeneratorDescriptor[] generatorArray = Iterables.toArray(
				GeneratorExtensions.getGeneratorDescriptors(),
				GeneratorDescriptor.class);
		generators.setInput(generatorArray);
		generators.getCombo().select(0);

		checkComplete();

	}

	protected void checkComplete() {
		setPageComplete(validatePage());
	}

	protected boolean validatePage() {
		return !statecharts.getSelection().isEmpty()
				&& !generators.getSelection().isEmpty();
	}

	public String getGeneratorId() {
		return ((GeneratorDescriptor) ((StructuredSelection) generators
				.getSelection()).getFirstElement()).getId();
	}

	private static class GeneratorDescriptorLabelProvider extends LabelProvider {

		GeneratorDescriptorLabelProvider() {
			super();
		}

		@Override
		public String getText(Object element) {
			if (element instanceof GeneratorDescriptor) {
				return ((GeneratorDescriptor) element).getName();
			}
			return super.getText(element);
		}

		@Override
		public Image getImage(Object element) {
			if (element instanceof GeneratorDescriptor) {
				return ((GeneratorDescriptor) element).getImage();
			}
			return super.getImage(element);
		}

	}
}
