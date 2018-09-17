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
package org.yakindu.sct.generator.c;

import org.yakindu.sct.generator.c.files.StatemachineSource;
import org.yakindu.sct.generator.c.submodules.StatemachineSourceFragment;
import org.yakindu.sct.generator.c.submodules.eventdriven.EventDrivenStatemachineSourceFragment;

/**
 * @author rbeckmann
 *
 */
public class SourceContentFragmentProvider extends AbstractContentFragmentProvider<StatemachineSource> {
	@Override
	public StatemachineSource get() {
		StatemachineSource source = new StatemachineSource();
		injector.injectMembers(source);

		source.getContentProviders().add(injector.getInstance(StatemachineSourceFragment.class));
		if (isEventDriven()) {
			source.getContentProviders().add(injector.getInstance(EventDrivenStatemachineSourceFragment.class));
		}
		return source;
	}
}
