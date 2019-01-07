/** 
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.scoping
import java.util.List
import java.util.Optional
import org.eclipse.core.runtime.Assert
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.eclipse.xtext.scoping.impl.FilteringScope
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.yakindu.base.expressions.expressions.ExpressionsPackage
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypesPackage
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions
import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor
import org.yakindu.sct.generator.core.extensions.ILibraryDescriptor
import org.yakindu.sct.generator.core.extensions.LibraryExtensions
import org.yakindu.sct.generator.genmodel.resource.FeatureResourceDescription
import org.yakindu.sct.generator.genmodel.typesystem.BuiltinDeclarations
import org.yakindu.sct.model.sgen.FeatureConfiguration
import org.yakindu.sct.model.sgen.GeneratorModel
import org.yakindu.sct.model.sgen.SGenPackage
import com.google.common.base.Predicate
import com.google.common.collect.Iterables
import com.google.common.collect.Lists
import com.google.inject.Inject
import com.google.inject.Injector
/** 
 * @author andreas muelder - Initial contribution and API
 */
class SGenScopeProvider extends AbstractDeclarativeScopeProvider {
	@Inject XtextResourceSet resourceSet
	@Inject Injector injector
	@Inject ITypeSystem typeSystem
	@Inject BuiltinDeclarations buildInDeclarations
	override IScope getScope(EObject context, EReference reference) {
		if (reference === TypesPackage.Literals.TYPE_SPECIFIER__TYPE) {
			return Scopes.scopeFor(typeSystem.getConcreteTypes()) 
		}
		if (reference === ExpressionsPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE) {
			return getElementReferenceScope(context) 
		}
		if (reference.getName().equals("type")) {
			return scope_Type(context, reference) 
		}
		if (reference.getName().equals("parameter")) {
			return scope_Parameter(context, reference) 
		}
		if (reference.getName().equals("elementRef")) {
			return scope_GeneratorEntry_elementRef(context, reference) 
		}
		return super.getScope(context, reference) 
	}
	def protected IScope getElementReferenceScope(EObject context) {
		var GeneratorModel generatorModel=(EcoreUtil.getRootContainer(context) as GeneratorModel) 
		var EList<Property> properties=generatorModel.getProperties() 
		var List<Property> all=buildInDeclarations.getDeclarations() 
		return Scopes.scopeFor(properties, Scopes.scopeFor(all)) 
	}
	def protected IScope scope_GeneratorEntry_elementRef(EObject context, EReference reference) {
		var GeneratorModel generatorModel=(EcoreUtil2.getRootContainer(context) as GeneratorModel) 
		var String id=generatorModel.getGeneratorId() 
		val Optional<IGeneratorDescriptor> desc=GeneratorExtensions.getGeneratorDescriptor(id) 
		if (!desc.isPresent()) {
			return IScope.NULLSCOPE 
		}
		val String elementRefType=desc.get().getElementRefType() 
		var IScope scope=new FilteringScope(getDelegate().getScope(context, reference),[IEObjectDescription input|var EList<EClass> allSuperTypes=input.getEClass().getESuperTypes() for (EClass eClass : allSuperTypes) {
			if (elementRefType.equals(eClass.getInstanceClassName())) return true 
		}return elementRefType.equals(input.getEClass().getInstanceClassName()) ]) 
		return new SimpleScope(scope.getAllElements()) 
	}
	def protected IScope scope_Parameter(EObject context, EReference reference) {
		var IScope libraryScope=getLibraryScope(context.eResource()) 
		return new FilteringScope(libraryScope,[IEObjectDescription input|if (!input.getEClass().equals(SGenPackage.Literals.FEATURE_PARAMETER)) {
			return false 
		}// Only allow references to FeatureParameters defined by
		// enclosing Feature
		var FeatureConfiguration configuration=EcoreUtil2.getContainerOfType(context, FeatureConfiguration) if (configuration === null || configuration.getType() === null) return false var String featureName=configuration.getType().getName() if (featureName === null) {
			return false 
		}return featureName.equals(input.getUserData(FeatureResourceDescription.FEATURE_CONTAINER)) ]) 
	}
	def protected IScope scope_Type(EObject context, EReference reference) {
		var IScope libraryScope=getLibraryScope(context.eResource()) 
		return new FilteringScope(libraryScope,[IEObjectDescription input|return input.getEClass().equals(SGenPackage.Literals.FEATURE_TYPE) ]) 
	}
	def protected SimpleScope getLibraryScope(Resource resource) {
		var GeneratorModel generatorModel=(EcoreUtil.getObjectByType(resource.getContents(), SGenPackage.Literals.GENERATOR_MODEL) as GeneratorModel) 
		Assert.isNotNull(generatorModel) 
		var String generatorId=generatorModel.getGeneratorId() 
		var Iterable<IEObjectDescription> allElements=Lists.newArrayList() 
		var Optional<IGeneratorDescriptor> generatorDescriptor=GeneratorExtensions.getGeneratorDescriptor(generatorId) 
		if (generatorDescriptor.isPresent()) {
			var Iterable<ILibraryDescriptor> libraryDescriptor=LibraryExtensions.getLibraryDescriptors(generatorDescriptor.get().getLibraryIDs()) 
			for (ILibraryDescriptor desc : libraryDescriptor) {
				var Resource library=resourceSet.getResource(desc.getURI(), true) 
				var FeatureResourceDescription description=new FeatureResourceDescription(library) 
				injector.injectMembers(description) 
				allElements=Iterables.concat(allElements, description.getExportedObjects()) 
			}
		}
		return new SimpleScope(allElements) 
	}
}