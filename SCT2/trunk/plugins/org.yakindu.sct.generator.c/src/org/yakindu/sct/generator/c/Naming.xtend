package org.yakindu.sct.generator.c

import com.google.inject.Inject
import java.util.Arrays
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.sgraph.Event
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.sct.model.sgraph.State
import java.util.regex.Pattern
import java.util.regex.Matcher

class Naming implements INaming{

	@Inject
	extension Navigation
	
	@Inject
	extension Base
	
	@Inject
	private StextNameProvider provider
	
	def getFullyQualifiedName(State state) {
		provider.getFullyQualifiedName(state).toString.asEscapedIdentifier
	}
	
	def module(ExecutionFlow it) {
		name.asIdentifier.toFirstUpper	
	}
	
	def client(String it) {
		it + "Required"	
	}
	
	def timerModule(ExecutionFlow it) {
		'sc_timer'	
	}
	
	def typesModule(ExecutionFlow it) {
		'sc_types'	
	}
	
	def dispatch type(ExecutionFlow it) {
		name.asIdentifier.toFirstUpper	
	}
	
	def timerType(ExecutionFlow it) {
		'SCTimer'
	}
	
	def statesEnumType(ExecutionFlow it) {
		module + 'States'	
	}
	
	def module(InterfaceScope it) {
		flow.module + (if (name == null || name.empty) 'Default' else name).asIdentifier.toFirstUpper	
	}
	
	def dispatch type(InterfaceScope it) {
		flow.module + 'Iface' + (if (name == null || name.empty) '' else name).asIdentifier.toFirstUpper	
	}
	
	def dispatch instance(InterfaceScope it) {
		'iface' + (if (name == null || name.empty) '' else name).asIdentifier.toFirstUpper	
	}
	
	def dispatch instance(Scope it) {
		'timeEvents'
	}
	
	def dispatch type(InternalScope it) {
		flow.module + 'Internal'	
	}
	
	def dispatch type(Scope it) {
		flow.module + 'TimeEvents'	
	}
	
	def dispatch instance(InternalScope it) {
		'internal'
	}
	
	def functionPrefix(Scope it) {
		type.toFirstLower	
	}
	
	def dispatch last_state(ExecutionFlow it) {
		module + "_last_state"
	}
	
	def dispatch last_state(Step it) {
		execution_flow.module + "_last_state"
	}
	
	def ExecutionFlow execution_flow(EObject element) {
		var ret = element;
		
		while (ret != null) {
			if (ret instanceof ExecutionFlow) {
				return ret as ExecutionFlow
			}
			else {
				ret = ret.eContainer;
			}	
		}
		return null;
	}
	
	def functionPrefix(ExecutionFlow it) {
		type.toFirstLower	
	}

	def nameOfRaiseTimeEventFunction(ExecutionFlow it) {
		type.toFirstLower + "_raiseTimeEvent"
	}

	def nameOfIsActiveFunction(ExecutionFlow it) {
		type.toFirstLower + "_isActive"
	}

	def asRaiser(EventDefinition it) {
		scope.functionPrefix + '_raise_' + name.asIdentifier.toFirstLower	
	}
	
	def asRaised(EventDefinition it) {
		scope.functionPrefix + '_israised_' + name.asIdentifier.toFirstLower	
	}
	
	def asGetter(EventDefinition it) {
		scope.functionPrefix + '_get_' + name.asIdentifier.toFirstLower	+ '_value'
	}
	
	def asGetter(VariableDefinition it) {
		scope.functionPrefix + '_get_' + name.asIdentifier.toFirstLower	
	}
	
	def asSetter(VariableDefinition it) {
		scope.functionPrefix + '_set_' + name.asIdentifier.toFirstLower	
	}

