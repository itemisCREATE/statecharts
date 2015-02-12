/**
 * Copyright (c) 2015 committers of YAKimport org.eclipse.xtext.service.AbstractGenericModule;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.DefaultTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer;
rs of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.domain.default_.modules;

import org.eclipse.xtext.service.AbstractGenericModule;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.DefaultTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DefaultTypeSystemModule extends AbstractGenericModule {

	public Class<? extends ITypeSystem> bindITypeSystem() {
		return DefaultTypeSystem.class;
	}

	public Class<? extends ITypeSystemInferrer> bindITypeSystemInferrer() {
		return STextTypeInferrer.class;
	}

}
