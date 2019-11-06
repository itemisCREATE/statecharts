
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from internaleventlifecycle.internaleventlifecycle_statemachine import InternalEventLifeCycle
from tests.vtimer.virtual_timer import *

# Unit TestCase for InternalEventLifeCycle
class InternaleventlifecycleTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = InternalEventLifeCycle()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_internalEventLifeCycleTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r1_a))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r2_c))
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r1_a))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r2_d))
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r1_a))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r2_d))
		self.statemachine.sci_interface.raise_f()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r1_a))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r2_c))
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r1_a))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r2_c))
		
