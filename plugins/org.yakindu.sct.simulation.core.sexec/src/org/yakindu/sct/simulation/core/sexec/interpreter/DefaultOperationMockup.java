/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.sexec.interpreter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yakindu.base.expressions.expressions.ArgumentExpression;
import org.yakindu.base.expressions.expressions.IntLiteral;
import org.yakindu.base.expressions.interpreter.AbstractOperationExecutor;
import org.yakindu.base.expressions.interpreter.IOperationExecutor;
import org.yakindu.base.types.Operation;
import org.yakindu.sct.model.sruntime.ExecutionContext;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Singleton;

/**
 *
 * @author jonathan thoene - Initial contribution and API
 *
 */
@Singleton
public class DefaultOperationMockup extends AbstractOperationExecutor implements IOperationExecutor {

	protected MockReturnMap mockReturn = new MockReturnMap();
	protected Multimap<String, List<Object>> verifyCalls = ArrayListMultimap.create();

	@Override
	public boolean canExecute(ArgumentExpression expression) {
		return true;
	}

	@Override
	public Object execute(ArgumentExpression expression, ExecutionContext context) {
		Operation definition = getOperation(expression);
		List<Object> arguments = Arrays.asList(executeArguments(expression.getArguments(), context, definition));
		verifyCalls.put(definition.getName(), arguments);
		return mockReturn.get(definition.getName(), arguments);
	}

	public boolean wasCalledAtLeast(String operation, List<Object> parameters, IntLiteral times) {
		int t = 1;
		if (times != null) {
			t = times.getValue();
		}
		return getOperationCallCount(operation, parameters) >= t;
	}
	
	public boolean wasCalledExactly(String operation, List<Object> parameters, IntLiteral times) {
		int t = 1;
		if (times != null) {
			t = times.getValue();
		}
		return getOperationCallCount(operation, parameters) == t;
	}

	public boolean wasNotCalled(String operation, List<Object> parameters) {
		return getOperationCallCount(operation, parameters) == 0;
	}

	public Collection<List<Object>> getOperationCalls(String operation) {
		Collection<List<Object>> calledParameters = verifyCalls.get(operation);
		return calledParameters;
	}

	public int getOperationCallCount(String operation, List<Object> parameters) {
		Collection<List<Object>> operationCalls = getOperationCalls(operation);
		if (operationCalls == null || operationCalls.isEmpty()) {
			return 0;
		}
		if (parameters == null || parameters.isEmpty()) {
			return operationCalls.size();
		}
		return getCallCountForParams(operationCalls, parameters);
	}

	public void mockReturnValue(String operation, List<Object> params, Object value) {
		mockReturn.put(operation, params, value);
	}

	public void reset() {
		mockReturn = new MockReturnMap();
		verifyCalls = ArrayListMultimap.create();
	}

	protected int getCallCountForParams(Collection<List<Object>> calledParameters, List<Object> parameters) {
		int times = 0;
		for (List<Object> params : calledParameters) {
			if (params.equals(parameters)) {
				times++;
			}
		}
		return times;
	}

	protected static class MockReturnMap {
		Map<String, Map<List<Object>, Object>> mockReturn;

		public MockReturnMap() {
			mockReturn = new HashMap<>();
		}

		public void put(String name, List<Object> args, Object value) {
			if (!mockReturn.containsKey(name) || args.isEmpty()) {
				Map<List<Object>, Object> map = new HashMap<>();
				map.put(args, value);
				mockReturn.put(name, map);
			} else {
				Map<List<Object>, Object> map = mockReturn.get(name);
				map.put(args, value);
			}
		}

		public Object get(String name, List<Object> args) {
			if (mockReturn.containsKey(name)) {
				Map<List<Object>, Object> resultMap = mockReturn.get(name);
				if (resultMap.containsKey(args)) {
					return resultMap.get(args);
				} else {
					return resultMap.get(Collections.emptyList());
				}
			} else {
				return null;
			}
		}

	}
}
