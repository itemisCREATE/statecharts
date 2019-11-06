
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from guard.guard_statemachine import Guard
from tests.vtimer.virtual_timer import *

# Unit TestCase for Guard
class GuardTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = Guard()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_guardTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_event1()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_event2()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		self.statemachine.sci_interface.raise_return()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_event1()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		self.statemachine.sci_interface.raise_return()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		
