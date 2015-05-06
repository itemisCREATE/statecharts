/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package de.itemis.xtext.utils.gmf.proposals;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.graphics.Image;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ISemanticContentProposal extends IContentProposal {

	public ISemanticModification getSemanticModification();

	public Image getImage();

	public String getProposalText();

	public String getID();

}
