package org.yakindu.sct.model.sgraph.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.common.base.Predicates;
import com.google.inject.Inject;

import de.itemis.xtext.utils.gmf.resource.InjectMembersResource;

public class SGraphInjectMembersResource extends InjectMembersResource {

	@Inject
	IGlobalScopeProvider scopeProvider;

	@Inject
	IQualifiedNameConverter nameConverter;

	public SGraphInjectMembersResource(URI uri) {
		super(uri);
	}

	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		super.doLoad(inputStream, options);
		linkSubStatecharts();
	}

	private void linkSubStatecharts() {
		TreeIterator<EObject> iter = getAllContents();
		while (iter.hasNext()) {
			EObject currentObject = iter.next();
			if (currentObject instanceof State) {
				State state = (State) currentObject;
				if (state.getSubstatechartId() != null) {
					Statechart substatechart = getStatechart(state,
							state.getSubstatechartId());
					state.setSubstatechart(substatechart);
				}
			}
		}
	}

	private Statechart getStatechart(EObject context, String substatechartId) {
		IScope scope = scopeProvider.getScope(context.eResource(),
				SGraphPackage.Literals.STATE__SUBSTATECHART,
				Predicates.<IEObjectDescription> alwaysTrue());
		IEObjectDescription statechartDescription = scope
				.getSingleElement(nameConverter
						.toQualifiedName(substatechartId));
		if (statechartDescription != null) {
			Statechart statechart = null;
			statechart = (Statechart) statechartDescription.getEObjectOrProxy();
			if (statechart != null && statechart.eIsProxy()) {
				statechart = (Statechart) EcoreUtil
						.resolve(statechart, context);
			}
			return statechart;

		}
		return null;
	}
}
