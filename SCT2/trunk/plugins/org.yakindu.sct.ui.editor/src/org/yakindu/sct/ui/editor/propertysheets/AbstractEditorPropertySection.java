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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.extensions.IExpressionLanguageProvider;

import com.google.inject.Injector;

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

	public abstract void createControls(Composite parent);

	public abstract void bindModel(EMFDataBindingContext context);

	private FormToolkit toolkit;

	private EMFDataBindingContext bindingContext;

	private Form form;

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
		toolkit.dispose();
	}

	@Override
	public final void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(parent);
		parent.setLayout(new GridLayout(1, true));
		toolkit = new FormToolkit(parent.getDisplay());
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

	protected void enableXtext(Control styledText, Injector injector) {
		StyledTextXtextAdapter xtextAdapter = new StyledTextXtextAdapter(
				injector);
		xtextAdapter.getFakeResourceContext().getFakeResource().eAdapters()
				.add(new ContextElementAdapter(this));
		xtextAdapter.adapt((StyledText) styledText);
	}

	protected Injector getInjector(SemanticTarget semanticTarget) {
		IExpressionLanguageProvider registeredProvider = ExpressionLanguageProviderExtensions
				.getRegisteredProvider(semanticTarget,
						getActiveEditorResource().getURI().lastSegment());
		return registeredProvider.getInjector();
	}

	public EObject getContextObject() {
		return getEObject();
	}
	// FIXME
	// public void createHelpColumn(final Composite parent, final Control
	// control) {
	// final ImageHyperlink helpWidget = toolkit.createImageHyperlink(parent,
	// SWT.CENTER);
	// Image defaultImage = PlatformUI.getWorkbench().getSharedImages()
	// .getImage(ISharedImages.IMG_LCL_LINKTO_HELP);
	// helpWidget.setImage(defaultImage);
	// GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP)
	// .applyTo(helpWidget);
	// helpWidget.setToolTipText(JFaceResources
	// .getString(IDialogLabelKeys.HELP_LABEL_KEY));
	// helpWidget.addMouseListener(new MouseAdapter() {
	// public void mouseDown(MouseEvent e) {
	// control.setFocus();
	// PlatformUI.getWorkbench().getHelpSystem().displayDynamicHelp();
	// }
	// });
	// GridDataFactory.fillDefaults().applyTo(helpWidget);
	// helpWidget.setEnabled(true);
	// }

}
