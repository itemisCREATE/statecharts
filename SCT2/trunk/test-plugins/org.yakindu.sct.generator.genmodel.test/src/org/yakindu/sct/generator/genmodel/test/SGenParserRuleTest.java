/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.test;

import static junit.framework.Assert.fail;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.genmodel.test.util.AbstractSGenTest;
import org.yakindu.sct.generator.genmodel.test.util.SGenInjectorProvider;
import org.yakindu.sct.model.sgen.GeneratorModel;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(SGenInjectorProvider.class)
public class SGenParserRuleTest extends AbstractSGenTest {

	/**
	 * GeneratorModel returns gen::GeneratorModel: 'GeneratorModel' 'for'
	 * generatorId=QID '{' (entries+=GeneratorEntry)* '}';
	 */
	@Test
	public void testGeneratorModel() {
		parseExpression("GeneratorModel for yakindu::java { }", GeneratorModel.class.getSimpleName());
	}

	/**
	 * GeneratorEntry returns gen::GeneratorEntry: contentType=ID
	 * elementRef=[ecore::EObject|QID] '{' (features+=FeatureConfiguration)*
	 * '}';
	 */
	@Test
	public void testGeneratorEntry() {
		fail("Implement me");
	}

	/**
	 * FeatureConfiguration returns gen::FeatureConfiguration:
	 * {gen::FeatureConfiguration} 'feature' type=[gen::FeatureType] '{'
	 * (parameterValues+=FeatureParameterValue)+ '}';
	 */
	@Test
	public void testFeatureConfiguration() {
		fail("Implement me");
	}

	/**
	 * FeatureParameterValue returns gen::FeatureParameterValue:
	 * {gen::FeatureParameterValue} parameter=[gen::FeatureParameter] '='
	 * expression=Literal;
	 */
	@Test
	public void testFeatureParameterValue() {
		fail("Implement me");
	}

}
