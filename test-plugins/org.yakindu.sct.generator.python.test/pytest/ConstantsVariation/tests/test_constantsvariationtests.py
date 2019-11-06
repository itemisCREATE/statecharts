
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from constantsvariation.constantsvariation_statemachine import ConstantsVariation
from tests.vtimer.virtual_timer import *

# Unit TestCase for ConstantsVariation
class ConstantsvariationtestsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = ConstantsVariation()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_constantDefinition(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_statea))
		self.assertTrue(self.statemachine.sci_interface.B2 == True)
		self.assertTrue(self.statemachine.sci_named.B == True)
		self.assertTrue(self.statemachine.sci_interface.I2 == 5)
		self.assertTrue(self.statemachine.sci_named.I == 5)
		self.assertTrue(self.statemachine.sci_interface.R2 == 5)
		self.assertTrue(self.statemachine.sci_named.R == 5)
		self.assertTrue(self.statemachine.sci_interface.STR2 == "String")
		self.assertTrue(self.statemachine.sci_named.STR == "String")
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_final())
		
