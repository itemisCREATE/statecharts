
#ifndef TIMERINTERFACE_H_
#define TIMERINTERFACE_H_

#include "sc_types.h"

//forward declaration of TimedStatemachineInterface to avoid cyclic dependency
class TimedStatemachineInterface;

/*! \file Basic interface for state machines.
 */
class TimerInterface
{
	public:
		
		virtual ~TimerInterface() = 0;
	
		/*! Starts the timing for a time event.
		 */ 
		virtual void setTimer(TimedStatemachineInterface* statemachine, sc_eventid event, sc_integer time, sc_boolean isPeriodic) = 0;
		
		/*! Unsets the given time event.
		 */
		virtual void unsetTimer(TimedStatemachineInterface* statemachine, sc_eventid event) = 0;
	
		/*! Cancel timer service. Use this to end possible timing threads and free
		 	 memory resources.
		 */
		virtual void cancel() = 0;
};

inline TimerInterface::~TimerInterface() {}

#endif /* TIMERINTERFACE_H_ */
