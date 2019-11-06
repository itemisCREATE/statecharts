
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from constants.constants_statemachine import Constants
from tests.vtimer.virtual_timer import *

# Unit TestCase for Constants
class ConstantstestsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = Constants()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_constantDefinition(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.assertTrue(self.statemachine.sci_interface.X == 10)
		self.assertTrue(self.statemachine.sci_interface.Y == 20)
		self.assertTrue(self.statemachine.sci_named.Y == "Hello World")
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.result == 20)
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_c))
		self.assertTrue(self.statemachine.sci_interface.result == 100)
		self.statemachine.sci_interface.raise_e2(self.statemachine.sci_interface.X)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.result == 1000)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		
