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

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * 
 * @author Enste
 * 
 */

public class Ferry extends JPanel {
	
	private static final long serialVersionUID = -7669481007320517898L;

	private JButton btFerryLeft,btFerryRight;
	
	private int yleft,yright;
	
	private double location;
	
	public Ferry() {
		Ship ship = new Ship();
		setOpaque(false);
		setLayout(new BorderLayout());
		add(ship);
		JPanel pbt = new JPanel();
		pbt.setLayout(new GridLayout(1,2));
		pbt.add(btFerryLeft = new JButton("<"));
		pbt.add(btFerryRight = new JButton(">"));
		add(pbt,BorderLayout.SOUTH);
	}
	
	public double getFerryLocation() {
		return location;
	}
	
	public void setFerryLocation(double location) {
		setLocation(yleft+(int)Math.round((yright-yleft)*location),(int)getLocation().getY());
		this.location = location;
	}
	
	public JButton getLeftFerryButton() {
		return btFerryLeft;
	}
	
	public JButton getRightFerryButton() {
		return btFerryRight;
	}
	
	public void setYLeft(int left) {
		yleft = left;
	}
	
	public void setYRight(int right) {
		yright = right;
	}
}
