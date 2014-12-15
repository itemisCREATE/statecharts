/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types;

import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.inject.ImplementedBy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ImplementedBy(DefaultTypeSystemRegistry.class)
public interface ITypeSystemRegistry {

	public ITypeSystem getTypeSystem(String uriScheme);

	public void addTypeSystem(String uriScheme, ITypeSystem system);

	public void removeTypeSystem(String uriScheme);
	
	public Iterable<ITypeSystem> getAllTypeSystems();
}
