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
import com.google.inject.Provider
import com.google.inject.name.Names
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.resource.containers.IAllContainersState
import org.eclipse.xtext.ui.editor.contentassist.ITemplateProposalProvider
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover
import org.eclipse.xtext.ui.editor.hover.IEObjectHover
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory
import org.eclipse.xtext.ui.editor.model.ResourceForIEditorInputFactory
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.ui.resource.SimpleResourceSetProvider
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider
import org.eclipse.xtext.ui.shared.Access
import org.yakindu.base.utils.jface.help.CrossRefObjectTextHover
import org.yakindu.base.utils.jface.help.HelpHoverProvider
import org.yakindu.base.utils.jface.help.HelpHoverProvider.OpenInHelpAction
import org.yakindu.sct.generator.core.filesystem.ISCTWorkspaceAccess
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
		binder.bind(typeof(String)).annotatedWith(Names.named(OpenInHelpAction.CONTEXTID)).toInstance(
			"org.yakindu.sct.ui.editor.sgen_feature")
	}

	def Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		SGenSemanticHighlightingCalculator
	}

	def Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		SGenHighlightingConfiguration
	}

	def Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProvider() {
		SGenUserHelpDocumentationProvider
	}

	def Class<? extends DispatchingEObjectTextHover> bindDispatchingEObjectTextHover() {
		CrossRefObjectTextHover
	}

	def Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		HelpHoverProvider
	}

	override Class<? extends IEObjectHover> bindIEObjectHover() {
		CrossRefObjectTextHover
	}

	override Class<? extends ITemplateProposalProvider> bindITemplateProposalProvider() {
		SGenTemplateProposalProvider
	}

	override Provider<IAllContainersState> provideIAllContainersState() {
		return Access.getWorkspaceProjectsState()
	}

	override Class<? extends IResourceSetProvider> bindIResourceSetProvider() {
		return if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			XtextResourceSetProvider
		} else {
			SimpleResourceSetProvider
		}
	}

	override Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			JavaClassPathResourceForIEditorInputFactory
		} else {
			ResourceForIEditorInputFactory
		}
	}

	def Class<? extends ISCTWorkspaceAccess> bindISCTWorkspaceAccess() {
		DefaultSCTWorkspaceAccess
	}
}
