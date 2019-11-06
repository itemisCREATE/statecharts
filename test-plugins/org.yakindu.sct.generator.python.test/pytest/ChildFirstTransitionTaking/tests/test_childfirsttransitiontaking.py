
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from childfirsttransitiontaking.childfirsttransitiontaking_statemachine import ChildFirstTransitionTaking
from tests.vtimer.virtual_timer import *

# Unit TestCase for ChildFirstTransitionTaking
class ChildfirsttransitiontakingTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = ChildFirstTransitionTaking()
		self.statemachine.init()

	def tearDown(self):
		self.statemachine.exit()
	
	def test_testParentTransitionFromSimpleState(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r1_a_r1_aa))
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r1_b))
		self.statemachine.exit()
		
	def test_testParentTransitionFromOrthogonalChildState(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r1_a_r1_aa))
		self.statemachine.sci_interface.raise_go()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r1_a_r1_ab_r1_aba))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r1_a_r1_ab_r2_abb))
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r1_b))
		self.statemachine.exit()
		
	def test_testParentLocalReactionOnTransition(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r1_a_r1_aa))
		self.statemachine.sci_interface.raise_go()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r1_a_r1_ab_r1_aba))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r1_a_r1_ab_r2_abb))
		self.statemachine.sci_interface.raise_go()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r1_a_r1_aa))
		self.statemachine.exit()
		
	def test_testLocalReactionsOnTransitionsParentScope(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r2_c_r_ca_r_caa))
		self.assertTrue(self.statemachine.sci_interface.clocalreaction == 0)
		self.assertTrue(self.statemachine.sci_interface.calocalreaction == 0)
		self.statemachine.sci_interface.raise_go()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r2_c_r_ca_r_cab))
		self.assertTrue(self.statemachine.sci_interface.clocalreaction == 1)
		self.assertTrue(self.statemachine.sci_interface.calocalreaction == 1)
		self.statemachine.sci_interface.raise_go()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r2_c_r_ca_r_caa))
		self.assertTrue(self.statemachine.sci_interface.clocalreaction == 2)
		self.assertTrue(self.statemachine.sci_interface.calocalreaction == 2)
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r2_c_r_cb))
		self.assertTrue(self.statemachine.sci_interface.clocalreaction == 3)
		self.assertTrue(self.statemachine.sci_interface.calocalreaction == 2)
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirsttransitiontaking_r2_c_r_ca))
		self.assertTrue(self.statemachine.sci_interface.clocalreaction == 4)
		self.assertTrue(self.statemachine.sci_interface.calocalreaction == 2)
		
