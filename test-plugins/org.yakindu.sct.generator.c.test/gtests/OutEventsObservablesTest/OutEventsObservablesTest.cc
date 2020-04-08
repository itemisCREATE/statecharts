#include "gtest/gtest.h"
#include "OutEventsObservables.h"

struct {
	OutEventsObservables machine;

	sc_observer* oEv_observers[1];
	sc_observer* oEv_b_observers[1];
	sc_observer* oEv_i_observers[1];
	sc_observer* oEv_r_observers[1];
	sc_observer* oEv_s_observers[1];

	sc_observer oEv_observer;
	sc_observer oEv_b_observer;
	sc_observer oEv_i_observer;
	sc_observer oEv_r_observer;
	sc_observer oEv_s_observer;

	sc_boolean raised_oEv;
	sc_boolean raised_oEv_b;
	sc_boolean raised_oEv_i;
	sc_boolean raised_oEv_r;
	sc_boolean raised_oEv_s;

} sm;

static void on_oEv(OutEventsObservables* handle, void* value);
static void on_oEv_b(OutEventsObservables* handle, void* value);
static void on_oEv_i(OutEventsObservables* handle, void* value);
static void on_oEv_r(OutEventsObservables* handle, void* value);
static void on_oEv_s(OutEventsObservables* handle, void* value);


static void on_oEv(OutEventsObservables* handle, void* value) {
	sm.raised_oEv = true;
	(void) handle;
	(void) value;
}

static void on_oEv_b(OutEventsObservables* handle, void* value){
	sm.raised_oEv_b = true;
	EXPECT_EQ(*(sc_boolean*)(value), true);
	(void) handle;
}

static void on_oEv_i(OutEventsObservables* handle, void* value){
	sm.raised_oEv_i = true;
	EXPECT_EQ(*(sc_integer*)(value), 1);
	(void) handle;
}

static void on_oEv_r(OutEventsObservables* handle, void* value){
	sm.raised_oEv_r = true;
	EXPECT_EQ(*(sc_real*)(value), 1.0);
	(void) handle;
}

static void on_oEv_s(OutEventsObservables* handle, void* value){
	sm.raised_oEv_s = true;
	EXPECT_EQ(strcmp(*(sc_string*)(value), (sc_string)"Hello World!"), 0);
	(void) handle;
}


TEST(OutEventObservables, OutEventObservables) {
	sm.raised_oEv = false;
	sm.raised_oEv_b = false;
	sm.raised_oEv_i = false;
	sm.raised_oEv_r = false;
	sm.raised_oEv_s = false;

	outEventsObservables_init(&sm.machine);

	SC_OBSERVABLE_INIT_OBSERVERS(&sm.machine.iface.oEv, sm.oEv_observers);
	SC_OBSERVABLE_INIT_OBSERVERS(&sm.machine.iface.oEv_b, sm.oEv_b_observers);
	SC_OBSERVABLE_INIT_OBSERVERS(&sm.machine.iface.oEv_i, sm.oEv_i_observers);
	SC_OBSERVABLE_INIT_OBSERVERS(&sm.machine.iface.oEv_r, sm.oEv_r_observers);
	SC_OBSERVABLE_INIT_OBSERVERS(&sm.machine.iface.oEv_s, sm.oEv_s_observers);

	SC_OBSERVER_INIT(&sm.oEv_observer, &sm.machine, on_oEv);
	SC_OBSERVER_INIT(&sm.oEv_b_observer, &sm.machine, on_oEv_b);
	SC_OBSERVER_INIT(&sm.oEv_i_observer, &sm.machine, on_oEv_i);
	SC_OBSERVER_INIT(&sm.oEv_r_observer, &sm.machine, on_oEv_r);
	SC_OBSERVER_INIT(&sm.oEv_s_observer, &sm.machine, on_oEv_s);

	SC_OBSERVER_SUBSCRIBE(outEventsObservablesIface_get_oEv(&sm.machine), &sm.oEv_observer);
	SC_OBSERVER_SUBSCRIBE(outEventsObservablesIface_get_oEv_b(&sm.machine), &sm.oEv_b_observer);
	SC_OBSERVER_SUBSCRIBE(outEventsObservablesIface_get_oEv_i(&sm.machine), &sm.oEv_i_observer);
	SC_OBSERVER_SUBSCRIBE(outEventsObservablesIface_get_oEv_r(&sm.machine), &sm.oEv_r_observer);
	SC_OBSERVER_SUBSCRIBE(outEventsObservablesIface_get_oEv_s(&sm.machine), &sm.oEv_s_observer);

	outEventsObservables_enter(&sm.machine);

	EXPECT_TRUE(sm.raised_oEv);
	EXPECT_TRUE(sm.raised_oEv_b);
	EXPECT_TRUE(sm.raised_oEv_i);
	EXPECT_TRUE(sm.raised_oEv_r);
	EXPECT_TRUE(sm.raised_oEv_s);
}

