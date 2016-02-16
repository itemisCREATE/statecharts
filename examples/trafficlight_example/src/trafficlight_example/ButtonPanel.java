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
package trafficlight_example;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author Tesch
 *
 */

public class ButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton pedestrianRequest;
	private JButton onOff;

	public ButtonPanel() {
		createContents();
	}

	private void createContents() {
		pedestrianRequest = new JButton();
		pedestrianRequest.setText("pedestrain request");
		add(BorderLayout.SOUTH, pedestrianRequest);
		onOff = new JButton();
		onOff.setText("on / off");
		add(BorderLayout.SOUTH, onOff);
	}

	public JButton getPedestrianRequest() {
		return pedestrianRequest;
	}

	public JButton getOnOff() {
		return onOff;
	}

}
