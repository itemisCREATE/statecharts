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
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.help.IWorkbenchHelpSystem;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.XtextProjectHelper;
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
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor.SpecificationControlAdapter.HoverListener;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor.SpecificationControlAdapter.ResizeListener;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor.SpecificationControlAdapter.SwitchListener;
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

	private static final int INITIAL_PALETTE_SIZE = 175;
	private static final int[] MIN_CONTROL_SIZE = {12, 23};

	public static final String ID = "org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor";

	private KeyHandler keyHandler;

	private DirtyStateListener domainAdapter;
	private LiveValidationListener validationListener;
	private IValidationIssueStore issueStore;
	private SwitchListener switchListener;
	private ResizeListener resizeListener;
	private HoverListener hoverListener;
	private HoverListener mouseMoveListener;
	private static boolean definitionSectionIsExpanded = true;
	private static boolean textControlIsFocused = true;

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
	};

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
	public void dispose() {
		if (validationListener != null) {
			validationListener.dispose();
		}
		if (issueStore != null)
			issueStore.disconnect(getDiagram().eResource());
		getEditingDomain().removeResourceSetListener(validationListener);
		getEditingDomain().removeResourceSetListener(domainAdapter);
		if (domainAdapter != null)
			domainAdapter.dispose();

		if (switchListener != null) {
			switchListener.dispose();
			switchListener = null;
		}
		if (resizeListener != null) {
			resizeListener.dispose();
			resizeListener = null;
		}
		if (hoverListener != null) {
			hoverListener.dispose();
			hoverListener = null;
		}
		if (mouseMoveListener != null) {
			mouseMoveListener.dispose();
			mouseMoveListener = null;
		}

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
		}
		return super.getAdapter(type);
	}

	@Override
	protected void createTextEditor(Composite parent) {
		Composite definitionSection = new Composite(parent, SWT.BORDER);
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(0, 0).applyTo(definitionSection);

		Button expandButton = createExpandControl(definitionSection);
		Composite sectionLabels = createDefinitionSectionLabels(definitionSection);
		StyledText xtextControl = createXtextControl(definitionSection);

		switchListener = new SpecificationControlAdapter.SwitchListener(parent, expandButton, xtextControl);
		resizeListener = new SpecificationControlAdapter.ResizeListener(parent, definitionSection, expandButton);

		parent.addControlListener(resizeListener);
		expandButton.addSelectionListener(switchListener);
		definitionSection.addMouseListener(new org.eclipse.swt.events.MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if (!definitionSectionIsExpanded)
					switchListener.handleSelection();
			}
		});
		// uncomment if hovering should be enabled
		// hoverListener = new SpecificationControlAdapter.HoverListener(parent,
		// expandButton, textControl);
		// mouseMoveListener = new SpecificationControlAdapter.HoverListener(parent,
		// expandButton, textControl);
		// specificationArea.addMouseTrackListener(hoverListener);
		// textControl.addMouseMoveListener(mouseMoveListener);

		final StyledTextXtextAdapter xtextAdapter = new StyledTextXtextAdapter(
				getEmbeddedStatechartSpecificationInjector());
		xtextAdapter.getFakeResourceContext().getFakeResource().eAdapters().add(new ContextElementAdapter(this));
		xtextAdapter.adapt((StyledText) xtextControl);
		initContextMenu(xtextControl);
		CompletionProposalAdapter adapter = new CompletionProposalAdapter(xtextControl,
				xtextAdapter.getContentAssistant(),
				org.eclipse.jface.bindings.keys.KeyStroke.getInstance(SWT.CTRL, SWT.SPACE), null);

		IEMFValueProperty modelProperty = EMFEditProperties.value(getEditingDomain(),
				SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION);

		ISWTObservableValue uiProperty = WidgetProperties.text(new int[]{SWT.FocusOut, SWT.DefaultSelection})
				.observe(xtextControl);
		ValidatingEMFDatabindingContext context = new ValidatingEMFDatabindingContext(this, this.getSite().getShell());
		context.bindValue(uiProperty, modelProperty.observe(getDiagram().getElement()), null,
				new UpdateValueStrategy() {
					@Override
					protected IStatus doSet(IObservableValue observableValue, Object value) {
						if (adapter != null && !adapter.isProposalPopupOpen())
							return super.doSet(observableValue, value);
						return Status.OK_STATUS;
					}
				});
		// TODO populate Propertiesview for StyledText control selection
		// TODO activate context menu entries like in StatechartTextEditPart
	}

	protected StyledText createXtextControl(Composite definitionSection) {
		StyledText textControl = new StyledText(definitionSection, SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);
		textControl.setAlwaysShowScrollBars(false);
		textControl.setBackground(ColorConstants.white);
		GridDataFactory.fillDefaults().grab(true, true).indent(10, 5).applyTo(textControl);
		return textControl;
	}

	protected Composite createDefinitionSectionLabels(Composite definitionSection) {
		Composite labelComposite = new Composite(definitionSection, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(0, 0).applyTo(labelComposite);
		createDefinitionSectionImageLabel(labelComposite);
		Label nameLabel = createDefinitionSectionNameLabel(labelComposite);
		createSeparator(definitionSection);
		createRotatedLabel(definitionSection, nameLabel.getFont());
		return labelComposite;
	}

	protected void createDefinitionSectionImageLabel(Composite labelComposite) {
		Label statechartImageLabel = new Label(labelComposite, SWT.NONE);
		statechartImageLabel.setImage(StatechartImages.MENU.image());
		GridDataFactory.fillDefaults().hint(21, 0).applyTo(statechartImageLabel);
	}

	protected Label createDefinitionSectionNameLabel(Composite labelComposite) {
		Label statechartNameLabel = new Label(labelComposite, SWT.NONE);
		statechartNameLabel.setText("Definition section");
		GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).indent(5, 0).grab(true, false)
				.applyTo(labelComposite);
		return statechartNameLabel;
	}

	protected void createSeparator(Composite definitionSection) {
		Label separator = new Label(definitionSection, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().span(2, 1).indent(-10, 0).grab(true, false).applyTo(separator);
	}

	protected void createRotatedLabel(Composite definitionSection, Font font) {
		RotatedLabel label = new RotatedLabel(definitionSection, SWT.NONE);
		label.setText("Definition section", font);
		GridDataFactory.fillDefaults().grab(false, true).hint(MIN_CONTROL_SIZE[0], definitionSection.getBounds().height)
				.applyTo(label);
	}

	protected Button createExpandControl(Composite definitionSection) {
		Button expandButton = new Button(definitionSection, SWT.PUSH);
		expandButton.setToolTipText("Hide statechart definition section");
		expandButton.setImage(StatechartImages.COLLAPSE.image());
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
		IWorkbenchPartSite site = StatechartDiagramEditor.this.getSite();
		if (site != null)
			site.registerContextMenu("org.yakindu.base.xtext.utils.jface.viewers.StyledTextXtextAdapterContextMenu",
					menuManager, site.getSelectionProvider());
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected static class SpecificationControlAdapter {

		protected static final int BORDERWIDTH = 4;

		/**
		 * Updates the weights of the parent, which is a SashForm
		 * 
		 * @param parent
		 *            The parent of the controls
		 * @param prominentControl
		 *            The control that should be always prominent in the SashForm, that
		 *            is, the SashForm must not intercept the prominent control.
		 */
		protected static void updateSashWidths(Composite parent, Control prominentControl) {
			int width = parent.getBounds().width;
			((SashForm) parent).setWeights(new int[]{prominentControl.getBounds().width + BORDERWIDTH, width});
		}

		/**
		 * @author robert rudi - Initial contribution and API
		 * 
		 */
		protected static class ResizeListener extends ControlAdapter {

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
				if (!definitionSectionIsExpanded) {
					if (definitionSection.getBounds().width != control.getBounds().width) {
						updateSashWidths(parent, control);
					}
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
		protected static class SwitchListener extends SelectionAdapter {

			protected final Composite parent;
			protected final Control control;
			protected final StyledText textControl;

			protected static final String SHOW_TOOLTIP = "Show ";
			protected static final String HIDE_TOOLTIP = "Hide ";
			protected static final String STATECHART_SPECIFICATION_SECTION_TOOLTIP_TEXT = "statechart definintion section";
			protected final Image EXPAND_IMAGE = StatechartImages.EXPAND.image();
			protected final Image COLLAPSE_IMAGE = StatechartImages.COLLAPSE.image();

			// indices: 0 - first sash width, 1 - second sash width
			// needed to restore sashwidths
			protected int[] previousWidths = new int[]{2, 10};

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
				definitionSectionIsExpanded = textControl.isVisible();
				if (textControl.isVisible()) { // Show both components in the parent SashForm
					updateProminentControl(HIDE_TOOLTIP, COLLAPSE_IMAGE);
					((SashForm) parent).setWeights(new int[]{previousWidths[0], previousWidths[1]});
					textControlIsFocused = true;
				} else { // hides the textControl in the SashForm
					updateProminentControl(SHOW_TOOLTIP, EXPAND_IMAGE);
					saveLastSashWidths();
					updateSashWidths(parent, control);
					textControlIsFocused = false;
				}
				parent.setRedraw(true);
			}

			protected void saveLastSashWidths() {
				previousWidths[0] = ((SashForm) parent).getWeights()[0];
				previousWidths[1] = ((SashForm) parent).getWeights()[1];
			}

			/**
			 * Updates the tooltip text and the image for the prominent control.
			 * 
			 * @param tooltipText
			 *            The tooltip text for the control
			 * @param image
			 *            The image for the controls
			 */
			protected void updateProminentControl(String tooltipText, Image image) {
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

		/**
		 * @author robert rudi - Initial contribution and API
		 * 
		 */
		private abstract static class SwitchHoverListener extends SwitchListener
				implements
					MouseTrackListener,
					MouseMoveListener {
			protected SwitchHoverListener(Composite parent, Control expandButton, StyledText textControl) {
				super(parent, expandButton, textControl);
			}
		}

		/**
		 * @author robert rudi - Initial contribution and API
		 * 
		 */
		protected static class HoverListener extends SwitchHoverListener {
			protected HoverListener(Composite parent, Control expandButton, StyledText textControl) {
				super(parent, expandButton, textControl);
			}

			@Override
			public void mouseEnter(MouseEvent e) {

			}

			@Override
			public void mouseExit(MouseEvent e) {
				// checks if current mouseposition is left from specification area
				if (e.x < textControl.getBounds().x
						&& (!definitionSectionIsExpanded && (!textControlIsFocused || e.x < 0))) {
					try {
						if (textControl.isVisible()) {
							Thread.sleep(250);
							parent.setRedraw(false);
							textControlIsFocused = false;
							textControl.setVisible(false);
							updateProminentControl(SHOW_TOOLTIP, EXPAND_IMAGE);
							saveLastSashWidths();
							updateSashWidths(parent, control);
							parent.setRedraw(true);
						}
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void mouseHover(MouseEvent e) {
				if (!definitionSectionIsExpanded) {
					if (!textControl.isVisible()) {
						parent.setRedraw(false);
						textControlIsFocused = true;
						textControl.setVisible(true);
						updateProminentControl(HIDE_TOOLTIP, COLLAPSE_IMAGE);
						((SashForm) parent).setWeights(new int[]{previousWidths[0], previousWidths[1]});
						parent.setRedraw(true);
					}
				}
			}

			@Override
			public void mouseMove(MouseEvent e) {
				if (!definitionSectionIsExpanded) {
					int textControlArea = (textControl.getBounds().width - (textControl.getBorderWidth() * 3));
					if (e.x < textControlArea) {
						textControlIsFocused = true;
					} else {
						parent.setRedraw(false);
						textControlIsFocused = false;
						textControl.setVisible(false);
						updateProminentControl(SHOW_TOOLTIP, EXPAND_IMAGE);
						saveLastSashWidths();
						updateSashWidths(parent, control);
						parent.setRedraw(true);
					}
				}
			}
		}

	}

	@Override
	protected boolean isDefinitionSectionInlined() {
		BooleanValueStyle style = DiagramPartitioningUtil.getInlineDefinitionSectionStyle(getDiagram());
		return style != null ? style.isBooleanValue() : true;
	}

	public class RotatedLabel extends Canvas {

		private String text;
		float rotatingAngle = -90f;

		public RotatedLabel(Composite parent, int style) {
			super(parent, style);

			this.addPaintListener(new PaintListener() {
				public void paintControl(PaintEvent e) {
					if (!definitionSectionIsExpanded) {
						paint(e);
					}
				}
			});
			this.addListener(SWT.MouseDown, new Listener() {

				@Override
				public void handleEvent(Event event) {
					if (switchListener != null && !definitionSectionIsExpanded)
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

		public void paint(PaintEvent e) {
			Transform tr = null;
			tr = new Transform(e.display);
			int w = e.width;
			int h = e.height;
			tr.translate(w / 2, h / 3);
			tr.rotate(rotatingAngle);
			e.gc.setTransform(tr);
			int drawHeight = -((w / 3) * 2);
			e.gc.drawString(text, 0, (drawHeight % 2) != 0 ? drawHeight - 1 : drawHeight);
		}
	}

}
