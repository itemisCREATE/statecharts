/** 
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.ui.quickfix

import java.util.Collections
import java.util.Optional
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions
import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor
import org.yakindu.sct.generator.core.extensions.ILibraryDescriptor
import org.yakindu.sct.generator.core.extensions.LibraryExtensions
import org.yakindu.sct.generator.core.library.IDefaultFeatureValueProvider
import org.yakindu.sct.generator.genmodel.ui.internal.GenmodelActivator
import org.yakindu.sct.generator.genmodel.validation.SGenJavaValidator
import org.yakindu.sct.model.sgen.FeatureConfiguration
import org.yakindu.sct.model.sgen.FeatureType
import org.yakindu.sct.model.sgen.FeatureTypeLibrary
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgen.GeneratorModel
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil

/** 
 * @author andreas muelder - Initial contribution and API
 */
class SGenQuickfixProvider extends DefaultQuickfixProvider {
	
	public static final String CHANGE_DOMAIN_COMMAND="Domain change command"
	
	@Fix(SGenJavaValidator::CODE_REQUIRED_FEATURE)
	def void AddRequiredFeature(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, '''Add feature «issue.getData().get(0)»'''.toString, '''Adds the feature «issue.getData().get(0)»'''.toString, null, (
			[EObject element, IModificationContext context|var FeatureConfiguration config=getDefaultFeatureConfiguration(issue, element) if (config !== null) {
			var GeneratorEntry entry=(element as GeneratorEntry) 
			entry.getFeatures().add(config) 
		}] as ISemanticModification)) 
	}
	@Fix(SGenJavaValidator::CODE_REQUIRED_DOMAIN)
	def void changeToValidDomain(Issue issue, IssueResolutionAcceptor acceptor) {
		var String[] validDomains=issue.getData().get(0).split(",") 
		for (String validDomain : validDomains) {
			addAcceptor(issue, acceptor, validDomain) 
		}
	}
	def private void addAcceptor(Issue issue, IssueResolutionAcceptor acceptor, String validDomain) {
		acceptor.accept(issue, validDomain, null, null, ([EObject element, IModificationContext context|if (element instanceof GeneratorEntry) {
			var EObject referencedStatechart=((element as GeneratorEntry)).getElementRef() 
			if (referencedStatechart instanceof Statechart) {
				var TransactionalEditingDomain sharedDomain=DiagramPartitioningUtil::getSharedDomain() 
				var DomainChangeCommand refactoringCommand=new DomainChangeCommand(sharedDomain,CHANGE_DOMAIN_COMMAND,Collections::EMPTY_LIST,validDomain,(referencedStatechart as Statechart)) 
				try {
					refactoringCommand.execute(new NullProgressMonitor(), null) 
				} catch (Exception ex) {
					ex.printStackTrace() 
				}
				
			}
		}] as ISemanticModification)) 
	}
	def private FeatureConfiguration getDefaultFeatureConfiguration(Issue issue, EObject element) {
		var GeneratorModel model=(EcoreUtil2::getRootContainer(element) as GeneratorModel) 
		var Optional<IGeneratorDescriptor> generatorDescriptor=GeneratorExtensions.getGeneratorDescriptor(model.getGeneratorId()) 
		if (!generatorDescriptor.isPresent()) return null 
		var Iterable<ILibraryDescriptor> libraryDescriptor=LibraryExtensions::getLibraryDescriptors(generatorDescriptor.get().getLibraryIDs()) 
		for (ILibraryDescriptor desc : libraryDescriptor) {
			var ResourceSet set=new ResourceSetImpl() 
			var Resource resource=set.getResource(desc.getURI(), true) 
			var FeatureTypeLibrary lib=(resource.getContents().get(0) as FeatureTypeLibrary) 
			var EList<FeatureType> types=lib.getTypes() 
			for (FeatureType featureType : types) {
				if (featureType.getName().equals(issue.getData().get(0))) {
					var IDefaultFeatureValueProvider valueProvider=desc.createFeatureValueProvider(GenmodelActivator.getInstance().getInjector(GenmodelActivator.ORG_YAKINDU_SCT_GENERATOR_GENMODEL_SGEN)) 
					if (valueProvider !== null) {
						return valueProvider.createDefaultFeatureConfiguration(featureType, element) 
					}
				}
			}
		}
		return null 
	}
}