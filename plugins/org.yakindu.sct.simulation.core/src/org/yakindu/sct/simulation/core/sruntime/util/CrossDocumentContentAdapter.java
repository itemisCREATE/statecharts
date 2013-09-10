package org.yakindu.sct.simulation.core.sruntime.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EContentsEList;

public class CrossDocumentContentAdapter extends EContentAdapter {
	public CrossDocumentContentAdapter() {
		super();
	}

	/**
	 * By default, all cross document references are followed. Usually this is
	 * not a great idea so this class can be subclassed to customize.
	 * 
	 * @param feature
	 *            a cross document reference
	 * @return whether the adapter should follow it
	 */
	protected boolean shouldAdapt(EStructuralFeature feature) {
		return true;
	}

	@Override
	protected void setTarget(EObject target) {
		super.setTarget(target);
		for (EContentsEList.FeatureIterator<EObject> featureIterator = (EContentsEList.FeatureIterator<EObject>) target
				.eCrossReferences().iterator(); featureIterator.hasNext();) {
			Notifier notifier = featureIterator.next();
			EStructuralFeature feature = featureIterator.feature();
			if (shouldAdapt(feature)) {
				addAdapter(notifier);
			}
		}
	}

	@Override
	protected void unsetTarget(EObject target) {
		super.unsetTarget(target);
		for (EContentsEList.FeatureIterator<EObject> featureIterator = (EContentsEList.FeatureIterator<EObject>) target
				.eCrossReferences().iterator(); featureIterator.hasNext();) {
			Notifier notifier = featureIterator.next();
			EStructuralFeature feature = featureIterator.feature();
			if (shouldAdapt(feature)) {
				removeAdapter(notifier);
			}
		}
	}

	@Override
	protected void selfAdapt(Notification notification) {
		super.selfAdapt(notification);
		if (notification.getNotifier() instanceof EObject) {
			Object feature = notification.getFeature();
			if (feature instanceof EReference) {
				EReference eReference = (EReference) feature;
				if (!eReference.isContainment() && shouldAdapt(eReference)) {
					handleContainment(notification);
				}
			}
		}
	}

}