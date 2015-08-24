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
package org.yakindu.base.gmf.runtime.palette;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;

/**
 * CreationTool based on
 * {@link org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool} which allow to
 * disable initial direct editing on element creation. Default behavior of
 * direct editing is enabled.
 * 
 * @author muehlbrandt
 * 
 */
public class CreationTool extends
		org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool {
	
	private boolean performDirectEdit;
	
	/**
	 * Default constructor
	 * @param elementType The type the tool should create.
	 * @param performDirectEdit flag to set direct editing enabled or disabled.
	 */
	public CreationTool(IElementType elementType, boolean performDirectEdit) {
		super(elementType);
		Assert.isNotNull(performDirectEdit);
		this.performDirectEdit = performDirectEdit;
	}
	
	/**
	 * Select the newly added shape view by default
	 * @param viewer
	 * @param objects
	 */
	@SuppressWarnings("rawtypes")
	protected void selectAddedObject(EditPartViewer viewer, Collection objects) {
		final List<Object> editparts = new ArrayList<Object>();
		for (Iterator i = objects.iterator(); i.hasNext();) {
			Object object = i.next();
			if (object instanceof IAdaptable) {
				Object editPart = viewer.getEditPartRegistry().get(
						((IAdaptable) object).getAdapter(View.class));
				if (editPart != null)
					editparts.add(editPart);
			}
		}

		if (!editparts.isEmpty()) {
			viewer.setSelection(new StructuredSelection(editparts));

			if (performDirectEdit) {
				// automatically put the first shape into edit-mode
				Display.getCurrent().asyncExec(new Runnable() {
					public void run() {
						EditPart editPart = (EditPart) editparts.get(0);
						// add active test since test scripts are failing on
						// this basically, the editpart has been deleted when
						// this code is being executed. (see RATLC00527114)
						if (editPart.isActive()) {
							editPart.performRequest(new Request(
									RequestConstants.REQ_DIRECT_EDIT));
							revealEditPart((EditPart) editparts.get(0));
						}
					}
				});
			}
		}
	}
	
	/**
	 * Get the current state of direct editing behavior.
	 * @return {@code true} if direct editing is enabled on element creation. Otherwise {@code false}.
	 */
	public boolean isPerformDirectEdit() {
		return performDirectEdit;
	}

	/**
	 * Set the direct editing flag to allow or disallow direct editing on element creation
	 * @param performDirectEdit
	 */
	public void setPerformDirectEdit(boolean performDirectEdit) {
		this.performDirectEdit = performDirectEdit;
	}
}
