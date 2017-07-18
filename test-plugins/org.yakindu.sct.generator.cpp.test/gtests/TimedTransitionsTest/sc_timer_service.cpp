/*
 * Timer Service Implementation for SCTUnit
 */

#include "sc_timer_service.h"

/**
 * Implementation of a timer service that uses _virtual_ time to raise time events.
 * It is solely meant for use with sctunit.
 */

SctUnitTimerService::SctUnitTimerService(
		StatemachineInterface * statemachine,
		bool event_driven,
		sc_integer cycle_period
		) :
		statemachine(statemachine),
		event_driven(event_driven),
		cycle_period(event_driven ? -1 : cycle_period),
		timer_queue()
{
	if(!event_driven) {
		SctTimer runCycle(
			cycle_period,
			true,
			0,
			-1,
			true
		);
		insert_timer(runCycle);
	}
}

void SctUnitTimerService::proceed(sc_integer time_ms)
{
	sc_integer elapsed_time_ms = 0;
		
	while(elapsed_time_ms <= time_ms) {
		if(timer_queue.empty()) {
			return;
		}
		SctTimer next = timer_queue.front();
		
		if(next.remaining_time_ms + elapsed_time_ms > time_ms) {
			return;
		}
		timer_queue.pop_front();
		
		elapsed_time_ms += next.remaining_time_ms;
		
		std::list<SctTimer>::iterator i_timer;
		
		/* Reduce all remaining timer's time */
		for(i_timer = timer_queue.begin(); i_timer != timer_queue.end(); i_timer++) {
			i_timer->proceed(next.remaining_time_ms);
		}
		
		/* Repeat and reinsert timer? */
		if(next.periodic) {
			next.reset();
			insert_timer(next);
		}
		
		if(next.is_runcycle) {
			statemachine->runCycle();
		} else {
			TimedStatemachineInterface * tsi = dynamic_cast<TimedStatemachineInterface*>(statemachine);
			tsi->raiseTimeEvent(next.pt_evid);
		}
	}
}

void SctUnitTimerService::setTimer(TimedStatemachineInterface* statemachine, sc_eventid event, sc_integer time_ms, sc_boolean isPeriodic)
{
	SctTimer timer(time_ms, isPeriodic, event, 0, false);
	insert_timer(timer);
}

void SctUnitTimerService::unsetTimer(TimedStatemachineInterface* statemachine, sc_eventid event)
{
	std::list<SctTimer>::iterator i_timer = timer_queue.begin();
	while(i_timer != timer_queue.end()) {
		if(i_timer->pt_evid == event) {
			timer_queue.erase(i_timer);
			return;
		}
		i_timer++;
	}
}

void SctUnitTimerService::cancel()
{
	std::list<SctTimer>::iterator i_timer = timer_queue.begin();
	while(i_timer != timer_queue.end()) {
		i_timer = timer_queue.erase(i_timer);
	}
}

void SctUnitTimerService::insert_timer(SctTimer timer) 
{
	std::list<SctTimer>::iterator i_timer;
	
	/* Either the list is empty, so we put the new timer in directly... */
	if(timer_queue.empty()) {
		timer_queue.push_front(timer);
		return;
	}
	
	
	/* Or we put it before some other timer that needs to be raised after this one */
	for(i_timer = timer_queue.begin(); i_timer != timer_queue.end(); i_timer++) {
		if(timer.compare(&(*i_timer)) <= 0) {
			timer_queue.insert(i_timer, timer);
			return;
		}
	}
	
	/* Or it gets put into the back of the list. */
	timer_queue.push_back(timer);
}

SctUnitTimerService::SctTimer::SctTimer(
		sc_integer time_ms,
		bool periodic,
		sc_eventid evid,
		sc_integer priority,
		sc_boolean is_runcycle
		) :
		remaining_time_ms(time_ms),
		initial_time_ms(time_ms),
		periodic(periodic),
		pt_evid(evid),
		priority(priority),
		is_runcycle(is_runcycle)
{}

void SctUnitTimerService::SctTimer::proceed(sc_integer time_ms)
{
	remaining_time_ms -= time_ms;
}

void SctUnitTimerService::SctTimer::reset()
{
	remaining_time_ms = initial_time_ms;
}

sc_integer SctUnitTimerService::SctTimer::compare(SctTimer * other)
{
	sc_integer result = remaining_time_ms - other->remaining_time_ms;
	if(result != 0) {
		return result;
	} else {
		// bigger priority needs to be raised first
		result = other->priority - priority;
		return result;
	}
}
