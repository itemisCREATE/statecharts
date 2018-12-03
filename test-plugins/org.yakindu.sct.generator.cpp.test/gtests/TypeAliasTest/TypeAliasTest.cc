#include <string>
#include "gtest/gtest.h"
#include "TypeAlias.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

TypeAlias* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class TypeAliasTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new TypeAlias();
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


TEST_F(TypeAliasTest, TypeAliasTest) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(TypeAlias::main_region_Start));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myVar()== 1l);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(TypeAlias::main_region_Mid));
	
	EXPECT_TRUE(strcmp(statechart->getDefaultSCI()->get_myString(), "TypeSystem") == 0);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(TypeAlias::main_region_Mid2));
	
	statechart->getDefaultSCI()->raise_myEvent();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(TypeAlias::main_region_End));
	
	
}

	}

