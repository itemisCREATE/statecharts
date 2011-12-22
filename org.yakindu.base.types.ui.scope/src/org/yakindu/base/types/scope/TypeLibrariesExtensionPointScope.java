package org.yakindu.base.types.scope;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.yakindu.base.types.Library;
import org.yakindu.base.types.Type;

import com.google.common.collect.Sets;

public class TypeLibrariesExtensionPointScope extends AbstractScope {

	private final TypeLibraryLocation locationData;

	private Library loadedModel;

	private final XtextResourceSetProvider resourceSetProvider;

	private final IQualifiedNameProvider qualifiedNameProvider;

	protected TypeLibrariesExtensionPointScope(IScope parent,
			TypeLibraryLocation locationData,
			XtextResourceSetProvider resourceSetProvider,
			IQualifiedNameProvider qualifiedNameProvider) {
		super(parent, false);
		this.locationData = locationData;
		this.resourceSetProvider = resourceSetProvider;
		this.qualifiedNameProvider = qualifiedNameProvider;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		if (locationData.getContainedDescriptionNames() == null
				|| loadedModel == null) {
			loadDefinitions();
		}
		Iterable<IEObjectDescription> iterable = Scopes.scopedElementsFor(
				loadedModel.getTypes(), qualifiedNameProvider);
		return iterable;
	}

	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByName(
			QualifiedName name) {
		if (locationData.getContainedDescriptionNames() == null) {
			loadDefinitions();
		}
		if (locationData.getContainedDescriptionNames().contains(name))
			return super.getLocalElementsByName(name);
		return Collections.emptyList();
	}

	protected void loadDefinitions() {
		XtextResourceSet resourceSet = (XtextResourceSet) resourceSetProvider
				.get(null);
		resourceSet.setClasspathURIContext(locationData.getBundle());
		URI uri = locationData.getLocation();
		Resource resource = (Resource) resourceSet.getResource(uri, true);
		if (resource != null && !resource.getContents().isEmpty()) {
			loadedModel = (Library) resource.getContents().get(0);
			if (locationData.getContainedDescriptionNames() == null) {
				Set<QualifiedName> names = Sets.newHashSet();
				for (Type type : loadedModel.getTypes()) {
					QualifiedName name = qualifiedNameProvider
							.getFullyQualifiedName(type);
					if (name != null)
						names.add(name);
				}
				locationData.setContainedDescriptionNames(names);
			}
		} else {
			locationData.setContainedDescriptionNames(Collections
					.<QualifiedName> emptySet());
		}
	}
}