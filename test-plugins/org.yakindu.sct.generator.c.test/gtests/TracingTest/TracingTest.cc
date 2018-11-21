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
#include "TracingRequired.h"

Tracing statechart;

bool entered = false;
bool exited = false;

void tracing_stateEntered(Tracing* handle, const TracingStates state){
	entered = true;
}

void tracing_stateExited(Tracing* handle, const TracingStates state){
	exited = true;
}

TEST(Tracing, Tracing) {
	tracing_init(&statechart);
	tracing_enter(&statechart);
	EXPECT_TRUE(entered);
	tracing_runCycle(&statechart);
	EXPECT_TRUE(exited);
	EXPECT_TRUE(tracing_isFinal(&statechart));
}
