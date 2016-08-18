package org.yakindu.sct.domain.generic.editor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.yakindu.sct.domain.extension.IModuleProvider;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.stext.Guard;
import org.yakindu.sct.model.stext.stext.StateSpecification;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;
import org.yakindu.sct.model.stext.ui.STextUiModule;
import org.yakindu.sct.model.stext.ui.internal.STextActivator;

import com.google.inject.Module;
import com.google.inject.util.Modules;

public class EditorModuleProvider implements IModuleProvider {

	private static final Map<String, Class<? extends EObject>> semanticTargetToRuleMap = new HashMap<String, Class<? extends EObject>>();

	static {
		semanticTargetToRuleMap.put(Statechart.class.getName(), StatechartSpecification.class);
		semanticTargetToRuleMap.put(Transition.class.getName(), TransitionSpecification.class);
		semanticTargetToRuleMap.put(State.class.getName(), StateSpecification.class);
		semanticTargetToRuleMap.put(Guard.class.getName(), Guard.class);
	}

	@Override
	public Module getModule(String... options) {
		if (options.length == 0)
			return new GenericEditorModule();
		return getEmbeddedEditorModule(options[0]);
	}

	public Module getEmbeddedEditorModule(String semanticTarget) {
		Class<? extends EObject> rule = semanticTargetToRuleMap.get(semanticTarget);
		Module uiModule = Modules.override(new STextRuntimeModule())
				.with(new STextUiModule(STextActivator.getInstance()));
		Module languageModule = Modules.override(uiModule).with(new SharedStateModule());
		return Modules.override(languageModule).with(new EntryRuleRuntimeModule(rule), new EntryRuleUIModule(rule));

	}

}
