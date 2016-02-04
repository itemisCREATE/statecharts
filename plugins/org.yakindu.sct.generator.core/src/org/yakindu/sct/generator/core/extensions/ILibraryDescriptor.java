package org.yakindu.sct.generator.core.extensions;

import org.eclipse.emf.common.util.URI;
import org.yakindu.sct.generator.core.features.IDefaultFeatureValueProvider;

public interface ILibraryDescriptor {

	URI getURI();

	String getLibraryId();

	IDefaultFeatureValueProvider createFeatureValueProvider();

}