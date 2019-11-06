
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from eventdriven.eventdriven_statemachine import eventDriven
from tests.vtimer.virtual_timer import *

# Unit TestCase for eventDriven
class EventdrivenTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = eventDriven()
		self.statemachine.init()

	def tearDown(self):
		self.statemachine.exit()
	
	def test_test(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.sci_interface.running)
		self.statemachine.sci_interface.raise_inevent()
		self.assertTrue(self.statemachine.sci_interface.oe1)
		self.assertTrue(self.statemachine.sci_interface.oe2)
		self.assertTrue(self.statemachine.sci_interface.oe3)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_stated))
		self.statemachine.sci_interface.raise_ineventbool(True)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_statee))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_statee__region0_state2))
		self.statemachine.sci_interface.raise_inevent()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_statef))
		self.statemachine.sci_namedi.raise_namedinevent()
		self.assertTrue(self.statemachine.is_final())
		self.statemachine.exit()
		
