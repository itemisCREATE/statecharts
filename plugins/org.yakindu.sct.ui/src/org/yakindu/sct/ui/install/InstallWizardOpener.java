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

import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.operations.InstallOperation;
import org.eclipse.equinox.p2.operations.OperationFactory;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.eclipse.equinox.p2.ui.ProvisioningUI;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.yakindu.sct.ui.UIPluginActivator;

/**
 * 
 * Convenience class to open the "Install New Software.." wizard with predefined
 * repository and selected features.
 * 
 * @author Thomas Kutz - Initial API and contribution
 *
 */
public class InstallWizardOpener {

	public void openInstallWizard(String repoURI, String... featureIds) {
		try {
			URI uri = URI.create(repoURI);
			IProvisioningAgent agent = getProvisioningAgent();
			IMetadataRepositoryManager manager = (IMetadataRepositoryManager) agent
					.getService(IMetadataRepositoryManager.SERVICE_NAME);
			IMetadataRepository repo = manager.loadRepository(uri, new NullProgressMonitor());

			Set<IInstallableUnit> selectedUnits = new HashSet<>();
			for (String featureId : featureIds) {
				selectedUnits.addAll(
						repo.query(QueryUtil.createIUQuery(featureId), new NullProgressMonitor()).toUnmodifiableSet());
			}
			if (featureIds.length == 0) {
				selectedUnits.addAll(
						repo.query(QueryUtil.createIUGroupQuery(), new NullProgressMonitor()).toUnmodifiableSet());
			}

			InstallOperation op = new OperationFactory().createInstallOperation(Collections.emptyList(),
					Collections.singletonList(uri), new NullProgressMonitor());

			ProvisioningUI.getDefaultUI().openInstallWizard(selectedUnits, op, null);
		} catch (ProvisionException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected IProvisioningAgent getProvisioningAgent() throws ProvisionException {
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
