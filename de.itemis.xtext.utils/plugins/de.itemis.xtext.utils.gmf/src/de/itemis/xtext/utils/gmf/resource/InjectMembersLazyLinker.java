package de.itemis.xtext.utils.gmf.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.impl.Linker;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;

/**
 * 
 * Customized implementation of the Xtext {@link Linker} that ensures that only
 * crossreferences which are described by Xtext are cleared. If the default
 * linker is used all crossreferences of the whole model are checked.
 * 
 * @author andreas muelder
 * 
 */
public class InjectMembersLazyLinker extends Linker {

	@Override
	protected void clearReference(EObject obj, EReference ref) {
		// If the CompositeNodeWithSemanticElement adapter exists, we know that
		// this is an Xtext model element.
		if (EcoreUtil.getAdapter(obj.eAdapters(),
				CompositeNodeWithSemanticElement.class) != null) {
			super.clearReference(obj, ref);
		}
	}
}
