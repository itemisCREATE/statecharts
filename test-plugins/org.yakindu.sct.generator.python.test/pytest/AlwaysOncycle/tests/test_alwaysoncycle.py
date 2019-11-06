
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from alwaysoncycle.alwaysoncycle_statemachine import AlwaysOncycle
from tests.vtimer.virtual_timer import *

# Unit TestCase for AlwaysOncycle
class AlwaysoncycleTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = AlwaysOncycle()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_alwaysOnCycleTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_statea))
		count = 0
		while (count < 5):
			self.timer.cycle_leap(1)
			self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_statea))
			count+1
		self.assertTrue((self.statemachine.sci_interface.value == 5))
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_stateb))
		self.assertTrue(self.statemachine.sci_interface.value == 0)
		count = 0
		while (count < 5):
			self.timer.cycle_leap(1)
			self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_stateb))
			count+1
		self.assertTrue((self.statemachine.sci_interface.value == 5))
		self.assertTrue((self.statemachine.sci_interface.x == 5))
		self.assertTrue((self.statemachine.sci_interface.y == 5))
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_statea))
		self.assertTrue(self.statemachine.sci_interface.value == 0)
		
