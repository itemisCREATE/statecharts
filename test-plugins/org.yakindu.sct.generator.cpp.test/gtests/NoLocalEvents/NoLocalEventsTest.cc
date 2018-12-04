#include <string>
#include "gtest/gtest.h"
#include "NoLocalEvents.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

NoLocalEvents* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class NoLocalEventsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new NoLocalEvents();
		statechart->init();
		runner = new SctUnitRunner(
			statechart,
			true,
			200
		);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};


TEST_F(NoLocalEventsTest, test) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(NoLocalEvents::main_region_StateA));
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(NoLocalEvents::main_region_StateB));
	
	statechart->getDefaultSCI()->raise_e();
	
	EXPECT_TRUE(statechart->isStateActive(NoLocalEvents::main_region_StateA));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_x()== 0l));
	
	statechart->getDefaultSCI()->raise_i( 42l);
	
	EXPECT_TRUE(statechart->isStateActive(NoLocalEvents::main_region_StateB));
	
	EXPECT_TRUE((statechart->getDefaultSCI()->get_x()== 42l));
	
	statechart->exit();
	
	
}

}

