/*
 * main.c
 *
 *  Created on: 16.11.2011
 *      Author: showcase
 */


#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include <time.h>
#include "Timer.h"
#include "DummyTimer.h"
#include "Test_ParallelRegionsStatemachine.h"
#include "definition.h"

//typedef long int int64_t;

/*@DTestSuite: ParallelRegions Statechart Test (Test_ParallelRegions.sct) */

#define MAXEVENTSPERTYPE 4
const char* stateName[10] = {"State1", "State2", "State3", "State4", "State5", "State6", "State7", "State8", "State9", "noState"};
const int EnumTostateStr[10] = { _State1, _State2, _State3, _State4, _State5, _State6, _State7, _State8, _State9, last_state };

int64_t timespecDiff(struct timespec *timeA_p, struct timespec *timeB_p)
{
  return ((timeA_p->tv_sec * 1000000000) + timeA_p->tv_nsec) -
           ((timeB_p->tv_sec * 1000000000) + timeB_p->tv_nsec);
}

const char* getStateString(uint32_t index)
{
	int i;
	for (i=0; i<10; ++i)
		if (EnumTostateStr[i] == index)
			return stateName[i];
	return stateName[last_state];
}

void setupStatemachine(Test_ParallelRegionsStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* set up dummy Timer */
	dummyTimer_init(dummyTimer);

	/* Set up Event Pool */
	test_ParallelRegions_eventPool_init_heap(eventPool, MAXEVENTSPERTYPE);

	/* initialize state machine */
	test_ParallelRegionsStatemachine_init(machine, dummyTimer, eventPool);

	/* call all necessary enter functions */
	test_ParallelRegionsStatemachine_enter(machine);

}

void teardownStatemachine(Test_ParallelRegionsStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* call all exit actions for this state machine */
	test_ParallelRegionsStatemachine_exit(machine);

	/* free all internal memory for this state machine */
	test_ParallelRegionsStatemachine_destruct(machine);

	/* free the timer */
	timer_exit(dummyTimer);

	/* free all events in the event pool */
	eventPool_exit(eventPool);

}


int main(int argc, char** argv)
{
	Test_ParallelRegionsStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	struct timespec start, end;
	int i;
	int max;

	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/* create some Events */
	_Event* ev;

	max = atoi(argv[1]);

	clock_gettime(CLOCK_MONOTONIC, &start);

	for (i=0; i<max; ++i) {
		int random = rand()%14;
		ev = eventPool_createEvent(machine.base.eventPool, random);
		if (!ev)
			abort();
		statemachine_cy_setEvent(&machine.base, ev);
		test_ParallelRegionsStatemachine_runCycle(&machine);
	}

	clock_gettime(CLOCK_MONOTONIC, &end);

    int64_t timeElapsed = timespecDiff(&end, &start);

    printf("Time is %lld per cycle %lld\n", timeElapsed, timeElapsed/max);

	return 0;
}
