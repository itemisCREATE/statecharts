/**
 * Copyright (c) 2013-2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sexec.interpreter;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.yakindu.base.expressions.expressions.ArgumentExpression;
import org.yakindu.base.expressions.interpreter.AbstractOperationExecutor;
import org.yakindu.base.expressions.interpreter.IExecutionSlotResolver;
import org.yakindu.base.expressions.interpreter.IOperationExecutor;
import org.yakindu.base.types.Operation;
import org.yakindu.sct.commons.WorkspaceClassLoaderFactory;
import org.yakindu.sct.model.sruntime.ExecutionContext;
import org.yakindu.sct.model.stext.stext.InterfaceScope;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Implementation of {@link IOperationExecutor} interface that delegates
 * simulator operation calls to Java classes. These classes can be specified in
 * the run configuration tab.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
public class JavaOperationMockup extends AbstractOperationExecutor {

	@Inject
	protected IExecutionSlotResolver resolver;

	private List<Object> callbacks = Lists.newArrayList();

	public void initOperationCallbacks(IProject project, String[] classes) {
		callbacks = Lists.newArrayList();

		ClassLoader classLoader = new WorkspaceClassLoaderFactory().createClassLoader(project,
				getClass().getClassLoader());
		try {
			if (classes.length > 0)
				for (String string : classes) {
					string = string.trim();
					if (string.length() == 0)
						continue;
					Class<?> loadClass = classLoader.loadClass(string);
					callbacks.add(loadClass.newInstance());
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean canExecute(ArgumentExpression expression, ExecutionContext context) {
		for (Object callback : callbacks) {
			Class<?> current = callback.getClass();
			while (current != Object.class) {
				Method[] methods = current.getDeclaredMethods();
				for (Method method : methods) {
					if (hasSignatureMatch(getOperation(expression), method)) {
						return true;
					}
				}
				current = current.getSuperclass();
			}
		}

		return false;
	}

	@Override
	public Object execute(ArgumentExpression expression, ExecutionContext context) {
		return execute(expression, context, null);
	}
	
	@Override
	public Object execute(ArgumentExpression expression, ExecutionContext context, List<Object> argValues) {
		Operation definition = getOperation(expression);
		List<Object> targets = callbacks;
		if (definition.eContainer() instanceof InterfaceScope) {
			String className = ((InterfaceScope) definition.eContainer()).getName();
			if (className != null) {
				targets = callbacks.stream().filter(c -> className.equals(c.getClass().getSimpleName()))
						.collect(Collectors.toList());
			}
		}
		PolymorphicDispatcher<Object> dispatcher = new PolymorphicDispatcher<Object>(definition.getName(),
				definition.getParameters().size(), definition.getParameters().size(),
				targets.size() > 0 ? targets : callbacks);
		try {
			return dispatcher.invoke(provideArguments(argValues, expression.getArguments(), context, definition));
		} catch (Exception ex) {
			throw new WrappedException("Error during invocation of operation '" + definition.getName()
					+ "' with params " + definition.getParameters() + " '", ex);
		}
	}

	protected boolean hasSignatureMatch(Operation definition, Method method) {
		if (!definition.getName().equals(method.getName())) {
			return false;
		}

		if (!(definition.getParameters().size() == method.getParameterTypes().length)) {
			return false;
		}

		// TODO: Check parameter types and return type match. For this a
		// JavaTypeChecker should be introduced to get a matching Java type for
		// a YAKINDU Type System type.

		return true;
	}
}
