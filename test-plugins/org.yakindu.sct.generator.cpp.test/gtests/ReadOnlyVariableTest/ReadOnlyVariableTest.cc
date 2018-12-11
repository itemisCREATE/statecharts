#include <string>
#include "gtest/gtest.h"
#include "ReadOnlyVariable.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

ReadOnlyVariable* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ReadOnlyVariableTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new ReadOnlyVariable();
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


TEST_F(ReadOnlyVariableTest, ReadOnlyVariableTest) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ReadOnlyVariable::main_region_StateA));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myInt()== 0);
	
	EXPECT_TRUE(strcmp(statechart->getDefaultSCI()->get_myString(), "testString") == 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBool()== true);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myReal()== 1.1);
	
	EXPECT_TRUE(statechart->getSCI_A()->get_myInt()== 0);
	
	EXPECT_TRUE(strcmp(statechart->getSCI_A()->get_myString(), "testString") == 0);
	
	EXPECT_TRUE(statechart->getSCI_A()->get_myBool()== true);
	
	EXPECT_TRUE(statechart->getSCI_A()->get_myReal()== 1.1);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(ReadOnlyVariable::main_region_StateB));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myInt()== 100);
	
	EXPECT_TRUE(strcmp(statechart->getDefaultSCI()->get_myString(), "fail") == 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBool()== false);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myReal()== 6.6);
	
	EXPECT_TRUE(statechart->getSCI_A()->get_myInt()== 200);
	
	EXPECT_TRUE(strcmp(statechart->getSCI_A()->get_myString(), "A_fail") == 0);
	
	EXPECT_TRUE(statechart->getSCI_A()->get_myBool()== false);
	
	EXPECT_TRUE(statechart->getSCI_A()->get_myReal()== 7.7);
	
	
}

}

