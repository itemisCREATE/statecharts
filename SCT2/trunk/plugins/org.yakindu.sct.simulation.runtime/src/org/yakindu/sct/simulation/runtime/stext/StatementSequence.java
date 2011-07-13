/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.stext;

import java.util.ArrayList;

import org.yakindu.sct.simulation.runtime.ExecutionScope;

/**
 * A statement sequence is a statement that executes a list of statements.
 *  
 * @author terfloth@itemis.de
 */
public class StatementSequence extends ArrayList<Statement> implements Statement {

	private static final long serialVersionUID = -7484316500582800045L;

	public void execute(ExecutionScope scope) {
		for (Statement stmt : this) {	
			stmt.execute(scope);
		}
	}

}
