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

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SemanticContentProposalLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		if (element instanceof SemanticContentProposal) {
			return ((SemanticContentProposal) element).getProposalText();
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof SemanticContentProposal) {
			return ((SemanticContentProposal) element).getImage();
		}
		return super.getImage(element);
	}

}
