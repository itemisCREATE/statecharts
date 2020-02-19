/** Generated by YAKINDU Statechart Tools code generator. */

#include <algorithm>
#include <list>
#include "gtest/gtest.h"
#include "ParentFirstOrthogonalReactions.h"

#include "ParentFirstOrthogonalReactionsRequired.h"
#include "sc_timer_service.h"

#define SC_UNUSED(P) (void)P

static ParentFirstOrthogonalReactions statechart;


class ParentFirstOrthogonalReactionsTest : public ::testing::Test
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
	void setTimer(ParentFirstOrthogonalReactions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ParentFirstOrthogonalReactions* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ParentFirstOrthogonalReactionsTest * tc;

class CheckMock{
	typedef sc_boolean (CheckMock::*functiontype)();
	struct parameters {
		const sc_string id;
		sc_boolean (CheckMock::*behavior)();
		inline bool operator==(const parameters& other) {
			return (strcmp(this->id, other.id) == 0);
		}
	};
	public:
	std::list<CheckMock::parameters> mocks;
	sc_boolean (CheckMock::*checkBehaviorDefault)();

	sc_boolean check1(){
		return (tc->checkA(false));
	}

	sc_boolean check2(){
		return (tc->checkAA(false));
	}

	sc_boolean check3(){
		return (tc->checkAAA(false));
	}

	sc_boolean check4(){
		return (tc->checkAAC(false));
	}

	sc_boolean check5(){
		return (tc->checkAC(false));
	}

	sc_boolean check6(){
		return (tc->checkC(false));
	}

	sc_boolean check7(){
		return (tc->checkAAA(true));
	}

	sc_boolean check8(){
		return (tc->checkAA(true));
	}

	sc_boolean check9(){
		return (tc->checkA(true));
	}

	sc_boolean check10(){
		return (tc->checkC(true));
	}

	sc_boolean checkDefault(){
		sc_boolean defaultValue = false;
		return (defaultValue);
	}

	void setCheckBehavior(const sc_string id,sc_boolean (CheckMock::*func)()){
		parameters p;
		p.id = id;
		p.behavior = func;
	
		std::list<CheckMock::parameters>::iterator i = std::find(mocks.begin(), mocks.end(), p);
		if(i != mocks.end()) {
			mocks.erase(i);
		}
		mocks.push_back(p);
	}

	functiontype getBehavior(const sc_string id){
		parameters p;
		p.id = id;
		
		std::list<CheckMock::parameters>::iterator i = std::find(mocks.begin(), mocks.end(), p);
		if(i != mocks.end()) {
			return  i->behavior;
		} else {
			return checkBehaviorDefault;
		}
	}
	
	void setDefaultBehavior(sc_boolean (CheckMock::*defaultBehavior)()){
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
		sc_integer defaultValue = 0;
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


void ParentFirstOrthogonalReactionsTest::SetUp()
{
	parentFirstOrthogonalReactions_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &parentFirstOrthogonalReactions_runCycle,
		false,
		200,
		&statechart
	);
	
	checkMock = new CheckMock();
	checkMock->initializeBehavior();
	nextMock = new NextMock();
	nextMock->initializeBehavior();
	
	tc = this;
}
sc_boolean ParentFirstOrthogonalReactionsTest::checkA(sc_boolean ret)
{
	parentFirstOrthogonalReactionsIface_set_cnt(&statechart,parentFirstOrthogonalReactionsIface_get_cnt(&statechart)+1);
	parentFirstOrthogonalReactionsIface_set_a_check(&statechart,parentFirstOrthogonalReactionsIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ParentFirstOrthogonalReactionsTest::checkAA(sc_boolean ret)
{
	parentFirstOrthogonalReactionsIface_set_cnt(&statechart,parentFirstOrthogonalReactionsIface_get_cnt(&statechart)+1);
	parentFirstOrthogonalReactionsIface_set_aa_check(&statechart,parentFirstOrthogonalReactionsIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ParentFirstOrthogonalReactionsTest::checkAAA(sc_boolean ret)
{
	parentFirstOrthogonalReactionsIface_set_cnt(&statechart,parentFirstOrthogonalReactionsIface_get_cnt(&statechart)+1);
	parentFirstOrthogonalReactionsIface_set_aaa_check(&statechart,parentFirstOrthogonalReactionsIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ParentFirstOrthogonalReactionsTest::checkAAC(sc_boolean ret)
{
	parentFirstOrthogonalReactionsIface_set_cnt(&statechart,parentFirstOrthogonalReactionsIface_get_cnt(&statechart)+1);
	parentFirstOrthogonalReactionsIface_set_aac_check(&statechart,parentFirstOrthogonalReactionsIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ParentFirstOrthogonalReactionsTest::checkAC(sc_boolean ret)
{
	parentFirstOrthogonalReactionsIface_set_cnt(&statechart,parentFirstOrthogonalReactionsIface_get_cnt(&statechart)+1);
	parentFirstOrthogonalReactionsIface_set_ac_check(&statechart,parentFirstOrthogonalReactionsIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ParentFirstOrthogonalReactionsTest::checkC(sc_boolean ret)
{
	parentFirstOrthogonalReactionsIface_set_cnt(&statechart,parentFirstOrthogonalReactionsIface_get_cnt(&statechart)+1);
	parentFirstOrthogonalReactionsIface_set_c_check(&statechart,parentFirstOrthogonalReactionsIface_get_cnt(&statechart));
	return ret;
}
sc_integer ParentFirstOrthogonalReactionsTest::nextCounter()
{
	parentFirstOrthogonalReactionsIface_set_cnt(&statechart,parentFirstOrthogonalReactionsIface_get_cnt(&statechart)+1);
	return parentFirstOrthogonalReactionsIface_get_cnt(&statechart);
}
void ParentFirstOrthogonalReactionsTest::executionOrder()
{
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	checkMock->setCheckBehavior("AA",&CheckMock::check2);
	checkMock->setCheckBehavior("AAA",&CheckMock::check3);
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	nextMock->setDefaultBehavior(&NextMock::next1);
	parentFirstOrthogonalReactions_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_sm_local(&statechart)== 1);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_a_check(&statechart)== 2);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_a_local(&statechart)== 3);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aa_check(&statechart)== 4);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aa_local(&statechart)== 5);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aaa_check(&statechart)== 6);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aaa_local(&statechart)== 7);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aac_check(&statechart)== 8);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aac_local(&statechart)== 9);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_ac_check(&statechart)== 10);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_ac_local(&statechart)== 11);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_c_check(&statechart)== 12);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_c_local(&statechart)== 13);
}
void ParentFirstOrthogonalReactionsTest::executionOrderWIthFirstLeafTransition()
{
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	checkMock->setCheckBehavior("AA",&CheckMock::check2);
	checkMock->setCheckBehavior("AAA",&CheckMock::check7);
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	nextMock->setDefaultBehavior(&NextMock::next1);
	parentFirstOrthogonalReactions_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_sm_local(&statechart)== 1);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_a_check(&statechart)== 2);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_a_local(&statechart)== 3);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aa_check(&statechart)== 4);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aa_local(&statechart)== 5);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aaa_check(&statechart)== 6);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aaa_local(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aac_check(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aac_local(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_ac_check(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_ac_local(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_c_check(&statechart)== 7);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_c_local(&statechart)== 8);
}
void ParentFirstOrthogonalReactionsTest::executionOrderWIthFirstParentTransition()
{
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	checkMock->setCheckBehavior("AA",&CheckMock::check8);
	checkMock->setCheckBehavior("AAA",&CheckMock::check3);
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	nextMock->setDefaultBehavior(&NextMock::next1);
	parentFirstOrthogonalReactions_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_sm_local(&statechart)== 1);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_a_check(&statechart)== 2);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_a_local(&statechart)== 3);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aa_check(&statechart)== 4);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aa_local(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aaa_check(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aaa_local(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aac_check(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aac_local(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_ac_check(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_ac_local(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_c_check(&statechart)== 5);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_c_local(&statechart)== 6);
}
void ParentFirstOrthogonalReactionsTest::executionOrderWIthFirstGrandParentTransition()
{
	checkMock->setCheckBehavior("A",&CheckMock::check9);
	checkMock->setCheckBehavior("AA",&CheckMock::check2);
	checkMock->setCheckBehavior("AAA",&CheckMock::check3);
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	nextMock->setDefaultBehavior(&NextMock::next1);
	parentFirstOrthogonalReactions_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_sm_local(&statechart)== 1);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_a_check(&statechart)== 2);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_a_local(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aa_check(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aa_local(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aaa_check(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aaa_local(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aac_check(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aac_local(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_ac_check(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_ac_local(&statechart)== 0);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_c_check(&statechart)== 3);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_c_local(&statechart)== 4);
}
void ParentFirstOrthogonalReactionsTest::executionOrderWithLastLeafTransition()
{
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	checkMock->setCheckBehavior("AA",&CheckMock::check2);
	checkMock->setCheckBehavior("AAA",&CheckMock::check3);
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	checkMock->setCheckBehavior("C",&CheckMock::check10);
	nextMock->setDefaultBehavior(&NextMock::next1);
	parentFirstOrthogonalReactions_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_sm_local(&statechart)== 1);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_a_check(&statechart)== 2);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_a_local(&statechart)== 3);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aa_check(&statechart)== 4);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aa_local(&statechart)== 5);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aaa_check(&statechart)== 6);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aaa_local(&statechart)== 7);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aac_check(&statechart)== 8);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_aac_local(&statechart)== 9);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_ac_check(&statechart)== 10);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_ac_local(&statechart)== 11);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_c_check(&statechart)== 12);
	EXPECT_TRUE(parentFirstOrthogonalReactionsIface_get_c_local(&statechart)== 0);
}

