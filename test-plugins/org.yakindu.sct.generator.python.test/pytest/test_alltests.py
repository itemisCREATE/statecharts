
# Suite: Alltests

import glob, string
import unittest
import warnings

# testcases listed / specified in SCT Unit file:
target_tests = [\
	'ConstOnlyDefaultScope.tests.test_constonlydefaultscope',\
	'ConstOnlyInternalScope.tests.test_constonlyinternalscope',\
	'ConstOnlyNamedScope.tests.test_constonlynamedscope',\
	'EntryReactionAction.tests.test_entryreactionaction',\
	'EventDrivenInternalEvent.tests.test_eventdriveninternalevent',\
	'EventDrivenTriggeredByEvent.tests.test_eventdriventriggeredbyevent',\
	'EventDrivenTriggeredByTimeEvent.tests.test_eventdriventriggeredbytimeevent',\
	'localEvents.tests.test_localevents',\
	'NoLocalEvents.tests.test_nolocalevents',\
	'OutEventVisibilityEventDriven.tests.test_outeventvisibilityeventdriven',\
	'OutEventWithPayload.tests.test_outeventwithpayload',\
	'ChildFirstExecutionHierarchy.tests.test_childfirstexecutionhierarchy',\
	'ChildFirstLocalReactions.tests.test_childfirstlocalreactions',\
	'ChildFirstOrthogonalReactions.tests.test_childfirstorthogonalreactions',\
	'ChildFirstTransitionsInSubchart.tests.test_childfirsttransitionsinsubchart',\
	'ChildFirstTransitionTaking.tests.test_childfirsttransitiontaking',\
	'ParentFirstExecutionHierarchy.tests.test_parentfirstexecutionhierarchy',\
	'ParentFirstLocalReactions.tests.test_parentfirstlocalreactions',\
	'ParentFirstOrthogonalReactions.tests.test_parentfirstorthogonalreactions',\
	'ExitState.tests.test_exitstate',\
	'TransitionHandlesMultipleExits.tests.test_transitionhandlesmultipleexists',\
	'TriggerExpressionPrecedence.tests.test_triggerexpressionprecedence',\
	'StatechartEntryAndExitActions.tests.test_statechartentryexitactions',\
	'AlwaysOncycle.tests.test_alwaysoncycle',\
	'AssignmentAsExpression.tests.test_assignmentasexpression',\
	'BitExpressions.tests.test_bitexpressions',\
	'BitwiseExecutionOrder.tests.test_bitwiseexecutionorder',\
	'BooleanExpressions.tests.test_booleanexpressions',\
	'CastExpressions.tests.test_castexpressions',\
	'Choice.tests.test_choice',\
	'CKeywords.tests.test_ckeywords',\
	'ConditionalExpressions.tests.test_conditionalexpression',\
	'Constants.tests.test_constantstests',\
	'ConstantsVariation.tests.test_constantsvariationtests',\
	'Declarations.tests.test_declarations',\
	'DeepEntry.tests.test_deepentry',\
	'DeepHistory.tests.test_deephistory',\
	'DynamicChoice.tests.test_dynamicchoice',\
	'EmptyTransition.tests.test_emptytransition',\
	'EnterState.tests.test_enterstate',\
	'EntryChoice.tests.test_entrychoice',\
	'EntryExitSelfTransition.tests.test_entryexitselftransition',\
	'EventDrivenOutEvents.tests.test_eventdrivenoutevents',\
	'ExitOnSelfTransition.tests.test_exitonselftransition',\
	'ExitSequence.tests.test_exitsequence',\
	'FeatureCalls.tests.test_featurecalls',\
	'FinalState.tests.test_finalstate',\
	'FloatModulo.tests.test_floatmodulo',\
	'Guard.tests.test_guard',\
	'GuardedEntry.tests.test_guardedentry',\
	'Guard.tests.test_guard',\
	'HistoryWithExitPoint.tests.test_historywithexitpoint',\
	'HistoryWithoutInitialStep.tests.test_historywithoutinitialstep',\
	'InEventLifeCycle.tests.test_ineventlifecycle',\
	'IntegerExpressions.tests.test_integerexpressions',\
	'InternalEventLifeCycle.tests.test_internaleventlifecycle',\
	'LocalReactions.tests.test_localreactions',\
	'LogicalAnd.tests.test_logicalandtests',\
	'LogicalOr.tests.test_logicalortests',\
	'NamedInterfaceAccess.tests.test_namedinterfaceaccess',\
	'Operations.tests.test_operationstest',\
	'OutEventLifeCycle.tests.test_outeventlifecycle',\
	'Parenthesis.tests.test_parenthesis',\
	'PriorityValues.tests.test_priorityvalues',\
	'RaiseEvent.tests.test_raiseevent',\
	'ReadOnlyVariable.tests.test_readonlyvariable',\
	'SameNameDifferentRegion.tests.test_samenamedifferentregion',\
	'ShallowHistory.tests.test_shallowhistory',\
	'ShallowHistoryWithDeepEntry.tests.test_shallowhistorywithdeepentry',\
	'ShadowValueParameter.tests.test_shadowvalueparameter',\
	'SimpleEvent.tests.test_simpleevent',\
	'SimpleHierachy.tests.test_simplehierachy',\
	'StatechartActive.tests.test_statechartactive',\
	'StatechartLocalReactions.tests.test_statechartlocalreactions',\
	'StateIsActive.tests.test_stateisactive',\
	'StaticChoice.tests.test_staticchoice',\
	'STextKeywordsInStatesAndRegions.tests.test_stextkeywordsinstatesandregions',\
	'StringExpressions.tests.test_stringexpressions',\
	'SyncFork.tests.test_syncfork',\
	'SyncJoin.tests.test_syncjoin',\
	'TransitionWithoutCondition.tests.test_transitionwithoutcondition',\
	'TriggerGuardExpressions.tests.test_triggerguardexpressions',\
	'ValuedEvents.tests.test_valuedevents',\
	'TypeAlias.tests.test_typealias',\
	'StatechartKeywords.tests.test_statemachinekeywords',\
	'TimedTransitions.tests.test_timedtransitions',\
	]
# recursive search for all testcases in current directory:
found_tests_raw = glob.glob('**/test_*.py', recursive=True)
found_tests = [test_file[0:len(test_file)-3].replace('\\','.') for test_file in found_tests_raw]
# match testcases found with user specified testcases:
testcases = set(target_tests).intersection(found_tests)
print('Number of TestCases specified by user: ', len(target_tests))
print('Number of TestCases found by search: ', len(found_tests))
print('Number of matching TestCases: ', len(testcases))

with warnings.catch_warnings(record=False):
    suites = [unittest.defaultTestLoader.loadTestsFromName(test_file) for test_file in testcases]
    test_suite = unittest.TestSuite(suites)
    test_runner = unittest.TextTestRunner(verbosity=2).run(test_suite)

