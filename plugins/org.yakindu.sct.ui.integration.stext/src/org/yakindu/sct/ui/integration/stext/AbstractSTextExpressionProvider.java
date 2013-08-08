package org.yakindu.sct.ui.integration.stext;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.ui.STextUiModule;
import org.yakindu.sct.ui.editor.extensions.AbstractExpressionsProvider;
import org.yakindu.sct.ui.editor.extensions.IExpressionLanguageProvider;
import org.yakindu.sct.ui.integration.stext.modules.EntryRuleRuntimeModule;
import org.yakindu.sct.ui.integration.stext.modules.EntryRuleUIModule;

import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractSTextExpressionProvider extends AbstractExpressionsProvider implements IExpressionLanguageProvider {

	@Override
	protected Module getRuntimeModule() {
		return Modules.override(new STextRuntimeModule()).with(new EntryRuleRuntimeModule(getRule()));
	}

	protected abstract Class<? extends EObject> getRule();

	@Override
	protected Module getUIModule() {
		return Modules.override(new STextUiModule(ExtensionsActivator.getDefault())).with(new EntryRuleUIModule(getRule()));
	}
}
