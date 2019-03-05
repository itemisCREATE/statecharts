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
package org.yakindu.sct.ui.editor.editor;

import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DiagramGraphicalViewerKeyHandler;
import org.eclipse.gmf.runtime.gef.ui.internal.editparts.AnimatableZoomManager;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.help.IWorkbenchHelpSystem;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.yakindu.base.base.DomainElement;
import org.yakindu.base.xtext.utils.gmf.resource.DirtyStateListener;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.DomainStatus;
import org.yakindu.sct.domain.extension.DomainStatus.Severity;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.definitionsection.StatechartDefinitionSection;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningEditor;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.proposals.ContentProposalViewerKeyHandler;
import org.yakindu.sct.ui.editor.providers.ISCTOutlineFactory;
import org.yakindu.sct.ui.editor.utils.HelpContextIds;
import org.yakindu.sct.ui.editor.validation.IValidationIssueStore;
import org.yakindu.sct.ui.editor.validation.LiveValidationListener;

import com.google.common.collect.Lists;
import com.google.inject.Injector;
import com.google.inject.Key;

/**
 * @author andreas muelder - Initial contribution and API
 * @author martin esser
 * @author robert rudi
 */
@SuppressWarnings("restriction")
public class StatechartDiagramEditor extends DiagramPartitioningEditor implements IGotoMarker {

	public static final String ID = "org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor";

	protected static final int INITIAL_PALETTE_SIZE = 175;

	private KeyHandler keyHandler;
	private DirtyStateListener domainAdapter;
	private LiveValidationListener validationListener;
	private IValidationIssueStore issueStore;

	private StatechartDefinitionSection definitionSection;

	public StatechartDiagramEditor() {
		super(true);
	}

	public boolean isEditable() {
		DomainStatus domainStatus = getDomainStatus();
		if (domainStatus == null || domainStatus.getSeverity() == Severity.ERROR) {
			return false;
		}
		return super.isEditable();
	}

	protected DomainStatus getDomainStatus() {
		EObject element = getDiagram().getElement();
		DomainElement domainElement = EcoreUtil2.getContainerOfType(element, DomainElement.class);
		if (domainElement != null) {
			DomainStatus domainStatus = DomainRegistry.getDomainStatus(domainElement.getDomainID());
			return domainStatus;
		}
		return null;
	}

	@Override
	protected void createBreadcrumbViewer(Composite parent) {
		DomainStatus domainStatus = getDomainStatus();
		if (domainStatus != null && !(domainStatus.getSeverity() == Severity.OK)) {
			createStatusLabel(parent, domainStatus);
		}
		super.createBreadcrumbViewer(parent);
	}

	protected void createStatusLabel(Composite parent, DomainStatus domainStatus) {
		DomainStatusLabel label = new DomainStatusLabel(domainStatus, parent);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(label);
		parent.pack(true);
	}

	protected Object createOutline(Class<?> type) {
		Injector editorInjector = getEditorInjector();
		boolean outlineBindingExists = null != editorInjector.getExistingBinding(Key.get(ISCTOutlineFactory.class));
		if (!outlineBindingExists) {
			// get the GMF default outline
			return super.getAdapter(type);
		}
		ISCTOutlineFactory outlineFactory = editorInjector.getInstance(ISCTOutlineFactory.class);
		return outlineFactory.createOutline(this);
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		checkXtextNature();
		registerValidationListener();
	}

	protected void registerValidationListener() {
		issueStore = getIssueStore();
		validationListener = getEditorInjector().getInstance(LiveValidationListener.class);
		validationListener.setResource(getDiagram().eResource());
		validationListener.setValidationIssueProcessor(issueStore);
		getEditingDomain().addResourceSetListener(validationListener);
		validationListener.scheduleValidation();
	}

	protected IValidationIssueStore getIssueStore() {
		Optional<IEditorPart> editorWithSameResource = getEditorWithSameResource();
		if (editorWithSameResource.isPresent()) {
			IValidationIssueStore sharedStore = editorWithSameResource.get().getAdapter(IValidationIssueStore.class);
			return sharedStore;
		} else {
			IValidationIssueStore newStore = getEditorInjector().getInstance(IValidationIssueStore.class);
			newStore.connect(getDiagram().eResource());
			return newStore;
		}
	}

