package org.yakindu.sct.simulation.core.extensions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.simulation.core.ISCTBuilder;

/**
 * 
 * @author andreas muelder
 * 
 */
public class Extensions<T extends ISCTBuilder> {

	private String extensionPointId;

	public Extensions(String extensionPointId) {
		this.extensionPointId = extensionPointId;
	}

	public T getRegisteredProvider(EObject object) {
		List<T> loadRegisteredProvider = loadRegisteredProvider();
		for (T t : loadRegisteredProvider) {
			if (t.isBuilderFor(object)) {
				return t;
			}
		}
		throw new IllegalStateException("No provider found for type" + object);

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
