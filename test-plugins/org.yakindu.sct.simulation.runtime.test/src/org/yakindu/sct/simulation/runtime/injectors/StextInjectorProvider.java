package org.yakindu.sct.simulation.runtime.injectors;

import org.eclipse.xtext.junit.GlobalRegistries;
import org.eclipse.xtext.junit.GlobalRegistries.GlobalStateMemento;
import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.junit4.IRegistryConfigurator;
import org.yakindu.sct.model.stext.STextStandaloneSetup;

import com.google.inject.Injector;

public class StextInjectorProvider implements IInjectorProvider,
		IRegistryConfigurator {
	
	private GlobalStateMemento globalStateMemento;
	private Injector injector;

	static {
		GlobalRegistries.initializeDefaults();
	}

	public Injector getInjector() {
		if (injector == null) {
			this.injector = new STextStandaloneSetup()
					.createInjectorAndDoEMFRegistration();
		}
		return injector;
	}

	public void restoreRegistry() {
		globalStateMemento.restoreGlobalState();
	}

	public void setupRegistry() {
		globalStateMemento = GlobalRegistries.makeCopyOfGlobalState();
	}

}
