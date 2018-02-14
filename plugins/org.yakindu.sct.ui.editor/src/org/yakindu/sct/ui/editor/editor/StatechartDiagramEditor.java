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

import java.util.ArrayList;
import java.util.Optional;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
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
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DiagramGraphicalViewerKeyHandler;
import org.eclipse.gmf.runtime.gef.ui.internal.editparts.AnimatableZoomManager;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.XMLMemento;
import org.eclipse.ui.help.IWorkbenchHelpSystem;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.DomainElement;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.xtext.utils.gmf.resource.DirtyStateListener;
import org.yakindu.base.xtext.utils.jface.viewers.FilteringMenuManager;
import org.yakindu.base.xtext.utils.jface.viewers.StyledTextXtextAdapter;
import org.yakindu.base.xtext.utils.jface.viewers.context.XtextFakeResourceContext;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.DomainStatus;
import org.yakindu.sct.domain.extension.DomainStatus.Severity;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.util.ContextElementAdapter;
import org.yakindu.sct.model.sgraph.util.ContextElementAdapter.IContextElementProvider;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.StatechartImages;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningEditor;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.propertysheets.ValidatingEMFDatabindingContext;
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
public class StatechartDiagramEditor extends DiagramPartitioningEditor implements IGotoMarker, IContextElementProvider {

	public static final String ID = "org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor";

	protected static final String CANNOT_INLINE_SECTION = "Cannot be inlined for subdiagrams";
	protected static final String DEFINITION_SECTION = "definition section";
	protected static final String INLINE_SECTION = "Inline " + DEFINITION_SECTION;
	protected static final String SHOW_SECTION = "Show " + DEFINITION_SECTION;
	protected static final String HIDE_SECTION = "Hide " + DEFINITION_SECTION;

	protected static final int INITIAL_PALETTE_SIZE = 175;
	protected static final int[] MIN_SIZE = {11, 21};
	protected static final int BORDERWIDTH = 2;
	protected static boolean iconHasFocus = false;
	protected int[] previousWidths = DEFAULT_WEIGHTS;
	private boolean isSectionExpanded = true;

	private KeyHandler keyHandler;
	private DirtyStateListener domainAdapter;
	private LiveValidationListener validationListener;
	private IValidationIssueStore issueStore;
	private SelectionListener selectionListener;
	private ResizeListener resizeListener;
	private IconPaintListener iconPaintListener;
	private IconMouseListener iconMouseListener;
	private IconMouseTrackListener iconMouseTrackListener;
	private NameModificationListener nameModificationListener;
	private CollapsedBorderMouseTrackListener collapsedBorderMouseTrackListener;
	private CollapsedBorderMouseListener collapsedBorderMouseListener;
	private ChangeSelectionProviderOnFocusGain embeddedEditorSelectionProviderListener;
	private EmbeddedEditorKeyListener embeddedEditorKeyListener;

	private Label switchControl;
	private Composite labelComposite;
	private CollapsedBorder collapsedBorder;

	private EmbeddedEditor embeddedEditor;
	private XtextResource xtextResource;

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

