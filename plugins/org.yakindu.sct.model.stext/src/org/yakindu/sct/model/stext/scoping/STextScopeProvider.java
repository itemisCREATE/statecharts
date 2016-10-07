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

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.InferenceResult;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.util.ContextElementAdapter;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder
 * @author axel terfloth
 * @author alexander nyssen Added support for scoping of enumeration literals
 * 
 */
public class STextScopeProvider extends AbstractDeclarativeScopeProvider {

	@Inject
	private ITypeSystemInferrer typeInferrer;
	@Inject
	private ITypeSystem typeSystem;

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

	public IScope scope_TypeSpecifier_type(final EObject context, EReference reference) {
		return getDelegate().getScope(context, reference);
	}

	public IScope scope_ElementReferenceExpression_reference(final EObject context, EReference reference) {
		IScope scope = getUnnamedTopLevelScope(context, reference);
		scope = getNamedTopLevelScope(context, reference, scope);
		return scope;
	}

	public IScope scope_FeatureCall_feature(final FeatureCall context, EReference reference) {
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
		InferenceResult result = typeInferrer.infer(owner);
		Type ownerType = result != null ? result.getType() : null;

		if (element instanceof Scope) {
			return Scopes.scopeFor(((Scope) element).getDeclarations());
		} else if (ownerType != null) {
			scope = Scopes.scopeFor(typeSystem.getPropertyExtensions(ownerType));
			scope = Scopes.scopeFor(typeSystem.getOperationExtensions(ownerType), scope);
		}

		if (ownerType instanceof ComplexType) {
			return addScopeForComplexType((ComplexType) ownerType, scope);
		}
		if (ownerType instanceof EnumerationType) {
			return addScopeForEnumType((EnumerationType) ownerType, scope);
		}
		return scope;
	}

	protected IScope addScopeForEnumType(EnumerationType element, IScope scope) {
		return Scopes.scopeFor((element).getEnumerator(), scope);
	}

	protected IScope addScopeForComplexType(final ComplexType type, IScope scope) {
		return Scopes.scopeFor(type.getAllFeatures(), scope);
	}

	protected IScope getNamedTopLevelScope(final EObject context, EReference reference, IScope outer) {
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
		return Scopes.scopeFor(scopeCandidates, outer);
	}

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

		// Add import scope
		IScope scope = getDelegate().getScope(context, reference);
		return Scopes.scopeFor(scopeCandidates, scope);
	}

	protected Statechart getStatechart(EObject context) {
		final ContextElementAdapter provider = (ContextElementAdapter) EcoreUtil.getExistingAdapter(context.eResource(),
				ContextElementAdapter.class);

		if (provider == null) {
			return EcoreUtil2.getContainerOfType(context, Statechart.class);
		} else {
			return (Statechart) EcoreUtil.getObjectByType(provider.getElement().eResource().getContents(),
					SGraphPackage.Literals.STATECHART);
		}
	}
}
