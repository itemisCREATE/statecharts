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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import traffic.light.TrafficLight.Alignment;

/**
 * 
 * @author Tesch
 *
 */

public class CrossingPanel extends CrossWalkPanel {

	private static final long serialVersionUID = 2709756259645789247L;
	
	protected TrafficLight trafficLightWest;
	protected TrafficLight trafficLightNorth;
	protected TrafficLight trafficLightSouth;
	protected PedestrianLight pedlightNorth;
	
	public CrossingPanel() {
		super();
		
		trafficLightWest = new TrafficLight(Alignment.HORIZONTAL);
		trafficLightNorth = new TrafficLight(Alignment.VERTICAL);
		trafficLightSouth = new TrafficLight(Alignment.VERTICAL);
		pedlightNorth = new PedestrianLight(PedestrianLight.Alignment.HORIZONTAL);
	}

	@Override
	protected void paintTrafficLights(Graphics g) {
		super.paintTrafficLights(g);
		
		trafficLightWest.updatePosition(new Point(25, 150));
		trafficLightWest.paint(g);

		trafficLightNorth.updatePosition(new Point(350, 25));
		trafficLightNorth.paint(g);

		trafficLightSouth.updatePosition(new Point(150, 425));
		trafficLightSouth.paint(g);
	}

	@Override
	protected void paintPedestrainLights(Graphics g) {
		super.paintPedestrainLights(g);
		
		pedlightNorth.updatePosition(new Point(175, 25));
		pedlightNorth.paint(g);
	}
	
	@Override
	protected void paintCrossing(Graphics g) {
		
		int breite = getSize().width;
		int hoehe = getSize().height;
	
		g.setColor(Color.darkGray);
		g.fillRect(225, 0, 100, hoehe);
	
		g.setColor(Color.darkGray);
		g.fillRect(0, 225, breite, 100);
	
		g.setColor(Color.white);
		g.fillRect(270, 0, 10, hoehe);
	
		g.setColor(Color.white);
		g.fillRect(0, 270, breite, 10);
	
		g.setColor(Color.darkGray);
		g.fillRect(225, 225, 100, 100);
	
		g.setColor(Color.white);
		g.fillRect(225, 225, 100, 100);
	
		g.setColor(Color.darkGray);
		g.fillRect(235, 235, 80, 80);
	
		g.setColor(Color.white);
	
		g.fillRect(230, 30, 10, 50);
		g.fillRect(230 + 20, 30, 10, 50);
		g.fillRect(230 + 40, 30, 10, 50);
		g.fillRect(230 + 60, 30, 10, 50);
		g.fillRect(230 + 80, 30, 10, 50);
	
		g.setColor(Color.white);
		g.fillRect(475, 230, 50, 10);
		g.fillRect(475, 230 + 20, 50, 10);
		g.fillRect(475, 230 + 40, 50, 10);
		g.fillRect(475, 230 + 60, 50, 10);
		g.fillRect(475, 230 + 80, 50, 10);
	
	}


	public TrafficLight getTrafficLightWest() {
		return trafficLightWest;
	}

	public TrafficLight getTrafficLightNorth() {
		return trafficLightNorth;
	}

	public TrafficLight getTrafficLightSouth() {
		return trafficLightSouth;
	}

	public PedestrianLight getPedLightNorth() {
		return pedlightNorth;
	}
}
