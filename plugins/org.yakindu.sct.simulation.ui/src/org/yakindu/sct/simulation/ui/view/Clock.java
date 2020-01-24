/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.view;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.time.DurationFormatUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.yakindu.sct.simulation.ui.SimulationImages;

public class Clock extends Composite {

	private Font font;
	private Label timeLabel;
	private Label timeIconLabel;
	private long currentTime = -1;

	public Clock(Composite parent) {
		super(parent, SWT.NONE);
		font = new Font(Display.getDefault(), new FontData(FONT, FONT_SIZE, SWT.NORMAL));
		createContents();
		updateTimestamp(0);
	}

	private static final int FONT_SIZE = 11;
	private static final String FONT = "Courier New";

	protected void createContents() {
		setLayout(new GridLayout(2, false));
		timeIconLabel = new Label(this, SWT.NONE);
		timeIconLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		timeIconLabel.setImage(SimulationImages.SIMULATION_CLOCK.image());
		timeIconLabel.setToolTipText("Displays the duration since the simulation is running");
		timeLabel = new Label(this, SWT.NONE);
		timeLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		timeLabel.setFont(font);
		timeLabel.setToolTipText("Simulation Time");
	}

	protected void updateTimestamp(long timestamp) {
		if (timestamp == currentTime)
			return;
		currentTime = timestamp;
		String formatDurationHMS = DurationFormatUtils.formatDuration(timestamp,
				(timestamp == 0 ? "--:--:--.---" : "HH:mm:ss.SSS"), true);
		timeLabel.setText(formatDurationHMS);
		getParent().layout();
	}

	protected String getReadableSimulationTime(long timestamp) {
		long days = TimeUnit.MILLISECONDS.toDays(timestamp);
		long hours = TimeUnit.MILLISECONDS.toHours(timestamp);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(timestamp);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(timestamp);
		return DurationFormatUtils.formatDuration(timestamp,
				(days > 0 ? "dd 'days '" : "") + (hours > 0 ? "HH 'hours '" : "") + (minutes > 0 ? "mm 'minutes '" : "")
						+ (seconds > 0 ? "ss 'seconds '" : ""),
				false);
	}

}
