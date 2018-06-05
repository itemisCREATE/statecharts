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

import static java.util.Arrays.asList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.yakindu.base.expressions.interpreter.IOperationMockup;
import org.yakindu.base.types.Operation;

import com.google.inject.Singleton;

/**
 * 
 * @author jonathan thoene - Initial contribution and API
 * 
 */
@Singleton
public class DefaultOperationMockup implements IOperationMockup {
	
	protected MockReturnMap mockReturn = new MockReturnMap();
	protected VerifyCallMap verifyCalls = new VerifyCallMap();
	
	@Override
	public boolean canExecute(Operation definition, Object[] parameter) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object execute(Operation definition, Object[] parameter) {
		verifyCalls.put(definition.getName(), asList(parameter));
		return mockReturn.get(definition.getName(), asList(parameter));
	}

	public boolean wasCalled(String operation, List<Object> parameters, int times) {
		Set<List<Object>> calledParameters = verifyCalls.getParams(operation);
		if (calledParameters != null) {
			if (!calledParameters.contains(parameters) && !parameters.isEmpty()) {
				return false;
			} 
		} else {
			return false;
		}
		if (parameters.isEmpty()) {
			if (verifyCalls.getCallCount(operation) < times) {
				return false;
			}
		} else {
			if (verifyCalls.getCallCountForParams(operation, parameters) < times) {
				return false;
			}
		}
		return true;
	}
	
	public void mockReturnValue(String operation, List<Object> params, Object value) {
		mockReturn.put(operation, params, value);
	}
	
	public void reset() {
		mockReturn = new MockReturnMap();
		verifyCalls = new VerifyCallMap();
	}
	
	protected static class VerifyCallMap {
		Map<String, OperationCounter> verifyCalls;

		public VerifyCallMap() {
			verifyCalls = new HashMap<>();
		}

		public void put(String name, List<Object> params) {
			if (verifyCalls.containsKey(name)) {
				if (params == null || params.isEmpty()) {
					verifyCalls.get(name).increaseCallCount();
				} else {
					verifyCalls.get(name).put(params);
				}
			} else {
				if (params == null || params.isEmpty()) {
					verifyCalls.put(name, new OperationCounter());
				} else {
					verifyCalls.put(name, new OperationCounter(params));
				}
			}
		}

		public Set<List<Object>> getParams(String name) {
			if(verifyCalls.get(name) != null) {
				return verifyCalls.get(name).getParams();
			} else {
				return null;
			}
		}

		public int getCallCount(String name) {
			return verifyCalls.get(name).getCallCount();
		}

		public Integer getCallCountForParams(String name, List<Object> params) {
			return verifyCalls.get(name).getCallCountForParams(params);
		}
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
	protected static class OperationCounter {

		int callCount;
		Map<List<Object>, Integer> paramCounter = new HashMap<>();

		public OperationCounter() {
			callCount = 1;
		}

		public OperationCounter(List<Object> params) {
			callCount = 1;
			put(params);
		}

		public void put(List<Object> params) {
			callCount++;
			if (paramCounter.containsKey(params)) {
				paramCounter.put(params, paramCounter.get(params) + 1);
			} else {
				paramCounter.put(params, 1);
			}
		}

		public Integer getCallCountForParams(List<Object> params) {
			return paramCounter.get(params);
		}

		public Set<List<Object>> getParams() {
			return paramCounter.keySet();
		}

		public int getCallCount() {
			return callCount;
		}

		public void increaseCallCount() {
			callCount++;
		}
	}
}
