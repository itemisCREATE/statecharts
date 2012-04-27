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
#include "Test_TransitionStatemachine.h"

/*@DTestSuite: Hierachy Statechart Test (Test_Transition.sct) */

#define MAXEVENTSPERTYPE 4
const char* stateName[3] = {"State1", "State2", "noState"};
const int EnumTostateStr[3] = { _Test_Transition_region0_State1, _Test_Transition_region0_State2, last_state };

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

void setupStatemachine(Test_TransitionStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* set up dummy Timer */
	dummyTimer_init(dummyTimer);

	/* Set up Event Pool */
	test_Transition_eventPool_init_heap(eventPool, MAXEVENTSPERTYPE);

	/* initialize state machine */
	test_TransitionStatemachine_init(machine, dummyTimer, eventPool);

	/* call all necessary enter functions */
	test_TransitionStatemachine_enter(machine);

}

void setupStatemachineMyTimer(Test_TransitionStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* set up dummy Timer */
	myTimer_init(dummyTimer);

	/* Set up Event Pool */
	test_Transition_eventPool_init_heap(eventPool, MAXEVENTSPERTYPE);

	/* initialize state machine */
	test_TransitionStatemachine_init(machine, dummyTimer, eventPool);

	/* call all necessary enter functions */
	test_TransitionStatemachine_enter(machine);

}

void teardownStatemachine(Test_TransitionStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* call all exit actions for this state machine */
	test_TransitionStatemachine_exit(machine);

	/* free all internal memory for this state machine */
	test_TransitionStatemachine_destruct(machine);

	/* free the timer */
	timer_exit(dummyTimer);

	/* free all events in the event pool */
	eventPool_exit(eventPool);

}

/*@Test: test_default_var1 test behavior of var1 in default interface */
int test_initialization()
{

	return 0;
}


