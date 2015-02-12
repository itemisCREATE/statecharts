package org.yakindu.sct.domain.default_.modules;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.ui.STextUiModule;
import org.yakindu.sct.model.stext.ui.internal.STextActivator;

import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractSTextExpressionProvider extends AbstractExpressionsProvider implements
		IExpressionLanguageProvider {

	@Override
	protected Module getRuntimeModule() {
		return Modules.override(new STextRuntimeModule()).with(new EntryRuleRuntimeModule(getRule()));
	}

	protected abstract Class<? extends EObject> getRule();

	@Override
	protected Module getUIModule() {
		return Modules.override(new STextUiModule(STextActivator.getInstance())).with(new EntryRuleUIModule(getRule()));
	}
}
