
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from castexpressions.castexpressions_statemachine import CastExpressions
from tests.vtimer.virtual_timer import *

# Unit TestCase for CastExpressions
class CastexpressionsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = CastExpressions()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_castExpressionTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.sci_interface.realvalue == 5)
		self.assertTrue(self.statemachine.sci_interface.intvalue == 5)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.realvalue == 15)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_c))
		self.assertTrue(self.statemachine.sci_interface.realvalue == 757)
		
