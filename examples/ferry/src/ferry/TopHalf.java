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

/**
 * 
 * @author Enste
 * 
 */

public class TopHalf extends JPanel {

	private static final long serialVersionUID = -7956450070729198474L;
	
	public TopHalf() {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(new Color(153,217,234));
		g.fillRect(0,0,getWidth(),getWidth());
	}
}
