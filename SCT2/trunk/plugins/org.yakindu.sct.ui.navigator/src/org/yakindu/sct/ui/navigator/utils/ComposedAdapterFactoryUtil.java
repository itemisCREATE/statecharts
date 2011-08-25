package org.yakindu.sct.ui.navigator.utils;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.yakindu.sct.model.sgraph.provider.SGraphItemProviderAdapterFactory;
import org.yakindu.sct.model.sgraph.util.SGraphAdapterFactory;
import org.yakindu.sct.model.stext.stext.util.StextAdapterFactory;

public class ComposedAdapterFactoryUtil {

	public static final ComposedAdapterFactory FACTORY;
	static {
		FACTORY = new ComposedAdapterFactory();
		FACTORY.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		FACTORY.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		FACTORY.addAdapterFactory(new SGraphAdapterFactory());
		FACTORY.addAdapterFactory(new StextAdapterFactory());
		FACTORY.addAdapterFactory(new SGraphItemProviderAdapterFactory());

	}
}
