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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Feature;
import org.yakindu.base.types.ITypeSystem;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeSystemUtils;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.scoping.ContextPredicateProvider.EmptyPredicate;
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
 * @author alexander nyssen Added support for scoping of enumeration literals
 * 
 */
public class STextScopeProvider extends AbstractDeclarativeScopeProvider {

	@Inject
	ITypeSystem typeSystem;

	@Inject
	TypeSystemUtils typeSystemUtils;

	private static class ErrorHandlerDelegate<T> implements ErrorHandler<T> {

		private ErrorHandler<T> delegate;

		public static final Log LOG = LogFactory.getLog(STextScopeProvider.class);

		public ErrorHandlerDelegate(ErrorHandler<T> delegate) {
			this.delegate = delegate;

		}

		public T handle(Object[] params, Throwable throwable) {
			if (throwable instanceof NoSuchMethodException) {
				LOG.debug("Error in scope method, using fallback", throwable);
			} else {
				LOG.warn("Error in scope method, using fallback", throwable);
			}
			return delegate.handle(params, throwable);
		}

	}

	@Override
	public IScope getScope(EObject context, EReference reference) {
		String methodName = "scope_" + reference.getEContainingClass().getName() + "_" + reference.getName();
		System.out.println(methodName);
		try {
			ErrorHandler<IScope> originalHandler = getErrorHandler();
			setErrorHandler(new ErrorHandlerDelegate<IScope>(originalHandler));
			IScope scope = super.getScope(context, reference);
			setErrorHandler(originalHandler);
			return scope;
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}

	@Inject
	private ContextPredicateProvider predicateProvider;

	public IScope scope_ElementReferenceExpression_reference(final EObject context, EReference reference) {
		IScope namdScope = getNamedTopLevelScope(context, reference);
		IScope unnamedScope = getUnnamedTopLevelScope(context, reference);
//		Predicate<IEObjectDescription> predicate = calculateFilterPredicate(context, reference);
//		unnamedScope = new FilteringScope(unnamedScope, predicate);
		// add enum types
		return new SimpleScope(Iterables.concat(namdScope.getAllElements(), unnamedScope.getAllElements(), Scopes
				.scopeFor(typeSystemUtils.getEnumerationTypes(typeSystem)).getAllElements()));
	}

	public IScope scope_FeatureCall_feature(final FeatureCall context, EReference reference) {

		Predicate<IEObjectDescription> predicate = calculateFilterPredicate(context, reference);

		Expression owner = context.getOwner();
		EObject element = null;
		if (owner instanceof ElementReferenceExpression) {
			element = ((ElementReferenceExpression) owner).getReference();
		} else if (owner instanceof FeatureCall) {
			element = ((FeatureCall) owner).getFeature();
		} else {
			return getDelegate().getScope(context, reference);
		}

		IScope scope = IScope.NULLSCOPE;

		if (element instanceof Scope) {
			scope = Scopes.scopeFor(((Scope) element).getDeclarations());
			scope = new FilteringScope(scope, predicate);
		}

		if (element instanceof ComplexType) {
			scope = Scopes.scopeFor(allFeatures((Type) element), scope);
			scope = new FilteringScope(scope, predicate);
		}

		if (element instanceof EnumerationType) {
			scope = Scopes.scopeFor(((EnumerationType) element).getEnumerator(), scope);
			scope = new FilteringScope(scope, predicate);
		}

		if (element instanceof Feature) {
			scope = Scopes.scopeFor(allFeatures(((Feature) element).getType()), scope);
			scope = new FilteringScope(scope, predicate);
		}

		return scope;
	}

	private Predicate<IEObjectDescription> calculateFilterPredicate(final EObject context, final EReference reference) {
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
	protected IScope getNamedTopLevelScope(final EObject context, EReference reference) {
		List<EObject> scopeCandidates = Lists.newArrayList();
		Statechart statechart = getStatechart(context);
		if (statechart == null)
			return IScope.NULLSCOPE;
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
	protected IScope getUnnamedTopLevelScope(final EObject context, EReference reference) {
		List<EObject> scopeCandidates = Lists.newArrayList();
		Statechart statechart = getStatechart(context);
		if (statechart == null)
			return IScope.NULLSCOPE;
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
		final ContextElementAdapter provider = (ContextElementAdapter) EcoreUtil.getExistingAdapter(
				context.eResource(), ContextElementAdapter.class);

		if (provider == null) {
			return EcoreUtil2.getContainerOfType(context, Statechart.class);
		} else {
			return (Statechart) EcoreUtil.getObjectByType(provider.getElement().eResource().getContents(),
					SGraphPackage.Literals.STATECHART);
		}
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
	protected void collectFeatures(Type type, List<Feature> features, Set<Type> visited) {
		if (type == null || visited.contains(type))
			return;
		if (type instanceof ComplexType) {
			for (Type superType : ((ComplexType) type).getSuperTypes()) {
				collectFeatures(superType, features, visited);
			}
			features.addAll(((ComplexType) type).getFeatures());
		}
		visited.add(type);
	}

	// TODO
	protected IScope scope_TypedElement_type(EObject context, EReference ref) {
		IScope scope = getDelegate().getScope(context, ref);
		
		return scope;
	}
	//

}