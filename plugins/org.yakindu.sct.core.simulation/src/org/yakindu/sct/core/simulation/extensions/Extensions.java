package org.yakindu.sct.core.simulation.extensions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * 
 * @author andreas muelder
 * 
 */
public class Extensions<T> {

	private String extensionPointId;

	public Extensions(String extensionPointId) {
		this.extensionPointId = extensionPointId;
	}

	public T getFirstExtension() {
		return getExtensions().get(0);
	}

	public List<T> getExtensions() {
		List<T> extensions = loadRegisteredProvider();
		if (extensions.size() == 0)
			throw new IllegalStateException(
					"No extensions registered for extension point"
							+ extensionPointId);
		return extensions;
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