	protected Optional<IEditorPart> getEditorWithSameResource() {
		ArrayList<IEditorReference> currentEditors = Lists.newArrayList(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences());

		Optional<IEditorPart> editorWithSameResource = currentEditors.stream().filter(e -> {
			try {
				IEditorInput otherInput = e.getEditorInput();
				IEditorInput thisInput = this.getEditorInput();

				return ID.equals(e.getId()) && !otherInput.equals(thisInput)
						&& equalsLocationURI(otherInput, thisInput);
			} catch (PartInitException e1) {
				e1.printStackTrace();
				return false;
			}
		}).map(e -> e.getEditor(false)).findFirst();
		return editorWithSameResource;
	}

	protected boolean equalsLocationURI(IEditorInput otherInput, IEditorInput thisInput) {
		URI otherLocationURI = ((IFileEditorInput) otherInput).getFile().getLocationURI();
		URI thisLocationURI = ((IFileEditorInput) thisInput).getFile().getLocationURI();
		// location URI can be null if project was deleted from workspace
		return otherLocationURI != null && otherLocationURI.equals(thisLocationURI);
	}

	protected Injector getEditorInjector() {
		IDomain domain = DomainRegistry.getDomain(getDiagram().getElement());
		Injector injector = domain.getInjector(IDomain.FEATURE_EDITOR);
		return injector;
	}

	protected void checkXtextNature() {
		IFileEditorInput editorInput = (IFileEditorInput) getEditorInput();
		if (editorInput == null || editorInput.getFile() == null)
			return;
		IProject project = editorInput.getFile().getProject();
		if (project != null && !XtextProjectHelper.hasNature(project) && project.isAccessible()
				&& !project.isHidden()) {
			addNature(project);
		}
	}

	public void addNature(IProject project) {
		try {
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = XtextProjectHelper.NATURE_ID;
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected TransactionalEditingDomain createEditingDomain() {
		TransactionalEditingDomain domain = DiagramPartitioningUtil.getSharedDomain();
		domainAdapter = new DirtyStateListener();
		domain.addResourceSetListener(domainAdapter);
		return domain;
	}

	public void gotoMarker(IMarker marker) {
		MarkerNavigationService.getInstance().gotoMarker(this, marker);
	}

	@Override
	protected PreferencesHint getPreferencesHint() {
		return DiagramActivator.DIAGRAM_PREFERENCES_HINT;
	}

	@Override
	protected void createGraphicalViewer(Composite parent) {
		super.createGraphicalViewer(parent);
		IWorkbenchHelpSystem helpSystem = PlatformUI.getWorkbench().getHelpSystem();
		helpSystem.setHelp(getGraphicalViewer().getControl(), HelpContextIds.SC_EDITOR_GRAPHICAL_VIEWER);
	}

	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		disableAnimatedZoom();
		createContentProposalViewerKeyHandler();
		super.constructPaletteViewer();
	}

	// Disable the animated zoom, it is too slow for bigger models
	protected void disableAnimatedZoom() {
		AnimatableZoomManager zoomManager = (AnimatableZoomManager) getGraphicalViewer()
				.getProperty(ZoomManager.class.toString());
		zoomManager.setZoomAnimationStyle(ZoomManager.ANIMATE_NEVER);
	}

	protected void createContentProposalViewerKeyHandler() {
		ContentProposalViewerKeyHandler contentProposalHandler = new ContentProposalViewerKeyHandler(
				getGraphicalViewer());
		contentProposalHandler
				.setParent(new DiagramGraphicalViewerKeyHandler(getGraphicalViewer()).setParent(getKeyHandler()));
		getGraphicalViewer().setKeyHandler(contentProposalHandler);
	}

	/**
	 * Overrides the GMF key handler to fix key binding for zooming and to remove
	 * unused key bindings.
	 */
	@Override
	protected KeyHandler getKeyHandler() {
		if (keyHandler == null) {
			keyHandler = new KeyHandler();

			registerZoomActions();

			// Zoom in - Unix - Numpad plus
			keyHandler.put(KeyStroke.getPressed('+', SWT.KEYPAD_ADD, SWT.MOD1),
					getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));

			// Zoom in - Unix - Numpad minus
			keyHandler.put(KeyStroke.getPressed('-', SWT.KEYPAD_SUBTRACT, SWT.MOD1),
					getActionRegistry().getAction(GEFActionConstants.ZOOM_OUT));

			// Zoom out - all OS - German and English keyboard layout
			keyHandler.put(KeyStroke.getPressed('-', 0x2d, SWT.MOD1),
					getActionRegistry().getAction(GEFActionConstants.ZOOM_OUT));

			// Zoom in - all OS - English keyboard layout
			keyHandler.put(KeyStroke.getPressed('=', 0x3d, SWT.MOD1),
					getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));

			// Zoom in - Unix - German layout ([CTRL++] propagates char '+')
			keyHandler.put(KeyStroke.getPressed('+', 0x2b, SWT.MOD1),
					getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));

