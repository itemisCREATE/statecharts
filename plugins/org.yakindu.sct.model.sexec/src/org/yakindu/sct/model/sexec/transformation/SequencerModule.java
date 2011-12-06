package org.yakindu.sct.model.sexec.transformation;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.yakindu.sct.model.sgraph.naming.SGraphNameProvider;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SequencerModule implements Module {

	public static final String ADD_TRACES = "ADD_TRACES";

	public void configure(Binder binder) {
		binder.bind(IQualifiedNameProvider.class).to(SGraphNameProvider.class);
		binder.bind(Boolean.class).annotatedWith(Names.named(ADD_TRACES))
				.toInstance(Boolean.FALSE);
	}

}
