
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from integerexpressions.integerexpressions_statemachine import IntegerExpressions
from tests.vtimer.virtual_timer import *

# Unit TestCase for IntegerExpressions
class IntegerexpressionsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = IntegerExpressions()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_integerExpressions(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_statea))
		self.assertTrue(self.statemachine.sci_interface.myint1 == 10)
		self.assertTrue(self.statemachine.sci_interface.myint2 == 5)
		self.statemachine.sci_interface.raise_e1()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.less == False)
		self.assertTrue(self.statemachine.sci_interface.greater == True)
		self.assertTrue(self.statemachine.sci_interface.equalorless == False)
		self.assertTrue(self.statemachine.sci_interface.equalorgreater == True)
		self.assertTrue(self.statemachine.sci_interface.equal == False)
		self.assertTrue(self.statemachine.sci_interface.notequal == True)
		self.assertTrue(self.statemachine.sci_interface.plus == 15)
		self.assertTrue(self.statemachine.sci_interface.minus == 5)
		self.assertTrue(self.statemachine.sci_interface.multiply == 50)
		self.assertTrue(self.statemachine.sci_interface.division == 2)
		self.assertTrue(self.statemachine.sci_interface.modulo == 0)
		self.assertTrue(self.statemachine.sci_interface.negat == - 10 )
		self.assertTrue(self.statemachine.sci_interface.multiassign == 20)
		self.assertTrue(self.statemachine.sci_interface.divassign == 2)
		self.assertTrue(self.statemachine.sci_interface.plusassign == 12)
		self.assertTrue(self.statemachine.sci_interface.minusassign == - 8 )
		self.assertTrue(self.statemachine.sci_interface.moduloassign == 0)
		self.assertTrue(self.statemachine.sci_interface.decrementassign == 0)
		self.assertTrue(self.statemachine.sci_interface.decrement == 1)
		self.assertTrue(self.statemachine.sci_interface.incrementassign == 0)
		self.assertTrue(self.statemachine.sci_interface.increment == 1)
		
