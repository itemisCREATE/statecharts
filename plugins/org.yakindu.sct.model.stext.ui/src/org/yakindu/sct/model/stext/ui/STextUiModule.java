/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.stext.ui;

import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.resource.clustering.DynamicResourceClusteringPolicy;
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy;
import org.eclipse.xtext.tasks.ITaskFinder;
import org.eclipse.xtext.ui.editor.contentassist.IContentAssistantFactory;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.ProblemAnnotationHover;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.ResourceForIEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.SimpleResourceSetProvider;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.ui.tasks.TaskMarkerCreator;
import org.eclipse.xtext.ui.tasks.TaskMarkerTypeProvider;
import org.yakindu.base.utils.jface.help.CrossRefObjectTextHover;
import org.yakindu.base.utils.jface.help.HelpHoverProvider;
import org.yakindu.sct.model.stext.ui.contentassist.AsyncContentAssistContextFactory;
import org.yakindu.sct.model.stext.ui.contentassist.AsyncXtextContentAssistProcessor;
import org.yakindu.sct.model.stext.ui.contentassist.STextStatefulFactory;
import org.yakindu.sct.model.stext.ui.document.TransactionalXtextDocument;
import org.yakindu.sct.model.stext.ui.help.STextUserHelpDocumentationProvider;
import org.yakindu.sct.model.stext.ui.highlighting.SCTHighlightingConfiguration;
import org.yakindu.sct.model.stext.ui.hyperlink.PackageImportHyperlinkHelper;
import org.yakindu.sct.model.stext.ui.tasks.SCTTaskMarkerCreator;
import org.yakindu.sct.model.stext.ui.tasks.SCTTaskMarkerTypeProvider;
import org.yakindu.sct.model.stext.ui.tasks.STextTaskFinder;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
@SuppressWarnings("restriction")
public class STextUiModule extends org.yakindu.sct.model.stext.ui.AbstractSTextUiModule {

	public static final String STEXT_LANGUAGE_NAME = "org.yakindu.sct.model.stext.SText";

	public STextUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends StatefulFactory> bindStatefulFactory() {
		return STextStatefulFactory.class;
	}

	public Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProvider() {
		return STextUserHelpDocumentationProvider.class;
	}

	public Class<? extends DispatchingEObjectTextHover> bindDispatchingEObjectTextHover() {
		return CrossRefObjectTextHover.class;
	}

	@Override
	public Class<? extends IEObjectHover> bindIEObjectHover() {
		return CrossRefObjectTextHover.class;
	}

	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return HelpHoverProvider.class;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(String.class).annotatedWith(Names.named("domain.id")).toInstance("org.yakindu.sct.domain");
		binder.bind(XtextDocument.class).to(TransactionalXtextDocument.class);
		binder.bind(TaskMarkerCreator.class).to(SCTTaskMarkerCreator.class);
		binder.bind(TaskMarkerTypeProvider.class).to(SCTTaskMarkerTypeProvider.class);
	}

	public com.google.inject.Provider<org.eclipse.xtext.resource.containers.IAllContainersState> provideIAllContainersState() {
		if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			return Access.getJavaProjectsState();
		} else {
			return Access.getWorkspaceProjectsState();
		}
	}

	public Class<? extends IResourceSetProvider> bindIResourceSetProvider() {
		if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			return XtextResourceSetProvider.class;
		} else {
			return SimpleResourceSetProvider.class;
		}
	}

	@Override
	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			return JavaClassPathResourceForIEditorInputFactory.class;
		} else {
			return ResourceForIEditorInputFactory.class;
		}
	}

	public Class<? extends org.eclipse.jface.text.ITextHover> bindITextHover() {
		return ProblemAnnotationHover.class;
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return SCTHighlightingConfiguration.class;
	}

	public Class<? extends ITaskFinder> bindITaskFinder() {
		return STextTaskFinder.class;
	}

	public Class<? extends IResourceClusteringPolicy> bindIResourceClusteringPolicy() {
		return DynamicResourceClusteringPolicy.class;
	}

	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return PackageImportHyperlinkHelper.class;
	}

	@Override
	public Class<? extends IContentAssistantFactory> bindIContentAssistantFactory() {
		return AsyncContentAssistContextFactory.class;
	}

	@Override
	public Class<? extends IContentAssistProcessor> bindIContentAssistProcessor() {
		return AsyncXtextContentAssistProcessor.class;
	}
}
