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

#ifndef SRC_GEN_OCBNAMEDINTERFACEIMPL_H_
#define SRC_GEN_OCBNAMEDINTERFACEIMPL_H_

#include "UnimplementedOCB.h"

class OCBNamedInterfaceImpl : public UnimplementedOCB::SCI_Named_OCB {
	public:
		OCBNamedInterfaceImpl();
		virtual ~OCBNamedInterfaceImpl();
		void namedInterfaceOperation();
};



#endif /* SRC_GEN_OCBNAMEDINTERFACEIMPL_H_ */
