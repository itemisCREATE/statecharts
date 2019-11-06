
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from samenamedifferentregion.samenamedifferentregion_statemachine import SameNameDifferentRegion
from tests.vtimer.virtual_timer import *

# Unit TestCase for SameNameDifferentRegion
class SamenamedifferentregionTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = SameNameDifferentRegion()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_sameNameDifferenRegionTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_statea))
		self.statemachine.sci_interface.raise_e1()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_stateb))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_stateb_r1_statea))
		self.statemachine.sci_interface.raise_e1()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_stateb))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_stateb_r1_stateb))
		
