/*
 * TracingInterfaceImpl.h
 *
 *  Created on: 21.11.2018
 *      Author: administrator
 */

#ifndef TRACINGINTERFACEIMPL_H_
#define TRACINGINTERFACEIMPL_H_

class TracingInterfaceImpl : public Tracing , public Tracing::Tracing_TR{
public:
	TracingInterfaceImpl();
	virtual ~TracingInterfaceImpl();
	void stateEntered(Tracing::TracingStates state);
	void stateExited(Tracing::TracingStates state);

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

void TracingInterfaceImpl::stateEntered(Tracing::TracingStates state) {entered = true;}
void TracingInterfaceImpl::stateExited(Tracing::TracingStates state) {exited = true;}


#endif /* TRACINGINTERFACEIMPL_H_ */

