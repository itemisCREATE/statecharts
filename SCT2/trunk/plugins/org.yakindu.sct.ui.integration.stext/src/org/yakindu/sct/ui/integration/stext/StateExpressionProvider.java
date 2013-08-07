package org.yakindu.sct.ui.integration.stext;

import org.yakindu.sct.model.stext.stext.StateSpecification;
import org.yakindu.sct.ui.editor.extensions.AbstractExpressionsProvider;
import org.yakindu.sct.ui.editor.extensions.IExpressionLanguageProvider;
import org.yakindu.sct.ui.integration.stext.modules.EntryRuleRuntimeModule;
import org.yakindu.sct.ui.integration.stext.modules.EntryRuleUIModule;

import com.google.inject.Module;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StateExpressionProvider extends AbstractExpressionsProvider implements IExpressionLanguageProvider {

	@Override
	protected Module getRuntimeModule() {
		return new EntryRuleRuntimeModule(StateSpecification.class);
	}

	@Override
	protected Module getUIModule() {
		return new EntryRuleUIModule(ExtensionsActivator.getDefault(), StateSpecification.class);
	}
}
