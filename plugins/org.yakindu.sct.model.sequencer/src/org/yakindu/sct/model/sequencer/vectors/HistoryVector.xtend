/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sequencer.vectors

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.sct.model.sequencer.util.SgraphExtensions
import org.yakindu.sct.model.sequencer.vectors.StateVector.StateVectorSpec
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.Statechart

@Singleton
class HistoryVector {
	
	@Inject extension SgraphExtensions
	
	def create new StateVectorSpec historyVector(Statechart sc) {
		var offset = -1
		for ( r : sc.eAllContents.filter(typeof(Region)).toIterable) {
			if (r.requireHistory) {
				offset = offset+1
				r.historyVector.offset = offset;
				r.historyVector.size = 1
			}
		}
		if (offset != -1) {
			it.offset = 0;
			it.size = offset+1
		}
	}
	
	def create new StateVectorSpec historyVector(Region r) {}
}
