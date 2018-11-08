/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.wizard.pages;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.dialogs.PreferencesUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class MessageArea extends Composite {

	private static final String DOWNLOAD_LINK = "http://www.statecharts.org/examples.html";
	protected static final String PREF_PAGE_ID = "com.yakindu.sct.examples";
	protected static final String DISPLAY_ID = "com.yakindu.sct.examples";
	private Label imageLabel;
	private Link textLabel;
	public Button button;
	private Group group;

	public static enum State {
		DOWNLOAD, UPDATE, INSTALL, ERROR, HIDE
	}

	private State state = State.HIDE;

	public MessageArea(Composite parent) {
		super(parent, SWT.NONE);
		setLayout(new FillLayout());
		createControls();
	}

	protected void createControls() {
		group = new Group(this, SWT.NONE);
		group.setLayout(new GridLayout(3, false));
		imageLabel = new Label(group, SWT.NONE);
		GridDataFactory.fillDefaults().grab(false, false).align(SWT.BEGINNING, SWT.CENTER).applyTo(imageLabel);
		textLabel = new Link(group, SWT.WRAP);
		textLabel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (DOWNLOAD_LINK.equals(e.text)) {
					Program.launch(DOWNLOAD_LINK);
				} else {
					PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(getShell(), PREF_PAGE_ID,
							new String[] { DISPLAY_ID }, null);
					dialog.setSelectedNode("DISPLAY_ID");
					dialog.open();
				}
			}
		});
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.CENTER, SWT.CENTER).applyTo(textLabel);
		button = new Button(group, SWT.FLAT);
		button.setText("Download");
		GridDataFactory.fillDefaults().grab(false, false).align(SWT.END, SWT.CENTER).applyTo(button);
	}

	public void showNoExamplesFound() {
		state = State.DOWNLOAD;
		imageLabel.setImage(Display.getDefault().getSystemImage(SWT.ICON_INFORMATION));
		textLabel.setText(
				"No examples found, please download the latest examples.\nYou can <a>change the storage location here.</a>");
		button.setText("Download");
		textLabel.pack();
		button.setVisible(true);
		show();
	}

	public void showUpdateAvailable() {
		state = State.UPDATE;
		imageLabel.setImage(Display.getDefault().getSystemImage(SWT.ICON_QUESTION));
		textLabel.setText("Updates available. Do you want to download the new examples?");
		textLabel.pack();
		button.setText("Update");
		button.setVisible(true);
		show();
	}
	
	public void showProRequired() {
		state = State.INSTALL;
		imageLabel.setImage(Display.getDefault().getSystemImage(SWT.ICON_INFORMATION));
		textLabel.setText("This example requires YAKINDU Statechart Tools Professional Edition. Do you want to download it?");
		textLabel.pack();
		button.setText("Download");
		button.setVisible(true);
		show();
	}

	public void showUnableToDownloadError() {
		state = State.ERROR;
		imageLabel.setImage(Display.getDefault().getSystemImage(SWT.ICON_ERROR));
		textLabel.setText(
				"Unable to download examples. You can manually download them from \n <a>http://www.statecharts.org/examples.html</a>");
		textLabel.pack();
		button.setVisible(false);
		show();
	}

	protected void show() {
		setVisible(true);
		GridData data = (GridData) getLayoutData();
		data.exclude = false;
	}

	public void hide() {
		state = State.HIDE;
		setVisible(false);
		GridData data = (GridData) getLayoutData();
		data.exclude = true;
	}

	public void addSelectionListener(SelectionListener listener) {
		button.addSelectionListener(listener);
	}

	public State getState() {
		return state;
	}
}
