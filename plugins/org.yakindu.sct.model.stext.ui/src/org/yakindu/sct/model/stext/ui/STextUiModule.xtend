/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.ui

import com.google.inject.Binder
import com.google.inject.name.Names
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.eclipse.xtext.ui.editor.hover.ProblemAnnotationHover
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory
import org.eclipse.xtext.ui.editor.model.ResourceForIEditorInputFactory
import org.eclipse.xtext.ui.resource.SimpleResourceSetProvider
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider
import org.eclipse.xtext.ui.shared.Access
import org.yakindu.base.utils.jface.help.CrossRefObjectTextHover
import org.yakindu.base.utils.jface.help.HelpHoverProvider
import org.yakindu.base.utils.jface.help.HelpHoverProvider.OpenInHelpAction
import org.yakindu.sct.model.stext.ui.contentassist.AsyncContentAssistContextFactory
import org.yakindu.sct.model.stext.ui.contentassist.AsyncXtextContentAssistProcessor
import org.yakindu.sct.model.stext.ui.document.TransactionalXtextDocument
import org.yakindu.sct.model.stext.ui.help.STextUserHelpDocumentationProvider
import org.yakindu.sct.model.stext.ui.highlighting.SCTHighlightingConfiguration
import org.yakindu.sct.model.stext.ui.hyperlink.PackageImportHyperlinkHelper
import org.yakindu.sct.model.stext.ui.tasks.SCTTaskMarkerCreator
import org.yakindu.sct.model.stext.ui.tasks.SCTTaskMarkerTypeProvider
import org.yakindu.sct.model.stext.ui.tasks.STextTaskFinder

class STextUiModule extends AbstractSTextUiModule {
	
	public static final String STEXT_LANGUAGE_NAME = "org.yakindu.sct.model.stext.SText"

	new(AbstractUIPlugin plugin) {
		super(plugin)
	}

	def bindIEObjectDocumentationProvider() {
		STextUserHelpDocumentationProvider
	}

	def bindDispatchingEObjectTextHover() {
		CrossRefObjectTextHover
	}

	override bindIEObjectHover() {
		CrossRefObjectTextHover
	}

	def bindIEObjectHoverProvider() {
		HelpHoverProvider
	}

	def configureHelpAction(Binder binder) {
		binder.bind(String).annotatedWith(Names.named(OpenInHelpAction.CONTEXTID)).toInstance(
			"org.yakindu.sct.ui.editor.stext_keyword")
	}

	def configureTransactionalDomainID(Binder binder) {
		binder.bind(String).annotatedWith(Names.named("domain.id")).toInstance("org.yakindu.sct.domain")
	}

	def bindXtextDocument() {
		TransactionalXtextDocument
	}

	def bindTaskMarkerCreator() {
		SCTTaskMarkerCreator
	}

	def bindTaskMarkerTypeProvider() {
		SCTTaskMarkerTypeProvider
	}

	override provideIAllContainersState() {
		if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			return Access.getJavaProjectsState()
		} else {
			return Access.getWorkspaceProjectsState()
		}
	}

	override bindIResourceSetProvider() {
		if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			return XtextResourceSetProvider
		} else {
			return SimpleResourceSetProvider
		}
	}

	override bindIResourceForEditorInputFactory() {
		if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			return JavaClassPathResourceForIEditorInputFactory
		} else {
			return ResourceForIEditorInputFactory
		}
	}

	override bindITextHover() {
		return ProblemAnnotationHover
	}

	def bindIHighlightingConfiguration() {
		SCTHighlightingConfiguration
	}

	def bindITaskFinder() {
		STextTaskFinder
	}

	def bindIHyperlinkHelper() {
		PackageImportHyperlinkHelper
	}

	override bindIContentAssistantFactory() {
		AsyncContentAssistContextFactory
	}

	override bindIContentAssistProcessor() {
		return AsyncXtextContentAssistProcessor
	}
}
