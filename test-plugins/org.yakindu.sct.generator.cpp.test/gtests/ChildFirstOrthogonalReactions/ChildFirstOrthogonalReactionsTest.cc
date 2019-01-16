#include <string>
#include "gtest/gtest.h"
#include "ChildFirstOrthogonalReactions.h"
#include "sc_runner.h"
#include "sc_types.h"
#include "gmock/gmock.h"

using ::testing::AtLeast;
using ::testing::Return;
using ::testing::_;

namespace  {

sc_boolean checkA(sc_boolean ret);
sc_boolean checkAA(sc_boolean ret);
sc_boolean checkAAA(sc_boolean ret);
sc_boolean checkAAC(sc_boolean ret);
sc_boolean checkAC(sc_boolean ret);
sc_boolean checkC(sc_boolean ret);
sc_integer nextCounter();
executionorder::ChildFirstOrthogonalReactions* statechart;


class CheckMock{
	typedef sc_boolean (CheckMock::*functiontype)();
	struct parameters {
		const sc_string value;
		sc_boolean (CheckMock::*behavior)();
		inline bool operator==(const parameters& other) {
			return (this->value == other.value);
		}
	};
	public:
	std::list<CheckMock::parameters> mocks;
	sc_boolean (CheckMock::*checkBehaviorDefault)();

	sc_boolean check1(){
		return (checkA(false));
	}

	sc_boolean check2(){
		return (checkAA(false));
	}

	sc_boolean check3(){
		return (checkAAA(false));
	}

	sc_boolean check4(){
		return (checkAAC(false));
	}

	sc_boolean check5(){
		return (checkAC(false));
	}

	sc_boolean check6(){
		return (checkC(false));
	}

	sc_boolean check7(){
		return (checkAAA(true));
	}

	sc_boolean check8(){
		return (checkAA(true));
	}

	sc_boolean check9(){
		return (checkA(true));
	}

	sc_boolean check10(){
		return (checkC(true));
	}

	sc_boolean checkDefault(){
		sc_boolean defaultValue = false;
		return (defaultValue);
	}

