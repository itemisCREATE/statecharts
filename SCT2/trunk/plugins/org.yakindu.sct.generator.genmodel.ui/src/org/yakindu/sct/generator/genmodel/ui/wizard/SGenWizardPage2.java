/**
 * Copyright (c) 2013 committers of YAKINDU and others.
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
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.yakindu.sct.generator.core.extensions.FileExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;

import com.google.common.collect.Lists;

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 * @author andreas muelder - extension point for contribution of file extensions
 *         added
 * @author oliver bohl - changed for more generic
 * 
 */
public class SGenWizardPage2 extends WizardPage {

	private final static Map<String, CoreGenerator> PROJECT_NATURES = new TreeMap<String, CoreGenerator>();
	static {
		PROJECT_NATURES.put("org.eclipse.cdt.core.cnature", CoreGenerator.C);
		PROJECT_NATURES.put("org.eclipse.cdt.core.ccnature", CoreGenerator.Cpp);
		PROJECT_NATURES.put(JavaCore.NATURE_ID, CoreGenerator.Java);
	}

	private ComboViewer generatorCombo;

	protected CheckboxTreeViewer resourceTree;

	private final SGenWizardPage1 fileSelectionPage;

	@SuppressWarnings("unused")
	private final IStructuredSelection selection;

	private Label lblNewLabel;

	protected SGenWizardPage2(String pageName, SGenWizardPage1 fileSelectionPage, IStructuredSelection selection) {
		super(pageName);
		this.fileSelectionPage = fileSelectionPage;
		this.selection = selection;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(1, false));
		createGeneratorCombo(container);
		createObjectTree(container);
		refreshInput();
	}

	private void createObjectTree(Composite container) {
		lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblNewLabel.setText("Choose: " + getSelectedGenerator().getContentType());

		resourceTree = new CheckboxTreeViewer(container, SWT.BORDER);
		resourceTree.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		resourceTree.setContentProvider(new SGenWizardPage2ContentProvider());
		resourceTree.setLabelProvider(new SGenWizardPage2LabelProvider());

		TreePropagatingCheckStateListener checkStateListener = new TreePropagatingCheckStateListener(resourceTree) {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				super.checkStateChanged(event);
			}
		};
		resourceTree.addCheckStateListener(checkStateListener);
		resourceTree.addDoubleClickListener(new TreeExpandingDoubleClickListener(resourceTree, checkStateListener));
		resourceTree.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);
		resourceTree.setFilters(new ViewerFilter[] { new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				// TODO: Filter by common navigator filter instead of supressing
				// '.' prefixed folder
				if (element instanceof IFolder) {
					return !((IFolder) element).getName().startsWith(".");
				}
				return true;
			}
		} });
	}

	private void createGeneratorCombo(Composite container) {
		Label lblGenerator = new Label(container, SWT.NONE);
		lblGenerator.setText("Generator");
		generatorCombo = new ComboViewer(container, SWT.READ_ONLY);
		generatorCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		generatorCombo.setLabelProvider(new GeneratorDescriptorLabelProvider());
		generatorCombo.setContentProvider(new ArrayContentProvider());
		List<GeneratorDescriptor> descriptors = Lists.newArrayList(GeneratorExtensions.getGeneratorDescriptors());
		Collections.sort(descriptors, CoreGenerator.generatorOrder);
		generatorCombo.setInput(descriptors);
		generatorCombo.getCombo().select(0);
		generatorCombo.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				refreshInput();
			}
		});
	}

	protected void refreshInput() {
		lblNewLabel.setText("Choose: " + getSelectedGenerator().getContentType());
		((SGenWizardPage2ContentProvider) resourceTree.getContentProvider()).setFileExtension(FileExtensions
				.getFileExtension(getSelectedGenerator().getId()));
		resourceTree.setInput(getSelectedProject());
	}

	protected IProject getSelectedProject() {
		IPath containerPath = fileSelectionPage.getFilePath();
		IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(containerPath);
		return folder.getProject();
	}

	public List<EObject> getSelectedElements() {
		List<EObject> selectedElements = Lists.newArrayList();
		Object[] checkedElements = resourceTree.getCheckedElements();
		for (Object object : checkedElements) {
			if (object instanceof IFile) {
				selectedElements.add(loadReferencedObject((IResource) object));
			}
		}
		return selectedElements;
	}

	protected EObject loadReferencedObject(IResource resource) {
		URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource emfResource = resourceSet.getResource(uri, true);

		GeneratorDescriptor desc = getSelectedGenerator();
		String className = desc.getElementRefType();

		TreeIterator<EObject> content = emfResource.getAllContents();
		List<EObject> contentList = Lists.newArrayList(content);

		for (EObject obj : contentList) {
			if (obj.eClass().getInstanceClassName().equals(className))
				return obj;
		}

		for (EObject obj : contentList) {
			List<EClass> superClasses = obj.eClass().getEAllSuperTypes();
			for (EClass superClass : superClasses) {
				if (superClass.getInstanceClassName().equals(className)) {
					return obj;
				}
			}
		}
		return null;
	}

	public GeneratorDescriptor getSelectedGenerator() {
		return (GeneratorDescriptor) ((StructuredSelection) generatorCombo.getSelection()).getFirstElement();
	}

	private static class GeneratorDescriptorLabelProvider extends LabelProvider {

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
