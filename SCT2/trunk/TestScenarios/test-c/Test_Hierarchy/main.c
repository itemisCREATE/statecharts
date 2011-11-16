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
#include "Test_ExpressionStatemachine.h"
#include "Test_Hierarchy.h"

/*@DTestSuite: Hierachy Statechart Test (Test_Hierarchy.sct) */

#define MAXEVENTSPERTYPE 4
const char* stateName[6] = {"State1", "State2", "State3", "State4", "State5", "State6"};

void setupStatemachine(Test_HierarchyStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* set up dummy Timer */
	dummyTimer_init(dummyTimer);

	/* Set up Event Pool */
	eventPool_init_heap(eventPool, event_last, MAXEVENTSPERTYPE);

	/* initialize state machine */
	test_HierarchyStatemachine_init(machine, dummyTimer, eventPool);

}

void teardownStatemachine(Test_HierarchyStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	test_HierarchyStatemachine_exit(machine);
	timer_exit(dummyTimer);
	eventPool_exit(eventPool);

}

/*@Test: test_default_var1 test behavior of var1 in default interface */
int test_initialization()
{

	return 0;
}


/*@Test: test_state9_state10_transition test behavior of var1 in default and other interface */
int test_state9_state10_transition()
{
	Test_HierarchyStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);



	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_default_var1 test behavior of var1 in default and other interface */
int test_state1_state2_back_transition()
{
	Test_HierarchyStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: run an explicit cycle - without any waiting event (for initialization) */
	test_ExpressionStatemachine_runCycle(&machine);

	/*@Desc:  */


	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}




int test_default_other_var2_var3()
{
	Test_ExpressionStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	real testvalue1u = (19.4 + 19.4*123 + 0.1);
	real testvalue1l = (19.4 + 19.4*123 - 0.1);

	real testvalue2u = 19.4 + 19.4*123/5.0 + 0.1;
	real testvalue2l = 19.4 + 19.4*123/5.0 - 0.1;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check initial value for var2 ( == 123) */
	assert( test_Expression_if_get_var2(&machine.interface) == 123 );

	/*@Desc: check initial value for var3 (19.4) */
	assert( (test_Expression_if_get_var3(&machine.interface) > 19.3) &&
			(test_Expression_if_get_var3(&machine.interface) < 19.5));

	/*@Desc: run an explicit cycle - without any waiting event */
	test_ExpressionStatemachine_runCycle(&machine);

	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: check, wether var3 on default interface is set correct after state1 entry */
	assert( (test_Expression_if_get_var3(&machine.interface) > testvalue1l) &&
			(test_Expression_if_get_var3(&machine.interface) < testvalue1u) );

	/*@Desc: check, wether var3 on default interface is set correct after state1 entry */
	assert( test_Expression_if_get_var2(&machine.interface) == 1 );

	/*@Desc: set var5 to "false" to let transition take place */
	test_Expression_if_set_var5(&machine.interface, bool_false);

	/*@Desc: raise event1 on default interface with value 5 (actually unused) */
	test_Expression_if_raise_event1(&machine.interface, 5);

	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State2") == 0);

	/*@Desc: check, wether var3 on default interface is set correct after entry */
	assert( (test_Expression_if_get_var3(&machine.interface) > testvalue2l) &&
			(test_Expression_if_get_var3(&machine.interface) < testvalue2u) );

	/*@Desc: set event1 with variable 5 (acutally unused) */
	test_Expression_if_raise_event1(&machine.interface, 5);

	/*@Desc: run an explicit cycle */
	test_ExpressionStatemachine_runCycle(&machine);

	/*@Desc: check the transition to state1 */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc-Info: I will not calculate the complete for var3 in this scenario */

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
		return test_default_other_var1();
	case 2:
		return test_default_other_var2_var3();
	}

	return 0;

}
