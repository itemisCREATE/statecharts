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
package org.yakindu.slang.generator.modification

import com.google.inject.Inject
import java.util.Collection
import java.util.Set
import org.eclipse.emf.transaction.RunnableWithResult
import org.eclipse.emf.transaction.util.TransactionUtil
import org.yakindu.base.types.Package

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class ModificationExecutor implements IModification {
	
	@Inject Set<IModification> modifications;

	def protected Collection<Package> modifyInternal(Collection<Package> packages) {
		modifications.forEach[mod | mod.modify(packages)]
		packages
	}

	override Collection<Package> modify(Collection<Package> packages) {
		val editingDomain = packages.map[TransactionUtil.getEditingDomain(it)].head
		if (editingDomain === null) {
			return packages.modifyInternal
		} else {
			val runnable = new RunnableWithResult.Impl<Collection<Package>>() {
				override run() {
					result = packages.modifyInternal
				}
			}
			editingDomain.runExclusive(runnable);
			return runnable.result
		}
	}

}
