package org.yakindu.sct.generator.cpp.providers;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)
public @interface GeneratorContribution {
	/** The target of the annotation - e.g. "Header" or "Implementation" */
	String value();
}
