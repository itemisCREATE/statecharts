
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from ineventlifecycle.ineventlifecycle_statemachine import InEventLifeCycle
from tests.vtimer.virtual_timer import *

# Unit TestCase for InEventLifeCycle
class IneventlifecycleTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = InEventLifeCycle()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_eventLifeCycle(self):
		self.statemachine.enter()
		self.statemachine.sci_interface.raise_e()
		self.assertTrue(self.statemachine.sci_interface.i == 0)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.i == 1)
		
