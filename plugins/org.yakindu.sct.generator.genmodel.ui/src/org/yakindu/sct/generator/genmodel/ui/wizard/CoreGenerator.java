/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.ui.wizard;

/**
 * @author holger willebrandt - Initial contribution and API
 */
public enum CoreGenerator {

	Java("yakindu::java"), C("yakindu::c"), Cpp("yakindu::cpp");

	private String id;

	private CoreGenerator(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
