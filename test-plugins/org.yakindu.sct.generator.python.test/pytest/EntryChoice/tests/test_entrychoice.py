
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from entrychoice.entrychoice_statemachine import EntryChoice
from tests.vtimer.virtual_timer import *

# Unit TestCase for EntryChoice
class EntrychoiceTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = EntryChoice()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_entryChoiceTest(self):
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		
