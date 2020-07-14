/*
 * ObservableTest.cpp
 *
 *  Created on: 03.06.2020
 *      Author: aterfloth
 */


#include <string>
#include "gtest/gtest.h"
#include "sc_rxc.h"

extern "C" {


declare_sc_reactive_extensions(int)
define_sc_reactive_extensions(int)

}

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


typedef struct IntAdder {
	sc_observer_int observer;
	int sum;
} IntAdder;

void IntAdder_next(IntAdder *self, int value) {
	self->sum += value;
}

void IntAdder_init(IntAdder *self) {
	sc_observer_int_init(&(self->observer), self, (sc_observer_next_int_fp) IntAdder_next);
	self->sum = 0;
}



typedef struct Counter {
	sc_observer observer;
	int count;
} Counter;

void Counter_next(Counter *self) {
	self->count++;
}

void Counter_init(Counter *self) {
	sc_observer_init(&(self->observer), self, (sc_observer_next_fp)Counter_next);
	self->count = 0;
}


TEST_F(ObservableTest, testObserver)
{

	IntAdder adder;
	IntAdder_init(&adder);

	sc_observer_int_next(&(adder.observer), 1);
	sc_observer_int_next(&(adder.observer), 2);
	sc_observer_int_next(&(adder.observer), 3);

	EXPECT_EQ(adder.sum, 6);
}

TEST_F(ObservableTest, testVoidObserver)
{

	Counter counter;
	Counter_init(&counter);

	sc_observer_next(&(counter.observer));
	sc_observer_next(&(counter.observer));
	sc_observer_next(&(counter.observer));
	sc_observer_next(&(counter.observer));

	EXPECT_EQ(counter.count, 4);
}


TEST_F(ObservableTest, testCreateSubscription) {

	IntAdder adder;
	IntAdder_init(&adder);

	sc_subscription_int adder_subscription;
	sc_subscription_int_init(&adder_subscription, &(adder.observer));

	EXPECT_EQ(&(adder.observer), adder_subscription.observer);
}


TEST_F(ObservableTest, testSubscribeNullSubscription) {

	sc_observable observable;
	EXPECT_FALSE(sc_observable_subscribe(&observable, sc_null));
}


TEST_F(ObservableTest, testSubscribeWithNullObserver) {

	sc_subscription sub;
	sc_subscription_init(&sub, sc_null);
	sc_observable observable;
	sc_observable_init(&observable);

	EXPECT_FALSE(sc_observable_subscribe(&observable, &sub));
}


TEST_F(ObservableTest, testSubscribe) {
	IntAdder adder;
	IntAdder_init(&adder);
	sc_subscription_int sub;
	sc_subscription_int_init(&sub, &(adder.observer));
	sc_observable_int observable;
	sc_observable_int_init(&observable);

	EXPECT_TRUE(sc_observable_subscribe(&observable,&sub));
	EXPECT_EQ(sub.next, &sub);
}


TEST_F(ObservableTest, testMultipleSubscribeOnObservable) {
	IntAdder adder;
	IntAdder_init(&adder);
	sc_subscription_int sub1;
	sc_subscription_int_init(&sub1, &(adder.observer));
	sc_subscription_int sub2;
	sc_subscription_int_init(&sub2, &(adder.observer));
	sc_subscription_int sub3;
	sc_subscription_int_init(&sub3, &(adder.observer));
	sc_subscription_int sub4;
	sc_subscription_int_init(&sub4, &(adder.observer));

	sc_observable_int observable;
	sc_observable_int_init(&observable);

	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub1));
	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub2));
	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub3));
	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub4));

	EXPECT_EQ(sub1.next, &sub1);
	EXPECT_EQ(sub2.next, &sub1);
	EXPECT_EQ(sub3.next, &sub2);
	EXPECT_EQ(sub4.next, &sub3);
}


