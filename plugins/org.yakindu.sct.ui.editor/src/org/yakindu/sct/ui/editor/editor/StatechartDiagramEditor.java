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

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Button;
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
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.DomainElement;
import org.yakindu.base.xtext.utils.gmf.resource.DirtyStateListener;
import org.yakindu.base.xtext.utils.jface.fieldassist.CompletionProposalAdapter;
import org.yakindu.base.xtext.utils.jface.viewers.FilteringMenuManager;
import org.yakindu.base.xtext.utils.jface.viewers.StyledTextXtextAdapter;
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

	private static final String ROTATED_LABEL_TEXT = "Definition section";
	private static final String CANNOT_INLINE_SECTION_TOOLTIP = "Cannot be inlined for subdiagrams";
	private static final String INLINE_SECTION_TOOLTIP = "Inline statechart definition section";
	private static final int TEXT_CONTROL_HORIZONTAL_MARGIN = 10;
	private static final int INITIAL_PALETTE_SIZE = 175;
	private static final int[] MIN_CONTROL_SIZE = {11, 21};
	private static final int BORDERWIDTH = 2;
	private static boolean imageLabelHasFocus = false;
	private int[] previousWidths = DEFAULT_WEIGHTS;

	private KeyHandler keyHandler;
	private DirtyStateListener domainAdapter;
	private LiveValidationListener validationListener;
	private IValidationIssueStore issueStore;
	private SwitchListener switchListener;
	private ResizeListener resizeListener;
	private StyledText xtextControl;
	private boolean isExpandedDefinitionSection = true;

	private ImageLabelMouseListener imageLabelMouseListener;
	private ImageLabelMouseTrackListener imageLabelMouseTrackListener;
	private ImageLabelPaintListener imageLabelPaintListener;

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
		issueStore = getEditorInjector().getInstance(IValidationIssueStore.class);
		issueStore.connect(getDiagram().eResource());
		validationListener = getEditorInjector().getInstance(LiveValidationListener.class);
		validationListener.setResource(getDiagram().eResource());
		validationListener.setValidationIssueProcessor(issueStore);
		getEditingDomain().addResourceSetListener(validationListener);
		validationListener.scheduleValidation();
	}

	protected Injector getEditorInjector() {
		IDomain domain = DomainRegistry.getDomain(getDiagram().getElement());
		Injector injector = domain.getInjector(IDomain.FEATURE_EDITOR);
		return injector;
	}

	protected Injector getEmbeddedStatechartSpecificationInjector() {
		IDomain domain = DomainRegistry.getDomain(getDiagram().getElement());
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
		if (issueStore != null)
			issueStore.disconnect(getDiagram().eResource());
		getEditingDomain().removeResourceSetListener(validationListener);
		getEditingDomain().removeResourceSetListener(domainAdapter);
		if (domainAdapter != null)
			domainAdapter.dispose();

		disposeDefinitionSectionControlListeners();
		if (xtextControl != null && !xtextControl.isDisposed())
			xtextControl.dispose();

		super.dispose();
	}

	protected void disposeDefinitionSectionControlListeners() {
		if (switchListener != null) {
			switchListener.dispose();
			switchListener = null;
		}
		if (resizeListener != null) {
			resizeListener.dispose();
			resizeListener = null;
		}
		if (imageLabelMouseListener != null) {
			imageLabelMouseListener.dispose();
			imageLabelMouseListener = null;
		}
		if (imageLabelMouseTrackListener != null) {
			imageLabelMouseTrackListener.dispose();
			imageLabelMouseTrackListener = null;
		}
		if (imageLabelPaintListener != null) {
			imageLabelPaintListener.dispose();
			imageLabelPaintListener = null;
		}
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
		Composite definitionSection = new Composite(parent, SWT.BORDER);
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(0, 0).applyTo(definitionSection);

		Button expandButton = createExpandControl(definitionSection);
		createDefinitionSectionLabels(definitionSection);
		xtextControl = createXtextControl(definitionSection);

		switchListener = new SwitchListener(parent, expandButton, xtextControl);
		resizeListener = new ResizeListener(parent, definitionSection, expandButton);

		parent.addControlListener(resizeListener);
		expandButton.addSelectionListener(switchListener);
		xtextControl.addControlListener(resizeListener);
		definitionSection.addMouseListener(new org.eclipse.swt.events.MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if (!isExpandedDefinitionSection) {
					switchListener.handleSelection();
				}
			}
		});
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
		toggleDefinitionSection();
		restoreSashWidths(getSash(), getMemento());
		enableXtext(xtextControl);
	}

	protected void enableXtext(StyledText xtextControl) {
		final StyledTextXtextAdapter xtextAdapter = new StyledTextXtextAdapter(
				getEmbeddedStatechartSpecificationInjector(), getSite());
		xtextAdapter.getFakeResourceContext().getFakeResource().eAdapters().add(new ContextElementAdapter(this));
		xtextAdapter.adapt((StyledText) xtextControl);
		initContextMenu(xtextControl);
		CompletionProposalAdapter adapter = new CompletionProposalAdapter(xtextControl,
				xtextAdapter.getContentAssistant(),
				org.eclipse.jface.bindings.keys.KeyStroke.getInstance(SWT.CTRL, SWT.SPACE), null);
		IEMFValueProperty modelProperty = EMFEditProperties.value(getEditingDomain(),
				SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION);

		ISWTObservableValue uiProperty = WidgetProperties.text(new int[]{SWT.FocusOut, SWT.Modify})
				.observe(xtextControl);
		ValidatingEMFDatabindingContext context = new ValidatingEMFDatabindingContext(this, getSite().getShell());
		context.bindValue(uiProperty, modelProperty.observe(
				EcoreUtil.getObjectByType(getDiagram().eResource().getContents(), SGraphPackage.Literals.STATECHART)),
				null, new UpdateValueStrategy() {
					@Override
					protected IStatus doSet(IObservableValue observableValue, Object value) {
						if (adapter != null && !adapter.isProposalPopupOpen())
							return super.doSet(observableValue, value);
						return Status.OK_STATUS;
					}
				});
	}

	protected StyledText createXtextControl(Composite definitionSection) {
		StyledText textControl = new StyledText(definitionSection, SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, true).indent(TEXT_CONTROL_HORIZONTAL_MARGIN, 0).applyTo(textControl);
		textControl.setAlwaysShowScrollBars(false);
		textControl.setBackground(ColorConstants.white);
		textControl.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.stateMask == SWT.CTRL && e.keyCode == 'a') { 
					textControl.selectAll();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		return textControl;
	}

	protected Composite createDefinitionSectionLabels(Composite definitionSection) {
		Composite labelComposite = new Composite(definitionSection, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(0, 0).applyTo(labelComposite);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(labelComposite);
		createDefinitionSectionNameLabel(labelComposite);
		createDefinitionSectionImageLabel(labelComposite);
		createSeparator(definitionSection);
		createRotatedLabel(definitionSection);
		return labelComposite;
	}

	protected void createDefinitionSectionImageLabel(Composite labelComposite) {
		Label statechartImageLabel = new Label(labelComposite, SWT.FILL);
		statechartImageLabel.setImage(StatechartImages.PIN.image());
		statechartImageLabel.setToolTipText(INLINE_SECTION_TOOLTIP);
		statechartImageLabel.setEnabled(getContextObject() instanceof Statechart);
		labelComposite.setToolTipText(getTooltipText());
		GridDataFactory.fillDefaults().applyTo(statechartImageLabel);
		imageLabelMouseListener = new ImageLabelMouseListener(statechartImageLabel);
		imageLabelMouseTrackListener = new ImageLabelMouseTrackListener(statechartImageLabel);
		imageLabelPaintListener = new ImageLabelPaintListener(statechartImageLabel);
	}

	protected String getTooltipText() {
		return (getContextObject() instanceof Statechart) ? INLINE_SECTION_TOOLTIP : CANNOT_INLINE_SECTION_TOOLTIP;
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

	protected void createDefinitionSectionNameLabel(Composite labelComposite) {
		Text statechartNameLabel = new Text(labelComposite, SWT.SINGLE | SWT.NORMAL);
		GridDataFactory.fillDefaults().indent(5, 0).grab(true, false).align(SWT.FILL, SWT.CENTER)
				.applyTo(statechartNameLabel);
		statechartNameLabel.setText(this.getTitle());
		statechartNameLabel.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				statechartNameLabel.update();
				statechartNameLabel.redraw();
				statechartNameLabel.getParent().layout();
			}
		});

		observeStatechartName(statechartNameLabel);
	}

	protected void observeStatechartName(Text statechartNameLabel) {
		ValidatingEMFDatabindingContext context = new ValidatingEMFDatabindingContext(this, this.getSite().getShell());
		IEMFValueProperty property = EMFEditProperties.value(TransactionUtil.getEditingDomain(getContextObject()),
				BasePackage.Literals.NAMED_ELEMENT__NAME);
		ISWTObservableValue observe = WidgetProperties.text(new int[]{SWT.FocusOut, SWT.DefaultSelection})
				.observe(statechartNameLabel);
		context.bindValue(observe, property.observe(this.getContextObject()));
	}

	protected void createSeparator(Composite definitionSection) {
		Label separator = new Label(definitionSection, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().span(2, 1).grab(true, false).applyTo(separator);
	}

	protected void createRotatedLabel(Composite definitionSection) {
		RotatedLabel rotatedLabel = new RotatedLabel(definitionSection, SWT.NONE);
		rotatedLabel.setText(ROTATED_LABEL_TEXT, new Font(Display.getDefault(), "Segoe UI", 8, SWT.NORMAL));
		GridDataFactory.fillDefaults().grab(false, false)
				.hint(MIN_CONTROL_SIZE[0], definitionSection.getBounds().height).applyTo(rotatedLabel);
	}

	protected Button createExpandControl(Composite definitionSection) {
		Button expandButton = new Button(definitionSection, SWT.PUSH | SWT.BORDER_SOLID);
		expandButton.setToolTipText("Hide statechart definition section");
		expandButton.setImage(
				isExpandedDefinitionSection ? StatechartImages.COLLAPSE.image() : StatechartImages.EXPAND.image());
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).indent(-1, 0)
				.hint(MIN_CONTROL_SIZE[0], MIN_CONTROL_SIZE[1]).applyTo(expandButton);
		return expandButton;
	}

	@Override
	public EObject getContextObject() {
		return getDiagram().getElement();
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

	/**
	 * Updates the weights of the parent, which is a SashForm
	 * 
	 * @param parent
	 *            The parent of the controls
	 * @param prominentControl
	 *            The control that should be always prominent in the SashForm, that
	 *            is, the SashForm must not intercept the prominent control.
	 */
	protected void collapseSash(Composite parent, Control prominentControl) {
		int width = parent.getBounds().width;
		((SashForm) parent).setWeights(new int[]{prominentControl.getBounds().width + BORDERWIDTH, width});
	}

	protected class ImageLabelMouseListener extends MouseAdapter {
		private Label statechartImageLabel;

		public ImageLabelMouseListener(Label statechartImageLabel) {
			this.statechartImageLabel = statechartImageLabel;
			this.statechartImageLabel.addMouseListener(this);
		}
		@Override
		public void mouseUp(MouseEvent e) {
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(getDiagram());
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

		public void dispose() {
			this.statechartImageLabel.removeMouseListener(this);
		}
	}

	protected class ImageLabelMouseTrackListener extends MouseTrackAdapter {
		private final Label statechartImageLabel;
		protected ImageLabelMouseTrackListener(Label statechartImageLabel) {
			this.statechartImageLabel = statechartImageLabel;
			this.statechartImageLabel.addMouseTrackListener(this);
		}
		@Override
		public void mouseEnter(MouseEvent e) {
			statechartImageLabel.setCursor(new Cursor(Display.getDefault(), SWT.CURSOR_HAND));
			imageLabelHasFocus = true;
			statechartImageLabel.redraw();
		}
		@Override
		public void mouseExit(MouseEvent e) {
			imageLabelHasFocus = false;
			statechartImageLabel.redraw();
		}

		public void dispose() {
			this.statechartImageLabel.removeMouseTrackListener(this);
		}
	}

	protected class ImageLabelPaintListener implements PaintListener {
		private final Label statechartImageLabel;

		protected ImageLabelPaintListener(Label statechartImageLabel) {
			this.statechartImageLabel = statechartImageLabel;
			this.statechartImageLabel.addPaintListener(this);
		}

		@Override
		public void paintControl(PaintEvent e) {
			if (imageLabelHasFocus) {
				drawIconBorder(statechartImageLabel, e.gc);
			}
		}
		protected void drawIconBorder(Label statechartImageLabel, GC gc) {
			Rectangle rect = new Rectangle(0, 0, statechartImageLabel.getBounds().width - 1,
					statechartImageLabel.getBounds().height - 1);
			Transform t = new Transform(Display.getDefault());
			gc.setTransform(t);
			gc.setForeground(ColorConstants.lightGray);
			gc.drawRectangle(0, 0, rect.width, rect.height);
		}

		public void dispose() {
			this.statechartImageLabel.removePaintListener(this);
		}
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected class ResizeListener extends ControlAdapter {

		private final Composite parent;
		private final Composite definitionSection;
		private final Control control;

		protected ResizeListener(Composite parent, Composite definitionSection, Control control) {
			this.parent = parent;
			this.definitionSection = definitionSection;
			this.control = control;
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
			if (!isExpandedDefinitionSection) {
				if (definitionSection.getBounds().width != control.getBounds().width) {
					collapseSash(parent, control);
				}
			} else {
				previousWidths = ((SashForm) parent).getWeights();
			}
		}

		protected void dispose() {
			if (this.parent != null && !this.parent.isDisposed())
				this.parent.dispose();
			if (this.definitionSection != null && !this.definitionSection.isDisposed())
				this.definitionSection.dispose();
			if (this.control != null && !this.control.isDisposed())
				this.control.dispose();
		}
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected class SwitchListener extends SelectionAdapter {

		protected final Composite parent;
		protected final Control control;
		protected final StyledText textControl;

		protected static final String SHOW_TOOLTIP = "Show ";
		protected static final String HIDE_TOOLTIP = "Hide ";
		protected static final String STATECHART_SPECIFICATION_SECTION_TOOLTIP_TEXT = "statechart definintion section";
		protected final Image EXPAND_IMAGE = StatechartImages.EXPAND.image();
		protected final Image COLLAPSE_IMAGE = StatechartImages.COLLAPSE.image();

		protected SwitchListener(Composite parent, Control control, StyledText textControl) {
			this.parent = parent;
			this.control = control;
			this.textControl = textControl;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			handleSelection();
		}

		protected void handleSelection() {
			parent.setRedraw(false);
			textControl.setVisible(!textControl.isVisible());
			isExpandedDefinitionSection = !isExpandedDefinitionSection;
			if (textControl.isVisible()) {
				updateSwitchControl(HIDE_TOOLTIP, COLLAPSE_IMAGE);
				((SashForm) parent).setWeights(previousWidths);
			} else {
				if (isExpandedDefinitionSection) {
					// needed to restore previous widths of sashcontrols if definition section is
					// collapsed and editor has been reopened
					textControl.setVisible(!textControl.isVisible());
					updateSwitchControl(HIDE_TOOLTIP, COLLAPSE_IMAGE);
					((SashForm) parent).setWeights(previousWidths);
				} else {
					updateSwitchControl(SHOW_TOOLTIP, EXPAND_IMAGE);
					collapseSash(parent, control);
				}
			}
			parent.setRedraw(true);
		}

		/**
		 * Updates the tooltip text and the image for the prominent control.
		 * 
		 * @param tooltipText
		 *            The tooltip text for the control
		 * @param image
		 *            The image for the controls
		 */
		protected void updateSwitchControl(String tooltipText, Image image) {
			control.setToolTipText(tooltipText + STATECHART_SPECIFICATION_SECTION_TOOLTIP_TEXT);
			((Button) control).setImage(image);
		}

		protected void dispose() {
			if (this.parent != null && !this.parent.isDisposed())
				this.parent.dispose();
			if (this.control != null && !this.control.isDisposed())
				this.control.dispose();
			if (this.textControl != null && !this.textControl.isDisposed())
				this.textControl.dispose();
		}
	}

	@Override
	protected boolean isDefinitionSectionInlined() {
		BooleanValueStyle style = DiagramPartitioningUtil.getInlineDefinitionSectionStyle(getDiagram());
		return style != null ? style.isBooleanValue() : true;
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected class RotatedLabel extends Canvas {

		private String text;
		float rotatingAngle = -90f;

		public RotatedLabel(Composite parent, int style) {
			super(parent, style);

			this.addPaintListener(new PaintListener() {
				public void paintControl(PaintEvent e) {
					paint(e);
				}
			});
			this.addListener(SWT.MouseDown, new Listener() {

				@Override
				public void handleEvent(Event event) {
					if (switchListener != null && !isExpandedDefinitionSection)
						switchListener.handleSelection();
				}
			});
		}

		public void setText(String string, Font font) {
			this.text = string;
			setFont(font);
			redraw();
			update();
		}

		public void setText(String string) {
			this.text = string;
			redraw();
			update();
		}

		public void paint(PaintEvent e) {
			Transform tr = null;
			tr = new Transform(e.display);
			int w = e.width;
			int h = e.height;
			tr.translate(w / 2, h / 3);
			tr.rotate(rotatingAngle);
			e.gc.setTransform(tr);
			int drawHeight = -((w / 3) * 2);
			e.gc.drawString(isExpandedDefinitionSection ? "" : text, 0,
					(drawHeight % 2) != 0 ? drawHeight - 1 : drawHeight);
		}

	}

	@Override
	public void saveState(IMemento memento) {
		if (memento == null) {
			String factoryId = getEditorInput().getPersistable().getFactoryId();
			memento = XMLMemento.createWriteRoot(factoryId);
		}

		memento.putInteger(FIRST_SASH_CONTROL, previousWidths[0]);
		memento.putInteger(SECOND_SASH_CONTROL, previousWidths[1]);

		super.setMemento(memento);
	}

	@Override
	public void restoreState(IMemento memento) {
		if (getSash() != null && memento != null && memento.getInteger(FIRST_SASH_CONTROL) != null
				&& memento.getInteger(SECOND_SASH_CONTROL) != null) {
			getSash().setWeights(
					new int[]{memento.getInteger(FIRST_SASH_CONTROL), memento.getInteger(SECOND_SASH_CONTROL)});
		}
		super.setMemento(memento);
	}

}
