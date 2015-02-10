/**
  Copyright (c) 2014-2015 committers of YAKINDU Statechart Tools.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  
  Contributors:
  	Markus Mühlbrandt - Initial contribution and API
  	Axel Terfloth - Extensions
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

class StepDepthComparator implements Comparator<Step> {
	@Inject
	extension SExecExtensions

	override compare(Step arg0, Step arg1) {
		return arg0.scopeDepth - arg1.scopeDepth
	}
}

class ExecutionScopeDepthComparator implements Comparator<ExecutionScope> {
	@Inject
	extension SExecExtensions

	override compare(ExecutionScope o1, ExecutionScope o2) {
		return o1.scopeDepth - o2.scopeDepth
	}
}

enum NameShorteningStrategy {
	FQN_NAME,
	SHORT_NAME,
	REMOVE_VOWELS,
	INDEX_POSITION
}


/** Default implementation of the naming service for various identifiers used in the generated code. 
 * It is responsible for identifier construction depending on the thing to be named including different strategies 
 * which also include name shortening.
 */
class DefaultNamingService implements INamingService {

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

	var protected int maxLength = 0

	var protected char separator = '_'

	var protected Map<NamedElement, String> map

	var protected ExecutionFlow activeFlow

	var protected Statechart activeStatechart

	new(int maxLength, char separator) {
		this.maxLength = maxLength
		this.separator = separator
	}

	new() {
		this.maxLength = 0
		this.separator = '_'
	}

	override void initializeNamingService(Statechart statechart) {
		if (map == null || activeStatechart != statechart) {
			activeFlow = null
			activeStatechart = statechart
			map = statechart.createShortNameMap(maxLength, separator)
		}
	}

	override void initializeNamingService(ExecutionFlow flow) {
		if (map == null || activeFlow != flow) {
			activeFlow = flow
			activeStatechart = null
			map = flow.createShortNameMap(maxLength, separator)
		}
	}

	override getShortNameMap(Statechart statechart) {
		if (map == null || activeStatechart != statechart) {
			statechart.initializeNamingService()
		}
		return map
	}

	override Map<NamedElement, String> getShortNameMap(ExecutionFlow flow) {
		if (map == null || activeFlow != flow) {
			flow.initializeNamingService()
		}
		return map
	}

	override getShortName(NamedElement element) {
		if (map == null || !map.containsKey(element)) {
			var statechart = element.statechart
			if (statechart != null) {
				statechart.initializeNamingService
			} else {
				element.flow?.initializeNamingService
			}
		}
		map?.get(element)
	}

	def Map<NamedElement, String> createShortNameMap(Statechart statechart, int maxLength, char separator) {
		var HashMap<NamedElement, String> map = new HashMap<NamedElement, String>
		map.addShortVertexNames(statechart, maxLength, separator)
		return map;
	}

	def protected void addShortVertexNames(Map<NamedElement, String> map, CompositeElement element, int maxLength,
		char separator) {
		for (region : element.regions) {
			for (vertex : region.vertices) {
				switch vertex {
					State:
						map.putShortName(vertex, vertex.prefix(separator), vertex.suffix(separator), maxLength,
							separator)
					default:
						map.putShortName(vertex, vertex.prefix(separator), vertex.suffix(separator), maxLength,
							separator)
				}
			}
		}
		for (region : element.regions) {
			for (vertex : region.vertices) {
				if (vertex instanceof CompositeElement) {
					map.addShortVertexNames(vertex as CompositeElement, maxLength, separator)
				}
			}
		}
	}

	def Map<NamedElement, String> createShortNameMap(ExecutionFlow flow, int maxLength, char separator) {
		var HashMap<NamedElement, String> map = new HashMap<NamedElement, String>
		map.addShortStateNames(flow, maxLength, separator)
		map.addShortFctNames(flow, maxLength, separator)
		map.addShortTimeEventNames(flow, maxLength, separator)
		return map;
	}

	def protected void addShortStateNames(Map<NamedElement, String> map, ExecutionFlow flow, int maxLength,
		char separator) {
		for (s : flow.states.sortWith(executionScopeDepthComparator)) {
			map.putShortName(s, s.prefix(separator), s.suffix(separator), maxLength, separator)
		}
	}

	def protected void addShortFctNames(Map<NamedElement, String> map, ExecutionFlow flow, int maxLength, char separator) {
		for (s : flow.allFunctions.sortWith(stepDepthComparator)) {
			map.putShortName(s, s.prefix(separator), s.suffix(separator), maxLength, separator)
		}
	}

