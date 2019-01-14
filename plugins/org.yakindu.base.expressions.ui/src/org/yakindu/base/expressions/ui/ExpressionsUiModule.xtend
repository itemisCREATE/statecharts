/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.base.expressions.ui

import org.eclipse.ui.plugin.AbstractUIPlugin
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory
import org.eclipse.xtext.ui.editor.model.ResourceForIEditorInputFactory
import org.eclipse.xtext.ui.resource.SimpleResourceSetProvider
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider
import org.eclipse.xtext.ui.shared.Access

/** 
 * Use this class to register components to be used within the IDE.
 */
class ExpressionsUiModule extends AbstractExpressionsUiModule {

	new(AbstractUIPlugin plugin) {
		super(plugin)
	}

	override provideIAllContainersState() {
		return if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			Access.getJavaProjectsState()
		} else {
			Access.getWorkspaceProjectsState()
		}
	}

	override bindIResourceSetProvider() {
		return if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			XtextResourceSetProvider
		} else {
			SimpleResourceSetProvider
		}
	}

	override bindIResourceForEditorInputFactory() {
		return if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			JavaClassPathResourceForIEditorInputFactory
		} else {
			ResourceForIEditorInputFactory
		}
	}
}
