/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.naming

import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.Formatter
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sgraph.Statechart
import java.util.List
import org.yakindu.sct.model.sexec.ExecutionScope
import com.google.inject.Inject
import org.yakindu.sct.model.stext.naming.StextNameProvider

/**
 * Helper class with methods to create meaningful short names for {@link ExecutionFlow}
 * elements. Intended to be used within generators to match target language identifier
 * character length restrictions.
 * 
 * @author Markus Muehlbrandt
 * 
 */
class NamingHelper {
	
	@Inject private StextNameProvider provider

	def dispatch String fqElementName(ExecutionState it, char separator) {
		provider.getFullyQualifiedName(it).skipFirst(2).toString(separator.toString)
	}
	
	def dispatch String fqElementName(ExecutionScope it, char separator) {
		provider.getFullyQualifiedName(it).skipFirst(2).toString(separator.toString)
	}

	def dispatch String fqElementName(EObject it, char separator) {
		eContainer.fqElementName(separator)
	}

	def dispatch String fqElementName(ExecutionNode it, char separator) {
		provider.getFullyQualifiedName(it).skipFirst(2).toString(separator.toString)
	}

	def dispatch String fqElementName(ExecutionFlow it, char separator) {
		""
	}

	def dispatch String fqElementName(Statechart it, char separator) {
		""
	}
	
	def dispatch String fqElementName(NamedElement it, char separator) {
		provider.getFullyQualifiedName(it).skipFirst(1).toString(separator.toString)
	}
	
	def containsName(List<String> it, String shortName) {
		findFirst[compareTo(shortName) == 0] != null
	}
	
	def String getHash(String text, int length) {
		if (length <= 0) {
			return ""
		}

		var hash = getHash(text)

		if (length > hash.length()) {
			hash = hash.substring(0, hash.length())
		} else {
			hash = hash.substring(0, length)
		}

		return hash.replace('0', 'a').replace('1', 'b').replace('2', 'c').replace('3', 'd').replace('4', 'e').
			replace('5', 'f').replace('6', 'g').replace('7', 'h').replace('8', 'i').replace('9', 'j')
	}

	def String getHash(String text) {
		var sha1 = ""
		try {
			var MessageDigest crypt = MessageDigest.getInstance("SHA-1")
			crypt.reset
			crypt.update(text.getBytes("UTF-8"))
			sha1 = byteToHex(crypt.digest)
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace()
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace
		}
		return sha1
	}

	def String byteToHex(byte[] hash) {
		var Formatter formatter = new Formatter
		for (byte b : hash) {
			formatter.format("%02x", b)
		}
		var String result = formatter.toString
		formatter.close
		return result
	}
}