				return ID.equals(e.getId()) && !otherInput.equals(thisInput) && ((IFileEditorInput) otherInput)
						.getFile().getLocationURI().equals(((IFileEditorInput) thisInput).getFile().getLocationURI());
			} catch (PartInitException e1) {
				e1.printStackTrace();
				return false;
			}
		}).map(e -> e.getEditor(false)).findFirst();
		return editorWithSameResource;
	}

	protected Injector getEditorInjector() {
		IDomain domain = DomainRegistry.getDomain(getDiagram().getElement());
		Injector injector = domain.getInjector(IDomain.FEATURE_EDITOR);
		return injector;
	}

	protected Injector getEmbeddedStatechartSpecificationInjector() {
		IDomain domain = DomainRegistry.getDomain(getContextObject());
		return domain.getInjector(IDomain.FEATURE_EDITOR, Statechart.class.getName());
	}

	protected void checkXtextNature() {
		IFileEditorInput editorInput = (IFileEditorInput) getEditorInput();
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
			getKeyHandler().put(KeyStroke.getPressed('+', SWT.KEYPAD_ADD, SWT.MOD1),
					getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));

			// Zoom in - Unix - Numpad minus
			getKeyHandler().put(KeyStroke.getPressed('-', SWT.KEYPAD_SUBTRACT, SWT.MOD1),
					getActionRegistry().getAction(GEFActionConstants.ZOOM_OUT));

			// Zoom out - all OS - German and English keyboard layout
			getKeyHandler().put(KeyStroke.getPressed('-', 0x2d, SWT.MOD1),
					getActionRegistry().getAction(GEFActionConstants.ZOOM_OUT));

			// Zoom in - all OS - English keyboard layout
			getKeyHandler().put(KeyStroke.getPressed('=', 0x3d, SWT.MOD1),
					getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));

			// Zoom in - Unix - German layout ([CTRL++] propagates char '+')
			getKeyHandler().put(KeyStroke.getPressed('+', 0x2b, SWT.MOD1),
					getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));

			// Zoom in - Windows - German layout ([CTRL++] propagates char 0x1d)
			getKeyHandler().put(KeyStroke.getPressed((char) 0x1d, 0x2b, SWT.MOD1),
					getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));

			// Zoom original - all OS
			getKeyHandler().put(/* CTRL + '0' */
					KeyStroke.getPressed('0', 0x30, SWT.MOD1), new Action() {
						@Override
						public void run() {
							resetZoom();
						}
					});

			// Zoom original - all OS - Numpad 0
			getKeyHandler().put(/* CTRL + '0' */
					KeyStroke.getPressed('0', SWT.KEYPAD_0, SWT.MOD1), new Action() {
						@Override
						public void run() {
							resetZoom();
						}
					});

			// Test Error - for AERI testing only
			// DOWN: stateMask=0x50000 CTRL ALT, keyCode=0x6c 'l', character=0xc
			// ' '
			getKeyHandler().put(KeyStroke.getPressed((char) 0xc, 0x6c, 0x50000), new Action() {
				@Override
				public void run() {
					DiagramActivator.getDefault().getLog()
							.log(new Status(IStatus.ERROR, DiagramActivator.PLUGIN_ID, "AERI Testing error"));
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
	public String getFactoryId() {
		return getEditorInput().getPersistable().getFactoryId();
	}

	@Override
	public void dispose() {
		saveState(getMemento());

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

		disposeEmbeddedEditor();

		super.dispose();
	}

	protected void disposeEmbeddedEditor() {
		if (selectionListener != null && switchControl != null && !switchControl.isDisposed()) {
			switchControl.removeMouseListener(selectionListener);
			selectionListener = null;
			switchControl.dispose();
			switchControl = null;
		}

		if (embeddedEditor != null) {
			StyledText textWidget = embeddedEditor.getViewer().getTextWidget();
			if (textWidget != null && !textWidget.isDisposed()) {
				if (resizeListener != null) {
					textWidget.removeControlListener(resizeListener);
					getSash().removeControlListener(resizeListener);
					resizeListener = null;
				}
				if (embeddedEditorKeyListener != null) {
					textWidget.removeKeyListener(embeddedEditorKeyListener);
					embeddedEditorKeyListener = null;
				}
				if (embeddedEditorSelectionProviderListener != null) {
					textWidget.removeFocusListener(embeddedEditorSelectionProviderListener);
					textWidget.removeDisposeListener(embeddedEditorSelectionProviderListener);
					embeddedEditorSelectionProviderListener = null;
				}
				textWidget.dispose();
				textWidget = null;
				embeddedEditor = null;
			}
		}

		iconMouseListener = null;
		iconMouseTrackListener = null;
		iconPaintListener = null;
		nameModificationListener = null;
		collapsedBorderMouseTrackListener = null;
		collapsedBorderMouseListener = null;
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
		} else if (DiagramPartitioningEditor.class.equals(type)) {
			return super.getAdapter(type);
		}
		return super.getAdapter(type);
	}

	@Override
	protected void createTextEditor(Composite parent) {
		if (getContextObject() instanceof Statechart) {
			Composite definitionSection = new Composite(parent, SWT.BORDER);
			GridLayoutFactory.fillDefaults().numColumns(2).spacing(0, 0).applyTo(definitionSection);

			switchControl = createSwitchControl(definitionSection);
			createDefinitionSectionLabels(definitionSection);
			createSpecificationEditor(definitionSection);

			selectionListener = new SelectionListener(embeddedEditor.getViewer().getTextWidget());
			switchControl.addMouseListener(selectionListener);

			resizeListener = new ResizeListener(definitionSection);
			getSash().addControlListener(resizeListener);
			embeddedEditor.getViewer().getTextWidget().addControlListener(resizeListener);
		}
	}

	/*
	 * Need hook into part creation lifecycle because the Xtext controls depends on
	 * the selection provider of IWorkbenchPartSite, so the Xtext enabling cannot be
	 * done before or while the part is created.
	 * 
	 * @see org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningEditor#
	 * createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		if (getContextObject() instanceof Statechart) {
			toggleDefinitionSection();
			restoreSashWidths(getSash(), getMemento());
		}
	}

	protected void createSpecificationEditor(Composite definitionSection) {
		embeddedEditor = createEmbeddedEditor(definitionSection);
		EmbeddedEditorModelAccess modelAccess = embeddedEditor.createPartialEditor();
		modelAccess.updateModel(getStatechartSpecification());
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(embeddedEditor.getViewer().getControl());
		initializeEmbeddedEditorWidget();
	}

	protected void initializeEmbeddedEditorWidget() {
		StyledText editorWidget = embeddedEditor.getViewer().getTextWidget();
		editorWidget.setAlwaysShowScrollBars(false);
		editorWidget.setSelection(0);
		embeddedEditorKeyListener = new EmbeddedEditorKeyListener();
		editorWidget.addKeyListener(embeddedEditorKeyListener);
		enableXtext(editorWidget);
		initContextMenu(editorWidget);
	}

	protected void enableXtext(StyledText editor) {
		initXtextSelectionProvider(editor);
		initBinding(editor);
	}

	protected void initXtextSelectionProvider(StyledText editor) {
		XtextStyledTextSelectionProvider xtextStyledTextSelectionProvider = new XtextStyledTextSelectionProvider();
		embeddedEditorSelectionProviderListener = new ChangeSelectionProviderOnFocusGain(getSite(),
				xtextStyledTextSelectionProvider);
		editor.addFocusListener(embeddedEditorSelectionProviderListener);
		editor.addDisposeListener(embeddedEditorSelectionProviderListener);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	protected void initBinding(StyledText editor) {
		IEMFValueProperty modelProperty = EMFEditProperties.value(getEditingDomain(),
				SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION);
		ISWTObservableValue uiProperty = WidgetProperties.text(new int[]{SWT.FocusOut, SWT.Modify}).observe(editor);
		IObservableValue modelPropertyObservable = modelProperty.observe(
				EcoreUtil.getObjectByType(getDiagram().eResource().getContents(), SGraphPackage.Literals.STATECHART));
		ValidatingEMFDatabindingContext context = new ValidatingEMFDatabindingContext(this, getSite().getShell());
		context.bindValue(uiProperty, modelPropertyObservable, null, null);
	}

	protected EmbeddedEditor createEmbeddedEditor(Composite definitionSection) {
		Injector embeddedEditorInjector = getEmbeddedStatechartSpecificationInjector();
		EmbeddedEditorFactory instance = embeddedEditorInjector.getInstance(EmbeddedEditorFactory.class);
		IEditedResourceProvider provider = getXtextResourceProvider(embeddedEditorInjector);

		return instance.newEditor(provider).showErrorAndWarningAnnotations().withParent(definitionSection);
	}

	protected IEditedResourceProvider getXtextResourceProvider(Injector injector) {
		return new IEditedResourceProvider() {

			@Override
			public XtextResource createResource() {
				XtextFakeResourceContext resource = new XtextFakeResourceContext(injector);
				xtextResource = resource.getFakeResource();
				xtextResource.eAdapters().add(new ContextElementAdapter(StatechartDiagramEditor.this));
				return xtextResource;
			}
		};
	}

	protected void createDefinitionSectionLabels(Composite definitionSection) {
		labelComposite = new Composite(definitionSection, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(0, 0).applyTo(labelComposite);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(labelComposite);
		createNameLabel(labelComposite);
		createInlineIcon(labelComposite);
		createSeparator(definitionSection);
		createCollapsedBorder(definitionSection);
	}

	protected void createInlineIcon(Composite labelComposite) {
		Label icon = new Label(labelComposite, SWT.FILL);
		icon.setImage(StatechartImages.PIN.image());
		icon.setToolTipText(INLINE_SECTION);
		icon.setEnabled(getContextObject() instanceof Statechart);
		labelComposite.setToolTipText(getInlineTooltipText());
		GridDataFactory.fillDefaults().applyTo(icon);
		iconMouseListener = new IconMouseListener();
		iconMouseTrackListener = new IconMouseTrackListener(icon);
		iconPaintListener = new IconPaintListener(icon);
		icon.addMouseListener(iconMouseListener);
		icon.addMouseTrackListener(iconMouseTrackListener);
		icon.addPaintListener(iconPaintListener);
	}

	protected String getInlineTooltipText() {
		return (getContextObject() instanceof Statechart) ? INLINE_SECTION : CANNOT_INLINE_SECTION;
	}

	protected SetCommand setBooleanValueStyle(BooleanValueStyle inlineStyle, TransactionalEditingDomain domain) {
		SetCommand command = new SetCommand(domain, inlineStyle,
				NotationPackage.Literals.BOOLEAN_VALUE_STYLE__BOOLEAN_VALUE, !inlineStyle.isBooleanValue());
		return command;
	}

	protected AddCommand addBooleanValueStyle(View view, BooleanValueStyle inlineStyle,
			TransactionalEditingDomain domain) {
		AddCommand command = new AddCommand(domain, view, NotationPackage.Literals.VIEW__STYLES, inlineStyle);
		return command;
	}

	protected void createNameLabel(Composite labelComposite) {
		Text nameLabel = new Text(labelComposite, SWT.SINGLE | SWT.NORMAL);
		GridDataFactory.fillDefaults().indent(5, 1).grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(nameLabel);

		nameLabel.setText(getStatechartName());
		nameLabel.setEditable(getContextObject() instanceof Statechart);
		nameLabel.setBackground(ColorConstants.white);
		nameModificationListener = new NameModificationListener(nameLabel);
		nameLabel.addModifyListener(nameModificationListener);
	}

	protected String getStatechartName() {
		Statechart statechart = EcoreUtil2.getContainerOfType(getContextObject(), Statechart.class);
		return statechart.getName();
	}

	protected void createSeparator(Composite definitionSection) {
		Label separator = new Label(definitionSection, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().span(2, 1).grab(true, false).applyTo(separator);
	}

	protected void createCollapsedBorder(Composite definitionSection) {
		collapsedBorder = new CollapsedBorder(definitionSection, SWT.NONE);
		collapsedBorder.setText("Definition section", new Font(getDisplay(), "Segoe UI", 8, SWT.NORMAL));
		collapsedBorderMouseListener = new CollapsedBorderMouseListener(collapsedBorder);
		collapsedBorderMouseTrackListener = new CollapsedBorderMouseTrackListener(collapsedBorder);
		collapsedBorder.addMouseListener(collapsedBorderMouseListener);
		collapsedBorder.addMouseTrackListener(collapsedBorderMouseTrackListener);

		GridDataFactory.fillDefaults().grab(false, false).span(2, 1).hint(0, definitionSection.getBounds().height)
				.applyTo(collapsedBorder);

		refresh(definitionSection);
	}

	protected Label createSwitchControl(Composite definitionSection) {
		Label switchControl = new Label(definitionSection, SWT.PUSH);
		switchControl.setToolTipText(HIDE_SECTION);
		switchControl.setImage(isSectionExpanded ? StatechartImages.COLLAPSE.image() : StatechartImages.EXPAND.image());
		switchControl.setCursor(new Cursor(getDisplay(), SWT.CURSOR_HAND));
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).indent(-1, 0).hint(MIN_SIZE[0], MIN_SIZE[1])
				.applyTo(switchControl);
		return switchControl;
	}

	@Override
	public EObject getContextObject() {
		Assert.isNotNull(getDiagram());
		EObject element = getDiagram().getElement();
		Assert.isNotNull(element);
		return element;
	}

	protected void initContextMenu(Control control) {
		MenuManager menuManager = new FilteringMenuManager();
		Menu contextMenu = menuManager.createContextMenu(control);
		control.setMenu(contextMenu);
		IWorkbenchPartSite site = getSite();
		if (site != null)
			site.registerContextMenu("org.yakindu.base.xtext.utils.jface.viewers.StyledTextXtextAdapterContextMenu",
					menuManager, site.getSelectionProvider());
	}

	protected void collapseDefinitionSection() {
		int parentWidth = getSashWidth();
		int switchControlWidth = getSwitchControlWidth();
		int[] sashWidths = getCollapsedSashWidths(parentWidth, switchControlWidth);
		if ((parentWidth - switchControlWidth) < 0 || (parentWidth < switchControlWidth)) {
			sashWidths = DEFAULT_WEIGHTS;
		}
		layoutDefinitionSection(0, sashWidths, false, 1);
	}

	protected void expandDefinitionSection() {
		layoutDefinitionSection(SASH_WIDTH, previousWidths, true, 2);
	}

	protected int getSashWidth() {
		return getSash().getBounds().width;
	}

	protected int[] getCollapsedSashWidths(int parentWidth, int switchControlWidth) {
		int diff = parentWidth - switchControlWidth;
		return new int[]{switchControlWidth, (diff % 2 != 0) ? diff - (1 + BORDERWIDTH) : diff};
	}

	protected void layoutDefinitionSection(int sashWidth, int[] weights, boolean visible, int hSpan) {
		getDisplay().asyncExec(() -> {
			getSash().setRedraw(false);
			getSash().setSashWidth(sashWidth);
			getSash().setWeights(weights);
			embeddedEditor.getViewer().getControl().setVisible(visible);
			labelComposite.setVisible(visible);
			if (visible)
				refreshSwitchControl(HIDE_SECTION, StatechartImages.COLLAPSE.image());
			else
				refreshSwitchControl(SHOW_SECTION, StatechartImages.EXPAND.image());
			layoutCollapsedBorder(hSpan);
			layoutEmbeddedEditor(hSpan);
			refresh(getSash());
			getSash().setRedraw(true);
		});
	}

	protected void layoutEmbeddedEditor(int hSpan) {
		((GridData) embeddedEditor.getViewer().getControl().getLayoutData()).horizontalSpan = hSpan;
	}

	protected void layoutCollapsedBorder(int hSpan) {
		((GridData) collapsedBorder.getLayoutData()).horizontalSpan = hSpan;
	}

	protected void refresh(Composite comp) {
		comp.layout(false, true);
		comp.redraw();
		comp.update();
	}

	protected void refreshSwitchControl(String tooltipText, Image image) {
		switchControl.setToolTipText(tooltipText);
		switchControl.setImage(image);
	}

	@Override
	protected boolean isDefinitionSectionInlined() {
		BooleanValueStyle style = DiagramPartitioningUtil.getInlineDefinitionSectionStyle(getDiagram());
		return style != null ? style.isBooleanValue() : true;
	}

	@Override
	public void saveState(IMemento memento) {
		if (memento == null) {
			memento = XMLMemento.createWriteRoot(getFactoryId());
		}
		memento.putInteger(FIRST_SASH_WEIGHT, previousWidths[0]);
		memento.putInteger(SECOND_SASH_WEIGHT, previousWidths[1]);
		setExpandState(memento);

		super.setMemento(memento);
	}

	@Override
	protected void setExpandState(IMemento memento) {
		if (getContextObject() != null) {
			if (getContextObject() instanceof NamedElement) {
				NamedElement element = (NamedElement) getContextObject();
				if (element != null)
					memento.putBoolean(stripElementName(element.getName()) + MEM_EXPANDED, isSectionExpanded);
			}
		}
	}

	@Override
	public void restoreState(IMemento memento) {
		if (getSash() != null && memento != null) {
			if (memento.getInteger(FIRST_SASH_WEIGHT) != null && memento.getInteger(SECOND_SASH_WEIGHT) != null) {
				int[] weights = new int[]{memento.getInteger(FIRST_SASH_WEIGHT),
						memento.getInteger(SECOND_SASH_WEIGHT)};
				getSash().setWeights(weights);
				previousWidths = weights;
				isSectionExpanded = getExpandState(memento);
			}
		}
		super.setMemento(memento);
	}

	protected boolean getExpandState(IMemento memento) {
		Object expandState = null;
		if (getContextObject() instanceof NamedElement) {
			NamedElement element = (NamedElement) getContextObject();
			if (element != null)
				expandState = memento.getBoolean(stripElementName(element.getName()) + MEM_EXPANDED);
		}
		return expandState != null ? ((Boolean) expandState).booleanValue() : true;
	}

	protected TransactionalEditingDomain getTransactionalEditingDomain() {
		return TransactionUtil.getEditingDomain(getDiagram());
	}

	protected String getStatechartSpecification() {
		return ((Statechart) getContextObject()).getSpecification();
	}

	protected Display getDisplay() {
		return Display.getCurrent() != null ? Display.getCurrent() : Display.getDefault();
	}

	protected int getSwitchControlWidth() {
		return switchControl.getBounds().width + BORDERWIDTH;
	}

	/**
	 * 
	 * @author robert rudi - Initial contribution and API
	 *
	 */
	public class EmbeddedEditorKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if (e.stateMask == SWT.CTRL && e.keyCode == 'a') {
				embeddedEditor.getViewer().getTextWidget().selectAll();
			}
		}
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected class NameModificationListener implements ModifyListener {

		private final Text nameLabel;

		protected NameModificationListener(Text nameLabel) {
			this.nameLabel = nameLabel;
		}

		@Override
		public void modifyText(ModifyEvent e) {
			if (getContextObject() instanceof Statechart) {
				getSash().setRedraw(false);
				TransactionalEditingDomain domain = getTransactionalEditingDomain();
				SetCommand command = new SetCommand(domain, getContextObject(),
						BasePackage.Literals.NAMED_ELEMENT__NAME, nameLabel.getText());
				domain.getCommandStack().execute(command);
				refresh(nameLabel.getParent());
				getSash().setRedraw(true);
			}
		}
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected class CollapsedBorderMouseListener extends MouseAdapter {
		private final CollapsedBorder collapsedBorder;
		protected CollapsedBorderMouseListener(CollapsedBorder collapsedBorder) {
			this.collapsedBorder = collapsedBorder;
		}
		@Override
		public void mouseUp(MouseEvent e) {
			if (!isSectionExpanded)
				selectionListener.handleSelection();
			collapsedBorder.setCursor(new Cursor(getDisplay(), SWT.CURSOR_ARROW));
		}
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected class CollapsedBorderMouseTrackListener extends MouseTrackAdapter {
		private final CollapsedBorder collapsedBorder;
		protected CollapsedBorderMouseTrackListener(CollapsedBorder collapsedBorder) {
			this.collapsedBorder = collapsedBorder;
		}
		@Override
		public void mouseEnter(MouseEvent e) {
			collapsedBorder
					.setCursor(new Cursor(getDisplay(), (!isSectionExpanded) ? SWT.CURSOR_HAND : SWT.CURSOR_ARROW));
			collapsedBorder.setToolTipText((!isSectionExpanded) ? SHOW_SECTION : null);
		}
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected class IconMouseListener extends MouseAdapter {

		@Override
		public void mouseUp(MouseEvent e) {
			TransactionalEditingDomain domain = getTransactionalEditingDomain();
			BooleanValueStyle inlineStyle = DiagramPartitioningUtil.getInlineDefinitionSectionStyle(getDiagram());
			if (inlineStyle == null) {
				inlineStyle = DiagramPartitioningUtil.createInlineDefinitionSectionStyle();
				AddCommand command = addBooleanValueStyle(getDiagram(), inlineStyle, domain);
				domain.getCommandStack().execute(command);
			}
			// set the new value for the boolean value style
			SetCommand command = setBooleanValueStyle(inlineStyle, domain);
			domain.getCommandStack().execute(command);

			toggleDefinitionSection();
			refreshDiagramEditPartChildren();
		}
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected class IconMouseTrackListener extends MouseTrackAdapter {
		private final Label icon;

		protected IconMouseTrackListener(Label icon) {
			this.icon = icon;
		}

		@Override
		public void mouseEnter(MouseEvent e) {
			icon.setCursor(new Cursor(getDisplay(), SWT.CURSOR_HAND));
			iconHasFocus = true;
			refresh(icon.getParent());
		}

		@Override
		public void mouseExit(MouseEvent e) {
			iconHasFocus = false;
			refresh(icon.getParent());
		}
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected class IconPaintListener implements PaintListener {
		private final Label icon;

		protected IconPaintListener(Label icon) {
			this.icon = icon;
		}

		@Override
		public void paintControl(PaintEvent e) {
			if (iconHasFocus) {
				drawIconBorder(icon, e.gc);
			}
		}

		protected void drawIconBorder(Label icon, GC gc) {
			Rectangle rect = new Rectangle(0, 0, icon.getBounds().width - 1, icon.getBounds().height - 1);
			Transform t = new Transform(getDisplay());
			gc.setTransform(t);
			gc.setForeground(ColorConstants.lightGray);
			gc.drawRectangle(0, 0, rect.width, rect.height);
			refresh(icon.getParent());
		}
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected class ResizeListener extends ControlAdapter {

		private final Composite definitionSection;

		protected ResizeListener(Composite definitionSection) {
			this.definitionSection = definitionSection;
		}

		@Override
		public void controlResized(ControlEvent e) {
			handleControlChanged();
		}

		@Override
		public void controlMoved(ControlEvent e) {
			handleControlChanged();
		}

		protected void handleControlChanged() {
			if (isSectionExpanded) {
				previousWidths = getSash().getWeights();// save current weights so the widths can later be restored
			} else {
				if (definitionSection.getBounds().width != getSwitchControlWidth()) {
					collapseDefinitionSection(); // keep sash collapsed
				}
			}
		}
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected class SelectionListener extends MouseAdapter {

		protected final StyledText xtextEditor;

		protected SelectionListener(StyledText xtextEditor) {
			this.xtextEditor = xtextEditor;
		}

		protected void handleSelection() {
			getSash().setRedraw(false);
			isSectionExpanded = !isSectionExpanded;
			if (isSectionExpanded) {
				xtextEditor.setVisible(true);
				expandDefinitionSection();
			} else {
				xtextEditor.setVisible(false);
				collapseDefinitionSection();
			}
			getSash().setRedraw(true);
		}

		@Override
		public void mouseUp(MouseEvent e) {
			handleSelection();
		}
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected class CollapsedBorder extends Canvas {

		private String text;
		float rotationAngle = -90f;

		public CollapsedBorder(Composite parent, int style) {
			super(parent, style);

			this.addPaintListener(new PaintListener() {
				public void paintControl(PaintEvent e) {
					paint(e);
				}
			});
			this.addListener(SWT.MouseDown, new Listener() {

				@Override
				public void handleEvent(Event event) {
					if (selectionListener != null && !isSectionExpanded)
						selectionListener.handleSelection();
				}
			});
		}

		public void setText(String string, Font font) {
			this.text = string;
			setFont(font);
			refresh(this);
		}

		public void paint(PaintEvent e) {
			Transform tr = null;
			tr = new Transform(e.display);
			int w = e.width;
			int h = e.height;
			tr.translate(w / 2, h / 2);
			tr.rotate(rotationAngle);
			e.gc.setTransform(tr);
			int drawHeight = -w + 2;
			e.gc.drawString(isSectionExpanded ? "" : text, 0, drawHeight % 2 != 0 ? drawHeight + 1 : drawHeight - 1);
			update();
		}
	}

	/**
	 * copied from {@link StyledTextXtextAdapter}
	 */
	protected class XtextStyledTextSelectionProvider implements ISelectionProvider {

		public void setSelection(ISelection selection) {
		}

		public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		}

		public void addSelectionChangedListener(ISelectionChangedListener listener) {
		}

		public ISelection getSelection() {
			if (embeddedEditor.getViewer().getTextWidget().isDisposed())
				return StructuredSelection.EMPTY;
			int offset = embeddedEditor.getViewer().getTextWidget().getCaretOffset() - 1;
			if (xtextResource != null) {

				IParseResult parseResult = xtextResource.getParseResult();

				if (parseResult == null)
					return StructuredSelection.EMPTY;
				ICompositeNode rootNode = parseResult.getRootNode();
				ILeafNode selectedNode = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);
				final EObject selectedObject = NodeModelUtils.findActualSemanticObjectFor(selectedNode);
				if (selectedObject == null) {
					return StructuredSelection.EMPTY;
				}
				return new StructuredSelection(selectedObject);
			}
			return StructuredSelection.EMPTY;
		}
	}

	/**
	 * copied from {@link StyledTextXtextAdapter}
	 */
	protected class ChangeSelectionProviderOnFocusGain implements FocusListener, DisposeListener {

		protected ISelectionProvider selectionProviderOnFocusGain;
		protected ISelectionProvider selectionProviderOnFocusLost;
		protected IWorkbenchPartSite site;

		public ChangeSelectionProviderOnFocusGain(IWorkbenchPartSite site,
				ISelectionProvider selectionProviderOnFocusGain) {
			this.selectionProviderOnFocusGain = selectionProviderOnFocusGain;
			this.site = site;
		}

		public void focusLost(FocusEvent e) {
			if (this.selectionProviderOnFocusLost != null) {
				this.site.setSelectionProvider(this.selectionProviderOnFocusLost);
			}
		}

		public void focusGained(FocusEvent e) {
			this.selectionProviderOnFocusLost = this.site.getSelectionProvider();
			this.site.setSelectionProvider(this.selectionProviderOnFocusGain);
		}

		public void widgetDisposed(DisposeEvent e) {
			if (this.selectionProviderOnFocusLost != null) {
				this.site.setSelectionProvider(this.selectionProviderOnFocusLost);
			}
			((StyledText) e.getSource()).removeFocusListener(this);
			((StyledText) e.getSource()).removeDisposeListener(this);
		}
	}

}
