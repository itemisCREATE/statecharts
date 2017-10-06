/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.language

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author rbeckmann
 *
 */
class Comment extends CodePart {
	protected static final int MAX_LINE_LENGTH = 80
	
	@Accessors protected CharSequence comment
	
	new(CharSequence comment) {
		this.comment = comment
	}
	
	override toString() {
		if(comment.length < MAX_LINE_LENGTH) {
			'''/* «comment» */'''
		}
		else {
			splitComment.toString
		}
	}
	
	def splitComment() {
		val words = comment.toString.split(" ")
		val List<CharSequence> lines = newArrayList
		
		var line = ""
		
		for(word : words) {
			if(line.contains("\n")) {
				val parts = line.split("\n")
				lines.addAll(parts.subList(0, parts.size - 1))
				line = parts.last
			}
			if((line + word).length > MAX_LINE_LENGTH) {
				lines.add(line.trim)
				line = word + " "
			} else {
				line += word + " "
			}
		}
		lines.add(line.trim)
		
		'''
			/* 
			 «FOR l : lines»
			 	* «l»
			 «ENDFOR»
			 */
		'''
	}
	
}
