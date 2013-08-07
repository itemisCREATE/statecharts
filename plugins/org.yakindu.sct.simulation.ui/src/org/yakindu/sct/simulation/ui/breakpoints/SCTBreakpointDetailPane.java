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
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPartSite;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.simulation.core.breakpoints.SCTBreakpoint;
import org.yakindu.sct.ui.integration.stext.ExpressionExpressionProvider;

import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter;
import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter.IContextElementProvider;
import de.itemis.xtext.utils.jface.viewers.StyledTextXtextAdapter;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTBreakpointDetailPane implements IDetailPane, IContextElementProvider {

	public static final String SCT_BREAKPOINT_PANE = "sctBreakpointPane";
	private StyledTextXtextAdapter adapter;
	private Statechart statechart;
	private SCTBreakpoint sctBreakpoint;

	public void init(IWorkbenchPartSite partSite) {
		
	}

	public Control createControl(Composite parent) {
		parent.setBackground(ColorConstants.white);
		final StyledText txt = new StyledText(parent, SWT.BORDER | SWT.MULTI);
		txt.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				sctBreakpoint.setExpression((Statement) adapter.getFakeResourceContext().getFakeResource()
						.getParseResult().getRootASTElement());
			}

			public void focusGained(FocusEvent e) {

			}
		});
		ExpressionExpressionProvider provider = new ExpressionExpressionProvider();
		adapter = new StyledTextXtextAdapter(provider.getInjector());
		adapter.getFakeResourceContext().getFakeResource().eAdapters().add(new ContextElementAdapter(this));
		adapter.adapt(txt);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(txt);
		return txt;
	}

	public void dispose() {

	}

	public void display(IStructuredSelection selection) {
		sctBreakpoint = (SCTBreakpoint) selection.getFirstElement();
		if (sctBreakpoint == null)
			return;
		EObject semanticObject = sctBreakpoint.getSemanticObject();
		Resource resource = semanticObject.eResource();
		statechart = (Statechart) EcoreUtil.getObjectByType(resource.getContents(), SGraphPackage.Literals.STATECHART);

	}

	public boolean setFocus() {
		return false;
	}

	public String getID() {
		return SCT_BREAKPOINT_PANE;
	}

	public String getName() {
		return "SCT Breakpoint Details";
	}

	public String getDescription() {
		return null;
	}

	public EObject getContextObject() {
		return statechart;
	}

}
