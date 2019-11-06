
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from parentfirstlocalreactions.parentfirstlocalreactions_statemachine import ParentFirstLocalReactions
from tests.vtimer.virtual_timer import *

# Unit TestCase for ParentFirstLocalReactions
class ParentfirstlocalreactionsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = ParentFirstLocalReactions()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_expectBottomUpLocalReactionOrder(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.parentfirstlocalreactions_r_a_r_aa_r_aaa))
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.parentfirstlocalreactions_r_a_r_aa_r_aaa))
		self.assertTrue(self.statemachine.sci_interface.sm_local == 1)
		self.assertTrue(self.statemachine.sci_interface.a_local == 2)
		self.assertTrue(self.statemachine.sci_interface.aa_local == 3)
		self.assertTrue(self.statemachine.sci_interface.aaa_local == 4)
		
	def test_expectParentLocalReactionOnChildLocalTransition(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.parentfirstlocalreactions_r_a_r_aa_r_aaa))
		self.statemachine.sci_interface.raise_e()
		self.statemachine.sci_interface.disable_a = True
		self.statemachine.sci_interface.disable_aa = True
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.parentfirstlocalreactions_r_a_r_aa_r_aab))
		self.assertTrue(self.statemachine.sci_interface.sm_local == 1)
		self.assertTrue(self.statemachine.sci_interface.a_local == 2)
		self.assertTrue(self.statemachine.sci_interface.aa_local == 3)
		self.assertTrue(self.statemachine.sci_interface.aaa_local == 0)
		
	def test_expectGrandparentLocalReactionOnParentLocalTransition(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.parentfirstlocalreactions_r_a_r_aa_r_aaa))
		self.statemachine.sci_interface.disable_a = True
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.parentfirstlocalreactions_r_a_r_ab))
		self.assertTrue(self.statemachine.sci_interface.sm_local == 1)
		self.assertTrue(self.statemachine.sci_interface.a_local == 2)
		self.assertTrue(self.statemachine.sci_interface.aa_local == 0)
		self.assertTrue(self.statemachine.sci_interface.aaa_local == 0)
		
	def test_expectNoLocalReactionOnGrandparentTransition(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.parentfirstlocalreactions_r_a_r_aa_r_aaa))
		self.statemachine.sci_interface.disable_aaa = True
		self.statemachine.sci_interface.disable_aa = True
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.parentfirstlocalreactions_r_b))
		self.assertTrue(self.statemachine.sci_interface.sm_local == 1)
		self.assertTrue(self.statemachine.sci_interface.a_local == 0)
		self.assertTrue(self.statemachine.sci_interface.aa_local == 0)
		self.assertTrue(self.statemachine.sci_interface.aaa_local == 0)
		
