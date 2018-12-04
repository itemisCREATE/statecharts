
#include <algorithm>
#include <list>
#include "gtest/gtest.h"
#include "ChildFirstOrthogonalReactions.h"

#include "ChildFirstOrthogonalReactionsRequired.h"
#include "sc_timer_service.h"

static ChildFirstOrthogonalReactions statechart;


class ChildFirstOrthogonalReactionsTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	sc_boolean checkA(sc_boolean ret);
	sc_boolean checkAA(sc_boolean ret);
	sc_boolean checkAAA(sc_boolean ret);
	sc_boolean checkAAC(sc_boolean ret);
	sc_boolean checkAC(sc_boolean ret);
	sc_boolean checkC(sc_boolean ret);
	sc_integer nextCounter();
	void executionOrder();
	void executionOrderWIthFirstLeafTransition();
	void executionOrderWIthFirstParentTransition();
	void executionOrderWIthFirstGrandParentTransition();
	void executionOrderWithLastLeafTransition();
	void setTimer(ChildFirstOrthogonalReactions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ChildFirstOrthogonalReactions* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ChildFirstOrthogonalReactionsTest * tc;

sc_boolean checkA(sc_boolean ret);
sc_boolean checkAA(sc_boolean ret);
sc_boolean checkAAA(sc_boolean ret);
sc_boolean checkAAC(sc_boolean ret);
sc_boolean checkAC(sc_boolean ret);
sc_boolean checkC(sc_boolean ret);
sc_integer nextCounter();
class CheckMock{
	typedef sc_boolean (CheckMock::*functiontype)(const sc_string);
	struct parameters {
		const sc_string value;
		sc_boolean (CheckMock::*behavior)(const sc_string);
		inline bool operator==(const parameters& other) {
			return (this->value == other.value);
		}
	};
	public:
	std::list<CheckMock::parameters> mocks;
	sc_boolean (CheckMock::*checkBehaviorDefault)(const sc_string);

	sc_boolean check1(const sc_string value){
		return (tc->checkA(false));
	}

	sc_boolean check2(const sc_string value){
		return (tc->checkAA(false));
	}

	sc_boolean check3(const sc_string value){
		return (tc->checkAAA(false));
	}

	sc_boolean check4(const sc_string value){
		return (tc->checkAAC(false));
	}

	sc_boolean check5(const sc_string value){
		return (tc->checkAC(false));
	}

	sc_boolean check6(const sc_string value){
		return (tc->checkC(false));
	}

	sc_boolean check7(const sc_string value){
		return (tc->checkAAA(true));
	}

	sc_boolean check8(const sc_string value){
		return (tc->checkAA(true));
	}

	sc_boolean check9(const sc_string value){
		return (tc->checkA(true));
	}

	sc_boolean check10(const sc_string value){
		return (tc->checkC(true));
	}

	sc_boolean checkDefault(const sc_string value){
		sc_boolean defaultValue = null;
		return (defaultValue);
	}

	void setCheckBehavior(const sc_string value,sc_boolean (CheckMock::*func)(const sc_string)){
		parameters p;
		p.value = value;
		p.behavior = func;
	
		std::list<CheckMock::parameters>::iterator i = std::find(mocks.begin(), mocks.end(), p);
		if(i != mocks.end()) {
			mocks.erase(i);
		}
		mocks.push_back(p);
	}

	functiontype getBehavior(const sc_string value){
		parameters p;
		p.value = value;
		
		std::list<CheckMock::parameters>::iterator i = std::find(mocks.begin(), mocks.end(), p);
		if(i != mocks.end()) {
			return  i->behavior;
		} else {
			return checkBehaviorDefault;
		}
	}
	
	void setDefaultBehavior(sc_boolean (CheckMock::*defaultBehavior)(const sc_string)){
		checkBehaviorDefault = defaultBehavior;
		mocks.clear();
	}
	
	void initializeBehavior() {
		setDefaultBehavior(&CheckMock::checkDefault);
	}
	
	void reset() {
		initializeBehavior();
		mocks.clear();
	}
};
static CheckMock* checkMock;

class NextMock{
	typedef sc_integer (NextMock::*functiontype)();
	public:
	sc_integer (NextMock::*nextBehaviorDefault)();

	sc_integer next1(){
		return (tc->nextCounter());
	}

	sc_integer nextDefault(){
		sc_integer defaultValue = null;
		return (defaultValue);
	}

	functiontype getBehavior(){
		return nextBehaviorDefault;
	}
	
	void setDefaultBehavior(sc_integer (NextMock::*defaultBehavior)()){
		nextBehaviorDefault = defaultBehavior;
	}
	
	void initializeBehavior() {
		setDefaultBehavior(&NextMock::nextDefault);
	}
	
	void reset() {
		initializeBehavior();
	}
};
static NextMock* nextMock;


void ChildFirstOrthogonalReactionsTest::SetUp()
{
	childFirstOrthogonalReactions_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &childFirstOrthogonalReactions_runCycle,
		false,
		200,
		&statechart
	);
	
	checkMock = new CheckMock();
	checkMock = new CheckMock();
	checkMock->initializeBehavior();
	nextMock = new NextMock();
	nextMock = new NextMock();
	nextMock->initializeBehavior();
	
	tc = this;
}
sc_boolean ChildFirstOrthogonalReactionsTest::checkA(sc_boolean ret)
{
	childFirstOrthogonalReactionsIface_set_cnt(&statechart,childFirstOrthogonalReactionsIface_get_cnt(&statechart)+1l);
	childFirstOrthogonalReactionsIface_set_a_check(&statechart,childFirstOrthogonalReactionsIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ChildFirstOrthogonalReactionsTest::checkAA(sc_boolean ret)
{
	childFirstOrthogonalReactionsIface_set_cnt(&statechart,childFirstOrthogonalReactionsIface_get_cnt(&statechart)+1l);
	childFirstOrthogonalReactionsIface_set_aa_check(&statechart,childFirstOrthogonalReactionsIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ChildFirstOrthogonalReactionsTest::checkAAA(sc_boolean ret)
{
	childFirstOrthogonalReactionsIface_set_cnt(&statechart,childFirstOrthogonalReactionsIface_get_cnt(&statechart)+1l);
	childFirstOrthogonalReactionsIface_set_aaa_check(&statechart,childFirstOrthogonalReactionsIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ChildFirstOrthogonalReactionsTest::checkAAC(sc_boolean ret)
{
	childFirstOrthogonalReactionsIface_set_cnt(&statechart,childFirstOrthogonalReactionsIface_get_cnt(&statechart)+1l);
	childFirstOrthogonalReactionsIface_set_aac_check(&statechart,childFirstOrthogonalReactionsIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ChildFirstOrthogonalReactionsTest::checkAC(sc_boolean ret)
{
	childFirstOrthogonalReactionsIface_set_cnt(&statechart,childFirstOrthogonalReactionsIface_get_cnt(&statechart)+1l);
	childFirstOrthogonalReactionsIface_set_ac_check(&statechart,childFirstOrthogonalReactionsIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ChildFirstOrthogonalReactionsTest::checkC(sc_boolean ret)
{
	childFirstOrthogonalReactionsIface_set_cnt(&statechart,childFirstOrthogonalReactionsIface_get_cnt(&statechart)+1l);
	childFirstOrthogonalReactionsIface_set_c_check(&statechart,childFirstOrthogonalReactionsIface_get_cnt(&statechart));
	return ret;
}
sc_integer ChildFirstOrthogonalReactionsTest::nextCounter()
{
	childFirstOrthogonalReactionsIface_set_cnt(&statechart,childFirstOrthogonalReactionsIface_get_cnt(&statechart)+1l);
	return childFirstOrthogonalReactionsIface_get_cnt(&statechart);
}
void ChildFirstOrthogonalReactionsTest::executionOrder()
{
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	checkMock->setCheckBehavior("AA",&CheckMock::check2);
	checkMock->setCheckBehavior("AAA",&CheckMock::check3);
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	nextMock->setDefaultBehavior(&NextMock::next1);
	childFirstOrthogonalReactions_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aaa_check(&statechart)== 1l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aaa_local(&statechart)== 2l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aac_check(&statechart)== 3l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aac_local(&statechart)== 4l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aa_check(&statechart)== 5l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aa_local(&statechart)== 6l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_ac_check(&statechart)== 7l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_ac_local(&statechart)== 8l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_a_check(&statechart)== 9l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_a_local(&statechart)== 10l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_c_check(&statechart)== 11l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_c_local(&statechart)== 12l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_sm_local(&statechart)== 13l);
}
void ChildFirstOrthogonalReactionsTest::executionOrderWIthFirstLeafTransition()
{
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	checkMock->setCheckBehavior("AA",&CheckMock::check2);
	checkMock->setCheckBehavior("AAA",&CheckMock::check7);
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	nextMock->setDefaultBehavior(&NextMock::next1);
	childFirstOrthogonalReactions_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aaa_check(&statechart)== 1l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aaa_local(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aac_check(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aac_local(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aa_check(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aa_local(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_ac_check(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_ac_local(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_a_check(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_a_local(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_c_check(&statechart)== 2l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_c_local(&statechart)== 3l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_sm_local(&statechart)== 4l);
}
void ChildFirstOrthogonalReactionsTest::executionOrderWIthFirstParentTransition()
{
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	checkMock->setCheckBehavior("AA",&CheckMock::check8);
	checkMock->setCheckBehavior("AAA",&CheckMock::check3);
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	nextMock->setDefaultBehavior(&NextMock::next1);
	childFirstOrthogonalReactions_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aaa_check(&statechart)== 1l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aaa_local(&statechart)== 2l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aac_check(&statechart)== 3l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aac_local(&statechart)== 4l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aa_check(&statechart)== 5l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aa_local(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_ac_check(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_ac_local(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_a_check(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_a_local(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_c_check(&statechart)== 6l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_c_local(&statechart)== 7l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_sm_local(&statechart)== 8l);
}
void ChildFirstOrthogonalReactionsTest::executionOrderWIthFirstGrandParentTransition()
{
	checkMock->setCheckBehavior("A",&CheckMock::check9);
	checkMock->setCheckBehavior("AA",&CheckMock::check2);
	checkMock->setCheckBehavior("AAA",&CheckMock::check3);
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	nextMock->setDefaultBehavior(&NextMock::next1);
	childFirstOrthogonalReactions_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aaa_check(&statechart)== 1l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aaa_local(&statechart)== 2l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aac_check(&statechart)== 3l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aac_local(&statechart)== 4l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aa_check(&statechart)== 5l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aa_local(&statechart)== 6l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_ac_check(&statechart)== 7l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_ac_local(&statechart)== 8l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_a_check(&statechart)== 9l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_a_local(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_c_check(&statechart)== 10l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_c_local(&statechart)== 11l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_sm_local(&statechart)== 12l);
}
void ChildFirstOrthogonalReactionsTest::executionOrderWithLastLeafTransition()
{
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	checkMock->setCheckBehavior("AA",&CheckMock::check2);
	checkMock->setCheckBehavior("AAA",&CheckMock::check3);
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	checkMock->setCheckBehavior("C",&CheckMock::check10);
	nextMock->setDefaultBehavior(&NextMock::next1);
	childFirstOrthogonalReactions_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aaa_check(&statechart)== 1l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aaa_local(&statechart)== 2l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aac_check(&statechart)== 3l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aac_local(&statechart)== 4l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aa_check(&statechart)== 5l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_aa_local(&statechart)== 6l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_ac_check(&statechart)== 7l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_ac_local(&statechart)== 8l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_a_check(&statechart)== 9l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_a_local(&statechart)== 10l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_c_check(&statechart)== 11l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_c_local(&statechart)== 0l);
	EXPECT_TRUE(childFirstOrthogonalReactionsIface_get_sm_local(&statechart)== 12l);
}

void ChildFirstOrthogonalReactionsTest::setTimer(ChildFirstOrthogonalReactions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ChildFirstOrthogonalReactionsTest::unsetTimer(ChildFirstOrthogonalReactions* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ChildFirstOrthogonalReactionsTest, executionOrder) {
	executionOrder();
}
TEST_F(ChildFirstOrthogonalReactionsTest, executionOrderWIthFirstLeafTransition) {
	executionOrderWIthFirstLeafTransition();
}
TEST_F(ChildFirstOrthogonalReactionsTest, executionOrderWIthFirstParentTransition) {
	executionOrderWIthFirstParentTransition();
}
TEST_F(ChildFirstOrthogonalReactionsTest, executionOrderWIthFirstGrandParentTransition) {
	executionOrderWIthFirstGrandParentTransition();
}
TEST_F(ChildFirstOrthogonalReactionsTest, executionOrderWithLastLeafTransition) {
	executionOrderWithLastLeafTransition();
}


sc_boolean childFirstOrthogonalReactionsIface_check(const ChildFirstOrthogonalReactions* statechart, const sc_string value) {
	return (checkMock->*(checkMock->getBehavior(value)))(value);
}
sc_integer childFirstOrthogonalReactionsIface_next(const ChildFirstOrthogonalReactions* statechart) {
	return (nextMock->*(nextMock->getBehavior()))();
}
