package org.yakindu.sct.model.stext;

import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.yakindu.base.types.ITypeSystemAccess;
import org.yakindu.base.types.impl.BaseTypeSystemAccessImpl;
import org.yakindu.sct.model.sgraph.resource.SCTLinker;
import org.yakindu.sct.model.stext.conversion.StextValueConverterService;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
import org.yakindu.sct.model.stext.scoping.NamespaceLocalScopeResolver;
import org.yakindu.sct.model.stext.scoping.STextGlobalScopeProvider;
import org.yakindu.sct.model.stext.validation.ITypeInferrer;
import org.yakindu.sct.model.stext.validation.TypeInferrer;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 * 
 * @author andreas muelder
 * @author axel terfloth
 */
public class STextRuntimeModule extends
		org.yakindu.sct.model.stext.AbstractSTextRuntimeModule {

	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return STextGlobalScopeProvider.class;
	}

	@Override
	public Class<? extends ILinker> bindILinker() {
		return SCTLinker.class;
	}
	
	// public Class<? extends LazyURIEncoder> bindLazyURIEncoder() {
	// return SCTLazyURIEncoder.class;
	// }

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return StextNameProvider.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return StextValueConverterService.class;
	}

	public Class<? extends ITypeSystemAccess> bindITypeSystemAccess() {
		return BaseTypeSystemAccessImpl.class;
	}

	public Class<? extends ITypeInferrer> bindITypeInferrer() {
		return TypeInferrer.class;
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
