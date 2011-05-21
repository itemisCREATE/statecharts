package org.yakindu.sct.statechart.core.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.yakindu.sct.statechart.ExpressionsRuntimeModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.itemis.xtext.utils.gmf.resource.InjectMembersResource;

/**
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public class InjectMembersResourceFactory extends XMIResourceFactoryImpl {

	@Override
	public Resource createResource(URI uri) {
		InjectMembersResource resource = new InjectMembersResource(uri);
		System.out.println("Execute factory");
		ExpressionsRuntimeModule module = new ExpressionsRuntimeModule();
		Injector injector = Guice.createInjector(module);
		// Add a Transition service
		TransitionInjectionService transitionService = new TransitionInjectionService();
		injector.injectMembers(transitionService);
		resource.getServices().add(transitionService);
		// Add a State service
		StateInjectionService stateService = new StateInjectionService();
		injector.injectMembers(stateService);
		resource.getServices().add(stateService);
		// Add a Statechart service
		StatechartInjectionService statechartService = new StatechartInjectionService();
		injector.injectMembers(statechartService);
		resource.getServices().add(statechartService);
		return resource;
	}
}
