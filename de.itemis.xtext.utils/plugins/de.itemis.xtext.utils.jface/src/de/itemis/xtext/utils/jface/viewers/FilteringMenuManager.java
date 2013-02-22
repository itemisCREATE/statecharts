/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package de.itemis.xtext.utils.jface.viewers;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.xtext.util.Arrays;

/**
 * exclusionSet from DiagramContextMenuProvider
 * 
 * @author muelder
 * 
 */
public class FilteringMenuManager extends MenuManager {

	private String[] exclusionSet = { "replaceWithMenu", "compareWithMenu", "ValidationAction", "team.main",
			"org.eclipse.jst.ws.atk.ui.webservice.category.popupMenu",
			"org.eclipse.tptp.platform.analysis.core.ui.internal.actions.MultiAnalysisActionDelegate",
			"org.eclipse.debug.ui.contextualLaunch.run.submenu", "org.eclipse.debug.ui.contextualLaunch.debug.submenu",
			"org.eclipse.debug.ui.contextualLaunch.profile.submenu",
			"org.eclipse.mylyn.resources.ui.ui.interest.remove.element" };

	protected boolean allowItem(IContributionItem itemToAdd) {
		if (itemToAdd.getId() != null && Arrays.contains(exclusionSet, itemToAdd.getId()))
			itemToAdd.setVisible(false);
		return super.allowItem(itemToAdd);
	}
}
