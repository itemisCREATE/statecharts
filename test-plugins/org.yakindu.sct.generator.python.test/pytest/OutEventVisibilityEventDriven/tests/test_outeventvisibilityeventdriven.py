
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from outeventvisibilityeventdriven.outeventvisibilityeventdriven_statemachine import OutEventVisibilityEventDriven
from tests.vtimer.virtual_timer import *

# Unit TestCase for OutEventVisibilityEventDriven
class OuteventvisibilityeventdrivenTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = OutEventVisibilityEventDriven()
		self.statemachine.init()

	def tearDown(self):
		self.statemachine.exit()
	
	def test_out_events_must_be_collected_during_local_event_processing_steps(self):
		self.statemachine.enter()
		self.statemachine.sci_interface.raise_i(1)
		self.assertTrue(self.statemachine.sci_interface.o1)
		self.assertTrue(self.statemachine.sci_interface.o2)
		self.statemachine.exit()
		
	def test_all_out_events_that_are_raised_within_a_single_step_must_be_visible(self):
		self.statemachine.enter()
		self.assertTrue(not self.statemachine.sci_interface.o1)
		self.assertTrue(not self.statemachine.sci_interface.o2)
		self.statemachine.sci_interface.raise_i(2)
		self.assertTrue(self.statemachine.sci_interface.o1)
		self.assertTrue(not self.statemachine.sci_interface.o2)
		self.statemachine.sci_interface.raise_i(2)
		self.assertTrue(not self.statemachine.sci_interface.o1)
		self.assertTrue(self.statemachine.sci_interface.o2)
		self.statemachine.sci_interface.raise_i(2)
		self.assertTrue(self.statemachine.sci_interface.o1)
		self.assertTrue(self.statemachine.sci_interface.o2)
		self.statemachine.exit()
		
