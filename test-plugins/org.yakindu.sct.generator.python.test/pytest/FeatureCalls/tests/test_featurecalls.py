
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from featurecalls.featurecalls_statemachine import FeatureCalls
from tests.vtimer.virtual_timer import *

# Unit TestCase for FeatureCalls
class FeaturecallsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = FeatureCalls()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_featureCalls(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		
