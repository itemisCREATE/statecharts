
#include <iostream>
#include <cstdlib>
#include <cassert>
#include <cstring>
#include <string>
#include "Timer.h"
#include "DummyTimer.h"
#include "InterfaceTestStatemachineOOY.hpp"
#include "log.h"

extern Logger logger;

/*@Test: test_default_interface good case, guard matches */
int first()
{
	/* set up dummy Timer */
	Timer dummyTimer;
	dummyTimer_init(&dummyTimer);

	logger.setLevel(Logger::LOG_INFO);

	InterfaceTestStatemachineOOY machine("127.0.0.1", 2002, &dummyTimer);

	// wait for the setup
	machine.runCycle();
	machine.get_ifaceOther()->set_v1(12);
	std::cout << "raise event 1\n";
	machine.get_iface()->raise_event1();

	machine.runCycle();

	std::cout << "other.v1 = " << machine.get_ifaceOther()->get_v1() << std::endl;

	std::cout << "raise event 1\n";
	machine.get_iface()->raise_event1();

	machine.runCycle();

	std::cout << "other.v1 = " << machine.get_ifaceOther()->get_v1() << std::endl;

	std::cout << "raise event 3\n";
	machine.get_ifaceOther()->raise_event3();

	machine.runCycle();

	std::cout << "raise event 3\n";
	machine.get_ifaceOther()->raise_event3();

	machine.runCycle();

	std::cout << "raise event 5\n";
	machine.get_iface()->set_var1(bool_true);
	machine.get_ifaceThird()->raise_event5();

	machine.runCycle();

	std::cout << "raise event 5\n";
	machine.get_ifaceThird()->raise_event5();

	machine.runCycle();

	return 0;
}

int main(int argc, char** argv)
{
	if (argc != 2)
		return -1;

	switch (atoi(argv[1])) {
	case 1:
		return first();
	}

	return 0;

}

