/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * René Beckmann - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import org.yakindu.sct.model.sexec.naming.StringTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringTreeNodeTest {
	private StringTreeNode tree;
	
	@Before
	public void setupStringTreeNode()
	{
		tree = new StringTreeNode();
	}
	
	@Test
	public void stringAddTest()
	{
		/*
		 * Add a few strings where some are substrings of others and check if they all exist in the tree.
		 */
		
		List<String> testStrings = new ArrayList<String>();
		
		testStrings.add("Statechart1");
		testStrings.add("Statechart2");
		testStrings.add("Statechart1.Region1");
		testStrings.add("Statechart1.Region2");
		testStrings.add("Statechart1.Region1.StateA");
		testStrings.add("Statechart1.Region2.StateA");
		
		for(String s : testStrings)
		{
			tree.addString(s);
		}
		
		List<String> treeContents = tree.getContents();
		
		stringListsEqual(testStrings, treeContents);
	}
	
	@Test
	public void noDoublesTest()
	{
		// Add the same string twice, expect it to be in the tree only once.
		tree.addString("DoubleString");
		tree.addString("DoubleString");
		
		assertEquals(1, tree.getContents().size());
	}
	
	@Test
	public void compressTest()
	{
		// Add data to the tree, compress it, and compare contents before and after compressing.
		tree.addString("PartOne");
		tree.addString("PartTwo");
		
		List<String> beforeContents = tree.getContents();
		
		tree.compress();
		
		List<String> afterContents = tree.getContents();
		
		stringListsEqual(beforeContents, afterContents);
	}
	
	@Test
	public void compressNodeTest()
	{
		// Add data to the tree, compress it, and check if the nodes match the expectation.
		tree.addString("PartOne");
		tree.addString("PartTwo");
		
		tree.compress();
		
		List<StringTreeNode> nodelist = tree.getNodes();
		List<String> nodecontents = new ArrayList<String>();
		List<String> expectednodecontents = new ArrayList<String>();
		
		expectednodecontents.add("Part");
		expectednodecontents.add("One");
		expectednodecontents.add("Two");
		expectednodecontents.add(""); //two end nodes should be present
		expectednodecontents.add("");
		
		for(StringTreeNode node : nodelist)
		{
			if(node.getData() != null)
			{
				nodecontents.add(node.getData());
			}
		}
		
		stringListsEqual(nodecontents, expectednodecontents);
	}
	
	@Test
	public void hasSiblingsTest()
	{
		testSiblings("Sc1Reg1StateA", new ArrayList<String>(
				Arrays.asList("StateB", "StateC")));
	}
	
	@Test
	public void hasNoSiblingsTest()
	{
		testSiblings("Sc1Reg2StateA", new ArrayList<String>());
	}
	
	@Test
	public void nodeChainContainedTest()
	{
		buildStandardTestTree();
		String testString = new String("Sc1Reg1StateA");
		List<StringTreeNode> nodes = tree.getNodeChain(testString);
		
		StringBuilder builder = new StringBuilder();
		
		for(StringTreeNode node : nodes)
		{
			builder.append(node.getData());
		}
		
		assertEquals(testString, builder.toString());
	}
	
	@Test
	public void nodeChainNotContainedTest()
	{
		buildStandardTestTree();
		String testString = new String("Sc1Reg3StateA");
		List<StringTreeNode> nodes = tree.getNodeChain(testString);
		
		assertEquals(nodes, null);
	}
	
	@Test
	public void endNodesTest()
	{
		buildStandardTestTree();
		tree.addStringList(new ArrayList<String>(
				Arrays.asList("Sc1", "Reg1")
		));
		
		assertEquals(6, tree.getEndNodes().size());
	}
	
	@Test
	public void distanceTest()
	{
		buildStandardTestTree();
		List<StringTreeNode> nodes1, nodes2, nodes3, nodes4;
		StringTreeNode testNode1, testNode2, testNode3, testNode4; 
		
		nodes1 = tree.getNodeChain("Sc1Reg1StateA");
		nodes2 = tree.getNodeChain("Sc1Reg1StateB");
		nodes3 = tree.getNodeChain("Sc1Reg2StateA");
		nodes4 = tree.getNodeChain("Sc2Reg1StateA");
		
		testNode1 = nodes1.get(nodes1.size() - 1); // (Sc1Reg1)State A
		testNode2 = nodes2.get(nodes2.size() - 1); // (Sc1Reg1)State B
		testNode3 = nodes3.get(nodes3.size() - 1); // (Sc1Reg2)State A
		testNode4 = nodes4.get(nodes4.size() - 1); // (Sc2Reg1)State A
		
		assertEquals(2, testNode1.getDistance(testNode2));
		assertEquals(4, testNode1.getDistance(testNode3));
		assertEquals(6, testNode1.getDistance(testNode4));
	}
	
	@Test
	public void navigateTest()
	{
		buildStandardTestTree();
		
		StringTreeNode nextnode = tree.navigate("Sc1");
		
		assertEquals(true, nextnode!=null);
		assertEquals("Sc1", nextnode.getData());
		
		nextnode = nextnode.navigate("Reg2");
		
		assertEquals(true, nextnode!=null);
		assertEquals("Reg2", nextnode.getData());
		
		nextnode = nextnode.navigate("StateA");
		
		assertEquals(true, nextnode!=null);
		assertEquals("StateA", nextnode.getData());
		
		nextnode = nextnode.getParent().getParent();
		
		assertEquals(true, nextnode!=null);
		assertEquals("Sc1", nextnode.getData());
	}
	
	@Test
	public void childrenContentTest()
	{
		buildStandardTestTree();
		
		StringTreeNode nextnode = tree.navigate("Sc1");
		
		ArrayList<String> expectedChildren = new ArrayList<String>(Arrays.asList("Reg1", "Reg2"));
		
		stringListsEqual(expectedChildren, nextnode.getChildrenContents());
	}
	
	@Test
	public void deletionTest()
	{
		buildStandardTestTree();
		
		tree.navigate("Sc1").navigate("Reg2").delete();
		
		ArrayList<String> expectedContents = new ArrayList<String>(
				Arrays.asList(
						"Sc1Reg1StateA",
						"Sc1Reg1StateB",
						"Sc1Reg1StateC",
						"Sc2Reg1StateA"
						));
		
		stringListsEqual(expectedContents, tree.getContents());
	}
	
	@Test
	public void addStringListReturnTest1()
	{
		List<String> list = new ArrayList<String>(
				Arrays.asList("Un", "Deux", "Trois", "Quatre")
				);
		StringTreeNode testNode = tree.addStringList(list);
		
		assertEquals("UnDeuxTroisQuatre", testNode.getContentUpwards());
	}
	
	@Test
	public void addStringListReturnTest2()
	{
		List<String> list1 = new ArrayList<String>(
				Arrays.asList("Un", "Deux", "Trois", "Quatre")
				);
		List<String> list2 = new ArrayList<String>(list1);
		list2.add("Cinq");
		
		tree.addStringList(list2);
		
		StringTreeNode testNode = tree.addStringList(list1);
		
		assertEquals("UnDeuxTroisQuatre", testNode.getContentUpwards());
	}
	
	@Test
	public void weightTest()
	{
		buildStandardTestTree();
		
		assertEquals(15, tree.getWeight());
	}
	
	private void testSiblings(String testString, List<String> expectedSiblings)
	{
		buildStandardTestTree();
		stringListsEqual(tree.getSiblings(testString), expectedSiblings);
	}
	
	private void buildStandardTestTree()
	{
		/*
		 * 				 StateA
		 *              /
		 * root-Sc1-Reg1-StateB
		 *  \     \     \
		 *   \     \     StateC
		 *    \     \
		 *     \     Reg2-StateA
		 *      \
		 *       Sc2-Reg1-StateA
		 */      
		tree.addStringList(new ArrayList<String>(
				Arrays.asList("Sc1", "Reg1", "StateA")
		));
		tree.addStringList(new ArrayList<String>(
				Arrays.asList("Sc1", "Reg1", "StateB")
		));
		tree.addStringList(new ArrayList<String>(
				Arrays.asList("Sc1", "Reg1", "StateC")
		));
		tree.addStringList(new ArrayList<String>(
				Arrays.asList("Sc1", "Reg2", "StateA")
		));
		tree.addStringList(new ArrayList<String>(
				Arrays.asList("Sc2", "Reg1", "StateA")
		));
	}
	
	private void stringListsEqual(List<String> onelist, List<String> otherlist)
	{
		onelist.sort(null);
		otherlist.sort(null);
		assertEquals(onelist, otherlist);
	}
}
