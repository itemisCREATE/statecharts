
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from transitionhandlesmultipleexits.transitionhandlesmultipleexits_statemachine import TransitionHandlesMultipleExits
from tests.vtimer.virtual_timer import *

# Unit TestCase for TransitionHandlesMultipleExits
class TransitionhandlesmultipleexistsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = TransitionHandlesMultipleExits()
		self.statemachine.init()

	def tearDown(self):
		self.statemachine.exit()
	
	def test_testTransitionHandling2Of2Exits(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.transitionhandlesmultipleexits_main_region_a_r_aa))
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.transitionhandlesmultipleexits_main_region_b_r_bb))
		self.assertTrue(self.statemachine.sci_interface.x == 1)
		self.statemachine.exit()
		self.statemachine.enter()
		self.statemachine.sci_interface.x = 0
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.transitionhandlesmultipleexits_main_region_a_r_aa))
		self.statemachine.sci_interface.raise_f()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.transitionhandlesmultipleexits_main_region_b_r_bb))
		self.assertTrue(self.statemachine.sci_interface.x == 2)
		
	def test_testTransitionHandling2Of3Exits(self):
		self.statemachine.enter()
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.transitionhandlesmultipleexits_main_region_b_r_bb))
		self.statemachine.sci_interface.x = 0
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.transitionhandlesmultipleexits_main_region_a_r_aa))
		self.assertTrue(self.statemachine.sci_interface.x == 11)
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.transitionhandlesmultipleexits_main_region_b_r_bb))
		self.statemachine.sci_interface.x = 0
		self.statemachine.sci_interface.raise_g()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.transitionhandlesmultipleexits_main_region_a_r_aa))
		self.assertTrue(self.statemachine.sci_interface.x == 10)
		self.statemachine.exit()
		
	def test_testTransitionHandling1Of3Exits(self):
		self.statemachine.enter()
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.transitionhandlesmultipleexits_main_region_b_r_bb))
		self.statemachine.sci_interface.x = 0
		self.statemachine.sci_interface.raise_f()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.transitionhandlesmultipleexits_main_region_a_r_aa))
		self.assertTrue(self.statemachine.sci_interface.x == 24)
		self.statemachine.exit()
		
