
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from childfirstexecutionhierarchy.childfirstexecutionhierarchy_statemachine import ChildFirstExecutionHierarchy
from tests.vtimer.virtual_timer import *

# Unit TestCase for ChildFirstExecutionHierarchy
class ChildfirstexecutionhierarchyTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = ChildFirstExecutionHierarchy()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_childShouldTakeTransition(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirstexecutionhierarchy_r_a_r_aa_r_aaa))
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirstexecutionhierarchy_r_b))
		self.assertTrue(not self.statemachine.sci_interface.a_reacted)
		self.assertTrue(not self.statemachine.sci_interface.aa_reacted)
		self.assertTrue(self.statemachine.sci_interface.aaa_reacted)
		self.assertNoLocalReaction()
		
	def test_parentShouldTakeTransition(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirstexecutionhierarchy_r_a_r_aa_r_aaa))
		self.statemachine.sci_interface.disable_aaa = True
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirstexecutionhierarchy_r_b))
		self.assertTrue(not self.statemachine.sci_interface.a_reacted)
		self.assertTrue(self.statemachine.sci_interface.aa_reacted)
		self.assertTrue(not self.statemachine.sci_interface.aaa_reacted)
		self.assertTrue(not self.statemachine.sci_interface.a_local)
		self.assertTrue(not self.statemachine.sci_interface.aa_local)
		self.assertTrue(self.statemachine.sci_interface.aaa_local)
		
	def test_grandparentShouldTakeTransition(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirstexecutionhierarchy_r_a_r_aa_r_aaa))
		self.statemachine.sci_interface.disable_aa = True
		self.statemachine.sci_interface.disable_aaa = True
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirstexecutionhierarchy_r_b))
		self.assertTrue(self.statemachine.sci_interface.a_reacted)
		self.assertTrue(not self.statemachine.sci_interface.aa_reacted)
		self.assertTrue(not self.statemachine.sci_interface.aaa_reacted)
		self.assertTrue(not self.statemachine.sci_interface.a_local)
		self.assertTrue(self.statemachine.sci_interface.aa_local)
		self.assertTrue(self.statemachine.sci_interface.aaa_local)
		
	def test_expectLocalReactrionsExecuteWithNoTransition(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirstexecutionhierarchy_r_a_r_aa_r_aaa))
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.childfirstexecutionhierarchy_r_a_r_aa_r_aaa))
		self.assertTrue(self.statemachine.sci_interface.a_local)
		self.assertTrue(self.statemachine.sci_interface.aa_local)
		self.assertTrue(self.statemachine.sci_interface.aaa_local)
		
	def assertNoLocalReaction(self):
		self.assertTrue(not self.statemachine.sci_interface.a_local)
		self.assertTrue(not self.statemachine.sci_interface.aa_local)
		self.assertTrue(not self.statemachine.sci_interface.aaa_local)
		
