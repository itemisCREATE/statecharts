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
import java.util.ArrayList

/** Default implementation of the naming service for various identifiers used in the generated code. 
 * It is responsible for identifier construction depending on the thing to be named including different strategies 
 * which also include name shortening.
 */
class TreeNamingService implements INamingService {

	@Inject extension SExecExtensions
	@Inject extension SgraphExtensions
	@Inject extension StatechartExtensions
	@Inject extension IQualifiedNameProvider
	@Inject extension StepDepthComparator stepDepthComparator
	@Inject extension ExecutionScopeDepthComparator executionScopeDepthComparator
	@Inject extension NamingHelper

	@Inject private StextNameProvider provider

	// from public class org.yakindu.sct.generator.c.features.CDefaultFeatureValueProvider extends		
	private static final String VALID_IDENTIFIER_REGEX = "[_a-zA-Z][_a-zA-Z0-9]*";

	var protected int maxLength = 0;

	var protected char separator = '_';

	var protected Map<NamedElement, String> map;
	
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
	
	override initializeNamingService(Statechart statechart) {
		if(tree == null || activeStatechart != statechart)
		{
			activeFlow = null;
			activeStatechart = statechart;
			createNameTree(statechart);
		}
	}
	
	def private void createNameTree(Statechart statechart)
	{
		
	}
	
	override initializeNamingService(ExecutionFlow flow) {
		if(tree == null || activeFlow != flow)
		{
			activeFlow = flow;
			activeStatechart = null;
			createNameTree(flow);
		}
	}
	
	def private void createNameTree(ExecutionFlow flow)
	{
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
		val name = elem.elementName(NameShorteningStrategy::FQN_NAME);
		val segments = new ArrayList<String>(name.getSegments());
		if(name != null)
		{
			tree.addStringList(segments);
			//System.out.println(name);
		}
		
	}
	
	/*
	 * elementName
	 */
	 
	 def protected dispatch QualifiedName elementName(ExecutionFlow it, NameShorteningStrategy nameShorteningType) {
		return null;
	}
	
	def protected dispatch QualifiedName elementName(ExecutionScope it, NameShorteningStrategy nameShorteningType) {
		return sourceElement.elementName(nameShorteningType)
	}

	def protected dispatch QualifiedName elementName(ExecutionState it, NameShorteningStrategy nameShorteningType) {
		return sourceElement.elementName(nameShorteningType)
	}
	
	def protected dispatch QualifiedName elementName(EObject it, NameShorteningStrategy nameShorteningType) {
		eContainer?.elementName(nameShorteningType)
	}

	def protected dispatch QualifiedName elementName(ExecutionNode it, NameShorteningStrategy nameShorteningType) {
		return provider.getFullyQualifiedName(it).skipFirst(2)
	}

	// TODO: we should merge the region/vertex case into this base implementation; we should check whether it is used in any case at all (otherwise it could be replaced with the body of vertexOrRegionName)
	def protected dispatch QualifiedName elementName(NamedElement it, NameShorteningStrategy nameShorteningType) {
		return provider.getFullyQualifiedName(it).skipFirst(2)
	}
	
	def protected dispatch QualifiedName elementName(Reaction it, NameShorteningStrategy nameShorteningType) {
		return provider.getFullyQualifiedName(it).skipFirst(2)
	}

	def protected dispatch QualifiedName elementName(Region it, NameShorteningStrategy nameShorteningType) {
		return provider.getFullyQualifiedName(it).skipFirst(1)
	}
	
	def protected dispatch QualifiedName elementName(Step it, NameShorteningStrategy nameShorteningType) {
		var parentName = eContainer.elementName(nameShorteningType)
		// parent name may be null
		/*
		if (( isEnterSequence || isCheckFunction || isEffect ) && (name != null) && (!name.trim.empty))
			parentName + separator + name
		else
			parentName
	*/
		parentName
	}

	def protected dispatch QualifiedName elementName(Vertex it, NameShorteningStrategy nameShorteningType) {
		return provider.getFullyQualifiedName(it).skipFirst(1)
	}
	
	/*
	 * end elementName
	 */
	
	def private vertexOrRegionName(NamedElement it, NameShorteningStrategy nameShorteningType) {
		switch nameShorteningType {
			case NameShorteningStrategy::FQN_NAME:
				return provider.getFullyQualifiedName(it).skipFirst(1).toString(separator.toString)
			case NameShorteningStrategy::SHORT_NAME: {
				if (name.nullOrEmpty) {
					return provider.getFullyQualifiedName(it).lastSegment.toString.substring(1)
				}
				return name
			}
			case NameShorteningStrategy::REMOVE_VOWELS:
				return it.elementName(NameShorteningStrategy::SHORT_NAME)
			case NameShorteningStrategy::INDEX_POSITION:
				return asSGraphIndexPosition
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
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override asEscapedIdentifier(String string) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override asIdentifier(String string) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override isKeyword(String string) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getShortNameMap(Statechart statechart) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getShortNameMap(ExecutionFlow flow) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	

	
}
