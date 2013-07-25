package org.yakindu.sct.ui.editor.editor.proposals;

import static org.eclipse.emf.ecore.util.EcoreUtil.getObjectByType;
import static org.yakindu.sct.model.sgraph.SGraphPackage.Literals.STATECHART;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;

import de.itemis.xtext.utils.gmf.proposals.AbstractSemanticModification;

public abstract class StateTemplatesModification extends AbstractSemanticModification {

	public abstract String getTemplatePath();

	public boolean IsModificationFor(EObject object) {
		return object instanceof State;
	}

	@Override
	protected void internalExecute(EObject semanticObject, View view) {
		State state = (State) semanticObject;
		Resource resource = loadTemplateResource(getTemplatePath());
		// Semantic changes
		Statechart statechart = (Statechart) getObjectByType(resource.getContents(), STATECHART);
		state.getRegions().addAll(statechart.getRegions());
		// Notation changes
		// TODO: Implement me
		resource.unload();

	}

	protected Resource loadTemplateResource(String templatePath) {
		ResourceSet set = new ResourceSetImpl();
		return set.getResource(URI.createPlatformPluginURI(getTemplatePath(), true), true);
	}
}
