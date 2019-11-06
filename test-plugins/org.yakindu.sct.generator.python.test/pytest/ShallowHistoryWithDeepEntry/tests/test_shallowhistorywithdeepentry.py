
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from shallowhistorywithdeepentry.shallowhistorywithdeepentry_statemachine import ShallowHistoryWithDeepEntry
from tests.vtimer.virtual_timer import *

# Unit TestCase for ShallowHistoryWithDeepEntry
class ShallowhistorywithdeepentryTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = ShallowHistoryWithDeepEntry()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_noDeepEntryWithinHistory(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_y))
		self.statemachine.sci_interface.raise_toz()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_z__region0_a))
		self.statemachine.sci_interface.raise_toy()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_y))
		self.statemachine.sci_interface.raise_toz()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_z__region0_a))
		
	def test_deepEntryWithinHistory(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_y))
		self.statemachine.sci_interface.raise_toz()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_z__region0_a))
		self.statemachine.sci_interface.raise_toc()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_z__region0_b__region0_c))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_z__region0_b))
		self.statemachine.sci_interface.raise_toy()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_y))
		self.statemachine.sci_interface.raise_toz()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_z__region0_b__region0_c))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_z__region0_b))
		
	def test_directDeepEntryIntoHistory(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_y))
		self.statemachine.sci_interface.raise_toc()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_z__region0_b__region0_c))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_z__region0_b))
		self.statemachine.sci_interface.raise_toy()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_y))
		self.statemachine.sci_interface.raise_toz()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_z__region0_b__region0_c))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_z__region0_b))
		
