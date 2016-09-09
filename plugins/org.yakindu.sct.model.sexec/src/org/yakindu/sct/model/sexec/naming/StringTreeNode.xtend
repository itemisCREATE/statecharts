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

package org.yakindu.sct.model.sexec.naming

import java.util.ArrayList
import java.util.List
import java.util.Comparator

class StringTreeNodeDepthComparator implements Comparator<StringTreeNode> {
	override compare(StringTreeNode o1, StringTreeNode o2) {
		return o1.getDepth() - o2.getDepth();
	}
}

class StringTreeNode {
	/*
	 * implements a data tree to hold the various statechart elements' names
	 */
	private String data;
	private ArrayList<StringTreeNode> children;
	private StringTreeNode parent;

	/*
	 * Constructors
	 */
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

	/*
	 * getters & setters
	 */
	def public ArrayList<StringTreeNode> getChildren() {
		/*
		 * getter for this.children
		 */
		return children;
	}

	def public String getData() {
		/*
		 * getter for this.data
		 */
		return data;
	}

	/*
	 * Tree construction functions
	 */
	def public void addChild(StringTreeNode node) {
		/*
		 * Function to add a child to this node.
		 */
		node.parent = this;
		children.add(node);
	}

	def public StringTreeNode addString(String s) {
		/*
		 * Cut the string into an ArrayList containing the single chars in the string,
		 * and call addStringList afterwards.
		 */
		var sList = new ArrayList<String>();

		for (var i = 0; i < s.length(); i++) {
			sList.add(Character.toString(s.charAt(i)));
		}
		return this.addStringList(sList);
	}

	def public StringTreeNode addStringList(List<String> sList) {
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

		var firstString = sList.get(0); // first element to search in own children. If not found, create new one.
		var rest = sList.subList(1, sList.size()); // the rest of the array that the child's addStringList function is called with
		var newChild = true;

		for (child : children) // search for child that fits
		{
			if (child.getData().equals(firstString)) {
				newChild = false;
				return child.addStringList(rest);
			}
		}
		if (newChild) {
			var newNode = new StringTreeNode(firstString);
			addChild(newNode);
			return newNode.addStringList(rest);
		}

	}

	/*
	 * Tree reading functions
	 */
	def public List<StringTreeNode> getNodes() {
		var List<StringTreeNode> nodelist = new ArrayList<StringTreeNode>();

		nodelist.add(this);

		for (child : children) {
			nodelist.addAll(child.getNodes())
		}

		return nodelist;
	}

	def public int getWeight() {
		var weight = 0;

		for (c : children) {
			weight += c.getWeight() + 1; // + 1: count children as well
		}

		return weight;
	}

	def public int getDepth() {
		// Upwards recursion to get distance from root
		if (parent == null) {
			return 0;
		} else {
			return parent.getDepth() + 1;
		}
	}

	def public ArrayList<String> getSiblings(String fullName) {

		val nodeChain = getNodeChain(fullName)
		val lastNode = (nodeChain).get(nodeChain.size() - 1);

		val siblings = lastNode.getSiblings();

		val siblingsContents = new ArrayList<String>();

		for (node : siblings) {
			siblingsContents.add(node.getData());
		}
		return siblingsContents
	}

	def public ArrayList<StringTreeNode> getSiblings() {
		// returns a list of the parent's children without this - can be empty.
		if (isRoot()) {
			return new ArrayList<StringTreeNode>();
		} else {
			var list = new ArrayList<StringTreeNode>(this.parent.getChildren()); // copy
			list.removeAll(this);
			return list;
		}

	}

	def public ArrayList<String> getContents() {
		/*
		 * Returns a list of all strings contained in the tree
		 */
		var contents = new ArrayList<String>();
		var endNodes = getEndNodes();

		for (end : endNodes) {
			contents.add(end.getContentUpwards());
		}

		return contents;
	}

