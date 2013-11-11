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

import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;

/**
 * Defines all Generators that are known to be core-generators (provided by
 * YAKINDU)
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public enum CoreGenerator {

	Java("yakindu::java"), C("yakindu::c"), Cpp("yakindu::cpp"), GenericJava("yakindu::generic"), Xpand(
			"yakindu::xpand");

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
		if (GenericJava.id.equals(id)) {
			return GenericJava;
		}
		if (Xpand.id.equals(id)) {
			return Xpand;
		}
		throw new IllegalArgumentException(String.format("No such generator id '%s'", id));
	}

	/**
	 * Comparator to sort {@link GeneratorDescriptor}s. YAKINDU
	 * {@link CoreGenerator}s come first.
	 */
	public static final Comparator<GeneratorDescriptor> generatorOrder = new Comparator<GeneratorDescriptor>() {

		public int compare(GeneratorDescriptor o1, GeneratorDescriptor o2) {
			int a = 0;
			int b = 0;
			try {
				a = CoreGenerator.parseId(o1.getId()).ordinal();
			} catch (IllegalArgumentException e) {
				a = Integer.MAX_VALUE;
			}
			try {
				b = CoreGenerator.parseId(o2.getId()).ordinal();
			} catch (IllegalArgumentException e) {
				b = Integer.MAX_VALUE;
			}
			int result = Integer.valueOf(a).compareTo(b);
			if (result == 0) {
				result = o1.getName().compareTo(o2.getName());
			}
			return result;
		}
	};

}
