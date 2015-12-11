#include "TimerInterface.h"

class Timer : public TimerInterface {
	
	private:
		TimedStatemachineInterface* statemachineSet;
		TimedStatemachineInterface* statemachineUnset;
		sc_eventid eventSet;
		sc_eventid eventUnset;
		sc_integer time;
		sc_boolean periodic;

	public:

		Timer();

		~Timer();

		void setTimer(TimedStatemachineInterface* statemachine, sc_eventid event, sc_integer time, sc_boolean isPeriodic);
		
		void unsetTimer(TimedStatemachineInterface* statemachine, sc_eventid event);
	
		void cancel();

		TimedStatemachineInterface* getStatemachineSet();

		TimedStatemachineInterface* getStatemachineUnset();

		sc_eventid getEventSet();

		sc_eventid getEventUnset();

		sc_integer getTime();

		sc_boolean isPeriodic();

};
