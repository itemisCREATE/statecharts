package org.yakindu.sct.generator.base.internal;

import static com.google.common.base.Predicates.compose;
import static com.google.common.base.Predicates.equalTo;
import static com.google.common.collect.Iterables.any;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;
import static org.yakindu.sct.generator.base.util.GeneratorBaseUtil.resourceSimpleName;

import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.sct.generator.base.AbstractSCTGenerator;
import org.yakindu.sct.generator.base.internal.GeneratorExtensions.GeneratorDescriptor;
import org.yakindu.sct.generator.base.util.GeneratorBaseUtil;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.SGenPackage;
import org.yakindu.sct.model.sgen.StatechartReferences;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * 
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class SCTGenerator {

	private static final String STATECHART_FILE_EXTENSION = "sct";

	public void doBuild(IResource statechartResource) throws CoreException {

		if (!isStatechartResource(statechartResource)) {
			return;
		}

		final Iterable<GeneratorDescriptor> generatorDescriptors = GeneratorExtensions
				.getGeneratorDescriptors();

		final Iterable<String> genmodelExtensions = Iterables.transform(
				generatorDescriptors, new GetResourceExtension());

		final Set<IResource> genModelResources = findAllGenModels(
				statechartResource, genmodelExtensions);

		for (GeneratorDescriptor generatorDescriptor : generatorDescriptors) {
			String resourceExtension = generatorDescriptor
					.getResourceExtension();

			Iterable<GeneratorModel> genModelsForStatechart = findGenmodelsForStatechart(
					genModelResources, statechartResource, resourceExtension);

			if (!Iterables.isEmpty(genModelsForStatechart)) {

				AbstractSCTGenerator<?> generator = generatorDescriptor
						.getGenerator();

				generator.processModels(genModelsForStatechart,
						statechartResource);
			}

		}
	}

	private Iterable<GeneratorModel> findGenmodelsForStatechart(
			final Set<IResource> genModelResources,
			IResource statechartResource, String resourceExtension) {
		Predicate<IResource> isResourceExtension = compose(
				equalTo(resourceExtension), new GetFileExtension());

		Iterable<GeneratorModel> genModelsForStatechart = filter(
				transform(filter(genModelResources, isResourceExtension),
						new CreateGeneratorModel()),
				new IsConfigurationForStatechart(statechartResource));
		return genModelsForStatechart;
	}

	private boolean isStatechartResource(IResource statechartResource) {
		return STATECHART_FILE_EXTENSION.matches(statechartResource
				.getFileExtension());
	}

	private Set<IResource> findAllGenModels(IResource resource,
			final Iterable<String> resourceExtensions) throws CoreException {
		final Set<IResource> resources = Sets.newHashSet();
		resource.getProject().accept(
				new ResourceVisitor(resourceExtensions, resources));
		return resources;
	}

	private static final class ResourceVisitor implements IResourceVisitor {
		private final Iterable<String> resourceExtensions;
		private final Set<IResource> resources;

		ResourceVisitor(Iterable<String> resourceExtensions,
				Set<IResource> resources) {
			this.resourceExtensions = resourceExtensions;
			this.resources = resources;
		}

		public boolean visit(IResource resource) throws CoreException {
			int resourceType = resource.getType();
			if (any(resourceExtensions, equalTo(resource.getFileExtension()))) {
				resources.add(resource);
				return false;
			}
			return resourceType == IResource.FOLDER
					|| resourceType == IResource.PROJECT;
		}
	}

	private static final class GetStatechartName implements
			Function<Statechart, String> {
		GetStatechartName() {
		}

		public String apply(Statechart from) {
			Assert.isNotNull(from,
					String.format("Null Input in %s", getClass()));
			return from.getName();
		}
	}

	private static final class IsConfigurationForStatechart implements
			Predicate<GeneratorModel> {

		private final IResource resource;

		public IsConfigurationForStatechart(IResource resource) {
			this.resource = resource;
		}

		public boolean apply(GeneratorModel input) {
			Assert.isNotNull(input,
					String.format("Null Input in %s", getClass()));
			StatechartReferences references = input.getStatechartReferences();
			boolean isMatch = references != null
					&& any(references.getStatecharts(),
							compose(equalTo(resourceSimpleName(resource)),
									new GetStatechartName()));
			return isMatch;
		}
	}

	private static final class CreateGeneratorModel implements
			Function<IResource, GeneratorModel> {
		CreateGeneratorModel() {
		}

		public GeneratorModel apply(IResource inputResource) {
			URI uri = URI.createPlatformResourceURI(inputResource.getFullPath()
					.toString(), true);

			Resource emfResource = GeneratorBaseUtil.loadResource(uri);

			GeneratorModel genmodel = (GeneratorModel) EcoreUtil
					.getObjectByType(emfResource.getContents(),
							SGenPackage.Literals.GENERATOR_MODEL);
			Assert.isNotNull(genmodel, String.format(
					"Could not load GeneratorModel from resource %s",
					inputResource));
			return genmodel;
		}
	}

	private static final class GetFileExtension implements
			Function<IResource, String> {
		GetFileExtension() {
		}

		public String apply(IResource from) {
			Assert.isNotNull(from,
					String.format("Null Input in %s", getClass()));
			return from.getFileExtension();
		}
	}

	private static final class GetResourceExtension implements
			Function<GeneratorDescriptor, String> {
		GetResourceExtension() {
		}

		public String apply(GeneratorDescriptor from) {
			Assert.isNotNull(from,
					String.format("Null Input in %s", getClass()));
			return from.getResourceExtension();
		}
	}

}
