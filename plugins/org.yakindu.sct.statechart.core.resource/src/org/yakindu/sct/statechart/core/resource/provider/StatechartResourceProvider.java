package org.yakindu.sct.statechart.core.resource.provider;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;

/**
 * 
 * @author andreas muelder
 * 
 */
public class StatechartResourceProvider extends
DefaultResourceServiceProvider implements IResourceServiceProvider {

	@Override
	public IResourceDescription.Manager getResourceDescriptionManager() {
		return new DefaultResourceDescriptionManager() {
			public IResourceDescription getResourceDescription(Resource resource) {
				return new StatechartResourceDescription(resource);
			}
		};
	}

	@Override
	public boolean canHandle(URI uri) {
		return uri.fileExtension().endsWith("sct");
	}

}
