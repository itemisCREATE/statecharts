
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from localevents.localevents_statemachine import localEvents
from tests.vtimer.virtual_timer import *

# Unit TestCase for localEvents
class LocaleventsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = localEvents()
		self.statemachine.init()

	def tearDown(self):
		self.statemachine.exit()
	
	def test_test(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.localevents_r1_comp1_r_a1))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.localevents_r2_comp2_r_a2))
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.localevents_r1_comp1_r_d1))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.localevents_r2_comp2_r_d2))
		self.assertTrue(self.statemachine.sci_interface.cyclecountsm == 5)
		self.assertTrue(self.statemachine.sci_interface.cyclecount1 == 5)
		self.assertTrue(self.statemachine.sci_interface.cyclecount2 == 5)
		self.assertTrue(self.statemachine.sci_interface.checksum == 3)
		self.statemachine.exit()
		

if __name__ == '__main__':
    unittest.main()
