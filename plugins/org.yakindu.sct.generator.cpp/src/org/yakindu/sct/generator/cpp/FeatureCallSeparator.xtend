/** 
 * Copyright (c) 2020 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.Type
import org.yakindu.base.types.Package
import org.yakindu.base.types.TypedElement
import org.yakindu.base.types.adapter.OriginTracing
import org.yakindu.sct.model.sgraph.util.StatechartUtil
import org.yakindu.sct.model.stext.stext.InterfaceScope

/**
 * Helper class to decide which kind of separator ('->', '::', '.') needs to be printed for a feature call.
 */
class FeatureCallSeparator {
	
	@Inject protected extension ExpressionExtensions
	@Inject extension OriginTracing
	@Inject extension StatechartUtil
	
	def dispatch CharSequence callSep(EObject owner) '''.'''
	def dispatch CharSequence callSep(Package owner) '''::''' // namespaces are separated by ::
	def dispatch CharSequence callSep(ArgumentExpression it) { featureOrReference.callSep }
	def dispatch CharSequence callSep(InterfaceScope it) '''->'''
	def dispatch CharSequence callSep(TypedElement it) { if (type.isPointer) '''->''' else '''.''' }
	
	// TODO: move somewhere else yet to be defined
	def isPointer(Type type) {
		// submachine and interface variables are translated into pointers by code generator
		type.isOriginStatechart || type.originTraces.exists[it instanceof InterfaceScope]
	}
}