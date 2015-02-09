/*
  Copyright (c) 2014-2015 committers of YAKINDU Statechart Tools.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  
  Contributors:
  	Markus Muelhbrand - Initial contribution
 */

package org.yakindu.sct.model.sexec.naming;

import java.util.Map;

import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author Markus Mühlbrandt
 * 
 */
public interface INamingService {

	/**
	 * Initializes the service.
	 * 
	 * @param statechart
	 */
	void initializeNamingService(Statechart statechart);

	/**
	 * Initializes the service.
	 * 
	 * @param flow
	 */
	void initializeNamingService(ExecutionFlow flow);

	/**
	 * Returns a map which stores a short name (value) for a NamedElement (key).
	 * 
	 * @param statechart
	 * @return
	 */
	Map<NamedElement, String> getShortNameMap(Statechart statechart);

	/**
	 * Returns a map which stores a short name (value) for a NamedElement (key).
	 * 
	 * @param flow
	 * @return
	 */
	Map<NamedElement, String> getShortNameMap(ExecutionFlow flow);

	/**
	 * Returns a short name for the given element. The naming service has to be
	 * initialized before.
	 * 
	 * @param element
	 * @return
	 */
	String getShortName(NamedElement element);

	/**
	 * Convert string to a valid identifier (e.g. removes blanks and invalid
	 * characters)
	 * 
	 * @param string
	 * @return
	 */
	String asIdentifier(String string);

	/**
	 * If the given string equals a target language keyword it is escaped.
	 * 
	 * @param string
	 * @return
	 */
	String asEscapedIdentifier(String string);

	/**
	 * Checks if the given string is a target language keyword
	 * 
	 * @param string
	 * @return
	 */
	boolean isKeyword(String string);

	/**
	 * Sets the maximum length for shorted names.
	 * 
	 * @param int
	 */
	void setMaxLength(int length);

	/**
	 * Sets the separator for shorted names.
	 * 
	 * @param char
	 */
	void setSeparator(char sep);

	/**
	 * Returns the maximum length of shorted names.
	 * 
	 * @return int
	 */
	int getMaxLength();

	/**
	 * Returns the separator for shorted names.
	 * 
	 * @return char
	 */
	char getSeparator();

}
