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

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
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
import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor;
import org.yakindu.sct.generator.genmodel.ui.PathToImageResolver;
import org.yakindu.sct.ui.install.InstallWizardOpener;
import org.yakindu.sct.ui.wizards.AbstractWorkspaceLabelProvider;
import org.yakindu.sct.ui.wizards.ModelCreationWizardPage;
import org.yakindu.sct.ui.wizards.WorkspaceTreeContentProvider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 * @author andreas muelder - extension point for contribution of file extensions
 *         added
 * @author oliver bohl - changed for more generic
 * 
 */
public class SGenWizardPage2 extends WizardPage {

	private final static Map<String, CoreGenerator> NATURE_TO_GENERATOR = new TreeMap<String, CoreGenerator>();
	static {
		NATURE_TO_GENERATOR.put("org.eclipse.cdt.core.cnature", CoreGenerator.C);
		NATURE_TO_GENERATOR.put("org.eclipse.cdt.core.ccnature", CoreGenerator.Cpp);
		NATURE_TO_GENERATOR.put(JavaCore.NATURE_ID, CoreGenerator.Java);
	}

	private ComboViewer generatorCombo;

	protected CheckboxTreeViewer resourceTree;

	private final ModelCreationWizardPage fileSelectionPage;

	@SuppressWarnings("unused")
	private final IStructuredSelection selection;

	private Label lblNewLabel;

	protected SGenWizardPage2(String pageName, ModelCreationWizardPage fileSelectionPage,
			IStructuredSelection selection) {
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
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		refreshInput();
	}

	private void createObjectTree(Composite container) {
		lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblNewLabel.setText("Choose: " + getSelectedGenerator().getContentType());

		resourceTree = new CheckboxTreeViewer(container, SWT.BORDER);
		resourceTree.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		resourceTree.setContentProvider(new WorkspaceTreeContentProvider());
		resourceTree.setLabelProvider(new SGenWorkspaceLabelProvider());

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
		List<IGeneratorDescriptor> descriptors = Lists.newArrayList(GeneratorExtensions.getGeneratorDescriptors());
		Collections.sort(descriptors, CoreGenerator.generatorOrder);
		generatorCombo.setInput(descriptors);
		generatorCombo.getCombo().select(0);
		Optional<CoreGenerator> preferredByNature = getGeneratorForNature(getContextProject());
		if (preferredByNature.isPresent()) {
			Optional<IGeneratorDescriptor> desc = descriptors.stream()
					.filter(d -> d.getId().equals(preferredByNature.get().getId())).findFirst();
			if (desc.isPresent()) {
				generatorCombo.getCombo().select(descriptors.indexOf(desc.get()));
			}
		}
		generatorCombo.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				Object element = ((IStructuredSelection) event.getSelection()).getFirstElement();
				if (element instanceof InstallMoreGeneratorsItem) {
					try {
						getContainer().run(true, true, (monitor) -> {
							((InstallMoreGeneratorsItem) element).openInstallWizard(monitor);
						});
					} catch (InvocationTargetException | InterruptedException e) {
						e.printStackTrace();
					}
					generatorCombo.getCombo().select(0);
				} else {
					refreshInput();
				}
			}

		});
		generatorCombo.add(new InstallMoreGeneratorsItem());
	}

	private Optional<CoreGenerator> getGeneratorForNature(IProject project) {
		for (Entry<String, CoreGenerator> entry : NATURE_TO_GENERATOR.entrySet()) {
			try {
				if (project.hasNature(entry.getKey())) {
					return Optional.of(entry.getValue());
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return Optional.empty();
	}

	protected void refreshInput() {
		lblNewLabel.setText("Choose: " + getSelectedGenerator().getContentType());
		((WorkspaceTreeContentProvider) resourceTree.getContentProvider())
				.setFileExtension(FileExtensions.getFileExtension(getSelectedGenerator().getId()));
		resourceTree.setInput(getRelevantProjects());
	}

	protected List<IProject> getRelevantProjects() {
		List<IProject> relevantProjects = Lists.newArrayList();
		IProject project = getContextProject();
		relevantProjects.add(project);
		relevantProjects.addAll(getReferencedProjects(project));
		return relevantProjects;
	}

	protected IProject getContextProject() {
		IPath containerPath = fileSelectionPage.getFilePath();
		IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(containerPath);
		IProject project = folder.getProject();
		return project;
	}
	
	protected List<IProject> getReferencedProjects(IProject project) {
		try {
			IProject[] referencedProjects = project.getReferencedProjects();
			return Arrays.asList(referencedProjects);
		} catch (CoreException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
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

		IGeneratorDescriptor desc = getSelectedGenerator();
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

	public IGeneratorDescriptor getSelectedGenerator() {
		return (IGeneratorDescriptor) ((StructuredSelection) generatorCombo.getSelection()).getFirstElement();
	}

	private static class GeneratorDescriptorLabelProvider extends LabelProvider {

		
		@Override
		public String getText(Object element) {
			if (element instanceof IGeneratorDescriptor) {
				return ((IGeneratorDescriptor) element).getName();
			}
			if (element instanceof InstallMoreGeneratorsItem) {
				return ((InstallMoreGeneratorsItem) element).getText();
			}
			return super.getText(element);
		}

		@Override
		public Image getImage(Object element) {
			if (element instanceof IGeneratorDescriptor) {
				return PathToImageResolver.toImage(((IGeneratorDescriptor) element).getImagePath());
			}
			return super.getImage(element);
		}
	}

	protected static class SGenWorkspaceLabelProvider extends AbstractWorkspaceLabelProvider {

		protected Image createImageForFile(IFile file) {
			String generatorID = FileExtensions.getGeneratorForFileExtension(file.getFileExtension());
			Optional<IGeneratorDescriptor> genDesc = GeneratorExtensions.getGeneratorDescriptor(generatorID);
			if (genDesc.isPresent()) {
				return PathToImageResolver.toImage(genDesc.get().getImagePath());
			}
			return null;
		}

	}
	
	protected static class InstallMoreGeneratorsItem {
		
		private static final String LABS_REPO_URI = "http://updates.yakindu.com/statecharts/labs";

		public String getText() {
			return "Install more...";
		}
		
		public void openInstallWizard(IProgressMonitor monitor) {
			Map<String, Set<String>> deps = Maps.newHashMap();
			deps.put(LABS_REPO_URI, Collections.emptySet());
			new InstallWizardOpener().open(deps, monitor);
		}
	}

	
}
