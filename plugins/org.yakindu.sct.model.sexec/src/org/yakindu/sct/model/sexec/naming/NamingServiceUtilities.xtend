package org.yakindu.sct.model.sexec.naming

import com.google.inject.Inject
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.stext.stext.TimeEventSpec

class NamingServiceUtilities {
	@Inject extension SExecExtensions
	@Inject extension SgraphExtensions
	@Inject extension StatechartExtensions

	var protected int maxLength = 0

	var protected char separator = '_'

	var protected Statechart activeStatechart

	var protected ExecutionFlow activeFlow

	def initialize(int maxLength, char separator, Statechart statechart, ExecutionFlow flow) {
		this.maxLength = maxLength
		this.separator = separator
		this.activeStatechart = statechart
		this.activeFlow = flow

	}

	def asIdentifier(String string) {
		string.replaceAll('[^a-z&&[^A-Z&&[^0-9]]]', separator.toString)
	}

	def asEscapedIdentifier(String string) {
		string.asIdentifier
	}

	def isKeyword(String string) {
		return false
	}

	def public setSeparator(char sep) {
		separator = sep
	}

	def public setMaxLength(int maxLength) {
		this.maxLength = maxLength
	}

	def public prefix(Step it, char separator) {
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

	def public suffix(Step it, char separator) {
		""
	}

	def public prefix(ExecutionState it, char separator) {
		flow.name
	}

	def public suffix(ExecutionState it, char separator) {
		""
	}

	def public prefix(TimeEventSpec it, NamedElement element) {
		activeFlow.name
	}

	def public suffix(TimeEventSpec it, NamedElement element) {
		switch (element) {
			Statechart: "tev" + element.timeEventSpecs.indexOf(it)
			State: "tev" + element.timeEventSpecs.indexOf(it)
		}
	}

	def public prefix(State it, char separator) {
		return getStatechart.name
	}

	def public prefix(Vertex it, char separator) {
		""
	}

	def public suffix(Vertex it, char separator) {
		""
	}

}
