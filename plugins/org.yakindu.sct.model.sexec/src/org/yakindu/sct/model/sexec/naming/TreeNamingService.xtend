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
import java.util.HashMap
import java.util.List
import java.util.Map
import javax.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgraph.CompositeElement
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import com.google.common.collect.Maps

/** New implementation of the naming service for various identifiers used in the generated code. 
 * It is responsible for identifier construction depending on the thing to be named including different strategies 
 * which also include name shortening.
 */
class TreeNamingService implements INamingService {

	@Inject extension SExecExtensions
	@Inject extension StatechartExtensions
	@Inject extension IQualifiedNameProvider

	@Inject extension ElementNameProvider

	@Inject protected StringTreeNodeDepthComparator stringTreeNodeDepthComparator

	// from public class org.yakindu.sct.generator.c.features.CDefaultFeatureValueProvider extends		
	protected static final String VALID_IDENTIFIER_REGEX = "[_a-zA-Z][_a-zA-Z0-9]*";

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

	override initializeNamingService(Statechart statechart) {
		if (tree === null || activeStatechart != statechart) {
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

	def protected void createNameTree(Statechart statechart) {
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

	override initializeNamingService(ExecutionFlow flow) {
		if (tree === null || activeFlow != flow) {
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

	def protected void createNameTree(ExecutionFlow flow) {
		// Initialize tree
		tree = new StringTreeNode();

		for (region : flow.regions) {
			addElement(region, new ArrayList<String>(), new ArrayList<String>());
			for (node : region.nodes) {
				addElement(node, new ArrayList<String>(), new ArrayList<String>());
			}
		}

		for (state : flow.states) {
			addElement(state, state.prefix, state.suffix);
		}
		for (func : flow.allFunctions) {
			addElement(func, func.prefix, func.suffix);
		}

		// Create short name for time events of statechart
		if (flow.sourceElement instanceof Statechart) {
			val statechart = flow.sourceElement as Statechart
			addShortTimeEventName(flow, statechart)
		}

		// Create short name for time events of states
		for (executionState : flow.states) {
			if (executionState.sourceElement instanceof State) {
				val state = executionState.sourceElement as State
				addShortTimeEventName(executionState, state)
			}
		}
	}

	def public test_printTreeContents() {
		for (s : tree.getContents()) {
			System.out.println(s);
		}

		System.out.println();
	}

	def protected addShortTimeEventName(NamedElement executionFlowElement, NamedElement sgraphElement) {
		var timeEventSpecs = sgraphElement.timeEventSpecs;
		for (tes : timeEventSpecs) {
			val timeEvent = executionFlowElement.flow.getTimeEvent(sgraphElement.fullyQualifiedName + "_time_event_" +
				timeEventSpecs.indexOf(tes))
			if (timeEvent !== null) {
				addElement(executionFlowElement, prefix(tes, sgraphElement), suffix(tes, sgraphElement));
			}
		}
	}

	def protected void addElement(NamedElement elem, List<String> prefix, List<String> suffix) {
		val name = new ArrayList<String>(elem.elementNameSegments());
		val segments = new ArrayList<String>();
		segments.addAll(prefix);
		segments.addAll(name);
		segments.addAll(suffix);
		if (!segments.isEmpty()) {
			val addedNode = tree.addStringList(segments);

			treeMap.put(elem, addedNode); // remember for later access
			shortNamesValid = false;
		}
	// System.out.println(name);
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
		// check if element was named before
		if (map.containsKey(element)) {
			return map.get(element);
		}
		// if not, check if element is located in the tree
		if (!treeMap.containsKey(element)) {
			addElement(element, new ArrayList<String>(), new ArrayList<String>());
		}
		// check if names are shortened already
		if (!shortNamesValid) {
			shortenNames();
		}

		val name = getShortenedName(element);

		map.put(element, name);
		return name;
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
		val nodes = tree.getEndNodes().sortWith(stringTreeNodeDepthComparator);
		var doublets = new HashMap<String, ArrayList<ArrayList<StringTreeNode>>>();
		val mapping = new HashMap<StringTreeNode, ArrayList<StringTreeNode>>();

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

	def protected shortenNames() {
		if (individualMap === null || individualMap.isEmpty()) {
			constructIndividualNames();
		}
		if (this.maxLength == 0) {
			return;
		}
		
		val max_weight = tree.getWeight();

		while (shortenOneCharacter(tree.getEndNodes(), max_weight)) {
		}

		shortNamesValid = true;
	}

	def protected boolean shortenOneCharacter(ArrayList<StringTreeNode> endnodes, int max_weight) {
		/*
		 * takes all end-nodes of the tree, finds their attached individual chain of nodes, their shortstring and shortens the
		 * longest chain's cheapest shortstring.
		 */
		var max_length = 0;
		var StringTreeNode max_length_node;

		var names = new ArrayList<String>();

		for (node : endnodes) {
			// iterates over all endnodes and returns the maximum length of all names.
			var newname = node.getIndividualName.joinShortStrings();
			names.add(newname);
			var length = newname.length();
			if (length > max_length) {
				max_length = length;
				max_length_node = node;
			}
		}

		if (max_length < this.maxLength) {
			return false;
		}

		var min_cost = Integer.MAX_VALUE;
		var ShortString best_cut;

		for (node : max_length_node.getIndividualName) // all nodes describing the individual name of this end node
		{
			val shortstr = node.shortStringForNode;
			val current_cost = shortstr.getCutCost();

			var noDoubles = false;

			val node_cost_factor = max_weight - node.getWeight() + 1;

			shortstr.removeCheapestChar();

			val cut_cost = (shortstr.getCutCost() - current_cost) * node_cost_factor;

			val current_name = max_length_node.getIndividualName.joinShortStrings;

			if (!names.contains(current_name)) {
				noDoubles = true;
				// do further check to avoid double names only when quick check is okay
				var doubleCheckArray = new ArrayList<String>();
				for (n : endnodes) {
					var newname = n.getIndividualName.joinShortStrings();
					if (doubleCheckArray.contains(newname)) {
						noDoubles = false;
					}
					doubleCheckArray.add(newname);
				}
			}

			if (noDoubles && cut_cost > 0 && cut_cost < min_cost) {
				min_cost = cut_cost;
				best_cut = shortstr;
			}

			shortstr.rollback(); // revert changes
		}

		if (best_cut === null) {
			return false;
		}
		best_cut.removeCheapestChar(); // reapply best change
		return true;
	}

	def protected Map<StringTreeNode, ShortString> createShortStringMapping() {
		val HashMap<StringTreeNode, ShortString> mapping = newHashMap;
		for (node : tree.getNodes()) {
			mapping.put(
				node,
				new ShortString(node.getData())
			);
		}

		return mapping;
	}

	def protected StringTreeNode getNodeForElement(NamedElement elem) {
		return treeMap.get(elem);
	}

	def protected ShortString getShortStringForNode(StringTreeNode node) {
		if (node_shortString_map === null || node_shortString_map.isEmpty()) {
			createShortStringMapping();
		}
		return node_shortString_map.get(node);
	}

	def protected ArrayList<StringTreeNode> getIndividualName(StringTreeNode node) {
		if (individualMap.isEmpty()) {
			constructIndividualNames();
		}
		return individualMap.get(node);
	}

	def protected getShortenedName(StringTreeNode node) {
		return joinShortStrings(getIndividualName(node));
	}

	def protected getShortenedName(NamedElement elem) {
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

	def public getTreeContents() {
		return tree.getContents();
	}

	def protected List<NamedElement> getNodeElements(StringTreeNode node) {
		val ArrayList<NamedElement> list = new ArrayList<NamedElement>();

		for (elem : treeMap.keySet()) {
			if (treeMap.get(elem) == node) {
				list.add(elem);
			}
		}

		return list;
	}

	def protected String joinShortStrings(ArrayList<?> list) {
		val sb = new StringBuilder();
		var first = true;

		for (s : list) {
			var String shortened;
			if (s instanceof ShortString) {
				shortened = s.getShortenedString();
			} else if (s instanceof StringTreeNode) {
				shortened = s.getShortStringForNode.getShortenedString();
			}
			if (shortened.length > 0) {
				if (first) {
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
			case isCheckFunction: {
				l.add("check");
			}
			case isEntryAction: {
				l.add("enact");
			}
			case isExitAction: {
				l.add("exact");
			}
			case isEffect: {
				l.add("effect");
			}
			case isEnterSequence: {
				l.add("enseq");
			}
			case isDeepEnterSequence: {
				l.add("dhenseq");
			}
			case isShallowEnterSequence: {
				l.add("shenseq");
			}
			case isExitSequence: {
				l.add("exseq");
			}
			case isReactSequence: {
				l.add("react");
			}
			default: {
			}
		}

		return l;
	}

	def protected prefix(Step it) {
		return new ArrayList<String>();
	}

	def protected prefix(ExecutionState it) {
		var l = new ArrayList<String>();
		// l.add(flow.name);
		return l;
	}

	def protected suffix(ExecutionState it) {
		return new ArrayList<String>();
	}

	def protected prefix(TimeEventSpec it, NamedElement element) {
		var l = new ArrayList<String>();
		// l.add(activeFlow.name);
		return l;
	}

	def protected suffix(TimeEventSpec it, NamedElement element) {
		var l = new ArrayList<String>();
		switch (element) {
			Statechart: {
				l.add("tev" + element.timeEventSpecs.indexOf(it));
			}
			State: {
				l.add("tev" + element.timeEventSpecs.indexOf(it));
			}
		}
		return l;
	}

	def protected prefix(State it) {
		var l = new ArrayList<String>();
		// l.add(activeStatechart.name);
		return l;
	}

	def protected prefix(Vertex it) {
		return new ArrayList<String>();
	}

	def protected suffix(Vertex it) {
		return new ArrayList<String>();
	}
}
