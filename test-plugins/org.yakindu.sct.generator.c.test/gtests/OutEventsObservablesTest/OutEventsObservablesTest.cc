#include "gtest/gtest.h"
#include "OutEventsObservables.h"

struct {
	OutEventsObservables machine;
	sc_observer* oEv_observers[1];
	sc_observer observer;
	sc_boolean raised;
} sm;

static void on_oEv(OutEventsObservables* handle, void* value);

static void on_oEv(OutEventsObservables* handle, void* value) {
	sm.raised = true;
	(void) handle;
	(void) value;
}

TEST(OutEventObservables, OutEventObservables) {
		sm.raised = false;
		outEventsObservables_init(&sm.machine);
		SC_OBSERVABLE_INIT_OBSERVERS(&sm.machine.iface.oEv, sm.oEv_observers);

		SC_OBSERVER_INIT(&sm.observer, &sm.machine, on_oEv);
		SC_OBSERVER_SUBSCRIBE(outEventsObservablesIface_get_oEv(&sm.machine), &sm.observer);
		outEventsObservables_enter(&sm.machine);
		EXPECT_TRUE(sm.raised);
	}
