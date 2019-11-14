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
import java.util.Collections;
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

import com.google.common.collect.Lists;
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

	private static final String WILDCARD = "*";
	
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
	/**
	 * 
	 * This also adds all new repositories listed in feature map to the known repositories
	 */
	protected Set<IInstallableUnit> collectIUs(Map<String, Set<String>> features, IMetadataRepositoryManager manager,
			IProgressMonitor monitor) {

		Set<IInstallableUnit> units = Sets.newHashSet();
		for (Map.Entry<String, Set<String>> entry : features.entrySet()) {
			try {
				if (monitor.isCanceled()) {
					return units;
				}
				List<IMetadataRepository> repos = Lists.newArrayList();
				if (entry.getKey().equals(WILDCARD)) {
					List<URI> knownRepos = Arrays.asList(manager.getKnownRepositories(IRepositoryManager.REPOSITORIES_ALL));
					for (URI repoUri : knownRepos) {
						repos.add(manager.loadRepository(repoUri, monitor));
					}
				} else {
					repos = Collections.singletonList(manager.loadRepository(URI.create(entry.getKey()), monitor));
				}
				
				for (String featureId : entry.getValue()) {
					for (IMetadataRepository repo : repos) {
						Set<IInstallableUnit> unmodifiableSet = repo.query(QueryUtil.createLatestQuery(QueryUtil.createIUQuery(featureId)), monitor).toUnmodifiableSet();
						units.addAll(unmodifiableSet);
					}
				}
				
				if (entry.getValue().isEmpty()) {
					for (IMetadataRepository repo : repos) {
						units.addAll(repo.query(QueryUtil.createIUGroupQuery(), monitor).toUnmodifiableSet());
					}
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
