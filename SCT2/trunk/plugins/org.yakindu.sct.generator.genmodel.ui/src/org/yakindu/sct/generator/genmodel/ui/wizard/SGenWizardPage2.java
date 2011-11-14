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

import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
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
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class SGenWizardPage2 extends WizardPage {

	protected static final Object STATECHART_FILE_EXTEMSION = "sct";
	private ComboViewer generators;
	protected CheckboxTreeViewer statecharts;
	private final IResourceDescriptions resourceDescriptions;
	private final SGenWizardPage1 fileSelectionPage;

	/**
	 * @param pageName
	 * @param resourceDescriptions
	 * @param selection
	 */
	protected SGenWizardPage2(String pageName,
			IResourceDescriptions resourceDescriptions,
			SGenWizardPage1 fileSelectionPage) {
		super(pageName);
		this.resourceDescriptions = resourceDescriptions;
		this.fileSelectionPage = fileSelectionPage;
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
		statecharts.setContentProvider(new ITreeContentProvider() {

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				// TODO Auto-generated method stub

			}

			@Override
			public void dispose() {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean hasChildren(Object element) {
				return element instanceof IProject;
			}

			@Override
			public Object getParent(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof IFolder) {
					return new Object[] { ((IFolder) inputElement).getProject() };
				}
				if (inputElement instanceof IProject) {
					return findStatecharts((IProject) inputElement).toArray();
				}
				return new Object[] {};
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				if (parentElement instanceof IProject) {
					return findStatecharts((IProject) parentElement).toArray();
				}
				return new Object[] {};
			}
		});
		statecharts.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof IResource) {
					return ((IResource) element).getFullPath().toString();
				}
				return super.getText(element);
			}
		});
		statecharts.addCheckStateListener(new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				Object element = event.getElement();
				if (element instanceof IProject) {
					statecharts.setSubtreeChecked(element, event.getChecked());
				}
				checkComplete();

			}
		});
		// statecharts.addDoubleClickListener(new IDoubleClickListener() {
		//
		// @Override
		// public void doubleClick(DoubleClickEvent event) {
		// IStructuredSelection selection = (IStructuredSelection)
		// event.getSelection();
		// Object firstElement = selection.getFirstElement();
		// if (firstElement instanceof IProject) {
		// boolean expanded = statecharts
		// .getExpandedState(firstElement);
		// statecharts.setExpandedState(firstElement, !expanded);
		// }
		//
		// }
		// });
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

	/**
	 * @param inputElement
	 * @return
	 */
	protected List<IResource> findStatecharts(IProject project) {
		final List<IResource> statecharts = Lists.newArrayList();
		try {
			project.accept(new IResourceVisitor() {

				@Override
				public boolean visit(IResource resource) throws CoreException {
					if (resource.getType() == IResource.FILE
							&& STATECHART_FILE_EXTEMSION.equals(resource
									.getFileExtension())) {
						statecharts.add(resource);
					}
					return resource.getType() == IResource.FOLDER
							|| resource.getType() == IResource.PROJECT;
				}
			});
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statecharts;
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			IPath containerPath = fileSelectionPage.getFilePath();
			IFolder folder = ResourcesPlugin.getWorkspace().getRoot()
					.getFolder(containerPath);
			statecharts.setInput(folder);
			checkComplete();
		}

	}

	List<Statechart> getStatechars() {
		return Collections.emptyList();
	}

	protected void checkComplete() {
		setPageComplete(validatePage());
	}

	protected boolean validatePage() {
		return statecharts.getCheckedElements().length > 0
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
