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
#include "Timer.h"
#include "DummyTimer.h"
#include "Test_LocalActionsStatemachine.h"

/*@DTestSuite: LocalActions Statechart Test (Test_LocalActions.sct) */

#define MAXEVENTSPERTYPE 4
const char* stateName[3] = {"State1", "State2", "noState"};
const int EnumTostateStr[3] = { _Test_LocalActions_mainRegion_State1, _Test_LocalActions_mainRegion_State2, last_state };

const char* getStateString(uint32_t index)
{
	int i;
	for (i=0; i<10; ++i)
		if (EnumTostateStr[i] == index)
			return stateName[i];
	return stateName[last_state];
}

/* Timer Test Environment START */

int myTimerSet = 0;
uint32_t timerValue;
sc_boolean timerPeriodic;

void setMyTimer(const uint32_t evid, const uint32_t time_ms, sc_boolean periodic)
{
	myTimerSet = 1;
	timerValue = time_ms;
	timerPeriodic = periodic;
	printf("myTimer: set event <%d> with time %dms\n", evid, time_ms);
}

void unsetMyTimer(const uint32_t evid)
{
	myTimerSet = -1;
	timerValue = 0;
	timerPeriodic = bool_false;
	printf("myTimer: unset event <%d>\n", evid);
}

void myTimer_init(Timer* handle)
{
	timer_setFPtr(handle, &setMyTimer, &unsetMyTimer);
}

/* Timer Test Environment END */

void setupStatemachine(Test_LocalActionsStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* set up dummy Timer */
	dummyTimer_init(dummyTimer);

	/* Set up Event Pool */
	test_LocalActions_eventPool_init_heap(eventPool, MAXEVENTSPERTYPE);

	/* initialize state machine */
	test_LocalActionsStatemachine_init(machine, dummyTimer, eventPool);

	/* call all necessary enter functions */
	test_LocalActionsStatemachine_enter(machine);

}

void setupStatemachineMyTimer(Test_LocalActionsStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* set up dummy Timer */
	myTimer_init(dummyTimer);

	/* Set up Event Pool */
	test_LocalActions_eventPool_init_heap(eventPool, MAXEVENTSPERTYPE);

	/* initialize state machine */
	test_LocalActionsStatemachine_init(machine, dummyTimer, eventPool);

	/* call all necessary enter functions */
	test_LocalActionsStatemachine_enter(machine);

}

void teardownStatemachine(Test_LocalActionsStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* call all exit actions for this state machine */
	test_LocalActionsStatemachine_exit(machine);

	/* free all internal memory for this state machine */
	test_LocalActionsStatemachine_destruct(machine);

	/* free the timer */
	timer_exit(dummyTimer);

	/* free all events in the event pool */
	eventPool_exit(eventPool);

}

/*@Test: localActions_check_initial_entry test whether the entry action is called within initialization */
int localActions_check_initial_entry()
{
	Test_LocalActionsStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check whether entry works on initialisation*/
	assert(test_LocalActions_if_get_i(test_LocalActionsStatemachine_get_iface(&machine)) == 1);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: localActions_check_transition_entry test whether the entry action is called after the Event1 transition*/
int localActions_check_transition_entry()
{
	Test_LocalActionsStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: raise event1 on default Interface */
	test_LocalActions_if_raise_Event1(test_LocalActionsStatemachine_get_iface(&machine));

	/*@Desc: run an explicit cycle */
	test_LocalActionsStatemachine_runCycle(&machine);

	/*@Desc: check whether entry works on initialisation*/
	assert(test_LocalActions_if_get_j(test_LocalActionsStatemachine_get_iface(&machine)) == 1);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: localActions_check_transition_exit test whether exit action in state 1 and 2 is called after the transitions */
int localActions_check_transition_exit()
{
	Test_LocalActionsStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: raise event1 on default Interface */
	test_LocalActions_if_raise_Event1(test_LocalActionsStatemachine_get_iface(&machine));

	/*@Desc: run an explicit cycle */
	test_LocalActionsStatemachine_runCycle(&machine);

	/*@Desc: check whether entry works on initialisation*/
	assert(test_LocalActions_if_get_i(test_LocalActionsStatemachine_get_iface(&machine)) == 0);

	/*@Desc: raise event1 on default Interface */
	test_LocalActions_if_raise_Event3(test_LocalActionsStatemachine_get_iface(&machine));

	/*@Desc: run an explicit cycle */
	test_LocalActionsStatemachine_runCycle(&machine);

	/*@Desc: check whether entry works on initialisation*/
	assert(test_LocalActions_if_get_j(test_LocalActionsStatemachine_get_iface(&machine)) == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

int main(int argc, char** argv)
{
	if (argc != 2)
		return -1;

	switch (atoi(argv[1])) {
	case 1:
		return localActions_check_initial_entry();
	case 2:
		return localActions_check_transition_entry();
	case 3:
		return localActions_check_transition_exit();
	}

	return -1;

}
