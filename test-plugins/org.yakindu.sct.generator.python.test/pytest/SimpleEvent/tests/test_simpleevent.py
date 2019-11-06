
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from simpleevent.simpleevent_statemachine import SimpleEvent
from tests.vtimer.virtual_timer import *

# Unit TestCase for SimpleEvent
class SimpleeventTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = SimpleEvent()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_simpleEventTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a), 'Expected A to be active')
		self.assertTrue(5 == 5)
		self.statemachine.sci_interface.raise_event1()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b), 'Expected B to be active')
		self.timer.cycle_leap(1)
		self.assertTrue(not self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		
