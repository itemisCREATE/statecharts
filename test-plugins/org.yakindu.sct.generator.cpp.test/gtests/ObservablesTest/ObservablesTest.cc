/*
 * ObservableTest.cc
 *
 *  Created on: 27.05.2020
 *      Author: aterfloth
 */




#include <string>
#include "gtest/gtest.h"
#include "sc_rxcpp.h"

namespace  {


class ObservableTest : public ::testing::Test
{
protected:
	virtual void SetUp()
	{
	}


	virtual void TearDown()
	{
	}


};

class IntAdder : public sc::rx::Observer<int>
{
public:
	int sum = 0;
	virtual ~IntAdder() {}
	virtual void next(int value)
	{
		this->sum += value;
	}
};

class Counter : public sc::rx::Observer<void>
{
public:
	int count = 0;
	virtual ~Counter() {}
	virtual void next()
	{
		this->count++;
	}
};

TEST_F(ObservableTest, testObserver)
{

	IntAdder adder;
	adder.next(1);
	adder.next(2);
	adder.next(3);

	EXPECT_EQ(adder.sum, 6);
}

TEST_F(ObservableTest, testVoidObserver)
{

	Counter counter;
	counter.next();
	counter.next();
	counter.next();
	counter.next();

	EXPECT_EQ(counter.count, 4);
}


TEST_F(ObservableTest, testCreateSubscription) {

	IntAdder adder;
	sc::rx::subscription<int> adder_subscription(&adder);

	EXPECT_EQ(&adder, adder_subscription.observer);
}


TEST_F(ObservableTest, testSubscribeNullSubscription) {

	sc::rx::Observable<int> observable;
	EXPECT_FALSE(observable.subscribe((sc_null)));
}


TEST_F(ObservableTest, testSubscribeWithNullObserver) {

	sc::rx::subscription<int> sub(sc_null);
	sc::rx::Observable<int> observable;
	EXPECT_FALSE(observable.subscribe(&sub));
}


TEST_F(ObservableTest, testSubscribe) {
	IntAdder adder;
	sc::rx::subscription<int> sub(&adder);
	sc::rx::Observable<int> observable;
	EXPECT_TRUE(observable.subscribe(&sub));
	EXPECT_EQ(sub.next, &sub);
}


TEST_F(ObservableTest, testMultipleSubscribeOnObservable) {
	IntAdder adder;
	sc::rx::subscription<int> substription1(&adder);
	sc::rx::subscription<int> substription2(&adder);
	sc::rx::subscription<int> substription3(&adder);
	sc::rx::subscription<int> substription4(&adder);
	sc::rx::Observable<int> observable;
	EXPECT_TRUE(observable.subscribe(&substription1));
	EXPECT_TRUE(observable.subscribe(&substription2));
	EXPECT_TRUE(observable.subscribe(&substription3));
	EXPECT_TRUE(observable.subscribe(&substription4));
	EXPECT_EQ(substription1.next, &substription1);
	EXPECT_EQ(substription2.next, &substription1);
	EXPECT_EQ(substription3.next, &substription2);
	EXPECT_EQ(substription4.next, &substription3);
}

TEST_F(ObservableTest, testSubscribeSubscribedSubscription) {
	IntAdder adder;
	sc::rx::subscription<int> substription1(&adder);
	sc::rx::subscription<int> substription2(&adder);
	sc::rx::Observable<int> observable;

	EXPECT_TRUE(observable.subscribe(&substription1));
	EXPECT_TRUE(observable.subscribe(&substription2));

	EXPECT_FALSE(observable.subscribe(&substription1));
	EXPECT_FALSE(observable.subscribe(&substription2));
}


TEST_F(ObservableTest, testUnsubscribeNullSubscription)
{
	sc::rx::Observable<int> observable;
	EXPECT_FALSE(observable.unsubscribe(sc_null));
}


TEST_F(ObservableTest, testUnsubscribeFromUnsubscribed)
{
	sc::rx::subscription<int> subscription(sc_null);
	sc::rx::Observable<int> observable;

	EXPECT_FALSE(observable.unsubscribe(&subscription));
}


TEST_F(ObservableTest, testUnsubscribe)
{
	IntAdder adder;
	sc::rx::subscription<int> subscription(&adder);
	sc::rx::Observable<int> observable;

	EXPECT_TRUE(observable.subscribe(&subscription));
	EXPECT_TRUE(observable.unsubscribe(&subscription));
}


TEST_F(ObservableTest, testUnsubscribeUnsubscribed)
{
	IntAdder adder;
	sc::rx::subscription<int> subscription(&adder);
	sc::rx::Observable<int> observable;

	EXPECT_TRUE(observable.subscribe(&subscription));
	EXPECT_TRUE(observable.unsubscribe(&subscription));
	EXPECT_FALSE(observable.unsubscribe(&subscription));
}

TEST_F(ObservableTest, testUnsubscribeNotSubscribed)
{
	IntAdder adder;
	sc::rx::subscription<int> subscription1(&adder);
	sc::rx::subscription<int> subscription2(&adder);
	sc::rx::subscription<int> subscription3(&adder);
	sc::rx::Observable<int> observable;

	EXPECT_TRUE(observable.subscribe(&subscription1));
	EXPECT_FALSE(observable.unsubscribe(&subscription3));

	EXPECT_TRUE(observable.subscribe(&subscription2));
	EXPECT_FALSE(observable.unsubscribe(&subscription3));
}

TEST_F(ObservableTest, testUnsubscribeSubscriptionOfForeinObservable)
{
	IntAdder adder;
	sc::rx::subscription<int> subscription1(&adder);
	sc::rx::subscription<int> subscription2(&adder);

	sc::rx::Observable<int> observable1;
	sc::rx::Observable<int> observable2;

	EXPECT_TRUE(observable1.subscribe(&subscription1));
	EXPECT_TRUE(observable2.subscribe(&subscription2));
	EXPECT_FALSE(observable1.unsubscribe(&subscription2));
}


TEST_F(ObservableTest, testUnsubscribeMultipleSubscriptions)
{
	IntAdder adder;
	sc::rx::subscription<int> subscription1(&adder);
	sc::rx::subscription<int> subscription2(&adder);
	sc::rx::subscription<int> subscription3(&adder);
	sc::rx::subscription<int> subscription4(&adder);

	sc::rx::Observable<int> observable;

	EXPECT_TRUE(observable.subscribe(&subscription1));
	EXPECT_TRUE(observable.subscribe(&subscription2));
	EXPECT_TRUE(observable.subscribe(&subscription3));
	EXPECT_TRUE(observable.subscribe(&subscription4));

	EXPECT_TRUE(observable.unsubscribe(&subscription1));
	EXPECT_TRUE(observable.unsubscribe(&subscription2));
	EXPECT_TRUE(observable.unsubscribe(&subscription3));
	EXPECT_TRUE(observable.unsubscribe(&subscription4));
}

TEST_F(ObservableTest, testUnsubscribeMultipleSubscriptionsReverseOrder)
{
	IntAdder adder;
	sc::rx::subscription<int> subscription1(&adder);
	sc::rx::subscription<int> subscription2(&adder);
	sc::rx::subscription<int> subscription3(&adder);
	sc::rx::subscription<int> subscription4(&adder);

	sc::rx::Observable<int> observable;

	EXPECT_TRUE(observable.subscribe(&subscription1));
	EXPECT_TRUE(observable.subscribe(&subscription2));
	EXPECT_TRUE(observable.subscribe(&subscription3));
	EXPECT_TRUE(observable.subscribe(&subscription4));

	EXPECT_TRUE(observable.unsubscribe(&subscription4));
	EXPECT_TRUE(observable.unsubscribe(&subscription3));
	EXPECT_TRUE(observable.unsubscribe(&subscription2));
	EXPECT_TRUE(observable.unsubscribe(&subscription1));
}




TEST_F(ObservableTest, testObserveObservable) {

	IntAdder adder;
	sc::rx::subscription<int> sub(&adder);

	sc::rx::Observable<int> observable;
	observable.subscribe(&sub);

	EXPECT_EQ(0, adder.sum);

	observable.next(1);
	EXPECT_EQ(1, adder.sum);

	observable.next(10);
	observable.next(100);
	EXPECT_EQ(111, adder.sum);
}

TEST_F(ObservableTest, testObserveVoidObservable) {

	Counter counter;
	sc::rx::subscription<void> sub(&counter);

	sc::rx::Observable<void> observable;
	observable.subscribe(&sub);

	EXPECT_EQ(0, counter.count);

	observable.next();
	EXPECT_EQ(1, counter.count);

	observable.next();
	observable.next();
	EXPECT_EQ(3, counter.count);
}

TEST_F(ObservableTest, testSubscribeMultipleObservers) {

	IntAdder adder1;
	sc::rx::subscription<int> subscription1(&adder1);

	IntAdder adder2;
	sc::rx::subscription<int> subscription2(&adder2);

	EXPECT_EQ(0, adder1.sum);
	EXPECT_EQ(0, adder2.sum);


	sc::rx::Observable<int> observable;
	observable.subscribe(&subscription1);

	observable.next(1);
	EXPECT_EQ(1, adder1.sum);
	EXPECT_EQ(0, adder2.sum);

	observable.subscribe(&subscription2);

	observable.next(10);
	observable.next(100);
	EXPECT_EQ(111, adder1.sum);
	EXPECT_EQ(110, adder2.sum);
}

TEST_F(ObservableTest, testSubscribeObserverToTwoObservables) {

	IntAdder adder;
	sc::rx::subscription<int> subscription1(&adder);
	sc::rx::subscription<int> subscription2(&adder);

	EXPECT_EQ(0, adder.sum);

	sc::rx::Observable<int> observable1;
	observable1.subscribe(&subscription1);

	sc::rx::Observable<int> observable2;
	observable2.subscribe(&subscription2);

	observable1.next(1);
	EXPECT_EQ(1, adder.sum);

	observable2.next(10);
	observable1.next(1);
	EXPECT_EQ(12, adder.sum);
}

TEST_F(ObservableTest, testMultipleSubscriptionsOfObserver) {

	IntAdder adder;
	sc::rx::subscription<int> subscription1(&adder);
	sc::rx::subscription<int> subscription2(&adder);

	EXPECT_EQ(0, adder.sum);

	sc::rx::Observable<int> observable;
	observable.subscribe(&subscription1);
	observable.subscribe(&subscription2);

	observable.next(1);
	EXPECT_EQ(2, adder.sum);

	observable.next(10);
	observable.next(100);
	EXPECT_EQ(222, adder.sum);
}


TEST_F(ObservableTest, testSingleSubsrciptionObserver) {

	class Adder : public sc::rx::SingleSubscriptionObserver<int> {
	public:
		int sum = 0;
		virtual void next(int i) {
			sum += i;
		}
	};

	Adder adder;

	EXPECT_EQ(0, adder.sum);

	sc::rx::Observable<int> observable;
	adder.subscribe(&observable);

	observable.next(1);
	EXPECT_EQ(1, adder.sum);

	observable.next(10);
	observable.next(100);
	observable.next(1000);
	EXPECT_EQ(1111, adder.sum);

	adder.unsubscribe(&observable);
	observable.next(10000);
	EXPECT_EQ(1111, adder.sum);

}


}
