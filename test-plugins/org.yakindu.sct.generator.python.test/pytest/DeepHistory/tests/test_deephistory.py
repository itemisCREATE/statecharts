
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from deephistory.deephistory_statemachine import DeepHistory
from tests.vtimer.virtual_timer import *

# Unit TestCase for DeepHistory
class DeephistoryTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = DeepHistory()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_deepHistoryTest(self):
		self.statemachine.enter()
		self.statemachine.sci_interface.raise_event1()
		self.timer.cycle_leap(1)
		self.statemachine.sci_interface.raise_event3()
		self.timer.cycle_leap(1)
		self.statemachine.sci_interface.raise_event5()
		self.timer.cycle_leap(1)
		self.statemachine.sci_interface.raise_event7()
		self.timer.cycle_leap(1)
		self.assertTrue(not self.statemachine.is_state_active(self.statemachine.State.mainregion_state1))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.mainregion_state2__region0_state4__region0_state7__region0_state9))
		self.statemachine.sci_interface.raise_event2()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.mainregion_state1))
		self.assertTrue(not self.statemachine.is_state_active(self.statemachine.State.mainregion_state2__region0_state4__region0_state7__region0_state9))
		self.statemachine.sci_interface.raise_event1()
		self.timer.cycle_leap(1)
		self.assertTrue(not self.statemachine.is_state_active(self.statemachine.State.mainregion_state1))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.mainregion_state2__region0_state4__region0_state7__region0_state9))
		
