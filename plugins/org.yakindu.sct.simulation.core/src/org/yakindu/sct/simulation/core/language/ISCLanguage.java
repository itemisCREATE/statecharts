/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.language;

/**
 * Instances of this interface provide meta information about statechart languages and their dependencies.
 * 
 * @author axel terfloth
 */
public interface ISCLanguage {

	/** 
	 * Each statechart language has it's unique id. It is proposed to use fully qualified names.
	 * 
	 * @return
	 */
	String getId();
	
	/**
	 * A language also has a simple name.
	 */
	String getName();
	
	/** 
	 * A statechart language can inherit from another language.
	 * @return
	 */
	String getBaseLanguageId();
}
