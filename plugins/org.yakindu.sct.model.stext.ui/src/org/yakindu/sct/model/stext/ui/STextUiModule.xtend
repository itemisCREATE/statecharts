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
import org.eclipse.jface.text.ITextHover
import org.eclipse.jface.text.contentassist.IContentAssistProcessor
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.tasks.ITaskFinder
import org.eclipse.xtext.ui.editor.contentassist.IContentAssistantFactory
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover
import org.eclipse.xtext.ui.editor.hover.IEObjectHover
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider
import org.eclipse.xtext.ui.editor.hover.ProblemAnnotationHover
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory
import org.eclipse.xtext.ui.editor.model.ResourceForIEditorInputFactory
import org.eclipse.xtext.ui.editor.model.XtextDocument
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration
import org.eclipse.xtext.ui.resource.SimpleResourceSetProvider
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider
import org.eclipse.xtext.ui.shared.Access
import org.eclipse.xtext.ui.tasks.TaskMarkerCreator
import org.eclipse.xtext.ui.tasks.TaskMarkerTypeProvider
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

	def Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProvider() {
		return STextUserHelpDocumentationProvider
	}

	def Class<? extends DispatchingEObjectTextHover> bindDispatchingEObjectTextHover() {
		return CrossRefObjectTextHover
	}

	override Class<? extends IEObjectHover> bindIEObjectHover() {
		return CrossRefObjectTextHover
	}

	def Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return HelpHoverProvider
	}

	def configureHelpAction(Binder binder) {
		binder.bind(String).annotatedWith(Names.named(OpenInHelpAction.CONTEXTID)).toInstance(
			"org.yakindu.sct.ui.editor.stext_keyword")
	}

	def configureTransactionalDomainID(Binder binder) {
		binder.bind(String).annotatedWith(Names.named("domain.id")).toInstance("org.yakindu.sct.domain")
	}

	def Class<? extends XtextDocument> bindXtextDocument() {
		TransactionalXtextDocument
	}

	def Class<? extends TaskMarkerCreator> bindTaskMarkerCreator() {
		SCTTaskMarkerCreator
	}

	def Class<? extends TaskMarkerTypeProvider> bindTaskMarkerTypeProvider() {
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

	override Class<? extends ITextHover> bindITextHover() {
		return ProblemAnnotationHover
	}

	def Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return SCTHighlightingConfiguration
	}

	def Class<? extends ITaskFinder> bindITaskFinder() {
		return STextTaskFinder
	}

	def Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return PackageImportHyperlinkHelper
	}

	override Class<? extends IContentAssistantFactory> bindIContentAssistantFactory() {
		return AsyncContentAssistContextFactory
	}

	override Class<? extends IContentAssistProcessor> bindIContentAssistProcessor() {
		return AsyncXtextContentAssistProcessor
	}
}