TEST_F(ObservableTest, testSubscribeSubscribedSubscription) {
	IntAdder adder;
	sc_subscription_int sub1;
	sc_subscription_int_init(&sub1, &(adder.observer));
	sc_subscription_int sub2;
	sc_subscription_int_init(&sub2, &(adder.observer));
	sc_observable_int observable;
	sc_observable_int_init(&observable);

	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub1));
	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub2));

	EXPECT_FALSE(sc_observable_int_subscribe(&observable,&sub1));
	EXPECT_FALSE(sc_observable_int_subscribe(&observable,&sub2));
}


TEST_F(ObservableTest, testUnsubscribeNullSubscription)
{
	sc_observable observable;
	sc_observable_init(&observable);

	EXPECT_FALSE(sc_observable_unsubscribe(&observable, sc_null));
}


TEST_F(ObservableTest, testUnsubscribeFromUnsubscribed)
{
	sc_subscription sub;
	sc_subscription_init(&sub, sc_null);
	sc_observable observable;
	sc_observable_init(&observable);

	EXPECT_FALSE(sc_observable_unsubscribe(&observable, &sub));
}


TEST_F(ObservableTest, testUnsubscribe)
{

	IntAdder adder;
	IntAdder_init(&adder);
	sc_subscription_int sub;
	sc_subscription_int_init(&sub, &(adder.observer));
	sc_observable_int observable;
	sc_observable_int_init(&observable);

	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub));
	EXPECT_TRUE(sc_observable_int_unsubscribe(&observable,&sub));
}


TEST_F(ObservableTest, testUnsubscribeUnsubscribed)
{
	IntAdder adder;
	IntAdder_init(&adder);
	sc_subscription_int sub;
	sc_subscription_int_init(&sub, &(adder.observer));
	sc_observable_int observable;
	sc_observable_int_init(&observable);

	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub));
	EXPECT_TRUE(sc_observable_int_unsubscribe(&observable,&sub));
	EXPECT_FALSE(sc_observable_int_unsubscribe(&observable,&sub));
}


TEST_F(ObservableTest, testUnsubscribeNotSubscribed)
{
	IntAdder adder;
	IntAdder_init(&adder);
	sc_subscription_int sub1;
	sc_subscription_int_init(&sub1, &(adder.observer));
	sc_subscription_int sub2;
	sc_subscription_int_init(&sub2, &(adder.observer));
	sc_subscription_int sub3;
	sc_subscription_int_init(&sub3, &(adder.observer));

	sc_observable_int observable;
	sc_observable_int_init(&observable);

	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub1));
	EXPECT_FALSE(sc_observable_int_unsubscribe(&observable,&sub3));

	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub2));
	EXPECT_FALSE(sc_observable_int_unsubscribe(&observable,&sub3));

}


TEST_F(ObservableTest, testUnsubscribeSubscriptionOfForeinObservable)
{
	IntAdder adder;
	IntAdder_init(&adder);
	sc_subscription_int sub1;
	sc_subscription_int_init(&sub1, &(adder.observer));
	sc_subscription_int sub2;
	sc_subscription_int_init(&sub2, &(adder.observer));

	sc_observable_int observable1;
	sc_observable_int_init(&observable1);
	sc_observable_int observable2;
	sc_observable_int_init(&observable2);

	EXPECT_TRUE(sc_observable_int_subscribe(&observable1,&sub1));
	EXPECT_TRUE(sc_observable_int_subscribe(&observable2,&sub2));
	EXPECT_FALSE(sc_observable_int_unsubscribe(&observable1,&sub2));
}


TEST_F(ObservableTest, testUnsubscribeMultipleSubscriptions)
{
	IntAdder adder;
	IntAdder_init(&adder);
	sc_subscription_int sub1;
	sc_subscription_int_init(&sub1, &(adder.observer));
	sc_subscription_int sub2;
	sc_subscription_int_init(&sub2, &(adder.observer));
	sc_subscription_int sub3;
	sc_subscription_int_init(&sub3, &(adder.observer));
	sc_subscription_int sub4;
	sc_subscription_int_init(&sub4, &(adder.observer));

	sc_observable_int observable;
	sc_observable_int_init(&observable);

	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub1));
	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub2));
	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub3));
	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub4));

	EXPECT_TRUE(sc_observable_int_unsubscribe(&observable,&sub1));
	EXPECT_TRUE(sc_observable_int_unsubscribe(&observable,&sub2));
	EXPECT_TRUE(sc_observable_int_unsubscribe(&observable,&sub3));
	EXPECT_TRUE(sc_observable_int_unsubscribe(&observable,&sub4));
}


