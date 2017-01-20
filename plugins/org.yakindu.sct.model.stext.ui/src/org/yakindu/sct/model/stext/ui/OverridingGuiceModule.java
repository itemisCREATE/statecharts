/** 
 * Copyright (c) 2017 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.stext.ui;

import org.eclipse.xtext.resource.clustering.DynamicResourceClusteringPolicy;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;

import com.google.inject.Binder;
import com.google.inject.Module;

@SuppressWarnings("restriction")
public class OverridingGuiceModule implements Module {
	@Override
	public void configure(Binder binder) {
		binder.bind(IResourceClusteringPolicy.class).to(DynamicResourceClusteringPolicy.class);
	}
}