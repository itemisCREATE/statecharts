/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.expressions.linking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.yakindu.base.expressions.expressions.ArgumentExpression;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.TypesPackage;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * 
 * Supports operation overloading
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class OperationOverloadingLinkingService extends DefaultLinkingService {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	@Inject
	private OperationOverloadingResolver operationsLinker;

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
		if (context instanceof ArgumentExpression && isOperationCall(context)) {
			return getLinkedOperation((ArgumentExpression) context, ref, node);
		}
		return super.getLinkedObjects(context, ref, node);
	}

	public List<EObject> getLinkedOperation(ArgumentExpression context, EReference ref, INode node) {
		final EClass requiredType = ref.getEReferenceType();
		if (requiredType == null) {
			return Collections.<EObject>emptyList();
		}
		final String crossRefString = getCrossRefNodeAsString(node);
		if (crossRefString == null || crossRefString.equals("")) {
			return Collections.<EObject>emptyList();
		}
		final IScope scope = getScope(context, ref);
		final QualifiedName qualifiedLinkName = qualifiedNameConverter.toQualifiedName(crossRefString);
		// Adoption to super class implementation here to return multi elements
		final Iterable<IEObjectDescription> eObjectDescription = scope.getElements(qualifiedLinkName);
		int size = Iterables.size(eObjectDescription);
		if (size == 0)
			return Collections.emptyList();
		if (size == 1)
			return Collections.singletonList(Iterables.getFirst(eObjectDescription, null).getEObjectOrProxy());
		// Two operation with same name found here
		List<IEObjectDescription> candidates = new ArrayList<>();
		for (IEObjectDescription currentDescription : eObjectDescription) {
			if (TypesPackage.Literals.OPERATION.isSuperTypeOf(currentDescription.getEClass())) {
				candidates.add(currentDescription);
			}
		}
		Optional<Operation> operation = operationsLinker.linkOperation(candidates, context);
		if (operation.isPresent()) {
			return Collections.singletonList(operation.get());
		}
		//Link to first operation to get parameter errors instead of linking errors
		return Collections.singletonList(Iterables.getFirst(eObjectDescription, null).getEObjectOrProxy());
	}

	protected boolean isOperationCall(EObject context) {
		if (context instanceof ElementReferenceExpression) {
			return ((ElementReferenceExpression) context).isOperationCall();
		}
		if (context instanceof FeatureCall) {
			return ((FeatureCall) context).isOperationCall();
		}
		return false;
	}

}
