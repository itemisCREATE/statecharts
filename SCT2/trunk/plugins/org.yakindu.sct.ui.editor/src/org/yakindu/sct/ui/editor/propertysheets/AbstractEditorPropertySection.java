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
package org.yakindu.sct.ui.editor.propertysheets;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.dialogs.IDialogLabelKeys;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.help.IWorkbenchHelpSystem;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.extensions.IExpressionLanguageProvider;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

import de.itemis.xtext.utils.jface.fieldassist.CompletionProposalAdapter;
import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter;
import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter.IContextElementProvider;
import de.itemis.xtext.utils.jface.viewers.StyledTextXtextAdapter;
import de.itemis.xtext.utils.jface.viewers.util.ActiveEditorTracker;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractEditorPropertySection extends
		AbstractModelerPropertySection implements IContextElementProvider {

	private final static String CONTEXTMENUID = "de.itemis.xtext.utils.jface.viewers.StyledTextXtextAdapterContextMenu";
	
	public abstract void createControls(Composite parent);

	public abstract void bindModel(EMFDataBindingContext context);

	private FormToolkit toolkit;

	private EMFDataBindingContext bindingContext;

	private Form form;

	private CompletionProposalAdapter completionProposalAdapter;

	
	@Override
	public void refresh() {
		super.refresh();
		if (bindingContext != null)
			bindingContext.dispose();
		bindingContext = new EMFDataBindingContext();
		bindModel(bindingContext);
	}

	@Override
	public void dispose() {
		super.dispose();
		if (bindingContext != null)
			bindingContext.dispose();
		if (toolkit != null)
			toolkit.dispose();
	}

	@Override
	public final void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		toolkit = new FormToolkit(parent.getDisplay());
		toolkit.setBorderStyle(SWT.BORDER);
		super.createControls(parent, aTabbedPropertySheetPage);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(parent);
		parent.setLayout(new GridLayout(1, true));
		form = toolkit.createForm(parent);
		toolkit.decorateFormHeading(form);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(form);
		form.getBody().setLayout(createBodyLayout());
		createControls(form.getBody());
	}

	protected Layout createBodyLayout() {
		return new GridLayout(1, false);
	}

	public FormToolkit getToolkit() {
		return toolkit;
	}

	/**
	 * returns the resource that is active in the current editor, this is used
	 * for the {@link XtextPropertyDescriptor}s context resource to enable
	 * scoping to elements outside the text block
	 */
	protected Resource getActiveEditorResource() {
		IEditorPart editor = ActiveEditorTracker.getLastActiveEditor();

		EditingDomain domain = null;
		if (editor instanceof IEditingDomainProvider) {
			domain = ((IEditingDomainProvider) editor).getEditingDomain();
		} else if (editor.getAdapter(IEditingDomainProvider.class) != null) {
			domain = ((IEditingDomainProvider) editor
					.getAdapter(IEditingDomainProvider.class))
					.getEditingDomain();
		} else if (editor.getAdapter(EditingDomain.class) != null) {
			domain = (EditingDomain) editor.getAdapter(EditingDomain.class);
		}
		if (domain == null) {
			return null;
		}

		EList<Resource> resources = domain.getResourceSet().getResources();

		return resources.get(0); // always take the first resource ...
	}

	
	
	protected void enableXtext(Control control, Injector injector) {
		final StyledTextXtextAdapter xtextAdapter = new StyledTextXtextAdapter(
				injector);
		xtextAdapter.getFakeResourceContext().getFakeResource().eAdapters()
				.add(new ContextElementAdapter(this));
		final StyledText styledText = (StyledText) control;
		xtextAdapter.adapt(styledText);
		MenuManager menuManager = createMenuManager(control);
		Menu contextMenu = menuManager.createContextMenu(control);
		control.setMenu(contextMenu);
		
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPartSite site = window.getActivePage().getActiveEditor().getSite();
		
		ISelectionProvider provider = new ISelectionProvider() {
			
			public void setSelection(ISelection selection) {}
			
			public void removeSelectionChangedListener(ISelectionChangedListener listener) {}
			
			public void addSelectionChangedListener(ISelectionChangedListener listener) {}

			public ISelection getSelection() {
				
				if (styledText.isDisposed()) {
					return new StructuredSelection();
				}
				
				int offset = styledText.getCaretOffset()-1;
				XtextResource fakeResource = xtextAdapter.getFakeResourceContext().getFakeResource();
				if (fakeResource == null) {
					return new StructuredSelection();
				}
				
				IParseResult parseResult = fakeResource.getParseResult();
				if (parseResult == null) {
					return new StructuredSelection();
				}
				ICompositeNode rootNode = parseResult.getRootNode();
				if (rootNode == null) {
					return new StructuredSelection();
				}
				ILeafNode selectedNode = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);
				final EObject selectedObject = NodeModelUtils.findActualSemanticObjectFor(selectedNode);
				
				if (selectedObject == null) {
					return new StructuredSelection();
				}
				return new StructuredSelection(selectedObject);
			}
		};
		
		site.setSelectionProvider(provider);
		site.registerContextMenu(CONTEXTMENUID, menuManager, provider);
		
		completionProposalAdapter = new CompletionProposalAdapter(
				control, xtextAdapter.getContentAssistant(),
				KeyStroke.getInstance(SWT.CTRL, SWT.SPACE), null);
	}
	
	protected MenuManager createMenuManager(Control styledText) {
		
		MenuManager manager = new MenuManager(CONTEXTMENUID, CONTEXTMENUID) {
			// Overridden to filter default actions
			@Override
			public IContributionItem[] getItems() {
				ArrayList<Object> result = Lists.newArrayList();
				IContributionItem[] itemis = super.getItems();
				for (IContributionItem iContributionItem : itemis) {
					String id = iContributionItem.getId();
					if (id != null && id.startsWith("org.yakindu"))
						result.add(iContributionItem);
				}
				return result.toArray(new IContributionItem[] {});
			}
		};

		

		
		return manager;
	}

	public CompletionProposalAdapter getCompletionProposalAdapter() {
		return completionProposalAdapter;
	}

	protected Injector getInjector(SemanticTarget semanticTarget) {
		IExpressionLanguageProvider registeredProvider = ExpressionLanguageProviderExtensions
				.getRegisteredProvider(semanticTarget,
						getActiveEditorResource().getURI().fileExtension());
		return registeredProvider.getInjector();
	}

	public EObject getContextObject() {
		return getEObject();
	}

	protected void createHelpWidget(final Composite parent,
			final Control control, String helpId) {
		final ImageHyperlink helpWidget = toolkit.createImageHyperlink(parent,
				SWT.CENTER);
		Image defaultImage = PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_LCL_LINKTO_HELP);
		helpWidget.setImage(defaultImage);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP)
				.applyTo(helpWidget);
		helpWidget.setToolTipText(JFaceResources
				.getString(IDialogLabelKeys.HELP_LABEL_KEY));
		helpWidget.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				control.setFocus();
				PlatformUI.getWorkbench().getHelpSystem().displayDynamicHelp();
			}
		});
		GridDataFactory.fillDefaults().applyTo(helpWidget);
		helpWidget.setEnabled(true);
		setHelpContext(control, helpId);
	}

	protected void setHelpContext(Control control, String helpId) {
		IWorkbenchHelpSystem helpSystem = PlatformUI.getWorkbench()
				.getHelpSystem();
		helpSystem.setHelp(control, helpId);
	}

}
