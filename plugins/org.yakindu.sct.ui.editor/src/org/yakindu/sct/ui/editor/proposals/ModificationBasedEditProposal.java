/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.ui.editor.proposals;

import org.eclipse.swt.graphics.Image;
import org.yakindu.sct.ui.editor.modifications.ISemanticModification;

public class ModificationBasedEditProposal implements IEditProposal {

	protected ISemanticModification modification;
	protected String label;
	protected String description;
	protected Image image;
	

	public ModificationBasedEditProposal(ISemanticModification	modification) {
		this(modification, null, null, null);
	}

	
	public ModificationBasedEditProposal(ISemanticModification	modification, String label, String description, Image image) {
		this.modification = modification;
		this.label = label;
		this.description = description;
		this.image = image;
	}
	
	

	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	@Override
	public boolean isApplicable() {
		return modification != null && modification.isApplicable();
	}


	@Override
	public void apply() {
		if (modification != null) modification.modify();
	}


	@Override
	public String getId() {
		return (modification != null) ? modification.getClass().getName() : null;
	}
	

	
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}