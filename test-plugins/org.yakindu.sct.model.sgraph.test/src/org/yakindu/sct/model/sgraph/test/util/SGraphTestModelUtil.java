package org.yakindu.sct.model.sgraph.test.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;

public final class SGraphTestModelUtil {

	private static final String TESTMODEL_DIR = "org.yakindu.sct.model.sgraph.test/testmodels/";

	private SGraphTestModelUtil() {
	}

	public static final Statechart loadStatechart(URI uri) {
		// Initialize the model
		SGraphPackage.eINSTANCE.eClass();
		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Get the resource
		Resource resource = resSet.getResource(uri, true);
		// Get the first model element and cast it to the right type
		Statechart statechart = (Statechart) resource.getContents().get(0);
		return statechart;
	}

	public static final Statechart loadStatechart(String filename) {
		return loadStatechart(URI.createPlatformPluginURI(TESTMODEL_DIR + filename, true));
	}
}
