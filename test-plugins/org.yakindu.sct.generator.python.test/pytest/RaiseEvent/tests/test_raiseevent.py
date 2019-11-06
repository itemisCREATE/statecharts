
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from raiseevent.raiseevent_statemachine import RaiseEvent
from tests.vtimer.virtual_timer import *

# Unit TestCase for RaiseEvent
class RaiseeventTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = RaiseEvent()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_raiseEvent(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.second_region_satea))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_statea))
		self.statemachine.sci_interface.raise_e2()
		self.timer.cycle_leap(1)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.second_region_stateb))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_stateb))
		
