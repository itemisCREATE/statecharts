/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.common.base.Predicates;
import com.google.inject.Inject;

import de.itemis.xtext.utils.gmf.resource.InjectMembersResource;

/**
 * Implementation of InjectMembersResource that handles substatecharts set in
 * states by qualifiedName
 * 
 * @author benjamin schwertfeger
 * 
 */
public class SGraphInjectMembersResource extends InjectMembersResource {

	@Inject
	IGlobalScopeProvider scopeProvider;

	@Inject
	IQualifiedNameConverter nameConverter;

	@Inject
	IQualifiedNameProvider nameProvider;

	public SGraphInjectMembersResource(URI uri) {
		super(uri);
	}

	protected XMLLoad createXMLLoad() {
		return new SGraphLoad(createXMLHelper());
	}

	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		super.doLoad(inputStream, options);
		linkSubStatecharts();
	}

	private void linkSubStatecharts(State currentState) {
		removeDiagnostics(currentState);
		Statechart substatechart = getStatechart(currentState,
				currentState.getSubstatechartId());
		currentState.setSubstatechart(substatechart);
		registerRelinkAdapter(currentState);
	}

	private void removeDiagnostics(State currentState) {
		List<org.eclipse.emf.common.util.Diagnostic> diagnostics = getDiagnostics();
		Iterator<org.eclipse.emf.common.util.Diagnostic> iter = diagnostics
				.iterator();
		while (iter.hasNext()) {
			org.eclipse.emf.common.util.Diagnostic d = iter.next();
			if (d instanceof BrokenLinkDiagnostic && !d.getData().isEmpty()
					&& d.getData().get(0) == currentState) {
				iter.remove();
			}
		}

	}

	/**
	 * Adds a relinkAdapter that observes the source feature and links the model
	 * element in case of changes again.
	 * 
	 * @param object
	 */
	private void registerRelinkAdapter(State object) {
		Adapter existingAdapter = EcoreUtil.getExistingAdapter(object,
				RelinkAdapter.class);
		if (existingAdapter == null) {
			object.eAdapters().add(
					new RelinkAdapter(object,
							SGraphPackage.Literals.STATE__SUBSTATECHART_ID));
		}
	}

	private void linkSubStatecharts() {
		TreeIterator<EObject> iter = getAllContents();
		while (iter.hasNext()) {
			EObject currentObject = iter.next();
			if (currentObject instanceof State) {
				State state = (State) currentObject;
				if (state.getSubstatechartId() == null
						&& state.getSubstatechart() != null) {
					// For compatibility added. If a substate is set, but not
					// the ID, the ID is updated.
					state.setSubstatechartId(nameProvider
							.getFullyQualifiedName(state.getSubstatechart())
							.toString());
				}
				linkSubStatecharts(state);
			}
		}
	}

	private Statechart getStatechart(EObject context, String substatechartId) {
		if (substatechartId == null || substatechartId.length() == 0) {
			return null;
		}
		IScope scope = scopeProvider.getScope(context.eResource(),
				SGraphPackage.Literals.STATE__SUBSTATECHART,
				Predicates.<IEObjectDescription> alwaysTrue());
		IEObjectDescription statechartDescription = scope
				.getSingleElement(nameConverter
						.toQualifiedName(substatechartId));
		if (statechartDescription != null) {
			Statechart statechart = null;
			statechart = (Statechart) statechartDescription.getEObjectOrProxy();
			if (statechart.eIsProxy()) {
				statechart = (Statechart) EcoreUtil
						.resolve(statechart, context);
			}
			return statechart;
		} else {
			getDiagnostics()
					.add(new BrokenLinkDiagnostic(
							org.eclipse.emf.common.util.Diagnostic.ERROR,
							"source", 0, "Sub statechart '" + substatechartId
									+ "' not linked", new Object[] { context }));
		}
		return null;
	}

	@Override
	public void attached(EObject eObject) {
		super.attached(eObject);
		if (isLoading() || isParsing())
			return;
		if (eObject instanceof State) {
			linkSubStatecharts((State) eObject);
		}
	}

	@Override
	public void detached(EObject eObject) {
		super.detached(eObject);
		Adapter existingAdapter = EcoreUtil.getExistingAdapter(eObject,
				RelinkAdapter.class);
		if (existingAdapter != null) {
			eObject.eAdapters().remove(existingAdapter);
		}
	}

	private final class BrokenLinkDiagnostic extends BasicDiagnostic {
		public BrokenLinkDiagnostic(int severity, String source, int code,
				String message, Object[] data) {
			super(severity, source, code, message, data);
		}
	}

	/**
	 * ReparseAdapter listens for feature changes and reparses the whole model.
	 * 
	 * @author benjamin schwertfeger
	 * 
	 */
	private final class RelinkAdapter extends AdapterImpl {
		public final EStructuralFeature expressionFeature;

		private RelinkAdapter(State currentObject,
				EStructuralFeature expressionFeature) {
			this.expressionFeature = expressionFeature;
		}

		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getFeature() == expressionFeature) {
				if (!(msg.getNotifier() instanceof State)) {
					throw new IllegalStateException(
							"Changed StatechartID should only rise for states");
				}
				linkSubStatecharts((State) msg.getNotifier());
			}
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return RelinkAdapter.class == type;
		}
	}
}
