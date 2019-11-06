
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from staticchoice.staticchoice_statemachine import StaticChoice
from tests.vtimer.virtual_timer import *

# Unit TestCase for StaticChoice
class StaticchoiceTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = StaticChoice()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_staticChoiceTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_start))
		self.timer.cycle_leap(1)
		
