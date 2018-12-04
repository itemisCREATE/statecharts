#include <string>
#include "gtest/gtest.h"
#include "EntryChoice.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

EntryChoice* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class EntryChoiceTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new EntryChoice();
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


TEST_F(EntryChoiceTest, EntryChoiceTest) {
	
	statechart->enter();
	
	runner->proceed_cycles(1);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(EntryChoice::main_region_A));
	
	
}

}

