package org.eclipselabs.mscript.language.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public class AbstractMscriptJavaValidator extends AbstractDeclarativeValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipselabs.org/mscript/AST/1.0.0"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipselabs.org/mscript/TypeSystem/1.0.0"));
		return result;
	}

}
