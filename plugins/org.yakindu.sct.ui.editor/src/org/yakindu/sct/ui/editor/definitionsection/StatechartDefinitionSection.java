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

import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
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
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
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
import org.yakindu.sct.model.sgraph.util.ContextElementAdapter.IContextElementProvider;
import org.yakindu.sct.ui.editor.StatechartImages;
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

	protected static final String INLINE_TOOLTIP = "Inline definition section";
	protected static final String SHOW_SECTION_TOOLTIP = "Show definition section";
	protected static final String HIDE_SECTION_TOOLTIP = "Hide definition section";

	protected static final int SASH_WIDTH = 5;
	protected static final int BORDERWIDTH = 2;
	protected static final int MAXIMIZED_CONTROL_INDEX = 1;
	protected static final String REGEX_NO_WORD_NO_WHITESPACE = "[^\\w[\\s+]]";
	protected static final String MEM_EXPANDED = "DefinitionSectionIsExpanded";
	protected static final String MEM_FIRST_WEIGHT = "FirstSashWeight";
	protected static final String MEM_SECOND_WEIGHT = "SecondSashWeight";
	protected static final int[] MIN_SIZE = {11, 21};
	protected static final int[] DEFAULT_WEIGHTS = new int[]{2, 10};
	protected int[] previousWidths = DEFAULT_WEIGHTS;
	private boolean isSectionExpanded = true;

	private SelectionListener selectionListener;
	private ResizeListener resizeListener;
	private InliningIconListener inliningIconListener;
	private NameModificationListener nameModificationListener;
	private CollapsedBorderMouseListener collapsedBorderMouseListener;
	private ReleaseSelectionOnFocusGain selectionProviderListener;
	private EmbeddedEditorKeyListener embeddedEditorKeyListener;

	private Label switchControl;
	private Composite labelComposite;
	private CollapsedBorder collapsedBorder;

	private EmbeddedEditor embeddedEditor;
	private XtextResource xtextResource;
	private SashForm sash;
	private IEditorPart editorPart;

	private static IMemento memento;

	public StatechartDefinitionSection(Composite parent, int style, IEditorPart editorPart) {
		super(parent, style);

		this.sash = (SashForm) parent;
		this.editorPart = editorPart;

		resizeListener = new ResizeListener(this);
		getSash().addControlListener(resizeListener);

		this.switchControl = createSwitchControl(this);
		this.labelComposite = createDefinitionSectionLabels(this);
		this.embeddedEditor = createSpecificationEditor(this);

		GridLayoutFactory.fillDefaults().numColumns(2).spacing(0, 0).applyTo(this);
	}

	protected Label createSwitchControl(Composite definitionSection) {
		Label switchControl = new Label(definitionSection, SWT.PUSH);
		switchControl.setToolTipText(HIDE_SECTION_TOOLTIP);
		switchControl.setImage(isSectionExpanded ? StatechartImages.COLLAPSE.image() : StatechartImages.EXPAND.image());
		switchControl.setCursor(new Cursor(getDisplay(), SWT.CURSOR_HAND));
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).indent(-1, 0).hint(MIN_SIZE[0], MIN_SIZE[1])
				.applyTo(switchControl);
		selectionListener = new SelectionListener();
		switchControl.addMouseListener(selectionListener);
		return switchControl;
	}

	protected Composite createDefinitionSectionLabels(Composite definitionSection) {
		Composite labelComposite = new Composite(definitionSection, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(0, 0).applyTo(labelComposite);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(labelComposite);
		createNameLabel(labelComposite);
		createInlineIcon(labelComposite);
		createSeparator(definitionSection);
		createCollapsedBorder(definitionSection);
		return labelComposite;
	}

	protected void createNameLabel(Composite labelComposite) {
		Text nameLabel = new Text(labelComposite, SWT.SINGLE | SWT.NORMAL);
		GridDataFactory.fillDefaults().indent(5, 1).grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(nameLabel);

		nameLabel.setText(getStatechartName());
		nameLabel.setEditable(isStatechart());
		nameLabel.setBackground(ColorConstants.white);
		nameModificationListener = new NameModificationListener(nameLabel);
		nameLabel.addModifyListener(nameModificationListener);
	}

	protected String getStatechartName() {
		Statechart statechart = EcoreUtil2.getContainerOfType(getContextObject(), Statechart.class);
		Assert.isNotNull(statechart);
		return statechart.getName();
	}

	protected void createInlineIcon(Composite labelComposite) {
		Label icon = new Label(labelComposite, SWT.FILL);
		icon.setImage(StatechartImages.PIN.image());
		icon.setToolTipText(INLINE_TOOLTIP);
		icon.setEnabled(isStatechart());
		labelComposite.setToolTipText(INLINE_TOOLTIP);
		GridDataFactory.fillDefaults().applyTo(icon);
		inliningIconListener = new InliningIconListener(icon);
		icon.addMouseListener(inliningIconListener);
		icon.addMouseTrackListener(inliningIconListener);
		icon.addPaintListener(inliningIconListener);
	}

	protected boolean isStatechart() {
		return getContextObject() instanceof Statechart;
	}

	protected void createSeparator(Composite definitionSection) {
		Label separator = new Label(definitionSection, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().span(2, 1).grab(true, false).applyTo(separator);
	}

	protected void createCollapsedBorder(Composite definitionSection) {
		collapsedBorder = new CollapsedBorder(definitionSection, SWT.NONE);
		GridDataFactory.fillDefaults().grab(false, false).span(2, 1).hint(0, definitionSection.getBounds().height)
				.applyTo(collapsedBorder);
		collapsedBorder.setText("Definition section", new Font(getDisplay(), "Segoe UI", 8, SWT.NORMAL));
		collapsedBorderMouseListener = new CollapsedBorderMouseListener(collapsedBorder);
		collapsedBorder.addMouseListener(collapsedBorderMouseListener);
		collapsedBorder.addMouseTrackListener(collapsedBorderMouseListener);
		refresh(definitionSection);
	}

	protected void refresh(Composite comp) {
		comp.layout(false, true);
		comp.redraw();
		comp.update();
	}

	protected EmbeddedEditor createSpecificationEditor(Composite definitionSection) {
		EmbeddedEditor embeddedEditor = createEmbeddedEditor(definitionSection);
		EmbeddedEditorModelAccess modelAccess = embeddedEditor.createPartialEditor();
		modelAccess.updateModel(((Statechart) getContextObject()).getSpecification());
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(embeddedEditor.getViewer().getControl());
		initializeEmbeddedEditorWidget(embeddedEditor);
		return embeddedEditor;
	}

	protected EmbeddedEditor createEmbeddedEditor(Composite definitionSection) {
		Injector embeddedEditorInjector = getEmbeddedStatechartSpecificationInjector();
		EmbeddedEditorFactory instance = embeddedEditorInjector.getInstance(EmbeddedEditorFactory.class);
		IEditedResourceProvider provider = getXtextResourceProvider(embeddedEditorInjector);
		return instance.newEditor(provider).showErrorAndWarningAnnotations().withParent(definitionSection);
	}

	protected Injector getEmbeddedStatechartSpecificationInjector() {
		IDomain domain = DomainRegistry.getDomain(getContextObject());
		return domain.getInjector(IDomain.FEATURE_EDITOR, Statechart.class.getName());
	}

	protected IEditedResourceProvider getXtextResourceProvider(Injector injector) {
		return new IEditedResourceProvider() {

			@Override
			public XtextResource createResource() {
				XtextFakeResourceContext resource = new XtextFakeResourceContext(injector);
				xtextResource = resource.getFakeResource();
				xtextResource.eAdapters()
						.add(new ContextElementAdapter(editorPart.getAdapter(IContextElementProvider.class)));
				return xtextResource;
			}
		};
	}

	protected void initializeEmbeddedEditorWidget(EmbeddedEditor embeddedEditor) {
		StyledText embeddedEditorWidget = embeddedEditor.getViewer().getTextWidget();
		embeddedEditorWidget.setAlwaysShowScrollBars(false);
		embeddedEditorWidget.setSelection(0);
		embeddedEditorKeyListener = new EmbeddedEditorKeyListener(embeddedEditorWidget);
		embeddedEditorWidget.addKeyListener(embeddedEditorKeyListener);
		embeddedEditorWidget.addControlListener(resizeListener);
		enableXtext(embeddedEditorWidget);
		initContextMenu(embeddedEditorWidget);
	}

	protected void enableXtext(StyledText embeddedEditorWidget) {
		initXtextSelectionProvider(embeddedEditorWidget);
		initBinding(embeddedEditorWidget);
	}

	protected void initXtextSelectionProvider(StyledText embeddedEditorWidget) {
		try {
			XtextStyledTextSelectionProvider styledTextSelectionProvider = new XtextStyledTextSelectionProvider(
					embeddedEditorWidget, xtextResource);
			ReleaseSelectionOnFocusGain selectionChangeListener = new ReleaseSelectionOnFocusGain(
					this.editorPart.getSite(), styledTextSelectionProvider);
			embeddedEditorWidget.addFocusListener(selectionChangeListener);
			embeddedEditorWidget.addDisposeListener(selectionChangeListener);
		} catch (NullPointerException e) {
			// do nothing
		}
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	protected void initBinding(StyledText embeddedEditorWidget) {
		IEMFValueProperty modelProperty = EMFEditProperties.value(getTransactionalEditingDomain(),
				SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION);
		ISWTObservableValue uiProperty = WidgetProperties.text(new int[]{SWT.FocusOut, SWT.Modify})
				.observe(embeddedEditorWidget);
		IObservableValue modelPropertyObservable = modelProperty
				.observe(EcoreUtil.getObjectByType(getContextContents(), SGraphPackage.Literals.STATECHART));
		ValidatingEMFDatabindingContext context = new ValidatingEMFDatabindingContext(
				(IContextElementProvider) editorPart, editorPart.getSite().getShell());
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

	protected TransactionalEditingDomain getTransactionalEditingDomain() {
		return editorPart.getAdapter(TransactionalEditingDomain.class);
	}

	protected EObject getContextObject() {
		return editorPart.getAdapter(EObject.class);
	}

	protected EList<?> getContextContents() {
		return editorPart.getAdapter(EList.class);
	}

	protected Diagram getDiagram() {
		return editorPart.getAdapter(Diagram.class);
	}

	protected void updateInlineStyle() {
		TransactionalEditingDomain domain = getTransactionalEditingDomain();
		Diagram diagram = getDiagram();
		BooleanValueStyle inlineStyle = DiagramPartitioningUtil.getInlineDefinitionSectionStyle(diagram);
		if (inlineStyle == null) {
			inlineStyle = DiagramPartitioningUtil.createInlineDefinitionSectionStyle();
			addInlineStyle(inlineStyle, domain);
		}
		setInlineStyleValue(inlineStyle, domain);
	}

	protected void setInlineStyleValue(BooleanValueStyle inlineStyle, TransactionalEditingDomain domain) {
		SetCommand command = new SetCommand(domain, inlineStyle,
				NotationPackage.Literals.BOOLEAN_VALUE_STYLE__BOOLEAN_VALUE, !inlineStyle.isBooleanValue());
		domain.getCommandStack().execute(command);
	}

	protected void addInlineStyle(BooleanValueStyle inlineStyle, TransactionalEditingDomain domain) {
		AddCommand command = new AddCommand(domain, (View) getDiagram(), NotationPackage.Literals.VIEW__STYLES,
				inlineStyle);
		domain.getCommandStack().execute(command);
	}

	public void toggleDefinitionSection() {
		getSash().setMaximizedControl(!isInlined() ? null : getSash().getChildren()[MAXIMIZED_CONTROL_INDEX]);
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
		return new int[]{switchControlWidth, (diff % 2 != 0) ? diff - (1 + BORDERWIDTH) : diff};
	}

	protected void layoutDefinitionSection(int sashWidth, int[] weights, boolean visible, int hSpan) {
		getSash().setRedraw(false);
		getSash().setSashWidth(sashWidth);
		getSash().setWeights(weights);
		getEmbeddedEditorWidget().setVisible(visible);
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
			StyledText embeddedEditorWidget = getEmbeddedEditorWidget();
			if (embeddedEditorWidget != null && !embeddedEditorWidget.isDisposed()) {
				if (resizeListener != null) {
					embeddedEditorWidget.removeControlListener(resizeListener);
					getSash().removeControlListener(resizeListener);
					resizeListener = null;
				}
				if (embeddedEditorKeyListener != null) {
					embeddedEditorWidget.removeKeyListener(embeddedEditorKeyListener);
					embeddedEditorKeyListener = null;
				}
				if (selectionProviderListener != null) {
					embeddedEditorWidget.removeFocusListener(selectionProviderListener);
					embeddedEditorWidget.removeDisposeListener(selectionProviderListener);
					selectionProviderListener = null;
				}
				if (collapsedBorder != null && !collapsedBorder.isDisposed()) {
					collapsedBorder.removeMouseListener(collapsedBorderMouseListener);
					collapsedBorder.removeMouseTrackListener(collapsedBorderMouseListener);
					collapsedBorderMouseListener = null;
				}

				embeddedEditorWidget.dispose();
				embeddedEditorWidget = null;
				embeddedEditor = null;
			}
		}
		inliningIconListener = null;
		nameModificationListener = null;
	}

	public SashForm getSash() {
		return this.sash;
	}

	protected StyledText getEmbeddedEditorWidget() {
		return embeddedEditor.getViewer().getTextWidget();
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
				isSectionExpanded = hasMemento.booleanValue();
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
		memento.putBoolean(sectionProperty + MEM_EXPANDED, isSectionExpanded);
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
			return new int[]{first, second};
		return DEFAULT_WEIGHTS;
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
	protected class CollapsedBorderMouseListener implements MouseListener, MouseTrackListener {
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

		@Override
		public void mouseEnter(MouseEvent e) {
			collapsedBorder
					.setCursor(new Cursor(getDisplay(), (!isSectionExpanded) ? SWT.CURSOR_HAND : SWT.CURSOR_ARROW));
			collapsedBorder.setToolTipText((!isSectionExpanded) ? SHOW_SECTION_TOOLTIP : null);
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
		public void mouseDown(MouseEvent e) {
		}
	}

	/**
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected class InliningIconListener implements MouseListener, MouseTrackListener, PaintListener {

		private Label icon;
		private boolean iconHasFocus = false;

		protected InliningIconListener(Label icon) {
			this.icon = icon;
		}

		@Override
		public void mouseUp(MouseEvent e) {
			updateInlineStyle();
			toggleDefinitionSection();
			refreshEditorContents();
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
			icon.setCursor(new Cursor(getDisplay(), SWT.CURSOR_HAND));
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
				drawIconBorder(icon, e.gc);
			}
		}

		protected void drawIconBorder(Label icon, GC gc) {
			Rectangle rect = new Rectangle(0, 0, icon.getBounds().width - 1, icon.getBounds().height - 1);
			Transform t = new Transform(getDisplay());
			gc.setTransform(t);
			gc.setForeground(ColorConstants.lightGray);
			gc.drawRectangle(0, 0, rect.width, rect.height);
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
				saveState(memento);
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

		protected void handleSelection() {
			getSash().setRedraw(false);
			isSectionExpanded = !isSectionExpanded;
			if (isSectionExpanded) {
				expandDefinitionSection();
			} else {
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
		private Listener mouseDownListener;
		private PaintListener paintListener;

		public CollapsedBorder(Composite parent, int style) {
			super(parent, style);

			paintListener = new PaintListener() {
				public void paintControl(PaintEvent e) {
					paint(e);
				}
			};
			mouseDownListener = new Listener() {

				@Override
				public void handleEvent(Event event) {
					if (selectionListener != null && !isSectionExpanded)
						selectionListener.handleSelection();
				}
			};
			this.addPaintListener(paintListener);
			this.addListener(SWT.MouseDown, mouseDownListener);
		}

		@Override
		public void dispose() {
			if (mouseDownListener != null)
				this.removeListener(SWT.MouseDown, mouseDownListener);
			if (paintListener != null)
				this.removePaintListener(paintListener);
			super.dispose();
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
		}
	}
}
