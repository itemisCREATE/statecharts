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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.yakindu.base.expressions.expressions.ArgumentExpression;
import org.yakindu.base.expressions.expressions.util.ArgumentSorter;
import org.yakindu.base.types.Expression;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class OperationOverloadingResolver {

	protected class PolymorphicComparator implements Comparator<Operation> {

		public int compare(Operation operation1, Operation operation2) {
			List<Parameter> parameters1 = operation1.getParameters();
			List<Parameter> parameters2 = operation2.getParameters();

			if (parameters1.size() > parameters2.size()) {
				return -1;
			}
			if (parameters1.size() < parameters2.size()) {
				return 1;
			}

			for (int i = 0; i < parameters1.size(); i++) {
				final Type type1 = parameters1.get(i).getType();
				final Type type2 = parameters2.get(i).getType();

				if (typeSystem.isSame(type1, type2))
					continue;
				if (typeSystem.isSuperType(type1, type2)) {
					return 1;
				}
				if (typeSystem.isSuperType(type2, type1)) {
					return -1;
				}
			}
			return 0;
		}
	}

	@Inject
	protected ITypeSystemInferrer inferrer;
	@Inject
	protected ITypeSystem typeSystem;

	public Optional<Operation> linkOperation(List<IEObjectDescription> candidates, ArgumentExpression call) {
		if (candidates.size() == 1 && candidates.get(0).getEClass().isSuperTypeOf(TypesPackage.Literals.OPERATION)) {
			return Optional.of((Operation) candidates.get(0).getEObjectOrProxy());
		}

		List<Operation> operations = candidates.stream().map(it -> (Operation) it.getEObjectOrProxy())
				.collect(Collectors.toList());
		Collections.sort(operations, new PolymorphicComparator());
		for (Operation operation : operations) {
			if (isCallable(operation, call)) {
				return Optional.of(operation);
			}
		}

		return Optional.empty();
	}

	protected boolean isCallable(Operation operation, ArgumentExpression expression) {
		EList<Expression> orderedExpressions = ArgumentSorter.getOrderedExpressions(expression.getArguments(),
				operation);
		List<Type> argumentTypes = orderedExpressions.stream().map(it -> inferrer.infer(it).getType())
				.filter(t -> t != null).collect(Collectors.toList());
		List<Type> parameterTypes = operation.getParameters().stream().map(it -> it.getType())
				.collect(Collectors.toList());
		if (argumentTypes.size() != parameterTypes.size())
			return false;
		for (int i = 0; i < argumentTypes.size(); i++) {
			Type type1 = argumentTypes.get(i);
			Type type2 = parameterTypes.get(i);
			
			if (!typeSystem.isConvertableTo(type1, type2) && !typeSystem.isSuperType(type2, type1))
				return false;
		}
		return true;
	}
}
