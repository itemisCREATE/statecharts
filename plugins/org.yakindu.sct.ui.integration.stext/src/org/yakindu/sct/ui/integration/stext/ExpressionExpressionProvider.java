package org.yakindu.sct.ui.integration.stext;

import org.yakindu.sct.model.stext.stext.Expression;
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
public class ExpressionExpressionProvider extends AbstractExpressionsProvider implements IExpressionLanguageProvider {

	@Override
	protected Module getRuntimeModule() {
		return new EntryRuleRuntimeModule(Expression.class);
	}

	@Override
	protected Module getUIModule() {
		return new EntryRuleUIModule(ExtensionsActivator.getDefault(), Expression.class);
	}
}
