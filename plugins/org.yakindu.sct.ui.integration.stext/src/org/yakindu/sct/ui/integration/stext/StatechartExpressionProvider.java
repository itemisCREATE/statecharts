package org.yakindu.sct.ui.integration.stext;

import org.yakindu.sct.ui.editor.extensions.AbstractExpressionsProvider;
import org.yakindu.sct.ui.editor.extensions.IExpressionLanguageProvider;
import org.yakindu.sct.ui.integration.stext.modules.StatechartRuntimeModule;
import org.yakindu.sct.ui.integration.stext.modules.StatechartUIModule;

import com.google.inject.Module;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartExpressionProvider extends AbstractExpressionsProvider
		implements IExpressionLanguageProvider {

	@Override
	protected Module getRuntimeModule() {
		return new StatechartRuntimeModule();
	}

	@Override
	protected Module getUIModule() {
		return new StatechartUIModule(ExtensionsActivator.getDefault());
	}
}
