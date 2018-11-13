/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.naming.tree

import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author rbeckmann
 *
 */
class TreeServiceNamesValidator {
	@Accessors protected List<List<ShortString>> names
	
	@Inject protected extension ShortStringUtils
	
	def boolean validate() {
		val Set<String> set = newHashSet

		if (names === null) {
			return false
		} else {
			for (name : names) {
				val s = name.join

				if (!set.add(s)) {
					return false
				}
			}
			return true
		}
	}
}