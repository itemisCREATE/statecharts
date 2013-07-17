/**
 */
package org.yakindu.sct.model.stext.stext.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.yakindu.sct.model.stext.stext.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StextFactoryImpl extends EFactoryImpl implements StextFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static StextFactory init()
  {
    try
    {
      StextFactory theStextFactory = (StextFactory)EPackage.Registry.INSTANCE.getEFactory(StextPackage.eNS_URI);
      if (theStextFactory != null)
      {
        return theStextFactory;
      }
    }
    catch (Exception exception)
    {
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
  public StextFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
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
      case StextPackage.EVENT_DEFINITION: return createEventDefinition();
      case StextPackage.VARIABLE_DEFINITION: return createVariableDefinition();
      case StextPackage.OPERATION_DEFINITION: return createOperationDefinition();
      case StextPackage.LOCAL_REACTION: return createLocalReaction();
      case StextPackage.TRANSITION_REACTION: return createTransitionReaction();
      case StextPackage.ENTRY_POINT_SPEC: return createEntryPointSpec();
      case StextPackage.EXIT_POINT_SPEC: return createExitPointSpec();
      case StextPackage.EVENT_SPEC: return createEventSpec();
      case StextPackage.REGULAR_EVENT_SPEC: return createRegularEventSpec();
      case StextPackage.TIME_EVENT_SPEC: return createTimeEventSpec();
      case StextPackage.BUILTIN_EVENT_SPEC: return createBuiltinEventSpec();
      case StextPackage.ENTRY_EVENT: return createEntryEvent();
      case StextPackage.EXIT_EVENT: return createExitEvent();
      case StextPackage.ALWAYS_EVENT: return createAlwaysEvent();
      case StextPackage.EXPRESSION: return createExpression();
      case StextPackage.LITERAL: return createLiteral();
      case StextPackage.BOOL_LITERAL: return createBoolLiteral();
      case StextPackage.INT_LITERAL: return createIntLiteral();
      case StextPackage.REAL_LITERAL: return createRealLiteral();
      case StextPackage.HEX_LITERAL: return createHexLiteral();
      case StextPackage.STRING_LITERAL: return createStringLiteral();
      case StextPackage.SIMPLE_SCOPE: return createSimpleScope();
      case StextPackage.REACTION_TRIGGER: return createReactionTrigger();
      case StextPackage.DEFAULT_TRIGGER: return createDefaultTrigger();
      case StextPackage.REACTION_EFFECT: return createReactionEffect();
      case StextPackage.EVENT_RAISING_EXPRESSION: return createEventRaisingExpression();
      case StextPackage.ASSIGNMENT_EXPRESSION: return createAssignmentExpression();
      case StextPackage.CONDITIONAL_EXPRESSION: return createConditionalExpression();
      case StextPackage.LOGICAL_OR_EXPRESSION: return createLogicalOrExpression();
      case StextPackage.LOGICAL_AND_EXPRESSION: return createLogicalAndExpression();
      case StextPackage.LOGICAL_NOT_EXPRESSION: return createLogicalNotExpression();
      case StextPackage.BITWISE_XOR_EXPRESSION: return createBitwiseXorExpression();
      case StextPackage.BITWISE_OR_EXPRESSION: return createBitwiseOrExpression();
      case StextPackage.BITWISE_AND_EXPRESSION: return createBitwiseAndExpression();
      case StextPackage.LOGICAL_RELATION_EXPRESSION: return createLogicalRelationExpression();
      case StextPackage.SHIFT_EXPRESSION: return createShiftExpression();
      case StextPackage.NUMERICAL_ADD_SUBTRACT_EXPRESSION: return createNumericalAddSubtractExpression();
      case StextPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION: return createNumericalMultiplyDivideExpression();
      case StextPackage.NUMERICAL_UNARY_EXPRESSION: return createNumericalUnaryExpression();
      case StextPackage.PRIMITIVE_VALUE_EXPRESSION: return createPrimitiveValueExpression();
      case StextPackage.FEATURE_CALL: return createFeatureCall();
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION: return createElementReferenceExpression();
      case StextPackage.EVENT_VALUE_REFERENCE_EXPRESSION: return createEventValueReferenceExpression();
      case StextPackage.ACTIVE_STATE_REFERENCE_EXPRESSION: return createActiveStateReferenceExpression();
      case StextPackage.PARENTHESIZED_EXPRESSION: return createParenthesizedExpression();
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
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case StextPackage.DIRECTION:
        return createDirectionFromString(eDataType, initialValue);
      case StextPackage.TIME_EVENT_TYPE:
        return createTimeEventTypeFromString(eDataType, initialValue);
      case StextPackage.ASSIGNMENT_OPERATOR:
        return createAssignmentOperatorFromString(eDataType, initialValue);
      case StextPackage.SHIFT_OPERATOR:
        return createShiftOperatorFromString(eDataType, initialValue);
      case StextPackage.ADDITIVE_OPERATOR:
        return createAdditiveOperatorFromString(eDataType, initialValue);
      case StextPackage.MULTIPLICATIVE_OPERATOR:
        return createMultiplicativeOperatorFromString(eDataType, initialValue);
      case StextPackage.UNARY_OPERATOR:
        return createUnaryOperatorFromString(eDataType, initialValue);
      case StextPackage.RELATIONAL_OPERATOR:
        return createRelationalOperatorFromString(eDataType, initialValue);
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
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case StextPackage.DIRECTION:
        return convertDirectionToString(eDataType, instanceValue);
      case StextPackage.TIME_EVENT_TYPE:
        return convertTimeEventTypeToString(eDataType, instanceValue);
      case StextPackage.ASSIGNMENT_OPERATOR:
        return convertAssignmentOperatorToString(eDataType, instanceValue);
      case StextPackage.SHIFT_OPERATOR:
        return convertShiftOperatorToString(eDataType, instanceValue);
      case StextPackage.ADDITIVE_OPERATOR:
        return convertAdditiveOperatorToString(eDataType, instanceValue);
      case StextPackage.MULTIPLICATIVE_OPERATOR:
        return convertMultiplicativeOperatorToString(eDataType, instanceValue);
      case StextPackage.UNARY_OPERATOR:
        return convertUnaryOperatorToString(eDataType, instanceValue);
      case StextPackage.RELATIONAL_OPERATOR:
        return convertRelationalOperatorToString(eDataType, instanceValue);
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
  public Root createRoot()
  {
    RootImpl root = new RootImpl();
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefRoot createDefRoot()
  {
    DefRootImpl defRoot = new DefRootImpl();
    return defRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatechartRoot createStatechartRoot()
  {
    StatechartRootImpl statechartRoot = new StatechartRootImpl();
    return statechartRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateRoot createStateRoot()
  {
    StateRootImpl stateRoot = new StateRootImpl();
    return stateRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionRoot createTransitionRoot()
  {
    TransitionRootImpl transitionRoot = new TransitionRootImpl();
    return transitionRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatechartSpecification createStatechartSpecification()
  {
    StatechartSpecificationImpl statechartSpecification = new StatechartSpecificationImpl();
    return statechartSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateSpecification createStateSpecification()
  {
    StateSpecificationImpl stateSpecification = new StateSpecificationImpl();
    return stateSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionSpecification createTransitionSpecification()
  {
    TransitionSpecificationImpl transitionSpecification = new TransitionSpecificationImpl();
    return transitionSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatechartScope createStatechartScope()
  {
    StatechartScopeImpl statechartScope = new StatechartScopeImpl();
    return statechartScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InterfaceScope createInterfaceScope()
  {
    InterfaceScopeImpl interfaceScope = new InterfaceScopeImpl();
    return interfaceScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InternalScope createInternalScope()
  {
    InternalScopeImpl internalScope = new InternalScopeImpl();
    return internalScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventDefinition createEventDefinition()
  {
    EventDefinitionImpl eventDefinition = new EventDefinitionImpl();
    return eventDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableDefinition createVariableDefinition()
  {
    VariableDefinitionImpl variableDefinition = new VariableDefinitionImpl();
    return variableDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationDefinition createOperationDefinition()
  {
    OperationDefinitionImpl operationDefinition = new OperationDefinitionImpl();
    return operationDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalReaction createLocalReaction()
  {
    LocalReactionImpl localReaction = new LocalReactionImpl();
    return localReaction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionReaction createTransitionReaction()
  {
    TransitionReactionImpl transitionReaction = new TransitionReactionImpl();
    return transitionReaction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntryPointSpec createEntryPointSpec()
  {
    EntryPointSpecImpl entryPointSpec = new EntryPointSpecImpl();
    return entryPointSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExitPointSpec createExitPointSpec()
  {
    ExitPointSpecImpl exitPointSpec = new ExitPointSpecImpl();
    return exitPointSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventSpec createEventSpec()
  {
    EventSpecImpl eventSpec = new EventSpecImpl();
    return eventSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RegularEventSpec createRegularEventSpec()
  {
    RegularEventSpecImpl regularEventSpec = new RegularEventSpecImpl();
    return regularEventSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeEventSpec createTimeEventSpec()
  {
    TimeEventSpecImpl timeEventSpec = new TimeEventSpecImpl();
    return timeEventSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BuiltinEventSpec createBuiltinEventSpec()
  {
    BuiltinEventSpecImpl builtinEventSpec = new BuiltinEventSpecImpl();
    return builtinEventSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntryEvent createEntryEvent()
  {
    EntryEventImpl entryEvent = new EntryEventImpl();
    return entryEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExitEvent createExitEvent()
  {
    ExitEventImpl exitEvent = new ExitEventImpl();
    return exitEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlwaysEvent createAlwaysEvent()
  {
    AlwaysEventImpl alwaysEvent = new AlwaysEventImpl();
    return alwaysEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolLiteral createBoolLiteral()
  {
    BoolLiteralImpl boolLiteral = new BoolLiteralImpl();
    return boolLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntLiteral createIntLiteral()
  {
    IntLiteralImpl intLiteral = new IntLiteralImpl();
    return intLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RealLiteral createRealLiteral()
  {
    RealLiteralImpl realLiteral = new RealLiteralImpl();
    return realLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HexLiteral createHexLiteral()
  {
    HexLiteralImpl hexLiteral = new HexLiteralImpl();
    return hexLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLiteral createStringLiteral()
  {
    StringLiteralImpl stringLiteral = new StringLiteralImpl();
    return stringLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleScope createSimpleScope()
  {
    SimpleScopeImpl simpleScope = new SimpleScopeImpl();
    return simpleScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReactionTrigger createReactionTrigger()
  {
    ReactionTriggerImpl reactionTrigger = new ReactionTriggerImpl();
    return reactionTrigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefaultTrigger createDefaultTrigger()
  {
    DefaultTriggerImpl defaultTrigger = new DefaultTriggerImpl();
    return defaultTrigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReactionEffect createReactionEffect()
  {
    ReactionEffectImpl reactionEffect = new ReactionEffectImpl();
    return reactionEffect;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventRaisingExpression createEventRaisingExpression()
  {
    EventRaisingExpressionImpl eventRaisingExpression = new EventRaisingExpressionImpl();
    return eventRaisingExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentExpression createAssignmentExpression()
  {
    AssignmentExpressionImpl assignmentExpression = new AssignmentExpressionImpl();
    return assignmentExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalExpression createConditionalExpression()
  {
    ConditionalExpressionImpl conditionalExpression = new ConditionalExpressionImpl();
    return conditionalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalOrExpression createLogicalOrExpression()
  {
    LogicalOrExpressionImpl logicalOrExpression = new LogicalOrExpressionImpl();
    return logicalOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalAndExpression createLogicalAndExpression()
  {
    LogicalAndExpressionImpl logicalAndExpression = new LogicalAndExpressionImpl();
    return logicalAndExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalNotExpression createLogicalNotExpression()
  {
    LogicalNotExpressionImpl logicalNotExpression = new LogicalNotExpressionImpl();
    return logicalNotExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseXorExpression createBitwiseXorExpression()
  {
    BitwiseXorExpressionImpl bitwiseXorExpression = new BitwiseXorExpressionImpl();
    return bitwiseXorExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseOrExpression createBitwiseOrExpression()
  {
    BitwiseOrExpressionImpl bitwiseOrExpression = new BitwiseOrExpressionImpl();
    return bitwiseOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseAndExpression createBitwiseAndExpression()
  {
    BitwiseAndExpressionImpl bitwiseAndExpression = new BitwiseAndExpressionImpl();
    return bitwiseAndExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalRelationExpression createLogicalRelationExpression()
  {
    LogicalRelationExpressionImpl logicalRelationExpression = new LogicalRelationExpressionImpl();
    return logicalRelationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftExpression createShiftExpression()
  {
    ShiftExpressionImpl shiftExpression = new ShiftExpressionImpl();
    return shiftExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericalAddSubtractExpression createNumericalAddSubtractExpression()
  {
    NumericalAddSubtractExpressionImpl numericalAddSubtractExpression = new NumericalAddSubtractExpressionImpl();
    return numericalAddSubtractExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericalMultiplyDivideExpression createNumericalMultiplyDivideExpression()
  {
    NumericalMultiplyDivideExpressionImpl numericalMultiplyDivideExpression = new NumericalMultiplyDivideExpressionImpl();
    return numericalMultiplyDivideExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericalUnaryExpression createNumericalUnaryExpression()
  {
    NumericalUnaryExpressionImpl numericalUnaryExpression = new NumericalUnaryExpressionImpl();
    return numericalUnaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveValueExpression createPrimitiveValueExpression()
  {
    PrimitiveValueExpressionImpl primitiveValueExpression = new PrimitiveValueExpressionImpl();
    return primitiveValueExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureCall createFeatureCall()
  {
    FeatureCallImpl featureCall = new FeatureCallImpl();
    return featureCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementReferenceExpression createElementReferenceExpression()
  {
    ElementReferenceExpressionImpl elementReferenceExpression = new ElementReferenceExpressionImpl();
    return elementReferenceExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventValueReferenceExpression createEventValueReferenceExpression()
  {
    EventValueReferenceExpressionImpl eventValueReferenceExpression = new EventValueReferenceExpressionImpl();
    return eventValueReferenceExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActiveStateReferenceExpression createActiveStateReferenceExpression()
  {
    ActiveStateReferenceExpressionImpl activeStateReferenceExpression = new ActiveStateReferenceExpressionImpl();
    return activeStateReferenceExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParenthesizedExpression createParenthesizedExpression()
  {
    ParenthesizedExpressionImpl parenthesizedExpression = new ParenthesizedExpressionImpl();
    return parenthesizedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Direction createDirectionFromString(EDataType eDataType, String initialValue)
  {
    Direction result = Direction.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDirectionToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeEventType createTimeEventTypeFromString(EDataType eDataType, String initialValue)
  {
    TimeEventType result = TimeEventType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTimeEventTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentOperator createAssignmentOperatorFromString(EDataType eDataType, String initialValue)
  {
    AssignmentOperator result = AssignmentOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAssignmentOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftOperator createShiftOperatorFromString(EDataType eDataType, String initialValue)
  {
    ShiftOperator result = ShiftOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertShiftOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveOperator createAdditiveOperatorFromString(EDataType eDataType, String initialValue)
  {
    AdditiveOperator result = AdditiveOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAdditiveOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeOperator createMultiplicativeOperatorFromString(EDataType eDataType, String initialValue)
  {
    MultiplicativeOperator result = MultiplicativeOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMultiplicativeOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryOperator createUnaryOperatorFromString(EDataType eDataType, String initialValue)
  {
    UnaryOperator result = UnaryOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertUnaryOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalOperator createRelationalOperatorFromString(EDataType eDataType, String initialValue)
  {
    RelationalOperator result = RelationalOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertRelationalOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeUnit createTimeUnitFromString(EDataType eDataType, String initialValue)
  {
    TimeUnit result = TimeUnit.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTimeUnitToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StextPackage getStextPackage()
  {
    return (StextPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static StextPackage getPackage()
  {
    return StextPackage.eINSTANCE;
  }

} //StextFactoryImpl
