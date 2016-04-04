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
package traffic.light;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

import traffic.light.trafficlightctrl.ITrafficLightCtrlStatemachine;
import traffic.light.trafficlightctrl.SynchronizedTrafficLightCtrlStatemachine;

/**
 * 
 * @author Tesch
 *
 */

public class TrafficlightDemo extends JFrame {

	private static final long serialVersionUID = -8909693541678814631L;

	protected SynchronizedTrafficLightCtrlStatemachine statemachine;

	protected TimerService timer;

	private CrossWalkPanel crossing;

	private ButtonPanel buttonPanel;

	public static void main(String[] args) {
		TrafficlightDemo application = new TrafficlightDemo();
		application.createContents();
		application.setupStatemachine();
		application.run();
	}

	protected void run() {
		statemachine.enter();
		RuntimeService.getInstance().registerStatemachine(statemachine, 100);
	}

	protected void createContents() {
		setLayout(new BorderLayout());
		setTitle("Crosswalk traffic light");
		crossing = new CrossWalkPanel();
		add(BorderLayout.CENTER, crossing);
		buttonPanel = new ButtonPanel();
		add(BorderLayout.SOUTH, buttonPanel);
		setSize(440, 440);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	protected void setupStatemachine() {
		statemachine = new SynchronizedTrafficLightCtrlStatemachine();
		timer = new TimerService();
		statemachine.setTimer(timer);
		statemachine.getSCInterface().setSCInterfaceOperationCallback(new ITrafficLightCtrlStatemachine.SCInterfaceOperationCallback() {
			@Override
			public void synchronize() {
				checkTrafficLightStates();
				repaint();
			}
		});
		
		statemachine.init();

		buttonPanel.getPedestrianRequest()
				.addActionListener(e -> statemachine.getSCInterface().raisePedestrianRequest());
		buttonPanel.getOnOff().addActionListener(e -> statemachine.getSCInterface().raiseOnOff());
	}

	
	protected void checkTrafficLightStates() {

		crossing.getTrafficLight().setRed(statemachine.getSCITrafficLight().getRed());
		crossing.getTrafficLight().setYellow(statemachine.getSCITrafficLight().getYellow());
		crossing.getTrafficLight().setGreen(statemachine.getSCITrafficLight().getGreen());

		crossing.getPedLight().setRed(statemachine.getSCIPedestrian().getRed());
		crossing.getPedLight().setGreen(statemachine.getSCIPedestrian().getGreen());
		crossing.getPedLight().setWhite(statemachine.getSCIPedestrian().getRequest());
	}
}
