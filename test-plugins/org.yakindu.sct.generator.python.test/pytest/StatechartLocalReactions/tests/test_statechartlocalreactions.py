
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from statechartlocalreactions.statechartlocalreactions_statemachine import StatechartLocalReactions
from tests.vtimer.virtual_timer import *

# Unit TestCase for StatechartLocalReactions
class StatechartlocalreactionsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = StatechartLocalReactions()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_statechartLocalReactionsTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_s1))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.region2_a))
		cycles = 0
		while (cycles < 10):
			self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.region2_a))
			if (self.statemachine.sci_interface.myint%2 == 0) {
				self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_s1))
			}
			else {
				self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_s2))
			}
			self.timer.cycle_leap(1)
			cycles += 1
			self.assertTrue((self.statemachine.sci_interface.myint == cycles))
		
