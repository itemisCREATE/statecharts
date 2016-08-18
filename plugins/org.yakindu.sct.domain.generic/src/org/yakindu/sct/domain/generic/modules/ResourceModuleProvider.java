package org.yakindu.sct.domain.generic.modules;

import org.eclipse.emf.ecore.resource.Resource;
import org.yakindu.sct.domain.extension.IModuleProvider;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.resource.StextResource;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.util.Modules;

public class ResourceModuleProvider implements IModuleProvider {

	@Override
	public Module getModule(String... options) {
		return Modules.combine(new STextRuntimeModule(), new Module() {

			@Override
			public void configure(Binder binder) {
				binder.bind(Resource.class).to(StextResource.class);
			}
		});
	}

}
