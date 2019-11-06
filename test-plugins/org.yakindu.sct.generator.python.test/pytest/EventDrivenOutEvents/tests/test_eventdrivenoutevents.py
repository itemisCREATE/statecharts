
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from eventdrivenoutevents.eventdrivenoutevents_statemachine import EventDrivenOutEvents
from tests.vtimer.virtual_timer import *

# Unit TestCase for EventDrivenOutEvents
class EventdrivenouteventsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = EventDrivenOutEvents()
		self.statemachine.init()

	def tearDown(self):
		self.statemachine.exit()
	
	def test_test(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_statea))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.second_region_statec))
		self.statemachine.sci_interface.raise_e1()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_stateb))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.second_region_stated))
		self.statemachine.exit()
		
