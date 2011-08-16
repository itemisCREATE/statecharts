/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.common.util;

import java.io.IOException;
import java.util.Formatter;

/**
 * @author Andreas Unger
 *
 */
public class PrintAppendable {

	private Appendable appendable;
	private Formatter formatter;
	private IOException ioException;
	
	/**
	 * 
	 */
	public PrintAppendable(Appendable appendable) {
		this.appendable = appendable;
	}
	
	public PrintAppendable print(CharSequence charSequence) {
		try {
			appendable.append(charSequence);
		} catch (IOException e) {
			ioException = e;
		}
		return this;
	}
	
	public PrintAppendable println() {
		try {
			appendable.append("\n");
		} catch (IOException e) {
			ioException = e;
		}
		return this;
	}

	public PrintAppendable println(CharSequence charSequence) {
		try {
			appendable.append(charSequence).append("\n");
		} catch (IOException e) {
			ioException = e;
		}
		return this;
	}

	public PrintAppendable printf(String format, Object... args) {
		IOException ioException = getFormatter().format(format, args).ioException();
		if (ioException != null) {
			this.ioException = ioException;
		}
		return this;
	}

	/**
	 * @return the ioException
	 */
	public IOException getIOException() {
		return ioException;
	}
	
	private Formatter getFormatter() {
		if (formatter == null) {
			formatter = new Formatter(appendable);
		}
		return formatter;
	}
	
}
