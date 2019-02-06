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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.operations.InstallOperation;
import org.eclipse.equinox.p2.operations.OperationFactory;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.IRepositoryManager;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.eclipse.equinox.p2.ui.ProvisioningUI;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.yakindu.sct.ui.UIPluginActivator;

import com.google.common.collect.Sets;

/**
 * 
 * Convenience class to open the "Install New Software.." wizard with preselected features to be installed.
 * 
 * @author Thomas Kutz - Initial API and contribution
 *
 */
public class InstallWizardOpener {
	
	public void open(Map<String, Set<String>> features, IProgressMonitor monitor) {
		try {
			IMetadataRepositoryManager manager = getRepoManager();
			
			Set<IInstallableUnit> units = collectIUs(features, manager, monitor);
			if (monitor.isCanceled()) return;
			
			List<URI> knownRepos = Arrays.asList(manager.getKnownRepositories(IRepositoryManager.REPOSITORIES_ALL));
			InstallOperation op = new OperationFactory().createInstallOperation(units, knownRepos, monitor);
			
			open(units, op);
			
		} catch (ProvisionException e) {
			e.printStackTrace();
		}
	}

	protected Set<IInstallableUnit> collectIUs(Map<String, Set<String>> features,
			IMetadataRepositoryManager manager, IProgressMonitor monitor) {
		
		Set<IInstallableUnit> units = Sets.newHashSet();
		for (Map.Entry<String, Set<String>> entry : features.entrySet()) {
			if (monitor.isCanceled()) {
				return units;
			}
			manager.addRepository(URI.create(entry.getKey()));
			
			for (String featureId : entry.getValue()) {
				units.addAll(
						manager.query(QueryUtil.createLatestQuery(QueryUtil.createIUQuery(featureId)), monitor).toUnmodifiableSet());
			}
			if (entry.getValue().isEmpty()) {
				units.addAll(
						manager.query(QueryUtil.createIUGroupQuery(), monitor).toUnmodifiableSet());
			}
		}
		return units;
	}

	protected IMetadataRepositoryManager getRepoManager() throws ProvisionException {
		return (IMetadataRepositoryManager) getProvisioningAgent().getService(IMetadataRepositoryManager.SERVICE_NAME);
	}

	protected void open(Set<IInstallableUnit> units, InstallOperation op) {
		Display.getDefault().asyncExec(() -> {
			ProvisioningUI.getDefaultUI().openInstallWizard(units, op, null);
		});
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
