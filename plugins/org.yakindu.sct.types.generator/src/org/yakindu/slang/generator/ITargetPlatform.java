/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.slang.generator;

import java.util.Set;

import org.yakindu.base.types.Type;

public interface ITargetPlatform {
	/**
	 * For a given type, provide a replacement type that works on the target
	 * platform.
	 * 
	 * @param type
	 *            Type to be replaced
	 * @return
	 */
	public Type getReplacementType(Type type);

	/**
	 * Provide a set of keywords that exist on the target platform and are not
	 * allowed as identifiers.
	 */
	public Set<String> getLanguageKeywords();
}
