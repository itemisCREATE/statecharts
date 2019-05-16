package org.yakindu.sct.model.sequencer.util;

import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.EVENT_DRIVEN_ANNOTATION;
import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.CYCLE_BASED_ANNOTATION;

public interface SequencerAnnotationConstants {
	public static final String EVENT_DRIVEN = EVENT_DRIVEN_ANNOTATION;
	public static final String CYCLE_BASED = CYCLE_BASED_ANNOTATION;
	
	/** Annotation to mark events as being the trigger, that is, calling the runCycle / rtc */
	public static final String TRIGGER = "Trigger";
	
	/** Mark events to be put into a queue on raise instead of being put to "true" etc directly */
	public static final String QUEUED = "Queued";
}
