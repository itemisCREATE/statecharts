/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.edithelper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.commands.CreateRegionCommand;
import org.yakindu.sct.ui.editor.editor.StatechartElementTypes;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StateEditHelper extends VertexEditHelper {
	/**
	 * Creates regions for {@link State}s created with the Composite/Orthogonal
	 * State tool.
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {

		if (StatechartElementTypes.COMPOSITE_STATE.equals(req.getTypeToConfigure())) {
			return createCompositeStateCommand(req);
		} else if (StatechartElementTypes.ORTHOGONAL_STATE.equals(req.getTypeToConfigure())) {
			return createOrthogonalState(req);
		}
		return null;
	}

	@Override
	protected ICommand getCreateCommand(CreateElementRequest req) {
		if (req.getElementType() == StatechartElementTypes.REGION) {
			return new CreateRegionCommand(req);
		}
		return super.getCreateCommand(req);
	}

	private ICommand createOrthogonalState(ConfigureRequest req) {
		Region region = SGraphFactory.eINSTANCE.createRegion();
		region.setName("r1");
		Region region2 = SGraphFactory.eINSTANCE.createRegion();
		region2.setName("r2");
		return new SetValueCommand(new SetRequest(req.getElementToConfigure(),
				SGraphPackage.Literals.COMPOSITE_ELEMENT__REGIONS, com.google.common.collect.Lists.newArrayList(region,
						region2)));
	}

	private ICommand createCompositeStateCommand(ConfigureRequest req) {
		Region region = SGraphFactory.eINSTANCE.createRegion();
		region.setName("r1");
		return new SetValueCommand(new SetRequest(req.getElementToConfigure(),
				SGraphPackage.Literals.COMPOSITE_ELEMENT__REGIONS, region));
	}
}
