package org.yakindu.sct.domain.extension;

import com.google.inject.Module;

public interface IModuleProvider {

	public Module getModule(String ...options);
	
}
