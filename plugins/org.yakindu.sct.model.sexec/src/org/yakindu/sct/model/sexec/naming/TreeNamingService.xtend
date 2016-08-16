/**
 *   Copyright (c) 2014-2015 committers of YAKINDU Statechart Tools.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 *   	Markus Mühlbrandt - Initial contribution and API
 *   	Axel Terfloth - Extensions
 */


package org.yakindu.sct.model.sexec.naming

import java.util.ArrayList
import java.util.Comparator
import java.util.HashMap
import java.util.List
import java.util.Map
import javax.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgraph.CompositeElement
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.sct.model.sexec.Reaction
import org.eclipse.xtext.naming.QualifiedName
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.stext.stext.LocalReaction
import com.google.common.collect.Maps

/** Default implementation of the naming service for various identifiers used in the generated code. 
 * It is responsible for identifier construction depending on the thing to be named including different strategies 
 * which also include name shortening.
 */
class TreeNamingService implements INamingService {

	@Inject extension SExecExtensions
	//@Inject extension SgraphExtensions
	@Inject extension StatechartExtensions
	@Inject extension IQualifiedNameProvider
	//@Inject extension StepDepthComparator stepDepthComparator
	//@Inject extension ExecutionScopeDepthComparator executionScopeDepthComparator
	//@Inject extension NamingHelper
	
	@Inject extension ElementNameProvider
	
	@Inject private StringTreeNodeDepthComparator stringTreeNodeDepthComparator

	//@Inject private StextNameProvider provider

	// from public class org.yakindu.sct.generator.c.features.CDefaultFeatureValueProvider extends		
	private static final String VALID_IDENTIFIER_REGEX = "[_a-zA-Z][_a-zA-Z0-9]*";

	var protected int maxLength = 0;

	var protected char separator = '_';

	var protected Map<StringTreeNode, String> map;
	
	var protected Map<NamedElement, StringTreeNode> treeMap;
	
	var protected Map<StringTreeNode, ShortString> shortenMap;
	
	var protected Map<StringTreeNode, List<StringTreeNode>> individualMap; 
	
	var protected StringTreeNode tree;
	
	var protected ExecutionFlow activeFlow;

	var protected Statechart activeStatechart;

	new(int maxLength, char separator) {
		this.maxLength = maxLength
		this.separator = separator
	}

	new() {
		this.maxLength = 0
		this.separator = '_'
	}
	
	override initializeNamingService(Statechart statechart) 
	{
		map = Maps.newHashMap
		treeMap = Maps.newHashMap
		if(tree == null || activeStatechart != statechart)
		{
			activeFlow = null;
			activeStatechart = statechart;
			createNameTree(statechart);
		}
	}
	
	def private void createNameTree(Statechart statechart)
	{
		tree = new StringTreeNode();
		
		addShortVertexNames(statechart);
	}
	
	def protected void addShortVertexNames(CompositeElement element) {
		for (region : element.regions) {
			addElement(region);
			for (vertex : region.vertices) {
				switch vertex {
					State:
						addElement(vertex)
					default:
						addElement(vertex)
				}
			}
		}
		for (region : element.regions) {
			for (vertex : region.vertices) {
				if (vertex instanceof CompositeElement) {
					addShortVertexNames(vertex as CompositeElement)
				}
			}
		}
	}
	
	override initializeNamingService(ExecutionFlow flow) 
	{
		map = Maps.newHashMap
		treeMap = Maps.newHashMap
		if(tree == null || activeFlow != flow)
		{
			activeFlow = flow;
			activeStatechart = null;
			createNameTree(flow);
		}
	}
	
	def private void createNameTree(ExecutionFlow flow)
	{
		// Initialize tree
		tree = new StringTreeNode();
		
		for(region : flow.regions)
		{
			addElement(region);
			for(node : region.nodes) {
				addElement(node);
			}
		}
		
		for(state : flow.states)
		{
			addElement(state);
		}
		for(func : flow.allFunctions)
		{
			addElement(func);
		}
		
		// Create short name for time events of statechart
		if (flow.sourceElement instanceof Statechart) 
		{
			val statechart = flow.sourceElement as Statechart
			addShortTimeEventName(flow, statechart)
		}

		// Create short name for time events of states
		for (executionState : flow.states)
		{
			if (executionState.sourceElement instanceof State) 
			{
				val state = executionState.sourceElement as State
				addShortTimeEventName(executionState, state)
			}
		}
		
		for(s : tree.getContents())
		{
			System.out.println(s);
		}
		
		System.out.println();
	}
	
	def protected void addRegionsNodes(ExecutionRegion region)
	{
		for(node : region.nodes)
		{
			addElement(node);
			if(node instanceof ExecutionRegion)
			{
				addRegionsNodes(node);
			}
		}
	}
	
