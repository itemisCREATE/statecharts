/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.ui.hyperlink;

import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;
import org.yakindu.base.expressions.scoping.IPackageImport2URIMapper;
import org.yakindu.base.expressions.scoping.IPackageImport2URIMapper.PackageImport;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.sct.model.stext.stext.ImportScope;
import org.eclipse.jface.text.hyperlink.IHyperlink;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class PackageImportHyperlinkHelper extends HyperlinkHelper {

	@Inject
	private IPackageImport2URIMapper mapper;

	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		createPackageImportHyperlinksByOffset(resource, offset, acceptor);
		super.createHyperlinksByOffset(resource, offset, acceptor);
	}

	protected void createPackageImportHyperlinksByOffset(XtextResource resource, int offset,
			IHyperlinkAcceptor acceptor) {
		INode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
		if (node != null && node.getGrammarElement() instanceof RuleCall
				&& node.getSemanticElement() instanceof ImportScope) {
			NodeModelUtils.findNodesForFeature(node.getSemanticElement(), TypesPackage.Literals.PACKAGE__IMPORTS);
			ImportScope importScope = (ImportScope) node.getSemanticElement();
			EList<String> imports = importScope.getImports();
			for (String pkgImport : imports) {
				Optional<PackageImport> mappedImport = mapper.findPackageImport(resource, pkgImport);
				if (mappedImport.isPresent()) {
					acceptor.accept(createHyperlink(node, mappedImport.get()));
				}
			}
		}
	}

	protected IHyperlink createHyperlink(INode node, final PackageImport pkgImport) {
		XtextHyperlink result = getHyperlinkProvider().get();
		result.setURI(pkgImport.getUri());
		Region region = new Region(node.getOffset(), node.getLength());
		result.setHyperlinkRegion(region);
		result.setHyperlinkText(pkgImport.getUri().toString());
		return result;
	}
}