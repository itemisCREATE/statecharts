package de.itemis.xtext.utils.gmf.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;

import com.google.inject.internal.Lists;

/**
 * Implementation of {@link Resource} that handles Xtext mixins.
 * 
 * @author andreas muelder
 * 
 */
public class InjectMembersResource extends GMFResource {

	private static final String INJECT_MEMBERS = "InjectMembers";

	private List<IMemberInjectionService> services;

	public InjectMembersResource(URI uri) {
		super(uri);
		services = Lists.newArrayList();
	}

	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		super.doLoad(inputStream, options);
		TreeIterator<EObject> iter = getAllContents();
		while (iter.hasNext()) {
			EObject currentObject = iter.next();
			EAnnotation eAnnotation = currentObject.eClass().getEAnnotation(
					INJECT_MEMBERS);
			if (eAnnotation != null) {
				IMemberInjectionService service = receiveInjectionService(currentObject);
				reparse(service, currentObject);
			}
		}
	}

	private IMemberInjectionService receiveInjectionService(
			EObject currentObject) {
		// first come first serve
		for (IMemberInjectionService service : services) {
			if (service.isServiceFor(currentObject)) {
				return service;
			}
		}
		throw new IllegalStateException("No service found for object "
				+ currentObject);
	}

	private void reparse(IMemberInjectionService service, EObject currentObject) {
		service.injectMembers(currentObject);
		registerReparseAdapter(service, currentObject);
		List<Diagnostic> errors = service.getErrors();
		getErrors().addAll(errors);
		List<Diagnostic> warnings = service.getWarnings();
		getWarnings().addAll(warnings);
	}

	/**
	 * Adds a reparseAdapter that observes the source feature and reparses the
	 * model element in case of changes.
	 * 
	 * @param object
	 */
	private void registerReparseAdapter(IMemberInjectionService service,
			EObject object) {
		Adapter existingAdapter = EcoreUtil.getExistingAdapter(object,
				ReparseAdapter.class);
		EList<Adapter> eAdapters = object.eAdapters();
		if (existingAdapter == null) {
			eAdapters.add(new ReparseAdapter(object,
					service.getSourceFeature(), service));
		}
	}

	public List<IMemberInjectionService> getServices() {
		return services;
	}

	public void setServices(List<IMemberInjectionService> services) {
		this.services = services;
	}

	/**
	 * ReparseAdapter listens for feature changes and reloads the textual part
	 * 
	 * @author andreas muelder
	 * 
	 */
	private final class ReparseAdapter extends AdapterImpl {
		public final EStructuralFeature expressionFeature;
		private final EObject currentObject;
		private final IMemberInjectionService service;

		private ReparseAdapter(EObject currentObject,
				EStructuralFeature expressionFeature,
				IMemberInjectionService service) {
			this.currentObject = currentObject;
			this.expressionFeature = expressionFeature;
			this.service = service;
		}

		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getFeature() == expressionFeature) {
				reparse(service, currentObject);
			}
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return ReparseAdapter.class == type;
		}

	}

}