	def protected addShortTimeEventName(NamedElement executionFlowElement, NamedElement sgraphElement) 
	{
		var timeEventSpecs = sgraphElement.timeEventSpecs;
		for (tes : timeEventSpecs) {
			val timeEvent = executionFlowElement.flow.getTimeEvent(sgraphElement.fullyQualifiedName + "_time_event_" +
				timeEventSpecs.indexOf(tes))
			if (timeEvent != null) {
				addElement(executionFlowElement);
			}
		}
	}
	
	def private void addElement(NamedElement elem)
	{
		val name = elem.elementName();
		
		if(name != null)
		{
			val segments = new ArrayList<String>(name.getSegments());
			if(!segments.isEmpty()) {
				val addedNode = tree.addStringList(segments);
				
				treeMap.put(elem, addedNode); // remember for later access
			}
			//System.out.println(name);
		}
		
	}
	
	def protected asIndexPosition(ExecutionScope it) {
		superScope.subScopes.indexOf(it).toString;
	}

	def protected dispatch asSGraphIndexPosition(Region it) {
		composite.regions.toList.indexOf(it).toString
	}

	def protected dispatch asSGraphIndexPosition(State it) {
		parentRegion.vertices.filter(typeof(State)).toList.indexOf(it).toString
	}

	def protected dispatch asSGraphIndexPosition(Vertex it) {
		parentRegion.vertices.toList.indexOf(it).toString
	}

	def protected removeVowels(String it) {
		replaceAll('[aeiou]', '')
	}
	
	def protected removeSmallLetters(String it) {
		replaceAll('[a-z]', '');
	}

	override public setMaxLength(int length) {
		maxLength = length
	}

	override public setSeparator(char sep) {
		// Check if Prefix is ok		
		var String sepString = sep + ""
		if (!(sepString.matches(VALID_IDENTIFIER_REGEX))) {
			throw new IllegalArgumentException
		}
		separator = sep
	}

	override public getMaxLength() {
		return maxLength
	}

	override public getSeparator() {
		return separator
	}
	
	override getShortName(NamedElement element) {
		createShortname(element);
		
		return map.get(treeMap.get(element));
	}
	
	def private constructIndividualNames()
	{
		individualMap.clear();
		
		var nodes = tree.getEndNodes().sortWith(stringTreeNodeDepthComparator);
		
		var names = new ArrayList<String>();
		
		for(node : nodes)
		{
			var individualNameFound = false;
			
			var currentNode = node.getParent(); // actual end node only contains empty string
			var name = currentNode.getData();
			
			var nodelist = new ArrayList<StringTreeNode>();
			
			individualMap.put(node, nodelist);
			
			nodelist.add(currentNode);
			nodelist.add(node);
			
			/*
			 * elements that point to this node, because we need to check if
			 * it's a step. In that case, we want to prepend one more node,
			 * so that - for example - "lr0" becomes "StateA_lr0".
			 */
			val loop_nodeElements = getNodeElements(node);
			
			var isStep = false;
			
			for(elem : loop_nodeElements)
			{
				if(elem instanceof Step) {
					isStep = true;
				}
			}
			
			if(isStep) {
				currentNode = currentNode.getParent();
				name = currentNode.getData() + separator + name;
				nodelist.add(0, currentNode);
			}
			
			while(!individualNameFound)
			{
				if(!names.contains(name)) {
					individualNameFound = true;
				} else {
					currentNode = currentNode.getParent();
					name = currentNode.getData() + separator + name;
					nodelist.add(0, currentNode);
				}
			}
		}
	}
	
	def private shortenNames()
	{
		if(this.maxLength == 0) {
			return;
		}
		
		var success = false;
		
		if(individualMap.isEmpty()) {
				constructIndividualNames();

		}		
		
		createShortStringMapping();
				
		while(!success)
		{
			/*
			 * Phase 1 - get current Data Set
			 * 
			 * load all current names, construct them, find the longest one.
			 * if the longest one is short enough, set success to true.
			 * Else, shorten it by doing the cheapest possible operations on the ShortStrings.
			 */ 
			var ArrayList<StringTreeNode> longestlist;
			var maxNameLength = 0;
			
			for(endnode : individualMap.keySet()) {
				var nodelist = individualMap.get(endnode);
				var name = "";
				var first = true;
				for(node : nodelist) {
					var shortstr = shortenMap.get(node);
					if(!first) {
						name += this.separator + shortstr.getShortenedString();
					} else {
						name = shortstr.getShortenedString();
						first = false;
					}
				}
				
				if(name.length > maxNameLength) {
					longestlist = new ArrayList(nodelist);
					maxNameLength = name.length();
				}	
				
			}
			
			if(maxNameLength > this.maxLength) {
				var currentLength = maxNameLength;
				var shortStrings = new ArrayList<ShortString>();
				
				for(node : longestlist) {
					shortStrings.add(shortenMap.get(node));
				}
				
				while(currentLength > this.maxLength) {
					var costOfCheapestCut = Integer.MAX_VALUE;
					var ShortString cheapestCut;
					
					var first = true;
					var name = "";
					for(shortstr : shortStrings) {
						if(!first) {
							name += this.separator + shortstr.getShortenedString();
						} else {
							name = shortstr.getShortenedString();
							first = false;
						}
					}
					
					currentLength = name.length();
				}
			}
			else {
				success = true;
			}
		}
	}
	
