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
package org.yakindu.sct.model.sexec.concepts

import org.yakindu.sct.model.stext.stext.StextFactory
import org.yakindu.sct.model.sexec.ExecutionFlow
import com.google.inject.Singleton
import com.google.inject.Inject
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.stext.stext.StatechartScope

/**
 * @author Axel Terfloth
 */
@Singleton
class ShadowMemberScope {
	
	
	public static String SHADOW_ANNOTATION = "__shadow__"
	
	protected extension StextFactory = StextFactory.eINSTANCE
	@Inject protected extension TypeBuilder
	
	def create createInternalScope shadowMemberScope(ExecutionFlow flow) {
		flow.scopes += it
		it._annotate(SHADOW_ANNOTATION)
	} 
	
	def boolean isShadowMemberScope(StatechartScope it) {
		annotations.exists[ a | a.type.name == SHADOW_ANNOTATION]		
	} 
	
}