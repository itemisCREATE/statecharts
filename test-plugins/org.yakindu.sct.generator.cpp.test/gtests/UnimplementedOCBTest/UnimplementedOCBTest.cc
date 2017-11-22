//**
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
#include "UnimplementedOCB.h"
#include "OCBDefaultInterfaceImpl.h"
#include "OCBInternalImpl.h"
#include "OCBNamedInterfaceImpl.h"


TEST(UnimplementedOCBTest, UnimplementedOCBTest) {
	UnimplementedOCB* statechart = new UnimplementedOCB();
	OCBDefaultInterfaceImpl* di = new OCBDefaultInterfaceImpl();
	OCBNamedInterfaceImpl* ni = new OCBNamedInterfaceImpl();
	OCBInternalImpl* ii = new OCBInternalImpl();
	
	EXPECT_TRUE(statechart->init() < 0);
	statechart->setDefaultSCI_OCB(di);
	EXPECT_TRUE(statechart->init() < 0);
	statechart->setSCI_Named_OCB(ni);
	EXPECT_TRUE(statechart->init() < 0);
	statechart->setInternalSCI_OCB(ii);
	EXPECT_TRUE(statechart->init() == 0);
	delete statechart;
}
