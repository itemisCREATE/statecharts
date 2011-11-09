
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include "Timer.h"
#include "DummyTimer.h"
#include "InterfaceTestStatemachine.h"
#include "InterfaceTestEvent.h"

#define MAXEVENTSPERTYPE 4
const char* stateName[6] = {"State1", "State2", "State3", "State4", "State5", "State6"};

void setupStatemachine(InterfaceTestStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* set up dummy Timer */
	dummyTimer_init(dummyTimer);

	/* Set up Event Pool */
	eventPool_init_heap(eventPool, event_last, MAXEVENTSPERTYPE);

	/* initialize state machine */
	interfaceTestStatemachine_init(machine, dummyTimer, eventPool);

}

void teardownStatemachine(InterfaceTestStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	interfaceTestStatemachine_exit(machine);
	timer_exit(dummyTimer);
	eventPool_exit(eventPool);

}

/*@Test: test_default_interface good case, guard matches */
int test_default_interface_good()
{
	InterfaceTestStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	integer retval;

	setupStatemachine(&machine, &dummyTimer, &eventPool);


	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: raise event1 */
	interfaceTest_if_raise_event1(&machine.interface);

	/*@DescInfo: Initial value for the guard is 2.3, which is bigger than 0, so the transition should be taken */

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether the state is set to "State2" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State2") == 0);

	/*@Desc: check if the entry event2 is raised */
	assert( interfaceTest_if_is_event2_raised(&machine.interface, &retval) == bool_true );

	/*@Desc: check if the return value of event2 is set to 22 */
	assert( retval == 22 );

	/*@Desc: raise event1 */
	interfaceTest_if_raise_event1(&machine.interface);

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether state has changed back to "State1" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: check whether event2 is not raised any more */
	assert( interfaceTest_if_is_event2_raised(&machine.interface, &retval) == bool_false );

	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_default_interface good case, guard matches */
int test_default_interface_bad()
{
	InterfaceTestStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	integer retval = 55;

	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: set variable var2 to -12.6 */
	interfaceTest_if_set_var2(&machine.interface, -12.6);

	/*@Desc: raise event1 */
	interfaceTest_if_raise_event1(&machine.interface);

	/*@DescInfo: Transition should not be taken, as guard with var2 is less than 0 */

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether the state is set to "State2" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: check if the entry event2 is NOT raised */
	assert( interfaceTest_if_is_event2_raised(&machine.interface, &retval) == bool_false );

	/*@Desc: check if the original retval has not been changed */
	assert( retval == 55 );

	/*@Desc: raise event1 */
	interfaceTest_if_raise_event1(&machine.interface);

	/*@Desc: set variable var2 to 213.55 (>0) */
	interfaceTest_if_set_var2(&machine.interface, 213.55);

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether state has changed back to "State2" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State2") == 0);

	/*@Desc: check whether event2 is raised */
	assert( interfaceTest_if_is_event2_raised(&machine.interface, &retval) == bool_true );

	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}


int main(int argc, char** argv)
{
	if (argc != 2)
		return -1;

	switch (atoi(argv[1])) {
	case 1:
		return test_default_interface_good();
	case 2:
		return test_default_interface_bad();
	}

	return 0;

	/*
	InterfaceTestStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	integer retval1;
	boolean retval2;
//	real retval3;



	interfaceTestStatemachine_runCycle(&machine);

	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State3") == 0);
	assert( interfaceTest_if_other_is_event4_raised(&machine.interfaceOther) == bool_true );

	interfaceTest_if_other_raise_event3(&machine.interfaceOther);

	assert( interfaceTestStatemachine_eventWaiting(&machine) == bool_true );

	interfaceTestStatemachine_runCycle(&machine);

	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);
	assert( interfaceTest_if_other_is_event4_raised(&machine.interfaceOther) == bool_false );


	interfaceTest_if_third_raise_event5(&machine.interfaceThird);
	interfaceTest_if_set_var1(&machine.interface, bool_true);

	interfaceTestStatemachine_runCycle(&machine);

	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State4") == 0);
	assert( interfaceTest_if_third_is_event6_raised(&machine.interfaceThird, &retval2) == bool_true );


	interfaceTest_if_third_raise_event5(&machine.interfaceThird);

	interfaceTestStatemachine_runCycle(&machine);

	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);


	interfaceTestStatemachine_exit(&machine);
	timer_exit(&dummyTimer);
	eventPool_exit(&eventPool);

	return(0);
	*/
}

