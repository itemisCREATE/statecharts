package org.yakindu.sct.generator.java.test;

import org.junit.Test;
import org.yakindu.scr.Observable;
import org.yakindu.scr.Observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ObservablesTest {
	
	private class Counter implements Observer<Void> {

		private int count = 0;

		@Override
		public void next(Void value) {
			this.count += 1;
		}

		public int getCount() {
			return count;
		}

	}

	private class Adder implements Observer<Integer> {

		private int sum = 0;

		@Override
		public void next(Integer value) {
			this.sum += value;
		}

		public int getSum() {
			return sum;
		}

	}

	@Test
	public void testValueObserver() {
		Adder adder = new Adder();
		adder.next(1);
		adder.next(2);
		adder.next(3);
		assertEquals(6, adder.getSum());
	}

	@Test
	public void testVoidObserver() {
		Counter counter = new Counter();
		counter.next(null);
		counter.next(null);
		counter.next(null);
		counter.next(null);
		assertEquals(4, counter.getCount());
	}

	@Test
	public void testSubscribeNullObserver() {
		Observable<Void> observable = new Observable<>();
		assertFalse(observable.subscribe(null));
	}

	@Test
	public void testSubscribe() {
		Adder adder = new Adder();
		Observable<Integer> observable = new Observable<>();
		assertTrue(observable.subscribe(adder));
	}

	@Test
	public void testMultipleSubscribe() {
		Adder adder = new Adder();
		Observable<Integer> observable = new Observable<>();
		assertTrue(observable.subscribe(adder));
		assertTrue(observable.subscribe(adder));
		assertTrue(observable.subscribe(adder));
		assertTrue(observable.subscribe(adder));
	}

	@Test
	public void testUnsubscribeNullObserver() {
		Observable<Void> observable = new Observable<>();
		assertFalse(observable.unsubscribe(null));
	}

	@Test
	public void testUnsubscribe() {
		Adder adder = new Adder();
		Observable<Integer> observable = new Observable<>();
		assertTrue(observable.subscribe(adder));
		assertTrue(observable.unsubscribe(adder));
		assertFalse(observable.unsubscribe(adder));
	}

	@Test
	public void testUnsubscribeFromForeignObservable() {
		Adder adder = new Adder();
		Observable<Integer> observable1 = new Observable<>();
		Observable<Integer> observable2 = new Observable<>();
		assertTrue(observable1.subscribe(adder));
		assertFalse(observable2.unsubscribe(adder));
	}

	@Test
	public void testUnsubscribeMultipleObservers() {
		Adder adder = new Adder();
		Observable<Integer> observable = new Observable<>();

		assertTrue(observable.subscribe(adder));
		assertTrue(observable.subscribe(adder));
		assertTrue(observable.subscribe(adder));
		assertTrue(observable.subscribe(adder));

		assertTrue(observable.unsubscribe(adder));
		assertTrue(observable.unsubscribe(adder));
		assertTrue(observable.unsubscribe(adder));
		assertTrue(observable.unsubscribe(adder));
	}

	@Test
	public void testObserveValueObservable() {
		Adder adder = new Adder();
		Observable<Integer> observable = new Observable<>();
		observable.subscribe(adder);
		assertEquals(0, adder.getSum());

		observable.next(1);
		assertEquals(1, adder.getSum());
		observable.next(10);
		observable.next(100);
		assertEquals(111, adder.getSum());
	}

	@Test
	public void testObserveVoidObservable() {
		Counter counter = new Counter();
		Observable<Void> observable = new Observable<>();
		observable.subscribe(counter);
		assertEquals(0, counter.getCount());

		observable.next(null);
		assertEquals(1, counter.getCount());

		observable.next(null);
		observable.next(null);
		assertEquals(3, counter.getCount());
	}

	@Test
	public void testSubscribeMultipleObservers() {
		Adder adder1 = new Adder();
		Adder adder2 = new Adder();
		Observable<Integer> observable = new Observable<>();
		observable.subscribe(adder1);

		observable.next(1);
		assertEquals(1, adder1.getSum());
		assertEquals(0, adder2.getSum());

		observable.subscribe(adder2);
		observable.next(10);
		observable.next(100);
		assertEquals(111, adder1.getSum());
		assertEquals(110, adder2.getSum());
	}

	@Test
	public void testSubscribeObserverToTwoObservables() {
		Adder adder = new Adder();
		Observable<Integer> observable1 = new Observable<>();
		observable1.subscribe(adder);
		Observable<Integer> observable2 = new Observable<>();
		observable2.subscribe(adder);

		observable1.next(1);
		assertEquals(1, adder.getSum());

		observable2.next(10);
		observable1.next(1);
		assertEquals(12, adder.getSum());
	}

	@Test
	public void testMultipleSubscriptionsOfObserver() {
		Adder adder = new Adder();
		Observable<Integer> observable = new Observable<>();
		observable.subscribe(adder);
		observable.subscribe(adder);

		observable.next(1);
		assertEquals(2, adder.getSum());

		observable.next(10);
		observable.next(100);
		assertEquals(222, adder.getSum());
	}

	@Test
	public void testSubscribeMultipleObserver() {
		Adder adder1 = new Adder();
		Adder adder2 = new Adder();
		Observable<Integer> observable = new Observable<>();

		assertTrue(observable.subscribe(adder1));
		assertTrue(observable.subscribe(adder2));
	}

	@Test
	public void testUnsubscribeMultipleObserver() {
		Adder adder1 = new Adder();
		Adder adder2 = new Adder();
		Observable<Integer> observable = new Observable<>();
		observable.subscribe(adder1);
		observable.subscribe(adder2);

		assertTrue(observable.unsubscribe(adder1));
		assertTrue(observable.unsubscribe(adder2));
	}

	@Test
	public void testSubscribeMultipleObserverOnMultipleObservables() {
		Adder adder1 = new Adder();
		Adder adder2 = new Adder();
		Observable<Integer> observable1 = new Observable<>();
		Observable<Integer> observable2 = new Observable<>();

		assertTrue(observable1.subscribe(adder1));
		assertTrue(observable1.subscribe(adder2));
		assertTrue(observable2.subscribe(adder1));
		assertTrue(observable2.subscribe(adder2));
	}

	@Test
	public void testUnsubscribeMultipleObserverFromMultipleObservables() {
		Adder adder1 = new Adder();
		Adder adder2 = new Adder();
		Observable<Integer> observable1 = new Observable<>();
		Observable<Integer> observable2 = new Observable<>();
		observable1.subscribe(adder1);
		observable1.subscribe(adder2);
		observable2.subscribe(adder1);
		observable2.subscribe(adder2);

		assertTrue(observable1.unsubscribe(adder1));
		assertTrue(observable1.unsubscribe(adder2));
		assertTrue(observable2.unsubscribe(adder1));
		assertTrue(observable2.unsubscribe(adder2));
	}
}
