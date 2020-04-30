/** 
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Andreas Mülder (itemis AG)
 * Axel Terfloth (itemis AG) 
 */
package org.yakindu.sct.model.stext.scoping

import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.FilteringScope
import org.eclipse.xtext.scoping.impl.ImportNormalizer
import org.eclipse.xtext.scoping.impl.ImportScope
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.scoping.ExpressionsScopeProvider
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Package
import org.yakindu.base.types.Type
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.InferenceResult
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.ScopedElement
import org.yakindu.sct.model.sgraph.SpecificationElement
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.extensions.STextExtensions
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.StatechartSpecification
import com.google.common.base.Predicate
import com.google.common.collect.Lists
import com.google.inject.Inject
import org.yakindu.base.types.MetaComposite
import org.yakindu.base.expressions.expressions.MetaCall

/** 
 * @author andreas muelder
 * @author axel terfloth
 * @author alexander nyssen Added support for scoping of enumeration literals
 */
class STextScopeProvider extends ExpressionsScopeProvider {

	@Inject 
	ITypeSystemInferrer typeInferrer
	@Inject 
	ITypeSystem typeSystem
	@Inject 
	IQualifiedNameProvider nameProvider
	@Inject 
	ContextPredicateProvider predicateProvider
	@Inject
	protected STextExtensions utils

	def IScope scope_ActiveStateReferenceExpression_value(EObject context, EReference reference) {
		var Statechart statechart = getStatechart(context)
		if(statechart === null) return IScope.NULLSCOPE
		var List<State> allStates = EcoreUtil2.getAllContentsOfType(statechart, State)
		var IScope scope = Scopes.scopeFor(allStates, nameProvider, IScope.NULLSCOPE)
		return new ImportScope(getActiveStateNormalizer(context), scope,
			new EObjectDescriptionLookUp(Lists.newArrayList(scope.getAllElements())), reference.getEReferenceType(),
			false)
	}

	def protected List<ImportNormalizer> getActiveStateNormalizer(EObject context) {
		var List<ImportNormalizer> normalizer = Lists.newArrayList()
		var SpecificationElement contextElement = utils.getContextElement(context)
		if(contextElement === null) return normalizer
		var Region containingRegion = EcoreUtil2.getContainerOfType(contextElement, Region)
		if(containingRegion === null) return normalizer
		var QualifiedName fullyQualifiedName = nameProvider.getFullyQualifiedName(containingRegion)
		while (!fullyQualifiedName.getSegments().isEmpty()) {
			normalizer.add(new ImportNormalizer(fullyQualifiedName, true, false))
			fullyQualifiedName = fullyQualifiedName.skipLast(1)
		}
		return normalizer
	}

	/** 
	 * Scoping for types and taking imported namespaces into account e.g. in
	 * variable declarations.
	 */
	def IScope scope_TypeSpecifier_type(EObject context, EReference reference) {
		var IScope scope = getDelegate().getScope(context, reference)
		var Predicate<IEObjectDescription> predicate = calculateFilterPredicate(context, reference)
		return new FilteringScope(scope, predicate)
	}

	def IScope scope_ElementReferenceExpression_reference(EObject context, EReference reference) {
		var IScope namedScope = getNamedTopLevelScope(context, reference)
		var IScope unnamedScope = getUnnamedTopLevelScope(context, reference)
		var Predicate<IEObjectDescription> predicate = calculateFilterPredicate(context, reference)
		unnamedScope = new FilteringScope(unnamedScope, predicate)
		return new SimpleScope(unnamedScope, namedScope.getAllElements())
	}

	def IScope scope_FeatureCall_feature(FeatureCall context, EReference reference) {
		var Predicate<IEObjectDescription> predicate = calculateFilterPredicate(context, reference)
		var Expression owner = context.getOwner()
		var EObject element = null
		if (owner instanceof ElementReferenceExpression) {
			element = owner.getReference()
		} else if (owner instanceof FeatureCall) {
			element = owner.getFeature()
		} else {
			return getDelegate().getScope(context, reference)
		}
		var IScope scope = IScope.NULLSCOPE
		if (element instanceof Package) {
			return addScopeForPackage(element, scope, predicate, context, reference)
		}
		
		var InferenceResult result = typeInferrer.infer(owner)
		var Type ownerType = if(result !== null) result.getType() else null
		if (element instanceof Scope) {
			scope = Scopes.scopeFor(element.getDeclarations())
			return new FilteringScope(scope, predicate)
		} else if (ownerType !== null) {
			scope = Scopes.scopeFor(typeSystem.getPropertyExtensions(ownerType))
			scope = Scopes.scopeFor(typeSystem.getOperationExtensions(ownerType), scope)
		}
		if (ownerType instanceof EnumerationType) {
			scope = addScopeForEnumType(ownerType, scope, predicate)
		}
		if (ownerType instanceof ComplexType) {
			scope = addScopeForComplexType(ownerType, scope, predicate)
		}

		return scope
	}
	
	
	
