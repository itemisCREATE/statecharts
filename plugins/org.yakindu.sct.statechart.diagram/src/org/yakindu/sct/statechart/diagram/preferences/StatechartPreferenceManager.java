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
package org.yakindu.sct.statechart.diagram.preferences;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.statechart.diagram.DiagramActivator;
import org.yakindu.sct.statechart.diagram.editor.StatechartDiagramEditor;

/**
 * This singleton class holds instances of all preferences for the statechart
 * diagram. It is registered as a {@link IPropertyChangeListener} to the
 * {@link IPreferenceStore} and updated the diagram in case of a
 * {@link PropertyChangeEvent}.
 * 
 * It also handles disposing of {@link Color}s in case of preference changes.
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public final class StatechartPreferenceManager implements
		IPropertyChangeListener {

	private static StatechartPreferenceManager myself;

	private static Color regionColor;

	private static Color stateColor;

	public static synchronized StatechartPreferenceManager getInstance() {
		if (myself == null)
			myself = new StatechartPreferenceManager();
		return myself;
	}

	private StatechartPreferenceManager() {
		updatePreferences();
		DiagramActivator.getDefault().getPreferenceStore()
				.addPropertyChangeListener(this);
	}

	private void updatePreferences() {
		IPreferenceStore preferenceStore = DiagramActivator.getDefault()
				.getPreferenceStore();
		if (regionColor != null)
			regionColor.dispose();
		regionColor = preferenceStringToColor(preferenceStore
				.getString(PreferenceConstants.REGION_COLOR));
		if (stateColor != null)
			stateColor.dispose();
		stateColor = preferenceStringToColor(preferenceStore
				.getString(PreferenceConstants.STATE_COLOR));
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (PreferenceConstants.REGION_COLOR.equals(event.getProperty())
				|| PreferenceConstants.STATE_COLOR.equals(event.getProperty())) {
			updatePreferences();
			refreshActiveEditor();
		}

	}

	private void refreshActiveEditor() {
		// TODO: Improve refresh mechanism to only update those editparts which
		// are affected by the changed property.
		IEditorPart activeEditor = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (activeEditor instanceof StatechartDiagramEditor) {
			DiagramEditPart diagramEditPart = ((StatechartDiagramEditor) activeEditor)
					.getDiagramEditPart();
			refresh(diagramEditPart);
		}
	}

	private void refresh(IGraphicalEditPart parent) {
		parent.refresh();
		@SuppressWarnings("unchecked")
		List<IGraphicalEditPart> children = parent.getChildren();
		for (IGraphicalEditPart child : children) {
			refresh(child);
		}
	}

	private Color preferenceStringToColor(String colorString) {
		String[] rgbs = colorString.trim().split(",");
		Assert.isTrue(rgbs.length == 3);
		return new Color(Display.getCurrent(), new RGB(Integer.parseInt(rgbs[0]
				.trim()), Integer.parseInt(rgbs[1].trim()),
				Integer.parseInt(rgbs[2].trim())));
	}

	public Color getRegionColor() {
		return regionColor;
	}

	public Color getStateColor() {
		return stateColor;
	}

}
