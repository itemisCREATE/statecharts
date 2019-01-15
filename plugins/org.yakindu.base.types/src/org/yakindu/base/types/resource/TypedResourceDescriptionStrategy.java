/**
 * Copyright (c) 2013 committers of YAKINDU and others. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html Contributors:
 * committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.base.types.resource;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Package;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeAlias;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.TypedElement;
import org.yakindu.base.types.TypesPackage;

import com.google.common.collect.Maps;

public class TypedResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {

	/**
	 * This flag is true if the element has or contains elements with an unknown
	 * resp. unsupported type
	 */
	public static final String HAS_UNKNOWN_TYPE = "has_unknown_type";

	/**
	 * For types that are visible (<code>Type.isVisible()==true</code>) this flag is
	 * true, otherwise false
	 */
	public static final String IS_VISIBLE_TYPE = "is_visible_type";

	/**
	 * Type aliases whose original type is an enumeration type will have this flag
	 * set to true, otherwise this flag is missing
	 */
	public static final String IS_ALIAS_ON_ENUM = "is_alias_on_enum";

	/**
	 * This flag indicates the if the type of a TypedElelemnt is complex or not
	 */
	public static final String HAS_COMPLEX_TYPE = "has_complex_type";

	/**
	 * Holds an operations's signature as produced by the corresponding
	 * {@link IItemLabelProvider}
	 */
	public static final String OPERATION_SIGNATURE = "operation_signature";

	@Override
	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if (getQualifiedNameProvider() == null)
			return false;
		try {
			QualifiedName qualifiedName = getQualifiedNameProvider().getFullyQualifiedName(eObject);
			if (qualifiedName != null) {
				Map<String, String> userData = Maps.newHashMap();
				defineUserData(eObject, userData);
				acceptor.accept(EObjectDescription.create(qualifiedName, eObject, userData));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return eObject instanceof Package || eObject instanceof ComplexType;
	}

	protected void defineUserData(EObject eObject, Map<String, String> userData) {
		if (eObject instanceof TypedElement) {
			userData.put(HAS_UNKNOWN_TYPE, String.valueOf(isUnknownType((TypedElement) eObject)));
			userData.put(HAS_COMPLEX_TYPE, String.valueOf(hasComplexType((TypedElement) eObject)));
		}
		if (eObject instanceof Type) {
			userData.put(IS_VISIBLE_TYPE, String.valueOf(((Type) eObject).isVisible()));
		}
		if (eObject instanceof TypeAlias) {
			if (((TypeAlias) eObject).getOriginType() instanceof EnumerationType) {
				userData.put(IS_ALIAS_ON_ENUM, String.valueOf(true));
			}
		}
	}

	protected boolean isUnknownType(TypedElement element) {
		return false;
	}

	protected boolean hasComplexType(TypedElement element) {
		return false; // element.getType() instanceof ComplexType;
	}

	protected String getOperationSignature(Operation operation) {
		if (operation.getName() == null) {
			return "null";
		}
		StringBuilder builder = new StringBuilder(operation.getName());
		builder.append("(");
		EList<Parameter> parameters = operation.getParameters();
		String sep = "";
		Iterator<Parameter> iterator = parameters.iterator();
		while (iterator.hasNext()) {
			Parameter parameter = iterator.next();
			builder.append(sep);
			builder.append(parameter.getName());
			builder.append(" : ");
			String typeName = getTypeName(parameter.getTypeSpecifier());
			builder.append(typeName);
			sep = ", ";
		}
		builder.append(")");
		if (operation.getType() != null) {
			builder.append(" : ");
			String name = getTypeName(operation.getTypeSpecifier());
			builder.append(name == null ? "void" : name);
		}
		return builder.toString();
	}

	protected String getTypeName(TypeSpecifier typeSpecifier) {
		Type type = (Type) typeSpecifier.eGet(TypesPackage.Literals.TYPE_SPECIFIER__TYPE, false);
		String typeName = "";
		if (type == null) {
			typeName = "null";
		} else if (type.eIsProxy()) {
			URI eProxyURI = ((InternalEObject) type).eProxyURI();
			typeName = StringUtils.substringAfterLast(eProxyURI.fragment(), ".");
		} else {
			typeName = type.getName();
		}
		return typeName;
	}

}