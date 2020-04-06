/*
 * Timer Service Implementation for SCTUnit
 */

#include "sc_timer_service.h"

#include <stdlib.h>

/**
 * Implementation of a timer service that uses _virtual_ time to raise time events.
 * It is solely meant for use with sctunit.
 */

void sc_timer_service_init(
		sc_unit_timer_service_t * ts,
		sc_raise_time_event_fp raise_event_func,
		sc_run_cycle_fp run_cycle_func,
		sc_boolean event_driven,
		sc_integer cycle_period,
		void* handle
		)
{
	ts->raise_event_func = raise_event_func;
	ts->tasks = 0;
	ts->run_cycle_func = run_cycle_func;
	ts->event_driven = event_driven;
	ts->cycle_period = cycle_period;
	ts->handle = handle;
	ts->current_time_ms = 0;
	
	if(!ts->event_driven) {
		sc_timer_t run_cycle;
		sc_timer_init(
			&run_cycle,
			ts->cycle_period,
			true,
			0);
		run_cycle.isRunCycle = true;
		run_cycle.priority = -1;
		insert_timer(ts, run_cycle);
	}
}

void sc_timer_init(
	sc_timer_t * t,
	sc_integer time_ms,
	sc_boolean periodic,
	sc_eventid evid
)
{
	t->rel_time_ms = time_ms;
	t->abs_time_ms = 0;
	t->periodic = periodic;
	t->pt_evid = evid;
	t->priority = 0;
	t->isRunCycle = false;
}

void sc_timer_service_proceed_time(sc_unit_timer_service_t * ts, sc_integer time_ms)
{
	sc_integer stop_time_ms = ts->current_time_ms + time_ms;
	sc_boolean processed_timer = false;
	
	do {
		/* first assume we won't process a timer */
		processed_timer = false;
	
		/* and then check if there is a timer to process */
		if( ts->tasks != 0) {
			if(ts->tasks->timer.abs_time_ms <= stop_time_ms) {
	
				sc_timer_task_t * next_task = pop_task(ts);
				sc_timer_t next = next_task->timer;
				free(next_task);
	
				/* shift time to the timer absolute time */
				ts->current_time_ms = next.abs_time_ms;
	
				/* reschedule periodic timer */
				if(next.periodic) {
					insert_timer(ts, next);
				}
	
				/* process timer ... */
				if(next.isRunCycle) {
					ts->run_cycle_func(ts->handle);
				} else {
					ts->raise_event_func(ts->handle, next.pt_evid);
				}
	
				processed_timer = true;
			}
		}
	
	} while ( processed_timer );
	
	/* As a postcondition the current time is the time after proceeding the specified period. */
	ts->current_time_ms = stop_time_ms;
}

void sc_timer_service_proceed_cycles(sc_unit_timer_service_t * ts, sc_integer cycles)
{
	sc_integer elapsed_cycles = 0;
	
	while(elapsed_cycles < cycles) {
		sc_timer_task_t * next_task;
		sc_timer_t next;
		if(ts->tasks == 0) {
			return;
		}
		next_task = pop_task(ts);
		next = next_task->timer;
		free(next_task);
		
		ts->current_time_ms = next.abs_time_ms;
		
		/* Repeat the event? */
		if(next.periodic) {
			insert_timer(ts, next);
		}

		/* Process event */
		if(next.isRunCycle) {
			ts->run_cycle_func(ts->handle);
			elapsed_cycles++;
		} else {
			ts->raise_event_func(ts->handle, next.pt_evid);
		}
	}
}

sc_timer_t sc_timer_service_proceed(sc_unit_timer_service_t * ts)
{
	sc_timer_task_t * next_task = pop_task(ts);
	sc_timer_t next = next_task->timer;
	free(next_task);
	
	ts->current_time_ms = next.abs_time_ms;
	
	/* Repeat the event? */
	if(next.periodic) {
		insert_timer(ts, next);
	}
	
	return next;
}

void delete_task(sc_unit_timer_service_t * ts, sc_timer_task_t * task)
{
	if(!task) {
		return;
	}
	if(ts->tasks == task) {
		ts->tasks = ts->tasks->next;

	} else {
		sc_timer_task_t * current = ts->tasks->next;
		sc_timer_task_t * last = ts->tasks;
		while(current) {
			if(current == task) {
				last->next = current->next;
			}
			else {
				last = last->next;
			}
			current = current->next;
		}
	}
	free(task);
}

sc_timer_task_t * find_time_event(sc_unit_timer_service_t * ts, sc_eventid evid)
{
	sc_timer_task_t * task = ts->tasks;
	while(task && task->timer.pt_evid != evid) {
		task = task->next;
	}
	return task;
}

void insert_timer(sc_unit_timer_service_t * ts, sc_timer_t te)
{
	sc_timer_task_t * head = ts->tasks;
	sc_timer_task_t * new_task = (sc_timer_task_t *) malloc(sizeof(sc_timer_task_t));
	sc_timer_task_t * last = head;
	te.abs_time_ms = ts->current_time_ms + te.rel_time_ms;
	new_task->timer = te;
	new_task->next = 0;
	if(head == 0) {
		ts->tasks = new_task;
		return;
	}

	/* Check if we should put it in as first element */
	if(compare(&te, &(head->timer)) < 0) {
		new_task->next = head;
		ts->tasks = new_task;
		return;
	}

	head = head->next;
	while(head != 0) {
		if(compare(&te, &(head->timer)) < 0) {
			new_task->next = head;
			last->next = new_task;
			return;
		}
		last = head;
		head = head->next;
	}

	/* put it in last position */
	last->next = new_task;
}

sc_timer_task_t * pop_task(sc_unit_timer_service_t * ts) {
	sc_timer_task_t * head = ts->tasks;
	if(head != 0) {
		ts->tasks = head->next;
	}
	return head;
}

/* Returns negative when a needs to be raised before b, 0 when a<>b, positive when a after b */
sc_integer compare(sc_timer_t * a, sc_timer_t * b) {
	/* smaller time_ms needs to be raised first */
	sc_integer result = a->abs_time_ms - b->abs_time_ms;
	if(result != 0) {
		return result;
	} else {
		/* bigger priority needs to be raised first */
		result = b->priority - a->priority;
		return result;
	}
}

