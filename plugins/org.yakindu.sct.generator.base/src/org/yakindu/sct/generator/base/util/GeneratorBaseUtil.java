package org.yakindu.sct.generator.base.util;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class GeneratorBaseUtil {

	/**
	 * Loads a {@link Statechart} model via the registered resource for a given
	 * {@link URI}
	 */
	public static Statechart loadStatechart(IResource resource)
			throws IOException {
		URI uri = URI.createPlatformResourceURI(resource.getFullPath()
				.toString(), true);
		return loadStatechart(uri);
	}

	/**
	 * Loads a {@link Statechart} model via the registered resource for a given
	 * {@link URI}
	 */
	public static Statechart loadStatechart(URI uri) {
		Resource resource = loadResource(uri);
		Statechart statechart = (Statechart) resource.getContents().get(0);
		Assert.isNotNull(statechart);
		return statechart;
	}

	public static Resource loadResource(URI uri) {
		Factory factory = ResourceFactoryRegistryImpl.INSTANCE.getFactory(uri);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = factory.createResource(uri);
		resourceSet.getResources().add(resource);
		try {
			resource.load(Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return resource;
	}

	/**
	 * Transforms the {@link Statechart} model to a {@link ExecutionFlow} model
	 */
	public static ExecutionFlow createExecutionFlowModel(Statechart statechart) {
		Injector injector = Guice.createInjector(new SequencerModule());
		ModelSequencer sequencer = injector.getInstance(ModelSequencer.class);
		ExecutionFlow flow = sequencer.transform(statechart);
		Assert.isNotNull(flow);
		return flow;
	}
}
