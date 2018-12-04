#include <string>
#include "gtest/gtest.h"
#include "ParentFirstOrthogonalReactions.h"
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
executionorder::ParentFirstOrthogonalReactions* statechart;


class CheckMock{
	typedef sc_boolean (CheckMock::*functiontype)(const sc_string);
	struct parameters {
		const sc_string id;
		sc_boolean (CheckMock::*behavior)(const sc_string);
		inline bool operator==(const parameters& other) {
			return (this->id == other.id);
		}
	};
	public:
	std::list<CheckMock::parameters> mocks;
	sc_boolean (CheckMock::*checkBehaviorDefault)(const sc_string);

	sc_boolean check1(const sc_string id){
		return (checkA(false));
	}

	sc_boolean check2(const sc_string id){
		return (checkAA(false));
	}

	sc_boolean check3(const sc_string id){
		return (checkAAA(false));
	}

	sc_boolean check4(const sc_string id){
		return (checkAAC(false));
	}

	sc_boolean check5(const sc_string id){
		return (checkAC(false));
	}

	sc_boolean check6(const sc_string id){
		return (checkC(false));
	}

	sc_boolean check7(const sc_string id){
		return (checkAAA(true));
	}

	sc_boolean check8(const sc_string id){
		return (checkAA(true));
	}

	sc_boolean check9(const sc_string id){
		return (checkA(true));
	}

	sc_boolean check10(const sc_string id){
		return (checkC(true));
	}

	sc_boolean checkDefault(const sc_string id){
		sc_boolean defaultValue = null;
		return (defaultValue);
	}

	void setCheckBehavior(const sc_string id,sc_boolean (CheckMock::*func)(const sc_string)){
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
		return (nextCounter());
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

class MockDefault : public executionorder::ParentFirstOrthogonalReactions::DefaultSCI_OCB {
	public:
	sc_integer next() {
		return (nextMock->*(nextMock->getBehavior()))();
	}
	sc_boolean check(sc_string id) {
		return (checkMock->*(checkMock->getBehavior(id)))(id);
	}
};

//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class ParentFirstOrthogonalReactionsTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new executionorder::ParentFirstOrthogonalReactions();
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
	statechart->getDefaultSCI()->set_cnt(statechart->getDefaultSCI()->get_cnt()+1l);
	
	statechart->getDefaultSCI()->set_a_check(statechart->getDefaultSCI()->get_cnt());
	
	return ret;
	
	
}
sc_boolean checkAA(sc_boolean ret){
	statechart->getDefaultSCI()->set_cnt(statechart->getDefaultSCI()->get_cnt()+1l);
	
	statechart->getDefaultSCI()->set_aa_check(statechart->getDefaultSCI()->get_cnt());
	
	return ret;
	
	
}
sc_boolean checkAAA(sc_boolean ret){
	statechart->getDefaultSCI()->set_cnt(statechart->getDefaultSCI()->get_cnt()+1l);
	
	statechart->getDefaultSCI()->set_aaa_check(statechart->getDefaultSCI()->get_cnt());
	
	return ret;
	
	
}
sc_boolean checkAAC(sc_boolean ret){
	statechart->getDefaultSCI()->set_cnt(statechart->getDefaultSCI()->get_cnt()+1l);
	
	statechart->getDefaultSCI()->set_aac_check(statechart->getDefaultSCI()->get_cnt());
	
	return ret;
	
	
}
sc_boolean checkAC(sc_boolean ret){
	statechart->getDefaultSCI()->set_cnt(statechart->getDefaultSCI()->get_cnt()+1l);
	
	statechart->getDefaultSCI()->set_ac_check(statechart->getDefaultSCI()->get_cnt());
	
	return ret;
	
	
}
sc_boolean checkC(sc_boolean ret){
	statechart->getDefaultSCI()->set_cnt(statechart->getDefaultSCI()->get_cnt()+1l);
	
	statechart->getDefaultSCI()->set_c_check(statechart->getDefaultSCI()->get_cnt());
	
	return ret;
	
	
}
sc_integer nextCounter(){
	statechart->getDefaultSCI()->set_cnt(statechart->getDefaultSCI()->get_cnt()+1l);
	
	return statechart->getDefaultSCI()->get_cnt();
	
	
}

TEST_F(ParentFirstOrthogonalReactionsTest, executionOrder) {
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
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_sm_local()== 1l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_check()== 2l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local()== 3l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_check()== 4l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local()== 5l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_check()== 6l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local()== 7l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_check()== 8l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_local()== 9l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_check()== 10l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_local()== 11l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_check()== 12l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_local()== 13l);
	
	
	checkMock->reset();
	nextMock->reset();
}
TEST_F(ParentFirstOrthogonalReactionsTest, executionOrderWIthFirstLeafTransition) {
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
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_sm_local()== 1l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_check()== 2l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local()== 3l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_check()== 4l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local()== 5l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_check()== 6l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_check()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_check()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_check()== 7l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_local()== 8l);
	
	
	checkMock->reset();
	nextMock->reset();
}
TEST_F(ParentFirstOrthogonalReactionsTest, executionOrderWIthFirstParentTransition) {
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
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_sm_local()== 1l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_check()== 2l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local()== 3l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_check()== 4l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_check()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_check()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_check()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_check()== 5l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_local()== 6l);
	
	
	checkMock->reset();
	nextMock->reset();
}
TEST_F(ParentFirstOrthogonalReactionsTest, executionOrderWIthFirstGrandParentTransition) {
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
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_sm_local()== 1l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_check()== 2l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_check()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_check()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_check()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_check()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_local()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_check()== 3l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_local()== 4l);
	
	
	checkMock->reset();
	nextMock->reset();
}
TEST_F(ParentFirstOrthogonalReactionsTest, executionOrderWithLastLeafTransition) {
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
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_sm_local()== 1l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_check()== 2l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a_local()== 3l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_check()== 4l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aa_local()== 5l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_check()== 6l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aaa_local()== 7l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_check()== 8l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_aac_local()== 9l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_check()== 10l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_ac_local()== 11l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_check()== 12l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c_local()== 0l);
	
	
	checkMock->reset();
	nextMock->reset();
}

}

