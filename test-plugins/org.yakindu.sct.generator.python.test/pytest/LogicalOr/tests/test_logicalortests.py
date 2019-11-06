
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from logicalor.logicalor_statemachine import LogicalOr
from tests.vtimer.virtual_timer import *

# Unit TestCase for LogicalOr
class LogicalortestsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = LogicalOr()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_operandEvaluationOrder(self):
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.x == 4 and self.statemachine.sci_interface.b, 'logical or expression was executed in wrong order...')
		
