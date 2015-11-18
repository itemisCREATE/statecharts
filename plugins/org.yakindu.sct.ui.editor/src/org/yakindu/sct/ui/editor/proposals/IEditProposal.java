/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.proposals;

import org.eclipse.swt.graphics.Image;

/**
 * 
 * @author terfloth - initial contribution
 *
 */
public interface IEditProposal {

	/** 
	 * @return true if the proposal is applicable. 
	 */
	public boolean isApplicable();
	
	/**
	 * Applies the proposal.  
	 */
	public void apply();
	
	/**
	 * Provides the id of the proposal. 
	 * This id has to be unique forr all proposals on an element. 
	 * @return
	 */
	public String getId();
	
	/**
	 * Provides the display label of this proposal. 
	 */
	public String getLabel();
	
	/**
	 * Provides the description of this proposal. 
	 */
	public String getDescription();
	
	/**
	 * Optionally provides an icon image. 
	 */
	public Image getImage();
	
	/**
	 * Provides a order number that can be used for sorting.
	 */
	public int getOrder();
}