	def private createShortStringMapping()
	{
		if(!shortenMap.isEmpty()) {
			shortenMap.clear();
		}
		for(node : tree.getNodes()) {
			shortenMap.put(
				node,
				new ShortString(node.getData())
			);
		}
	}
	
	def private createShortname(NamedElement element)
	{
		if(!treeMap.containsKey(element)) {
			addElement(element);
		}
		
		val elementNode = treeMap.get(element);
		
		// check if the node attached to this element already has a name generated
		if(map.containsKey(elementNode))
		{
			return map.get(elementNode);
		}
		
		var HashMap<StringTreeNode, String> treeNames = Maps.newHashMap();
		var nodes = tree.getEndNodes().sortWith(stringTreeNodeDepthComparator);
		
		for(node : nodes)
		{
			var individualNameFound = false;
			
			if(map.containsKey(node))
			{
				treeNames.put(node, map.get(node));
				individualNameFound = true;
						
			}
			var currentNode = node.getParent(); // actual end node only contains empty string
			var name = currentNode.getData();
			
			/*
			 * elements that point to this node, because we need to check if
			 * it's a step. In that case, we want to prepend one more node,
			 * so that - for example - "lr0" becomes "StateA_lr0".
			 */
			val loop_nodeElements = getNodeElements(node);
			
			var isStep = false;
			
			for(elem : loop_nodeElements)
			{
				if(elem instanceof Step) {
					isStep = true;
				}
			}
			
			if(isStep) {
				currentNode = currentNode.getParent();
				name = currentNode.getData() + separator + name;
			}
			
			while(!individualNameFound)
			{
				if(!nameShortEnough(name))
				{
					abbreviate(name);
				}
				if(!map.containsValue(name) && !treeNames.containsValue(name)) {
					treeNames.put(node, name);
					individualNameFound = true;
				} else {
					currentNode = currentNode.getParent();
					name = currentNode.getData() + separator + name;
				}
			}
		}
		
		val searchedName = treeNames.get(elementNode);
		
		map.put(elementNode, searchedName);
	}
	
	def private boolean nameShortEnough(String name) {
		if(this.maxLength == 0 || name.length() < this.maxLength) {
			return true;
		} else {
			return false;
		}
	}
	
	override asEscapedIdentifier(String string) {
		asIdentifier(string);
	}
	
	override asIdentifier(String string) {
		string.replaceAll('[^a-z&&[^A-Z&&[^0-9]]]', separator.toString)
	}
	
	override isKeyword(String string) {
		return false;
	}
	
	override getShortNameMap(Statechart statechart) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getShortNameMap(ExecutionFlow flow) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def public getTreeContents()
	{
		return tree.getContents();
	}
	
	def private List<NamedElement> getNodeElements(StringTreeNode node)
	{
		val ArrayList<NamedElement> list = new ArrayList<NamedElement>();
		
		for(elem : treeMap.keySet())
		{
			if(treeMap.get(elem) == node) {
				list.add(elem);
			}
		}
		
		return list;
	}
	
	def private abbreviate(String name)
	{
		var shortN = name;
		
		var tokens = name.split(this.separator.toString());
		
		while(!nameShortEnough(shortN) && this.map.containsValue(shortN))
		{
			var tooLong = shortN.length - this.maxLength;
			
			
		}
		if(nameShortEnough(name))
		{
			return name;
		}
		
		var shortName = removeVowels(name);
		if(nameShortEnough(shortName))
		{
			return shortName;
		}
		
		shortName = makeShortTokens(name);
		
		return shortName;
	}
	
	def private makeShortTokens(String name)
	{
		var shortName = "";
		val String[] tokens = name.split(this.separator.toString());
		var int i;
		
		for(i=0; i < tokens.length-1; i++)
		{
			shortName += tokens.get(i).charAt(0) + this.separator;
		}		
		
		val lastPart = tokens.get(tokens.length - 1);
		
		if(!nameShortEnough(shortName + lastPart)) {
			if(!nameShortEnough(shortName + removeVowels(lastPart))) {
				if(!nameShortEnough(shortName + removeSmallLetters(lastPart))) {
					
				}
			}
		}
		
		return shortName;
	}
		
	def private Map<String, Integer> getTokenFrequency()
	{
		var ret = new HashMap<String, Integer>();
		var contents = tree.getContents();
		
		for(s : contents) {
			var tokens = s.split(this.separator.toString());
			
			for(var i=0; i < tokens.length; i++)
			{
				ret.put(tokens.get(i), ret.getOrDefault(tokens.get(i), 0) + 1);
			}
		}
		
		return ret;
	}
	
}
