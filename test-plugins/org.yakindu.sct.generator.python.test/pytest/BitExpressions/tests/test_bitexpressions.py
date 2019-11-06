
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from bitexpressions.bitexpressions_statemachine import BitExpressions
from tests.vtimer.virtual_timer import *

# Unit TestCase for BitExpressions
class BitexpressionsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = BitExpressions()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_bitExpressions(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_statea))
		self.assertTrue(self.statemachine.sci_interface.mybit1 == 5)
		self.assertTrue(self.statemachine.sci_interface.mybit2 == 7)
		self.statemachine.sci_interface.raise_e1()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_stateb))
		self.assertTrue(self.statemachine.sci_interface.leftbitshift == 10)
		self.assertTrue(self.statemachine.sci_interface.rightbitshift == 2)
		self.assertTrue(self.statemachine.sci_interface.complementbitshift == - 6 )
		self.assertTrue(self.statemachine.sci_interface.bitwiseand == 5)
		self.assertTrue(self.statemachine.sci_interface.bitwiseor == 7)
		self.assertTrue(self.statemachine.sci_interface.bitwisexor == 2)
		
