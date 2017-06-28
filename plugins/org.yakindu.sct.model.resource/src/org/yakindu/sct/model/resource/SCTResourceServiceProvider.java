/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.resource;

import org.eclipse.xtext.resource.generic.GenericResourceServiceProvider;
import org.eclipse.xtext.ui.markers.IMarkerContributor;
import org.eclipse.xtext.ui.tasks.TaskMarkerContributor;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * 
 * @author Johannes Dicks - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SCTResourceServiceProvider extends GenericResourceServiceProvider {

	@Inject
	Injector injector;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Class<T> t) {
		T implementer = super.get(t);
		if (implementer == null) {
			if (t.equals(IMarkerContributor.class)) {
				TaskMarkerContributor taskMarkerContributor = new TaskMarkerContributor();
				injector.injectMembers(taskMarkerContributor);
				implementer = (T) taskMarkerContributor;
			}
		}
		return implementer;
	}

}
