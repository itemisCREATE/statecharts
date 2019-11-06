
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from outeventlifecycle.outeventlifecycle_statemachine import OutEventLifeCycle
from tests.vtimer.virtual_timer import *

# Unit TestCase for OutEventLifeCycle
class OuteventlifecycleTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = OutEventLifeCycle()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_availableAfterCycle(self):
		self.statemachine.enter()
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.f)
		
	def test_availableWithinCycle(self):
		self.init(False)
		self.assertTrue(self.statemachine.sci_interface.f_available_in_cycle)
		
	def test_unvailableWithin2ndCycle(self):
		self.init(True)
		self.assertTrue(not self.statemachine.sci_interface.f_available_in_next_cycle)
		
	def test_unvailableAfter2ndCycle(self):
		self.init(True)
		self.assertTrue(not self.statemachine.sci_interface.f)
		
	def init(self, sndCycle):
		self.statemachine.enter()
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		if (sndCycle) {
			self.timer.cycle_leap(1)
		}
		
