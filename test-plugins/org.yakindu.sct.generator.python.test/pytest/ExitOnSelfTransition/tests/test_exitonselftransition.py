
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from exitonselftransition.exitonselftransition_statemachine import ExitOnSelfTransition
from tests.vtimer.virtual_timer import *

# Unit TestCase for ExitOnSelfTransition
class ExitonselftransitionTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = ExitOnSelfTransition()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_exitOnSelfTransitionTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.assertTrue(self.statemachine.sci_interface.entrycount == 1)
		self.assertTrue(self.statemachine.sci_interface.exitcount == 0)
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.entrycount == 2)
		self.assertTrue(self.statemachine.sci_interface.exitcount == 1)
		self.statemachine.sci_interface.raise_f()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.entrycount == 2)
		self.assertTrue(self.statemachine.sci_interface.exitcount == 2)
		
