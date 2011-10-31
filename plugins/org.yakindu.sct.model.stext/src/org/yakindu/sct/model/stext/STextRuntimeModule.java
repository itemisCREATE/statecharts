package org.yakindu.sct.model.stext;

import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
import org.yakindu.sct.model.stext.scoping.NamespaceLocalScopeResolver;

import com.google.inject.Binder;
import com.google.inject.name.Names;

import de.itemis.xtext.utils.gmf.resource.InjectMembersLazyLinker;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class STextRuntimeModule extends org.yakindu.sct.model.stext.AbstractSTextRuntimeModule {
	
	@Override
	public Class<? extends ILinker> bindILinker() {
		return InjectMembersLazyLinker.class;
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return StextNameProvider.class;
	}

	// contributed by
	// org.eclipse.xtext.generator.scoping.AbstractScopingFragment
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class)
				.annotatedWith(
						Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
				.to(NamespaceLocalScopeResolver.class);
	}

}

