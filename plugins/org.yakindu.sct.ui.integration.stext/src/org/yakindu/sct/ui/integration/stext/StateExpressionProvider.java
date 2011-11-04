package org.yakindu.sct.ui.integration.stext;

import org.yakindu.sct.ui.editor.extensions.AbstractExpressionsProvider;
import org.yakindu.sct.ui.editor.extensions.IExpressionLanguageProvider;
import org.yakindu.sct.ui.integration.stext.modules.StateRuntimeModule;
import org.yakindu.sct.ui.integration.stext.modules.StateUIModule;

import com.google.inject.Module;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StateExpressionProvider extends AbstractExpressionsProvider
		implements IExpressionLanguageProvider {

	@Override
	protected Module getRuntimeModule() {
		return new StateRuntimeModule();
	}

	@Override
	protected Module getUIModule() {
		return new StateUIModule(ExtensionsActivator.getDefault());
	}
}
