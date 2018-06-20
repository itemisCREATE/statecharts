package org.yakindu.sct.model.stext.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.util.ContextElementAdapter;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;

public class STextUtils {
	public SpecificationElement getContextElement(EObject context) {
		final ContextElementAdapter provider = (ContextElementAdapter) EcoreUtil.getExistingAdapter(context.eResource(),
				ContextElementAdapter.class);

		if (provider == null) {
			return EcoreUtil2.getContainerOfType(context, SpecificationElement.class);
		} else {
			return (SpecificationElement) provider.getElement();
		}
	}
	
	public ScopedElement getScopedElement(EObject context) {
		ScopedElement scopedElement = EcoreUtil2.getContainerOfType(context, ScopedElement.class);
		if (EcoreUtil.getRootContainer(context) instanceof StatechartSpecification && scopedElement != null)
			return scopedElement;
		return getStatechart(context);
	}

	public Statechart getStatechart(EObject context) {
		final ContextElementAdapter provider = (ContextElementAdapter) EcoreUtil.getExistingAdapter(context.eResource(),
				ContextElementAdapter.class);

		if (provider == null) {
			return EcoreUtil2.getContainerOfType(context, Statechart.class);
		} else {
			return (Statechart) EcoreUtil.getObjectByType(provider.getElement().eResource().getContents(),
					SGraphPackage.Literals.STATECHART);
		}
	}
}