	void setCheckBehavior(const sc_string value,sc_boolean (CheckMock::*func)()){
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
		return (nextCounter());
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

class MockDefault : public executionorder::ChildFirstOrthogonalReactions::DefaultSCI_OCB {
	public:
	sc_boolean check(sc_string value) {
		return (checkMock->*(checkMock->getBehavior(value)))();
	}
	sc_integer next() {
		return (nextMock->*(nextMock->getBehavior()))();
	}
};

//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ChildFirstOrthogonalReactionsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new executionorder::ChildFirstOrthogonalReactions();
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

sc_boolean checkA(sc_boolean ret){
	statechart->getDefaultSCI()->set_cnt(statechart->getDefaultSCI()->get_cnt()+1);
	
	statechart->getDefaultSCI()->set_a_check(statechart->getDefaultSCI()->get_cnt());
	
	return ret;
	
	
}
sc_boolean checkAA(sc_boolean ret){
	statechart->getDefaultSCI()->set_cnt(statechart->getDefaultSCI()->get_cnt()+1);
	
	statechart->getDefaultSCI()->set_aa_check(statechart->getDefaultSCI()->get_cnt());
	
	return ret;
	
	
}
sc_boolean checkAAA(sc_boolean ret){
	statechart->getDefaultSCI()->set_cnt(statechart->getDefaultSCI()->get_cnt()+1);
	
	statechart->getDefaultSCI()->set_aaa_check(statechart->getDefaultSCI()->get_cnt());
	
	return ret;
	
	
}
sc_boolean checkAAC(sc_boolean ret){
	statechart->getDefaultSCI()->set_cnt(statechart->getDefaultSCI()->get_cnt()+1);
	
	statechart->getDefaultSCI()->set_aac_check(statechart->getDefaultSCI()->get_cnt());
	
	return ret;
	
	
}
sc_boolean checkAC(sc_boolean ret){
	statechart->getDefaultSCI()->set_cnt(statechart->getDefaultSCI()->get_cnt()+1);
	
	statechart->getDefaultSCI()->set_ac_check(statechart->getDefaultSCI()->get_cnt());
	
	return ret;
	
	
}
sc_boolean checkC(sc_boolean ret){
	statechart->getDefaultSCI()->set_cnt(statechart->getDefaultSCI()->get_cnt()+1);
	
	statechart->getDefaultSCI()->set_c_check(statechart->getDefaultSCI()->get_cnt());
	
	return ret;
	
	
}
sc_integer nextCounter(){
	statechart->getDefaultSCI()->set_cnt(statechart->getDefaultSCI()->get_cnt()+1);
	
	return statechart->getDefaultSCI()->get_cnt();
	
	
}

TEST_F(ChildFirstOrthogonalReactionsTest, executionOrder) {
	checkMock = new CheckMock();
	checkMock->initializeBehavior();
	nextMock = new NextMock();
	nextMock->initializeBehavior();
	
	MockDefault defaultMock;
	statechart->setDefaultSCI_OCB(&defaultMock);
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	
	checkMock->setCheckBehavior("AA",&CheckMock::check2);
	
	checkMock->setCheckBehavior("AAA",&CheckMock::check3);
	
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	
	nextMock->setDefaultBehavior(&NextMock::next1);
	
	statechart->enter();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_check()== 1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local()== 2);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_check()== 3);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_local()== 4);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_check()== 5);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local()== 6);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_check()== 7);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_local()== 8);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_check()== 9);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local()== 10);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_check()== 11);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_local()== 12);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_sm_local()== 13);
	
	
	checkMock->reset();
	nextMock->reset();
}
TEST_F(ChildFirstOrthogonalReactionsTest, executionOrderWIthFirstLeafTransition) {
	checkMock = new CheckMock();
	checkMock->initializeBehavior();
	nextMock = new NextMock();
	nextMock->initializeBehavior();
	
	MockDefault defaultMock;
	statechart->setDefaultSCI_OCB(&defaultMock);
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	
	checkMock->setCheckBehavior("AA",&CheckMock::check2);
	
	checkMock->setCheckBehavior("AAA",&CheckMock::check7);
	
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	
	nextMock->setDefaultBehavior(&NextMock::next1);
	
	statechart->enter();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_check()== 1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_check()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_local()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_check()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_check()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_local()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_check()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_check()== 2);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_local()== 3);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_sm_local()== 4);
	
	
	checkMock->reset();
	nextMock->reset();
}
TEST_F(ChildFirstOrthogonalReactionsTest, executionOrderWIthFirstParentTransition) {
	checkMock = new CheckMock();
	checkMock->initializeBehavior();
	nextMock = new NextMock();
	nextMock->initializeBehavior();
	
	MockDefault defaultMock;
	statechart->setDefaultSCI_OCB(&defaultMock);
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	
	checkMock->setCheckBehavior("AA",&CheckMock::check8);
	
	checkMock->setCheckBehavior("AAA",&CheckMock::check3);
	
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	
	nextMock->setDefaultBehavior(&NextMock::next1);
	
	statechart->enter();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_check()== 1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local()== 2);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_check()== 3);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_local()== 4);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_check()== 5);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_check()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_local()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_check()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_check()== 6);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_local()== 7);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_sm_local()== 8);
	
	
	checkMock->reset();
	nextMock->reset();
}
TEST_F(ChildFirstOrthogonalReactionsTest, executionOrderWIthFirstGrandParentTransition) {
	checkMock = new CheckMock();
	checkMock->initializeBehavior();
	nextMock = new NextMock();
	nextMock->initializeBehavior();
	
	MockDefault defaultMock;
	statechart->setDefaultSCI_OCB(&defaultMock);
	checkMock->setCheckBehavior("A",&CheckMock::check9);
	
	checkMock->setCheckBehavior("AA",&CheckMock::check2);
	
	checkMock->setCheckBehavior("AAA",&CheckMock::check3);
	
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	
	nextMock->setDefaultBehavior(&NextMock::next1);
	
	statechart->enter();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_check()== 1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local()== 2);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_check()== 3);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_local()== 4);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_check()== 5);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local()== 6);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_check()== 7);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_local()== 8);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_check()== 9);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_check()== 10);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_local()== 11);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_sm_local()== 12);
	
	
	checkMock->reset();
	nextMock->reset();
}
TEST_F(ChildFirstOrthogonalReactionsTest, executionOrderWithLastLeafTransition) {
	checkMock = new CheckMock();
	checkMock->initializeBehavior();
	nextMock = new NextMock();
	nextMock->initializeBehavior();
	
	MockDefault defaultMock;
	statechart->setDefaultSCI_OCB(&defaultMock);
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	
	checkMock->setCheckBehavior("AA",&CheckMock::check2);
	
	checkMock->setCheckBehavior("AAA",&CheckMock::check3);
	
	checkMock->setCheckBehavior("AAC",&CheckMock::check4);
	
	checkMock->setCheckBehavior("AC",&CheckMock::check5);
	
	checkMock->setCheckBehavior("C",&CheckMock::check10);
	
	nextMock->setDefaultBehavior(&NextMock::next1);
	
	statechart->enter();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_check()== 1);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local()== 2);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_check()== 3);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_local()== 4);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_check()== 5);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local()== 6);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_check()== 7);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_local()== 8);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_check()== 9);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local()== 10);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_check()== 11);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_local()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_sm_local()== 12);
	
	
	checkMock->reset();
	nextMock->reset();
}

}

