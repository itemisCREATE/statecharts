
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from nolocalevents.nolocalevents_statemachine import NoLocalEvents
from tests.vtimer.virtual_timer import *

# Unit TestCase for NoLocalEvents
class NolocaleventsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = NoLocalEvents()
		self.statemachine.init()

	def tearDown(self):
		self.statemachine.exit()
	
	def test_test(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.nolocalevents_main_region_statea))
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.nolocalevents_main_region_stateb))
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.nolocalevents_main_region_statea))
		self.assertTrue((self.statemachine.sci_interface.x == 0))
		self.statemachine.sci_interface.raise_i(42)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.nolocalevents_main_region_stateb))
		self.assertTrue((self.statemachine.sci_interface.x == 42))
		self.statemachine.exit()
		
