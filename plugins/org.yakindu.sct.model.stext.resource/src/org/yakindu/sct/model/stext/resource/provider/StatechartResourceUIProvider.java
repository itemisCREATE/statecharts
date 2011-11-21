/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.resource.provider;

import org.eclipse.xtext.ui.resource.DefaultResourceUIServiceProvider;
import org.yakindu.sct.model.sgraph.resource.provider.StatechartResourceProvider;

import com.google.inject.Inject;

/**
 * 
 * @author benjamin.schwertfeger@itemis.de
 * 
 */
public class StatechartResourceUIProvider extends
		DefaultResourceUIServiceProvider {

	@Inject
	public StatechartResourceUIProvider(
			StatechartResourceProvider runtimeDelegate) {
		super(runtimeDelegate);
	}
}
