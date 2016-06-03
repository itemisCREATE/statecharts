/** 
 * Copyright (c) 2016 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.transformation.test

import org.junit.Test
import static org.yakindu.sct.model.sgraph.test.util.SGraphTestFactory.*
import static org.yakindu.sct.model.stext.test.util.StextTestFactory.*
import static org.junit.Assert.*
import org.eclipse.emf.ecore.EObject
import org.yakindu.sct.model.sexec.Call

/** 
 * This test class tests transformation errors that create calls to null sequences. This covers the issues:
 *  - #566
 *  
 * @author terfloth@itemis.de
 */
class NullCallTest extends ModelSequencerTest {
	
	
	@Test def syncEntryOnReqionsWithoutDefaultSequence() {
		val tsc = new SCTTestUtil.MinimalTSC()
		
		val s2 = _createState("S2", tsc.r)
		
		val s2_r1 = _createRegion("r1", s2)
		val s2_r1_sync = _createSynchronization(s2_r1)
		val s1_t1 = _createTransition(tsc.s1, s2_r1_sync)
		val s1_t1_tr = _createReactionTrigger(s1_t1)
		_createRegularEventSpec(tsc.e1, s1_t1_tr)
		val a = _createState("A", s2_r1)
		_createTransition(s2_r1_sync, a)
		
		
		val s2_r2 = _createRegion("r2", s2)
		val b = _createState("B", s2_r2)
		_createTransition(s2_r1_sync, b)
		
		
		val flow = sequencer.transform(tsc.sc);
		
		assertNoNullCalls(flow)
		
	}
	
	
	def void assertNoNullCalls(EObject e) {
		assertFalse (e.eAllContents.filter(Call).exists[ step == null] )
	}
	

}