package de.itemis.xtext.gmf.integration.utils;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.IAntlrParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Utility class to handle a XTextDocument.
 * 
 * @author andreas.muelder@itemis.de
 * @author alexander.nyssen@itemis.de
 * 
 */
public final class XtextUtils {

	private XtextUtils() {
	}

	/**
	 * 
	 * @param xtextModule
	 * @param expression
	 * @param scope
	 * @return
	 */
	public static final Pair<IParseResult, List<Diagnostic>> parseExpression(Module xtextModule, String expression,
			Iterable<Resource> scope) {
		Assert.isNotNull(expression);

		Injector injector = Guice.createInjector(xtextModule);

		XtextDocument document = XtextUtils.createDummyDocument(injector, null);
		XtextUtils.updateDocument(document, expression);
		return Tuples.<IParseResult, List<Diagnostic>> pair(getParseResult(document), getErrors(document));
	}

	/**
	 * Creates an dummy {@link XtextDocument}.
	 * 
	 * @param injector
	 * @param issueProcessor
	 * @return
	 */
	public static XtextDocument createDummyDocument(Injector injector, IValidationIssueProcessor issueProcessor) {
		XtextDocument document = injector.getInstance(XtextDocument.class);
		XtextResource resource = injector.getInstance(XtextResource.class);
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.getResources().add(resource);
		resource.setParser(injector.getInstance(IAntlrParser.class));
		fakeResourceUri(resource);
		document.setInput(resource);
		document.setValidationJob(createValidationJob(injector, document, issueProcessor));
		return document;
	}

	/**
	 * updates the content of an document.
	 * 
	 * @param document
	 * @param contents
	 */
	public static void updateDocument(final XtextDocument document, final String contents) {

		document.set(contents);
		// first step: Reparse documents content
		document.modify(new IUnitOfWork<Object, XtextResource>() {
			@Override
			public Object exec(XtextResource state) throws Exception {
				state.reparse(document.get());
				return null;
			}
		});
		// second step: checkfor unresolvable proxies
		document.readOnly(new IUnitOfWork<Object, XtextResource>() {
			@Override
			public Object exec(XtextResource state) throws Exception {
				EcoreUtil.resolveAll(state);
				return null;
			}
		});
	}

	public static List<Diagnostic> getErrors(XtextDocument document) {
		return document.readOnly(new IUnitOfWork<List<Resource.Diagnostic>, XtextResource>() {
			@Override
			public List<Diagnostic> exec(XtextResource state) throws Exception {
				return state.getErrors();
			}
		});
	}

	public static List<Diagnostic> getWarnings(XtextDocument document) {
		return document.readOnly(new IUnitOfWork<List<Resource.Diagnostic>, XtextResource>() {
			@Override
			public List<Diagnostic> exec(XtextResource state) throws Exception {
				return state.getWarnings();
			}
		});
	}

	public static IParseResult getParseResult(XtextDocument document) {
		return document.readOnly(new IUnitOfWork<IParseResult, XtextResource>() {
			@Override
			public IParseResult exec(XtextResource state) throws Exception {
				return state.getParseResult();
			}
		});
	}

	/**
	 * The xtexts default global scoping checks for the project name from the
	 * {@link XtextResource} to provide project wide scope. Because we do not
	 * have a "real" resource, we set the URI to the actives editors input
	 * project to provide a project wide scope.
	 * 
	 * @param resource
	 */
	private static void fakeResourceUri(final XtextResource resource) {
		// TODO Abhängikeit zu Project URI und Nature entfernen
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
				// if (activePage == null) {
				// resource.setURI(URI.createURI("platform:/resource/"
				// + System.currentTimeMillis() + "/dummy"));
				// return;
				// }
				IEditorInput editorInput = activePage.getActiveEditor().getEditorInput();
				if (editorInput instanceof FileEditorInput) {
					FileEditorInput input = (FileEditorInput) editorInput;
					String activeProject = input.getFile().getProject().getName();
					resource.setURI(URI.createURI("platform:/resource/" + activeProject + "/dummy"));
				}
			}
		});
	}

	private static ValidationJob createValidationJob(Injector injector, XtextDocument document,
			final IValidationIssueProcessor issueProcessor) {
		IResourceValidator validator = injector.getInstance(IResourceValidator.class);
		ValidationJob job = new ValidationJob(validator, document, issueProcessor != null ? issueProcessor
				: new IValidationIssueProcessor() {
					@Override
					public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
						// do nothing
					}
				}, CheckMode.NORMAL_AND_FAST);
		return job;
	}

}