	def asFunction(OperationDefinition it) {
		scope.functionPrefix + '_' + name.asIdentifier.toFirstLower	
	}
		
	
	def functionName(Step it) {
		switch (it) {
			case isCheckFunction : asCheckFunction
			case isEntryAction: asEntryActionFunction
			case isExitAction : asExitActionFunction
			case isEffect : asEffectFunction
			case isEnterSequence : asEnterSequenceFunction
			case isDeepEnterSequence : asDeepEnterSequenceFunction
			case isShallowEnterSequence : asShallowEnterSequenceFunction
			case isExitSequence : asExitSequenceFunction
			case isReactSequence : asReactFunction
			default : ""
		} 
	}
	
	
	def asCheckFunction(Step it) { functionName(newArrayList('check', elementName, reaction.name)) }
	 
	def asEffectFunction(Step it) { functionName(newArrayList('effect', elementName, reaction.name)) }
	 
	def asEntryActionFunction(Step it) { functionName('entryaction') }
	
	def asExitActionFunction(Step it) { functionName('exitaction') }
	 
	def asEnterSequenceFunction(Step it) { functionName('entersequence') }
		 
	def asDeepEnterSequenceFunction(Step it) { functionName('deepentersequence') }
	 
	def asShallowEnterSequenceFunction(Step it) { functionName('shallowentersequence') }
	 
	def asExitSequenceFunction(Step it) { functionName('exitsequence') }
	 
	def asReactFunction(Step it) { functionName('react') }
	
	
	def functionName(Step it, String fName) { functionName(newArrayList(fName, elementName)) }
	
	def functionName(EObject it, List<String> segments) {
		flow.functionPrefix + segments.fold("", [s, seg | s + if (seg.empty) "" else "_" + seg]).asIdentifier
	}

	def dispatch String elementName(EObject it) { eContainer.elementName }
	
	def dispatch String elementName(ExecutionScope it) { (if (superScope != null && ! superScope.elementName.empty) superScope.elementName + "_" else "") + name }	
	
	def dispatch String elementName(ExecutionState it) { (if (superScope != null && ! superScope.elementName.empty) superScope.elementName + "_" else "") + simpleName }	
	
	def dispatch String elementName(ExecutionNode it) { name }	
	
	def dispatch String elementName(ExecutionFlow it) { "" }
	
	def raised(CharSequence it) { it + '_raised' }	
	def value(CharSequence it)  { it + '_value' }	
	
	
	
	def h(String it) { it + ".h" }
	def c(String it) { it + ".c" }
	
	def define(String it) { it.replaceAll('\\.', '_').toUpperCase }
	
	
	def asIdentifier(String it) {
		replaceAll('[^a-z&&[^A-Z&&[^0-9]]]', '_')
	}
	
	def asEscapedIdentifier(String it) {
		var s = it
		if (s.isCKeyword) {
			s = s + '_ID'
		}
		return s.asIdentifier
	} 
	
	def dispatch scopeDescription(Scope it) '''scope'''
	
	def dispatch scopeDescription(InterfaceScope it) '''«IF name==null || name.empty»default interface scope«ELSE»interface scope '«name»'«ENDIF»'''
	def dispatch scopeDescription(InternalScope it) '''internal scope'''
	
	def scHandleDecl(EObject it) { flow.type + '* ' + scHandle }
	
	def scHandle() { 'handle' }
	
	def valueParams(EventDefinition it) {
		if (hasValue) ', ' + type.cPrimitive + ' value' 
		else ''
	}
	
	/** todo externalize */
	def dispatch access (VariableDefinition it) 
		'''«scHandle»->«scope.instance».«name.asEscapedIdentifier»'''

	/** todo externalize */
	def dispatch access (OperationDefinition it) 
		'''«asFunction»'''
		
	/** todo externalize */
	def dispatch access (Event it) 
		'''«scHandle»->«scope.instance».«name.asIdentifier.raised»'''
				
	def dispatch access (EObject it) 
		'''#error cannot access elements of type «getClass().name» '''
		
	
	def valueAccess(Event it) 
		'''«scHandle»->«scope.instance».«name.asIdentifier.value»'''
		
	def boolean isCKeyword(String name) {
		var String lowName = name.toLowerCase();
		for (String keyword : Arrays::asList(C_KEYWORDS)) {
			var Pattern pattern = Pattern::compile("^" + keyword + "$");
			var Matcher matcher = pattern.matcher(lowName);
			if (matcher.find()) {
				return true;
			}
		}
		return false;
	}
}