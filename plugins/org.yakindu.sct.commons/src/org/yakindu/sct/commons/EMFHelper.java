package org.yakindu.sct.commons;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

public class EMFHelper {
	public static List<EClass> getAllSuperClasses(EClass eClass) {
		List<List<EClass>> superClasses = new ArrayList<>();

		getSuperClassTree(superClasses, eClass, 0);

		List<EClass> result = new ArrayList<>();
		for (List<EClass> list : superClasses) {
			result.addAll(list);
		}

		return result;
	}

	protected static void getSuperClassTree(List<List<EClass>> superClasses, EClass eClass, int depth) {
		if (superClasses.size() <= depth) {
			superClasses.add(depth, new ArrayList<>());
		}

		List<EClass> superTypes = eClass.getESuperTypes();

		superClasses.get(depth).add(eClass);

		for (EClass superType : superTypes) {
			getSuperClassTree(superClasses, superType, depth + 1);
		}
	}
}
