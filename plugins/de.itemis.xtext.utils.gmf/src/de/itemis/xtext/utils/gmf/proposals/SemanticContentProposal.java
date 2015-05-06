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

import org.eclipse.jface.fieldassist.ContentProposal;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SemanticContentProposal extends ContentProposal implements ISemanticContentProposal {

	private Image image;

	private ISemanticModification modification;

	public SemanticContentProposal(String id, String label, String description, Image image,
			ISemanticModification modification) {
		super(id, label, description);
		this.image = image;
		this.modification = modification;
	}

	public String getProposalText() {
		StringBuilder builder = new StringBuilder();
		builder.append(getLabel());
		return builder.toString();
	}

	public Image getImage() {
		return image;
	}

	public String getID() {
		return super.getContent();
	}

	public ISemanticModification getSemanticModification() {
		return modification;
	}

}
