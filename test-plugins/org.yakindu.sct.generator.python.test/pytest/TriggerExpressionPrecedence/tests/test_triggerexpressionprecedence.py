
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from triggerexpressionprecedence.triggerexpressionprecedence_statemachine import TriggerExpressionPrecedence
from tests.vtimer.virtual_timer import *

# Unit TestCase for TriggerExpressionPrecedence
class TriggerexpressionprecedenceTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = TriggerExpressionPrecedence()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_unsatisfiedTriggerAndFGuardFalseOrFalse(self):
		self.statemachine.enter()
		self.statemachine.sci_interface.c1 = False
		self.statemachine.sci_interface.c2 = False
		self.timer.cycle_leap(1)
		self.assertTrue(not self.statemachine.sci_interface.e1_transition)
		
	def test_unsatisfiedTriggerAndFGuardTrueOrFalse(self):
		self.statemachine.enter()
		self.statemachine.sci_interface.c1 = True
		self.statemachine.sci_interface.c2 = False
		self.timer.cycle_leap(1)
		self.assertTrue(not self.statemachine.sci_interface.e1_transition)
		
	def test_unsatisfiedTriggerAndFGuardFalseOrTrue(self):
		self.statemachine.enter()
		self.statemachine.sci_interface.c1 = False
		self.statemachine.sci_interface.c2 = True
		self.timer.cycle_leap(1)
		self.assertTrue(not self.statemachine.sci_interface.e1_transition)
		
	def test_unsatisfiedTriggerAndFGuardTrueOrTrue(self):
		self.statemachine.enter()
		self.statemachine.sci_interface.c1 = True
		self.statemachine.sci_interface.c2 = True
		self.timer.cycle_leap(1)
		self.assertTrue(not self.statemachine.sci_interface.e1_transition)
		
