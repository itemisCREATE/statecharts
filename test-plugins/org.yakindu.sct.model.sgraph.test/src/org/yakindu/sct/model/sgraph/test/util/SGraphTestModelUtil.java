package org.yakindu.sct.model.sgraph.test.util;

import org.eclipse.emf.common.util.URI;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.test.models.AbstractTestModelsUtil;

public final class SGraphTestModelUtil {

	private static final String TESTMODEL_DIR = "org.yakindu.sct.test.models/testmodels/validation/";

	private SGraphTestModelUtil() {
	}

	public static final Statechart loadStatechart(String filename) {
		return AbstractTestModelsUtil.loadStatechart(URI.createPlatformPluginURI(TESTMODEL_DIR + filename, true));
	}
}
