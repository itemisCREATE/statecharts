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

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.dialogs.IDialogLabelKeys;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.JFaceResources;
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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.help.IWorkbenchHelpSystem;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions;
import org.yakindu.sct.ui.editor.extensions.IExpressionLanguageProvider;

import com.google.inject.Injector;

import de.itemis.xtext.utils.jface.fieldassist.CompletionProposalAdapter;
import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter;
import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter.IContextElementProvider;
import de.itemis.xtext.utils.jface.viewers.FilteringMenuManager;
import de.itemis.xtext.utils.jface.viewers.StyledTextXtextAdapter;
import de.itemis.xtext.utils.jface.viewers.util.ActiveEditorTracker;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractEditorPropertySection extends AbstractModelerPropertySection implements
		IContextElementProvider {

	public abstract void createControls(Composite parent);

	public abstract void bindModel(EMFDataBindingContext context);

	private FormToolkit toolkit;

	private EMFDataBindingContext bindingContext;

	private Form form;

	private CompletionProposalAdapter completionProposalAdapter;

	public final static String CONTEXTMENUID = "de.itemis.xtext.utils.jface.viewers.StyledTextXtextAdapterContextMenu";

	@Override
	public void refresh() {
		super.refresh();
		if (bindingContext != null)
			bindingContext.dispose();
		bindingContext = new ValidatingEMFDatabindingContext(this, form.getShell());
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
	public final void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
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

	protected void enableXtext(Control styledText, Injector injector) {
		final StyledTextXtextAdapter xtextAdapter = new StyledTextXtextAdapter(injector);
		xtextAdapter.getFakeResourceContext().getFakeResource().eAdapters().add(new ContextElementAdapter(this));
		xtextAdapter.adapt((StyledText) styledText);

		initContextMenu(styledText);

		completionProposalAdapter = new CompletionProposalAdapter(styledText, xtextAdapter.getContentAssistant(),
				KeyStroke.getInstance(SWT.CTRL, SWT.SPACE), null);
	}

	protected void initContextMenu(Control control) {
		MenuManager menuManager = new FilteringMenuManager();
		Menu contextMenu = menuManager.createContextMenu(control);
		control.setMenu(contextMenu);
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPartSite site = window.getActivePage().getActiveEditor().getSite();
		site.registerContextMenu(CONTEXTMENUID, menuManager, site.getSelectionProvider());
	}

	public CompletionProposalAdapter getCompletionProposalAdapter() {
		return completionProposalAdapter;
	}

	protected Injector getInjector(String semanticTarget) {
		IEditorPart editor = ActiveEditorTracker.getLastActiveEditor();
		IEditorInput editorInput = editor.getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			String extension = ((IFileEditorInput) editorInput).getFile().getFileExtension();
			IExpressionLanguageProvider registeredProvider = ExpressionLanguageProviderExtensions
					.getLanguageProvider(semanticTarget, extension);
			return registeredProvider.getInjector();
		}
		return null;
	}

	public EObject getContextObject() {
		return getEObject();
	}

	protected void createHelpWidget(final Composite parent, final Control control, String helpId) {
		final ImageHyperlink helpWidget = toolkit.createImageHyperlink(parent, SWT.CENTER);
		Image defaultImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_LCL_LINKTO_HELP);
		helpWidget.setImage(defaultImage);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).applyTo(helpWidget);
		helpWidget.setToolTipText(JFaceResources.getString(IDialogLabelKeys.HELP_LABEL_KEY));
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
		IWorkbenchHelpSystem helpSystem = PlatformUI.getWorkbench().getHelpSystem();
		helpSystem.setHelp(control, helpId);
	}

}
