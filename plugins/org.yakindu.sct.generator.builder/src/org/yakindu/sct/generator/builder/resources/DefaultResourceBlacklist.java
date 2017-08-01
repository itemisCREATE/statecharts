/**
* Copyright (c) 2017 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
*  Johannes Dicks - itemis AG
*
*/
package org.yakindu.sct.generator.builder.resources;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.osgi.service.prefs.BackingStoreException;

import com.google.common.collect.Lists;

/**
 * @author johannes dicks - Initial contribution and API
 * 
 */
public class DefaultResourceBlacklist {
	private static final String SCT_BLACKLIST_DEFAULT = "";
	public static final String SCT_RESOURCE_NODE = "sct.resource";
	public static final String SCT_BLACKLIST_KEY = "blacklist";
	public static final String SCT_BLACKLIST_SEPERATOR = ",";

	public List<IResource> getValues(IProject project) {
		List<IResource> result = Lists.newArrayList();
		String string = getPersistentValues(project);
		String[] segments = string.split(SCT_BLACKLIST_SEPERATOR);
		for (String segment : segments) {
			if (!segment.isEmpty()) {
				IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(Path.fromPortableString(segment),
						true);
				if (resource != null && resource.exists()) {
					result.add(resource);
				}
			}
		}
		return result;

	}

	protected String getPersistentValues(IProject project) {
		IScopeContext projectScope = getPreferenceScope(project);
		IEclipsePreferences node = projectScope.getNode(SCT_RESOURCE_NODE);

		String string = node.get(SCT_BLACKLIST_KEY, SCT_BLACKLIST_DEFAULT);
		return string;
	}

	protected ProjectScope getPreferenceScope(IProject project) {
		return new ProjectScope(project);
	}

	public boolean violates(IResource resource, IProject project) {
		for (IResource blacklistItem : getValues(project)) {
			String fileName = resource.getFullPath().toString();
			if (fileName.contains(blacklistItem.getFullPath().toPortableString())) {
					return true;
				}
		}
		return false;
	}

	public boolean save(IProject project, List<IResource> items) {
		ProjectScope projectScope = getPreferenceScope(project);
		IEclipsePreferences node = projectScope.getNode(SCT_RESOURCE_NODE);

		String blacklist = getBlacklistValue(items);
		node.put(SCT_BLACKLIST_KEY, blacklist);
		try {
			node.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	protected String getBlacklistValue(List<IResource> items) {
		String blacklist = SCT_BLACKLIST_DEFAULT;
		for (IResource item : items) {
			blacklist += item.getFullPath().toPortableString() + SCT_BLACKLIST_SEPERATOR;
		}
		return blacklist;
	}
}