/*@Test: test_transition_with_AEvent1_value_gt5 test transition to state2 with event1 on Interface A carrying value 6 */
int test_transition_with_AEvent1_value_gt5()
{
	Test_TransitionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;
	Test_TransitionIf* iface = 0;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: receive interface for scope A */
	ifaceA = test_TransitionStatemachine_get_ifaceA(&machine);

	/*@Desc: receive interface for default scope */
	iface = test_TransitionStatemachine_get_iface(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: set event1 on interface A with value 6 */
	test_Transition_if_A_raise_event1(ifaceA, 6);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State2") == 0);

	/*@Desc: check whether i is set to 2 */
	assert( test_Transition_if_get_i(iface) == 1);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_transition_with_AEvent1_value_is_0 test whether there is no transition if event1 of interface A is set with value equal 0 */
int test_transition_with_AEvent1_value_is_0()
{
	Test_TransitionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;
	Test_TransitionIf* iface = 0;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: receive interface for scope A */
	ifaceA = test_TransitionStatemachine_get_ifaceA(&machine);

	/*@Desc: receive interface for default scope */
	iface = test_TransitionStatemachine_get_iface(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: set event1 on interface A with value 0 */
	test_Transition_if_A_raise_event1(ifaceA, 0);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: check whether i is set to default 0 */
	assert( test_Transition_if_get_i(iface) == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_transition_with_AEvent1_value_lt0 test transition to state2 with event1 on Interface A carrying value -1 */
int test_transition_with_AEvent1_value_lt0()
{
	Test_TransitionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;
	Test_TransitionIf* iface = 0;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: receive interface for scope A */
	ifaceA = test_TransitionStatemachine_get_ifaceA(&machine);

	/*@Desc: receive interface for default scope */
	iface = test_TransitionStatemachine_get_iface(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: set event1 on interface A with value 6 */
	test_Transition_if_A_raise_event1(ifaceA, -1);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State2") == 0);

	/*@Desc: check whether i is set to 2 */
	assert( test_Transition_if_get_i(iface) == 2);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_transition_with_no_event_and_i_eq_5 test whether there is a transition due to the guard [i==5]*/
int test_transition_with_no_event_and_i_eq_5()
{
	Test_TransitionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_TransitionIf* iface = 0;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: receive interface for scope A */
	iface = test_TransitionStatemachine_get_iface(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: set event1 on interface A with value 0 */
	test_Transition_if_set_i(iface, 5);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State2") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_transition_with_no_event_and_i_eq_5 test whether there is a transition due to the guard [i==5]*/
int test_transition_event2_set_with_event1_unconditioned()
{
	Test_TransitionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: receive interface for scope A */
	ifaceA = test_TransitionStatemachine_get_ifaceA(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: raise event2 on interface A*/
	test_Transition_if_A_raise_event2(ifaceA);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: this will actually produce a segmentation faults */

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

int test_transition_event2_set_with_event1_value_set_before()
{
	Test_TransitionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;
	Test_TransitionIf* iface = 0;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: receive interface for scope A */
	ifaceA = test_TransitionStatemachine_get_ifaceA(&machine);

	/*@Desc: receive interface for default scope */
	iface = test_TransitionStatemachine_get_iface(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: raise event2 on interface A*/
	test_Transition_if_A_raise_event1(ifaceA, -6);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State2") == 0);

	/*@Desc: raise event6 on default interface*/
	test_Transition_if_raise_event6(iface);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: raise event2 on interface A*/
	test_Transition_if_A_raise_event2(ifaceA);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State2") == 0);


	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

int test_transition_with_Event3_j_lt_20()
{
	Test_TransitionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;
	Test_TransitionIf* iface = 0;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: receive interface for scope A */
	ifaceA = test_TransitionStatemachine_get_ifaceA(&machine);

	/*@Desc: receive interface for default scope */
	iface = test_TransitionStatemachine_get_iface(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: set event1 on interface A with value 0 */
	test_Transition_if_set_j(iface, 10);

	/*@Desc: set event1 on interface A with value 6 */
	test_Transition_if_A_raise_event3(ifaceA);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State2") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

int test_transition_with_Event3_j_gt_30()
{
	Test_TransitionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;
	Test_TransitionIf* iface = 0;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: receive interface for scope A */
	ifaceA = test_TransitionStatemachine_get_ifaceA(&machine);

	/*@Desc: receive interface for default scope */
	iface = test_TransitionStatemachine_get_iface(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: set event1 on interface A with value 0 */
	test_Transition_if_set_j(iface, 40);

	/*@Desc: set event1 on interface A with value 6 */
	test_Transition_if_A_raise_event3(ifaceA);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State2") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

int test_transition_with_Event3_j_eq_25()
{
	Test_TransitionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;
	Test_TransitionIf* iface = 0;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: receive interface for scope A */
	ifaceA = test_TransitionStatemachine_get_ifaceA(&machine);

	/*@Desc: receive interface for default scope */
	iface = test_TransitionStatemachine_get_iface(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: set variable j to value 25 */
	test_Transition_if_set_j(iface, 25);

	/*@Desc: set event3 on default interface */
	test_Transition_if_A_raise_event3(ifaceA);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

int test_transition_with_Event4_j_gt_30()
{
	Test_TransitionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;
	Test_TransitionIf* iface = 0;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: receive interface for scope A */
	ifaceA = test_TransitionStatemachine_get_ifaceA(&machine);

	/*@Desc: receive interface for default scope */
	iface = test_TransitionStatemachine_get_iface(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: set variable j to value 40 */
	test_Transition_if_set_j(iface, 40);

	/*@Desc: set event4 on interface A */
	test_Transition_if_A_raise_event4(ifaceA);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State2") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

int test_transition_with_Event4_j_lt_30()
{
	Test_TransitionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;
	Test_TransitionIf* iface = 0;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: receive interface for scope A */
	ifaceA = test_TransitionStatemachine_get_ifaceA(&machine);

	/*@Desc: receive interface for default scope */
	iface = test_TransitionStatemachine_get_iface(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: set event1 on interface A with value 0 */
	test_Transition_if_set_j(iface, 20);

	/*@Desc: set event1 on interface A with value 6 */
	test_Transition_if_A_raise_event4(ifaceA);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

int test_after_transition_at_100_ms()
{
	Test_TransitionStatemachine machine;
	Timer myTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;
	Test_TransitionIf* iface = 0;

	/*@Desc: setup initial statemachine */
	setupStatemachineMyTimer(&machine, &myTimer, &eventPool);

	/*@Desc: receive interface for scope A */
	ifaceA = test_TransitionStatemachine_get_ifaceA(&machine);

	/*@Desc: receive interface for default scope */
	iface = test_TransitionStatemachine_get_iface(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*Desc: check whether timer is set correctly */
	assert (timerValue == 100 || timerValue == 10000);
	assert (timerPeriodic == bool_false);

	/*@Desc: set event1 on interface A with value 0 */
	test_Transition_if_set_j(iface, 40);

	/*@Desc: set event1 on interface A with value 6 */
	test_Transition_if_A_raise_event4(ifaceA);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State2") == 0);

	/*Desc: check whether timer is set correctly */
	assert (timerValue == 0 );
	assert (timerPeriodic == bool_false);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &myTimer, &eventPool);

	return 0;
}

int test_after_transition_eventHandling_100ms()
{
	Test_TransitionStatemachine machine;
	Timer myTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;
	Test_TransitionIf* iface = 0;
	_Event* time_100ms;

	/*@Desc: setup initial statemachine */
	setupStatemachineMyTimer(&machine, &myTimer, &eventPool);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*Desc: check whether timer is set correctly */
	assert (timerValue == 100 || timerValue == 10000);
	assert (timerPeriodic == bool_false);

	/*@Desc: create timer event */
	time_100ms = eventPool_createEvent(machine.base.eventPool, ev_state1_time_event_0);

	/*@Desc: set event1 on interface A with value 0 */
	statemachine_cy_setEvent((Statemachine_cy*)&machine, time_100ms);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State2") == 0);

	/*Desc: check whether timer is set correctly */
	assert (timerValue == 0 );
	assert (timerPeriodic == bool_false);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &myTimer, &eventPool);

	return 0;
}

int test_after_transition_eventHandling_10s()
{
	Test_TransitionStatemachine machine;
	Timer myTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;
	Test_TransitionIf* iface = 0;
	_Event* time_100ms;

	/*@Desc: setup initial statemachine */
	setupStatemachineMyTimer(&machine, &myTimer, &eventPool);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*Desc: check whether timer is set correctly */
	assert (timerValue == 100 || timerValue == 10000);
	assert (timerPeriodic == bool_false);

	/*@Desc: create timer event */
	time_100ms = eventPool_createEvent(machine.base.eventPool, ev_state1_time_event_1);

	/*@Desc: set event1 on interface A with value 0 */
	statemachine_cy_setEvent((Statemachine_cy*)&machine, time_100ms);

	/*@Desc: run an explicit cycle */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State2") == 0);

	/*Desc: check whether timer is set correctly */
	assert (timerValue == 0 );
	assert (timerPeriodic == bool_false);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &myTimer, &eventPool);

	return 0;
}

int main(int argc, char** argv)
{
	if (argc != 2)
		return -1;

	switch (atoi(argv[1])) {
	case 1:
		return test_transition_with_AEvent1_value_gt5();
	case 2:
		return test_transition_with_AEvent1_value_is_0();
	case 3:
		return test_transition_with_AEvent1_value_lt0();
	case 4:
		return test_transition_with_no_event_and_i_eq_5();
	case 5:
		return test_transition_event2_set_with_event1_unconditioned();
	case 6:
		return test_transition_event2_set_with_event1_value_set_before();
	case 7:
		return test_transition_with_Event3_j_lt_20();
	case 8:
		return test_transition_with_Event3_j_eq_25();
	case 9:
		return test_transition_with_Event3_j_gt_30();
	case 10:
		return test_transition_with_Event4_j_gt_30();
	case 11:
		return test_transition_with_Event4_j_lt_30();
	case 12:
		return test_after_transition_at_100_ms();
	case 13:
		return test_after_transition_eventHandling_100ms();
	case 14:
		return test_after_transition_eventHandling_10s();
	}

	return -1;

}
