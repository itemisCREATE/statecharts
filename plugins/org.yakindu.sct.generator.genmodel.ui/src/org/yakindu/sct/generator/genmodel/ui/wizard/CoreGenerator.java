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

import java.util.Comparator;

import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor;

/**
 * Defines all Generators that are known to be core-generators (provided by
 * YAKINDU)
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public enum CoreGenerator {

	C("yakindu::c"), Cpp("yakindu::cpp"), Java("yakindu::java");

	private String id;

	private CoreGenerator(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	static CoreGenerator parseId(String id) {
		if (Java.id.equals(id)) {
			return Java;
		}
		if (C.id.equals(id)) {
			return C;
		}
		if (Cpp.id.equals(id)) {
			return Cpp;
		}
		throw new IllegalArgumentException(String.format("No such generator id '%s'", id));
	}

	/**
	 * Comparator to sort {@link GeneratorDescriptor}s. YAKINDU
	 * {@link CoreGenerator}s come first.
	 */
	public static final Comparator<IGeneratorDescriptor> generatorOrder = new Comparator<IGeneratorDescriptor>() {

		public int compare(IGeneratorDescriptor o1, IGeneratorDescriptor o2) {
			int a = getPrio(o1);
			int b = getPrio(o2);
			int result = Integer.valueOf(a).compareTo(b);
			if (result == 0) {
				result = o2.getName().compareTo(o1.getName());
			}
			return result;
		}

		private int getPrio(IGeneratorDescriptor o1) {
			try {
				return CoreGenerator.parseId(o1.getId()).ordinal();
			} catch (IllegalArgumentException e) {
				return Integer.MAX_VALUE;
			}
		}
	};

}
