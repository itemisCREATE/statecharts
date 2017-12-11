/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.factories;

import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.DiagramViewFactory;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartDiagramViewFactory extends DiagramViewFactory {

	@Override
	protected MeasurementUnit getMeasurementUnit() {
		return MeasurementUnit.PIXEL_LITERAL;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	protected List createStyles(View view) {
		BooleanValueStyle inlineDefinitionSectionStyle = DiagramPartitioningUtil.createInlineDefinitionSectionStyle();
		view.getStyles().add(inlineDefinitionSectionStyle);
		return super.createStyles(view);
	}
}
