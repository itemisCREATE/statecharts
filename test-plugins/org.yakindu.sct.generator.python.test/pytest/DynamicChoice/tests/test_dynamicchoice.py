
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from dynamicchoice.dynamicchoice_statemachine import DynamicChoice
from tests.vtimer.virtual_timer import *

# Unit TestCase for DynamicChoice
class DynamicchoiceTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = DynamicChoice()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_dynamicChoiceTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_start))
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		
