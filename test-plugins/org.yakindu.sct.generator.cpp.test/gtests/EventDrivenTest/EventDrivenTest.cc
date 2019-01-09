#include <string>
#include "gtest/gtest.h"
#include "EventDriven.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

EventDriven* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class EventDrivenTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new EventDriven();
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


TEST_F(EventDrivenTest, test) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->getDefaultSCI()->isRaised_running());
	
	statechart->getDefaultSCI()->raise_inEvent();
	
	EXPECT_TRUE(statechart->getDefaultSCI()->isRaised_oe1());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->isRaised_oe2());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->isRaised_oe3());
	
	EXPECT_TRUE(statechart->isStateActive(EventDriven::main_region_StateD));
	
	statechart->getDefaultSCI()->raise_inEventBool( true);
	
	EXPECT_TRUE(statechart->isStateActive(EventDriven::main_region_StateE));
	
	EXPECT_TRUE(statechart->isStateActive(EventDriven::main_region_StateE__region0_State2));
	
	statechart->getDefaultSCI()->raise_inEvent();
	
	EXPECT_TRUE(statechart->isStateActive(EventDriven::main_region_StateF));
	
	statechart->getSCI_NamedI()->raise_namedInEvent();
	
	EXPECT_TRUE(statechart->isFinal());
	
	statechart->exit();
	
	
}

}

