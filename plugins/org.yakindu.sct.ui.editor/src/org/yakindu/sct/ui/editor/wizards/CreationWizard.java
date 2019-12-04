/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.wizards;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.gmf.runtime.util.EditPartUtils;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.StatechartImages;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.providers.SemanticHints;
import org.yakindu.sct.ui.wizards.ModelCreationWizardPage;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CreationWizard extends Wizard implements INewWizard {

	public static final String ID = "org.yakindu.sct.ui.editor.StatechartDiagramWizard";

	protected IStructuredSelection selection = new StructuredSelection();

	protected ModelCreationWizardPage modelCreationPage;

	protected DomainWizardPage domainWizardPage;

	protected Resource diagram;

	private boolean openOnCreate = true;

	protected PreferencesHint preferencesHint = DiagramActivator.DIAGRAM_PREFERENCES_HINT;

	private IWorkbench workbench;

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle("New YAKINDU Statechart");
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		initModelCreationPage();
		initDomainWizardPage();

	}

	protected void initModelCreationPage() {
		modelCreationPage = new ModelCreationWizardPage("DiagramModelFile", getSelection(), "sct");
		modelCreationPage.setTitle("YAKINDU SCT Diagram");
		modelCreationPage.setDescription("Create a new YAKINDU SCT diagram file.");
		modelCreationPage.setImageDescriptor(StatechartImages.LOGO.imageDescriptor());
		addPage(modelCreationPage);
	}

	protected void initDomainWizardPage() {
		if (DomainRegistry.getDomains().size() > 1) {
			domainWizardPage = new DomainWizardPage("DomainWizard");
			domainWizardPage.setTitle("Select Statechart Domain");
			domainWizardPage.setDescription("Select the domain you want to create a statechart for.");
			domainWizardPage.setImageDescriptor(StatechartImages.LOGO.imageDescriptor());
			addPage(domainWizardPage);
		}
	}

	public static class DiagramCreationDesccription {

		private URI uri;
		private String domainID;

		public DiagramCreationDesccription(URI uri, String domainID) {
			this.uri = uri;
			this.domainID = domainID;
		}

		public URI getModelURI() {
			return uri;
		}

		public String getDomainID() {
			return domainID;
		}

	}
	
	@Override
	public boolean performFinish() {
		final DiagramCreationDesccription create = getDiagramDescription();

		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {

				diagram = new DiagramCreator().createDiagram(create, monitor);
				if (isOpenOnCreate() && diagram != null) {
					try {
						openDiagram(diagram);
						PerspectiveUtil.switchToModelingPerspective(workbench.getActiveWorkbenchWindow());
					} catch (PartInitException e) {
						DiagramActivator.getDefault().getLog().log(
								new Status(IStatus.WARNING, DiagramActivator.PLUGIN_ID, "Editor can't be opened", e));
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (Exception e) {
			return false;
		}
		return diagram != null;
	}

	protected DiagramCreationDesccription getDiagramDescription() {
		URI uri = modelCreationPage.getURI();
		final String domainID = domainWizardPage != null ? domainWizardPage.getDomainID()
				: BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral();

		final DiagramCreationDesccription create = new DiagramCreationDesccription(uri, domainID);
		return create;
	}

	protected boolean openDiagram(Resource diagram) throws PartInitException {
		String path = diagram.getURI().toPlatformString(true);
		IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
		if (workspaceResource instanceof IFile) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			StatechartDiagramEditor editor = (StatechartDiagramEditor) page
					.openEditor(new FileEditorInput((IFile) workspaceResource), getEditorID());
			if (editor != null) {
				List<EObject> allNotationElements = EcoreUtil2.eAllContentsAsList(diagram);
				for (EObject eObject : allNotationElements) {
					if (eObject instanceof View && ((View) eObject).getType().equals(SemanticHints.STATE_NAME)) {
						IGraphicalEditPart editPart = EditPartUtils.findEditPartForSemanticElement(
								editor.getDiagramGraphicalViewer().getRootEditPart(), ((View) eObject).getElement());
						editPart = editPart.getChildBySemanticHint(SemanticHints.STATE_NAME);
						if (editPart != null) {
							final DirectEditRequest request = new DirectEditRequest();
							request.setDirectEditFeature(BasePackage.Literals.NAMED_ELEMENT__NAME);
							editPart.performRequest(request);
							break;
						}
					}
				}
				return false;
			}
		}
		return false;
	}

	protected String getEditorID() {
		return StatechartDiagramEditor.ID;
	}

	public IStructuredSelection getSelection() {
		return selection;
	}

	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

	public boolean isOpenOnCreate() {
		return openOnCreate;
	}

	public void setOpenOnCreate(boolean openOnCreate) {
		this.openOnCreate = openOnCreate;
	}

	protected void setPreferenceHint(PreferencesHint hint) {
		preferencesHint = hint;
	}
}
