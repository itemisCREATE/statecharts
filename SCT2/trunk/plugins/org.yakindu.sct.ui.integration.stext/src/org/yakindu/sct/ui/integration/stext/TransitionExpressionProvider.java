package org.yakindu.sct.ui.integration.stext;

import org.yakindu.sct.ui.editor.extensions.AbstractExpressionsProvider;
import org.yakindu.sct.ui.editor.extensions.IExpressionLanguageProvider;
import org.yakindu.sct.ui.integration.stext.modules.TransitionRuntimeModule;
import org.yakindu.sct.ui.integration.stext.modules.TransitionUIModule;

import com.google.inject.Module;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TransitionExpressionProvider extends AbstractExpressionsProvider
		implements IExpressionLanguageProvider {

	@Override
	protected Module getRuntimeModule() {
		return new TransitionRuntimeModule();
	}

	@Override
	protected Module getUIModule() {
		return new TransitionUIModule(ExtensionsActivator.getDefault());
	}
}
