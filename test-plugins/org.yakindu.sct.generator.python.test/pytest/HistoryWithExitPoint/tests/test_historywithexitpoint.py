
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from historywithexitpoint.historywithexitpoint_statemachine import HistoryWithExitPoint
from tests.vtimer.virtual_timer import *

# Unit TestCase for HistoryWithExitPoint
class HistorywithexitpointTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = HistoryWithExitPoint()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_historyEntryAfterExit(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.mr_a_r_x1))
		self.statemachine.sci_interface.raise_push()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.mr_b))
		self.statemachine.sci_interface.raise_back()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.mr_a_r_x1))
		self.statemachine.sci_interface.raise_next()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.mr_a_r_x2))
		self.statemachine.sci_interface.raise_push()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.mr_b))
		self.statemachine.sci_interface.raise_back()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.mr_a_r_x2))
		
