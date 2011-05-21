package de.itemis.xtext.utils.gmf.resource;

import java.io.StringReader;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.Linker;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;

import com.google.inject.Inject;
import com.google.inject.internal.Lists;

/**
 * 
 * Abstract base implementation for {@link IMemberInjectionService} s which use
 * Xtext to describe parts of the model textual. An {@link EStructuralFeature}
 * can be specified where the Xtext expression is stored in. (Must be of type
 * EString). The abstract base implementation provides hook methods where the
 * feature values can be copied from the parser result to the original object. <br />
 * Furthermore a {@link ReparseAdapter} is registered on the
 * {@link EStructuralFeature} and if the expression string changes, the
 * expression is reparsed.
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 * @param <S>
 *            Type of the original Metamodel object
 * @param <T>
 *            Type of the Root AST Object for the specified parser rule
 */
@SuppressWarnings("unchecked")
public abstract class AbstractXtextMemberInjectionService<S extends EObject, T extends EObject>
		implements IMemberInjectionService {

	private List<Diagnostic> errors = Lists.newArrayList();

	private List<Diagnostic> warnings = Lists.newArrayList();

	@Inject
	private IParser parser;
	//Injects a Linker (not an ILinker, this would lead to a LazyLinker)  
	@Inject
	private Linker linker;

	
	/**
	 * The ParserRule that should be invoked sith the expression
	 * 
	 * @return the parser rule
	 */
	public abstract String getParserRule();

	/**
	 * Hook method, where the feature values from the rootAST element can be
	 * copied to the original EObject
	 * 
	 * @param original
	 * @param rootAST
	 */
	public abstract void setFeatures(S original, T rootAST);

	/**
	 * {@inheritDoc}
	 */
	public void injectMembers(EObject object) {
		clearInternalState();
		EObject rootAst = parse((S) object);
		setFeatures((S) object, (T) rootAst);
		doLinking(object);
	}

	public String getExpression(S object) {
		// TODO add type checks and validation
		EAttribute feature = (EAttribute) getSourceFeature();
		String expression = (String) object.eGet(feature);
		return expression;
	}

	private S parse(S object) {
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName(getParserRule());
		String expression = getExpression(object);
		IParseResult result = parser.parse(parserRule, new StringReader(
				expression != null ? expression : ""));
		addSyntaxErrors(result);
		return (S) result.getRootASTElement();
	}

	protected void doLinking(EObject object) {
		final ListBasedDiagnosticConsumer consumer = new ListBasedDiagnosticConsumer();
		linker.linkModel(object, consumer);
		errors.addAll(consumer.getResult(Severity.ERROR));
		warnings.addAll(consumer.getResult(Severity.WARNING));
	}

	private void addSyntaxErrors(IParseResult result) {
		for (INode error : result.getSyntaxErrors()) {
			errors.add(new XtextSyntaxDiagnostic(error));
		}
	}

	private void clearInternalState() {
		errors.clear();
		warnings.clear();
	}

	public List<Diagnostic> getErrors() {
		return Collections.unmodifiableList(errors);
	}

	public List<Diagnostic> getWarnings() {
		return Collections.unmodifiableList(warnings);
	}

}
