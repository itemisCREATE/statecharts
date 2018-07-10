/** 
 * Copyright (c) 2016 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * @author René Beckmann (beckmann@itemis.de)
 *
*/
package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sexec.naming.tree.StringTreeNode;

public class StringTreeNodeTest {
	private StringTreeNode tree;

	@Before
	public void setupStringTreeNode() {
		tree = new StringTreeNode();
	}

	@Test
	public void stringAddTest() {
		/*
		 * Add a few strings where some are substrings of others and check if
		 * they all exist in the tree.
		 */

		List<String> testStrings = new ArrayList<String>();

		testStrings.add("Statechart1");
		testStrings.add("Statechart2");
		testStrings.add("Statechart1.Region1");
		testStrings.add("Statechart1.Region2");
		testStrings.add("Statechart1.Region1.StateA");
		testStrings.add("Statechart1.Region2.StateA");

		for (String s : testStrings) {
			addString(tree, s);
		}

		List<String> treeContents = getContents(tree);

		stringListsEqual(testStrings, treeContents);
	}

	@Test
	public void noDoublesTest() {
		// Add the same string twice, expect it to be in the tree only once.
		addString(tree, "DoubleString");
		addString(tree, "DoubleString");

		assertEquals(1, getContents(tree).size());
	}

	@Test
	public void compressTest() {
		// Add data to the tree, compress it, and compare contents before and
		// after compressing.
		addString(tree, "PartOne");
		addString(tree, "PartTwo");

		List<String> beforeContents = getContents(tree);

		tree.compress();

		List<String> afterContents = getContents(tree);

		stringListsEqual(beforeContents, afterContents);
	}

	@Test
	public void compressNodeTest() {
		// Add data to the tree, compress it, and check if the nodes match the
		// expectation.
		addString(tree, "PartOne");
		addString(tree, "PartTwo");

		tree.compress();

		List<StringTreeNode> nodelist = getNodes(tree);
		List<String> nodecontents = new ArrayList<String>();
		List<String> expectednodecontents = new ArrayList<String>();

		expectednodecontents.add("Part");
		expectednodecontents.add("One");
		expectednodecontents.add("Two");
		expectednodecontents.add(""); // two end nodes should be present
		expectednodecontents.add("");

		for (StringTreeNode node : nodelist) {
			if (node.getData() != null) {
				nodecontents.add(node.getData());
			}
		}

		stringListsEqual(nodecontents, expectednodecontents);
	}

	@Test
	public void nodeChainContainedTest() {
		buildStandardTestTree();
		String testString = new String("Sc1Reg1StateA");
		List<StringTreeNode> nodes = getNodeChain(tree, testString);

		StringBuilder builder = new StringBuilder();

		for (StringTreeNode node : nodes) {
			builder.append(node.getData());
		}

		assertEquals(testString, builder.toString());
	}

	@Test
	public void nodeChainNotContainedTest() {
		buildStandardTestTree();
		String testString = new String("Sc1Reg3StateA");
		List<StringTreeNode> nodes = getNodeChain(tree, testString);

		assertEquals(nodes, null);
	}

	@Test
	public void endNodesTest() {
		buildStandardTestTree();
		tree.addStringList(new ArrayList<String>(Arrays.asList("Sc1", "Reg1")));

		assertEquals(6, tree.getEndNodes().size());
	}

	@Test
	public void navigateTest() {
		buildStandardTestTree();

		StringTreeNode nextnode = navigate(tree, "Sc1");

		assertEquals(true, nextnode != null);
		assertEquals("Sc1", nextnode.getData());

		nextnode = navigate(nextnode, "Reg2");

		assertEquals(true, nextnode != null);
		assertEquals("Reg2", nextnode.getData());

		nextnode = navigate(nextnode, "StateA");

		assertEquals(true, nextnode != null);
		assertEquals("StateA", nextnode.getData());

		nextnode = nextnode.getParent().getParent();

		assertEquals(true, nextnode != null);
		assertEquals("Sc1", nextnode.getData());
	}

	@Test
	public void childrenContentTest() {
		buildStandardTestTree();

		StringTreeNode nextnode = navigate(tree, "Sc1");

		ArrayList<String> expectedChildren = new ArrayList<String>(Arrays.asList("Reg1", "Reg2"));

		stringListsEqual(expectedChildren, getChildrenContents(nextnode));
	}

	@Test
	public void addStringListReturnTest1() {
		List<String> list = new ArrayList<String>(Arrays.asList("Un", "Deux", "Trois", "Quatre"));
		StringTreeNode testNode = tree.addStringList(list);

		assertEquals("UnDeuxTroisQuatre", getContentUpwards(testNode));
	}

