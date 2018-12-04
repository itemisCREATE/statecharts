#include <string>
#include "gtest/gtest.h"
#include "SimpleHierachy.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

SimpleHierachy* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class SimpleHierachyTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new SimpleHierachy();
		statechart->init();
		runner = new SctUnitRunner(
			statechart,
			false,
			200
		);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};


TEST_F(SimpleHierachyTest, simpleHierachyTest) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(SimpleHierachy::main_region_A));
	
	statechart->getDefaultSCI()->raise_event1();
	
	statechart->getDefaultSCI()->raise_event1();
	
	statechart->getDefaultSCI()->raise_event1();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(SimpleHierachy::main_region_B));
	
	EXPECT_TRUE(statechart->isStateActive(SimpleHierachy::main_region_B_subregion1_B1));
	
	
}

}

