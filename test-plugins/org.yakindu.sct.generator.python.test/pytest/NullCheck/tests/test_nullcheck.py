
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from nullcheck.nullcheck_statemachine import NullCheck
from tests.vtimer.virtual_timer import *

# Unit TestCase for NullCheck
class NullcheckTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = NullCheck()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_simpleNullCheckTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		
