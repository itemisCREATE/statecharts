/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.domain.generic.editor;


import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.resource.TypedResourceDescriptionStrategy;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.ui.contentassist.STextProposalProvider;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * @author thomas kutz - package import and operation proposals
 * @author BeckmaR - extraction into superclass
 *
 */
public abstract class LanguageDomainProposalProvider extends STextProposalProvider {

	@Inject
	protected IResourceDescriptions descriptions;

	@Override
	protected void suppressKeywords(List<Keyword> suppressKeywords, StatechartSpecification model) {
		// do not suppress 'import' anymore
		suppressKeywords.addAll(getKeywords(grammarAccess.getExitEventAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getEntryEventAccess().getGroup().eContents()));
	}

	@Override
	protected StyledString getStyledDisplayString(EObject element, String qualifiedName, String shortName) {
		if (element instanceof Type) {
			return computeStyledString((Type) element, qualifiedName, shortName);
		}
		if (element instanceof Operation) {
			return computeStyledString((Operation) element, qualifiedName, shortName);
		}
		if (element instanceof Property) {
			return computeStyledString((Property) element, qualifiedName, shortName);
		}
		return super.getStyledDisplayString(element, qualifiedName, shortName);
	}

	protected StyledString computeStyledString(Operation operation, String qualifiedName, String shortName) {
		String signature = getUserData(operation, getOperationSignatureUserDataKey());
		if (signature != null && !signature.isEmpty()) {
			StyledString firstPart = new StyledString(signature);
			StyledString secondPart = getPackageImportStyleString(EcoreUtil.getURI(operation));
			return firstPart.append(secondPart);
		}
		return super.getStyledDisplayString(operation, qualifiedName, shortName);
	}

	protected String getOperationSignatureUserDataKey() {
		return TypedResourceDescriptionStrategy.OPERATION_SIGNATURE;
	}

	protected StyledString computeStyledString(Type type, String qualifiedName, String shortName) {
		String displayString = getDisplayString(type, qualifiedName, shortName);
		int i = displayString.lastIndexOf("-");
		if (i >= 0) {
			String simplePart = displayString.substring(0, i);
			String qualifiedPart = displayString.substring(i);
			return new StyledString(simplePart, getStyleForSimpleNamePart(type))
					.append(new StyledString(qualifiedPart, getStyleForQualifiedNamePart(type)));
		} else {
			return new StyledString(displayString, getStyleForSimpleNamePart(type));
		}
	}

	protected StyledString computeStyledString(Property prop, String qualifiedName, String shortName) {
		String displayString = getDisplayString(prop, qualifiedName, shortName);
		if (prop == null || prop.eIsProxy()) {
			return new StyledString(shortName, null).append(getPackageImportStyleString(EcoreUtil.getURI(prop)));
		}
		return new StyledString(displayString, null);
	}

	protected Styler getStyleForQualifiedNamePart(Type type) {
		return new GreyoutStyler();
	}

	protected Styler getStyleForSimpleNamePart(Type type) {
		if (isUnknownType(type)) {
			return new StrikeThroughStyler();
		}
		return null;
	}

	protected boolean isUnknownType(Type type) {
		String isUnknowType = getUserData(type, TypedResourceDescriptionStrategy.HAS_UNKNOWN_TYPE);
		return Boolean.valueOf(isUnknowType);
	}

	protected String getUserData(EObject eobject, String userDataKey) {
		URI uri = EcoreUtil.getURI(eobject).trimFragment();
		IResourceDescription resourceDescription = descriptions.getResourceDescription(uri);
		if (resourceDescription != null) {
			Iterable<IEObjectDescription> exportedObjectsByObject = descriptions.getResourceDescription(uri)
					.getExportedObjectsByObject(eobject);
			if (Iterables.size(exportedObjectsByObject) == 1) {
				IEObjectDescription next = exportedObjectsByObject.iterator().next();
				return next.getUserData(userDataKey);
			}
		}
		return null;
	}
}
