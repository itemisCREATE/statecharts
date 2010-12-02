package org.yakindu.sct.statechart.diagram.validation.provider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.statechart.diagram.validation.IValidationProvider;
import org.yakindu.sct.statechart.diagram.validation.ValidationActivator;

import com.google.common.collect.Sets;
import com.google.inject.internal.Lists;

/**
 * 
 * @author muelder
 * 
 */
public abstract class AbstractJavaValidationProvider implements
		IValidationProvider {

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface ValidationRule {
	}

	private Map<Class<?>, List<Method>> validationRuleMap;

	public AbstractJavaValidationProvider() {
		validationRuleMap = new HashMap<Class<?>, List<Method>>();
		initFeatureMap();
	}

	private void initFeatureMap() {
		Method[] methods = getClass().getMethods();
		for (Method method : methods) {
			ValidationRule annotation = method
					.getAnnotation(ValidationRule.class);
			if (annotation != null && method.getParameterTypes().length == 1) {
				Class<?> key = method.getParameterTypes()[0];
				if (validationRuleMap.containsKey(key)) {
					validationRuleMap.get(key).add(method);
				} else {
					validationRuleMap.put(key, Lists.newArrayList(method));
				}
			}
		}
	}

	@Override
	public final boolean isProviderFor(EObject semanticElement) {
		return getValidationsForClass(semanticElement.getClass()).size() > 0;
	}

	private List<Method> getValidationsForClass(Class<?> clazz) {
		List<Method> validationMethods = new ArrayList<Method>();
		Set<Class<?>> keys = validationRuleMap.keySet();
		for (Class<?> key : keys) {
			if (key.isAssignableFrom(clazz)) {
				validationMethods.addAll(validationRuleMap.get(key));
			}
		}
		return validationMethods;
	}

	@Override
	public final Set<IStatus> validate(EObject semanticElement) {
		Set<IStatus> status = Sets.newHashSet();
		List<Method> validationMethods = getValidationsForClass(semanticElement
				.getClass());
		for (Method method : validationMethods) {
			try {
				Object result = method.invoke(this, semanticElement);
				Assert.isTrue(result instanceof IStatus);
				status.add((IStatus) result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	protected IStatus createErrorStatus(String message) {
		IStatus status = new Status(IStatus.ERROR,
				ValidationActivator.PLUGIN_ID, message);
		return status;
	}

	protected IStatus createOKStatus() {
		return Status.OK_STATUS;
	}

	protected IStatus createWarningStatus(String message) {
		IStatus status = new Status(IStatus.WARNING,
				ValidationActivator.PLUGIN_ID, message);
		return status;
	}
}