	def public ArrayList<StringTreeNode> getEndNodes() {
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

	def public String getContentUpwards() {
		/*
		 * Traverse tree upwards and return the string ended by this node up to root
		 */
		var s = "";

		if (!isRoot()) {
			s = this.parent.getContentUpwards() + this.data;
		}

		return s;
	}

	def public String getShortName(String longname, int maxLen) {
		var nodeChain = getNodeChain(longname);

		var ret = "";

		for (node : nodeChain) {
			ret += node.getData();
		}

		return ret;
	}

	def public void delete() {
		/*
		 * All nodes have a reference to their parent (except the root node, where it's null) and their children.
		 * Thus, when we want to delete a node, we need to cut it from its parent's children and
		 * delete the reference to the parent. The rest of the tree is then 'floating' and will be garbage collected.
		 */
		if (!isRoot()) {
			this.parent.deleteChild(this);
			this.parent = null;
		}
	}

	def public deleteChild(StringTreeNode child) {
		this.children.removeAll(child);
	}

	def public ArrayList<StringTreeNode> getNodeChain(String name) {
		/*
		 * produces an ArrayList containing the Nodes that form the given string.
		 */
		var nodeChain = new ArrayList<StringTreeNode>();

		if (children.size() == 0 || (children.size() == 1 && children.get(0).isEnd())) {
			return nodeChain;
		}

		var maxEquality = 0;
		var StringTreeNode maxEqualNode = null;

		for (child : children) // find maximum equality in tree to select the correct branch
		{
			var childS = child.getData();
			if (name.startsWith(childS) && childS.length() > maxEquality) {
				maxEquality = childS.length();
				maxEqualNode = child;
			}
		}

		if (maxEqualNode == null) {
			return null;
		}

		var rest = name.substring(maxEquality);

		nodeChain.add(maxEqualNode);

		val childrenNodeChain = maxEqualNode.getNodeChain(rest);

		if (childrenNodeChain == null) {
			return null;
		}

		nodeChain.addAll(childrenNodeChain);

		return nodeChain;
	}

	def public StringTreeNode navigate(String content) {
		for (child : children) {
			if (content.equals(child.getData())) {
				return child;
			}
		}

		return null;
	}

	def public StringTreeNode getParent() {
		return parent;
	}

	def public List<String> getChildrenContents() {
		var returnList = new ArrayList<String>();

		for (child : children) {
			returnList.add(child.getData());
		}

		return returnList;
	}

	/*
	 * Tree manipulating functions
	 */
	def public void compress() {
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
		if (!isRoot()) // don't do for root, no data should be saved in root
		{
			while (this.children.length() == 1 && !children.get(0).isEnd()) {
				var myChild = children.get(0); // reference to only child
				this.children.removeAll(myChild); // delete from list
				this.data += myChild.getData(); // append myChilds data to own
				for (child : myChild.getChildren()) // adopt myChilds children as own
				{
					this.addChild(child);
				}
			}
		}

		for (child : this.children) // recursion
		{
			child.compress();
		}

	}

	/*
	 * Helper functions
	 */
	def public boolean isAncestor(StringTreeNode descendantNode) {
		/*
		 * Traverses the tree upwards and checks if the node this function is called on is an ancestor of the given node.
		 * 
		 * Example:
		 * 
		 * O-A-B-C-D
		 *      \
		 *       E
		 * 
		 * When called on 'B', given 'D', this should return true, but not the other way round:
		 * 'D' is not root, and 'D's parent is not 'B', so the function is called again with 'C'. 'B' is 'C's parent, returns true.
		 * 
		 * When called on 'E', given 'C', this should return false, and has the same behaviour when called on 'C' given 'E'.
		 * 1st. call: 'C' is not root, and 'C's parent is not 'E', so the function is called again with 'B'.
		 * 2nd. call: 'B' is not root, and 'B's parent is not 'E', so the function is called again with 'A'.
		 * 3rd. call: 'A' is not root, and 'A's parent is not 'E', so the function is called again with 'O', the root node.
		 * 4th. call: 'O' is the root node, false is returned. E is not an ancestor of C.
		 * 
		 * ATTENTION: This function does NOT return true if this is a root node. This would not test if descendantNode
		 * belongs to this tree.
		 * 
		 */
		if (descendantNode.isRoot()) // obviously, this node can't be the ancestor when descendantNode is root
		{
			return false;
		} else if (descendantNode.parent == this) {
			return true;
		} else {
			return this.isAncestor(descendantNode.parent)
		}
	}

	def public int getDistance(StringTreeNode otherNode) {
		if (this == otherNode) {
			return 0;
		} else if (this.isRoot()) {
			return otherNode.getDepth();
		} else if (otherNode.isRoot()) {
			return this.getDepth();
		} else if (this.isAncestor(otherNode)) {
			return otherNode.getDepth() - this.getDepth();
		} else if (otherNode.isAncestor(this)) {
			return this.getDepth() - otherNode.getDepth();
		} else {
			val commonAncestor = this.getCommonAncestor(otherNode);
			val distance = this.getDepth() + otherNode.getDepth() - 2 * commonAncestor.getDepth();
			return distance;
		}
	}

	def public StringTreeNode getCommonAncestor(StringTreeNode otherNode) {
		if (this == otherNode) {
			return this;
		} else if (this.isAncestor(otherNode)) {
			return this;
		} else if (otherNode.isAncestor(this)) {
			return otherNode;
		} else {
			// find node next to root, climb upwards until ancestor of other node is found
			var StringTreeNode upperNode;
			var StringTreeNode underNode;
			val thisDepth = this.getDepth();
			val otherDepth = otherNode.getDepth();
			if (thisDepth > otherDepth) {
				upperNode = otherNode;
				underNode = this;
			} else {
				upperNode = this;
				underNode = otherNode;
			}
			while (!upperNode.isAncestor(underNode)) {
				upperNode = upperNode.parent;
			}
			return upperNode;
		}
	}

	def public boolean isRoot() {
		return this.parent == null;
	}

	def public boolean isEnd() {
		var ret = (this.children.size() == 0 && this.data.equals(""));
		return ret;
	}
}
