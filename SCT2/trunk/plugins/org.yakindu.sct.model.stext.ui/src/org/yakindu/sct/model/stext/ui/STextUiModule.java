package org.yakindu.sct.model.stext.ui;

import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.ProblemAnnotationHover;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.ResourceForIEditorInputFactory;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.SimpleResourceSetProvider;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.IResourceValidator;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerCreator;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerTypeProvider;
import org.yakindu.sct.model.stext.ui.contentassist.STextStatefulFactory;
import org.yakindu.sct.model.stext.ui.help.CustomCSSHelpHoverProvider;
import org.yakindu.sct.model.stext.ui.help.STextUserHelpDocumentationProvider;
import org.yakindu.sct.model.stext.ui.hyperlink.NullHyperlinkDetector;
import org.yakindu.sct.model.stext.ui.validation.SCTDiagnosticConverterImpl;
import org.yakindu.sct.model.stext.ui.validation.SCTResourceValidatorImpl;

import com.google.inject.Binder;
import com.google.inject.name.Names;

import de.itemis.utils.jface.viewers.help.CrossRefObjectTextHover;

/**
 * Use this class to register components to be used within the IDE.
 */
public class STextUiModule extends
		org.yakindu.sct.model.stext.ui.AbstractSTextUiModule {

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
		return CustomCSSHelpHoverProvider.class;
	}

	public Class<? extends IDiagnosticConverter> bindIDiagnosticConverter() {
		return SCTDiagnosticConverterImpl.class;
	}

	public Class<? extends MarkerCreator> bindMarkerCreator() {
		return SCTMarkerCreator.class;
	}

	public Class<? extends MarkerTypeProvider> bindMarkerTypeProvider() {
		return SCTMarkerTypeProvider.class;
	}

	public Class<? extends IResourceValidator> bindIResourceValidator() {
		return SCTResourceValidatorImpl.class;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(String.class).annotatedWith(Names.named("stylesheet"))
				.toInstance("/StextHoverStyleSheet.css");
	}

	@Override
	public Class<? extends IHyperlinkDetector> bindIHyperlinkDetector() {
		return NullHyperlinkDetector.class;
	}

	public com.google.inject.Provider<org.eclipse.xtext.resource.containers.IAllContainersState> provideIAllContainersState() {
		if (Access.getJdtHelper().get().isJavaCoreAvailable()) {
			return Access.getJavaProjectsState();
		} else {
			return Access.getWorkspaceProjectsState();
		}
	}

	@Override
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
}
