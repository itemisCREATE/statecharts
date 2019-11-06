
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from exitstate.exitstate_statemachine import ExitState
from tests.vtimer.virtual_timer import *

# Unit TestCase for ExitState
class ExitstateTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = ExitState()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_defaultExit(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.exitstate_r_a))
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.exitstate_r_e))
		
	def test_namedExitThroughNamedTransition(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.exitstate_r_a))
		self.statemachine.sci_interface.raise_f()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.exitstate_r_f))
		
	def test_namedExitThroughDefaultTransition(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.exitstate_r_a))
		self.statemachine.sci_interface.raise_g()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.exitstate_r_e))
		
	def test_remainInA(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.exitstate_r_a))
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.exitstate_r_a))
		
