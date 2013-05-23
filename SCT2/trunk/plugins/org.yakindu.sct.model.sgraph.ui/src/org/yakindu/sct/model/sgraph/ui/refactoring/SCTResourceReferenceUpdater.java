package org.yakindu.sct.model.sgraph.ui.refactoring;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.AbstractReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.impl.EmfResourceChangeUtil;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * A state chart reference updater for referrences to Xtext elements.
 * The refactoring relies on serialization capabilities of the resource. 
 * 
 * @author Schwertfeger
 */
@SuppressWarnings("restriction")
public class SCTResourceReferenceUpdater extends AbstractReferenceUpdater {

	@Inject
	private EmfResourceChangeUtil changeUtil;

	@Override
	protected void createReferenceUpdates(
			ElementRenameArguments elementRenameArguments,
			Multimap<URI, IReferenceDescription> resource2references,
			ResourceSet resourceSet, IRefactoringUpdateAcceptor updateAcceptor,
			IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor,
				"Updating EMF References", resource2references.keySet().size());
		for (URI referringResourceURI : resource2references.keySet()) {
			try {
				if (progress.isCanceled())
					break;
				Resource referringResource = resourceSet.getResource(
						referringResourceURI, false);
				if (referringResource instanceof AbstractSCTResource) {
					AbstractSCTResource sctResource = (AbstractSCTResource) referringResource;
					URI newElementURI = elementRenameArguments
							.getNewElementURI(elementRenameArguments
									.getTargetElementURI());
					EObject refactoredElement = resourceSet.getEObject(
							newElementURI, true);
					if (refactoredElement != null
							&& refactoredElement instanceof EObject) {
						for (IReferenceDescription reference : resource2references
								.get(referringResourceURI)) {
							try {
								sctResource.setSerializerEnabled(true);
								updateReference(referringResource,
										refactoredElement, reference,
										updateAcceptor.getRefactoringStatus());
							} finally {
								sctResource.setSerializerEnabled(false);
							}
						}
					}
				}
				changeUtil.addSaveAsUpdate(referringResource, updateAcceptor);
				progress.worked(1);
			} catch (Exception exc) {
				throw new WrappedException(exc);
			}
		}
	}

	protected void updateReference(Resource referringResource,
			EObject refactoredElement,
			IReferenceDescription referenceDescription,
			StatusWrapper statusWrapper) {

		EObject oldSourceEObject = referringResource
				.getEObject(referenceDescription.getSourceEObjectUri()
						.fragment());
		EReference eReference = referenceDescription.getEReference();
		if (eReference.isMany()) {
			updateReferenceMulti(oldSourceEObject, eReference,
					referenceDescription.getIndexInList(), statusWrapper);
		} else {
			updateReferenceSingle(oldSourceEObject, eReference, statusWrapper);
		}
	}

	protected void updateReferenceMulti(EObject container, EReference eReference,
			int indexInList, StatusWrapper statusWrapper) {
		@SuppressWarnings("unchecked")
		// Unchecked is ok, because we checked the instance before
		List<Object> object = (List<Object>) eReference.eGet(eReference);
		Object value = object.remove(indexInList);
		object.set(indexInList, value);
	}

	protected void updateReferenceSingle(EObject container, EReference reference,
			StatusWrapper statusWrapper) {
		Object value = container.eGet(reference);
		container.eSet(reference, value);
	}

}
