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

	/*
	 * Holds the name of each element whose name was requested.
	 */
	var protected Map<NamedElement, String> map;
	
	/*
	 * Holds the end node in the tree for each NamedElement that was added.
	 */
	var protected Map<NamedElement, StringTreeNode> treeMap;
	
	/*
	 * For each node in the tree, there is a mapping to a short string managing the shortening of the name.
	 */
	var protected Map<StringTreeNode, ShortString> node_shortString_map;
	
	/*
	 * For each end node, individualMap holds a List of Nodes which make this name individual. (a subset of the tree basically)
	 */
	var protected Map<StringTreeNode, ArrayList<StringTreeNode>> individualMap;
	
	var protected boolean shortNamesValid; // marker to remember if the names are currently correctly shortened
	
	var protected StringTreeNode tree; // the tree which holds the added names
	
	// if the naming service is initialized with a flow, activeStatechart is null, and vice versa.
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
		if(tree == null || activeStatechart != statechart)
		{
			map = Maps.newHashMap
			treeMap = Maps.newHashMap
			shortNamesValid = false;
		
			activeFlow = null;
			activeStatechart = statechart;
			createNameTree(statechart);
			
			individualMap = constructIndividualNames();
			node_shortString_map = createShortStringMapping();
			
			shortenNames();
		}
	}
	
	def private void createNameTree(Statechart statechart)
	{
		tree = new StringTreeNode();
		
		addShortVertexNames(statechart);
	}
	
	def protected void addShortVertexNames(CompositeElement element) {
		for (region : element.regions) {
			addElement(region, new ArrayList<String>(), new ArrayList<String>());
			for (vertex : region.vertices) {
				switch vertex {
					State:
						addElement(vertex, new ArrayList<String>(), new ArrayList<String>())
					default:
						addElement(vertex, new ArrayList<String>(), new ArrayList<String>())
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
		if(tree == null || activeFlow != flow)
		{
			map = Maps.newHashMap
			treeMap = Maps.newHashMap
			shortNamesValid = false;
			
			activeFlow = flow;
			activeStatechart = null;
			
			createNameTree(flow);
			individualMap = constructIndividualNames();
			node_shortString_map = createShortStringMapping();
			
			shortenNames();
		}
	}
	
	def private void createNameTree(ExecutionFlow flow)
	{
		// Initialize tree
		tree = new StringTreeNode();
		
		for(region : flow.regions)
		{
			addElement(region, new ArrayList<String>(), new ArrayList<String>());
			for(node : region.nodes) {
				addElement(node, new ArrayList<String>(), new ArrayList<String>());
			}
		}
		
		for(state : flow.states)
		{
			addElement(state, state.prefix, state.suffix);
		}
		for(func : flow.allFunctions)
		{
			addElement(func, func.prefix, func.suffix);
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
	}
	
	def public test_printTreeContents()
	{
		for(s : tree.getContents())
		{
			System.out.println(s);
		}
		
		System.out.println();
	}
	
	def protected addShortTimeEventName(NamedElement executionFlowElement, NamedElement sgraphElement) 
	{
		var timeEventSpecs = sgraphElement.timeEventSpecs;
		for (tes : timeEventSpecs) {
			val timeEvent = executionFlowElement.flow.getTimeEvent(sgraphElement.fullyQualifiedName + "_time_event_" +
				timeEventSpecs.indexOf(tes))
			if (timeEvent != null) {
				addElement(executionFlowElement, prefix(tes, sgraphElement), suffix(tes, sgraphElement));
			}
		}
	}
	
	def private void addElement(NamedElement elem, List<String> prefix, List<String> suffix)
	{
		val name = new ArrayList<String>(elem.elementNameSegments());
		val segments = new ArrayList<String>();
		segments.addAll(prefix);
		segments.addAll(name);
		segments.addAll(suffix);
		if(!segments.isEmpty()) {
			val addedNode = tree.addStringList(segments);
			
			treeMap.put(elem, addedNode); // remember for later access
			
			shortNamesValid = false;
		}
		//System.out.println(name);
	
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
		if(map.containsKey(element)) {
			return map.get(element);
		}
		if(!treeMap.containsKey(element)) {
			addElement(element, new ArrayList<String>(), new ArrayList<String>());
		}
		
		if(!shortNamesValid) {
			shortenNames();
		}
		
		val name = getShortenedName(element);
		
		map.put(element, name);
		return name;
	}
	
	def private Map<StringTreeNode, ArrayList<StringTreeNode>> constructIndividualNames()
	{
		val HashMap<StringTreeNode, ArrayList<StringTreeNode>> mapping = newHashMap;
		
		val nodes = tree.getEndNodes().sortWith(stringTreeNodeDepthComparator);
		
		val names = new ArrayList<String>();
		for(node : nodes)
		{
			var individualNameFound = false;
			
			var currentNode = node.getParent(); // actual end node only contains empty string
			var name = currentNode.getData();
			
			val nodelist = new ArrayList<StringTreeNode>();
			
			mapping.put(node, nodelist); // 'nodelist' is filled further down
			
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
				// if this NamedElement is a step, it has a name like "tr0" or "lr0". That's not very descriptive,
				// so it's prepended with the name of the parent element, like for example "StateA".
				currentNode = currentNode.getParent();
				name = currentNode.getData() + separator + name;
				nodelist.add(0, currentNode);
			}
			
			while(!individualNameFound)
			{
				// prepend further parent elements (walk tree upwards) until an individual name is found.
				if(!names.contains(name)) {
					individualNameFound = true;
					names.add(name);
				} else {
					currentNode = currentNode.getParent();
					name = currentNode.getData() + separator + name;
					nodelist.add(0, currentNode);
				}
			}
		}
		
		return mapping;
	}
	
	def private shortenNames()
	{
		if(this.maxLength == 0) {
			return;
		}
		
		if(individualMap == null || individualMap.isEmpty()) {
			constructIndividualNames();
		}		
		
		val max_weight = tree.getWeight();
		
		while(shortenOneCharacter(tree.getEndNodes(), max_weight)) {}
		
		shortNamesValid = true;
	}
	
	def private boolean shortenOneCharacter(ArrayList<StringTreeNode> endnodes, int max_weight)
	{
		var max_length = 0;
		var StringTreeNode max_length_node;
		
		var names = new ArrayList<String>();
		
		for(node : endnodes)
		{
			var newname = node.getIndividualName.joinShortStrings();
			names.add(newname);
			var length = newname.length();
			if(length > max_length)
			{
				max_length = length;
				max_length_node = node;
			}
		}
		
		if(max_length < this.maxLength) {
			return false;
		}
		
		var min_cost = Integer.MAX_VALUE;
		var ShortString best_cut;
		
		for(node : max_length_node.getIndividualName) // all nodes describing the individual name of this end node
		{
			val shortstr = node.shortStringForNode;
			val current_cost = shortstr.getCutCost();
			
			var noDoubles = false;
			
			val node_cost_factor = max_weight - node.getWeight() + 1;
			
			shortstr.removeCheapestChar();
			
			val cut_cost = (shortstr.getCutCost() - current_cost) * node_cost_factor;
			
			val current_name = max_length_node.getIndividualName.joinShortStrings;
			
			if(!names.contains(current_name)) {
				noDoubles = true;
				// do further check to avoid double names only when quick check is okay
				var doubleCheckArray = new ArrayList<String>();
				for(n : endnodes)
				{
					var newname = n.getIndividualName.joinShortStrings();
					if(doubleCheckArray.contains(newname)) {
						noDoubles = false;
					}
					doubleCheckArray.add(newname);
				}
			}
			
			if(noDoubles && cut_cost > 0 && cut_cost < min_cost) {
				min_cost = cut_cost;
				best_cut = shortstr;
			}
			
			shortstr.rollback(); // revert changes
		}
		
		if(best_cut == null) {
			return false;
		}
		best_cut.removeCheapestChar(); // reapply best change
		return true;
	}
	
	def private Map<StringTreeNode, ShortString> createShortStringMapping()
	{
		val HashMap<StringTreeNode, ShortString> mapping = newHashMap;
		for(node : tree.getNodes()) {
			mapping.put(
				node,
				new ShortString(node.getData())
			);
		}
		
		return mapping;
	}
	
	def private StringTreeNode getNodeForElement(NamedElement elem)
	{
		return treeMap.get(elem);
	}
	
	def private ShortString getShortStringForNode(StringTreeNode node)
	{
		if(node_shortString_map == null || node_shortString_map.isEmpty())
		{
			createShortStringMapping();
		}
		return node_shortString_map.get(node);
	}
	
	def private ArrayList<StringTreeNode> getIndividualName(StringTreeNode node)
	{
		if(individualMap.isEmpty())
		{
			constructIndividualNames();
		}
		return individualMap.get(node);
	}
	
	def private getShortenedName(StringTreeNode node)
	{
		return joinShortStrings(getIndividualName(node));
	}
	
	def private getShortenedName(NamedElement elem)
	{
		return getShortenedName(getNodeForElement(elem));
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
	
	def private String joinShortStrings(ArrayList list)
	{
		val sb = new StringBuilder();
		var first = true;
		
		for(s : list)
		{
			var String shortened;
			if(s instanceof ShortString) {
				shortened = s.getShortenedString(); 
			} else if(s instanceof StringTreeNode) {
				shortened = s.getShortStringForNode.getShortenedString();
			}
			if(shortened.length > 0) {
				if(first) {
					sb.append(shortened);
					first = false;
				} else {
					sb.append(separator);
					sb.append(shortened);
				}
			}
		}
		
		return sb.toString();
	}
	
	def protected suffix(Step it) {
		var l = new ArrayList<String>();
		
		switch (it) {
			case isCheckFunction: { l.add("check"); }
			case isEntryAction: { l.add("enact"); }
			case isExitAction: { l.add("exact"); }
			case isEffect: { l.add("effect"); }
			case isEnterSequence: { l.add("enseq"); }
			case isDeepEnterSequence: { l.add("dhenseq"); }
			case isShallowEnterSequence: { l.add("shenseq"); }
			case isExitSequence: { l.add("exseq"); }
			case isReactSequence: { l.add("react"); }
			default: {}
		}
		
		return l;
	}

	def protected prefix(Step it){
		return new ArrayList<String>();
	}

	def protected prefix(ExecutionState it) {
		var l = new ArrayList<String>();
		//l.add(flow.name);
		return l;
	}

	def protected suffix(ExecutionState it) {
		return new ArrayList<String>();
	}

	def protected prefix(TimeEventSpec it, NamedElement element) {
		var l = new ArrayList<String>();
		//l.add(activeFlow.name);
		return l;
	}

	def protected suffix(TimeEventSpec it, NamedElement element) {
		var l = new ArrayList<String>();
		switch (element) {
			Statechart: { l.add("tev" + element.timeEventSpecs.indexOf(it)); }
			State: { l.add("tev" + element.timeEventSpecs.indexOf(it)); }
		}
		return l;
	}

	def protected prefix(State it) {
		var l = new ArrayList<String>();
		//l.add(activeStatechart.name);
		return l;
	}

	def protected prefix(Vertex it) {
		return new ArrayList<String>();
	}

	def protected suffix(Vertex it) {
		return new ArrayList<String>();
	}
}
