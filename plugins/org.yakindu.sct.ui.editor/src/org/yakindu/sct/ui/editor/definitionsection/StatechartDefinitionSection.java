/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.ui.editor.definitionsection;

import static org.yakindu.sct.ui.editor.definitionsection.ContextScopeHandler.EMBEDDED_TEXT_EDITOR_SCOPE;
import static org.yakindu.sct.ui.editor.definitionsection.ContextScopeHandler.TEXT_EDITOR_SCOPE;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackListener;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableEditor;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.XMLMemento;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.xtext.utils.jface.viewers.FilteringMenuManager;
import org.yakindu.base.xtext.utils.jface.viewers.XtextStyledTextSelectionProvider;
import org.yakindu.base.xtext.utils.jface.viewers.context.XtextFakeResourceContext;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.util.ContextElementAdapter;
import org.yakindu.sct.ui.editor.StatechartImages;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningEditor;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.propertysheets.ValidatingEMFDatabindingContext;

import com.google.inject.Injector;

/**
 *
 * @author robert rudi - Initial contribution and API
 *
 */
@SuppressWarnings("restriction")
public class StatechartDefinitionSection extends Composite implements IPersistableEditor, IPersistableElement {

	protected static final String SHOW_SECTION_TOOLTIP = "Show definition section";
	protected static final String HIDE_SECTION_TOOLTIP = "Hide definition section";

	protected static final int SASH_WIDTH = 5;
	protected static final int BORDERWIDTH = 2;
	protected static final int MAXIMIZED_CONTROL_INDEX = 1;
	protected static final String REGEX_NO_WORD_NO_WHITESPACE = "[^\\w[\\s+]]";
	protected static final String MEM_EXPANDED = "DefinitionSectionIsExpanded";
	protected static final String MEM_FIRST_WEIGHT = "FirstSashWeight";
	protected static final String MEM_SECOND_WEIGHT = "SecondSashWeight";
	protected static final int[] MIN_SIZE = { 11, 21 };
	protected static final int[] DEFAULT_WEIGHTS = new int[] { 2, 10 };
	protected int[] previousWidths = DEFAULT_WEIGHTS;
	private boolean sectionExpanded = true;

	private MouseListener mouseListener;
	private ResizeListener resizeListener;
	private ModifyListener nameModificationListener;

	private Label switchControl;
	private Composite labelComposite;
	private CollapsedBorder collapsedBorder;
	private InlineIcon inlineIcon;

	private EmbeddedEditor embeddedEditor;
	private XtextResource xtextResource;
	private SashForm sash;
	private DiagramPartitioningEditor editorPart;

	private static IMemento memento;
	private ValidatingEMFDatabindingContext context;

	private DefinitionSectionSynchronizer synchronizer;
	private Text nameLabel;

	public StatechartDefinitionSection(Composite parent, int style, DiagramPartitioningEditor editorPart) {
		super(parent, style);
		this.sash = (SashForm) parent;
		this.editorPart = editorPart;
		this.switchControl = createSwitchControl();
		this.labelComposite = createDefinitionSectionComponents();
		this.embeddedEditor = createSpecificationEditor();
		registerResizeListener();
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(0, 0).applyTo(this);
		initSynchronizer();
	}

