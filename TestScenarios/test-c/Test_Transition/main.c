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
const int EnumTostateStr[3] = { _State1, _State2, last_state };

const char* getStateString(uint32_t index)
{
	int i;
	for (i=0; i<10; ++i)
		if (EnumTostateStr[i] == index)
			return stateName[i];
	return stateName[last_state];
}

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


/*@Test: test_state9_state10_transition test behavior of var1 in default and other interface */
int test_transition_with_AEvent1_value_gt5()
{
	Test_TransitionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: receive interface for scope A */
	ifaceA = test_TransitionStatemachine_get_interfaceA(&machine);

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

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_state9_state10_transition test behavior of var1 in default and other interface */
int test_transition_with_AEvent1_value_is_0()
{
	Test_TransitionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_TransitionIfA* ifaceA = 0;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: receive interface for scope A */
	ifaceA = test_TransitionStatemachine_get_interfaceA(&machine);

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

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_default_var1 test behavior of var1 in default and other interface */
int test_state1_state2_back_transition()
{
	Test_TransitionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: run an explicit cycle - without any waiting event (for initialization) */
	test_TransitionStatemachine_runCycle(&machine);

	/*@Desc:  */


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
		return test_transition_with_AEvent1_value_gt5();
	case 2:
		return test_transition_with_AEvent1_value_is_0();
	}

	return -1;

}
