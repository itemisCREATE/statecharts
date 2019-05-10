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
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.sct.model.sexec.naming.IStringShortener

/**
 * @author rbeckmann
 *
 */
class TreeStringShortener implements IStringShortener {
	@Accessors(PUBLIC_SETTER) protected int maxLength = 0
	
	@Inject protected extension ShortStringUtils
	@Inject protected TreeServiceNamesValidator validator
	
	protected StringTreeNode tree
	
	protected boolean validState = false
	
	protected Map<Object, String> result
	protected Map<Object, StringTreeNode> storage
	protected Map<Object, List<String>> originalStrings = newHashMap
	
	override reset() {
		originalStrings = newHashMap
		validState = false
	}

	override addString(List<String> s, Object token) {
		if(originalStrings.keySet.filter[it != token].map[originalStrings.get(it).join("")].exists[it == s.join("")]) {
			throw new IllegalArgumentException("String is duplicate: " + s.join("."))
		}
		validState = false
		originalStrings.put(token, s)
	}
	
	override getString(Object token) {
		if(!originalStrings.containsKey(token)) {
			return null
		}
		
		assertValidState()
		
		return result.get(token)
	}
	
	def protected void assertValidState() {
		if(!validState) {
			result = newHashMap
			storage = newHashMap
			if(maxLength == 0) {
				originalStrings.keySet.forEach[token |
					result.put(token, originalStrings.get(token).join)
				]
			} else {
				buildTree()
				shortenNames()
			}
			validState = true
		}
	}
	
	def protected buildTree() {
		tree = new StringTreeNode
		storage = newHashMap
		
		originalStrings.keySet.forEach [ token |
			storage.put(token, tree.addStringList(originalStrings.get(token)))
		]
		
		tree.compress()
	}
	
	def protected shortenNames() {
		val List<List<StringTreeNode>> nodes = newArrayList
		val Map<StringTreeNode, List<StringTreeNode>> map = newHashMap
		val Map<StringTreeNode, List<ShortString>> endNodeShortStrings = newHashMap
		val Map<StringTreeNode, ShortString> shortStrings = newHashMap
		
		for(node : tree.endNodes) {
			val List<StringTreeNode> list = newArrayList
			list.add(node)
			nodes.add(list)
			map.put(node, list)
			endNodeShortStrings.put(node, newArrayList)
		}
		
		buildIndividualNames(nodes)
		
		
		map.keySet.forEach[node |
			endNodeShortStrings.get(node).addAll(map.get(node).map[toShortString(shortStrings)])
		]
		
		val List<List<ShortString>> shortStringLists = newArrayList(endNodeShortStrings.values)
		calculateShortNames(shortStringLists)
		
		storage.keySet.forEach[token |
			result.put(
				token,
				endNodeShortStrings.get(storage.get(token)).join
			)
		]
		
	}
	
	def calculateShortNames(List<List<ShortString>> names) {
		validator.names = names
		var longest = names.longestElement
		while(longest.getLength > maxLength && cutOneCharacter(longest)) {
			longest = names.longestElement
		}
	}
	
	def boolean cutOneCharacter(List<ShortString> strings) {
		var ShortString toCut
		var int cheapestCut = Integer.MAX_VALUE
		
		for(part : strings) {
			val oldCost = part.cutCost
			
			part.removeCheapestChar()
		
			val costDifference = part.cutCost - oldCost
			if(validator.validate() && costDifference > 0 && costDifference < cheapestCut) {
				toCut = part
				cheapestCut = costDifference
			}
			part.rollback
		}
		toCut?.removeCheapestChar
		
		return toCut !== null
	}
	
	/** Expand lists until all names are unambiguous. */
	def protected void buildIndividualNames(List<List<StringTreeNode>> nodes) {
		val Map<String, List<List<StringTreeNode>>> map = newHashMap
		
		for(list : nodes) {
			val name = toString(list)
			
			if(!map.containsKey(name)) {
				map.put(name, newArrayList)
			}
			
			map.get(name).add(list)
		}
		
		var abort = true
		for(outer : map.values) {
			if(outer.size > 1) {
				abort = false
				for(inner : outer) {
					val parent = inner.get(0).parent
					if(parent !== null) {
						inner.add(0, parent)
					}
				}
			}
		}
		
		if(abort) {
			return
		}
		
		buildIndividualNames(nodes)
		
	}
	
	def protected String toString(List<StringTreeNode> list) {
		val sb = new StringBuilder
		
		for(node : list) {
			sb.append(node.data)
		}
		
		sb.toString
	}
}