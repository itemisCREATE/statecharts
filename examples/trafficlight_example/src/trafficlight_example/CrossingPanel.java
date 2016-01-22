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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import trafficlight_example.TrafficLight.Alignment;

/**
 * 
 * @author Tesch
 *
 */

public class CrossingPanel extends JPanel {

	private static final long serialVersionUID = 2709756259645789247L;
	private TrafficLight light1;
	private TrafficLight light2;
	private TrafficLight light3;
	private TrafficLight light4;
	private PedestrianLight light5;
	private PedestrianLight light6;

	public CrossingPanel() {
		light1 = new TrafficLight(Alignment.HORIZONTAL);
		light2 = new TrafficLight(Alignment.VERTICAL);
		light3 = new TrafficLight(Alignment.HORIZONTAL);
		light4 = new TrafficLight(Alignment.VERTICAL);
		light5 = new PedestrianLight(trafficlight_example.PedestrianLight.Alignment.HORIZONTAL);
		light6 = new PedestrianLight(trafficlight_example.PedestrianLight.Alignment.VERTICAL);
	}

	public void paint(Graphics g) {
		paintCrossing(g);
		paintTrafficLights(g);
		paintPedestrainLights(g);
		g.dispose();
	}

	private void paintTrafficLights(Graphics g) {
		light1.updatePosition(new Point(25, 150));
		light1.paint(g);

		light2.updatePosition(new Point(350, 25));
		light2.paint(g);

		light3.updatePosition(new Point(425, 350));
		light3.paint(g);

		light4.updatePosition(new Point(150, 425));
		light4.paint(g);
	}

	private void paintPedestrainLights(Graphics g) {
		light5.updatePosition(new Point(175, 25));
		light5.paint(g);

		light6.updatePosition(new Point(475, 175));
		light6.paint(g);
	}

	private void paintCrossing(Graphics g) {

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

	public TrafficLight getLight1() {
		return light1;
	}

	public TrafficLight getLight2() {
		return light2;
	}

	public TrafficLight getLight3() {
		return light3;
	}

	public TrafficLight getLight4() {
		return light4;
	}

	public PedestrianLight getLight5() {
		return light5;
	}

	public PedestrianLight getLight6() {
		return light6;
	}
}
