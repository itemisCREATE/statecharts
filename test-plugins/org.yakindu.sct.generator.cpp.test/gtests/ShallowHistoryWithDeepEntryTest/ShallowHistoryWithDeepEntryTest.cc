#include <string>
#include "gtest/gtest.h"
#include "ShallowHistoryWithDeepEntry.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

ShallowHistoryWithDeepEntry* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ShallowHistoryWithDeepEntryTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new ShallowHistoryWithDeepEntry();
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


TEST_F(ShallowHistoryWithDeepEntryTest, noDeepEntryWithinHistory) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Y));
	
	statechart->getDefaultSCI()->raise_toZ();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_A));
	
	statechart->getDefaultSCI()->raise_toY();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Y));
	
	statechart->getDefaultSCI()->raise_toZ();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_A));
	
	
}
TEST_F(ShallowHistoryWithDeepEntryTest, deepEntryWithinHistory) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Y));
	
	statechart->getDefaultSCI()->raise_toZ();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_A));
	
	statechart->getDefaultSCI()->raise_toC();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B__region0_C));
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B));
	
	statechart->getDefaultSCI()->raise_toY();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Y));
	
	statechart->getDefaultSCI()->raise_toZ();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B__region0_C));
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B));
	
	
}
TEST_F(ShallowHistoryWithDeepEntryTest, directDeepEntryIntoHistory) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Y));
	
	statechart->getDefaultSCI()->raise_toC();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B__region0_C));
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B));
	
	statechart->getDefaultSCI()->raise_toY();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Y));
	
	statechart->getDefaultSCI()->raise_toZ();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B__region0_C));
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B));
	
	
}

}

