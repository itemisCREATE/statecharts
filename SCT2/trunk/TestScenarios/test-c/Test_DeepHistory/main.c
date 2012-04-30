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
#include "Test_DeepHistoryStatemachine.h"

/*@DTestSuite: ShallowHistory Statechart Test (Test_ShallowHistory.sct) */

#define MAXEVENTSPERTYPE 4
const char* stateName[10] = {"State1", "State2", "State3", "State4", "State5", "State6", "State7", "State8", "State9", "noState"};
const int EnumTostateStr[10] = { 
		_Test_DeepHistory_mainRegion_State1,
		_Test_DeepHistory_mainRegion_State2,
		_Test_DeepHistory_mainRegion_State2_region0_State3,
		_Test_DeepHistory_mainRegion_State2_region0_State4,
		_Test_DeepHistory_mainRegion_State2_region0_State5,
		_Test_DeepHistory_mainRegion_State2_region0_State4_region0_State6,
		_Test_DeepHistory_mainRegion_State2_region0_State4_region0_State7,
		_Test_DeepHistory_mainRegion_State2_region0_State4_region0_State7_region0_State8,
		_Test_DeepHistory_mainRegion_State2_region0_State4_region0_State7_region0_State9,
		last_state };

const char* getStateString(uint32_t index)
{
	int i;
	for (i=0; i<10; ++i)
		if (EnumTostateStr[i] == index)
			return stateName[i];
	return stateName[last_state];
}

void setupStatemachine(Test_DeepHistoryStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* set up dummy Timer */
	dummyTimer_init(dummyTimer);

	/* Set up Event Pool */
	test_DeepHistory_eventPool_init_heap(eventPool, MAXEVENTSPERTYPE);

	/* initialize state machine */
	test_DeepHistoryStatemachine_init(machine, dummyTimer, eventPool);

	/* call all necessary enter functions */
	test_DeepHistoryStatemachine_enter(machine);

}

void teardownStatemachine(Test_DeepHistoryStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* call all exit actions for this state machine */
	test_DeepHistoryStatemachine_exit(machine);

	/* free all internal memory for this state machine */
	test_DeepHistoryStatemachine_destruct(machine);

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


/*@Test: initialJumpToState3 test, if the initial state in state2 is activated */
int initialJumpToState3()
{
	Test_DeepHistoryStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_DeepHistoryIf* iface;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	iface = test_DeepHistoryStatemachine_get_iface(&machine);

	/*@Desc: check the initial state at position 0 to be State1 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	test_DeepHistory_if_raise_event1(iface);

	test_DeepHistoryStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 1 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State3") == 0);

	test_DeepHistory_if_raise_event2(iface);

	test_DeepHistoryStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 2 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);


	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_default_var1 test behavior of var1 in default and other interface */
int initialJumpToState5()
{
	Test_DeepHistoryStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	Test_DeepHistoryIf* iface;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	iface = test_DeepHistoryStatemachine_get_iface(&machine);

	/*@Desc: check the initial state at position 0 to be State1 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	test_DeepHistory_if_raise_event1(iface);

	test_DeepHistoryStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 1 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State3") == 0);

	test_DeepHistory_if_raise_event3(iface);

	test_DeepHistoryStatemachine_runCycle(&machine);

	test_DeepHistory_if_raise_event4(iface);

	test_DeepHistoryStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 2 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State5") == 0);

	test_DeepHistory_if_raise_event2(iface);

	test_DeepHistoryStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 to be State1 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	test_DeepHistory_if_raise_event1(iface);

	test_DeepHistoryStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 2 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State5") == 0);


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
		return initialJumpToState3();
	case 2:
		return initialJumpToState5();
	}

	return -1;

}
