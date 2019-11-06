
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from eventdriventriggeredbyevent.eventdriventriggeredbyevent_statemachine import EventDrivenTriggeredByEvent
from tests.vtimer.virtual_timer import *

# Unit TestCase for EventDrivenTriggeredByEvent
class EventdriventriggeredbyeventTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = EventDrivenTriggeredByEvent()
		self.timer = VirtualTimer(200)
		self.statemachine.set_timer(self.timer)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.unset_timer()
		self.statemachine.exit()
	
	def test_internalEventTriggersRunCycle(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriventriggeredbyevent_main_region_a))
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriventriggeredbyevent_main_region_b))
		self.assertTrue(self.statemachine.sci_interface.x == 0)
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriventriggeredbyevent_main_region_a))
		self.assertTrue(self.statemachine.sci_interface.x == 0)
		self.statemachine.exit()
		
	def test_proceedTimeDoesNotTriggerRunCycle(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriventriggeredbyevent_main_region_a))
		self.timer.time_leap(120*1000)
		self.assertTrue(self.statemachine.sci_interface.x == 0)
		self.statemachine.exit()
		
