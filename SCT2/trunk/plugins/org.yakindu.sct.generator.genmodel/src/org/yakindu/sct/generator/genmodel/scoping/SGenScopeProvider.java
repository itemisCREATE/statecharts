package org.yakindu.sct.generator.genmodel.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.yakindu.sct.generator.genmodel.resource.FeatureResourceDescription;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;

import com.google.common.base.Predicate;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenScopeProvider extends AbstractDeclarativeScopeProvider {


	/**
	 * Only allow references to FeatureParameters defined by enclosing Feature
	 */
	public IScope scope_FeatureParameterValue_parameter(
			final FeatureParameterValue context, EReference reference) {
		FilteringScope filteringScope = new FilteringScope(getDelegate()
				.getScope(context, reference),
				new Predicate<IEObjectDescription>() {
					public boolean apply(IEObjectDescription input) {
						FeatureConfiguration featureConfig = (FeatureConfiguration) context
								.eContainer();
						String featureName = featureConfig.getType().getName();
						if(featureName == null){
							return false;
						}
						return featureName.equals(input
								.getUserData(FeatureResourceDescription.FEATURE_CONTAINER));
					}
				});
		return filteringScope;
	}

	/**
	 * Only allow references to FeatureParameters defined by enclosing Feature
	 */
	public IScope scope_FeatureParameterValue_parameter(
			final FeatureConfiguration context, EReference reference) {
		FilteringScope filteringScope = new FilteringScope(getDelegate()
				.getScope(context, reference),
				new Predicate<IEObjectDescription>() {
					public boolean apply(IEObjectDescription input) {
						String featureName = context.getType().getName();
						return featureName.equals(input
								.getUserData(FeatureResourceDescription.FEATURE_CONTAINER));
					}
				});
		return filteringScope;
	}
}