TEST_F(ObservableTest, testUnsubscribeMultipleSubscriptionsReverseOrder)
{
	IntAdder adder;
	IntAdder_init(&adder);
	sc_subscription_int sub1;
	sc_subscription_int_init(&sub1, &(adder.observer));
	sc_subscription_int sub2;
	sc_subscription_int_init(&sub2, &(adder.observer));
	sc_subscription_int sub3;
	sc_subscription_int_init(&sub3, &(adder.observer));
	sc_subscription_int sub4;
	sc_subscription_int_init(&sub4, &(adder.observer));

	sc_observable_int observable;
	sc_observable_int_init(&observable);

	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub1));
	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub2));
	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub3));
	EXPECT_TRUE(sc_observable_int_subscribe(&observable,&sub4));

	EXPECT_TRUE(sc_observable_int_unsubscribe(&observable,&sub4));
	EXPECT_TRUE(sc_observable_int_unsubscribe(&observable,&sub3));
	EXPECT_TRUE(sc_observable_int_unsubscribe(&observable,&sub2));
	EXPECT_TRUE(sc_observable_int_unsubscribe(&observable,&sub1));
}


TEST_F(ObservableTest, testObserveObservable) {

	IntAdder adder;
	IntAdder_init(&adder);
	sc_subscription_int sub;
	sc_subscription_int_init(&sub, &(adder.observer));
	sc_observable_int observable;
	sc_observable_int_init(&observable);

	sc_observable_int_subscribe(&observable,&sub);

	EXPECT_EQ(0, adder.sum);

	sc_observable_int_next(&observable, 1);
	EXPECT_EQ(1, adder.sum);

	sc_observable_int_next(&observable, 10);
	sc_observable_int_next(&observable, 100);
	EXPECT_EQ(111, adder.sum);
}


TEST_F(ObservableTest, testObserveVoidObservable) {

	Counter counter;
	Counter_init(&counter);
	sc_subscription sub;
	sc_subscription_init(&sub, &(counter.observer));
	sc_observable observable;
	sc_observable_init(&observable);

	sc_observable_subscribe(&observable,&sub);

	EXPECT_EQ(0, counter.count);

	sc_observable_next(&observable);
	EXPECT_EQ(1, counter.count);

	sc_observable_next(&observable);
	sc_observable_next(&observable);
	EXPECT_EQ(3, counter.count);
}


TEST_F(ObservableTest, testSubscribeMultipleObservers) {

	IntAdder adder1;
	IntAdder_init(&adder1);
	sc_subscription_int sub1;
	sc_subscription_int_init(&sub1, &(adder1.observer));

	IntAdder adder2;
	IntAdder_init(&adder2);
	sc_subscription_int sub2;
	sc_subscription_int_init(&sub2, &(adder2.observer));

	EXPECT_EQ(0, adder1.sum);
	EXPECT_EQ(0, adder2.sum);

	sc_observable_int observable;
	sc_observable_int_init(&observable);

	sc_observable_int_subscribe(&observable,&sub1);

	sc_observable_int_next(&observable, 1);
	EXPECT_EQ(1, adder1.sum);
	EXPECT_EQ(0, adder2.sum);

	sc_observable_int_subscribe(&observable,&sub2);

	sc_observable_int_next(&observable, 10);
	sc_observable_int_next(&observable, 100);
	EXPECT_EQ(111, adder1.sum);
	EXPECT_EQ(110, adder2.sum);
}


