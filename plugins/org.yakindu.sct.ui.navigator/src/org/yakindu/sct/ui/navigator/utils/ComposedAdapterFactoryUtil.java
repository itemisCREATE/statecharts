package org.yakindu.sct.ui.navigator.utils;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

public class ComposedAdapterFactoryUtil {

	public static final ComposedAdapterFactory FACTORY;
	static {
		FACTORY = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		// FACTORY.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		// FACTORY.addAdapterFactory(new
		// ReflectiveItemProviderAdapterFactory());

		// FACTORY.addAdapterFactory(new SGraphItemProviderAdapterFactory());

	}

}
