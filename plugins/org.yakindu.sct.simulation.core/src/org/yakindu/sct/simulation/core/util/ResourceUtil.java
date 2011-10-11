package org.yakindu.sct.simulation.core.util;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ResourceUtil {

	public static Resource loadResource(String filename) {
		URI uri = URI.createPlatformResourceURI(filename, true);
		Factory factory = ResourceFactoryRegistryImpl.INSTANCE.getFactory(uri);
		Resource resource = factory.createResource(uri);
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResources().add(resource);
		try {
			resource.load(Collections.EMPTY_MAP);
			return resource;
		} catch (IOException e) {
			throw new IllegalStateException("Error loading resource", e);
		}
	}

	public static Statechart loadStatechart(String filename) {
		Resource resource = loadResource(filename);
		Statechart statechart = (Statechart) EcoreUtil.getObjectByType(
				resource.getContents(), SGraphPackage.Literals.STATECHART);
		return statechart;
	}

}
