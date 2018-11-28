/*
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */

#include <string>
#include "gtest/gtest.h"
#include "Tracing.h"
#include "TraceObserverImpl.h"


TEST(Tracing, Tracing) {
	Tracing* statechart = new Tracing();
	TraceObserverImpl* tracingcallback = new TraceObserverImpl();
	
	statechart->init();
	statechart->setTraceObserver(tracingcallback);
	statechart->enter();
	EXPECT_TRUE(tracingcallback->isEntered());
	statechart->runCycle();
	EXPECT_TRUE(tracingcallback->isExited());
	EXPECT_TRUE(statechart->isFinal());
}
