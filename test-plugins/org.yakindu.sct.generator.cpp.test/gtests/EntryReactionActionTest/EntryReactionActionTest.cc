#include <string>
#include "gtest/gtest.h"
#include "EntryReactionAction.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

void init();
entries::EntryReactionAction* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class EntryReactionActionTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new entries::EntryReactionAction();
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

void init(){
	statechart->enter();
	
	statechart->getDefaultSCI()->raise_b();
	
	runner->proceed_cycles(1);
	
	statechart->getDefaultSCI()->raise_d();
	
	runner->proceed_cycles(1);
	
	statechart->getDefaultSCI()->set_enteredR1(false);
	
	statechart->getDefaultSCI()->set_enteredR2(false);
	
	statechart->getDefaultSCI()->set_enteredBdefault(false);
	
	statechart->getDefaultSCI()->set_enteredBother(false);
	
	
}

TEST_F(EntryReactionActionTest, entryTransitionActionOnStatechartEnter) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_enteredR1());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_enteredR2());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_enteredBdefault());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredBother());
	
	
}
TEST_F(EntryReactionActionTest, entryOnRTS) {
	
	init();
	
	statechart->getDefaultSCI()->raise_b();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredR1());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredR2());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredBdefault());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_enteredBother());
	
	
}
TEST_F(EntryReactionActionTest, noEntryTransitionActionOnHistory) {
	
	init();
	
	statechart->getDefaultSCI()->raise_d();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredR1());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredR2());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredBdefault());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredBother());
	
	
}

	}