	protected Label createSwitchControl() {
		Label switchControl = new Label(this, SWT.PUSH);
		switchControl.setToolTipText(sectionExpanded ? HIDE_SECTION_TOOLTIP : SHOW_SECTION_TOOLTIP);
		switchControl.setImage(sectionExpanded ? StatechartImages.COLLAPSE.image() : StatechartImages.EXPAND.image());
		switchControl.setCursor(new Cursor(getDisplay(), SWT.CURSOR_HAND));
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).indent(-1, -1).hint(MIN_SIZE[0], MIN_SIZE[1])
		.applyTo(switchControl);
		mouseListener = new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				toggleExpandState();
			}
		};
		switchControl.addMouseListener(mouseListener);
		return switchControl;
	}

	protected Composite createDefinitionSectionComponents() {
		Composite labelComposite = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(0, 0).applyTo(labelComposite);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(labelComposite);
		createNameLabel(labelComposite);
		createInlineIcon(labelComposite);
		createSeparator(this);
		createCollapsedBorder(this);
		return labelComposite;
	}

	protected void initSynchronizer() {
		synchronizer = new DefinitionSectionSynchronizer();
		getContextObject().eAdapters().add(synchronizer);
	}

	protected void removeSynchronizer() {
		getContextObject().eAdapters().remove(synchronizer);
	}

	protected void createNameLabel(Composite labelComposite) {
		nameLabel = new Text(labelComposite, SWT.SINGLE | SWT.NORMAL);
		GridDataFactory.fillDefaults().indent(5, 1).grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(nameLabel);
		Optional<String> name = getStatechartName();
		if (name.isPresent()) {
			nameLabel.setText(name.get());
		}
		nameLabel.setEditable(isStatechart());
		nameLabel.setBackground(ColorConstants.white);
		nameModificationListener = new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				Optional<Statechart> sct = getStatechart();
				if (sct.isPresent()) {
					if (Objects.equals(sct.get().getName(), nameLabel.getText())) {
						return;
					}
					getSash().setRedraw(false);
					TransactionalEditingDomain domain = getTransactionalEditingDomain();
					SetCommand command = new SetCommand(domain, sct.get(),
							BasePackage.Literals.NAMED_ELEMENT__NAME, nameLabel.getText());
					domain.getCommandStack().execute(command);
					refresh(nameLabel.getParent());
					getSash().setRedraw(true);
				}
			}
		};
		nameLabel.addModifyListener(nameModificationListener);
	}

	protected Optional<String> getStatechartName() {
		Statechart statechart = EcoreUtil2.getContainerOfType(getContextObject(), Statechart.class);
		if (statechart == null) {
			return Optional.empty();
		}
		return Optional.ofNullable(statechart.getName());
	}

	protected void createInlineIcon(Composite labelComposite) {
		inlineIcon = new InlineIcon(labelComposite, SWT.FILL);
	}

	protected boolean isStatechart() {
		return getContextObject() instanceof Statechart;
	}

	protected Optional<Statechart> getStatechart() {
		return Optional.ofNullable(EcoreUtil2.getContainerOfType(getContextObject(), Statechart.class));
	}

	protected void createSeparator(Composite definitionSection) {
		Label separator = new Label(definitionSection, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().span(2, 1).grab(true, false).applyTo(separator);
	}

	protected void createCollapsedBorder(Composite definitionSection) {
		collapsedBorder = new CollapsedBorder(definitionSection, SWT.NONE);
		refresh(definitionSection);
	}

	protected void refresh(Composite comp) {
		comp.layout(false, true);
		comp.redraw();
		comp.update();
	}

	protected EmbeddedEditor createSpecificationEditor() {
		ContextScopeHandler.defineContext(EMBEDDED_TEXT_EDITOR_SCOPE, TEXT_EDITOR_SCOPE);
		EmbeddedEditor embeddedEditor = createEmbeddedEditor();
		embeddedEditor.createPartialEditor();
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(embeddedEditor.getViewer().getControl());
		StyledText text = embeddedEditor.getViewer().getTextWidget();
		text.setAlwaysShowScrollBars(false);
		text.setSelection(0);
		text.setKeyBinding(SWT.MOD1 | SWT.KEY_MASK & 'a', ST.SELECT_ALL);
		initXtextSelectionProvider(text);
		initContextMenu(text);
		text.addModifyListener((event) -> editorPart.firePropertyChange(IEditorPart.PROP_DIRTY));
		return embeddedEditor;
	}

	protected EmbeddedEditor createEmbeddedEditor() {
		Injector embeddedEditorInjector = getEmbeddedStatechartSpecificationInjector();
		EmbeddedEditorFactory instance = embeddedEditorInjector.getInstance(EmbeddedEditorFactory.class);
		IEditedResourceProvider provider = getXtextResourceProvider(embeddedEditorInjector);
		return instance.newEditor(provider).showErrorAndWarningAnnotations().withParent(this);
	}

	protected Injector getEmbeddedStatechartSpecificationInjector() {
		IDomain domain = DomainRegistry.getDomain(getContextObject());
		return domain.getInjector(IDomain.FEATURE_EDITOR, Statechart.class.getName());
	}

	protected IEditedResourceProvider getXtextResourceProvider(Injector injector) {
		return new IEditedResourceProvider() {

			@Override
			public XtextResource createResource() {
				IProject activeProject = WorkspaceSynchronizer.getFile(getContextObject().eResource()).getProject();
				XtextFakeResourceContext resource = new XtextFakeResourceContext(injector, activeProject);
				xtextResource = resource.getFakeResource();
				xtextResource.eAdapters().add(new ContextElementAdapter(getContextObject()));
				return xtextResource;
			}
		};
	}

	@SuppressWarnings("unused")
	protected void initXtextSelectionProvider(StyledText widget) {
		try {
			XtextStyledTextSelectionProvider provider = new XtextStyledTextSelectionProvider(widget, xtextResource);
			StyledTextSelectionListener listener = new StyledTextSelectionListener(this.editorPart.getSite(), widget,
					provider);
		} catch (NullPointerException e) {
			// do nothing, not opened within editor context
		}
	}

	protected void activate() {
		initBinding(embeddedEditor.getViewer().getTextWidget());
		getSash().setMaximizedControl(null);
	}

	protected void deactivate() {
		getSash().setMaximizedControl(getSash().getChildren()[MAXIMIZED_CONTROL_INDEX]);
		if (context != null)
			context.dispose();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void initBinding(StyledText text) {
		IEMFValueProperty modelProperty = EMFEditProperties.value(getTransactionalEditingDomain(),
				SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION);
		ISWTObservableValue uiProperty = WidgetProperties.text(new int[] { SWT.FocusOut }).observe(text);
		IObservableValue modelPropertyObservable = modelProperty.observe(getContextObject());
		context = new ValidatingEMFDatabindingContext((EObject)editorPart.getAdapter(EObject.class),
				editorPart.getSite().getShell());
		context.bindValue(uiProperty, modelPropertyObservable, null, null);
	}

	protected void initContextMenu(Control control) {
		MenuManager menuManager = new FilteringMenuManager();
		Menu contextMenu = menuManager.createContextMenu(control);
		control.setMenu(contextMenu);
		IWorkbenchPartSite site = editorPart.getSite();
		if (site != null)
			site.registerContextMenu("org.yakindu.base.xtext.utils.jface.viewers.StyledTextXtextAdapterContextMenu",
					menuManager, site.getSelectionProvider());
	}

	protected void registerResizeListener() {
		resizeListener = new ResizeListener();
		getSash().addControlListener(resizeListener);
		embeddedEditor.getViewer().getTextWidget().addControlListener(resizeListener);
	}

	protected TransactionalEditingDomain getTransactionalEditingDomain() {
		return (TransactionalEditingDomain) editorPart.getAdapter(TransactionalEditingDomain.class);
	}

	public EObject getContextObject() {
		return (EObject) editorPart.getAdapter(EObject.class);
	}

	protected Diagram getDiagram() {
		return (Diagram) editorPart.getAdapter(Diagram.class);
	}

	protected void toggleDefinitionSection() {
		toggleInlineStyle();
		updateStyle();
		refreshEditorContents();
	}

	private void toggleInlineStyle() {
		TransactionalEditingDomain domain = getTransactionalEditingDomain();
		Diagram diagram = getDiagram();
		BooleanValueStyle inlineStyle = DiagramPartitioningUtil.getInlineDefinitionSectionStyle(diagram);
		if (inlineStyle == null) {
			inlineStyle = DiagramPartitioningUtil.createInlineDefinitionSectionStyle();
			AddCommand command = new AddCommand(domain, getDiagram(), NotationPackage.Literals.VIEW__STYLES,
					inlineStyle);
			domain.getCommandStack().execute(command);
		}
		SetCommand command = new SetCommand(domain, inlineStyle,
				NotationPackage.Literals.BOOLEAN_VALUE_STYLE__BOOLEAN_VALUE, !inlineStyle.isBooleanValue());
		domain.getCommandStack().execute(command);
	}

	public void updateStyle() {
		if (isInlined()) {
			deactivate();
		} else {
			activate();
		}
	}

	protected boolean isInlined() {
		BooleanValueStyle style = DiagramPartitioningUtil.getInlineDefinitionSectionStyle(getDiagram());
		return style != null ? style.isBooleanValue() : true;
	}

	protected void collapseDefinitionSection() {
		int parentWidth = getSash().getBounds().width;
		int switchControlWidth = getSwitchControlWidth();
		int[] sashWidths = getCollapsedSashWidths(parentWidth, switchControlWidth);
		layoutDefinitionSection(0, sashWidths, false, 1);
	}

	protected void expandDefinitionSection() {
		layoutDefinitionSection(SASH_WIDTH, previousWidths, true, 2);
	}

	protected int getSwitchControlWidth() {
		return switchControl.getBounds().width + BORDERWIDTH;
	}

	protected int[] getCollapsedSashWidths(int parentWidth, int switchControlWidth) {
		int diff = parentWidth - switchControlWidth;
		if (diff < 0) {
			return DEFAULT_WEIGHTS;
		}
		return new int[] { switchControlWidth, (diff % 2 != 0) ? diff - (1 + BORDERWIDTH) : diff };
	}

	protected void layoutDefinitionSection(int sashWidth, int[] weights, boolean visible, int hSpan) {
		getSash().setRedraw(false);
		getSash().setSashWidth(sashWidth);
		getSash().setWeights(weights);
		embeddedEditor.getViewer().getControl().setVisible(visible);
		labelComposite.setVisible(visible);
		if (visible)
			refreshSwitchControl(HIDE_SECTION_TOOLTIP, StatechartImages.COLLAPSE.image());
		else
			refreshSwitchControl(SHOW_SECTION_TOOLTIP, StatechartImages.EXPAND.image());
		layoutCollapsedBorder(hSpan);
		layoutEmbeddedEditor(hSpan);
		refresh(getSash());
		getSash().setRedraw(true);
	}

	protected void toggleExpandState() {
		getSash().setRedraw(false);
		sectionExpanded = !sectionExpanded;
		if (sectionExpanded) {
			expandDefinitionSection();
		} else {
			collapseDefinitionSection();
		}
		getSash().setRedraw(true);
	}

	protected void layoutEmbeddedEditor(int hSpan) {
		((GridData) embeddedEditor.getViewer().getControl().getLayoutData()).horizontalSpan = hSpan;
	}

	protected void layoutCollapsedBorder(int hSpan) {
		((GridData) collapsedBorder.getLayoutData()).horizontalSpan = hSpan;
	}

	protected void refreshSwitchControl(String tooltipText, Image image) {
		switchControl.setToolTipText(tooltipText);
		switchControl.setImage(image);
	}

	@Override
	public void dispose() {
		saveState(memento);
		removeSynchronizer();
		disposeEmbeddedEditor();
		super.dispose();
	}

	protected void disposeEmbeddedEditor() {
		if (mouseListener != null && switchControl != null && !switchControl.isDisposed()) {
			switchControl.removeMouseListener(mouseListener);
			mouseListener = null;
			switchControl.dispose();
			switchControl = null;
		}
		if (inlineIcon != null && !inlineIcon.isDisposed())
			inlineIcon.dispose();

		if (collapsedBorder != null && !collapsedBorder.isDisposed())
			collapsedBorder.dispose();

		if (embeddedEditor != null) {
			embeddedEditor.getDocument().getValidationJob().cancel();
			StyledText embeddedEditorWidget = embeddedEditor.getViewer().getTextWidget();
			if (embeddedEditorWidget != null && !embeddedEditorWidget.isDisposed()) {
				if (resizeListener != null) {
					embeddedEditorWidget.removeControlListener(resizeListener);
					getSash().removeControlListener(resizeListener);
					resizeListener = null;
				}
				embeddedEditorWidget.dispose();
				embeddedEditorWidget = null;
				embeddedEditor = null;
			}
		}
		nameModificationListener = null;
	}
	
	public void validateEmbeddedEditorContext() {
		if(embeddedEditor == null || embeddedEditor.getDocument() == null || embeddedEditor.getDocument().getValidationJob() == null) 
			return;
		embeddedEditor.getDocument().getValidationJob().schedule();
	}

	public SashForm getSash() {
		return this.sash;
	}

	protected void refreshEditorContents() {
		((List<?>) ((DiagramEditPart) editorPart.getAdapter(DiagramEditPart.class)).getChildren()).forEach(part -> {
			if (part instanceof EditPart)
				((EditPart) part).refresh();
		});
	}

	@Override
	public String getFactoryId() {
		return editorPart.getEditorInput().getPersistable().getFactoryId();
	}

	public void restoreSashWidths() {
		if (memento == null) {
			saveState(memento);
		}
		restoreState(memento);
	}

	@Override
	public void saveState(IMemento memento) {
		if (memento == null) {
			memento = XMLMemento.createWriteRoot(getFactoryId());
		}
		setMementoProperties(memento);
		saveCurrentMemento(memento);
	}

	@Override
	public void restoreState(IMemento memento) {
		if (getSash() != null && memento != null) {
			Boolean hasMemento = getExpandProperty(memento);
			if (hasMemento != null) {
				previousWidths = getWeightProperties(memento);
				sectionExpanded = hasMemento.booleanValue();
				refreshEditorContents();
				saveCurrentMemento(memento);
			} else {
				saveState(memento);
			}
			getSash().setWeights(previousWidths);
		}
	}

	protected void saveCurrentMemento(IMemento memento) {
		StatechartDefinitionSection.memento = memento;
	}

	protected void setMementoProperties(IMemento memento) {
		String sectionProperty = getSectionProperty(getContextObject());
		memento.putInteger(sectionProperty + MEM_FIRST_WEIGHT, previousWidths[0]);
		memento.putInteger(sectionProperty + MEM_SECOND_WEIGHT, previousWidths[1]);
		memento.putBoolean(sectionProperty + MEM_EXPANDED, sectionExpanded);
	}

	protected String getSectionProperty(EObject element) {
		return stripElementName(((NamedElement) element).getName());
	}

	protected String stripElementName(String name) {
		if (name != null)
			return name.replaceAll(REGEX_NO_WORD_NO_WHITESPACE, "");
		return "";
	}

	protected Boolean getExpandProperty(IMemento memento) {
		String expandProperty = getSectionProperty(getContextObject()) + MEM_EXPANDED;
		return memento.getBoolean(expandProperty);
	}

	protected int[] getWeightProperties(IMemento memento) {
		String sectionProperty = getSectionProperty(getContextObject());
		Integer first = memento.getInteger(sectionProperty + MEM_FIRST_WEIGHT);
		Integer second = memento.getInteger(sectionProperty + MEM_SECOND_WEIGHT);
		if (first != null && second != null)
			return new int[] { first, second };
		return DEFAULT_WEIGHTS;
	}

	public String getDefinition() {
		if (isInlined())
			return null;
		return embeddedEditor.getDocument().get();
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 *
	 */
	protected class ResizeListener extends ControlAdapter {

		private static final int DELAY = 150;
		private Job resizeFinishedJob = new Job("Resizing...") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						if (isDisposed() || getSash().isDisposed())
							return;
						if (sectionExpanded) {
							// save current weights so the widths can later be restored
							previousWidths = getSash().getWeights();
							saveState(memento);
						} else {
							// keep sash collapsed
							if (getBounds().width != getSwitchControlWidth()) {
								collapseDefinitionSection();
							}
						}
					}
				});
				return Status.OK_STATUS;
			}
		};

		@Override
		public void controlResized(ControlEvent e) {
			handleControlChanged();
		}

		@Override
		public void controlMoved(ControlEvent e) {
			handleControlChanged();
		}

		protected void handleControlChanged() {
			resizeFinishedJob.cancel();
			resizeFinishedJob.schedule(DELAY);
		}

	}

	/**
	 * @author robert rudi - Initial contribution and API
	 *
	 */
	protected class InlineIcon extends Composite implements MouseListener, MouseTrackListener, PaintListener {

		protected static final String INLINE_TOOLTIP = "Inline definition section";
		private Cursor handCursor = new Cursor(getDisplay(), SWT.CURSOR_HAND);
		private boolean iconHasFocus = false;
		private Label icon;

		public InlineIcon(Composite parent, int style) {
			super(parent, style);
			GridLayoutFactory.fillDefaults().applyTo(this);
			icon = new Label(this, style);
			icon.setCursor(handCursor);
			icon.setImage(StatechartImages.PIN.image());
			icon.setToolTipText(INLINE_TOOLTIP);
			icon.setEnabled(isStatechart());
			icon.addMouseListener(this);
			icon.addMouseTrackListener(this);
			icon.addPaintListener(this);
		}

		@Override
		public void mouseUp(MouseEvent e) {
			toggleDefinitionSection();
			saveState(memento);
		}

		@Override
		public void mouseDoubleClick(MouseEvent e) {
		}

		@Override
		public void mouseDown(MouseEvent e) {
		}

		@Override
		public void mouseHover(MouseEvent e) {
		}

		@Override
		public void mouseEnter(MouseEvent e) {
			iconHasFocus = true;
			icon.redraw();
		}

		@Override
		public void mouseExit(MouseEvent e) {
			iconHasFocus = false;
			icon.redraw();
		}

		@Override
		public void paintControl(PaintEvent e) {
			if (iconHasFocus) {
				drawIconBorder(this.icon, e.gc);
			}
		}

		protected void drawIconBorder(Label icon, GC gc) {
			Rectangle rect = new Rectangle(0, 0, icon.getBounds().width - 1, icon.getBounds().height - 1);
			Transform t = new Transform(getDisplay());
			gc.setTransform(t);
			t.dispose();
			gc.setForeground(ColorConstants.lightGray);
			gc.drawRectangle(0, 0, rect.width, rect.height);
		}

		@Override
		public void dispose() {
			icon.removeMouseListener(this);
			icon.removeMouseTrackListener(this);
			icon.removePaintListener(this);
			handCursor.dispose();
			icon.dispose();
			super.dispose();
		}

	}

	/**
	 * @author robert rudi - Initial contribution and API
	 *
	 */
	protected class CollapsedBorder extends Canvas implements MouseListener, MouseTrackListener, PaintListener {

		private String text;
		float rotationAngle = -90f;
		private Font font = new Font(getDisplay(), "Segoe UI", 8, SWT.NORMAL);
		private Cursor arrowCursor = new Cursor(getDisplay(), SWT.CURSOR_ARROW);
		private Cursor handCursor = new Cursor(getDisplay(), SWT.CURSOR_HAND);

		public CollapsedBorder(Composite parent, int style) {
			super(parent, style);
			setText("Definition section", font);
			GridDataFactory.fillDefaults().grab(false, false).span(2, 1).hint(0, parent.getBounds().height)
			.applyTo(this);
			addPaintListener(this);
			addMouseListener(this);
			addMouseTrackListener(this);
		}

		public void setText(String string, Font font) {
			this.text = string;
			setFont(font);
			refresh(this);
		}

		@Override
		public void paintControl(PaintEvent e) {
			int w = e.width;
			int h = e.height;
			Transform tr = new Transform(e.display);
			tr.translate(w / 2, h / 2);
			tr.rotate(rotationAngle);
			e.gc.setTransform(tr);
			tr.dispose();
			int drawHeight = -w + 2;
			e.gc.drawString(sectionExpanded ? "" : text, 0, drawHeight % 2 != 0 ? drawHeight + 1 : drawHeight - 1);
		}

		@Override
		public void mouseUp(MouseEvent e) {
			if (!sectionExpanded)
				toggleExpandState();
			setCursor(arrowCursor);
		}

		@Override
		public void mouseDown(MouseEvent e) {
			if (mouseListener != null && !sectionExpanded)
				toggleExpandState();
		}

		@Override
		public void mouseEnter(MouseEvent e) {
			setCursor((!sectionExpanded) ? handCursor : arrowCursor);
			setToolTipText((!sectionExpanded) ? SHOW_SECTION_TOOLTIP : null);
		}

		@Override
		public void mouseExit(MouseEvent e) {
		}

		@Override
		public void mouseHover(MouseEvent e) {
		}

		@Override
		public void mouseDoubleClick(MouseEvent e) {
		}

		@Override
		public void dispose() {
			removePaintListener(this);
			removeMouseListener(this);
			removeMouseTrackListener(this);
			handCursor.dispose();
			arrowCursor.dispose();
			font.dispose();
			super.dispose();
		}
	}

	/**
	 * @author BeckmaR
	 *
	 *         Adapter for updating the name label on statechart name change
	 *         event.
	 */
	protected class DefinitionSectionSynchronizer extends AdapterImpl {
		@Override
		public void notifyChanged(Notification notification) {
			if (Notification.SET == notification.getEventType()) {
				if (BasePackage.Literals.NAMED_ELEMENT__NAME.equals(notification.getFeature())) {
					nameLabel.setText(notification.getNewStringValue());
				}
			}
		}
		@Override
		public boolean isAdapterForType(Object type) {
			return type instanceof DefinitionSectionSynchronizer;
		}
	}
}
