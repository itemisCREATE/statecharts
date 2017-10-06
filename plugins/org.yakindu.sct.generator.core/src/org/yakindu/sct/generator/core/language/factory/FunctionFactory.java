/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.language.factory;

import java.util.List;

import org.yakindu.sct.generator.core.language.IFunction;
import org.yakindu.sct.generator.core.language.IModifier;
import org.yakindu.sct.generator.core.language.IParameter;
import org.yakindu.sct.generator.core.language.Parameter;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author rbeckmann
 *
 */
public class FunctionFactory {
	@Inject protected Injector injector;
	protected IParameter defaultParameter;
	
	public IFunction function() {
		IFunction func = injector.getInstance(IFunction.class);
		if(defaultParameter != null) {
			func.getParameters().add(new Parameter(defaultParameter));
		}
		return func;
	}
	
	public IFunction function(CharSequence name) {
		IFunction func = function();
		func.setName(name);
		return func;
	}
	
	public IFunction function(CharSequence name, List<CharSequence> parameters) {
		IFunction func = function(name);
		func.getParameters().addAll(parameters);
		return func;
	}
	
	public IFunction function(CharSequence name, CharSequence content) {
		IFunction func = function(name);
		func.setContent(content);
		return func;
	}
	
	public IFunction function(CharSequence name, List<CharSequence> parameters, List<IModifier> modifiers) {
		IFunction func = function(name, parameters);
		func.getModifiers().addAll(modifiers);
		return func;
	}
	
	public IFunction function(CharSequence name, CharSequence content, 
			List<CharSequence> parameters) {
		IFunction func = function(name, parameters);
		func.setContent(content);
		return func;
	}
	
	public IFunction function(CharSequence name, CharSequence content, 
			List<CharSequence> parameters, List<IModifier> modifiers) {
		IFunction func = function(name, parameters, modifiers);
		func.setContent(content);
		return func;
	}
	
	public void setDefaultParameter(IParameter parameter) {
		this.defaultParameter = parameter;
	}
}
