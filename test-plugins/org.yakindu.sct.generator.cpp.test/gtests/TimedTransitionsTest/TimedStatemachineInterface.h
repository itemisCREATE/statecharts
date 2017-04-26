
#ifndef TIMEDSTATEMACHINEINTERFACE_H_
#define TIMEDSTATEMACHINEINTERFACE_H_

#include "sc_types.h"
#include "TimerInterface.h"

/*! \file Interface for state machines which use timed event triggers.
*/
class TimedStatemachineInterface {
	public:
	
		virtual ~TimedStatemachineInterface() = 0;
		
		/*! Set the ITimerService for the state machine. It must be set
		    externally on a timed state machine before a run cycle can be correct
		    executed.
		*/
		virtual void setTimer(TimerInterface* timer) = 0;
		
		/*! Returns the currently used timer service.
		*/
		virtual TimerInterface* getTimer() = 0;
		
		/*! Callback method if a time event occurred.
		*/
		virtual void raiseTimeEvent(sc_eventid event) = 0;
};

inline TimedStatemachineInterface::~TimedStatemachineInterface() {}

#endif /* TIMEDSTATEMACHINEINTERFACE_H_ */
