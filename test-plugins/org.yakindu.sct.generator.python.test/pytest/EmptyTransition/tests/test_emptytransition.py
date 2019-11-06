
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from emptytransition.emptytransition_statemachine import EmptyTransition
from tests.vtimer.virtual_timer import *

# Unit TestCase for EmptyTransition
class EmptytransitionTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = EmptyTransition()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_emptyTransitionTest(self):
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.assertTrue(not self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		
