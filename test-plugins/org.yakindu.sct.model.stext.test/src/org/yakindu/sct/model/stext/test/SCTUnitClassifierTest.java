/**
 * Copyright (c) 2014 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;
import org.yakindu.sct.test.models.SCTUnitTestModels;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class SCTUnitClassifierTest {

	@Inject
	SCTUnitTestModels testModels;

	private static final Set<EClass> IGNORE_ME = ImmutableSet.of(SGraphPackage.Literals.STATECHART,
			StextPackage.Literals.ROOT, StextPackage.Literals.STATE_SPECIFICATION,
			StextPackage.Literals.STATECHART_ROOT, StextPackage.Literals.STATECHART_SPECIFICATION,
			StextPackage.Literals.TRANSITION_SPECIFICATION, StextPackage.Literals.DEF_ROOT,
			StextPackage.Literals.STATE_ROOT, StextPackage.Literals.STATE_ROOT, StextPackage.Literals.TRANSITION_ROOT,
			StextPackage.Literals.BUILTIN_EVENT_SPEC, StextPackage.Literals.EVENT_SPEC, StextPackage.Literals.IMPORT,
			StextPackage.Literals.IMPORT_SCOPE, StextPackage.Literals.STATECHART_SCOPE,
			StextPackage.Literals.TRANSITION_REACTION, SGraphPackage.Literals.IMPORT,
			SGraphPackage.Literals.IMPORT_DECLARATION, SGraphPackage.Literals.SCOPE,
			SGraphPackage.Literals.REACTION_PROPERTY);

	@Test
	public void checkEClassesCoveredByTestModels() throws Exception {
		Set<EClassifier> classifier = new HashSet<EClassifier>();
		Iterables.addAll(classifier, SGraphPackage.eINSTANCE.getEClassifiers());
		Iterables.addAll(classifier, StextPackage.eINSTANCE.getEClassifiers());
		Iterables.addAll(classifier, ExpressionsPackage.eINSTANCE.getEClassifiers());
		classifier = Sets.newHashSet(Iterables.filter(classifier, new Predicate<EClassifier>() {
			public boolean apply(EClassifier clazz) {
				if (clazz instanceof EClass) {
					return !((EClass) clazz).isAbstract();
				}
				return false;
			}
		}));

		// Remove classes to ignore
		for (EClassifier eClassifier : IGNORE_ME) {
			classifier.remove(eClassifier);
		}
		// Remove all classes used within SCTUnit tests
		List<Statechart> allStatecharts = testModels.loadAllStatecharts();
		for (Statechart statechart : allStatecharts) {
			TreeIterator<EObject> eAllContents = statechart.eAllContents();
			while (eAllContents.hasNext()) {
				EClass eClass = eAllContents.next().eClass();
				if (classifier.contains(eClass)) {
					classifier.remove(eClass);
				}
			}
		}
		for (EClassifier current : classifier) {
			System.out.println(current.getInstanceTypeName());
		}
		org.junit.Assert.assertTrue("Classifiers not covered by SCTUnit Tests: " + classifier, classifier.size() == 0);

	}
}
