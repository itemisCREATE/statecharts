/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.providers;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.Bundle;
import org.yakindu.base.gmf.runtime.palette.DirectEditCreationTool;
import org.yakindu.sct.ui.editor.DiagramActivator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class DefaultSCTPaletteFactory implements ISCTPaletteFactory {

	// Meta model type IDs
	public static final String PLUGIN_ID_PREFIX = "org.yakindu.sct.ui.editor.";
	public static final String STATECHART_ID = "Statechart";
	public static final String REGION_ID = "Region";
	public static final String STATE_ID = "State";
	public static final String COMPOSITE_STATE_ID = "CompositeState";
	public static final String ORTHOGONAL_STATE_ID = "OrthogonalState";
	public static final String TRANSITION_ID = "Transition";
	public static final String CHOICE_ID = "Choice";
	public static final String ENTRY_ID = "Entry";
	public static final String DEEPHISTORY_ID = "DeepHistory";
	public static final String SHALLOWHISTORY_ID = "ShallowHistory";
	public static final String EXITNODE_ID = "Exit";
	public static final String FINALSTATE_ID = "FinalState";
	public static final String SYNCHRONIZATION_ID = "Synchronization";

	public void createPaletteEntries(PaletteRoot root) {
		PaletteContainer container = createToolsCategory(root);
		createTransitionEntry(container);
		createStateEntry(container);
		createCompositeStateEntry(container);
		createOrthogonalStateEntry(container);
		createRegionEntry(container);
		createInitialStateEntry(container);
		createShallowHistoryEntry(container);
		createDeepHistoryEntry(container);
		createFinalStateEntry(container);
		createExitEntry(container);
		createChoiceEntry(container);
		createSynchronizationEntry(container);
	}

	protected PaletteContainer createToolsCategory(PaletteRoot root) {
		PaletteDrawer drawer = new PaletteDrawer("Tools");
		root.add(drawer);
		return drawer;
	}

	protected void createTransitionEntry(PaletteContainer container) {
		container.add(new ConnectionCreationToolEntry("Transition", "Creates a transition", getType(TRANSITION_ID),
				findIcon("icons/obj16/transition-16.png"), findIcon("icons/obj32/transition-32.png")));
	}

	protected void createStateEntry(PaletteContainer container) {
		container.add(new CreationToolEntry("State", "Creates a state", getType(STATE_ID),
				findIcon("icons/obj16/State-16.png"), findIcon("icons/obj32/State-32.png"), true));
	}

	protected void createCompositeStateEntry(PaletteContainer container) {
		container.add(new CreationToolEntry("Composite State", "Creates a composite state", getType(COMPOSITE_STATE_ID),
				findIcon("icons/obj16/Composite-State-16.png"), findIcon("icons/obj32/Composite-State-32.png"), true));
	}

	protected void createOrthogonalStateEntry(PaletteContainer container) {
		container.add(new CreationToolEntry("Orthogonal State", "Creates an orthogonal state",
				getType(ORTHOGONAL_STATE_ID), findIcon("icons/obj16/Orthogonal-State-16.png"),
				findIcon("icons/obj32/Orthogonal-State-32.png"), true));
	}

	protected void createRegionEntry(PaletteContainer container) {
		container.add(new CreationToolEntry("Region", "Creates a region", getType(REGION_ID),
				findIcon("icons/obj16/Region-16.png"), findIcon("icons/obj32/Region-32.png"), false));
	}

	protected void createInitialStateEntry(PaletteContainer container) {
		container.add(new CreationToolEntry("Entry", "Creates an initial state", getType(ENTRY_ID),
				findIcon("icons/obj16/Initial-State-16.png"), findIcon("icons/obj32/Initial-State-32.png"), false));
	}

	protected void createShallowHistoryEntry(PaletteContainer container) {
		container.add(new CreationToolEntry("Shallow History", "Creates a shallow state", getType(SHALLOWHISTORY_ID),
				findIcon("icons/obj16/Shallow-History-16.png"), findIcon("icons/obj32/Shallow-History-32.png"), false));
	}

	protected void createDeepHistoryEntry(PaletteContainer container) {
		container.add(new CreationToolEntry("Deep History", "Creates a deep history", getType(DEEPHISTORY_ID),
				findIcon("icons/obj16/Deep-History-16.png"), findIcon("icons/obj32/Deep-History-32.png"), false));
	}

	protected void createFinalStateEntry(PaletteContainer container) {
		container.add(new CreationToolEntry("Final State", "Creates a final state", getType(FINALSTATE_ID),
				findIcon("icons/obj16/Final-State-16.png"), findIcon("icons/obj32/Final-State-32.png"), false));
	}

	protected void createExitEntry(PaletteContainer container) {
		container.add(new CreationToolEntry("Exit Node", "Creates an exit node", getType(EXITNODE_ID),
				findIcon("icons/obj16/Exit-Point-16.png"), findIcon("icons/obj32/Exit-Point-32.png"), false));
	}

	protected void createChoiceEntry(PaletteContainer container) {
		container.add(new CreationToolEntry("Choice", "Creates a choice", getType(CHOICE_ID),
				findIcon("icons/obj16/Choice-16.png"), findIcon("icons/obj32/Choice-32.png"), false));
	}

	protected void createSynchronizationEntry(PaletteContainer container) {
		container.add(new CreationToolEntry("Synchronization", "Creates a synchronization", getType(SYNCHRONIZATION_ID),
				findIcon("icons/obj16/Synchronization-16.png"), findIcon("icons/obj32/Synchronization-32.png"), false));
	}

	protected IElementType getType(String id) {
		return ElementTypeRegistry.getInstance().getType(PLUGIN_ID_PREFIX + id);
	}

	protected ImageDescriptor findIcon(String iconPath) {
		return getImageDescriptor(iconPath, DiagramActivator.getDefault().getBundle());
	}

	protected ImageDescriptor getImageDescriptor(String iconPath, Bundle bundle) {
		try {
			if (iconPath != null) {
				URL fullPathString = FileLocator.find(bundle, new Path(iconPath), null);
				fullPathString = fullPathString != null ? fullPathString : new URL(iconPath);
				if (fullPathString != null) {
					return ImageDescriptor.createFromURL(fullPathString);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static class CreationToolEntry extends CombinedTemplateCreationEntry {

		private IElementType elementType;
		private boolean directEdit;
		private Tool tool;

		public CreationToolEntry(String label, String shortDesc, IElementType elementType, ImageDescriptor iconSmall,
				ImageDescriptor iconLarge, boolean directEdit) {
			super(label, shortDesc, null, iconSmall, iconLarge);
			this.elementType = elementType;
			this.directEdit = directEdit;
			// Use of 'dummy' PaletteToolEntry here is required because of an
			// instanceof check in PaletteToolTransferDragSourceListener
			setTemplate(new PaletteToolEntry(null, null, null) {
				@Override
				public Tool createTool() {
					return CreationToolEntry.this.createTool();
				}
			});
		}

		@Override
		public Tool createTool() {
			if (tool == null)
				tool = new DirectEditCreationTool(elementType, directEdit);
			return tool;
		}
	}

	public static class ConnectionCreationToolEntry extends CombinedTemplateCreationEntry {

		private IElementType elementType;
		private Tool tool;

		public ConnectionCreationToolEntry(String label, String shortDesc, IElementType elementType,
				ImageDescriptor iconSmall, ImageDescriptor iconLarge) {
			super(label, shortDesc, null, iconSmall, iconLarge);
			this.elementType = elementType;
		}

		@Override
		public Tool createTool() {
			if (tool == null)
				tool = new ConnectionCreationTool(elementType);
			return tool;
		}

	}

}
