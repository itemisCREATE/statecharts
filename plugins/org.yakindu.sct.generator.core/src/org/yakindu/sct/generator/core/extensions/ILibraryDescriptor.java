/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.core.extensions;

import org.eclipse.emf.common.util.URI;
import org.yakindu.sct.generator.core.library.IDefaultFeatureValueProvider;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ILibraryDescriptor {

	URI getURI();

	String getLibraryId();

	IDefaultFeatureValueProvider createFeatureValueProvider();

}