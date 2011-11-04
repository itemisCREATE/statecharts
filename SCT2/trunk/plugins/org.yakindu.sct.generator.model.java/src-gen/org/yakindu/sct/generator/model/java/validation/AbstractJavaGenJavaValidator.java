package org.yakindu.sct.generator.model.java.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.yakindu.sct.generator.model.base.validation.BaseGenJavaValidator;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class, org.eclipse.xtext.validation.NamesAreUniqueValidator.class})
public class AbstractJavaGenJavaValidator extends BaseGenJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.yakindu.sct.generator.model.java.javaGen.JavaGenPackage.eINSTANCE);
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.yakindu.org/sct/statechart/SGen"));
		return result;
	}

}
