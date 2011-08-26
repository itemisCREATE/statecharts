package org.yakindu.sct.model.stext.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Builder;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory;

/**
 * This class is used to always set a current model when the context for the
 * proposal provider is created. It is used to propose Events as Transition
 * triggers.
 * 
 */
public class STextStatefulFactory extends StatefulFactory {
	private IParseResult parseResult;

	@Override
	public ContentAssistContext[] create(ITextViewer viewer, int offset,
			XtextResource resource) throws BadLocationException {
		this.parseResult = resource.getParseResult();
		return super.create(viewer, offset, resource);
	}

	@Override
	public Builder doCreateContext(INode lastCompleteNode,
			EObject currentModel, EObject previousModel, INode currentNode,
			String prefix) {
		if (currentModel == null) {
			currentModel = parseResult.getRootASTElement();
		}
		Builder result = super.doCreateContext(lastCompleteNode, currentModel,
				previousModel, currentNode, prefix);
		return result;
	}
}
