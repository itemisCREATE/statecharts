
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include "Timer.h"
#include "DummyTimer.h"
#include "Test_ExpressionStatemachine.h"
#include "Test_ExpressionEvent.h"

/*@DescTest: Expression Statechart Test (Test_Expression.sct) */

#define MAXEVENTSPERTYPE 4
const char* stateName[6] = {"State1", "State2", "State3", "State4", "State5", "State6"};

void setupStatemachine(Timer* dummyTimer, EventPool* eventPool)
{
	/* set up dummy Timer */
	dummyTimer_init(dummyTimer);

	/* Set up Event Pool */
	test_Expression_eventPool_init_heap(eventPool, MAXEVENTSPERTYPE);

	/* initialize state machine */
	test_ExpressionStatemachine_init(dummyTimer, eventPool);

	/* call all necessary enter functions */
	test_ExpressionStatemachine_enter();
}

void teardownStatemachine(Timer* dummyTimer, EventPool* eventPool)
{
	/* call all exit actions for this state machine */
	test_ExpressionStatemachine_exit();

	/* free all internal memory for this state machine */
	test_ExpressionStatemachine_destruct();

	/* free the timer */
	timer_exit(dummyTimer);

	/* free all events in the event pool */
	eventPool_exit(eventPool);

}

/*@Test: test_default_var1 test behavior of var1 in default interface */
int test_initialization_and_first_entry()
{
//	Test_ExpressionStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	real testvalue1u = (19.4 + 19.4*123 + 0.1);
	real testvalue1l = (19.4 + 19.4*123 - 0.1);

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

	/* get the handle only for getting the state name */
//	machine = test_Expression_get_handle();

	/*@Desc: check whether var1 from default interface is initially set to 6 */
	assert( test_Expression_if_get_var1() == 6);

	/*@Desc: check whether var2 from default is initially set to 123 */
	assert( test_Expression_if_get_var2() == 123);

	/*@Desc: check, wether var3 from default interface is set correct after state1 entry */
	printf("Var3 is set to %f\n", test_Expression_if_get_var3());
	assert( (test_Expression_if_get_var3() > testvalue1l) &&
			(test_Expression_if_get_var3() < testvalue1u) );

	/*@Desc: check, whether var4 from default interface is between 43.3 and 43.5 */
	printf("Var4 is set to %f\n", test_Expression_if_get_var4());
	assert( (test_Expression_if_get_var4() > 43.2) &&
			(test_Expression_if_get_var4() < 43.4) );

	/*@Desc: check whether var5 from default interface is initially set to false */
	assert( test_Expression_if_get_var5() == bool_false);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&dummyTimer, &eventPool);

	return 0;

}




