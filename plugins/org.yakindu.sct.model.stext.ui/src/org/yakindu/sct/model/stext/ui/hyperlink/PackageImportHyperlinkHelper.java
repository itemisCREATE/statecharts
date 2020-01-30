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

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.adapter.OriginTracing;
import org.yakindu.sct.model.sgraph.util.StatechartUtil;
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper;
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper.PackageImport;
import org.yakindu.sct.model.stext.stext.ImportScope;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
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
	
	@Inject
	private StatechartUtil statechartUtil;
	
	@Inject
	private OriginTracing tracing;

	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		createPackageImportHyperlinksByOffset(resource, offset, acceptor);
		super.createHyperlinksByOffset(resource, offset, acceptor);
	}

	protected void createPackageImportHyperlinksByOffset(XtextResource resource, int offset,
			IHyperlinkAcceptor acceptor) {
		INode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
		if (node != null && node.getGrammarElement() instanceof RuleCall
				&& node.getSemanticElement() instanceof ImportScope) {
			NodeModelUtils.findNodesForFeature(node.getSemanticElement(), TypesPackage.Literals.PACKAGE__IMPORT);
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
		result.setURI(pkgImport.getFileURI());
		Region region = new Region(node.getOffset(), node.getLength());
		result.setHyperlinkRegion(region);
		result.setHyperlinkText(pkgImport.getUri().toString());
		return result;
	}
	
	/**
	 * Produces hyperlinks for the given {@code region} that point to the referenced {@code target}.
	 * 
	 * Copied from {@link HyperlinkHelper} and exchanged target URI creation.
	 */
	@Override
	public void createHyperlinksTo(XtextResource from, Region region, EObject target, IHyperlinkAcceptor acceptor) {
		final URIConverter uriConverter = from.getResourceSet().getURIConverter();
		final String hyperlinkText = getLabelProvider().getText(target);
		final URI uri = computeURI(target);
		final URI normalized = uri.isPlatformResource() ? uri : uriConverter.normalize(uri);

		XtextHyperlink result = getHyperlinkProvider().get();
		result.setHyperlinkRegion(region);
		result.setURI(normalized);
		result.setHyperlinkText(hyperlinkText);
		acceptor.accept(result);
	}
	
	protected URI computeURI(EObject target) {
		Iterable<EObject> originTraces = IterableExtensions.filter(tracing.getOriginTraces(target), EObject.class);
		Iterator<EObject> iter = originTraces.iterator();
		if (iter.hasNext()) {
			target = iter.next();
		} else if (target instanceof Property) {
			Type type = ((Property) target).getType();
			if (statechartUtil.isOriginScope(type)) {
				target = statechartUtil.getOriginScope(type);
			}
		}
		return EcoreUtil.getURI(target);
	}
	
}