	@Test
	public void addStringListReturnTest2() {
		List<String> list1 = new ArrayList<String>(Arrays.asList("Un", "Deux", "Trois", "Quatre"));
		List<String> list2 = new ArrayList<String>(list1);
		list2.add("Cinq");

		tree.addStringList(list2);

		StringTreeNode testNode = tree.addStringList(list1);

		assertEquals("UnDeuxTroisQuatre", getContentUpwards(testNode));
	}

	@Test
	public void weightTest() {
		buildStandardTestTree();

		assertEquals(15, tree.getWeight());
	}

	protected void buildStandardTestTree() {
		/*
		 * StateA / root-Sc1-Reg1-StateB \ \ \ \ \ StateC \ \ \ Reg2-StateA \
		 * Sc2-Reg1-StateA
		 */
		tree.addStringList(new ArrayList<String>(Arrays.asList("Sc1", "Reg1", "StateA")));
		tree.addStringList(new ArrayList<String>(Arrays.asList("Sc1", "Reg1", "StateB")));
		tree.addStringList(new ArrayList<String>(Arrays.asList("Sc1", "Reg1", "StateC")));
		tree.addStringList(new ArrayList<String>(Arrays.asList("Sc1", "Reg2", "StateA")));
		tree.addStringList(new ArrayList<String>(Arrays.asList("Sc2", "Reg1", "StateA")));
	}

	protected void stringListsEqual(List<String> onelist, List<String> otherlist) {
		java.util.Collections.sort(onelist, Collator.getInstance());
		java.util.Collections.sort(otherlist, Collator.getInstance());
		assertEquals(onelist, otherlist);
	}
	
	protected StringTreeNode navigate(StringTreeNode node, String content) {
		for (StringTreeNode child : node.getChildren()) {
			if (content.equals(child.getData())) {
				return child;
			}
		}

		return null;
	}
	
	protected List<String> getContents(StringTreeNode tree) {
		/*
		 * Returns a list of all strings contained in the tree
		 */
		List<String> contents = new ArrayList<>();
		List<StringTreeNode> endNodes = tree.getEndNodes();

		for (StringTreeNode end : endNodes) {
			contents.add(getContentUpwards(end));
		}

		return contents;
	}

	protected String getContentUpwards(StringTreeNode node) {
		/*
		 * Traverse tree upwards and return the string ended by this node up to root
		 */
		String s = "";

		if (!node.isRoot()) {
			s = getContentUpwards(node.getParent()) + node.getData();
		}

		return s;
	}
	
	protected List<String> getChildrenContents(StringTreeNode node) {
		List<String> returnList = new ArrayList<>();

		for (StringTreeNode child : node.getChildren()) {
			returnList.add(child.getData());
		}

		return returnList;
	}
	
	protected List<StringTreeNode> getNodeChain(StringTreeNode tree, String name) {
		/*
		 * produces an ArrayList containing the Nodes that form the given string.
		 */
		List<StringTreeNode> nodeChain = new ArrayList<>();

		if (tree.getChildren().size() == 0 || (tree.getChildren().size() == 1 && tree.getChildren().get(0).isEnd())) {
			return nodeChain;
		}

		int maxEquality = 0;
		StringTreeNode maxEqualNode = null;

		for (StringTreeNode child : tree.getChildren()) // find maximum equality in tree to select the correct branch
		{
			String childS = child.getData();
			if (name.startsWith(childS) && childS.length() > maxEquality) {
				maxEquality = childS.length();
				maxEqualNode = child;
			}
		}

		if (maxEqualNode == null) {
			return null;
		}

		String rest = name.substring(maxEquality);

		nodeChain.add(maxEqualNode);

		List<StringTreeNode> childrenNodeChain = getNodeChain(maxEqualNode, rest);

		if (childrenNodeChain == null) {
			return null;
		}

		nodeChain.addAll(childrenNodeChain);

		return nodeChain;
	}
	
	protected StringTreeNode addString(StringTreeNode node, String s) {
		/*
		 * Cut the string into an ArrayList containing the single chars in the string,
		 * and call addStringList afterwards.
		 */
		List<String> sList = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			sList.add(Character.toString(s.charAt(i)));
		}
		return node.addStringList(sList);
	}
	
	protected List<StringTreeNode> getNodes(StringTreeNode node) {
		List<StringTreeNode> nodelist = new ArrayList<>();

		nodelist.add(node);

		for (StringTreeNode child : node.getChildren()) {
			nodelist.addAll(getNodes(child));
		}

		return nodelist;
	}
}
