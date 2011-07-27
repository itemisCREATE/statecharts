package org.yakindu.sct.model.stext;

import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.scoping.impl.ResourceSetGlobalScopeProvider;

import de.itemis.xtext.utils.gmf.resource.InjectMembersLazyLinker;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class STextRuntimeModule extends org.yakindu.sct.model.stext.AbstractSTextRuntimeModule {

	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		super.bindIGlobalScopeProvider();
		return ResourceSetGlobalScopeProvider.class;
	}
	
	@Override
	public Class<? extends ILinker> bindILinker() {
		return InjectMembersLazyLinker.class;
	}
}

