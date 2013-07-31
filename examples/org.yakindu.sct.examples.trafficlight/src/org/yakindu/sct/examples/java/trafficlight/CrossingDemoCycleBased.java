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
package org.yakindu.sct.examples.java.trafficlight;

import org.yakindu.sct.examples.trafficlight.cyclebased.RuntimeService;
import org.yakindu.sct.examples.trafficlight.cyclebased.TimerService;
import org.yakindu.sct.examples.trafficlight.cyclebased.trafficlightwaiting.TrafficLightWaitingStatemachine;

/**
 * Example to show how to integrate the generated statemachine code into
 * existing projects.
 * 
 * @author a.nyssen - initial API and implementation
 * @author m.muehlbrandt - adaptions to new statemachine code.
 * @author terfloth - refactoring
 */

public class CrossingDemoCycleBased extends CrossingDemoBase {

	private TrafficLightWaitingStatemachine statemachine;
	
	private TimerService timer;

	public static void main(String[] args) {

		new CrossingDemoCycleBased().runTrafficLight();
	}

	@Override
	protected void setUpAndRunStatemachine() {

		statemachine = new TrafficLightWaitingStatemachine();
		timer = new TimerService();
		statemachine.setTimer(timer);
		statemachine.init();
		statemachine.enter();
		
		RuntimeService.getInstance().registerStatemachine(statemachine, 100);
	}

	@Override
	protected void tearDownStatemachine() {
		// End TimerHandler and RuntimeService.
		timer.cancel();
		RuntimeService.getInstance().cancelTimer();
	}

	@Override
	protected void readStatemachineOutput() {
		trafficLightFigure.setRed(statemachine.getSCITrafficLight()
				.getRed());
		trafficLightFigure.setYellow(statemachine.getSCITrafficLight()
				.getYellow());
		trafficLightFigure.setGreen(statemachine.getSCITrafficLight()
				.getGreen());

		pedestrianLightFigure.setWhite(statemachine.getSCIPedestrian()
				.getRequest());
		pedestrianLightFigure.setRed(statemachine.getSCIPedestrian()
				.getRed());
		pedestrianLightFigure.setGreen(statemachine.getSCIPedestrian()
				.getGreen());
	}

	@Override
	protected void pedestrianRequestButtonClicked() {
		statemachine.raisePedestrianRequest(); // raise event in statemachine
	}

	@Override
	protected void onOffButtonClicked() {
		statemachine.raiseOnOff(); // raise event in statemachine
	}

}
