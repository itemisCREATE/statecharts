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
package org.yakindu.sct.types.modification

import com.google.inject.Inject
import java.util.Collection
import java.util.Set
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.transaction.RunnableWithResult
import org.eclipse.emf.transaction.util.TransactionUtil
import org.yakindu.base.types.Package

/**
 * The ModificationExecutor holds a set of {@link IModification} instances, obtained via injection
 * (see {@link org.yakindu.sct.types.TypesGeneratorModule}). It can be used to execute a number of 
 * IModification instances on a {@link Collection&lt;{@link org.yakindu.base.types.Package}&gt;.
 * The collection can explicitly be changed during this process.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class ModificationExecutor implements IModification {
	
	@Inject Set<IModification> modifications;

	def protected Collection<Package> modifyInternal(Collection<Package> packages) {
		if(ResourcesPlugin.workspace.root.getProject("Debug").exists){
			packages.forEach[p, i| p.serialize(URI.createPlatformResourceURI('''Debug/«p.name»_«i»_.slang''',true))]
		}
		var result = packages
		for(modification : modifications) {
			result = modification.modify(result)
			if(ResourcesPlugin.workspace.root.getProject("Debug").exists){
				result.forEach[p, i| p.serialize(URI.createPlatformResourceURI('''Debug/«p.name»_«i»_«modification.class.simpleName».slang''',true))]
			}
		}
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
	
	def serialize(Package p, URI uri) {
		val set = new ResourceSetImpl();
		val resource = set.createResource(uri);
			resource.contents += p
			resource.save(null)
	}

}
