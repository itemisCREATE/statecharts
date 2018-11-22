/*
 * TraceObserverImpl.h
 *
 *  Created on: 22.11.2018
 *      Author: administrator
 */

#ifndef TRACEOBSERVERIMPL_H_
#define TRACEOBSERVERIMPL_H_

#include "Tracing.h"

class TraceObserverImpl : public TraceObserver<Tracing::TracingStates>{
public:
	TraceObserverImpl();
	virtual ~TraceObserverImpl();
	void stateEntered(Tracing::TracingStates state);
	void stateExited(Tracing::TracingStates state);

	bool isEntered() const {
		return entered;
	}

	bool isExited() const {
		return exited;
	}

private:
	bool entered;
	bool exited;
};

TraceObserverImpl::TraceObserverImpl() {
	entered = false;
	exited = false;
}

TraceObserverImpl::~TraceObserverImpl() {}

void TraceObserverImpl::stateEntered(Tracing::TracingStates state) {entered = true;}
void TraceObserverImpl::stateExited(Tracing::TracingStates state) {exited = true;}

#endif /* TRACEOBSERVERIMPL_H_ */
