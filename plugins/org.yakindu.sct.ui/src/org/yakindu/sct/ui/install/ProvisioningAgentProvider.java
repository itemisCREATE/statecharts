/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.ui.install;

import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.yakindu.sct.ui.UIPluginActivator;

/**
 * 
 * @author Thomas Kutz - Initial API and contribution
 *
 */
public class ProvisioningAgentProvider {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IProvisioningAgent get() throws ProvisionException {
		ServiceReference sr = getContext().getServiceReference(IProvisioningAgentProvider.SERVICE_NAME);
		if (sr == null) {
			throw new ProvisionException("No service reference found for " + IProvisioningAgentProvider.SERVICE_NAME);
		}
		IProvisioningAgentProvider agentProvider = (IProvisioningAgentProvider) getContext().getService(sr);
		return agentProvider.createAgent(null);
	}
	
	protected BundleContext getContext() {
		return UIPluginActivator.getDefault().getBundle().getBundleContext();
	}
}
