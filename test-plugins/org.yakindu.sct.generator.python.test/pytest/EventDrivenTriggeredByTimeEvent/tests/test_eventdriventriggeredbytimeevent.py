
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from eventdriventriggeredbytimeevent.eventdriventriggeredbytimeevent_statemachine import EventDrivenTriggeredByTimeEvent
from tests.vtimer.virtual_timer import *

# Unit TestCase for EventDrivenTriggeredByTimeEvent
class EventdriventriggeredbytimeeventTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = EventDrivenTriggeredByTimeEvent()
		self.timer = VirtualTimer(200)
		self.statemachine.set_timer(self.timer)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.unset_timer()
		self.statemachine.exit()
	
	def test_timeEventTriggersRunCycle(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriventriggeredbytimeevent_r_a))
		self.assertTrue(self.statemachine.sci_interface.x == 0)
		self.timer.time_leap(999)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriventriggeredbytimeevent_r_a))
		self.assertTrue(self.statemachine.sci_interface.x == 0)
		self.timer.time_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriventriggeredbytimeevent_r_b))
		self.assertTrue(self.statemachine.sci_interface.x == 0)
		self.assertTrue(self.statemachine.sci_interface.transition_count == 1)
		self.timer.time_leap(1*1000)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriventriggeredbytimeevent_r_a))
		self.assertTrue(self.statemachine.sci_interface.x == 0)
		self.assertTrue(self.statemachine.sci_interface.transition_count == 2)
		self.timer.time_leap(999*1000)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriventriggeredbytimeevent_r_b))
		self.assertTrue(self.statemachine.sci_interface.x == 0)
		self.assertTrue(self.statemachine.sci_interface.transition_count == 1001)
		self.timer.time_leap(999*1000)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriventriggeredbytimeevent_r_a))
		self.assertTrue(self.statemachine.sci_interface.x == 0)
		self.assertTrue(self.statemachine.sci_interface.transition_count == 2000)
		self.statemachine.exit()
		
