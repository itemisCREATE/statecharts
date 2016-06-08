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

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * @author Enste
 * 
 */

public class Good extends JButton {
	
	private static final long serialVersionUID = 6526040213751215984L;

	public Good(BufferedImage image,int width,int height) {
		setIcon(new ImageIcon(image.getScaledInstance(width,height,Image.SCALE_DEFAULT)));
		setSize(width,height);
	}
}