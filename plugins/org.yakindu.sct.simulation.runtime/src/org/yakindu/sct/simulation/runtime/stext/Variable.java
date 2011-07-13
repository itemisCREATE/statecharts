/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.stext;

import org.yakindu.sct.simulation.runtime.EvaluationException;


/**
 * 
 * 
 * @author terfloth@itemis.de
 */
public class Variable {

	protected String name;
	protected Object value;
	protected Class<?> type;

	
	public Variable() {
		super();
	}

	public Variable(String name) {
		this();
		this.name = name;
	}

	public Variable(String name, Class<Object> type) {
		this();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		if(type != null && (! type.isAssignableFrom(value.getClass()))) {
			throw new EvaluationException(
					"Variable <" + name + "> of type " + type 
					+ " is not assignable from " + value.getClass() + " value.");
		}
		this.value = value;
	}
	
}
