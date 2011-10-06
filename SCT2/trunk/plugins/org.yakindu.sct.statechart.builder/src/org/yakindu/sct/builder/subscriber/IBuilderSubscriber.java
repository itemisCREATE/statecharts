package org.yakindu.sct.builder.subscriber;

import java.io.IOException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IBuilderSubscriber {

	public void doBuild(IResource resource) throws IOException, CoreException;

}
