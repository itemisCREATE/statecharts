
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from timedtransitions.timedtransitions_statemachine import TimedTransitions
from tests.vtimer.virtual_timer import *

# Unit TestCase for TimedTransitions
class TimedtransitionsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = TimedTransitions()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.set_timer(self.timer)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.unset_timer()
		self.statemachine.exit()
	
	def test_timer01(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_start))
		self.timer.time_leap(2030)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_end))
		
	def test_timer02(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_start))
		self.timer.time_leap(2*1000)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_end))
		
	def test_noAdditionalCycle(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_start))
		self.timer.time_leap(1950)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_start))
		self.timer.time_leap(100)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_end))
		
	def test_countCycles(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_start))
		self.assertTrue((self.statemachine.sci_interface.cycles == 0))
		self.assertTrue((self.statemachine.sci_interface.seconds == 0))
		self.timer.time_leap(100)
		self.assertTrue((self.statemachine.sci_interface.cycles == 0))
		self.assertTrue((self.statemachine.sci_interface.seconds == 0))
		self.timer.time_leap(100)
		self.assertTrue((self.statemachine.sci_interface.cycles == 1))
		self.assertTrue((self.statemachine.sci_interface.seconds == 0))
		self.timer.time_leap(800)
		self.assertTrue((self.statemachine.sci_interface.cycles == 5))
		self.assertTrue((self.statemachine.sci_interface.seconds == 1))
		
