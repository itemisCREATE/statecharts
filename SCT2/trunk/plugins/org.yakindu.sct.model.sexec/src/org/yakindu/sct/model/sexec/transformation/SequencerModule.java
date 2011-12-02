package org.yakindu.sct.model.sexec.transformation;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.yakindu.sct.model.sgraph.naming.SGraphNameProvider;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SequencerModule implements Module {

	public void configure(Binder binder) {

		binder.bind(IQualifiedNameProvider.class).to(
				SGraphNameProvider.class);

	}

}
