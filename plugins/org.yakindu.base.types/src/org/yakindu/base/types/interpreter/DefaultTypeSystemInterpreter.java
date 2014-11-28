package org.yakindu.base.types.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.typesystem.DefaultTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.inject.Inject;

public class DefaultTypeSystemInterpreter extends AbstractTypeSystemInterpreter {

	@Inject
	private ITypeSystem typeSystem;

	@Override
	public Object interpret(EObject object) {
		throw new IllegalArgumentException("not yet implemented");
	}

	@Override
	public Object defaultValue(Type type) {
		if (typeSystem.isSame(type, typeSystem.getType(DefaultTypeSystem.INTEGER))) {
			return 0L;
		}
		if (typeSystem.isSame(type, typeSystem.getType(DefaultTypeSystem.REAL))) {
			return 0.0D;
		}
		if (typeSystem.isSame(type, typeSystem.getType(DefaultTypeSystem.BOOLEAN))) {
			return false;
		}
		if (typeSystem.isSame(type, typeSystem.getType(DefaultTypeSystem.STRING))) {
			return "";
		}
		throw new IllegalArgumentException("not yet implemented");
	}

}
