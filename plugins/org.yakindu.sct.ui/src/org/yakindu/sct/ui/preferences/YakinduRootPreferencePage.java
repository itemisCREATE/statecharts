/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class YakinduRootPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	//Visit us ;-)
	private static final String YAKINDU_ORG = "http://www.statecharts.org/";

	@Override
	protected Control createContents(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("YAKINDU Statechart Tools general settings.");
		Link link = new Link(parent, SWT.NONE);
		link.setText("For more information visit <a>www.statecharts.org</a>");
		link.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				org.eclipse.swt.program.Program
						.launch(YAKINDU_ORG);
			}
		});
		return parent;
	}

	@Override
	public void createControl(Composite parent) {
		Composite content = new Composite(parent, SWT.NONE);
		setControl(content);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		content.setLayout(layout);
		createContents(content);
	}

	public void init(IWorkbench workbench) {
		// Nothing to do
	}

}
