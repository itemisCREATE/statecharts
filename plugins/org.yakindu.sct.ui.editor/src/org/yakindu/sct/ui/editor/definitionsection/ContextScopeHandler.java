/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.definitionsection;

import org.eclipse.core.commands.contexts.Context;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;

/**
 * 
 * @author robert rudi - Initial contribution and API
 *
 */
public abstract class ContextScopeHandler {

	protected static final String SCOPE_DESCRIPTION = "Editor scope";
	protected static final String DIALOG_AND_WINDOW_SCOPE = "org.eclipse.ui.contexts.dialogAndWindow";
	protected static final String EMBEDDED_TEXT_EDITOR_SCOPE = "org.eclipse.xtext.ui.embeddedTextEditorScope";
	protected static final String TEXT_EDITOR_SCOPE = "org.eclipse.ui.textEditorScope";

	protected static final IContextService contextService = PlatformUI.getWorkbench().getService(IContextService.class);

	/**
	 * Sets a new parent context for the given child context with optional scope
	 * description
	 */
	public static String defineContext(String childCtxId, String parentCtxId) {
		Context childCtx = getContext(childCtxId);
		if (childCtx != null) {
			childCtx.define(childCtx.getId(), SCOPE_DESCRIPTION, parentCtxId);
			return childCtxId;
		}
		return null;
	}

	private static Context getContext(String contextId) {
		return contextService.getContext(contextId);
	}

	public static IContextActivation activateContext(String context) {
		return contextService.activateContext(context);
	}

	public static void deactivateContext(IContextActivation context) {
		contextService.deactivateContext(context);
	}

}
