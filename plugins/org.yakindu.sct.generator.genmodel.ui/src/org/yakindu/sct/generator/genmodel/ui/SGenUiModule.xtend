/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.ui

import com.google.inject.Binder
import com.google.inject.name.Names
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory
import org.eclipse.xtext.ui.editor.model.ResourceForIEditorInputFactory
import org.eclipse.xtext.ui.resource.SimpleResourceSetProvider
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider
import org.eclipse.xtext.ui.shared.Access
import org.yakindu.base.utils.jface.help.CrossRefObjectTextHover
import org.yakindu.base.utils.jface.help.HelpHoverProvider
import org.yakindu.base.utils.jface.help.HelpHoverProvider.OpenInHelpAction
import org.yakindu.sct.generator.genmodel.ui.help.SGenUserHelpDocumentationProvider
import org.yakindu.sct.generator.genmodel.ui.highlighting.SGenHighlightingConfiguration
import org.yakindu.sct.generator.genmodel.ui.highlighting.SGenSemanticHighlightingCalculator
import org.yakindu.sct.generator.genmodel.ui.templates.SGenTemplateProposalProvider
import org.yakindu.sct.generator.genmodel.ui.ws.DefaultSCTWorkspaceAccess

class SGenUiModule extends AbstractSGenUiModule {
	
	new(AbstractUIPlugin plugin) {
		super(plugin)
	}

	def configureHelpAction(Binder binder) {
		binder.bind(String).annotatedWith(Names.named(OpenInHelpAction.CONTEXTID)).toInstance(
			"org.yakindu.sct.ui.editor.sgen_feature")
	}

	def bindISemanticHighlightingCalculator() {
		SGenSemanticHighlightingCalculator
	}

	def bindIHighlightingConfiguration() {
		SGenHighlightingConfiguration
	}

	def bindIEObjectDocumentationProvider() {
		SGenUserHelpDocumentationProvider
	}

	def bindDispatchingEObjectTextHover() {
		CrossRefObjectTextHover
	}

	def bindIEObjectHoverProvider() {
		HelpHoverProvider
	}

	override bindIEObjectHover() {
		CrossRefObjectTextHover
	}

	override bindITemplateProposalProvider() {
		SGenTemplateProposalProvider
	}

	override provideIAllContainersState() {
		return Access.getWorkspaceProjectsState()
	}

	override bindIResourceSetProvider() {
		if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			return typeof(XtextResourceSetProvider)
		} else {
			return typeof(SimpleResourceSetProvider)
		}
	}

	override bindIResourceForEditorInputFactory() {
		if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			return typeof(JavaClassPathResourceForIEditorInputFactory)
		} else {
			return typeof(ResourceForIEditorInputFactory)
		}
	}

	def bindISCTWorkspaceAccess() {
		return DefaultSCTWorkspaceAccess
	}
}
