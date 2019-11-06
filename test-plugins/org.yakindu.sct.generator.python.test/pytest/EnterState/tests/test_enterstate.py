
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from enterstate.enterstate_statemachine import EnterState
from tests.vtimer.virtual_timer import *

# Unit TestCase for EnterState
class EnterstateTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = EnterState()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_defaultEntry(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r_a))
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r_b_r_e))
		
	def test_namedEntryThroughNamedTransition(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r_a))
		self.statemachine.sci_interface.raise_f()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r_b_r_f))
		
	def test_namedEntryThroughDefaultTransition(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r_a))
		self.statemachine.sci_interface.raise_g()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.r_b_r_e))
		
