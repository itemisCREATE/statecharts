package de.itemis.xtext.utils.gmf.parser;

import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.IAntlrParser;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.parsetree.reconstr.Serializer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import de.itemis.xtext.utils.gmf.Activator;

public abstract class XtextAntlrParserDelegate implements IParser {

	protected Injector injector;
	private String parserRuleToApply;

	public XtextAntlrParserDelegate(Module module,
			String parserRuleToApply) {
		this.injector = Guice.createInjector(module);
		this.parserRuleToApply = parserRuleToApply;
	}

	public IParserEditStatus isValidEditString(IAdaptable element,
			String editString) {
		if (editString == null || editString.equals("")) {
			return ParserEditStatus.EDITABLE_STATUS;
		}
		return getParseStatus(parserRuleToApply, editString);
	}

	protected IParserEditStatus getParseStatus(String editString) {
		return getParseStatus(parserRuleToApply, editString);
	}

	protected IParseResult getParseResult(String editString) {
		return getParseResult(parserRuleToApply, editString);
	}

	protected IParseResult getParseResult(String parserRuleToApply,
			String editString) {
		try {
			IAntlrParser parser = constructXtextParser();
			return parser
					.parse(parserRuleToApply, new StringReader(editString));
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}
	}

	protected IParserEditStatus getParseStatus(String parserRuleToApply,
			String editString) {
		try {
			IParseResult parseResult = getParseResult(parserRuleToApply,
					editString);

			CompositeNode rootNode = parseResult.getRootNode();
			if (rootNode != null) {
				List<SyntaxError> allSyntaxErrors = getAllSyntaxErrors(rootNode);
				if (allSyntaxErrors.isEmpty()) {
					return ParserEditStatus.EDITABLE_STATUS;
				}
				return new ParserEditStatus(IParserEditStatus.ERROR,
						Activator.PLUGIN_ID, IParserEditStatus.EDITABLE,
						allSyntaxErrors.get(0).getMessage(), null);
			} else {
				return new ParserEditStatus(IParserEditStatus.ERROR,
						Activator.PLUGIN_ID, IParserEditStatus.EDITABLE,
						parseResult.getParseErrors().get(0).getMessage(), null);
			}
		} catch (Exception e) {
			return new ParserEditStatus(IParserEditStatus.ERROR,
					Activator.PLUGIN_ID, IParserEditStatus.EDITABLE,
					e.getMessage(), e);
		}
	}

	private List<SyntaxError> getAllSyntaxErrors(AbstractNode node) {
		List<SyntaxError> syntaxErrors = new ArrayList<SyntaxError>();
		// collect syntax errors of all child nodes
		if (node instanceof CompositeNode) {
			for (AbstractNode childNode : ((CompositeNode) node).getChildren()) {
				syntaxErrors.addAll(getAllSyntaxErrors(childNode));
			}
		}
		// add syntax errors of given node
		if (node.getSyntaxError() != null) {
			syntaxErrors.add(node.getSyntaxError());
		}
		return syntaxErrors;
	}

	protected IAntlrParser constructXtextParser()
			throws IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {

		IAntlrParser parser = (IAntlrParser) injector
				.getInstance(IAntlrParser.class);
		return parser;
	}

	protected Serializer constructXtextSerializer() {
		Serializer serializer = injector.getInstance(Serializer.class);
		return serializer;
	}

	protected ICommand createSetValueCommand(EObject element,
			EAttribute feature, Object value) {
		SetRequest request = new SetRequest(element, feature, value);
		return new SetValueCommand(request);
	}

	
	public String getPrintString(IAdaptable element, int flags) {
		// by default, assume edit and print string are identical.
		return getEditString(element, flags);
	}

	
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// NOT NEEDED HERE
		return null;
	}
}