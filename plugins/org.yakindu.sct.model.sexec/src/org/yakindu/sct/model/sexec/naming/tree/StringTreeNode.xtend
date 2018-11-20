/**
 *   Copyright (c) 2016 committers of YAKINDU Statechart Tools.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 * 		@author René Beckmann (beckmann@itemis.de)
 */

package org.yakindu.sct.model.sexec.naming.tree

import java.util.ArrayList
import java.util.Comparator
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author rbeckmann
 */
class StringTreeNodeDepthComparator implements Comparator<StringTreeNode> {
	override compare(StringTreeNode o1, StringTreeNode o2) {
		return o1.getDepth() - o2.getDepth();
	}
	
	def protected int getDepth(StringTreeNode node) {
		if (node.isRoot) {
			return 0;
		} else {
			return getDepth(node.parent) + 1;
		}
	}
}

/**
 * @author rbeckmann
 * 
 * Implements a data tree for strings, used in the TreeNamingService.
 */
class StringTreeNode {

	@Accessors(PUBLIC_GETTER) protected String data;
	@Accessors(PUBLIC_GETTER) protected ArrayList<StringTreeNode> children;
	@Accessors(PUBLIC_GETTER) protected StringTreeNode parent;

	new(String data) {
		this.data = data;
		this.parent = null;
		this.children = new ArrayList();
	}

	new() {
		this.data = null;
		this.parent = null;
		this.children = new ArrayList();
	}

	def protected void addChild(StringTreeNode node) {
		node.parent = this;
		children.add(node);
	}
	
	def protected List<String> getContents() {
		/*
		 * Returns a list of all strings contained in the tree
		 */
		val List<String> contents = newArrayList
		val List<StringTreeNode> endNodes = getEndNodes

		for (StringTreeNode end : endNodes) {
			contents.add(end.contentUpwards);
		}

		return contents;
	}
	
	def protected String getContentUpwards() {
		/*
		 * Traverse tree upwards and return the string ended by this node up to root
		 */
		var s = "";

		if (!isRoot()) {
			s = parent.getContentUpwards() + getData();
		}

		return s;
	}

	def StringTreeNode addStringList(List<String> sList) {
		/*
		 * Adds an array of strings.
		 * If the first element is found within own children's data,
		 * cut the first element and call that child with this function recursively.
		 * Else, create new child with that element, and proceed the same.
		 */
		if (sList.size() == 0) {
			for (child : children) {
				if (child.isEnd()) {
					return child; // only add one end per node - don't allow double strings
				}
			}
			val newNode = new StringTreeNode("");
			addChild(newNode); // mark End
			return newNode;
		}

		var firstString = sList.get(0) ?: ""; // first element to search in own children. If not found, create new one.
		var rest = sList.subList(1, sList.size()); // the rest of the array that the child's addStringList function is called with
		for (child : children) // search for child that fits
		{
			if (child.getData().equals(firstString)) {
				return child.addStringList(rest);
			}
		}
		var newNode = new StringTreeNode(firstString);
		addChild(newNode);
		return newNode.addStringList(rest);
	}

	/*
	 * Tree reading functions
	 */
	/** The weight is the number of children, plus their weight recursively.
	 * 	The tree's root has the maximum weight, while a leaf node's weight is zero.
	 */
	def int getWeight() {
		var weight = children.size()

		for (c : children) {
			weight += c.getWeight()
		}

		return weight;
	}

	def List<StringTreeNode> getEndNodes() {
		/*
		 * returns a list of nodes that are string ending nodes (node.isEnd() == true)
		 */
		var endNodes = new ArrayList<StringTreeNode>();

		for (child : children) {
			if (child.isEnd()) {
				endNodes.add(child);
			}
			endNodes.addAll(child.getEndNodes());
		}
		return endNodes;
	}

	def StringTreeNode getRoot() {
		if (isRoot) {
			this
		} else {
			parent.getRoot()
		}
	}

	def void compress() {
		/*
		 * Compresses branches.
		 * All nodes 'X' that have only one child 'A' append 'A's data to their own, delete  'A' and
		 * make 'A's children their ('X's) own.
		 * Only exception: endNodes, according to node.isEnd() == true, are not consumed.
		 * 
		 * Example:
		 * A, B, C... denote states, - denotes an edge, # denotes an end node, O the root node
		 * 
		 * O-A-B-C-D-E-#
		 *        \
		 *         F-G-#
		 * 
		 * becomes
		 * 
		 * O-ABC-DE-#
		 *      \
		 *       FG-#
		 */
		if (!isRoot()) {
			while (this.children.size() == 1 && !children.get(0).isEnd()) {
				var myChild = children.head;
				this.data += myChild.getData();
				for (child : myChild.getChildren()) {
					this.addChild(child);
				}
				this.children.removeAll(myChild);
			}
		}

		for (child : this.children) {
			child.compress();
		}

	}

	def boolean isRoot() {
		this.parent === null;
	}

	def boolean isEnd() {
		this.children.size() == 0 && this.data.equals("")
	}
}
