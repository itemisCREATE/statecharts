/*
 * Timer Service for SCTUnit
 */

#ifndef SC_TIMER_SERVICE_H_
#define SC_TIMER_SERVICE_H_

#include "sc_types.h"

#ifdef __cplusplus
extern "C" {
#endif

/*! file/ Interface definition of a POSIX thread based timer service for YAKINDU SCT stet machines. */

typedef struct {
	sc_integer rel_time_ms;
	sc_integer abs_time_ms;
	sc_boolean periodic;
	sc_eventid pt_evid;
	sc_integer priority;
	sc_boolean isRunCycle;
	void* handle;
} sc_timer_t;

typedef struct sc_timer_task_s {
	sc_timer_t timer;
	struct sc_timer_task_s * next;
} sc_timer_task_t;

/*! Function pointer type for state machines raiseEvent function. */
typedef void (*sc_raise_time_event_fp)(void *handle, sc_eventid evid);
typedef void (*sc_run_cycle_fp)(void *handle);

typedef struct {
	sc_timer_task_t * tasks;
	sc_raise_time_event_fp raise_event_func;
	sc_run_cycle_fp run_cycle_func;
	sc_boolean event_driven;
	sc_integer cycle_period;
	void* handle;
	sc_integer current_time_ms;

} sc_unit_timer_service_t;

void sc_timer_service_init(
	sc_unit_timer_service_t * ts,
	sc_raise_time_event_fp raise_event_func,
	sc_run_cycle_fp run_cycle_func,
	sc_boolean event_driven,
	sc_integer cycle_period,
	void* handle
);

void sc_timer_init(
	sc_timer_t * t,
	sc_integer time_ms,
	sc_boolean periodic,
	sc_eventid evid,
	void* handle
);


void sc_timer_service_proceed_time(sc_unit_timer_service_t * ts, sc_integer time_ms);
void sc_timer_service_proceed_cycles(sc_unit_timer_service_t * ts, sc_integer cycles);
sc_timer_t sc_timer_service_proceed(sc_unit_timer_service_t * ts);

void insert_timer(sc_unit_timer_service_t * ts, sc_timer_t te);

void delete_task(sc_unit_timer_service_t * ts, sc_timer_task_t* task);

sc_timer_task_t * find_time_event(sc_unit_timer_service_t * ts, sc_eventid evid);

sc_timer_task_t * pop_task(sc_unit_timer_service_t * ts);

sc_integer compare(sc_timer_t * a, sc_timer_t * b);

#ifdef __cplusplus
}
#endif

#endif /* SC_TIMER_SERVICE_H_ */