/*@Test: test_default_var1 test behavior of var1 in default and other interface */
int test_default_other_var1()
{
	Test_ExpressionStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

	/* get the handle only for getting the state name */
	machine = test_Expression_get_handle();

	/*@Desc: check initial value for var1 ( == 6) */
	assert( test_Expression_if_get_var1() == 6 );

	/*@Desc: run an explicit cycle - without any waiting event */
	test_ExpressionStatemachine_runCycle();

	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)machine, 0)], "State1") == 0);

	/*@Desc: check value for var1 after state1 entry / var1 is not changed during entry into state1 */
	assert( test_Expression_if_get_var1() == 6 );

	/*@Desc: raise event1 on default interface with value 5 (actually unused) */
	test_Expression_if_raise_event1(5);

	/*@Desc: set other.var1 to "true" to let transition take place */
	test_Expression_if_other_set_var1(bool_true);

	/*@Desc: run an explicit cycle */
	test_ExpressionStatemachine_runCycle();

	/*@Desc: check whether the state is set to "State2" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)machine, 0)], "State2") == 0);

	/*@Desc: check whether the transition action was executed */
	assert( test_Expression_if_other_get_var1() == bool_false);

	/*@Desc: check whether var1 has been increased by 1 (==7) */
	assert( test_Expression_if_get_var1() == 7 );

	/*@Desc: run an explicit cycle */
	test_ExpressionStatemachine_runCycle();

	/*@Desc: check whether the state is still set to "State2" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)machine, 0)], "State2") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&dummyTimer, &eventPool);

	return 0;
}

int test_default_other_var2_var3()
{
	Test_ExpressionStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	real testvalue1u = (19.4 + 19.4*123 + 0.1);
	real testvalue1l = (19.4 + 19.4*123 - 0.1);

	real testvalue2u = (19.4 + 19.4*123)/5.0 + 0.1;
	real testvalue2l = (19.4 + 19.4*123)/5.0 - 0.1;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

	/* get the handle only for getting the state name */
	machine = test_Expression_get_handle();

	/*@Desc: check initial value for var2 ( == 123) */
	assert( test_Expression_if_get_var2() == 123 );

	/*@Desc: check initial value for var3 (19.4) */
	printf("Var3 is set to %f\n", test_Expression_if_get_var3());
	assert( (test_Expression_if_get_var3() > testvalue1l) &&
			(test_Expression_if_get_var3() < testvalue1u));

	/*@Desc: run an explicit cycle - without any waiting event */
	test_ExpressionStatemachine_runCycle();

	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)machine, 0)], "State1") == 0);

	/*@Desc: raise event1 on default interface with value 5 (actually unused) */
	test_Expression_if_raise_event1(5);

	/*@Desc: run an explicit cycle - without any waiting event */
	test_ExpressionStatemachine_runCycle();

	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)machine, 0)], "State2") == 0);


	/*@Desc: check, wether var3 on default interface is set correct after state1 entry */
	assert( test_Expression_if_get_var2() == 1 );

	/*@Desc: set var5 to "false" to let transition take place */
	test_Expression_if_set_var5(bool_false);

	/*@Desc: raise event1 on default interface with value 5 (actually unused) */
	test_Expression_if_raise_event1(5);

	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)machine, 0)], "State2") == 0);

	/*@Desc: check, wether var3 on default interface is set correct after entry */
	printf("Var3 is set to %f\n", test_Expression_if_get_var3());
	assert( (test_Expression_if_get_var3() > testvalue2l) &&
			(test_Expression_if_get_var3() < testvalue2u) );

	/*@Desc: set event1 with variable 5 (acutally unused) */
	test_Expression_if_raise_event1(5);

	/*@Desc: run an explicit cycle */
	test_ExpressionStatemachine_runCycle();

	/*@Desc: check the transition to state1 */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)machine, 0)], "State1") == 0);

	/*@Desc-Info: I will not calculate the complete for var3 in this scenario */

	/*@Desc: teardown statemachine */
	teardownStatemachine(&dummyTimer, &eventPool);

	return 0;
}

int test_onCycle()
{
//	Test_ExpressionStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

	/* get the handle only for getting the state name */
//	machine = test_Expression_get_handle();

	/*@Desc: run an explicit cycle - without any waiting event */
	test_ExpressionStatemachine_runCycle();

	/*@Desc: raise event1 on default interface with value 5 (actually unused) */
	test_Expression_if_raise_event1(5);

	/*@Desc: set other.var1 to "true" to let transition take place */
	test_Expression_if_other_set_var1(bool_true);

	/*@Desc: run an explicit cycle */
	test_ExpressionStatemachine_runCycle();

	/*@Desc: check whether var1 has been increased by one (==7) */
	assert( test_Expression_if_get_var1() == 7 );

	/*@Desc: run an explicit cycle - without any change */
	test_ExpressionStatemachine_runCycle();

	/*@Desc: check whether var1 has been increased by 1 on onCycle (==8) */
	assert( test_Expression_if_get_var1() == 8 );

	/*@Desc: run an explicit cycle - without any change */
	test_ExpressionStatemachine_runCycle();

	/*@Desc: check whether var1 has been increased by 1 on onCycle (==9) */
	assert( test_Expression_if_get_var1() == 9 );

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
		return test_initialization_and_first_entry();
	case 2:
		return test_default_other_var1();
	case 3:
		return test_default_other_var2_var3();
	case 4:
		return test_onCycle();
	}

	return 0;

}

