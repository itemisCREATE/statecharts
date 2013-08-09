/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.compare.match.MatchEngine;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;

import com.google.common.base.Predicate;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTMatchEngineFactory implements IMatchEngine.Factory {

	private int ranking = 0;

	@Override
	public IMatchEngine getMatchEngine() {
		final IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		final IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.WHEN_AVAILABLE);
		return new SCTMatchEngine(matcher, comparisonFactory);
	}

	@Override
	public int getRanking() {
		return ranking;
	}

	@Override
	public void setRanking(int parseInt) {
		ranking = parseInt;
	}

	@Override
	public boolean isMatchEngineFactoryFor(IComparisonScope scope) {
		return true;
	}

	public static class SCTMatchEngine extends DefaultMatchEngine {

		public SCTMatchEngine(IEObjectMatcher matcher, IComparisonFactory comparisonFactory) {
			super(matcher, comparisonFactory);
		}

		@Override
		public Comparison match(IComparisonScope scope, Monitor monitor) {
			Predicate<EObject> predicate = new Predicate<EObject>() {
				@Override
				public boolean apply(EObject eobject) {
					// We only want to diff the SGraph and notation elements,
					// not the transient palceholders for concrete languages
					EPackage ePackage = eobject.eClass().getEPackage();
					return ePackage == SGraphPackage.eINSTANCE || ePackage == NotationPackage.eINSTANCE;
				}
			};
			if (scope instanceof DefaultComparisonScope) {
				DefaultComparisonScope defaultScope = (DefaultComparisonScope) scope;
				defaultScope.setEObjectContentFilter(predicate);
				defaultScope.setResourceContentFilter(predicate);
			}
			return super.match(scope, monitor);
		}
	}

}
