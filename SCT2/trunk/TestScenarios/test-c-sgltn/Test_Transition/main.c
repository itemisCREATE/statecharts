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
const char* stateName[6] = {"State1", "State2", "State3", "State4", "State5", "State6"};

void setupStatemachine(Timer* dummyTimer, EventPool* eventPool)
{
	/* set up dummy Timer */
	dummyTimer_init(dummyTimer);

	/* Set up Event Pool */
	test_Transition_eventPool_init_heap(eventPool, MAXEVENTSPERTYPE);

	/* initialize state machine */
	test_TransitionStatemachine_init(dummyTimer, eventPool);

	/* call all necessary enter functions */
	test_TransitionStatemachine_enter();

}

void teardownStatemachine(Timer* dummyTimer, EventPool* eventPool)
{
	/* call all exit actions for this state machine */
	test_TransitionStatemachine_exit();

	/* free all internal memory for this state machine */
	test_TransitionStatemachine_destruct();

	/* free the timer */
	timer_exit(dummyTimer);

	/* free all events in the event pool */
	eventPool_exit(eventPool);

}


/*@Test: test_state9_state10_transition test behavior of var1 in default and other interface */
int test_state9_state10_transition()
{
//	Test_TransitionStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

//	machine = test_Transition_get_handle();

	/*@Desc: run the statechart for the first time (initially) */
	test_TransitionStatemachine_runCycle();


	/*@Desc: teardown statemachine */
	teardownStatemachine(&dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_default_var1 test behavior of var1 in default and other interface */
int test_state1_state2_back_transition()
{
//	Test_TransitionStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

//	machine = test_Transition_get_handle();

	/*@Desc: run an explicit cycle - without any waiting event (for initialization) */
	test_TransitionStatemachine_runCycle();

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
		return test_state9_state10_transition();
	case 2:
		return test_state1_state2_back_transition();
	}

	return -1;

}
