package org.yakindu.sct.statechart.resources;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ecore.EcoreResourceServiceProviderImpl;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;

/**
 * 
 * @author andreas.muelder@itemis.de
 * 
 */
public class ExpressionsResourceProvider extends
		EcoreResourceServiceProviderImpl implements IResourceServiceProvider {

	@Override
	public IResourceDescription.Manager getResourceDescriptionManager() {
		return new IResourceDescription.Manager() {

			public boolean isAffected(Collection<Delta> deltas,
					IResourceDescription candidate,
					IResourceDescriptions context)
					throws IllegalArgumentException {
				return false;
			}

			public boolean isAffected(Delta delta,
					IResourceDescription candidate)
					throws IllegalArgumentException {
				return false;
			}

			public IResourceDescription getResourceDescription(Resource resource) {
				return new ExpressionsResourceDescription(resource);
			}
		};
	}

	@Override
	public boolean canHandle(URI uri) {
		return uri.fileExtension().endsWith("sct");
	}

}
