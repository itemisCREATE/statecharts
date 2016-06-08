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
package ferry;

import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

/**
 * 
 * @author Enste
 * 
 */
public class Ship extends JPanel {

	private static final long serialVersionUID = -2252066067399977955L;
	
	public Ship() {
		
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		Polygon poly = new Polygon();
		poly.addPoint((int)Math.round(getWidth()/6.0),getHeight());
		poly.addPoint(0,(int)Math.round(getHeight()*0.5));
		poly.addPoint((int)Math.round(getWidth()/6.0),(int)Math.round(getHeight()*0.5));
		poly.addPoint((int)Math.round(getWidth()/4.0),0);
		poly.addPoint(getWidth()-(int)Math.round(getWidth()/4.0),0);
		poly.addPoint(getWidth()-(int)Math.round(getWidth()/6.0),(int)Math.round(getHeight()*0.5));
		poly.addPoint(getWidth(),(int)Math.round(getHeight()*0.5));
		poly.addPoint(getWidth()-(int)Math.round(getWidth()/6.0),getHeight());
		g.fillPolygon(poly);
	}
}
