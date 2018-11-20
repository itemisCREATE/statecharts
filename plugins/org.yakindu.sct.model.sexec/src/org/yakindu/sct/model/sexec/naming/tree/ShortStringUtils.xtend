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

import java.util.List
import java.util.Map

/**
 * @author rbeckmann
 *
 */
class ShortStringUtils {
	def List<ShortString> getLongestElement(List<List<ShortString>> names) {
		names.sortBy[getLength].last
	}
	
	def getLength(List<ShortString> list) {
		list.map[shortenedSize].reduce[a, b|a + b]
	}
	
	def int getMaxLength(List<List<ShortString>> names) {
		return names.map[getLength].max
	}
	
	def String join(List<ShortString> name) {
		val sb = new StringBuilder

		name.forEach[sb.append(toString)]

		sb.toString
	}
	
	def ShortString toShortString(StringTreeNode node, Map<StringTreeNode, ShortString> map) {
		if (!map.containsKey(node)) {
			map.put(node, new ShortString(node.data, node.getRoot.weight - node.weight + 1))
		}
		map.get(node)

	}
}