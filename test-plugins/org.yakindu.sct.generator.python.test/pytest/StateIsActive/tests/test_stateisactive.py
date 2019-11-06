
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from stateisactive.stateisactive_statemachine import StateIsActive
from tests.vtimer.virtual_timer import *

# Unit TestCase for StateIsActive
class StateisactiveTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = StateIsActive()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_stateIsActive(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r1_r1a))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r2_r2a))
		self.statemachine.sci_interface.raise_event1()
		self.timer.cycle_leap(1)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r1_r1b))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r2_r2b))
		