	def protected void addShortTimeEventNames(Map<NamedElement, String> map, ExecutionFlow flow, int maxLength,
		char separator) {
		for (executionState : flow.states.sortWith(executionScopeDepthComparator)) {
			if (executionState.sourceElement instanceof State) {
				var state = executionState.sourceElement as State
				var timeEventSpecs = state.timeEventSpecs
				for (tes : timeEventSpecs) {
					var timeEvent = flow.getTimeEvent(
						state.fullyQualifiedName + "_time_event_" + timeEventSpecs.indexOf(tes))
					if (timeEvent != null) {
						map.put(timeEvent,
							executionState.getShortName(tes.prefix(state, separator), tes.suffix(state, separator),
								map.values.toList, maxLength, separator))
					}
				}
			}
		}
	}

	def protected void putShortName(Map<NamedElement, String> map, NamedElement element, String prefix, String suffix,
		int maxLength, char separator) {
		if (!map.containsKey(element)) {
			map.put(element, element.getShortName(prefix, suffix, map.values.toList, maxLength, separator))
		}
	}

	def protected prefix(Step it, char separator) {
		var prefix = flow.name.toFirstLower
		switch (it) {
			case isCheckFunction: prefix + separator + "check"
			case isEntryAction: prefix + separator + "enact"
			case isExitAction: prefix + separator + "exact"
			case isEffect: prefix + separator + "effect"
			case isEnterSequence: prefix + separator + "enseq"
			case isDeepEnterSequence: prefix + separator + "dhenseq"
			case isShallowEnterSequence: prefix + separator + "shenseq"
			case isExitSequence: prefix + separator + "exseq"
			case isReactSequence: prefix + separator + "react"
			default: ""
		}
	}

	def protected suffix(Step it, char separator) {
		""
	}

	def protected prefix(ExecutionState it, char separator) {
		flow.name
	}

	def protected suffix(ExecutionState it, char separator) {
		""
	}

	def protected prefix(TimeEventSpec it, State state, char separator) {
		activeFlow.name
	}

	def protected suffix(TimeEventSpec it, State state, char separator) {
		"tev" + state.timeEventSpecs.indexOf(it)
	}

	def protected prefix(State it, char separator) {
		activeStatechart.name
	}

	def protected prefix(Vertex it, char separator) {
		""
	}

	def protected suffix(Vertex it, char separator) {
		""
	}

	override asIdentifier(String string) {
		string.replaceAll('[^a-z&&[^A-Z&&[^0-9]]]', separator.toString)
	}

	override asEscapedIdentifier(String string) {
		string.asIdentifier
	}

	override isKeyword(String string) {
		return false
	}

	def protected String getShortName(NamedElement element, String prefix, String suffix, List<String> nameList,
		int maxLength, char separator) {
		var shortName = ""

		if (maxLength > 0) {

			//first reduction use short name
			shortName = element.createShortName(prefix, suffix, nameList, NameShorteningStrategy::SHORT_NAME,
				separator)

			//second reduction removing vowels
			if (shortName.length > maxLength) {
				shortName = element.createShortName(prefix, suffix, nameList, NameShorteningStrategy::REMOVE_VOWELS,
					separator);
			}

			//third reduction using index position as name
			if (shortName.length > maxLength) {
				shortName = element.createShortName(prefix, suffix, nameList, NameShorteningStrategy::INDEX_POSITION,
					separator);
			}

			//fourth reduction using hash value
			if (shortName.length > maxLength) {

				//Important: FQN has to be the same if the input model is a Statechart or an ExecutionFlow
				shortName = element.fqElementName(separator).asIdentifier.getHash(maxLength)
			}
		} else {

			//use full qualified name
			shortName = element.createShortName(prefix, suffix, nameList, NameShorteningStrategy::FQN_NAME, separator)
		}
		return shortName
	}

