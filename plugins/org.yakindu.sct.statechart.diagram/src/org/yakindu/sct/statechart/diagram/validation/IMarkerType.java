package org.yakindu.sct.statechart.diagram.validation;

import org.yakindu.sct.statechart.diagram.DiagramActivator;

/**
 * 
 * @author Lev0r
 * 
 */
public interface IMarkerType {

	public static final String DIAGRAM_MARKER_TYPE = DiagramActivator.PLUGIN_ID
			+ ".diagnostic";

	public static final String XTEXT_MARKER_TYPE = DiagramActivator.PLUGIN_ID
			+ ".xtext.diagnostic";

}
