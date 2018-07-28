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
package org.yakindu.sct.generator.genmodel.scoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 
 * @author kutz - Initial contribution and API
 *
 */
public class SGenGlobalScopeProvider extends DefaultGlobalScopeProvider {
	
	/**
	 * Overidden to avoid scope nesting which comes with shadowing problems when
	 * potential elements in scope have the same name
	 */
	@Override
	protected IScope getScope(IScope parent, final Resource context, boolean ignoreCase, EClass type, Predicate<IEObjectDescription> filter) {
		IScope result = parent;
		if (context == null || context.getResourceSet() == null)
			return result;
		List<IContainer> containers = Lists.newArrayList(getVisibleContainers(context));
		Collections.reverse(containers);
		List<IEObjectDescription> objectDescriptions = new ArrayList<IEObjectDescription>();
		Iterator<IContainer> iter = containers.iterator();
		while (iter.hasNext()) {
			IContainer container = iter.next();
			result = createContainerScopeWithContext(context, IScope.NULLSCOPE, container, filter, type, ignoreCase);
			Iterables.addAll(objectDescriptions, result.getAllElements());
		}
		return new SimpleScope(objectDescriptions);
	}
}
