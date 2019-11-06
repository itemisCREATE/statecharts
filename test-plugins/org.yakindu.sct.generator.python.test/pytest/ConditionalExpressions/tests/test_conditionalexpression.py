
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from conditionalexpressions.conditionalexpressions_statemachine import ConditionalExpressions
from tests.vtimer.virtual_timer import *

# Unit TestCase for ConditionalExpressions
class ConditionalexpressionTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = ConditionalExpressions()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_conditionalExpressionTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.assertTrue(self.statemachine.sci_interface.condition == 1)
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		self.assertTrue(self.statemachine.sci_interface.condition == 2)
		
