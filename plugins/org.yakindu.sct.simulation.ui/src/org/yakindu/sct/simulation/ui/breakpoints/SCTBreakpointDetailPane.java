/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.breakpoints;

import org.eclipse.debug.ui.IDetailPane;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPartSite;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.breakpoints.SCTBreakpoint;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions;
import org.yakindu.sct.ui.editor.extensions.IExpressionLanguageProvider;

import de.itemis.xtext.utils.jface.fieldassist.CompletionProposalAdapter;
import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter;
import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter.IContextElementProvider;
import de.itemis.xtext.utils.jface.viewers.StyledTextXtextAdapter;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTBreakpointDetailPane implements IDetailPane, IContextElementProvider {

	private static final String BREAKPOINT_CONDITION = "breakpointCondition";
	public static final String SCT_BREAKPOINT_PANE = "sctBreakpointPane";
	private StyledTextXtextAdapter adapter;
	private Statechart statechart;
	private SCTBreakpoint breakpoint;
	private StyledText text;
	private Button conditional;

	public void init(IWorkbenchPartSite partSite) {

	}

	public Control createControl(Composite parent) {
		parent.setBackground(ColorConstants.white);
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		GridDataFactory.fillDefaults().grab(true, true).applyTo(composite);
		createCheckBox(composite);
		createTextArea(composite);
		return composite;
	}

	protected void createCheckBox(Composite parent) {
		conditional = new Button(parent, SWT.CHECK);
		conditional.setText("Conditional (Suspend when expression is 'true')");
		conditional.setSelection(false);
		conditional.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				text.setEnabled(!text.getEnabled());
				updateTextBackground();
				breakpoint.setConditional(text.isEnabled());
			}

		});
		GridDataFactory.fillDefaults().grab(true, false).applyTo(conditional);
	}

	protected void updateTextBackground() {
		if (text.isEnabled())
			text.setBackground(ColorConstants.white);
		else
			text.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
	}

	protected void createTextArea(Composite parent) {
		text = new StyledText(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		IExpressionLanguageProvider provider = ExpressionLanguageProviderExtensions.getLanguageProvider(
				BREAKPOINT_CONDITION, "sct");
		adapter = new StyledTextXtextAdapter(provider.getInjector());
		adapter.getFakeResourceContext().getFakeResource().eAdapters().add(new ContextElementAdapter(this));
		adapter.adapt(text);
		final CompletionProposalAdapter completionAdapter = new CompletionProposalAdapter(text,
				adapter.getContentAssistant(), KeyStroke.getInstance(SWT.CTRL, SWT.SPACE), null);
		text.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				if (!completionAdapter.isProposalPopupOpen()) {
					breakpoint.setExpression(text.getText());
				}
			}
		});
		GridDataFactory.fillDefaults().grab(true, true).applyTo(text);
	}

	public void dispose() {
		adapter.dispose();
		conditional.dispose();
		text.dispose();
	}

	public void display(IStructuredSelection selection) {
		breakpoint = (SCTBreakpoint) selection.getFirstElement();
		if (breakpoint == null)
			return;
		// Set context object for scoping
		EObject semanticObject = breakpoint.getSemanticObject();
		Resource resource = semanticObject.eResource();
		statechart = (Statechart) EcoreUtil.getObjectByType(resource.getContents(), SGraphPackage.Literals.STATECHART);
		// Init control state
		conditional.setSelection(breakpoint.isConditional());
		text.setEnabled(breakpoint.isConditional());
		text.setText(breakpoint.getExpression());
		updateTextBackground();
	}

	public boolean setFocus() {
		text.setFocus();
		return true;
	}

	public String getID() {
		return SCT_BREAKPOINT_PANE;
	}

	public String getName() {
		return "SCT Breakpoint Details";
	}

	public String getDescription() {
		return getName();
	}

	public EObject getContextObject() {
		return statechart;
	}
}
