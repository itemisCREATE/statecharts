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

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * 
 * @author Enste
 * 
 */

public class Background extends JPanel {
	
	private static final long serialVersionUID = 8657208490120818244L;
	private JButton btLeftShore,btRightShore;

	public Background() {
		btLeftShore = new JButton("|<");
		btRightShore = new JButton(">|");
		setLayout(null);
		add(btLeftShore);
		add(btRightShore);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawWater(g);
		drawShore(g);
	}
	
	private void drawShore(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0,0,(int)Math.round(0.05*getWidth()),(int)Math.round(0.5*getHeight()));
		g.fillOval(0,0,(int)Math.round(0.1*getWidth()),(int)Math.round(0.5*getHeight()));
		g.fillRect(0,(int)Math.round(getHeight()-0.75*getHeight()),(int)Math.round(0.1*getWidth()),(int)Math.round(0.5*getHeight()));
		g.fillRect((int)Math.round(getWidth()-0.05*getWidth()),0,(int)Math.round(0.05*getWidth()),(int)Math.round(0.5*getHeight()));
		g.fillOval((int)Math.round(getWidth()-0.1*getWidth()),0,(int)Math.round(0.1*getWidth()),(int)Math.round(0.5*getHeight()));
		g.fillRect((int)Math.round(getWidth()-0.1*getWidth()),(int)Math.round(getHeight()-0.75*getHeight()),(int)Math.round(0.1*getWidth()),(int)Math.round(0.5*getHeight()));
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0,(int)Math.round(getHeight()-0.5*getHeight()),(int)Math.round(0.1*getWidth()),(int)Math.round(0.5*getHeight()));
		g.fillRect((int)Math.round(getWidth()-0.1*getWidth()),(int)Math.round(getHeight()-0.5*getHeight()),(int)Math.round(0.1*getWidth()),(int)Math.round(0.5*getHeight()));
		btLeftShore.setBounds(0,(int)Math.round(getHeight()-0.5*getHeight()),(int)Math.round(0.1*getWidth()),25);
		btRightShore.setBounds((int)Math.round(getWidth()-0.1*getWidth()),(int)Math.round(getHeight()-0.5*getHeight()),(int)Math.round(0.1*getWidth()),25);
	}
	
	private void drawWater(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0,(int)Math.round(getHeight()-getHeight()*0.65),getWidth(),(int)Math.round(getHeight()*0.65));
		g.setColor(new Color(0,162,232));
		g.fillRect(0,(int)Math.round(getHeight()-getHeight()*0.55),getWidth(),(int)Math.round(getHeight()*0.55));
		for(int y=0;y<=getWidth();y=y+(int)Math.round(0.2*getHeight())) {
			g.fillOval((int)Math.round(y-0.1*getHeight()),(int)Math.round(getHeight()-0.65*getHeight()),(int)Math.round(0.2*getHeight()),(int)Math.round(0.2*getHeight()));
			if(g.getColor().getRGB()==Color.BLUE.getRGB()) g.setColor(new Color(0,162,232));
			else g.setColor(Color.BLUE);
		}
		g.setColor(Color.CYAN);
		g.fillRect(0,(int)Math.round(getHeight()-getHeight()*0.45),getWidth(),(int)Math.round(getHeight()*0.45));
	}
	
	public JButton getLeftShoreButton() {
		return btLeftShore;
	}
	
	public JButton getRightShoreButton() {
		return btRightShore;
	}
}