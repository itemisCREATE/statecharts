package org.yakindu.sct.model.sgraph.test;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.Constants;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGraphTestModule implements Module {

	public void configure(Binder binder) {
		binder.bind(String.class)
				.annotatedWith(Names.named(Constants.LANGUAGE_NAME))
				.toInstance("org.yakindu.sct.model.sgraph");
		binder.bind(EValidator.Registry.class).toInstance(
				EValidator.Registry.INSTANCE);
	}

}
