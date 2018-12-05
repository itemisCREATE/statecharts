
#include "gtest/gtest.h"
#include "NamedInterfaceAccess.h"

#include "sc_timer_service.h"

static NamedInterfaceAccess statechart;


class NamedInterfaceAccessTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void SafeOpenSuccess();
	void setTimer(NamedInterfaceAccess* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(NamedInterfaceAccess* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static NamedInterfaceAccessTest * tc;


void NamedInterfaceAccessTest::SetUp()
{
	namedInterfaceAccess_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &namedInterfaceAccess_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void NamedInterfaceAccessTest::SafeOpenSuccess()
{
	namedInterfaceAccess_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	namedInterfaceAccessIfaceUser_raise_numberPressed(&statechart, 3l);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	namedInterfaceAccessIfaceUser_raise_numberPressed(&statechart, 7l);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	namedInterfaceAccessIfaceUser_raise_numberPressed(&statechart, 5l);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(namedInterfaceAccessIfaceSafe_israised_open(&statechart));
}

void NamedInterfaceAccessTest::setTimer(NamedInterfaceAccess* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void NamedInterfaceAccessTest::unsetTimer(NamedInterfaceAccess* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(NamedInterfaceAccessTest, SafeOpenSuccess) {
	SafeOpenSuccess();
}


