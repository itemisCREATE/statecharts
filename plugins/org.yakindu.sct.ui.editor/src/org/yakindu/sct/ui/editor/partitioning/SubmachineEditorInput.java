/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.partitioning;

import java.util.Objects;

import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SubmachineEditorInput extends DiagramEditorInput {

	private String context;

	public SubmachineEditorInput(Diagram diagram, String context) {
		super(diagram);
		this.context = context;
	}

	public String getContext() {
		return context;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(context);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) {
			return false;
		}
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubmachineEditorInput other = (SubmachineEditorInput) obj;
		return Objects.equals(context, other.context);
	}


}
