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
#include "Test_ShallowHistoryStatemachine.h"

/*@DTestSuite: ShallowHistory Statechart Test (Test_ShallowHistory.sct) */

#define MAXEVENTSPERTYPE 4
const char* stateName[6] = {"State1", "State2", "State3", "State4", "State5", "State6"};

void setupStatemachine(Timer* dummyTimer, EventPool* eventPool)
{
	/* set up dummy Timer */
	dummyTimer_init(dummyTimer);

	/* Set up Event Pool */
	test_ShallowHistory_eventPool_init_heap(eventPool, MAXEVENTSPERTYPE);

	/* initialize state machine */
	test_ShallowHistoryStatemachine_init(dummyTimer, eventPool);

	/* call all necessary enter functions */
	test_ShallowHistoryStatemachine_enter();

}

void teardownStatemachine(Timer* dummyTimer, EventPool* eventPool)
{
	/* call all exit actions for this state machine */
	test_ShallowHistoryStatemachine_exit();

	/* free all internal memory for this state machine */
	test_ShallowHistoryStatemachine_destruct();

	/* free the timer */
	timer_exit(dummyTimer);

	/* free all events in the event pool */
	eventPool_exit(eventPool);

}

/*@Test: test_state9_state10_transition test behavior of var1 in default and other interface */
int dummy1()
{
//	Test_ShallowHistoryStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

	/* get the handle only for getting the state name */
//	machine = test_ShallowHistory_get_handle()();


	/*@Desc: teardown statemachine */
	teardownStatemachine(&dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_default_var1 test behavior of var1 in default and other interface */
int dummy2()
{
//	Test_ShallowHistoryStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

	/*@Desc: run an explicit cycle - without any waiting event (for initialization) */
	test_ShallowHistoryStatemachine_runCycle();

	/* get the handle only for getting the state name */
//	machine = test_ShallowHistory_get_handle()();


	/*@Desc:  */


	/*@Desc: teardown statemachine */
	teardownStatemachine(&dummyTimer, &eventPool);

	return 0;
}






int main(int argc, char** argv)
{
	if (argc != 2)
		return -1;

	switch (atoi(argv[1])) {
	case 1:
		return dummy1();
	case 2:
		return dummy2();
	}

	return -1;

}
