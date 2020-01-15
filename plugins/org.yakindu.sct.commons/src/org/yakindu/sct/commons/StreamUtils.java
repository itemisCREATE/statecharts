/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.commons;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 *
 */
public class StreamUtils {

	public static <T, R> Function<T, Stream<R>> select(Class<R> clazz) {
		return e -> clazz.isInstance(e) ? Stream.of(clazz.cast(e)) : null;
	}

}
