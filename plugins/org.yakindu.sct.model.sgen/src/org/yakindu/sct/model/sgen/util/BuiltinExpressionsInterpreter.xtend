/** 
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * rbeckmann - initial API and implementation
 */
package org.yakindu.sct.model.sgen.util

import java.net.InetAddress
import java.nio.file.Files
import java.nio.file.Paths
import java.security.MessageDigest
import java.text.DateFormat
import java.util.Date
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.osgi.framework.FrameworkUtil
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.interpreter.DefaultExpressionInterpreter
import org.yakindu.base.types.Property
import org.yakindu.sct.model.sgen.GeneratorEntry

/** 
 * @author rbeckmann
 */
class BuiltinExpressionsInterpreter extends DefaultExpressionInterpreter implements BuiltinDeclarationNames {
	
	def dispatch Object execute(Void expression) {
		null
	}
	override dispatch Object execute(ElementReferenceExpression expression) {
		if (expression.reference instanceof Property) {
			switch ((expression.reference as Property).name) {
				case SCT_VERSION_VAR: {
					val v = FrameworkUtil.getBundle(getClass()).version
					return '''«v.major».«v.minor».«v.micro»'''.toString
				}
				case TIMESTAMP_VAR: {
					return DateFormat.getDateTimeInstance().format(new Date()).toString
				}
				case USER_VAR: {
					return System.getProperty("user.name").toString
				}
				case HOSTNAME_VAR: {
					return InetAddress.localHost.hostName.toString
				}
				case SHA256: {
					return sha256(expression)
				}
				case SCTFILE: {
					return sctfile(expression)
				}
				default:
					return executeElementReferenceExpression(expression)
			}

		}
		executeElementReferenceExpression(expression)
	}

	def String sha256(ElementReferenceExpression expression) {
		val uri = emfURI(expression)
		val nioPath = Paths.get(uri.toFile.location.toOSString)
		val content = Files.readAllBytes(nioPath)
		val byte[] hash = MessageDigest.getInstance("SHA-256").digest(content);
		bytesToHex(hash)
	}
	
	def sctfile(ElementReferenceExpression expression) {
		var path = emfURI(expression).toPlatformString(true)
		if(path.startsWith("/")) {
			path = path.substring(1)
		}
		path
	}
	
	def emfURI(EObject eObject) {
		val entry = EcoreUtil2.getContainerOfType(eObject, GeneratorEntry)
		EcoreUtil2.getURI(entry.elementRef) 
	}

	def String bytesToHex(byte[] hash) {
		val StringBuffer hexString = new StringBuffer();
		for (var i = 0; i < hash.length; i++) {
			var hex = Integer.toHexString(0xff.bitwiseAnd(hash.get(i)));
			if (hex.length() == 1) {
				hex = "0" + hex
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

	def IFile toFile(URI uri) {
		if (uri.isPlatformResource()) {
			val platformString = uri.toPlatformString(true)
			return ResourcesPlugin.getWorkspace().getRoot().findMember(platformString) as IFile;
		}
		return null;
	}

}
