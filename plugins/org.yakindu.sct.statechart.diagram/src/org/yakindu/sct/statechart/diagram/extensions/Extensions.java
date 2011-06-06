package org.yakindu.sct.statechart.diagram.extensions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;

/**
 * 
 * @author muelder
 * 
 * @param <T>
 */
public class Extensions<T extends ISCTProvider> {

	private final String extensionPointId;

	public Extensions(String extensionPointId) {
		this.extensionPointId = extensionPointId;
	}

	public T getRegisteredProvider(EObject semanticElement) {
		List<T> loadRegisteredProvider = loadRegisteredProvider();
		for (T t : loadRegisteredProvider) {
			if (t.isProviderFor(semanticElement)) {
				return t;
			}
		}
		throw new IllegalStateException("No provider found for semantic element "
				+ semanticElement);

	}

	public List<T> loadRegisteredProvider() {
		List<T> providers = new ArrayList<T>();
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						extensionPointId);
		for (IConfigurationElement configurationElement : configurationElements) {
			try {
				@SuppressWarnings("unchecked")
				T provider = (T) configurationElement
						.createExecutableExtension("class");
				providers.add(provider);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return providers;
	}
}
