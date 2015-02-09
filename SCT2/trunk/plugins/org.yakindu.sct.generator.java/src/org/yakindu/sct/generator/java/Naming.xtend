package org.yakindu.sct.generator.java

import com.google.inject.Inject
import java.util.Arrays
import java.util.regex.Matcher
import java.util.regex.Pattern
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgraph.Event
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Variable
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

class Naming implements JavaKeywords {
	
	@Inject extension Navigation

	@Inject extension INamingService namingService;	
	@Inject StextNameProvider provider;
	
	def iStatemachine() {
		"IStatemachine"
	}
	
	def iTimerCallback() {
		"ITimerCallback"
	}
	
	def iTimer() {
		"ITimer"
	}
	
	def timerServiceClass() {
		"TimerService"
	}
	
	def timeEventClass() {
		"TimeEvent"
	}
	
	def runtimeServiceClass() {
		"RuntimeService"
	}
	
	def java(String it) {
		it + ".java"
	}
	
	def asPrivate(String it) {
		"private " + it
	}
	
	def asPublic(String it) {
		"public " + it
	}
	
	def String getInternalOperationCallbackName(InternalScope it) {
		"InternalOperationCallback"
	}
	
	def boolean isJavaKeyword(String name) {
		var String lowName = name.toLowerCase();
		for (String keyword : Arrays::asList(KEYWORDS)) {
			var Pattern pattern = Pattern::compile("^" + keyword + "$");
			var Matcher matcher = pattern.matcher(lowName);
			if (matcher.find()) {
				return true;
			}
		}
		return false;
	}
	
	def dispatch String statemachineName(String name) {
		// remove whitespaces;
		var String newName = name.replace(" ", "")
		if (isJavaKeyword(name)) {
			return newName + "SM"
		}
		return newName
	}
	
	def dispatch String statemachineName(ExecutionFlow it) {
		return name.statemachineName.toFirstUpper()
	}
	
	def statemachineClassName(ExecutionFlow it) {
		statemachineName + "Statemachine"
	}
	
	def statemachineInterfaceName(ExecutionFlow it) {
		"I" + statemachineClassName
	}
	
	def String getInterfaceName(InterfaceScope it) {  
		if (name != null) {
			return "SCI" + name.toFirstUpper()
		}
		else {
			return "SCInterface";
		}
	}
	
	def dispatch getSymbol(VariableDefinition it){
		name.asEscapedIdentifier
	}
	def dispatch getSymbol(EventDefinition it){
		name.asEscapedIdentifier
	}
	
	def String getInterfaceImplName(InterfaceScope it) {
		getInterfaceName() + "Impl";
	}
	
	def String getInterfaceListenerName(InterfaceScope it) {
		interfaceName + "Listener";
	}
	
	def String getInterfaceOperationCallbackName(InterfaceScope it) {
		interfaceName + "OperationCallback"
	}
	
	def private String fullQualifiedStateName(String name) {
		name.substring(name.indexOf(".") + 1).replace(".", "_")
	}
	
	def dispatch String stateName(State state) {
		val String name = provider.getFullyQualifiedName(state).toString();
		name.fullQualifiedStateName
	}
	
	def dispatch String stateName(ExecutionState it) {
		name.fullQualifiedStateName
	}
	
	def asIdentifier(String it) {
		replaceAll('[^a-z&&[^A-Z&&[^0-9]]]', '_').toFirstLower
	}
	
	def asName(String it) {
		asIdentifier.toFirstUpper
	}
	
	def asEscapedIdentifier(String it) {
		var s = it
		if (s.isJavaKeyword) {
			s = s + '_ID'
		}
		return s.asIdentifier
	}
	
	def asEscapedName(String it) {
		asEscapedIdentifier.toFirstUpper
	}
	
	def String getValueIdentifier(Event it){
		name.asIdentifier+"Value"
	}
	
	def private varName(Variable it) {
		if (name.equalsIgnoreCase("class")) {
			name.asEscapedName
		}
		else {
			name.asName
		}
	}
	
	def String getter(Variable it) {
		return "get" + varName + "()"
	}
	
	def String setter(Variable it) {
		"set" + varName
	}
	
	def String getNullStateName() {
		"$NullState$";
	}
	
	def functionName(Step it) { shortName }
	
	
}