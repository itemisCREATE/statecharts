
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from entryexitselftransition.entryexitselftransition_statemachine import EntryExitSelfTransition
from tests.vtimer.virtual_timer import *

# Unit TestCase for EntryExitSelfTransition
class EntryexitselftransitionTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = EntryExitSelfTransition()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_selfTransitionToChildState(self):
		self.init()
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.entries == 1)
		self.assertTrue(self.statemachine.sci_interface.exits == 1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a__region0_c))
		self.statemachine.exit()
		
	def test_selfTransitionFromChildState(self):
		self.init()
		self.statemachine.sci_interface.raise_e1()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.entries == 0)
		self.assertTrue(self.statemachine.sci_interface.exits == 0)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a__region0_c))
		self.statemachine.sci_interface.raise_e1()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a__region0_b))
		self.assertTrue(self.statemachine.sci_interface.entries == 1)
		self.assertTrue(self.statemachine.sci_interface.exits == 1)
		self.statemachine.exit()
		
	def init(self):
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.entries == 1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a__region0_b))
		self.statemachine.sci_interface.entries = 0
		
