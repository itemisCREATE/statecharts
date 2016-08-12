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

	@Inject private StextNameProvider provider

	// from public class org.yakindu.sct.generator.c.features.CDefaultFeatureValueProvider extends		
	private static final String VALID_IDENTIFIER_REGEX = "[_a-zA-Z][_a-zA-Z0-9]*";

	var protected int maxLength = 0;

	var protected char separator = '_';

	var protected Map<NamedElement, String> map;
	
	var protected Map<NamedElement, StringTreeNode> treeMap;
	
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
		if(map.containsKey(element)) {
			return map.get(element);
		} 
		else 
		{
			if(!treeMap.containsKey(element)) {
				addElement(element);
			}
			createShortname(element);
			return map.get(element);
		}
	}
	
	def createShortname(NamedElement element)
	{
		if(map.containsKey(element))
		{
			return map.get(element);
		}
		
		var HashMap<StringTreeNode, String> treeNames = Maps.newHashMap();
		var nodes = tree.getEndNodes().sortWith(stringTreeNodeDepthComparator);
		
		// Create names for every node in the tree
		for(node : nodes)
		{
			var individualNameFound = false;
			var currentNode = node.getParent(); // actual end node only contains empty string
			var name = currentNode.getData();
			
			if(element instanceof Step)
			{
				currentNode = currentNode.getParent();
				name = currentNode.getData() + separator + name;
			}
			
			while(!individualNameFound)
			{
				if(!map.containsValue(name) && !treeNames.containsValue(name)) {
					treeNames.put(node, name);
					individualNameFound = true;
				} else {
					currentNode = currentNode.getParent();
					name = currentNode.getData() + separator + name;
				}
			}
		}
		
		val elementNode = treeMap.get(element);
		val searchedName = treeNames.get(elementNode);
		
		map.put(element, searchedName);
		
		// save future work and remove already resolved element from the tree. We are done with it. Note: Only END-nodes are removed, no actual content.
//		treeMap.remove(element);
//		elementNode.delete();
		
		System.out.println(searchedName);
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

	
}
