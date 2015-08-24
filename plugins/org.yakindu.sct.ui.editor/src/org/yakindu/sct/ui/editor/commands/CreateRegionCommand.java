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
package org.yakindu.sct.ui.editor.commands;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.gmf.runtime.emf.core.resources.IResourceHelper;
import org.eclipse.gmf.runtime.emf.core.util.Util;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.yakindu.base.gmf.runtime.editpolicies.CompartmentLayoutEditPolicy.RequestParameterKeys;
import org.yakindu.sct.ui.editor.DiagramActivator;

/**
 * 
 * @author muehlbrandt
 * 
 */

public class CreateRegionCommand extends CreateElementCommand {

	public CreateRegionCommand(CreateElementRequest request) {
		super(request);
	}

	@Override
	protected EObject doDefaultElementCreation() {
		if (getCreateRequest().getParameters().get(
				RequestParameterKeys.RegionFeedbackIndex) != null) {
			int regionFeedbackIndex = (Integer) getCreateRequest()
					.getParameters().get(
							RequestParameterKeys.RegionFeedbackIndex);
			// -1 means add -> use original behavior
			if (regionFeedbackIndex > -1) {
				return doDefaultElementCreation(regionFeedbackIndex);
			}
		}
		return super.doDefaultElementCreation();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected EObject doDefaultElementCreation(int index) {
		EObject result = null;
		EReference reference = getContainmentFeature();
		EClass eClass = getElementType().getEClass();

		if (reference != null) {
			EObject container = getElementToEdit();

			if (container != null) {

				IResourceHelper helper = Util.getHelper(container.eResource());

				if (helper != null) {

					result = helper.create(eClass);

				} else {
					result = eClass.getEPackage().getEFactoryInstance()
							.create(eClass);
				}

				if (FeatureMapUtil.isMany(container, reference)) {
					((List) container.eGet(reference)).add(index, result);
				} else {
					container.eSet(reference, result);
				}

				return result;
			}
		}

		IStatus status = (result != null) ? Status.OK_STATUS : new Status(
				Status.ERROR, DiagramActivator.PLUGIN_ID,
				"CreateRegionCommand: No Region created: "
						+ getElementType().getDisplayName());

		setDefaultElementCreationStatus(status);

		return result;
	}
}
