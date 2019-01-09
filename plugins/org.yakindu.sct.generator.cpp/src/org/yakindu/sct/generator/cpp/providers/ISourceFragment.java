package org.yakindu.sct.generator.cpp.providers;

import org.yakindu.sct.generator.c.IGenArtifactConfigurations;
import org.yakindu.sct.model.sexec.ExecutionFlow;

public interface ISourceFragment {
	/** The content of the fragment */
	public CharSequence get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs);

	/** Only use this fragment when this method returns true. */
	public default boolean isNeeded(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		return true;
	}
	
	/**
	 * If the method <code>isNeeded</code> returns <code>true</code>, the return
	 * value of this method should not be used / bound.
	 */
	public default Class<? extends ISourceFragment> replaces(ExecutionFlow it,
			IGenArtifactConfigurations artifactConfigs) {
		return null;
	}

	/**
	 * The priority of this fragment. Lower values mean this fragment will be
	 * generated before those with higher values. Default is 0.
	 * 
	 * @param config
	 * @param flow
	 */
	public default int orderPriority(ExecutionFlow flow, IGenArtifactConfigurations config) {
		return 0;
	}
}
