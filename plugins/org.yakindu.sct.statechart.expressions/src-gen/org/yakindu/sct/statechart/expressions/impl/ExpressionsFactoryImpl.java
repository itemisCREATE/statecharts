/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.statechart.expressions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.yakindu.sct.statechart.expressions.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsFactoryImpl extends EFactoryImpl implements ExpressionsFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ExpressionsFactory init()
  {
    try
    {
      ExpressionsFactory theExpressionsFactory = (ExpressionsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.yakindu.org/sct/statechart/Expressions"); 
      if (theExpressionsFactory != null)
      {
        return theExpressionsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ExpressionsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionsFactoryImpl()
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
      case ExpressionsPackage.ROOT: return createRoot();
      case ExpressionsPackage.DEF_ROOT: return createDefRoot();
      case ExpressionsPackage.STATECHART_ROOT: return createStatechartRoot();
      case ExpressionsPackage.STATE_ROOT: return createStateRoot();
      case ExpressionsPackage.TRANSITION_ROOT: return createTransitionRoot();
      case ExpressionsPackage.STATECHART_DEFINITION: return createStatechartDefinition();
      case ExpressionsPackage.STATE_DEFINITION: return createStateDefinition();
      case ExpressionsPackage.TRANSITION_STATEMENT: return createTransitionStatement();
      case ExpressionsPackage.SCOPE: return createScope();
      case ExpressionsPackage.SIMPLE_SCOPE: return createSimpleScope();
      case ExpressionsPackage.STATECHART_SCOPE: return createStatechartScope();
      case ExpressionsPackage.INTERFACE_SCOPE: return createInterfaceScope();
      case ExpressionsPackage.INTERNAL_SCOPE: return createInternalScope();
      case ExpressionsPackage.DEFINITION: return createDefinition();
      case ExpressionsPackage.EVENT_DEFINITION: return createEventDefinition();
      case ExpressionsPackage.EVENT_DERIVATION: return createEventDerivation();
      case ExpressionsPackage.VARIABLE_DEFINITION: return createVariableDefinition();
      case ExpressionsPackage.CLOCK: return createClock();
      case ExpressionsPackage.OPERATION: return createOperation();
      case ExpressionsPackage.ENTRYPOINT: return createEntrypoint();
      case ExpressionsPackage.EXITPOINT: return createExitpoint();
      case ExpressionsPackage.REACTION: return createReaction();
      case ExpressionsPackage.LOCAL_REACTION: return createLocalReaction();
      case ExpressionsPackage.TRANSITION_REACTION: return createTransitionReaction();
      case ExpressionsPackage.REACTION_TRIGGER: return createReactionTrigger();
      case ExpressionsPackage.ACTION: return createAction();
      case ExpressionsPackage.REACTION_PROPERTIES: return createReactionProperties();
      case ExpressionsPackage.REACTION_PROPERTY: return createReactionProperty();
      case ExpressionsPackage.REACTION_PRIORITY: return createReactionPriority();
      case ExpressionsPackage.ENTRY_POINT_SPEC: return createEntryPointSpec();
      case ExpressionsPackage.EXIT_POINT_SPEC: return createExitPointSpec();
      case ExpressionsPackage.EVENT_SPEC: return createEventSpec();
      case ExpressionsPackage.REGULAR_EVENT_SPEC: return createRegularEventSpec();
      case ExpressionsPackage.TIME_EVENT_SPEC: return createTimeEventSpec();
      case ExpressionsPackage.BUILTIN_EVENT_SPEC: return createBuiltinEventSpec();
      case ExpressionsPackage.ENTER_EVENT: return createEnterEvent();
      case ExpressionsPackage.EXIT_EVENT: return createExitEvent();
      case ExpressionsPackage.ON_CYCLE_EVENT: return createOnCycleEvent();
      case ExpressionsPackage.ALWAYS_EVENT: return createAlwaysEvent();
      case ExpressionsPackage.EXPRESSION_RULE: return createExpressionRule();
      case ExpressionsPackage.RAISE_EVENT_EXPRESSION: return createRaiseEventExpression();
      case ExpressionsPackage.EXPRESSION: return createExpression();
      case ExpressionsPackage.LOGICAL_OR_EXPRESSION: return createLogicalOrExpression();
      case ExpressionsPackage.LOGICAL_AND_EXPRESSION: return createLogicalAndExpression();
      case ExpressionsPackage.LOGICAL_NOT_EXPRESSION: return createLogicalNotExpression();
      case ExpressionsPackage.LOGICAL_RELATION_EXPRESSION: return createLogicalRelationExpression();
      case ExpressionsPackage.NUMERICAL_ADD_SUBTRACT_EXPRESSION: return createNumericalAddSubtractExpression();
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION: return createNumericalMultiplyDivideExpression();
      case ExpressionsPackage.NUMERICAL_UNARY_EXPRESSION: return createNumericalUnaryExpression();
      case ExpressionsPackage.PRIMITIVE_VALUE_EXPRESSION: return createPrimitiveValueExpression();
      case ExpressionsPackage.PROPERTY_REFERENCE_EXPRESSION: return createPropertyReferenceExpression();
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
      case ExpressionsPackage.DIRECTION:
        return createDirectionFromString(eDataType, initialValue);
      case ExpressionsPackage.ADDITIVE_OPERATOR:
        return createAdditiveOperatorFromString(eDataType, initialValue);
      case ExpressionsPackage.MULTIPLICATIVE_OPERATOR:
        return createMultiplicativeOperatorFromString(eDataType, initialValue);
      case ExpressionsPackage.UNARY_OPERATOR:
        return createUnaryOperatorFromString(eDataType, initialValue);
      case ExpressionsPackage.RELATIONAL_OPERATOR:
        return createRelationalOperatorFromString(eDataType, initialValue);
      case ExpressionsPackage.DIRECTION_KIND:
        return createDirectionKindFromString(eDataType, initialValue);
      case ExpressionsPackage.TIME_UNIT:
        return createTimeUnitFromString(eDataType, initialValue);
      case ExpressionsPackage.TYPE:
        return createTypeFromString(eDataType, initialValue);
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
      case ExpressionsPackage.DIRECTION:
        return convertDirectionToString(eDataType, instanceValue);
      case ExpressionsPackage.ADDITIVE_OPERATOR:
        return convertAdditiveOperatorToString(eDataType, instanceValue);
      case ExpressionsPackage.MULTIPLICATIVE_OPERATOR:
        return convertMultiplicativeOperatorToString(eDataType, instanceValue);
      case ExpressionsPackage.UNARY_OPERATOR:
        return convertUnaryOperatorToString(eDataType, instanceValue);
      case ExpressionsPackage.RELATIONAL_OPERATOR:
        return convertRelationalOperatorToString(eDataType, instanceValue);
      case ExpressionsPackage.DIRECTION_KIND:
        return convertDirectionKindToString(eDataType, instanceValue);
      case ExpressionsPackage.TIME_UNIT:
        return convertTimeUnitToString(eDataType, instanceValue);
      case ExpressionsPackage.TYPE:
        return convertTypeToString(eDataType, instanceValue);
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
  public StatechartDefinition createStatechartDefinition()
  {
    StatechartDefinitionImpl statechartDefinition = new StatechartDefinitionImpl();
    return statechartDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateDefinition createStateDefinition()
  {
    StateDefinitionImpl stateDefinition = new StateDefinitionImpl();
    return stateDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionStatement createTransitionStatement()
  {
    TransitionStatementImpl transitionStatement = new TransitionStatementImpl();
    return transitionStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scope createScope()
  {
    ScopeImpl scope = new ScopeImpl();
    return scope;
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
  public Definition createDefinition()
  {
    DefinitionImpl definition = new DefinitionImpl();
    return definition;
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
  public EventDerivation createEventDerivation()
  {
    EventDerivationImpl eventDerivation = new EventDerivationImpl();
    return eventDerivation;
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
  public Clock createClock()
  {
    ClockImpl clock = new ClockImpl();
    return clock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operation createOperation()
  {
    OperationImpl operation = new OperationImpl();
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entrypoint createEntrypoint()
  {
    EntrypointImpl entrypoint = new EntrypointImpl();
    return entrypoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exitpoint createExitpoint()
  {
    ExitpointImpl exitpoint = new ExitpointImpl();
    return exitpoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reaction createReaction()
  {
    ReactionImpl reaction = new ReactionImpl();
    return reaction;
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
  public Action createAction()
  {
    ActionImpl action = new ActionImpl();
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReactionProperties createReactionProperties()
  {
    ReactionPropertiesImpl reactionProperties = new ReactionPropertiesImpl();
    return reactionProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReactionProperty createReactionProperty()
  {
    ReactionPropertyImpl reactionProperty = new ReactionPropertyImpl();
    return reactionProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReactionPriority createReactionPriority()
  {
    ReactionPriorityImpl reactionPriority = new ReactionPriorityImpl();
    return reactionPriority;
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
  public EnterEvent createEnterEvent()
  {
    EnterEventImpl enterEvent = new EnterEventImpl();
    return enterEvent;
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
  public OnCycleEvent createOnCycleEvent()
  {
    OnCycleEventImpl onCycleEvent = new OnCycleEventImpl();
    return onCycleEvent;
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
  public ExpressionRule createExpressionRule()
  {
    ExpressionRuleImpl expressionRule = new ExpressionRuleImpl();
    return expressionRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RaiseEventExpression createRaiseEventExpression()
  {
    RaiseEventExpressionImpl raiseEventExpression = new RaiseEventExpressionImpl();
    return raiseEventExpression;
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
  public PropertyReferenceExpression createPropertyReferenceExpression()
  {
    PropertyReferenceExpressionImpl propertyReferenceExpression = new PropertyReferenceExpressionImpl();
    return propertyReferenceExpression;
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
  public DirectionKind createDirectionKindFromString(EDataType eDataType, String initialValue)
  {
    DirectionKind result = DirectionKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDirectionKindToString(EDataType eDataType, Object instanceValue)
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
  public Type createTypeFromString(EDataType eDataType, String initialValue)
  {
    Type result = Type.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionsPackage getExpressionsPackage()
  {
    return (ExpressionsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ExpressionsPackage getPackage()
  {
    return ExpressionsPackage.eINSTANCE;
  }

} //ExpressionsFactoryImpl
