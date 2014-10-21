/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sexec.interpreter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.types.Operation;
import org.yakindu.sct.commons.WorkspaceClassLoaderFactory;
import org.yakindu.sct.simulation.core.sexec.launch.ISCTLaunchParameters;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.ExecutionSlot;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Implementation of {@link IOperationMockup} interface that delegates simulator
 * operation calls to Java classes. These classes can be specified in the run
 * configuration tab.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class JavaOperationMockup implements IOperationMockup {

	@Inject(optional = true)
	private ILaunch launch;

	@Inject
	protected IExecutionSlotResolver resolver;

	private List<Object> callbacks;

	private void initOperationCallbacks() {
		callbacks = Lists.newArrayList();
		if (launch == null)
			return;
		
		IFile file = WorkspaceSynchronizer.getFile(((EObject) launch.getDebugTarget().getAdapter(EObject.class))
				.eResource());
		ClassLoader classLoader = new WorkspaceClassLoaderFactory().createClassLoader(file.getProject(), getClass()
				.getClassLoader());
		ILaunchConfiguration config = launch.getLaunchConfiguration();
		try {
			String classes = config.getAttribute(ISCTLaunchParameters.OPERATION_CLASS, "");
			String[] split = classes.split(",");
			if (split.length > 0)
				for (String string : split) {
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
	public boolean canExecute(Operation definition, Object[] parameter) {
		if (callbacks == null)
			initOperationCallbacks();
		// TODO: Check if there is a operation in the callbacks for the given
		// signature
		return callbacks.size() > 0;
	}

	public Object execute(Operation definition, Object[] parameter) {
		PolymorphicDispatcher<Object> dispatcher = new PolymorphicDispatcher<Object>(definition.getName(), definition
				.getParameters().size(), definition.getParameters().size(), callbacks);
		try {
			return dispatcher.invoke(parameter);
		} catch (WrappedException e) {
			throw e;
		} catch (Exception ex) {
			throw new WrappedException("Error during invocation of operation '" + definition.getName()
					+ "' with params " + definition.getParameters() + " '", ex);
		}
	}

	@Override
	public boolean canExecute(FeatureCall call, Object[] parameter) {
		ExecutionContext context = (ExecutionContext) launch.getDebugTarget().getAdapter(ExecutionContext.class);
		ExecutionSlot variable = resolver.resolve(context, call);
		if (variable != null)
			return true;
		return false;

	}

	@Override
	public Object execute(FeatureCall call, Object[] parameter) {
		Operation operation = (Operation) call.getFeature();
		ExecutionContext context = (ExecutionContext) launch.getDebugTarget().getAdapter(ExecutionContext.class);
		ExecutionSlot variable = resolver.resolve(context, call);
		PolymorphicDispatcher<Object> dispatcher = new PolymorphicDispatcher<Object>(operation.getName(), operation
				.getParameters().size(), operation.getParameters().size(), Collections.singletonList(variable
				.getValue()));
		try {
			return dispatcher.invoke(parameter);
		} catch (Exception ex) {
			System.err.println("Error invoking operation " + operation.getName() + " with parameters  "
					+ Arrays.toString(parameter));
			ex.printStackTrace();
			return null;
		}
	}
}
