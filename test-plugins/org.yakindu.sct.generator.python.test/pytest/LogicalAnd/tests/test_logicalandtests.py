
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from logicaland.logicaland_statemachine import LogicalAnd
from tests.vtimer.virtual_timer import *

# Unit TestCase for LogicalAnd
class LogicalandtestsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = LogicalAnd()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_operandEvaluationOrder(self):
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.x == 4 and self.statemachine.sci_interface.b, 'logical and expression was executed in wrong order...')
		
