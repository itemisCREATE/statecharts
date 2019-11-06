
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from stringexpressions.stringexpressions_statemachine import StringExpressions
from tests.vtimer.virtual_timer import *

# Unit TestCase for StringExpressions
class StringexpressionsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = StringExpressions()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_stringExpressionsTest(self):
		self.assertTrue(self.statemachine.sci_interface.quotedstringx == "\"X\"")
		self.assertTrue(self.statemachine.sci_interface.quotedstringy == "\"Y\"")
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_assignmentchecked))
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_vartovarcomparesucceeded))
		self.assertTrue(self.statemachine.sci_interface.guardstringequal)
		self.assertTrue(self.statemachine.sci_interface.guardstringnotequal)
		self.assertTrue(self.statemachine.sci_interface.stringvarequal)
		self.assertTrue(self.statemachine.sci_interface.stringvarnotequal)
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_vartoconstcomparesucceeded))
		self.assertTrue(self.statemachine.sci_interface.guardstringequal)
		self.assertTrue(self.statemachine.sci_interface.guardstringnotequal)
		self.assertTrue(self.statemachine.sci_interface.stringvarequal)
		self.assertTrue(self.statemachine.sci_interface.stringvarnotequal)
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_consttovarcomparesucceeded))
		self.assertTrue(self.statemachine.sci_interface.guardstringequal)
		self.assertTrue(self.statemachine.sci_interface.guardstringnotequal)
		self.assertTrue(self.statemachine.sci_interface.stringvarequal)
		self.assertTrue(self.statemachine.sci_interface.stringvarnotequal)
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_consttoconstcomparesucceeded))
		self.assertTrue(self.statemachine.sci_interface.guardstringequal)
		self.assertTrue(self.statemachine.sci_interface.guardstringnotequal)
		self.assertTrue(self.statemachine.sci_interface.stringvarequal)
		self.assertTrue(self.statemachine.sci_interface.stringvarnotequal)
		
