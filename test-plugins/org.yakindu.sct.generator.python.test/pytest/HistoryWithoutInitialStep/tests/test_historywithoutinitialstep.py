
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from historywithoutinitialstep.historywithoutinitialstep_statemachine import HistoryWithoutInitialStep
from tests.vtimer.virtual_timer import *

# Unit TestCase for HistoryWithoutInitialStep
class HistorywithoutinitialstepTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = HistoryWithoutInitialStep()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_enterThroughInitialEntry(self):
		self.init()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c))
		self.statemachine.sci_interface.raise_next()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_d))
		
	def test_enterCThroughHistory(self):
		self.init()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c))
		self.statemachine.sci_interface.raise_toa()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_tohistory()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c))
		
	def test_enterDThroughHistory(self):
		self.init()
		self.statemachine.sci_interface.raise_next()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_d))
		self.statemachine.sci_interface.raise_toa()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_tohistory()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_d))
		
	def test_enterThroughHistoryWithoutInit(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_tohistory()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c))
		
	def init(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_tob()
		self.timer.cycle_leap(1)
		
