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

#ifndef OCBDEFAULTINTERFACEIMPL_H_
#define OCBDEFAULTINTERFACEIMPL_H_

#include "UnimplementedOCB.h"

class OCBDefaultInterfaceImpl: public UnimplementedOCB::DefaultSCI_OCB {
public:
	OCBDefaultInterfaceImpl();
	virtual ~OCBDefaultInterfaceImpl();

	void defaultInterfaceOperation();
};


#endif /* OCBDEFAULTINTERFACEIMPL_H_ */
