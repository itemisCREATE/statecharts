
#include <algorithm>
#include <list>
#include "gtest/gtest.h"
#include "Operations.h"

#include "OperationsRequired.h"
#include "sc_timer_service.h"

static Operations statechart;


class OperationsTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void operationsCalled();
	void operationsNotCalled();
	void setTimer(Operations* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(Operations* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static OperationsTest * tc;

class AlwaysTrueMock{
	typedef sc_boolean (AlwaysTrueMock::*functiontype)();
	public:
	sc_boolean (AlwaysTrueMock::*alwaysTrueBehaviorDefault)();

	sc_boolean alwaysTrue1(){
		return (true);
	}

	sc_boolean alwaysTrueDefault(){
		sc_boolean defaultValue = false;
		return (defaultValue);
	}

	functiontype getBehavior(){
		return alwaysTrueBehaviorDefault;
	}
	
	void setDefaultBehavior(sc_boolean (AlwaysTrueMock::*defaultBehavior)()){
		alwaysTrueBehaviorDefault = defaultBehavior;
	}
	
	void initializeBehavior() {
		setDefaultBehavior(&AlwaysTrueMock::alwaysTrueDefault);
	}
	
	void reset() {
		initializeBehavior();
	}
};
static AlwaysTrueMock* alwaysTrueMock;

class InternalOperation1Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void internalOperation1() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static InternalOperation1Mock* internalOperation1Mock;

class InternalOperation2Mock{
	struct parameters {
		sc_integer param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<InternalOperation2Mock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void InternalOperation2(const sc_integer param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static InternalOperation2Mock* internalOperation2Mock;

class InternalOperation3Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void internalOperation3() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static InternalOperation3Mock* internalOperation3Mock;

class InternalOperation3aMock{
	struct parameters {
		sc_real param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<InternalOperation3aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_real param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_real param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void internalOperation3a(const sc_real param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static InternalOperation3aMock* internalOperation3aMock;

class InternalOperation4Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void internalOperation4() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static InternalOperation4Mock* internalOperation4Mock;

class InternalOperation4aMock{
	struct parameters {
		sc_integer param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<InternalOperation4aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void internalOperation4a(const sc_integer param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static InternalOperation4aMock* internalOperation4aMock;

class InternalOperation5Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void internalOperation5() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static InternalOperation5Mock* internalOperation5Mock;

class InternalOperation5aMock{
	struct parameters {
		const sc_string param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<InternalOperation5aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_string param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_string param1){
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void internalOperation5a(const sc_string param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<InternalOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static InternalOperation5aMock* internalOperation5aMock;

class Interface1InterfaceOperation1Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void interfaceOperation1() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static Interface1InterfaceOperation1Mock* interface1InterfaceOperation1Mock;

class Interface1InterfaceOperation2Mock{
	struct parameters {
		sc_integer param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<Interface1InterfaceOperation2Mock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void InterfaceOperation2(const sc_integer param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static Interface1InterfaceOperation2Mock* interface1InterfaceOperation2Mock;

class Interface1InterfaceOperation3Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void interfaceOperation3() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static Interface1InterfaceOperation3Mock* interface1InterfaceOperation3Mock;

class Interface1InterfaceOperation3aMock{
	struct parameters {
		sc_real param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<Interface1InterfaceOperation3aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_real param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_real param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void interfaceOperation3a(const sc_real param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static Interface1InterfaceOperation3aMock* interface1InterfaceOperation3aMock;

class Interface1InterfaceOperation4Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void interfaceOperation4() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static Interface1InterfaceOperation4Mock* interface1InterfaceOperation4Mock;

class Interface1InterfaceOperation4aMock{
	struct parameters {
		sc_integer param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<Interface1InterfaceOperation4aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void interfaceOperation4a(const sc_integer param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static Interface1InterfaceOperation4aMock* interface1InterfaceOperation4aMock;

class Interface1InterfaceOperation5Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void interfaceOperation5() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static Interface1InterfaceOperation5Mock* interface1InterfaceOperation5Mock;

class Interface1InterfaceOperation5aMock{
	struct parameters {
		const sc_string param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<Interface1InterfaceOperation5aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_string param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_string param1){
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void interfaceOperation5a(const sc_string param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<Interface1InterfaceOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static Interface1InterfaceOperation5aMock* interface1InterfaceOperation5aMock;

class UnnamedInterfaceOperation1Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void unnamedInterfaceOperation1() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static UnnamedInterfaceOperation1Mock* unnamedInterfaceOperation1Mock;

class UnnamedInterfaceOperation2Mock{
	struct parameters {
		sc_integer param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<UnnamedInterfaceOperation2Mock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedInterfaceOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedInterfaceOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void UnnamedInterfaceOperation2(const sc_integer param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedInterfaceOperation2Mock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static UnnamedInterfaceOperation2Mock* unnamedInterfaceOperation2Mock;

class UnnamedOperation3Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void unnamedOperation3() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static UnnamedOperation3Mock* unnamedOperation3Mock;

class UnnamedOperation3aMock{
	struct parameters {
		sc_real param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<UnnamedOperation3aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_real param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_real param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void unnamedOperation3a(const sc_real param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation3aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static UnnamedOperation3aMock* unnamedOperation3aMock;

class UnnamedOperation4Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void unnamedOperation4() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static UnnamedOperation4Mock* unnamedOperation4Mock;

class UnnamedOperation4aMock{
	struct parameters {
		sc_integer param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<UnnamedOperation4aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_integer param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void unnamedOperation4a(const sc_integer param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation4aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static UnnamedOperation4aMock* unnamedOperation4aMock;

class UnnamedOperation5Mock{
	public:
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	void unnamedOperation5() {
		++callCount;
	}
	void reset() {
		callCount = 0;
	}
};
static UnnamedOperation5Mock* unnamedOperation5Mock;

class UnnamedOperation5aMock{
	struct parameters {
		const sc_string param1;
		int callCount;
		inline bool operator==(const parameters& other) {
			return (this->param1 == other.param1);
		}
	};
	public:
	std::list<UnnamedOperation5aMock::parameters> paramCount;
	int callCount;

	sc_boolean calledAtLeast(const int times){
		return (callCount >= times);
	}
	
	sc_boolean calledAtLeastOnce(){
		return (callCount>0);
	}

	sc_boolean calledAtLeast(const int times, const sc_string param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount >= times);
		}else{
			return false;
		}
	}
	
	sc_boolean calledAtLeastOnce(const sc_string param1){
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			return (i->callCount > 0);
		}else{
			return false;
		}
	}

	void unnamedOperation5a(const sc_string param1) {
		++callCount;
		
		parameters p;
		p.param1 = param1;
		
		std::list<UnnamedOperation5aMock::parameters>::iterator i = std::find(paramCount.begin(), paramCount.end(), p);
		if(i != paramCount.end()) {
			p.callCount = (++i->callCount);
			paramCount.erase(i);
			
		}else{
			p.callCount = 1;
		}
		paramCount.push_back(p);
	}
	void reset() {
		callCount = 0;
		paramCount.clear();
	}
};
static UnnamedOperation5aMock* unnamedOperation5aMock;


void OperationsTest::SetUp()
{
	operations_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &operations_runCycle,
		false,
		200,
		&statechart
	);
	
	alwaysTrueMock = new AlwaysTrueMock();
	alwaysTrueMock->initializeBehavior();
	internalOperation1Mock = new InternalOperation1Mock();
	internalOperation2Mock = new InternalOperation2Mock();
	internalOperation3Mock = new InternalOperation3Mock();
	internalOperation3aMock = new InternalOperation3aMock();
	internalOperation4Mock = new InternalOperation4Mock();
	internalOperation4aMock = new InternalOperation4aMock();
	internalOperation5Mock = new InternalOperation5Mock();
	internalOperation5aMock = new InternalOperation5aMock();
	interface1InterfaceOperation1Mock = new Interface1InterfaceOperation1Mock();
	interface1InterfaceOperation2Mock = new Interface1InterfaceOperation2Mock();
	interface1InterfaceOperation3Mock = new Interface1InterfaceOperation3Mock();
	interface1InterfaceOperation3aMock = new Interface1InterfaceOperation3aMock();
	interface1InterfaceOperation4Mock = new Interface1InterfaceOperation4Mock();
	interface1InterfaceOperation4aMock = new Interface1InterfaceOperation4aMock();
	interface1InterfaceOperation5Mock = new Interface1InterfaceOperation5Mock();
	interface1InterfaceOperation5aMock = new Interface1InterfaceOperation5aMock();
	unnamedInterfaceOperation1Mock = new UnnamedInterfaceOperation1Mock();
	unnamedInterfaceOperation2Mock = new UnnamedInterfaceOperation2Mock();
	unnamedOperation3Mock = new UnnamedOperation3Mock();
	unnamedOperation3aMock = new UnnamedOperation3aMock();
	unnamedOperation4Mock = new UnnamedOperation4Mock();
	unnamedOperation4aMock = new UnnamedOperation4aMock();
	unnamedOperation5Mock = new UnnamedOperation5Mock();
	unnamedOperation5aMock = new UnnamedOperation5aMock();
	
	tc = this;
}
void OperationsTest::operationsCalled()
{
	alwaysTrueMock->setDefaultBehavior(&AlwaysTrueMock::alwaysTrue1);
	operations_enter(&statechart);
	EXPECT_TRUE(operations_isStateActive(&statechart, Operations_main_region_A));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(operations_isStateActive(&statechart, Operations_main_region_B));
	EXPECT_TRUE(internalOperation1Mock->calledAtLeastOnce());
	EXPECT_TRUE(internalOperation2Mock->calledAtLeastOnce(4));
	EXPECT_TRUE(internalOperation3Mock->calledAtLeastOnce());
	EXPECT_TRUE(internalOperation3aMock->calledAtLeastOnce(1.0));
	EXPECT_TRUE(internalOperation4Mock->calledAtLeastOnce());
	EXPECT_TRUE(internalOperation4aMock->calledAtLeastOnce(5));
	EXPECT_TRUE(internalOperation5Mock->calledAtLeastOnce());
	EXPECT_TRUE(internalOperation5aMock->calledAtLeastOnce());
	operationsIface_raise_ev(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(operations_isStateActive(&statechart, Operations_main_region_C));
	EXPECT_TRUE(interface1InterfaceOperation1Mock->calledAtLeastOnce());
	EXPECT_TRUE(interface1InterfaceOperation2Mock->calledAtLeastOnce(4));
	EXPECT_TRUE(interface1InterfaceOperation3Mock->calledAtLeastOnce());
	EXPECT_TRUE(interface1InterfaceOperation3aMock->calledAtLeastOnce(1.0));
	EXPECT_TRUE(interface1InterfaceOperation4Mock->calledAtLeastOnce());
	EXPECT_TRUE(interface1InterfaceOperation4aMock->calledAtLeastOnce(5));
	EXPECT_TRUE(interface1InterfaceOperation5Mock->calledAtLeastOnce());
	EXPECT_TRUE(interface1InterfaceOperation5aMock->calledAtLeastOnce());
	operationsIface_raise_ev(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(operations_isStateActive(&statechart, Operations_main_region_D));
	EXPECT_TRUE(unnamedInterfaceOperation1Mock->calledAtLeastOnce());
	EXPECT_TRUE(unnamedInterfaceOperation2Mock->calledAtLeastOnce(4));
	EXPECT_TRUE(unnamedOperation3Mock->calledAtLeastOnce());
	EXPECT_TRUE(unnamedOperation3aMock->calledAtLeastOnce(1.0));
	EXPECT_TRUE(unnamedOperation4Mock->calledAtLeastOnce());
	EXPECT_TRUE(unnamedOperation4aMock->calledAtLeastOnce(5));
	EXPECT_TRUE(unnamedOperation5Mock->calledAtLeastOnce());
	EXPECT_TRUE(unnamedOperation5aMock->calledAtLeastOnce());
}
void OperationsTest::operationsNotCalled()
{
	alwaysTrueMock->setDefaultBehavior(&AlwaysTrueMock::alwaysTrue1);
	operations_enter(&statechart);
	EXPECT_TRUE(operations_isStateActive(&statechart, Operations_main_region_A));
	EXPECT_FALSE(internalOperation1Mock->calledAtLeastOnce());
	EXPECT_FALSE(internalOperation2Mock->calledAtLeastOnce(4));
	EXPECT_FALSE(internalOperation3Mock->calledAtLeastOnce());
	EXPECT_FALSE(internalOperation3aMock->calledAtLeastOnce(1.0));
	EXPECT_FALSE(internalOperation4Mock->calledAtLeastOnce());
	EXPECT_FALSE(internalOperation4aMock->calledAtLeastOnce(5));
	EXPECT_FALSE(internalOperation5Mock->calledAtLeastOnce());
	EXPECT_FALSE(internalOperation5aMock->calledAtLeastOnce());
	operationsIface_raise_ev(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(operations_isStateActive(&statechart, Operations_main_region_B));
	EXPECT_FALSE(interface1InterfaceOperation1Mock->calledAtLeastOnce());
	EXPECT_FALSE(interface1InterfaceOperation2Mock->calledAtLeastOnce(4));
	EXPECT_FALSE(interface1InterfaceOperation3Mock->calledAtLeastOnce());
	EXPECT_FALSE(interface1InterfaceOperation3aMock->calledAtLeastOnce(1.0));
	EXPECT_FALSE(interface1InterfaceOperation4Mock->calledAtLeastOnce());
	EXPECT_FALSE(interface1InterfaceOperation4aMock->calledAtLeastOnce(5));
	EXPECT_FALSE(interface1InterfaceOperation5Mock->calledAtLeastOnce());
	EXPECT_FALSE(interface1InterfaceOperation5aMock->calledAtLeastOnce());
	operationsIface_raise_ev(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(operations_isStateActive(&statechart, Operations_main_region_C));
	EXPECT_FALSE(unnamedInterfaceOperation1Mock->calledAtLeastOnce());
	EXPECT_FALSE(unnamedInterfaceOperation2Mock->calledAtLeastOnce(4));
	EXPECT_FALSE(unnamedOperation3Mock->calledAtLeastOnce());
	EXPECT_FALSE(unnamedOperation3aMock->calledAtLeastOnce(1.0));
	EXPECT_FALSE(unnamedOperation4Mock->calledAtLeastOnce());
	EXPECT_FALSE(unnamedOperation4aMock->calledAtLeastOnce(5));
	EXPECT_FALSE(unnamedOperation5Mock->calledAtLeastOnce());
	EXPECT_FALSE(unnamedOperation5aMock->calledAtLeastOnce());
}

void OperationsTest::setTimer(Operations* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void OperationsTest::unsetTimer(Operations* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(OperationsTest, operationsCalled) {
	operationsCalled();
}
TEST_F(OperationsTest, operationsNotCalled) {
	operationsNotCalled();
}


void operationsInternal_internalOperation1(const Operations* statechart) {
	internalOperation1Mock->internalOperation1();
}
sc_boolean operationsInternal_internalOperation2(const Operations* statechart, const sc_integer param1) {
	internalOperation2Mock->InternalOperation2(param1);
	return false;
}
sc_real operationsInternal_internalOperation3(const Operations* statechart) {
	internalOperation3Mock->internalOperation3();
	return 0.0;
}
sc_real operationsInternal_internalOperation3a(const Operations* statechart, const sc_real param1) {
	internalOperation3aMock->internalOperation3a(param1);
	return 0.0;
}
sc_integer operationsInternal_internalOperation4(const Operations* statechart) {
	internalOperation4Mock->internalOperation4();
	return 0;
}
sc_integer operationsInternal_internalOperation4a(const Operations* statechart, const sc_integer param1) {
	internalOperation4aMock->internalOperation4a(param1);
	return 0;
}
sc_string operationsInternal_internalOperation5(const Operations* statechart) {
	internalOperation5Mock->internalOperation5();
	return "";
}
sc_string operationsInternal_internalOperation5a(const Operations* statechart, const sc_string param1) {
	internalOperation5aMock->internalOperation5a(param1);
	return "";
}
void operationsIfaceInterface1_interfaceOperation1(const Operations* statechart) {
	interface1InterfaceOperation1Mock->interfaceOperation1();
}
sc_boolean operationsIfaceInterface1_interfaceOperation2(const Operations* statechart, const sc_integer param1) {
	interface1InterfaceOperation2Mock->InterfaceOperation2(param1);
	return false;
}
sc_real operationsIfaceInterface1_interfaceOperation3(const Operations* statechart) {
	interface1InterfaceOperation3Mock->interfaceOperation3();
	return 0.0;
}
sc_real operationsIfaceInterface1_interfaceOperation3a(const Operations* statechart, const sc_real param1) {
	interface1InterfaceOperation3aMock->interfaceOperation3a(param1);
	return 0.0;
}
sc_integer operationsIfaceInterface1_interfaceOperation4(const Operations* statechart) {
	interface1InterfaceOperation4Mock->interfaceOperation4();
	return 0;
}
sc_integer operationsIfaceInterface1_interfaceOperation4a(const Operations* statechart, const sc_integer param1) {
	interface1InterfaceOperation4aMock->interfaceOperation4a(param1);
	return 0;
}
sc_string operationsIfaceInterface1_interfaceOperation5(const Operations* statechart) {
	interface1InterfaceOperation5Mock->interfaceOperation5();
	return "";
}
sc_string operationsIfaceInterface1_interfaceOperation5a(const Operations* statechart, const sc_string param1) {
	interface1InterfaceOperation5aMock->interfaceOperation5a(param1);
	return "";
}
void operationsIface_unnamedInterfaceOperation1(const Operations* statechart) {
	unnamedInterfaceOperation1Mock->unnamedInterfaceOperation1();
}
sc_boolean operationsIface_unnamedInterfaceOperation2(const Operations* statechart, const sc_integer param1) {
	unnamedInterfaceOperation2Mock->UnnamedInterfaceOperation2(param1);
	return false;
}
sc_real operationsIface_unnamedOperation3(const Operations* statechart) {
	unnamedOperation3Mock->unnamedOperation3();
	return 0.0;
}
sc_real operationsIface_unnamedOperation3a(const Operations* statechart, const sc_real param1) {
	unnamedOperation3aMock->unnamedOperation3a(param1);
	return 0.0;
}
sc_integer operationsIface_unnamedOperation4(const Operations* statechart) {
	unnamedOperation4Mock->unnamedOperation4();
	return 0;
}
sc_integer operationsIface_unnamedOperation4a(const Operations* statechart, const sc_integer param1) {
	unnamedOperation4aMock->unnamedOperation4a(param1);
	return 0;
}
sc_string operationsIface_unnamedOperation5(const Operations* statechart) {
	unnamedOperation5Mock->unnamedOperation5();
	return "";
}
sc_string operationsIface_unnamedOperation5a(const Operations* statechart, const sc_string param1) {
	unnamedOperation5aMock->unnamedOperation5a(param1);
	return "";
}
sc_boolean operationsIface_alwaysTrue(const Operations* statechart) {
	return (alwaysTrueMock->*(alwaysTrueMock->getBehavior()))();
}