TEST_F(ObservableTest, testSubscribeObserverToTwoObservables) {

	IntAdder adder;
	IntAdder_init(&adder);
	sc_subscription_int sub1;
	sc_subscription_int_init(&sub1, &(adder.observer));
	sc_subscription_int sub2;
	sc_subscription_int_init(&sub2, &(adder.observer));


	EXPECT_EQ(0, adder.sum);

	sc_observable_int observable1;
	sc_observable_int_init(&observable1);
	sc_observable_int_subscribe(&observable1,&sub1);

	sc_observable_int observable2;
	sc_observable_int_init(&observable2);
	sc_observable_int_subscribe(&observable2,&sub2);


	sc_observable_int_next(&observable1, 1);
	EXPECT_EQ(1, adder.sum);

	sc_observable_int_next(&observable2, 10);
	sc_observable_int_next(&observable1, 1);
	EXPECT_EQ(12, adder.sum);
}


TEST_F(ObservableTest, testMultipleSubscriptionsOfObserver) {

	IntAdder adder;
	IntAdder_init(&adder);
	sc_subscription_int sub1;
	sc_subscription_int_init(&sub1, &(adder.observer));
	sc_subscription_int sub2;
	sc_subscription_int_init(&sub2, &(adder.observer));

	EXPECT_EQ(0, adder.sum);

	sc_observable_int observable;
	sc_observable_int_init(&observable);
	sc_observable_int_subscribe(&observable,&sub1);
	sc_observable_int_subscribe(&observable,&sub2);

	sc_observable_int_next(&observable, 1);
	EXPECT_EQ(2, adder.sum);

	sc_observable_int_next(&observable, 10);
	sc_observable_int_next(&observable, 100);
	EXPECT_EQ(222, adder.sum);
}


typedef struct SingleSubAdder {
	sc_single_subscription_observer_int observer;
	int sum;
} SingleSubAdder;


void SingleSubAdder_next(SingleSubAdder *self, int value) {
	self->sum += value;
}

void SingleSubAdder_init(SingleSubAdder *self) {
	sc_single_subscription_observer_int_init(&(self->observer), self, (sc_observer_next_int_fp)SingleSubAdder_next);
	self->sum = 0;
}



typedef struct SingleSubCounter {
	sc_single_subscription_observer observer;
	int count;
} SingleSubCounter;

void SingleSubCounter_next(SingleSubCounter *self, void* value) {
	self->count++;
}

void SingleSubCounter_init(SingleSubCounter *self) {
	sc_single_subscription_observer_init(&(self->observer), self, (sc_observer_next_fp)SingleSubCounter_next);
	self->count = 0;
}


TEST_F(ObservableTest, testSingleSubsrciptionObserver) {

	SingleSubAdder observer;
	SingleSubAdder_init(&observer);


	EXPECT_EQ(0, observer.sum);

	sc_observable_int observable;
	sc_observable_int_init(&observable);
	sc_single_subscription_observer_int_subscribe(&(observer.observer),&observable);

	sc_observable_int_next(&observable, 1);
	EXPECT_EQ(1, observer.sum);

	sc_observable_int_next(&observable, 10);
	sc_observable_int_next(&observable, 100);
	sc_observable_int_next(&observable, 1000);
	EXPECT_EQ(1111, observer.sum);

	sc_single_subscription_observer_int_unsubscribe(&(observer.observer),&observable);

	sc_observable_int_next(&observable, 10000);
	EXPECT_EQ(1111, observer.sum);

}

TEST_F(ObservableTest, testSingleSubsrciptionVoidObserver) {

	SingleSubCounter observer;
	SingleSubCounter_init(&observer);

	EXPECT_EQ(0, observer.count);

	sc_observable observable;
	sc_observable_init(&observable);
	sc_single_subscription_observer_subscribe(&(observer.observer),&observable);

	sc_observable_next(&observable);
	EXPECT_EQ(1, observer.count);

	sc_observable_next(&observable);
	sc_observable_next(&observable);
	EXPECT_EQ(3, observer.count);

	sc_single_subscription_observer_unsubscribe(&(observer.observer),&observable);
	sc_observable_next(&observable);
	sc_observable_next(&observable);
	EXPECT_EQ(3, observer.count);

}


}
