
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from priorityvalues.priorityvalues_statemachine import PriorityValues
from tests.vtimer.virtual_timer import *

# Unit TestCase for PriorityValues
class PriorityvaluesTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = PriorityValues()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_transitionPriority(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_event1()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_c))
		
	def test_regionPriority(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.someregion_a))
		self.statemachine.sci_interface.raise_event2()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.someregion_b))
		self.assertTrue(not self.statemachine.is_state_active(self.statemachine.State.main_region_e))
		
