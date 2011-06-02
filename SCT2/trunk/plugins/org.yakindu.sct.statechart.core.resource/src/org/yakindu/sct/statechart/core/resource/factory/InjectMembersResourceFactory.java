package org.yakindu.sct.statechart.core.resource.factory;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.yakindu.sct.statechart.core.resource.services.StateInjectionService;
import org.yakindu.sct.statechart.core.resource.services.StatechartInjectionService;
import org.yakindu.sct.statechart.core.resource.services.TransitionInjectionService;

import com.google.inject.Inject;

import de.itemis.xtext.utils.gmf.resource.InjectMembersResource;

/**
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public class InjectMembersResourceFactory extends XMIResourceFactoryImpl {

	@Inject
	TransitionInjectionService transitionService;
	@Inject
	StateInjectionService stateService;
	@Inject
	StatechartInjectionService statechartService;

	@Override
	public Resource createResource(URI uri) {
		InjectMembersResource resource = new InjectMembersResource(uri);
		// Add a Transition service
		resource.getServices().add(transitionService);
		// Add a State service
		resource.getServices().add(stateService);
		// Add a Statechart service
		resource.getServices().add(statechartService);
		return resource;
	}
}
