/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.slang.generator.typesystem;

import java.util.concurrent.ExecutionException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.expressions.expressions.Literal;
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression;
import org.yakindu.base.expressions.expressions.StringLiteral;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.Expression;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.Singleton;

@Singleton
public class TargetPlatformProvider {

	private LoadingCache<String, ITypeSystemInferrer> typeSystemInferrerCache = CacheBuilder.newBuilder()
			.build(new CacheLoader<String, ITypeSystemInferrer>() {
				@Override
				public ITypeSystemInferrer load(String id) throws Exception {
					return DomainRegistry.getDomain(id).getInjector(IDomain.FEATURE_RESOURCE, false)
							.getInstance(ITypeSystemInferrer.class);
				}

			});

	private LoadingCache<String, ITypeSystem> typeSystemCache = CacheBuilder.newBuilder()
			.build(new CacheLoader<String, ITypeSystem>() {
				@Override
				public ITypeSystem load(String id) throws Exception {
					return DomainRegistry.getDomain(id).getInjector(IDomain.FEATURE_RESOURCE, false)
							.getInstance(ITypeSystem.class);
				}

			});

	public ITypeSystemInferrer getTypeSystemInferrer(EObject context) {
		try {
			String domain = getDomain(context);
			return typeSystemInferrerCache.get(domain);
		} catch (ExecutionException e) {
			e.printStackTrace();

		}
		return null;

	}

	public ITypeSystem getTypeSystem(EObject context) {
		try {
			String domain = getDomain(context);
			return typeSystemCache.get(domain);
		} catch (ExecutionException e) {
			e.printStackTrace();

		}
		return null;

	}

	protected String getDomain(EObject context) {
		org.yakindu.base.types.Package p = (org.yakindu.base.types.Package) EcoreUtil.getRootContainer(context);
		EList<Annotation> annotations = p.getAnnotations();
		// TODO: cyclic resolution bei getAnnotationOfType
//			Annotation annotation = p.getAnnotationOfType("TargetPlatform");
		for (Annotation current : annotations) {
			String text = NodeModelUtils.getNode(current).getText();
			if (text.contains("TargetPlatform")) {
				Expression argument = current.getArguments().get(0);
				Literal value = ((PrimitiveValueExpression) argument).getValue();
				String domain = ((StringLiteral) value).getValue();
				return domain;
			}
		}
		return BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral();
	}

}
