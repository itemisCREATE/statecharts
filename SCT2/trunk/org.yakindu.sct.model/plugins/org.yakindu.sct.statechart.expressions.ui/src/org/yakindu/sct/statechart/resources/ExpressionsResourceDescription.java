package org.yakindu.sct.statechart.resources;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.yakindu.model.sct.statechart.NamedElement;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 
 * @author andreas.muelder@itemis.de
 * 
 */
public class ExpressionsResourceDescription extends AbstractResourceDescription
		implements IResourceDescription {

	private final Resource resource;

	private final URI uri;

	public ExpressionsResourceDescription(Resource resource) {
		System.out.println("ResourceDescriptions " + resource);
		this.resource = resource;
		this.uri = getNormalizedURI(resource);
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		Iterator<EObject> contents = resource.getAllContents();
		List<IEObjectDescription> result = Lists.newArrayList();
		Map<String, String> userData = new HashMap<String, String>();
		while (contents.hasNext()) {
			EObject eObject = contents.next();
			if (eObject instanceof NamedElement) {
				String name = ((NamedElement) eObject).getName();
				if (name != null)
					result.add(new EObjectDescription(name, eObject, userData));
			}
		}
		return result;
	}

	public Iterable<String> getImportedNames() {
		return Iterables.emptyIterable();
	}

	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return Iterables.emptyIterable();
	}

	public URI getURI() {
		return uri;
	}

}
