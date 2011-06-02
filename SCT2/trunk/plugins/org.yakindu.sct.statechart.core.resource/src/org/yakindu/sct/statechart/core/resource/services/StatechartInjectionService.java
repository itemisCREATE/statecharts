package org.yakindu.sct.statechart.core.resource.services;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.yakindu.model.sct.statechart.Scope;
import org.yakindu.model.sct.statechart.State;
import org.yakindu.model.sct.statechart.Statechart;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.expressions.StatechartDefinition;

import de.itemis.xtext.utils.gmf.resource.AbstractXtextMemberInjectionService;
import de.itemis.xtext.utils.gmf.resource.IMemberInjectionService;

/**
 * Implementation if {@link IMemberInjectionService} interface to inject the
 * members of the {@link State} from the textual expression.F
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public class StatechartInjectionService extends
		AbstractXtextMemberInjectionService<Statechart, StatechartDefinition> {

	public boolean isServiceFor(EObject object) {
		return object instanceof Statechart;
	}

	@Override
	public void setFeatures(Statechart original, StatechartDefinition rootAST) {
		EList<Scope> definitionScopes = rootAST.getDefinitionScopes();
		original.getScopes().clear();
		original.getScopes().addAll(definitionScopes);
	}

	public EStructuralFeature getSourceFeature() {
		return StatechartPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION;
	}

	@Override
	public String getParserRule() {
		return StatechartDefinition.class.getSimpleName();
	}
	

}
