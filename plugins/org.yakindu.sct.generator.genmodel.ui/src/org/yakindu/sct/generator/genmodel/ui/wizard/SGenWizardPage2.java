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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.yakindu.sct.generator.core.extensions.FileExtensions;
import org.yakindu.sct.generator.core.extensions.FileExtensions.FileExtensionDescriptor;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.StatechartImages;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 * @author andreas muelder - extension point for contribution of file extensions
 *         added
 */
public class SGenWizardPage2 extends WizardPage {

	// protected static final String STATECHART_FILE_EXTENSION = "sct";

	static Map<String, CoreGenerator> natureDefaultGenerators = new TreeMap<String, CoreGenerator>();
	static {
		natureDefaultGenerators.put("org.eclipse.cdt.core.cnature",
				CoreGenerator.C);
		natureDefaultGenerators.put("org.eclipse.cdt.core.ccnature",
				CoreGenerator.Cpp);
		natureDefaultGenerators.put(JavaCore.NATURE_ID,
				CoreGenerator.Java);
	}
	private ComboViewer generatorCombo;
	protected CheckboxTreeViewer stateChartTree;
	private final SGenWizardPage1 fileSelectionPage;

	private static final ITreeContentProvider treeContentProvider = new ITreeContentProvider() {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof TreeNode) {
				return ((TreeNode) inputElement).children.toArray();
			}
			return new Object[] {};
		}

		public boolean hasChildren(Object element) {
			if (element instanceof TreeNode) {
				return !((TreeNode) element).children.isEmpty();
			}
			return false;
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof TreeNode) {
				return ((TreeNode) parentElement).children.toArray();
			}
			return new Object[] {};
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// not handled
		}

		public void dispose() {
			// not handled
		}

		public Object getParent(Object element) {
			return null;
		}

	};
	private static final LabelProvider treeLabelProvider = new LabelProvider() {

		@Override
		public Image getImage(Object element) {
			if (element instanceof TreeNode) {
				TreeNode treeNode = (TreeNode) element;
				if (isStatechartResource(treeNode.resource)) {
					return StatechartImages.LOGO.image();
				} else if (treeNode.resource.getType() == IResource.FOLDER) {
					return PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJ_FOLDER);
				} else if (treeNode.resource.getType() == IResource.PROJECT) {
					return PlatformUI.getWorkbench().getSharedImages()
							.getImage(IDE.SharedImages.IMG_OBJ_PROJECT);
				}
			}
			return super.getImage(element);
		}

		@Override
		public String getText(Object element) {
			if (element instanceof TreeNode) {
				return ((TreeNode) element).resource.getName();
			}
			return super.getText(element);
		}
	};

	private final IStructuredSelection selection;

	protected SGenWizardPage2(String pageName,
			SGenWizardPage1 fileSelectionPage, IStructuredSelection selection) {
		super(pageName);
		this.fileSelectionPage = fileSelectionPage;
		this.selection = selection;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(1, false));
		createGeneratorCombo(container);
		createStatechartTree(container);
		checkComplete();
	}

	private void createStatechartTree(Composite container) {
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1));
		lblNewLabel.setText("Statecharts");

		stateChartTree = new CheckboxTreeViewer(container, SWT.BORDER);
		stateChartTree.getTree().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		stateChartTree.setContentProvider(treeContentProvider);
		stateChartTree.setLabelProvider(treeLabelProvider);
		TreePropagatingCheckStateListener checkStateListener = new TreePropagatingCheckStateListener(
				stateChartTree) {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				super.checkStateChanged(event);
				checkComplete();
			}
		};
		stateChartTree.addCheckStateListener(checkStateListener);
		stateChartTree
				.addDoubleClickListener(new TreeExpandingDoubleClickListener(
						stateChartTree, checkStateListener));
		stateChartTree.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);
	}

	private void createGeneratorCombo(Composite container) {
		Label lblGenerator = new Label(container, SWT.NONE);
		lblGenerator.setText("Generator");
		generatorCombo = new ComboViewer(container, SWT.READ_ONLY);
		generatorCombo.getCombo().setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		generatorCombo.setLabelProvider(new GeneratorDescriptorLabelProvider());
		generatorCombo.setContentProvider(new ArrayContentProvider());
		List<GeneratorDescriptor> descriptors = Lists
				.newArrayList(GeneratorExtensions.getGeneratorDescriptors());
		Collections.sort(descriptors, CoreGenerator.generatorOrder);
		generatorCombo.setInput(descriptors);
		generatorCombo.getCombo().select(0);
	}

	public List<Statechart> getStatecharts() {
		List<Statechart> statecharts = Lists.newArrayList();
		Object[] checkedElements = stateChartTree.getCheckedElements();
		for (Object object : checkedElements) {
			if (object instanceof TreeNode) {
				IResource resource = ((TreeNode) object).resource;
				if (isStatechartResource(resource)) {
					statecharts.add(loadStatechart(resource));
				}
			}
		}
		return statecharts;
	}

	private static Statechart loadStatechart(IResource resource) {
		Resource emfResource = toEmfResource(resource);
		Statechart statechart = (Statechart) EcoreUtil.getObjectByType(
				emfResource.getContents(), SGraphPackage.Literals.STATECHART);
		return statechart;
	}

	private static Resource toEmfResource(IResource iResource) {
		URI uri = URI.createPlatformResourceURI(iResource.getFullPath()
				.toString(), true);
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.getResource(uri, true);
	}

	public String getGeneratorId() {
		return ((GeneratorDescriptor) ((StructuredSelection) generatorCombo
				.getSelection()).getFirstElement()).getId();
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			IPath containerPath = fileSelectionPage.getFilePath();
			IFolder folder = ResourcesPlugin.getWorkspace().getRoot()
					.getFolder(containerPath);
			try {
				TreeNode projectTree = new TreeNode(folder.getProject());
				projectTree.children.add(buildTree(folder.getProject()));
				stateChartTree.setInput(projectTree);
				applyPreselection(projectTree);
			} catch (CoreException e) {
				// input will be empty
			}
			preselectGenerator(folder);
			checkComplete();
		}
	}

	private void preselectGenerator(IFolder folder) {
		String generatorId = CoreGenerator.Java.getId();
		IProject project = folder.getProject();
		try {
			for (Entry<String, CoreGenerator> entry : natureDefaultGenerators
					.entrySet()) {
				if (project.getNature(entry.getKey()) != null) {
					generatorId = entry.getValue().getId();
				}
			}
		} catch (CoreException e) {
			// nothing will be pre-selected
		}
		GeneratorDescriptor descriptor = generatorId != null ? GeneratorExtensions
				.getGeneratorDescriptorForId(generatorId) : null;
		if (descriptor != null) {
			generatorCombo.setSelection(new StructuredSelection(
					new Object[] { descriptor }), true);
		}
	}

	private void applyPreselection(TreeNode treeNode) {
		if (treeNode.isPreselected()) {
			stateChartTree.setChecked(treeNode, true);
		}
		for (TreeNode child : treeNode.children) {
			applyPreselection(child);
		}
	}

	protected void checkComplete() {
		setPageComplete(validatePage());
	}

	protected boolean validatePage() {
		return stateChartSelected() && !generatorCombo.getSelection().isEmpty();
	}

	protected boolean stateChartSelected() {
		if (stateChartTree.getCheckedElements().length > 0) {
			for (Object element : stateChartTree.getCheckedElements()) {
				if (element instanceof TreeNode
						&& isStatechartResource(((TreeNode) element).resource)) {
					return true;
				}
			}
		}
		return false;
	}

	private TreeNode buildTree(IResource resource) throws CoreException {
		final TreeNode root = new TreeNode(resource);
		List<IResource> statecharts = Lists.newArrayList();
		resource.accept(new StatechartVisitor(resource, statecharts));
		if (!statecharts.isEmpty()) {
			Iterables.addAll(root.children, Iterables.transform(
					Iterables.transform(statecharts, toTreeNode),
					preselect(selection)));
		}
		List<IResource> folders = Lists.newArrayList();
		resource.accept(new FolderVisitor(resource, folders));
		for (IResource folder : folders) {
			TreeNode subtree = buildTree(folder);
			if (!subtree.isEmpty()) {
				root.children.add(subtree);
			}
		}
		return root;
	}

	private Function<TreeNode, TreeNode> preselect(
			final IStructuredSelection selection) {

		return new Function<TreeNode, TreeNode>() {

			public TreeNode apply(TreeNode from) {
				if (Iterators.contains(selection.iterator(), from.resource)) {
					from.setPreselected(true);
				}
				return from;
			}
		};
	}

	protected static boolean isStatechartResource(IResource resource) {
		List<String> registeredExtensions = new ArrayList<String>();
		Iterable<FileExtensionDescriptor> fileExtensions = FileExtensions
				.getFileExtensions();
		for (FileExtensionDescriptor desc : fileExtensions) {
			registeredExtensions.add(desc.getExtension());
		}
		return resource.getType() == IResource.FILE
				&& registeredExtensions.contains(resource.getFileExtension());
	}

	private static final Function<IResource, TreeNode> toTreeNode = new Function<IResource, TreeNode>() {

		public TreeNode apply(IResource from) {
			return new TreeNode(from);
		}
	};

	private static class TreeNode {
		final IResource resource;
		private boolean preselected;
		final List<TreeNode> children = Lists.newArrayList();

		public TreeNode(IResource project) {
			this.resource = project;
		}

		public boolean isEmpty() {
			return resource.getType() == IResource.FOLDER
					&& (children.isEmpty() || Iterables.all(children, isEmpty));
		}

		public boolean isPreselected() {
			return preselected;
		}

		public void setPreselected(boolean preselect) {
			this.preselected = preselect;
		}

		static final Predicate<TreeNode> isEmpty = new Predicate<TreeNode>() {
			public boolean apply(TreeNode input) {
				return input.isEmpty();
			}
		};
	}

	private class FolderVisitor implements IResourceVisitor {
		final List<IResource> matches;
		private final IResource rootFolder;

		public FolderVisitor(IResource rootFolder, List<IResource> matches) {
			super();
			this.rootFolder = rootFolder;
			this.matches = matches;
		}

		public boolean visit(IResource resource) throws CoreException {
			if (rootFolder.equals(resource)) {
				return true;
			}
			if (resource.getType() == IResource.FOLDER && !resource.isDerived()) {
				matches.add(resource);
			}
			return resource.getType() == IResource.PROJECT;
		}

	}

	private class StatechartVisitor implements IResourceVisitor {

		final List<IResource> matches;
		private final IResource rootResource;

		public StatechartVisitor(IResource rootResource, List<IResource> matches) {
			super();
			this.rootResource = rootResource;
			this.matches = matches;
		}

		public boolean visit(IResource resource) throws CoreException {
			if (rootResource.equals(resource)
					&& resource.getType() == IResource.FOLDER) {
				return true;
			}
			if (isStatechartResource(resource)) {
				matches.add(resource);
			}
			return resource.getType() == IResource.PROJECT;
		}
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
