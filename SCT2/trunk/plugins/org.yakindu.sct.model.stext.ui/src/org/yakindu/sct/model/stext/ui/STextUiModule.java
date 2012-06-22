package org.yakindu.sct.model.stext.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.yakindu.sct.model.sgraph.ui.shared.Access2;
import org.yakindu.sct.model.stext.ui.contentassist.STextStatefulFactory;
import org.yakindu.sct.model.stext.ui.help.CustomCSSHelpHoverProvider;
import org.yakindu.sct.model.stext.ui.help.STextUserHelpDocumentationProvider;

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

	@Override
	public com.google.inject.Provider<org.eclipse.xtext.resource.containers.IAllContainersState> provideIAllContainersState() {
		return Access2.getJavaProjectsState();
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

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(String.class).annotatedWith(Names.named("stylesheet"))
				.toInstance("/StextHoverStyleSheet.css");
	}
}
