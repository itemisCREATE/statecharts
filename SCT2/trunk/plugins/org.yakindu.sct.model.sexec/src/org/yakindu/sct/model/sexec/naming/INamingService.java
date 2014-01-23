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
}
