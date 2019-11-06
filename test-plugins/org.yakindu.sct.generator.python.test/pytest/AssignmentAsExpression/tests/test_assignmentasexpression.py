
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from assignmentasexpression.assignmentasexpression_statemachine import AssignmentAsExpression
from tests.vtimer.virtual_timer import *

# Unit TestCase for AssignmentAsExpression
class AssignmentasexpressionTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = AssignmentAsExpression()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_simpleAssignment(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_add))
		self.assertTrue(self.statemachine.sci_interface.b == 5)
		self.assertTrue(self.statemachine.sci_interface.a == 9)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_subtract))
		self.assertTrue(self.statemachine.sci_interface.d == 6)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_multiply))
		self.assertTrue(self.statemachine.sci_interface.e == 15)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_divide))
		self.assertTrue(self.statemachine.sci_interface.g == 1)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_modulo))
		self.assertTrue(self.statemachine.sci_interface.i == 1)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_shift))
		self.assertTrue(self.statemachine.sci_interface.j == 16)
		self.assertTrue(self.statemachine.sci_interface.k == 4)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_boolean_and))
		self.assertTrue(self.statemachine.sci_interface.l == 1)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_boolean_or))
		self.assertTrue(self.statemachine.sci_interface.p == 15)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_boolean_xor))
		self.assertTrue(self.statemachine.sci_interface.u == 12)
		self.statemachine.exit()
		
