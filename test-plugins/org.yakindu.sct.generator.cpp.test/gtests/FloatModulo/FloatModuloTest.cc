#include <string>
#include "gtest/gtest.h"
#include "FloatModulo.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

FloatModulo* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class FloatModuloTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new FloatModulo();
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


TEST_F(FloatModuloTest, test) {
	
	statechart->enter();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isFinal());
	
	
}

	}

