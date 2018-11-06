package org.yakindu.base.xtext.utils.jface;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class JFaceUtilsActivator extends AbstractUIPlugin {

	private static JFaceUtilsActivator INSTANCE;
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		INSTANCE = null;
	}
	
	public static JFaceUtilsActivator getInstance() {
		return INSTANCE;
	}
	
}
