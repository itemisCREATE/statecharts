/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.ui.syntaxcoloring;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.BuiltinDefinition;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.IterationCall;
import org.eclipselabs.mscript.language.ast.Module;
import org.eclipselabs.mscript.language.ast.StepExpression;
import org.eclipselabs.mscript.typesystem.Unit;

/**
 * @author Andreas Unger
 *
 */
public class MscriptSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator#provideHighlightingFor(org.eclipse.xtext.resource.XtextResource, org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor)
	 */
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (resource == null || resource.getParseResult() == null) {
			return;
		}

		Module module = (Module) resource.getParseResult().getRootASTElement();
		for (TreeIterator<EObject> it = module.eAllContents(); it.hasNext();) {
			EObject next = it.next();
			if (next instanceof FunctionDefinition) {
				List<INode> nodes = NodeModelUtils.findNodesForFeature(next, AstPackage.eINSTANCE.getDefinition_Name());
				for (INode node : nodes) {
					acceptor.addPosition(node.getOffset(), node.getLength(), MscriptHighlightingConfiguration.FUNCTION_ID);
				}
			} else if (next instanceof FeatureCall) {
				FeatureCall featureCall = (FeatureCall) next;
				if (featureCall.getFeature() instanceof BuiltinDefinition) {
					List<INode> nodes = NodeModelUtils.findNodesForFeature(featureCall, AstPackage.eINSTANCE.getFeatureCall_Feature());
					for (INode node : nodes) {
						acceptor.addPosition(node.getOffset(), node.getLength(), MscriptHighlightingConfiguration.BUILTIN_ID);
					}
				}
			} else if (next instanceof IterationCall) {
				List<INode> nodes = NodeModelUtils.findNodesForFeature(next, AstPackage.eINSTANCE.getIterationCall_Identifier());
				for (INode node : nodes) {
					acceptor.addPosition(node.getOffset(), node.getLength(), MscriptHighlightingConfiguration.ITERATION_ID);
				}
			} else if (next instanceof Unit) {
				INode node = NodeModelUtils.getNode(next);
				acceptor.addPosition(node.getOffset(), node.getLength(), MscriptHighlightingConfiguration.UNIT_ID);
				it.prune();
			} else if (next instanceof StepExpression) {
				INode node = NodeModelUtils.getNode(next);
				acceptor.addPosition(node.getOffset(), node.getLength(), MscriptHighlightingConfiguration.STEP_EXPRESSION_ID);
				it.prune();
			}
		}
	}

}
