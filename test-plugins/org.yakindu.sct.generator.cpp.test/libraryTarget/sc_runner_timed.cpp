/*
 * Timer Service Implementation for SCTUnit
 */

#include "sc_runner_timed.h"

/**
 * Implementation of a timer service that uses _virtual_ time to raise time events.
 * It is solely meant for use with sctunit.
 */

TimedSctUnitRunner::TimedSctUnitRunner(
		StatemachineInterface * statemachine,
		bool event_driven,
		sc_integer cycle_period
		) :
		statemachine(statemachine),
		event_driven(event_driven),
		cycle_period(event_driven ? -1 : cycle_period),
		current_time_ms(0),
		timer_queue()
{
	if(!event_driven) {
		SctTimer runCycle(
			0,
			cycle_period,
			true,
			0,
			-1,
			true
		);
		insert_timer(runCycle);
	}
}

void TimedSctUnitRunner::proceed_time(sc_integer time_ms)
{
	sc_integer stop_time_ms = current_time_ms + time_ms;
	bool processed_timer = false;

	do {
		
		// first assume we won't process a timer
		processed_timer = false;

		// and then check if there is a timer to process
		if( ! timer_queue.empty()) {
			SctTimer next = timer_queue.front();

			if(next.abs_time_ms <= stop_time_ms) {
				timer_queue.pop_front();
				current_time_ms = next.abs_time_ms;

				/* Repeat and reinsert timer? */
				if(next.periodic) {
					insert_timer(next);
				}

				if(next.is_runcycle) {
					statemachine->runCycle();
				} else {
					next.tsi->raiseTimeEvent(next.pt_evid);
				}
				processed_timer = true;
			}
		}

	} while ( processed_timer );

	// As a postcondition the current time is the time after proceeding the specified period.
	current_time_ms = stop_time_ms;
}

void TimedSctUnitRunner::proceed_cycles(sc_integer cycles)
{
	sc_integer elapsed_cycles = 0;
		
	while(elapsed_cycles < cycles) {
		if(timer_queue.empty()) {
			return;
		}
		SctTimer next = timer_queue.front();
		
		timer_queue.pop_front();
		
		current_time_ms = next.abs_time_ms;
		
		std::list<SctTimer>::iterator i_timer;
		
		/* Repeat and reinsert timer? */
		if(next.periodic) {
			insert_timer(next);
		}
		
		if(next.is_runcycle) {
			statemachine->runCycle();
			++elapsed_cycles;
		} else {
			next.tsi->raiseTimeEvent(next.pt_evid);
		}
	}
}
void TimedSctUnitRunner::setTimer(TimedStatemachineInterface* statemachine, sc_eventid event, sc_integer time_ms, sc_boolean isPeriodic)
{
	SctTimer timer(statemachine, time_ms, isPeriodic, event, 0, false);
	insert_timer(timer);
}

void TimedSctUnitRunner::unsetTimer(TimedStatemachineInterface* statemachine, sc_eventid event)
{
	std::list<SctTimer>::iterator i_timer = timer_queue.begin();
	while(i_timer != timer_queue.end() && i_timer->tsi == statemachine) {
		if(i_timer->pt_evid == event) {
			timer_queue.erase(i_timer);
			return;
		}
		++i_timer;
	}
}

void TimedSctUnitRunner::cancel()
{
	std::list<SctTimer>::iterator i_timer = timer_queue.begin();
	while(i_timer != timer_queue.end()) {
		i_timer = timer_queue.erase(i_timer);
	}
}
void TimedSctUnitRunner::insert_timer(SctTimer timer) 
{
	timer.abs_time_ms = current_time_ms + timer.rel_time_ms;
	
	std::list<SctTimer>::iterator i_timer;
	
	/* Either the list is empty, so we put the new timer in directly... */
	if(timer_queue.empty()) {
		timer_queue.push_front(timer);
		return;
	}
	
	
	/* Or we put it before some other timer that needs to be raised after this one */
	for(i_timer = timer_queue.begin(); i_timer != timer_queue.end(); ++i_timer) {
		if(timer.compare(&(*i_timer)) < 0) {
			timer_queue.insert(i_timer, timer);
			return;
		}
	}
	
	/* Or it gets put into the back of the list. */
	timer_queue.push_back(timer);
}

TimedSctUnitRunner::SctTimer::SctTimer(
		TimedStatemachineInterface * tsi,
		sc_integer time_ms,
		bool periodic,
		sc_eventid evid,
		sc_integer priority,
		sc_boolean is_runcycle
		) :
		tsi(tsi),
		rel_time_ms(time_ms),
		abs_time_ms(0),
		periodic(periodic),
		pt_evid(evid),
		priority(priority),
		is_runcycle(is_runcycle)
{}

sc_integer TimedSctUnitRunner::SctTimer::compare(SctTimer * other)
{
	sc_integer result = abs_time_ms - other->abs_time_ms;
	if(result != 0) {
		return result;
	} else {
		// bigger priority needs to be raised first
		result = other->priority - priority;
		return result;
	}
}
