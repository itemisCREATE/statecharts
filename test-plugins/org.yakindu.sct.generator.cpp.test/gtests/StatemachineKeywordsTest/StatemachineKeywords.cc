#include <string>
#include "gtest/gtest.h"
#include "StatechartKeywords.h"
#include "sc_runner_timed.h"
#include "sc_types.h"

namespace  {

StatechartKeywords* statechart;


class MockIf : public StatechartKeywords::SCI_If_OCB {
	public:
	void myOperation() {
	}
};
class MockInternal : public StatechartKeywords::InternalSCI_OCB {
	public:
	void myOperation() {
	}
};

//! The timers are managed by a timer service. */
static TimedSctUnitRunner * runner;

class StatemachineKeywords : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new StatechartKeywords();
		statechart->init();
		runner = new TimedSctUnitRunner(
			statechart,
			false,
			200
		);
		statechart->setTimer(runner);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};


TEST_F(StatemachineKeywords, statemachineKeywords) {
	
	MockIf ifMock;
	MockInternal internalMock;
	statechart->setSCI_If_OCB(&ifMock);
	statechart->setInternalSCI_OCB(&internalMock);
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(StatechartKeywords::main_region_Timer));
	
	
}

}

