
#include "gtest/gtest.h"
#include "TypeAlias.h"

#include "sc_timer_service.h"

static TypeAlias statechart;


class TypeAliasTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void typeAliasTest();
	void setTimer(TypeAlias* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(TypeAlias* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static TypeAliasTest * tc;


void TypeAliasTest::SetUp()
{
	typeAlias_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &typeAlias_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void TypeAliasTest::typeAliasTest()
{
	typeAlias_enter(&statechart);
	EXPECT_TRUE(typeAlias_isStateActive(&statechart, TypeAlias_main_region_Start));
	EXPECT_TRUE(typeAliasIface_get_myVar(&statechart)== 1l);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(typeAlias_isStateActive(&statechart, TypeAlias_main_region_Mid));
	EXPECT_TRUE(strcmp(typeAliasIface_get_myString(&statechart), "TypeSystem") == 0);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(typeAlias_isStateActive(&statechart, TypeAlias_main_region_Mid2));
	typeAliasIface_raise_myEvent(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(typeAlias_isStateActive(&statechart, TypeAlias_main_region_End));
}

void TypeAliasTest::setTimer(TypeAlias* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void TypeAliasTest::unsetTimer(TypeAlias* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(TypeAliasTest, TypeAliasTest) {
	typeAliasTest();
}


