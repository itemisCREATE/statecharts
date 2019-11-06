
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from triggerguardexpressions.triggerguardexpressions_statemachine import TriggerGuardExpressions
from tests.vtimer.virtual_timer import *

# Unit TestCase for TriggerGuardExpressions
class TriggerguardexpressionsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = TriggerGuardExpressions()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_trueGuard(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_e1()
		self.statemachine.sci_interface.b = True
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_e2()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_e1()
		self.statemachine.sci_interface.raise_e2()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		
	def test_falseGuard(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.b = False
		self.statemachine.sci_interface.raise_e1()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_e2()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_e1()
		self.statemachine.sci_interface.raise_e2()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		
