/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Mülder (itemis AG)
 *     Axel Terfloth (itemis AG) 
 */
package org.yakindu.sct.model.stext.scoping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.yakindu.base.types.Feature;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.scoping.ContextPredicateProvider.EmptyPredicate;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.FeatureCall;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter;

/**
 * 
 * @author andreas muelder
 * @author axel terfloth
 * 
 */
public class STextScopeProvider extends AbstractDeclarativeScopeProvider {

	@Override
	public IScope getScope(EObject context, EReference reference) {
		try {
			return super.getScope(context, reference);
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}

	@Inject
	private ContextPredicateProvider predicateProvider;

	public IScope scope_ElementReferenceExpression_reference(
			final EObject context, EReference reference) {
		IScope namdScope = getNamedTopLevelScope(context, reference);
		IScope unnamedScope = getUnnamedTopLevelScope(context, reference);
		Predicate<IEObjectDescription> predicate = calcuateFilterPredicate(
				context, reference);
		unnamedScope = new FilteringScope(unnamedScope, predicate);
		return new SimpleScope(Iterables.concat(namdScope.getAllElements(),
				unnamedScope.getAllElements()));
	}

	public IScope scope_FeatureCall_feature(final FeatureCall context,
			EReference reference) {

		Predicate<IEObjectDescription> predicate = calcuateFilterPredicate(
				context, reference);
		Expression owner = context.getOwner();
		if (owner instanceof ElementReferenceExpression) {
			EObject element = ((ElementReferenceExpression) owner)
					.getReference();
			if (element instanceof Scope) {
				IScope scope = Scopes.scopeFor(((Scope) element)
						.getDeclarations());
				return new FilteringScope(scope, predicate);
			} else if (element instanceof Type && element instanceof Feature) {
				EList<Feature> features = ((Type) element).getFeatures();
				IScope scope = Scopes.scopeFor(features, Scopes
						.scopeFor(allFeatures(((Feature) element).getType())));
				return new FilteringScope(scope, predicate);
			}

		} else if (owner instanceof FeatureCall) {
			Feature feature = (Feature) ((FeatureCall) owner).getFeature();
			IScope scope = Scopes.scopeFor(allFeatures(feature.getType()));
			if (feature instanceof Type) {
				IScope featureTypeScope = Scopes.scopeFor(
						allFeatures((Type) feature), scope);
				return new FilteringScope(featureTypeScope, predicate);
			}
			return new FilteringScope(scope, predicate);
		}
		return getDelegate().getScope(context, reference);
	}

	// OK
	private Predicate<IEObjectDescription> calcuateFilterPredicate(
			final EObject context, final EReference reference) {
		Predicate<IEObjectDescription> predicate = null;
		EObject container = context;
		EReference ref = reference;
		while (container != null) {
			predicate = predicateProvider.getPredicate(container.eClass(), ref);
			if (!(predicate instanceof EmptyPredicate)) {
				break;
			}
			ref = (EReference) container.eContainingFeature();
			container = container.eContainer();
		}
		return predicate;
	}

	/**
	 * Returns the toplevel scope
	 */
	protected IScope getNamedTopLevelScope(final EObject context,
			EReference reference) {
		List<EObject> scopeCandidates = Lists.newArrayList();
		Statechart statechart = getStatechart(context);
		EList<Scope> scopes = statechart.getScopes();
		for (Scope scope : scopes) {
			if (scope instanceof InterfaceScope) {
				String name = ((InterfaceScope) scope).getName();
				if (name != null && name.trim().length() > 0) {
					scopeCandidates.add(scope);
				}
			}
		}
		return Scopes.scopeFor(scopeCandidates);
	}

	/**
	 * Returns a scope with all toplevel declarations of unnamed scope
	 */
	protected IScope getUnnamedTopLevelScope(final EObject context,
			EReference reference) {
		List<EObject> scopeCandidates = Lists.newArrayList();
		Statechart statechart = getStatechart(context);
		EList<Scope> scopes = statechart.getScopes();
		for (Scope scope : scopes) {
			if (scope instanceof InterfaceScope) {
				String name = ((InterfaceScope) scope).getName();
				if (name == null || name.trim().length() == 0) {
					scopeCandidates.addAll(scope.getDeclarations());
				}
			} else if (scope instanceof InternalScope) {
				scopeCandidates.addAll(scope.getDeclarations());
			}
		}
		return Scopes.scopeFor(scopeCandidates);
	}

	/**
	 * Returns the {@link Statechart} for a context element
	 */

	protected Statechart getStatechart(EObject context) {
		final ContextElementAdapter provider = (ContextElementAdapter) EcoreUtil
				.getExistingAdapter(context.eResource(),
						ContextElementAdapter.class);

		Statechart statechart = (Statechart) EcoreUtil.getObjectByType(provider
				.getElement().eResource().getContents(),
				SGraphPackage.Literals.STATECHART);
		return statechart;
	}

	/**
	 * Returns all features including super features for the given type
	 */
	protected List<Feature> allFeatures(Type type) {
		List<Feature> features = new ArrayList<Feature>();
		collectFeatures(type, features, new HashSet<Type>());
		return features;
	}

	/**
	 * Performs a simple search to collect all features of the type and all
	 * super types.
	 * 
	 */
	protected void collectFeatures(Type type, List<Feature> features,
			Set<Type> visited) {
		if (type == null || visited.contains(type))
			return;
		for (Type superType : type.getSuperTypes()) {
			collectFeatures(superType, features, visited);
		}
		features.addAll(type.getFeatures());
		visited.add(type);
	}

}