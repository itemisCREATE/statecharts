/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.tasks;

import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.tasks.TaskTag;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SCTTask extends Task {

	private String semanticURI;
	private Task delgate;

	public SCTTask(Task delgate) {
		this.delgate = delgate;
	}

	public String getSemanticURI() {
		return semanticURI;
	}

	public void setSemanticURI(String semanticURI) {
		this.semanticURI = semanticURI;
	}

	public String getFullText() {
		return delgate.getFullText();
	}

	public int getTotalLength() {
		return delgate.getTotalLength();
	}

	public int getTagLength() {
		return delgate.getTagLength();
	}

	public TaskTag getTag() {
		return delgate.getTag();
	}

	public void setTag(TaskTag tag) {
		delgate.setTag(tag);
	}

	public String getDescription() {
		return delgate.getDescription();
	}

	public void setDescription(String description) {
		delgate.setDescription(description);
	}

	public int getLineNumber() {
		return delgate.getLineNumber();
	}

	public void setLineNumber(int lineNumber) {
		delgate.setLineNumber(lineNumber);
	}

	public int getOffset() {
		return delgate.getOffset();
	}

	public void setOffset(int offset) {
		delgate.setOffset(offset);
	}
	
	

}
