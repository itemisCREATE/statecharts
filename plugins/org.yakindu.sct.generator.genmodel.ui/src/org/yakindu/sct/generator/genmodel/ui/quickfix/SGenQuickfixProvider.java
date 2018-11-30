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
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
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
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenQuickfixProvider extends DefaultQuickfixProvider {

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
		System.out.println("found");
		acceptor.accept(issue, "Add feature " + issue.getData()[0], "Adds the feature " + issue.getData()[0], null,
				new ISemanticModification() {

					@Override
					public void apply(EObject element, IModificationContext context) throws Exception {
						System.out.println("found2");
						if (element instanceof GeneratorEntry) {
							EObject elementRef = ((GeneratorEntry) element).getElementRef();
							if (elementRef instanceof Statechart) {
								TransactionalEditingDomain sharedDomain = DiagramPartitioningUtil.getSharedDomain();
								AbstractTransactionalCommand refactoringCommand = new AbstractTransactionalCommand(
										sharedDomain, "Domain change command", Collections.EMPTY_LIST) {

									@Override
									protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
											IAdaptable info) throws ExecutionException {
										try {
											Statechart realStatechart = (Statechart) DiagramPartitioningUtil
													.getSharedDomain().getResourceSet()
													.getEObject(EcoreUtil.getURI(elementRef), true);
											(realStatechart).setDomainID("com.yakindu.domain.scxml");
											System.out.println("found3");
										} catch (Exception ex) {
											return CommandResult.newErrorCommandResult(ex);
										}
										return CommandResult.newOKCommandResult();
									}

									@Override
									protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info)
											throws ExecutionException {
										return Status.CANCEL_STATUS;
									}

								};
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
	
	public static void executeCommand(IUndoableOperation command, Resource resource, boolean serialize) {
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();

		if (resource instanceof AbstractSCTResource) {
			// enable serializer
			((AbstractSCTResource) resource).setSerializerEnabled(serialize);
			try {
				history.execute(command, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				// disable serializer
				((AbstractSCTResource) resource).setSerializerEnabled(false);
			}
		} else {
			try {
				history.execute(command, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Diagram getDiagramfromStatechart(Statechart statechart) {

		Resource sctResource = statechart.eResource();
		EList<EObject> contents = sctResource.getContents();
		EList<Diagram> diagrams = new BasicEList<Diagram>();
		for (EObject o : contents) {
			if (o instanceof Diagram) {
				diagrams.add((Diagram) o);
			}
		}
		return diagrams.get(0); // TODO: inner diagrams?
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
