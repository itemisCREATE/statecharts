
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from readonlyvariable.readonlyvariable_statemachine import ReadOnlyVariable
from tests.vtimer.virtual_timer import *

# Unit TestCase for ReadOnlyVariable
class ReadonlyvariableTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = ReadOnlyVariable()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_readOnlyVariableTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_statea))
		self.assertTrue(self.statemachine.sci_interface.myint == 0)
		self.assertTrue(self.statemachine.sci_interface.mystring == "testString")
		self.assertTrue(self.statemachine.sci_interface.mybool == True)
		self.assertTrue(self.statemachine.sci_interface.myreal == 1.1)
		self.assertTrue(self.statemachine.sci_a.myint == 0)
		self.assertTrue(self.statemachine.sci_a.mystring == "testString")
		self.assertTrue(self.statemachine.sci_a.mybool == True)
		self.assertTrue(self.statemachine.sci_a.myreal == 1.1)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_stateb))
		self.assertTrue(self.statemachine.sci_interface.myint == 100)
		self.assertTrue(self.statemachine.sci_interface.mystring == "fail")
		self.assertTrue(self.statemachine.sci_interface.mybool == False)
		self.assertTrue(self.statemachine.sci_interface.myreal == 6.6)
		self.assertTrue(self.statemachine.sci_a.myint == 200)
		self.assertTrue(self.statemachine.sci_a.mystring == "A_fail")
		self.assertTrue(self.statemachine.sci_a.mybool == False)
		self.assertTrue(self.statemachine.sci_a.myreal == 7.7)
		