void ParentFirstOrthogonalReactionsTest::setTimer(ParentFirstOrthogonalReactions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	SC_UNUSED(statechart);
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ParentFirstOrthogonalReactionsTest::unsetTimer(ParentFirstOrthogonalReactions* handle, const sc_eventid evid){
	SC_UNUSED(handle);
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ParentFirstOrthogonalReactionsTest, executionOrder) {
	executionOrder();
}
TEST_F(ParentFirstOrthogonalReactionsTest, executionOrderWIthFirstLeafTransition) {
	executionOrderWIthFirstLeafTransition();
}
TEST_F(ParentFirstOrthogonalReactionsTest, executionOrderWIthFirstParentTransition) {
	executionOrderWIthFirstParentTransition();
}
TEST_F(ParentFirstOrthogonalReactionsTest, executionOrderWIthFirstGrandParentTransition) {
	executionOrderWIthFirstGrandParentTransition();
}
TEST_F(ParentFirstOrthogonalReactionsTest, executionOrderWithLastLeafTransition) {
	executionOrderWithLastLeafTransition();
}


sc_integer parentFirstOrthogonalReactionsIface_next(const ParentFirstOrthogonalReactions* statechart) {
	SC_UNUSED(statechart);		
	return (nextMock->*(nextMock->getBehavior()))();
}
sc_boolean parentFirstOrthogonalReactionsIface_check(const ParentFirstOrthogonalReactions* statechart, const sc_string id) {
	SC_UNUSED(statechart);		
	return (checkMock->*(checkMock->getBehavior(id)))();
}
