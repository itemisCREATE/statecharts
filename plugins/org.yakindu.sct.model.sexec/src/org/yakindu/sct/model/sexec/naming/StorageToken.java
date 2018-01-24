/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.naming;

/**
 * @author rbeckmann
 *
 * Objects that are created when a string is inserted into the StringShortener, so that whoever
 * put the (long) string into it can get the (short) string back later - like a wardrobe.
 */
public class StorageToken {
	protected static long tokenID = 0;
	
	protected long myID;
	
	public StorageToken() {
		myID = tokenID;
		tokenID += 1;
	}
	
	@Override
	public String toString() {
		return "StorageToken[" + myID + "]";
	}
}