			// Zoom in - Windows - German layout ([CTRL++] propagates char 0x1d)
			keyHandler.put(KeyStroke.getPressed((char) 0x1d, 0x2b, SWT.MOD1),
					getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));

			// Zoom original - all OS
			keyHandler.put(/* CTRL + '0' */
					KeyStroke.getPressed('0', 0x30, SWT.MOD1), new Action() {
						@Override
						public void run() {
							resetZoom();
						}
					});

			// Zoom original - all OS - Numpad 0
			keyHandler.put(/* CTRL + '0' */
					KeyStroke.getPressed('0', SWT.KEYPAD_0, SWT.MOD1), new Action() {
						@Override
						public void run() {
							resetZoom();
						}
					});
		}
		return keyHandler;
	}

	protected void resetZoom() {
		ZoomManager manager = (ZoomManager) getGraphicalViewer().getProperty(ZoomManager.class.toString());
		if (manager != null)
			manager.setZoom(1.0d);
	}

	@SuppressWarnings("unchecked")
	protected void registerZoomActions() {
		IAction action;
		action = new ZoomInAction(getZoomManager());
		action.setText(""); //$NON-NLS-1$ // no text necessary since this
							// is not a visible action
		getActionRegistry().registerAction(action);
		getSelectionActions().add(action.getId());

		action = new ZoomOutAction(getZoomManager());
		action.setText(""); //$NON-NLS-1$ // no text necessary since this
							// is not a visible action
		getActionRegistry().registerAction(action);
		getSelectionActions().add(action.getId());
	}

	@Override
	public String getContributorId() {
		return ID;
	}

	@Override
	public void dispose() {
		if (definitionSection != null && !definitionSection.isDisposed())
			definitionSection.dispose();
		if (validationListener != null) {
			validationListener.dispose();
		}
		if (issueStore != null && !getEditorWithSameResource().isPresent()) {
			issueStore.disconnect(getDiagram().eResource());
		}
		getEditingDomain().removeResourceSetListener(validationListener);
		getEditingDomain().removeResourceSetListener(domainAdapter);
		if (domainAdapter != null)
			domainAdapter.dispose();
		super.dispose();
	}

	@Override
	protected int getInitialPaletteSize() {
		return INITIAL_PALETTE_SIZE;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class type) {
		if (IContentOutlinePage.class.equals(type)) {
			return createOutline(type);
		} else if (IValidationIssueStore.class.equals(type)) {
			return issueStore;
		} else if (EObject.class.equals(type)) {
			return this.getContextObject();
		} else if (TransactionalEditingDomain.class.equals(type)) {
			return getTransactionalEditingDomain();
		} else if (Diagram.class.equals(type)) {
			return getDiagram();
		} else if (DiagramEditPart.class.equals(type)) {
			return getDiagramEditPart();
		}
		return super.getAdapter(type);
	}

	@Override
	protected void createTextEditor(Composite parent) {
		if (isStatechart()) {
			definitionSection = new StatechartDefinitionSection(parent, SWT.BORDER, this);
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		toggleDefinitionSection();
	}

	public void toggleDefinitionSection() {
		if (definitionSection != null && !definitionSection.isDisposed() && isStatechart()) {
			definitionSection.updateStyle();
			definitionSection.restoreSashWidths();
		}
	}

	protected boolean isStatechart() {
		return getContextObject() instanceof Statechart;
	}

	@Override
	public EObject getContextObject() {
		if (getDiagram() == null || getDiagram().getElement() == null)
			return null;
		EObject element = getDiagram().getElement();
		return element;
	}

	protected TransactionalEditingDomain getTransactionalEditingDomain() {
		return TransactionUtil.getEditingDomain(getDiagram());
	}

	@Override
	public boolean isDirty() {
		if (getDiagram() == null || !(getContextObject() instanceof SpecificationElement))
			return super.isDirty();
		SpecificationElement contextObject = (SpecificationElement) getContextObject();
		return super.isDirty() || (definitionSection != null && (definitionSection.getDefinition() != null
				&& !definitionSection.getDefinition().equals(contextObject.getSpecification())));
	}

	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		if (definitionSection != null) {
			definitionSection.validateEmbeddedEditorContext();
		}
		super.doSave(progressMonitor);
	}
}
