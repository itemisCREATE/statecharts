
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from booleanexpressions.booleanexpressions_statemachine import BooleanExpressions
from tests.vtimer.virtual_timer import *

# Unit TestCase for BooleanExpressions
class BooleanexpressionsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = BooleanExpressions()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_booleanExpressions(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_statea))
		self.assertTrue(self.statemachine.sci_interface.mybool1 == True)
		self.assertTrue(self.statemachine.sci_interface.mybool2 == False)
		self.statemachine.sci_interface.raise_e1()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_stateb))
		self.assertTrue(self.statemachine.sci_interface.and_variable == False)
		self.assertTrue(self.statemachine.sci_interface.or_variable == True)
		self.assertTrue(self.statemachine.sci_interface.not_variable == False)
		self.assertTrue(self.statemachine.sci_interface.equal == False)
		self.assertTrue(self.statemachine.sci_interface.notequal == True)
		
