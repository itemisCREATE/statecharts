/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.domain.extension;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DomainStatus {

	public static final DomainStatus OK = new DomainStatus(Severity.OK);

	public static enum Severity {
		OK, ERROR, WARNING, INFO
	}
	
	public static interface ILinkHandler {
		void handleLink();
	}

	private Severity status;
	private String message;
	private String shortMessage;
	private ILinkHandler linkHandler;
	
	public DomainStatus(Severity status, String message) {
		this(status, message, message, ()->{});
	}
	
	public DomainStatus(Severity status, String message, String shortMessage, ILinkHandler linkHandler) {
		this.status = status;
		this.message = message;
		this.shortMessage = shortMessage;
		this.linkHandler = linkHandler;
	}

	public DomainStatus(Severity status) {
		this.status = status;
	}

	public Severity getSeverity() {
		return status;
	}

	public String getMessage() {
		return message;
	}
	
	public String getShortMessage() {
		return shortMessage;
	}
	
	public void handleLink() {
		this.linkHandler.handleLink();
	}

}