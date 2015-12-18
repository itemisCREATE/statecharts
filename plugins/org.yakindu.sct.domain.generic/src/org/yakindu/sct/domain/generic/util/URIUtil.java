/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.domain.generic.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class URIUtil {

	public static IFile toFile(URI uri) {
		if (uri.isPlatformResource()) {
			String platformString = uri.toPlatformString(true);
			return (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
		}
		return null;
	}
}
