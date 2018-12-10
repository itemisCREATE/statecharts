/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.ui.quickfix;

import java.util.Collections;
import java.util.Optional;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor;
import org.yakindu.sct.generator.core.extensions.ILibraryDescriptor;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions;
import org.yakindu.sct.generator.core.library.IDefaultFeatureValueProvider;
import org.yakindu.sct.generator.genmodel.ui.internal.SGenActivator;
import org.yakindu.sct.generator.genmodel.validation.SGenJavaValidator;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenQuickfixProvider extends DefaultQuickfixProvider {
	
	public static final String CHANGE_DOMAIN_COMMAND = "Domain change command";

	@Fix(SGenJavaValidator.CODE_REQUIRED_FEATURE)
	public void AddRequiredFeature(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add feature " + issue.getData()[0], "Adds the feature " + issue.getData()[0], null,
				new ISemanticModification() {
					public void apply(EObject element, IModificationContext context) throws Exception {
						FeatureConfiguration config = getDefaultFeatureConfiguration(issue, element);
						if (config != null) {
							GeneratorEntry entry = (GeneratorEntry) element;
							entry.getFeatures().add(config);
						}
					}
				});
	}
	
	@Fix(SGenJavaValidator.CODE_REQUIRED_DOMAIN)
	public void changeToValidDomain(final Issue issue, IssueResolutionAcceptor acceptor) {
		String[] validDomains = issue.getData()[0].split(",");
		for(String validDomain : validDomains) {
			addAcceptor(issue, acceptor, validDomain);
		}
	}
	
	private void addAcceptor(final Issue issue, IssueResolutionAcceptor acceptor, String validDomain) {
		acceptor.accept(issue, validDomain, null, null, new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof GeneratorEntry) {
					EObject referencedStatechart = ((GeneratorEntry) element).getElementRef();
					if (referencedStatechart instanceof Statechart) {
						TransactionalEditingDomain sharedDomain = DiagramPartitioningUtil.getSharedDomain();
						DomainChangeCommand refactoringCommand = new DomainChangeCommand(sharedDomain,
								CHANGE_DOMAIN_COMMAND, Collections.EMPTY_LIST, validDomain,
								(Statechart) referencedStatechart);
						try {
							refactoringCommand.execute(new NullProgressMonitor(), null);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}

			}
		});
	}
	
	private FeatureConfiguration getDefaultFeatureConfiguration(final Issue issue, EObject element) {
		GeneratorModel model = (GeneratorModel) EcoreUtil2.getRootContainer(element);

		Optional<IGeneratorDescriptor> generatorDescriptor = GeneratorExtensions.getGeneratorDescriptor(model.getGeneratorId());
		if(!generatorDescriptor.isPresent())
			return null;
		Iterable<ILibraryDescriptor> libraryDescriptor = LibraryExtensions
				.getLibraryDescriptors(generatorDescriptor.get().getLibraryIDs());
		for (ILibraryDescriptor desc : libraryDescriptor) {
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.getResource(desc.getURI(), true);
			FeatureTypeLibrary lib = (FeatureTypeLibrary) resource.getContents().get(0);
			EList<FeatureType> types = lib.getTypes();

			for (FeatureType featureType : types) {
				if (featureType.getName().equals(issue.getData()[0])) {
					IDefaultFeatureValueProvider valueProvider = desc.createFeatureValueProvider(SGenActivator
							.getInstance().getInjector(SGenActivator.ORG_YAKINDU_SCT_GENERATOR_GENMODEL_SGEN));
					if (valueProvider != null) {
						return valueProvider.createDefaultFeatureConfiguration(featureType, element);
					}
				}
			}
		}
		return null;
	}

}
