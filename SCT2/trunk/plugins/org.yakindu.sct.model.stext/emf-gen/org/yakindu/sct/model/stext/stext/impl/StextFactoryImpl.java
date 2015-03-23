/**
 */
package org.yakindu.sct.model.stext.stext.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression;
import org.yakindu.sct.model.stext.stext.AlwaysEvent;
import org.yakindu.sct.model.stext.stext.BuiltinEventSpec;
import org.yakindu.sct.model.stext.stext.DefRoot;
import org.yakindu.sct.model.stext.stext.DefaultTrigger;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.EntryEvent;
import org.yakindu.sct.model.stext.stext.EntryPointSpec;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.ExitEvent;
import org.yakindu.sct.model.stext.stext.ExitPointSpec;
import org.yakindu.sct.model.stext.stext.Guard;
import org.yakindu.sct.model.stext.stext.Import;
import org.yakindu.sct.model.stext.stext.ImportScope;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.Root;
import org.yakindu.sct.model.stext.stext.SimpleScope;
import org.yakindu.sct.model.stext.stext.StateRoot;
import org.yakindu.sct.model.stext.stext.StateSpecification;
import org.yakindu.sct.model.stext.stext.StatechartRoot;
import org.yakindu.sct.model.stext.stext.StatechartScope;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.TimeEventType;
import org.yakindu.sct.model.stext.stext.TimeUnit;
import org.yakindu.sct.model.stext.stext.TransitionReaction;
import org.yakindu.sct.model.stext.stext.TransitionRoot;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;
import org.yakindu.sct.model.stext.stext.TypeAliasDefinition;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StextFactoryImpl extends EFactoryImpl implements StextFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StextFactory init() {
		try {
			StextFactory theStextFactory = (StextFactory)EPackage.Registry.INSTANCE.getEFactory(StextPackage.eNS_URI);
			if (theStextFactory != null) {
				return theStextFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StextFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StextFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StextPackage.ROOT: return createRoot();
			case StextPackage.DEF_ROOT: return createDefRoot();
			case StextPackage.STATECHART_ROOT: return createStatechartRoot();
			case StextPackage.STATE_ROOT: return createStateRoot();
			case StextPackage.TRANSITION_ROOT: return createTransitionRoot();
			case StextPackage.STATECHART_SPECIFICATION: return createStatechartSpecification();
			case StextPackage.STATE_SPECIFICATION: return createStateSpecification();
			case StextPackage.TRANSITION_SPECIFICATION: return createTransitionSpecification();
			case StextPackage.STATECHART_SCOPE: return createStatechartScope();
			case StextPackage.INTERFACE_SCOPE: return createInterfaceScope();
			case StextPackage.INTERNAL_SCOPE: return createInternalScope();
			case StextPackage.IMPORT_SCOPE: return createImportScope();
			case StextPackage.IMPORT: return createImport();
			case StextPackage.EVENT_DEFINITION: return createEventDefinition();
			case StextPackage.VARIABLE_DEFINITION: return createVariableDefinition();
			case StextPackage.OPERATION_DEFINITION: return createOperationDefinition();
			case StextPackage.TYPE_ALIAS_DEFINITION: return createTypeAliasDefinition();
			case StextPackage.LOCAL_REACTION: return createLocalReaction();
			case StextPackage.TRANSITION_REACTION: return createTransitionReaction();
			case StextPackage.GUARD: return createGuard();
			case StextPackage.ENTRY_POINT_SPEC: return createEntryPointSpec();
			case StextPackage.EXIT_POINT_SPEC: return createExitPointSpec();
			case StextPackage.EVENT_SPEC: return createEventSpec();
			case StextPackage.REGULAR_EVENT_SPEC: return createRegularEventSpec();
			case StextPackage.TIME_EVENT_SPEC: return createTimeEventSpec();
			case StextPackage.BUILTIN_EVENT_SPEC: return createBuiltinEventSpec();
			case StextPackage.ENTRY_EVENT: return createEntryEvent();
			case StextPackage.EXIT_EVENT: return createExitEvent();
			case StextPackage.ALWAYS_EVENT: return createAlwaysEvent();
			case StextPackage.SIMPLE_SCOPE: return createSimpleScope();
			case StextPackage.REACTION_TRIGGER: return createReactionTrigger();
			case StextPackage.DEFAULT_TRIGGER: return createDefaultTrigger();
			case StextPackage.REACTION_EFFECT: return createReactionEffect();
			case StextPackage.EVENT_RAISING_EXPRESSION: return createEventRaisingExpression();
			case StextPackage.EVENT_VALUE_REFERENCE_EXPRESSION: return createEventValueReferenceExpression();
			case StextPackage.ACTIVE_STATE_REFERENCE_EXPRESSION: return createActiveStateReferenceExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case StextPackage.DIRECTION:
				return createDirectionFromString(eDataType, initialValue);
			case StextPackage.TIME_EVENT_TYPE:
				return createTimeEventTypeFromString(eDataType, initialValue);
			case StextPackage.TIME_UNIT:
				return createTimeUnitFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case StextPackage.DIRECTION:
				return convertDirectionToString(eDataType, instanceValue);
			case StextPackage.TIME_EVENT_TYPE:
				return convertTimeEventTypeToString(eDataType, instanceValue);
			case StextPackage.TIME_UNIT:
				return convertTimeUnitToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Root createRoot() {
		RootImpl root = new RootImpl();
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefRoot createDefRoot() {
		DefRootImpl defRoot = new DefRootImpl();
		return defRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatechartRoot createStatechartRoot() {
		StatechartRootImpl statechartRoot = new StatechartRootImpl();
		return statechartRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateRoot createStateRoot() {
		StateRootImpl stateRoot = new StateRootImpl();
		return stateRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionRoot createTransitionRoot() {
		TransitionRootImpl transitionRoot = new TransitionRootImpl();
		return transitionRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatechartSpecification createStatechartSpecification() {
		StatechartSpecificationImpl statechartSpecification = new StatechartSpecificationImpl();
		return statechartSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateSpecification createStateSpecification() {
		StateSpecificationImpl stateSpecification = new StateSpecificationImpl();
		return stateSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionSpecification createTransitionSpecification() {
		TransitionSpecificationImpl transitionSpecification = new TransitionSpecificationImpl();
		return transitionSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatechartScope createStatechartScope() {
		StatechartScopeImpl statechartScope = new StatechartScopeImpl();
		return statechartScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceScope createInterfaceScope() {
		InterfaceScopeImpl interfaceScope = new InterfaceScopeImpl();
		return interfaceScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalScope createInternalScope() {
		InternalScopeImpl internalScope = new InternalScopeImpl();
		return internalScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportScope createImportScope() {
		ImportScopeImpl importScope = new ImportScopeImpl();
		return importScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Import createImport() {
		ImportImpl import_ = new ImportImpl();
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventDefinition createEventDefinition() {
		EventDefinitionImpl eventDefinition = new EventDefinitionImpl();
		return eventDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDefinition createVariableDefinition() {
		VariableDefinitionImpl variableDefinition = new VariableDefinitionImpl();
		return variableDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationDefinition createOperationDefinition() {
		OperationDefinitionImpl operationDefinition = new OperationDefinitionImpl();
		return operationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeAliasDefinition createTypeAliasDefinition() {
		TypeAliasDefinitionImpl typeAliasDefinition = new TypeAliasDefinitionImpl();
		return typeAliasDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalReaction createLocalReaction() {
		LocalReactionImpl localReaction = new LocalReactionImpl();
		return localReaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionReaction createTransitionReaction() {
		TransitionReactionImpl transitionReaction = new TransitionReactionImpl();
		return transitionReaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Guard createGuard() {
		GuardImpl guard = new GuardImpl();
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryPointSpec createEntryPointSpec() {
		EntryPointSpecImpl entryPointSpec = new EntryPointSpecImpl();
		return entryPointSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExitPointSpec createExitPointSpec() {
		ExitPointSpecImpl exitPointSpec = new ExitPointSpecImpl();
		return exitPointSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventSpec createEventSpec() {
		EventSpecImpl eventSpec = new EventSpecImpl();
		return eventSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegularEventSpec createRegularEventSpec() {
		RegularEventSpecImpl regularEventSpec = new RegularEventSpecImpl();
		return regularEventSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeEventSpec createTimeEventSpec() {
		TimeEventSpecImpl timeEventSpec = new TimeEventSpecImpl();
		return timeEventSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltinEventSpec createBuiltinEventSpec() {
		BuiltinEventSpecImpl builtinEventSpec = new BuiltinEventSpecImpl();
		return builtinEventSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryEvent createEntryEvent() {
		EntryEventImpl entryEvent = new EntryEventImpl();
		return entryEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExitEvent createExitEvent() {
		ExitEventImpl exitEvent = new ExitEventImpl();
		return exitEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlwaysEvent createAlwaysEvent() {
		AlwaysEventImpl alwaysEvent = new AlwaysEventImpl();
		return alwaysEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleScope createSimpleScope() {
		SimpleScopeImpl simpleScope = new SimpleScopeImpl();
		return simpleScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReactionTrigger createReactionTrigger() {
		ReactionTriggerImpl reactionTrigger = new ReactionTriggerImpl();
		return reactionTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultTrigger createDefaultTrigger() {
		DefaultTriggerImpl defaultTrigger = new DefaultTriggerImpl();
		return defaultTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReactionEffect createReactionEffect() {
		ReactionEffectImpl reactionEffect = new ReactionEffectImpl();
		return reactionEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventRaisingExpression createEventRaisingExpression() {
		EventRaisingExpressionImpl eventRaisingExpression = new EventRaisingExpressionImpl();
		return eventRaisingExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventValueReferenceExpression createEventValueReferenceExpression() {
		EventValueReferenceExpressionImpl eventValueReferenceExpression = new EventValueReferenceExpressionImpl();
		return eventValueReferenceExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActiveStateReferenceExpression createActiveStateReferenceExpression() {
		ActiveStateReferenceExpressionImpl activeStateReferenceExpression = new ActiveStateReferenceExpressionImpl();
		return activeStateReferenceExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Direction createDirectionFromString(EDataType eDataType, String initialValue) {
		Direction result = Direction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDirectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeEventType createTimeEventTypeFromString(EDataType eDataType, String initialValue) {
		TimeEventType result = TimeEventType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimeEventTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeUnit createTimeUnitFromString(EDataType eDataType, String initialValue) {
		TimeUnit result = TimeUnit.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimeUnitToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StextPackage getStextPackage() {
		return (StextPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StextPackage getPackage() {
		return StextPackage.eINSTANCE;
	}

} //StextFactoryImpl
