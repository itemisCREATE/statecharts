/*
 * Timer Service for SCTUnit
 */

#ifndef SC_TIMER_SERVICE_H_
#define SC_TIMER_SERVICE_H_

#include <list>

#include "sc_types.h"
#include "StatemachineInterface.h"
#include "TimedStatemachineInterface.h"
#include "TimerInterface.h"

#ifdef __cplusplus
extern "C" {
#endif

class SctUnitTimerService : public TimerInterface {
	public:
		SctUnitTimerService(StatemachineInterface * statemachine, bool event_driven, sc_integer cycle_period);
		~SctUnitTimerService(){}
		void proceed(sc_integer time_ms);
		virtual void setTimer(TimedStatemachineInterface* statemachine, sc_eventid event, sc_integer time_ms, sc_boolean isPeriodic);
		virtual void unsetTimer(TimedStatemachineInterface* statemachine, sc_eventid event);
		virtual void cancel();
	private:
		class SctTimer;
		StatemachineInterface * statemachine;
		
		bool event_driven;
		sc_integer cycle_period;

		std::list<SctTimer> timer_queue;
		void insert_timer(SctTimer timer);
};

class SctUnitTimerService::SctTimer {
	friend class SctUnitTimerService;
	public:
		SctTimer(sc_integer time_ms, bool periodic, sc_eventid evid, sc_integer priority, sc_boolean is_runcycle);
		~SctTimer(){}
		void proceed(sc_integer time_ms);
		
		sc_integer compare(SctTimer * other);
		
		void reset();
		
	private:
		sc_integer remaining_time_ms;
		sc_integer initial_time_ms;
		sc_boolean periodic;
		sc_eventid pt_evid;
		sc_integer priority;
		sc_boolean is_runcycle;
};

#ifdef __cplusplus
}
#endif

#endif /* SC_TIMER_SERVICE_H_ */

