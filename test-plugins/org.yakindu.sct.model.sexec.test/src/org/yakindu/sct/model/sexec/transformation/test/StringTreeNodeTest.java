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
	
	private void testSiblings(String testString, List<String> expectedSiblings)
	{
		buildStandardTestTree();
		stringListsEqual(tree.getSiblings(testString), expectedSiblings);
	}
	
	private void buildStandardTestTree()
	{
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
