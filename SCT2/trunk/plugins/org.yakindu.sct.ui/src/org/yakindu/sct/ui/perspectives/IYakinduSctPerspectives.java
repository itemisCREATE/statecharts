package org.yakindu.sct.ui.perspectives;

import org.yakindu.sct.ui.UIPluginActivator;

/**
 * Ids for the YAKINDU statechart editor perspectives.
 * <p>
 * This interface contains constants only; it is not intended to be implemented
 * or extended.
 */
public interface IYakinduSctPerspectives {

	public final static String ID_PERSPECTIVE_SCT_MODELING = UIPluginActivator.PLUGIN_ID
			+ "." + "ModelingPerspective";
	public final static String ID_PERSPECTIVE_SCT_SIMULATION = UIPluginActivator.PLUGIN_ID
			+ "." + "SimulationPerspective";
}
