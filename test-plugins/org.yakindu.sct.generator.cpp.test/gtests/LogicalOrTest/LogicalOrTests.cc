#include <string>
#include "gtest/gtest.h"
#include "LogicalOr.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

LogicalOr* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class LogicalOrTests : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new LogicalOr();
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


TEST_F(LogicalOrTests, operandEvaluationOrder) {
	
	statechart->enter();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 4l && statechart->getDefaultSCI()->get_b()) << "logical or expression was executed in wrong order..." ;
	
	
}

	}

