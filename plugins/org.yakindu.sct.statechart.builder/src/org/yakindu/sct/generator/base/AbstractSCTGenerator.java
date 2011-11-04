package org.yakindu.sct.generator.base;

import static com.google.common.collect.Iterables.getOnlyElement;
import static org.yakindu.sct.generator.base.util.GeneratorBaseUtil.resourceSimpleName;

import org.eclipse.core.resources.IResource;
import org.yakindu.sct.model.sgen.GeneratorConfiguration;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.OutletConfiguration;

import com.google.common.collect.Iterables;

/**
 * 
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public abstract class AbstractSCTGenerator<GENMODEL extends GeneratorModel> {

	public final void processModels(
			Iterable<GeneratorModel> genModelsForStatechart, IResource resource) {

		for (GeneratorModel generatorModel : genModelsForStatechart) {

			GeneratorConfiguration configuration = generatorModel
					.getConfiguration();

			if (configuration != null) {

				OutletConfiguration outletConfiguration = getOnlyElement(Iterables
						.filter(configuration.getConfigurations(),
								OutletConfiguration.class));
				executeOutlet(outletConfiguration, resource);

				@SuppressWarnings("unchecked")
				GENMODEL genmodel = (GENMODEL) generatorModel;
				generate(genmodel);
			}
		}
	}

	protected void executeOutlet(OutletConfiguration outletConfiguration,
			IResource resource) {
		String path = outletConfiguration.getPath();

		String realPath = resolvePlacholders(path,

		resourceSimpleName(resource));
		System.out.println("outlet path is " + realPath);
		/*
		 * TODO perform necessary filesystem opertations
		 */

	}

	public abstract void generate(GENMODEL genmodel);

	private String resolvePlacholders(String input, String statechartName) {
		return input.replaceAll("%statechartname", statechartName);
	}

}
