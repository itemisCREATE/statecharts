/*
 * Timer Service Implementation for SCTUnit
 */

#include "sc_timer_service.h"

#include <malloc.h>

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
}

void sc_timer_init(
	sc_timer_t * t,
	sc_integer time_ms,
	sc_boolean periodic,
	sc_eventid evid
)
{
	t->initial_time_ms = time_ms;
	t->remaining_time_ms = time_ms;
	t->periodic = periodic;
	t->pt_evid = evid;
	t->priority = 0;
	t->isRunCycle = false;
}

void sc_timer_service_proceed(sc_unit_timer_service_t * ts, sc_integer time_ms)
{
	sc_integer time_ms_elapsed = 0;
	if(!ts->event_driven) {
		sc_timer_t run_cycle;
		run_cycle.isRunCycle = true;
		run_cycle.initial_time_ms = ts->cycle_period;
		run_cycle.remaining_time_ms = ts->cycle_period;
		run_cycle.pt_evid = 0;
		run_cycle.periodic = true;
		run_cycle.priority = -1;
		insert_timer(ts, run_cycle);
	}
	while(time_ms_elapsed <= time_ms) {
		sc_timer_task_t * next_task = pop_task(ts);
		sc_timer_t next;
		if(next_task == 0) {
			return;
		}
		next = next_task->timer;
		free(next_task);

		if(next.remaining_time_ms + time_ms_elapsed > time_ms) {
			delete_run_cycles(ts);
			return;
		}
		time_ms_elapsed += next.remaining_time_ms;

		// Reduce all remaining time events time
		sc_timer_task_t * head = ts->tasks;
		while(head != 0) {
			head->timer.remaining_time_ms -= next.remaining_time_ms;
			head = head->next;
		}

		// Repeat the event?
		if(next.periodic) {
			insert_timer(ts, next);
		}

		// Process event
		if(next.isRunCycle) {
			ts->run_cycle_func(ts->handle);
		} else {
			ts->raise_event_func(ts->handle, next.pt_evid);
		}
	}
	delete_run_cycles(ts);
}

void delete_task(sc_unit_timer_service_t * ts, sc_timer_task_t * task)
{
	if(!task) {
		return;
	}
	if(ts->tasks == task) {
		ts->tasks = ts->tasks->next;

	} else {
		sc_timer_task_t * this = ts->tasks->next;
		sc_timer_task_t * last = ts->tasks;
		while(this) {
			if(this == task) {
				last->next = this->next;
			}
			else {
				last = last->next;
			}
			this = this->next;
		}
	}
	free(task);
}

sc_timer_task_t * find_time_event(sc_unit_timer_service_t * ts, sc_eventid evid)
{
	sc_timer_task_t * this = ts->tasks;
	while(this && this->timer.pt_evid != evid) {
		this = this->next;
	}
	return this;
}

void insert_timer(sc_unit_timer_service_t * ts, sc_timer_t te)
{
	sc_timer_task_t * head = ts->tasks;
	sc_timer_task_t * new = (sc_timer_task_t *) malloc(sizeof(sc_timer_task_t));
	te.remaining_time_ms = te.initial_time_ms;
	new->timer = te;
	new->next = 0;
	if(head == 0) {
		ts->tasks = new;
		return;
	}

	// Check if we should put it in as first element
	if(compare(&te, &(head->timer)) <= 0) {
		new->next = head;
		ts->tasks = new;
		return;
	}

	sc_timer_task_t * last = head;
	head = head->next;
	while(head != 0) {
		if(compare(&te, &(head->timer)) <= 0) {
			new->next = head;
			last->next = new;
			return;
		}
		last = head;
		head = head->next;
	}

	// put it in last position
	last->next = new;
}

void delete_run_cycles(sc_unit_timer_service_t * ts)
{
	sc_timer_task_t * head = ts->tasks;
	sc_timer_task_t * last;
	sc_timer_task_t * to_delete;
	while(head != 0) {
		if(head->timer.isRunCycle) {
			if(!last) {
				ts->tasks = head->next;
			} else {
				last->next = head->next;
			}
			to_delete = head;
			head = head->next;
			free(to_delete);
		} else {
			last = head;
			head = head->next;
		}
	}
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
	if(a == 0) {
		puts("A is 0\n");
	}
	if(b == 0) {
		puts("B is 0\n");
	}
	// smaller time_ms needs to be raised first
	sc_integer result = a->remaining_time_ms - b->remaining_time_ms;
	if(result != 0) {
		return result;
	} else {
		// bigger priority needs to be raised first
		result = b->priority - a->priority;
		return result;
	}
}
