package org.yakindu.sct.generator.java.test.ineventqueue;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.yakindu.sct.generator.java.test.ieq.EventDrivenInternalEvent;
import org.yakindu.sct.generator.java.test.ieq.EventDrivenOutEvents;
import org.yakindu.sct.generator.java.test.ieq.EventDrivenTriggeredByEvent;
import org.yakindu.sct.generator.java.test.ieq.EventDrivenTriggeredByTimeEvent;
import org.yakindu.sct.generator.java.test.ieq.LocalEvents;

@RunWith(Suite.class)
@SuiteClasses({
	EventDrivenInternalEvent.class,
	EventDrivenTriggeredByEvent.class,
	EventDrivenTriggeredByTimeEvent.class,
	EventDrivenOutEvents.class,
	LocalEvents.class,
	})
public class AllTests {
}
