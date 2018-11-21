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

#ifndef TRACINGINTERFACEIMPL_H_
#define TRACINGINTERFACEIMPL_H_

class TracingInterfaceImpl : public Tracing , public Tracing::Tracing_TR{
public:
	TracingInterfaceImpl();
	virtual ~TracingInterfaceImpl();
	void tracing_stateEntered(Tracing::TracingStates state);
	void tracing_stateExited(Tracing::TracingStates state);

	bool isEntered() const {
		return entered;
	}

	void setEntered(bool entered = false) {
		this->entered = entered;
	}

	bool isExited() const {
		return exited;
	}

	void setExited(bool exited = false) {
		this->exited = exited;
	}

private:
	bool entered;
	bool exited;
};

TracingInterfaceImpl::TracingInterfaceImpl() {
	entered = false;
	exited = false;
}

TracingInterfaceImpl::~TracingInterfaceImpl() {}

void TracingInterfaceImpl::tracing_stateEntered(Tracing::TracingStates state) {entered = true;}
void TracingInterfaceImpl::tracing_stateExited(Tracing::TracingStates state) {exited = true;}


#endif /* TRACINGINTERFACEIMPL_H_ */
