package org.yakindu.sct.model.stext.ui

import com.google.inject.Binder
import com.google.inject.name.Names
import org.eclipse.jface.text.ITextHover
import org.eclipse.jface.text.contentassist.IContentAssistProcessor
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.service.AbstractGenericModule
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
import org.eclipse.xtext.resource.containers.IAllContainersState
import com.google.inject.Provider
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory

class STextUiOverrideModule extends AbstractGenericModule {

	def Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProvider() {
		return STextUserHelpDocumentationProvider
	}

	def Class<? extends DispatchingEObjectTextHover> bindDispatchingEObjectTextHover() {
		return CrossRefObjectTextHover
	}

	def Class<? extends IEObjectHover> bindIEObjectHover() {
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

	def Provider<? extends IAllContainersState> provideIAllContainersState() {
		if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			return Access.getJavaProjectsState()
		} else {
			return Access.getWorkspaceProjectsState()
		}
	}

	def Class<? extends IResourceSetProvider> bindIResourceSetProvider() {
		if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			return XtextResourceSetProvider
		} else {
			return SimpleResourceSetProvider
		}
	}

	def Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			return JavaClassPathResourceForIEditorInputFactory
		} else {
			return ResourceForIEditorInputFactory
		}
	}

	def Class<? extends ITextHover> bindITextHover() {
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

	def Class<? extends IContentAssistantFactory> bindIContentAssistantFactory() {
		return AsyncContentAssistContextFactory
	}

	def Class<? extends IContentAssistProcessor> bindIContentAssistProcessor() {
		return AsyncXtextContentAssistProcessor
	}
}
