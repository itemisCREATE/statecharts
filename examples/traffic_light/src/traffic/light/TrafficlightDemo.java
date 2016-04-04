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
import traffic.light.trafficlightctrl.TrafficLightCtrlStatemachine;

/**
 * 
 * @author Tesch
 *
 */

public class TrafficlightDemo extends JFrame {

	private static final long serialVersionUID = -8909693541678814631L;

	protected TrafficLightCtrlStatemachine statemachine;

	protected TimerService timer;

	private CrossingPanel crossing;

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
		setTitle("Traffic Light Crossing");
		crossing = new CrossingPanel();
		add(BorderLayout.CENTER, crossing);
		buttonPanel = new ButtonPanel();
		add(BorderLayout.SOUTH, buttonPanel);
		setSize(600, 600);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	protected void setupStatemachine() {
		statemachine = new TrafficLightCtrlStatemachine();
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
		crossing.getLight1().setRed(statemachine.getSCITrafficLight().getRed());
		crossing.getLight1().setYellow(statemachine.getSCITrafficLight().getYellow());
		crossing.getLight1().setGreen(statemachine.getSCITrafficLight().getGreen());

		crossing.getLight3().setRed(statemachine.getSCITrafficLight().getRed());
		crossing.getLight3().setYellow(statemachine.getSCITrafficLight().getYellow());
		crossing.getLight3().setGreen(statemachine.getSCITrafficLight().getGreen());

		crossing.getLight2().setGreen(statemachine.getSCITrafficLight().getRed());
		crossing.getLight2().setYellow(statemachine.getSCITrafficLight().getYellow());
		crossing.getLight2().setRed(statemachine.getSCITrafficLight().getGreen());

		crossing.getLight4().setGreen(statemachine.getSCITrafficLight().getRed());
		crossing.getLight4().setYellow(statemachine.getSCITrafficLight().getYellow());
		crossing.getLight4().setRed(statemachine.getSCITrafficLight().getGreen());

		crossing.getLight5().setGreen(statemachine.getSCIPedestrian().getRed());
		crossing.getLight5().setRed(statemachine.getSCIPedestrian().getGreen());
		crossing.getLight5().setWhite(statemachine.getSCIPedestrian().getRequest());

		crossing.getLight6().setRed(statemachine.getSCIPedestrian().getRed());
		crossing.getLight6().setGreen(statemachine.getSCIPedestrian().getGreen());
		crossing.getLight6().setWhite(statemachine.getSCIPedestrian().getRequest());
	}
}