	def protected String createShortName(NamedElement element, String prefix, String suffix, List<String> nameList,
		NameShorteningStrategy nameShorteningType, char separator) {

		var name = element.elementName(nameShorteningType)

		if (name.nullOrEmpty && prefix.nullOrEmpty && suffix.nullOrEmpty) {
			name = element.class.simpleName
		}

		if (!suffix.nullOrEmpty) {
			if (!name.nullOrEmpty) {
				name = name + separator + suffix

			} else {
				name = suffix
			}
		}

		if (! prefix.nullOrEmpty) {
			if ( ! name.nullOrEmpty ) {
				name = prefix + separator + name
			} else {
				name = prefix
			}
			
		}
				
		var shortName = name.asEscapedIdentifier
		
		if (nameList.containsName(shortName)) {
			switch element {
				ExecutionScope:
					shortName = element.superScope.createShortName(prefix, name, nameList, nameShorteningType, separator)
				Step: {
					if (element.scopeDepth > 0) {
						shortName = element.parentExecutionScope.superScope.createShortName(prefix, name, nameList,
							nameShorteningType, separator)
					} else {
						shortName = element.parentExecutionScope.createShortName(prefix, name, nameList,
							nameShorteningType, separator)
					}
				}
				default: {
					if (element.eContainer instanceof NamedElement) {
						shortName = (element.eContainer as NamedElement).createShortName(prefix, name, nameList,
							nameShorteningType, separator)
					}
				}
			}
		}
		return shortName;
	}

	def protected dispatch String elementName(NamedElement it, NameShorteningStrategy nameShorteningType) {
		switch nameShorteningType {
			case NameShorteningStrategy::FQN_NAME: return provider.getFullyQualifiedName(it).skipFirst(2).
				toString(separator.toString)
			case NameShorteningStrategy::SHORT_NAME: return name
			case NameShorteningStrategy::REMOVE_VOWELS: return name?.removeVowels
			case NameShorteningStrategy::INDEX_POSITION: return name?.removeVowels
		}
	}

	def protected dispatch String elementName(ExecutionScope it, NameShorteningStrategy nameShorteningType) {
		switch nameShorteningType {
			case NameShorteningStrategy::FQN_NAME: return provider.getFullyQualifiedName(it).skipFirst(2).
				toString(separator.toString)
			case NameShorteningStrategy::SHORT_NAME: return name
			case NameShorteningStrategy::REMOVE_VOWELS: return name?.removeVowels
			case NameShorteningStrategy::INDEX_POSITION: return asIndexPosition
		}
	}

	def protected dispatch String elementName(ExecutionState it, NameShorteningStrategy nameShorteningType) {
		switch nameShorteningType {
			case NameShorteningStrategy::FQN_NAME: 
				return provider.getFullyQualifiedName(it).skipFirst(2).toString(separator.toString)
			case NameShorteningStrategy::SHORT_NAME: return simpleName
			case NameShorteningStrategy::REMOVE_VOWELS: return simpleName.removeVowels
			case NameShorteningStrategy::INDEX_POSITION: return asIndexPosition
		}
	}

	def protected dispatch String elementName(ExecutionNode it, NameShorteningStrategy nameShorteningType) {
		switch nameShorteningType {
			case NameShorteningStrategy::FQN_NAME: return provider.getFullyQualifiedName(it).skipFirst(2).
				toString(separator.toString)
			case NameShorteningStrategy::SHORT_NAME: return simpleName
			case NameShorteningStrategy::REMOVE_VOWELS: return simpleName
			case NameShorteningStrategy::INDEX_POSITION: return simpleName
		}
	}

	def protected dispatch String elementName(Region it, NameShorteningStrategy nameShorteningType) {
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
				return name?.removeVowels
			case NameShorteningStrategy::INDEX_POSITION:
				return asSGraphIndexPosition
		}
	}

	def protected dispatch String elementName(Vertex it, NameShorteningStrategy nameShorteningType) {
		switch nameShorteningType {
			case NameShorteningStrategy::FQN_NAME: return provider.getFullyQualifiedName(it).skipFirst(1).
				toString(separator.toString)
			case NameShorteningStrategy::SHORT_NAME: return name
			case NameShorteningStrategy::REMOVE_VOWELS: return name?.removeVowels
			case NameShorteningStrategy::INDEX_POSITION: return asSGraphIndexPosition
		}
	}

	def protected dispatch String elementName(ExecutionFlow it, NameShorteningStrategy nameShorteningType) {
		""
	}

	def protected dispatch String elementName(Step it, NameShorteningStrategy nameShorteningType) {
		var parentName = eContainer.elementName(nameShorteningType)
		if( isEnterSequence && (name != null) && (!name.trim.empty) ) parentName + separator + name
		else parentName
	}

	def protected dispatch String elementName(EObject it, NameShorteningStrategy nameShorteningType) {
		eContainer?.elementName(nameShorteningType)
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
		var String sepString =  sep+""		
		if(!(sepString.matches(VALID_IDENTIFIER_REGEX))){
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

}
