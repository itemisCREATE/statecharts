/**
* Copyright (c) 2017 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	Johannes Dicks - itemis AG
*
*/
package org.yakindu.sct.generator.builder.resources;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.generic.GenericResourceServiceProvider;

import com.google.inject.Inject;

/**
 * @author johannes dicks - Initial contribution and API
 * 
 */
public class BlackListableResourceServiceProvider extends GenericResourceServiceProvider {


	@Inject
	private DefaultResourceBlacklist blacklist;

	@Override
	public boolean canHandle(URI uri) {
		IFile file = toFile(uri);
		if(file == null)
			return false;
		IProject project = file.getProject();

		if (blacklist.violates(file, project)) {
			return false;
		}
		return super.canHandle(uri);
	}

	public static IFile toFile(URI uri) {
		if (uri.isPlatformResource()) {
			String platformString = uri.toPlatformString(true);
			return (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
		}
		return null;
	}

}
