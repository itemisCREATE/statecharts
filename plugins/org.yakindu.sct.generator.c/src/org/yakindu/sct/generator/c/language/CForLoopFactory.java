/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.language;

/**
 * @author rbeckmann
 *
 */
public class CForLoopFactory {
	public ForLoop forloop(CharSequence initializer, CharSequence endCondition, CharSequence iteration, CharSequence content) {
		ForLoop loop = new ForLoop();
		loop.setInitializer(initializer);
		loop.setEndCondition(endCondition);
		loop.setIteration(iteration);
		loop.setContent(content);
		return loop;
	}
	
	public ForLoop forloop(CharSequence counter, CharSequence max, CharSequence content) {
		return forloop(
				counter + " = 0",
				counter + " < " + max,
				counter + "++",
				content
		);
	}
}
