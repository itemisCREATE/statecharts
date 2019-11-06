
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from eventdriveninternalevent.eventdriveninternalevent_statemachine import EventDrivenInternalEvent
from tests.vtimer.virtual_timer import *

# Unit TestCase for EventDrivenInternalEvent
class EventdriveninternaleventTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = EventDrivenInternalEvent()
		self.statemachine.init()

	def tearDown(self):
		self.statemachine.exit()
	
	def test_checkInternlEventQueueing(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriveninternalevent_r1_a))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriveninternalevent_r2_c))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriveninternalevent_check_valid))
		self.statemachine.sci_interface.raise_start()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriveninternalevent_r1_b))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriveninternalevent_r2_d))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.eventdriveninternalevent_check_valid))
		self.assertTrue(self.statemachine.sci_interface.i1_sequence == 2)
		self.assertTrue(self.statemachine.sci_interface.i2_sequence == 3)
		self.statemachine.exit()
		
