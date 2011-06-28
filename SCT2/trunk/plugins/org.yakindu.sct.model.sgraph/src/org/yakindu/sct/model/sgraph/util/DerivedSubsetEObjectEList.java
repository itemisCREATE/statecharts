package org.yakindu.sct.model.sgraph.util;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * A modifiable derived list whose values are obtained from a single multivalued
 * source feature. This list is ideal for implementing derived subset features.
 * 
 * @since .
 */
public class DerivedSubsetEObjectEList<E> extends DerivedEObjectEList<E> {

	protected class DerivedSubsetListIterator extends DerivedListIterator {

		protected int expectedModCount = modCount;

		@Override
		public void remove() {
			checkModCount();

			if (valuesIterator == null) {
				throw new IllegalStateException();
			}

			switch (prepared) {
			case 3:
			case 1:
				preparePrevious();
				break;
			case -1:
			case -3:
				prepareNext();
				break;
			}

			prepared = 0;

			valuesIterator.remove();

			modCount++;
			expectedModCount++;
		}

		@Override
		public void set(Object element) {
			checkModCount();

			if (valuesIterator == null) {
				throw new IllegalStateException();
			}

			switch (prepared) {
			case 3:
			case 1:
				preparePrevious();
				break;
			case -1:
			case -3:
				prepareNext();
				break;
			}

			prepared = 0;

			valuesIterator.set(element);

			modCount++;
			expectedModCount++;
		}

		@Override
		public void add(Object element) {
			checkModCount();

			if (valuesIterator == null) {
				@SuppressWarnings("unchecked")
				List<Object> valuesList = resolve() ? (List<Object>) owner
						.eGet(sourceFeatureIDs[featureIndex], resolve(), true)
						: ((InternalEList<Object>) owner
								.eGet(sourceFeatureIDs[featureIndex],
										resolve(), true)).basicList();

				valuesList.listIterator(valuesList.size()).add(element);
			} else {

				switch (prepared) {
				case 3:
					preparePrevious();
					break;
				case -3:
					prepareNext();
					break;
				}

				valuesIterator.add(element);
			}

			prepared = 0;

			modCount++;
			expectedModCount++;

			index++;
		}

		protected void checkModCount() {

			if (modCount != expectedModCount) {
				throw new ConcurrentModificationException();
			}
		}
	}

	protected class ResolvingDerivedSubsetListIterator extends
			DerivedSubsetListIterator {

		@Override
		protected boolean resolve() {
			return true;
		}

	}

	protected class EmptyDerivedSubsetListIterator extends
			EmptyDerivedListIterator {

		@Override
		public void remove() {
			throw new IllegalStateException();
		}

		@Override
		public void set(Object element) {
			throw new IllegalStateException();
		}

		@Override
		public void add(Object element) {
			throw new IllegalStateException();
		}

	}

	public DerivedSubsetEObjectEList(Class<?> dataClass, InternalEObject owner,
			int featureID, int[] sourceFeatureIDs) {
		super(dataClass, owner, featureID, sourceFeatureIDs);

		EStructuralFeature feature = sourceFeatureIDs.length == 1 ? getEStructuralFeature(sourceFeatureIDs[0])
				: null;

		if (feature == null || !feature.isMany()
				|| FeatureMapUtil.isFeatureMap(feature)) {

			throw new IllegalArgumentException(String.valueOf(sourceFeatureIDs));
		}
	}

	public DerivedSubsetEObjectEList(Class<?> dataClass, InternalEObject owner,
			int featureID, int sourceFeatureID) {
		this(dataClass, owner, featureID, new int[] { sourceFeatureID });
	}

	@Override
	public List<E> basicList() {

		return new DerivedSubsetEObjectEList<E>(dataClass, owner, featureID,
				sourceFeatureIDs) {

			@Override
			public ListIterator<E> listIterator(int index) {
				return basicListIterator(index);
			}
		};
	}

	@Override
	protected ListIterator<E> newListIterator() {
		return new DerivedSubsetListIterator();
	}

	@Override
	protected ListIterator<E> newResolvingListIterator() {
		return new ResolvingDerivedSubsetListIterator();
	}

	@Override
	protected ListIterator<E> newEmptyListIterator() {
		return new EmptyDerivedSubsetListIterator();
	}

	@Override
	protected boolean isNotificationRequired() {
		return owner.eNotificationRequired();
	}

}
