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
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.operations.InstallOperation;
import org.eclipse.equinox.p2.operations.OperationFactory;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.IRepositoryManager;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.eclipse.equinox.p2.ui.ProvisioningUI;
import org.eclipse.swt.widgets.Display;

import com.google.common.collect.Sets;

/**
 * 
 * Convenience class to open the "Install New Software.." wizard with
 * preselected features to be installed.
 * 
 * @author Thomas Kutz - Initial API and contribution
 *
 */
public class InstallWizardOpener {

	private ProvisioningAgentProvider agentProvider = new ProvisioningAgentProvider();

	public void open(Map<String, Set<String>> features, IProgressMonitor monitor) {
		try {
			IProvisioningAgent agent = agentProvider.get();
			IMetadataRepositoryManager manager = (IMetadataRepositoryManager) agent
					.getService(IMetadataRepositoryManager.SERVICE_NAME);

			Set<IInstallableUnit> units = collectIUs(features, manager, monitor);
			if (monitor.isCanceled())
				return;

			List<URI> knownRepos = Arrays.asList(manager.getKnownRepositories(IRepositoryManager.REPOSITORIES_ALL));
			InstallOperation op = new OperationFactory().createInstallOperation(units, knownRepos, monitor);
			agent.stop();

			open(units, op);
		} catch (ProvisionException e) {
			e.printStackTrace();
		}
	}

	protected Set<IInstallableUnit> collectIUs(Map<String, Set<String>> features, IMetadataRepositoryManager manager,
			IProgressMonitor monitor) {

		Set<IInstallableUnit> units = Sets.newHashSet();
		for (Map.Entry<String, Set<String>> entry : features.entrySet()) {
			try {
				if (monitor.isCanceled()) {
					return units;
				}
				IMetadataRepository repo = manager.loadRepository(URI.create(entry.getKey()), monitor);

				for (String featureId : entry.getValue()) {
					units.addAll(repo.query(QueryUtil.createLatestQuery(QueryUtil.createIUQuery(featureId)), monitor)
							.toUnmodifiableSet());
				}
				if (entry.getValue().isEmpty()) {
					units.addAll(repo.query(QueryUtil.createIUGroupQuery(), monitor).toUnmodifiableSet());
				}
			} catch (ProvisionException | OperationCanceledException e) {
				e.printStackTrace();
				continue;
			}
		}
		return units;
	}

	protected void open(Set<IInstallableUnit> units, InstallOperation op) {
		Display.getDefault().asyncExec(() -> {
			ProvisioningUI.getDefaultUI().openInstallWizard(units, op, null);
		});
	}
}
