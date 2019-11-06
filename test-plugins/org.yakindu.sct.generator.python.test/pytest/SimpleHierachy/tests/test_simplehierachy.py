
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from simplehierachy.simplehierachy_statemachine import SimpleHierachy
from tests.vtimer.virtual_timer import *

# Unit TestCase for SimpleHierachy
class SimplehierachyTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = SimpleHierachy()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_simpleHierachyTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_event1()
		self.statemachine.sci_interface.raise_event1()
		self.statemachine.sci_interface.raise_event1()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_subregion1_b1))
		
