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
package org.yakindu.sct.model.sexec.naming

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author rbeckmann
 *
 */
class TreeStringShortener implements IStringShortener {
	@Accessors(PUBLIC_SETTER) protected int maxLength = 0
	
	protected StringTreeNode tree
	
	protected boolean validState = false
	
	protected Map<StorageToken, String> result
	protected Map<StorageToken, StringTreeNode> storage
	protected Map<StorageToken, List<String>> originalStrings = newHashMap

	override addString(List<String> s) {
		validState = false
		val token = new StorageToken()
		originalStrings.put(token, s)
		return token
	}
	
	override getString(StorageToken token) {
		if(!originalStrings.containsKey(token)) {
			return null
		}
		
		assertValidState()
		
		return result.get(token)
	}
	
	def protected void assertValidState() {
		if(!validState) {
			if(maxLength == 0) {
				result = newHashMap
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
		
		for(node : tree.endNodes) {
			val List<StringTreeNode> list = newArrayList
			list.add(node)
			nodes.add(list)
			map.put(node, list)
		}
		
		buildIndividualNames(nodes)
		
		val Map<StringTreeNode, List<ShortString>> shortStrings = newHashMap
		
		map.keySet.forEach[node |
			shortStrings.put(node, newArrayList(map.get(node).map[new ShortString(it.data)]))
		]
		
		val List<List<ShortString>> shortStringLists = newArrayList(shortStrings.values)
		calculateShortNames(shortStringLists)
		
		storage.keySet.forEach[token |
			result.put(
				token,
				shortStrings.get(storage.get(token)).map[it.shortenedString].join
			)
		]
		
	}
	
	def calculateShortNames(List<List<ShortString>> lists) {
		while(getMaxLength(lists) > this.maxLength) {
			
		}
	}
	
	def int getMaxLength(List<List<ShortString>> names) {
		return names.map[innerList | innerList.map[getShortenedSize].reduce[a, b | a + b]].max
	}
	
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
		for(list : map.values) {
			if(list.size > 1) {
				abort = false
				for(nodeList : list) {
					val parent = nodeList.get(0).parent
					if(parent !== null) {
						nodeList.add(0, parent)
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
	
	def protected Map<StringTreeNode, ArrayList<StringTreeNode>> constructIndividualNames() {
		/*
		 * The map doublets is a three dimensional construct.
		 * For each end-node-name in the tree, it holds a list of lists describing that name.
		 * The outer list contains instances representing the same name, and the inner lists hold 
		 * the current set of nodes that is needed to make the name individual.
		 * 
		 * Consider the following simple tree:
		 * main_region-StateA
		 * main_region-StateB
		 * second_region-StateA
		 * 
		 * After the initial phase, the map then contains the following:
		 * {"StateA": [[node(StateA)], [node(StateA)]], "StateB": [[node(StateB)]]}
		 * 
		 * The iteration consists of two phases then.
		 * In Phase 1, all inner lists are extended with the first element's parent - as long as there is more than one list.
		 * This leads to the following:
		 * {"StateA": [[node(main_region), node(StateA)], [node(second_region), node(StateA)]], "StateB": [[node(StateB)]]}
		 * in Phase 2, the map is then resorted with the new names:
		 * {
		 * 	"main_region_StateA": [[node(main_region), node(StateA)]],
		 * 	"second_region_StateA": [[node(second_region), node(StateA)]],
		 * 	"StateB": [[node(StateB)]] 
		 * }
		 * 
		 * As we can see, all outer lists now have exactly length 1, which is the abortion criterion.
		 * 
		 * In the finalization phase, we check if there are any weird things happening like randomly created double names.
		 * For example, someone could create a state named "region_StateA" and two other elements named "region" and "StateA" could
		 * be clumped together to form an individual name.
		 * 
		 */
		 
		// get all end-nodes, that is "ends of strings" added to the tree.
		val nodes = tree.getEndNodes().sortWith(new StringTreeNodeDepthComparator);
		var Map<String, ArrayList<ArrayList<StringTreeNode>>> doublets = newHashMap
		val Map<StringTreeNode, ArrayList<StringTreeNode>> mapping = newHashMap

		// Initialization
		for (node : nodes) {
			if (!doublets.containsKey(node.data)) {
				doublets.put(node.data, new ArrayList<ArrayList<StringTreeNode>>());
			}
			val list = new ArrayList<StringTreeNode>();
			// add new inner list that will hold the nodes going to the end node forming the individual name
			doublets.get(node.data).add(list);
			// map this list to the end node. We'll return this map later, but we need to fill the lists first
			mapping.put(node, list);
			list.add(node);
		}

		var abort = false;
		// Iteration
		while (!abort) {
			// Phase 1
			for (name : doublets.keySet) {
				// check outer list. If it contains more than one list, there is more than one element with the same name.
				if (doublets.get(name).length > 1) {
					// if that is the case, add one parent node to all inner node lists.
					for (nodelist : doublets.get(name)) {
						nodelist.add(0, nodelist.get(0).parent);
					}
				}
			}

			// Phase 2
			val newDoublets = new HashMap<String, ArrayList<ArrayList<StringTreeNode>>>();

			for (name : doublets.keySet) // for all keys
			{
				for (nodelist : doublets.get(name)) // for inner lists in outer lists - returned by doublets.get(name)
				{
					// construct names formed by inner lists, now possibly extended by one node
					val sb = new StringBuilder();

					for (var i = 0; i < nodelist.length; i++) {
						if (i != 0) {
							sb.append(separator)
						}
						sb.append(nodelist.get(i).getData())
					}
					// add string to new map if it doesn't exist already
					if (!newDoublets.containsKey(sb.toString)) {
						newDoublets.put(sb.toString, new ArrayList<ArrayList<StringTreeNode>>());
					}

					newDoublets.get(sb.toString).add(nodelist);
				}
			}

			doublets = newDoublets;

			// Abort criterion. If there is any name with more than one element, repeat.
			abort = true;
			for (name : doublets.keySet) {
				if(doublets.get(name).length > 1) abort = false;
			}
		}

		return mapping;
	}
}