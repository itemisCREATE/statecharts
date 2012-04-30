
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
	interfaceTest_eventPool_init_heap(eventPool, MAXEVENTSPERTYPE);

	/* initialize state machine */
	interfaceTestStatemachine_init(machine, dummyTimer, eventPool);

	/* call all necessary enter functions */
	interfaceTestStatemachine_enter(machine);
}

void teardownStatemachine(InterfaceTestStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* call all exit actions for this state machine */
	interfaceTestStatemachine_exit(machine);

	/* free all internal memory for this state machine */
	interfaceTestStatemachine_destruct(machine);

	/* free the timer */
	timer_exit(dummyTimer);

	/* free all events in the event pool */
	eventPool_exit(eventPool);

}

/*@Test: test_default_interface good case, guard matches */
int test_default_interface_good()
{
	InterfaceTestStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	integer retval;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: raise event1 on default interface */
	interfaceTest_if_raise_event1(&machine.iface);

	/*@DescInfo: Initial value for the guard is 2.3, which is bigger than 0, so the transition should be taken */

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether the state is set to "State2" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State2") == 0);

	/*@Desc: check if the entry event2 is raised */
	assert( interfaceTest_if_is_event2_raised(&machine.iface, &retval) == bool_true );

	/*@Desc: check if the return value of event2 is set to 22 */
	assert( retval == 22 );

	/*@Desc: raise event1 on default interface */
	interfaceTest_if_raise_event1(&machine.iface);

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether state has changed back to "State1" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: check whether event2 is not raised any more */
	assert( interfaceTest_if_is_event2_raised(&machine.iface, &retval) == bool_false );

	/*@Desc: teardown statemachine */
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

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: set variable var2 to -12.6 */
	interfaceTest_if_set_var2(&machine.iface, -12.6);

	/*@Desc: raise event1 on default interface */
	interfaceTest_if_raise_event1(&machine.iface);

	/*@DescInfo: Transition should not be taken, as guard with var2 is less than 0 */

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether the state is still set to "State1" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: check if the entry event2 is NOT raised */
	assert( interfaceTest_if_is_event2_raised(&machine.iface, &retval) == bool_false );

	/*@Desc: check if the original retval has not been changed */
	assert( retval == 55 );

	/*@Desc: raise event1 on default interface */
	interfaceTest_if_raise_event1(&machine.iface);

	/*@Desc: set variable var2 to 213.55 (>0) */
	interfaceTest_if_set_var2(&machine.iface, 213.55);

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether state has changed back to "State2" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State2") == 0);

	/*@Desc: check whether event2 is raised */
	assert( interfaceTest_if_is_event2_raised(&machine.iface, &retval) == bool_true );

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_other_interface good case, guard matches */
int test_other_interface_good()
{
	InterfaceTestStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: raise event3 on other interface */
	interfaceTest_if_other_raise_event3(&machine.ifaceOther);

	/*@DescInfo: Initial value for the guard is var3 == 1, which is the initial value, so the transition should be taken */

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether the state is set to "State3" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State3") == 0);

	/*@Desc: check if the entry event4 is raised */
	assert( interfaceTest_if_other_is_event4_raised(&machine.ifaceOther) == bool_true );

	/*@Desc: raise event3 on other interface */
	interfaceTest_if_other_raise_event3(&machine.ifaceOther);

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether state has changed back to "State1" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: check whether event4 is not raised any more */
	assert( interfaceTest_if_other_is_event4_raised(&machine.ifaceOther) == bool_false );

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}


/*@Test: test_default_interface good case, guard matches */
int test_other_interface_bad()
{
	InterfaceTestStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: set variable var3 to 2 in default interface */
	interfaceTest_if_set_var3(&machine.iface, 2);

	/*@Desc: raise event1 on other interface */
	interfaceTest_if_other_raise_event3(&machine.ifaceOther);

	/*@DescInfo: Transition should not be taken, as guard with var3 is not equal 1 */

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether the state is still set to "State1" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: check if the entry event2 is NOT raised */
	assert( interfaceTest_if_other_is_event4_raised(&machine.ifaceOther) == bool_false );

	/*@Desc: raise event1 on other interface */
	interfaceTest_if_other_raise_event3(&machine.ifaceOther);

	/*@Desc: set variable var3 to 1 */
	interfaceTest_if_set_var3(&machine.iface, 1);

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether state has changed back to "State2" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State3") == 0);

	/*@Desc: check whether event2 is raised */
	assert( interfaceTest_if_other_is_event4_raised(&machine.ifaceOther) == bool_true );

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_third_interface good case, guard matches */
int test_third_interface_good()
{
	InterfaceTestStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;
	sc_boolean retVal = bool_false;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: raise event5 on other interface */
	interfaceTest_if_third_raise_event5(&machine.ifaceThird);

	/*@Desc: set var1 to true */
	interfaceTest_if_set_var1(&machine.iface, bool_true);

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether the state is set to "State4" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State4") == 0);

	/*@Desc: check if the entry event4 is raised */
	assert( interfaceTest_if_third_is_event6_raised(&machine.ifaceThird, &retVal) == bool_true );

	/*@Desc: check whether returned event6 value is set to true */
	assert( retVal == bool_true );

	/*@Desc: raise event5 on other interface */
	interfaceTest_if_third_raise_event5(&machine.ifaceThird);

	/*@Desc: set retValue to false */
	retVal = bool_false;

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether state has changed back to "State1" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: check whether event4 is not raised any more */
	assert( interfaceTest_if_third_is_event6_raised(&machine.ifaceThird, &retVal) == bool_false );

	/*@Desc: check whether returned event6 value is set to false */
	assert( retVal == bool_false );

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_default_interface good case, guard matches */
int test_third_interface_bad()
{
	InterfaceTestStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	sc_boolean retVal = bool_false;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: set variable var1 to false in default interface */
	interfaceTest_if_set_var1(&machine.iface, bool_false);

	/*@Desc: raise event1 on third interface */
	interfaceTest_if_third_raise_event5(&machine.ifaceThird);

	/*@DescInfo: Transition should not be taken, as guard with var3 is not equal 1 */

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether the state is still set to "State1" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: check if the entry event2 is NOT raised */
	assert( interfaceTest_if_third_is_event6_raised(&machine.ifaceThird, &retVal) == bool_false );

	/*@Desc: raise event5 on third interface */
	interfaceTest_if_third_raise_event5(&machine.ifaceThird);

	/*@Desc: set variable var1 to true on default interface */
	interfaceTest_if_set_var1(&machine.iface, bool_true);

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: check whether state has changed back to "State2" */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State4") == 0);

	/*@Desc: check whether event2 is raised */
	assert( interfaceTest_if_third_is_event6_raised(&machine.ifaceThird, &retVal) == bool_true );

	/*@Desc: check whether returned event6 value is set to true */
	assert( retVal == bool_true );

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

int test_namespaces()
{
	InterfaceTestStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State1") == 0);

	/*@Desc: check correct initialization of variable v1 */
	assert( interfaceTest_if_other_get_v1(&machine.ifaceOther) == 5 );

	/*@Desc: set third interface variable v1 to 52.83 */
	interfaceTest_if_third_set_v1( &machine.ifaceThird, 52.83 );

	/*@Desc: set other interface variable to 8877 */
	interfaceTest_if_other_set_v1( &machine.ifaceOther, 8877 );

	/*@DescInfo: toogle through all states */

	/*@Desc: raise event1 on default event */
	interfaceTest_if_raise_event1( &machine.iface);

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: raise event1 on default event */
	interfaceTest_if_raise_event1( &machine.iface);

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: raise event3 on default event */
	interfaceTest_if_other_raise_event3( &machine.ifaceOther);

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: raise event3 on default event */
	interfaceTest_if_other_raise_event3( &machine.ifaceOther);

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: set var1 of default interface to true */
	interfaceTest_if_set_var1( &machine.iface, bool_true);

	/*@Desc: raise event5 on default event */
	interfaceTest_if_third_raise_event5( &machine.ifaceThird);

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	/*@Desc: raise event5 on default event */
	interfaceTest_if_third_raise_event5( &machine.ifaceThird);

	/*@Desc: run an explicit cycle */
	interfaceTestStatemachine_runCycle(&machine);

	printf ("%f", interfaceTest_if_third_get_v1(&machine.ifaceThird));

	/*@Desc: check if v1 of third interface is still 52.83 */
	assert( interfaceTest_if_third_get_v1(&machine.ifaceThird) > 52.82 &&
			interfaceTest_if_third_get_v1(&machine.ifaceThird) < 52.84 );

	/*@Desc: check if v1 of other interface is still 8877 */
	assert( interfaceTest_if_other_get_v1(&machine.ifaceOther) == 10 );

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
		return test_default_interface_good();
	case 2:
		return test_default_interface_bad();
	case 3:
		return test_other_interface_good();
	case 4:
		return test_other_interface_bad();
	case 5:
		return test_third_interface_good();
	case 6:
		return test_third_interface_bad();
	case 7:
		return test_namespaces();
	}

	return 0;

}

