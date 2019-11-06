
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from guardedexit.guardedexit_statemachine import GuardedExit
from tests.vtimer.virtual_timer import *

# Unit TestCase for GuardedExit
class GuardedexitTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = GuardedExit()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_exitTaken(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.assertTrue(not self.statemachine.sci_interface.guard)
		self.checkDone(False)
		
	def test_exitNotTaken(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.guard = True
		self.checkDone(True)
		
	def checkDone(self, shouldBeDone):
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		self.assertTrue(self.statemachine.sci_interface.done if shouldBeDone else not self.statemachine.sci_interface.done)
		