	def IScope scope_FeatureCall_feature(MetaCall context, EReference reference) {

		var Predicate<IEObjectDescription> predicate = calculateFilterPredicate(context, reference);
		var Expression owner = context.getOwner();
		var EObject element = null;
		
		if (owner instanceof ElementReferenceExpression) {
			element = owner.getReference();
		} else if (owner instanceof FeatureCall) {
			element = owner.getFeature();
		} else {
			return getDelegate().getScope(context, reference);
		}

		var IScope scope = IScope.NULLSCOPE;

		if (element instanceof MetaComposite ) {
			if (element.getMetaFeatures().size() > 0) {
				scope = Scopes.scopeFor(element.getMetaFeatures(), scope);
				scope = new FilteringScope(scope, predicate);
			}
		}

		return scope;
	}
	

	def protected IScope addScopeForEnumType(EnumerationType element, IScope parentScope,
		Predicate<IEObjectDescription> predicate) {
		var scope = parentScope
		scope = Scopes.scopeFor((element).getEnumerator(), scope)
		scope = new FilteringScope(scope, predicate)
		return scope
	}

	def protected IScope addScopeForComplexType(ComplexType type, IScope parentScope,
		Predicate<IEObjectDescription> predicate) {
		var scope = parentScope
		scope = Scopes.scopeFor(type.getAllFeatures().filter[!isStatic], scope)
		scope = new FilteringScope(scope, predicate)
		return scope
	}

	def protected IScope addScopeForPackage(Package pkg, IScope parentScope, Predicate<IEObjectDescription> predicate, FeatureCall context, EReference reference) {
		var scope = parentScope
		scope = Scopes.scopeFor(pkg.member, scope)
		scope = new FilteringScope(scope, predicate)
		return scope
	}

	def private Predicate<IEObjectDescription> calculateFilterPredicate(EObject context, EReference reference) {
		var Predicate<IEObjectDescription> predicate = null
		var EObject container = context
		var EReference ref = reference
		var break = false;
		while (container !== null && !break) {
			predicate = predicateProvider.getPredicate(container.eClass(), ref)
			if (!(predicate === ContextPredicateProvider.EMPTY_PREDICATE)) {
				break = true
			}
			ref = container.eContainingFeature() as EReference
			container = container.eContainer()
		}
		return predicate
	}

	/** 
	 * Returns the toplevel scope
	 */
	def protected IScope getNamedTopLevelScope(EObject context, EReference reference) {
		var List<EObject> scopeCandidates = Lists.newArrayList()
		var ScopedElement scopedElement = getScopedElement(context)
		if(scopedElement === null) return IScope.NULLSCOPE
		var EList<Scope> scopes = scopedElement.getScopes()
		for (Scope scope : scopes) {
			if (scope instanceof InterfaceScope) {
				var String name = scope.getName()
				if (name !== null && name.trim().length() > 0) {
					scopeCandidates.add(scope)
				}
			}
		}
		return Scopes.scopeFor(scopeCandidates)
	}

	/** 
	 * Returns a scope with all toplevel declarations of unnamed scope
	 */
	def protected IScope getUnnamedTopLevelScope(EObject context, EReference reference) {
		var List<EObject> scopeCandidates = Lists.newArrayList()
		var ScopedElement scopedElement = getScopedElement(context)
		if(scopedElement === null) return IScope.NULLSCOPE
		var EList<Scope> scopes = scopedElement.getScopes()
		for (Scope scope : scopes) {
			if (scope instanceof InterfaceScope) {
				var String name = scope.getName()
				if (name === null || name.trim().length() === 0) {
					scopeCandidates.addAll(scope.getDeclarations())
				}
			} else if (scope instanceof InternalScope) {
				scopeCandidates.addAll(scope.getDeclarations())
			}
		}
		// Add import scope
		var IScope scope = getDelegate().getScope(context, reference)
		return Scopes.scopeFor(scopeCandidates, scope)
	}

	def protected ScopedElement getScopedElement(EObject context) {
		var ScopedElement scopedElement = EcoreUtil2.getContainerOfType(context, ScopedElement)
		if(EcoreUtil.getRootContainer(context) instanceof StatechartSpecification &&
			scopedElement !== null) return scopedElement
		return getStatechart(context)
	}

	def protected Statechart getStatechart(EObject context) {
		return utils.getStatechart(context)
	}
}
