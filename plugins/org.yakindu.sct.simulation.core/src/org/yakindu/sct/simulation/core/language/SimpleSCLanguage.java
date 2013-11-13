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
package org.yakindu.sct.simulation.core.language;

/**
 * Simple default implementation of the {@link ISCLanguage} interface.
 * 
 * @author terfloth
 *
 */
public class SimpleSCLanguage implements ISCLanguage {

	protected String id;
	protected String name;
	protected String baseLanguageId;
	
	public SimpleSCLanguage(String id, String name, String baseLanguageId) {
		super();
		this.id = id;
		this.name = name;
		this.baseLanguageId = baseLanguageId;
	}

	public String getId() {
		return id;
	}

	public String gertName() {
		return name;
	}

	public String getBaseLanguageId() {
		return baseLanguageId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((baseLanguageId == null) ? 0 : baseLanguageId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleSCLanguage other = (SimpleSCLanguage) obj;
		if (baseLanguageId == null) {
			if (other.baseLanguageId != null)
				return false;
		} else if (!baseLanguageId.equals(other.baseLanguageId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}
