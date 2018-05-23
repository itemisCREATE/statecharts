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
import org.yakindu.sct.generator.c.submodules.StatemachineSourceContentFragment;
import org.yakindu.sct.generator.c.submodules.eventdriven.EventDrivenStatemachineSourceContentProvider;

/**
 * @author rbeckmann
 *
 */
public class SourceContentFragmentProvider extends AbstractContentFragmentProvider<StatemachineSource> {
	@Override
	public StatemachineSource get() {
		StatemachineSource source = injector.getInstance(StatemachineSource.class);


		source.getContentProviders().add(injector.getInstance(StatemachineSourceContentFragment.class));
		if (isEventDriven()) {
			source.getContentProviders().add(injector.getInstance(EventDrivenStatemachineSourceContentProvider.class));
		}
		return source;
	}
}
