package org.yakindu.sct.generator.genmodel.ui.highlighting;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.yakindu.sct.model.sgen.DeprecatableElement;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.SGenPackage;
import org.yakindu.sct.model.sgen.impl.FeatureConfigurationImpl;

public class SGenSemanticHighlightingCalculator implements
		ISemanticHighlightingCalculator {

	public void provideHighlightingFor(XtextResource resource,
			IHighlightedPositionAcceptor acceptor) {
		if (resource == null || resource.getParseResult() == null)
			return;
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			final EObject object = allContents.next();
			if (object instanceof GeneratorEntry) {
				GeneratorEntry entry = (GeneratorEntry) object;

				List<INode> nodes = NodeModelUtils.findNodesForFeature(entry,
						SGenPackage.Literals.GENERATOR_ENTRY__CONTENT_TYPE);
				List<INode> features = NodeModelUtils.findNodesForFeature(
						entry, SGenPackage.Literals.GENERATOR_ENTRY__FEATURES);
				for (INode node : nodes) {
					if (node instanceof LeafNode
							&& !((LeafNode) node).isHidden()) {
						acceptor.addPosition(node.getTotalOffset(),
								node.getTotalLength(),
								DefaultHighlightingConfiguration.KEYWORD_ID);
					}
				}
				for (INode node : features) {
					if (node.getSemanticElement() instanceof FeatureConfigurationImpl) {
						FeatureConfigurationImpl feature = (FeatureConfigurationImpl) node
								.getSemanticElement();
						if (feature.getType() instanceof DeprecatableElement) {

							DeprecatableElement deprecatableElement = feature
									.getType();
							if (deprecatableElement.isDeprecated()) {
								acceptor.addPosition(
										node.getTotalOffset(),
										node.getTotalLength(),
										SGenHighlightingConfiguration.DEPRECATION);
							}
						}

					}

				}
				allContents.prune();
			}
		}
	}
}
