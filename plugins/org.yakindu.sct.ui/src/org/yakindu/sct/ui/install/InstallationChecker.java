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

import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.engine.IProfile;
import org.eclipse.equinox.p2.engine.IProfileRegistry;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.query.QueryUtil;

/**
 * 
 * @author Thomas Kutz - Initial API and contribution
 *
 */
public class InstallationChecker {

	private ProvisioningAgentProvider agentProvider = new ProvisioningAgentProvider();

	public boolean isFeatureInstalled(String featureId) {
		try {
			IProvisioningAgent agent = agentProvider.get();
			IProfileRegistry profileRegistry = (IProfileRegistry) agent.getService(IProfileRegistry.SERVICE_NAME);
			IProfile selfProfile = profileRegistry.getProfile(IProfileRegistry.SELF);
			if(selfProfile == null)
				return true;
			Set<IInstallableUnit> installed = selfProfile
					.available(QueryUtil.createIUQuery(featureId), new NullProgressMonitor()).toUnmodifiableSet();
			agent.stop();
			return !installed.isEmpty();
		} catch (ProvisionException e) {
			e.printStackTrace();
		}
		return false;
	}
}
