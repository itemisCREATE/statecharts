
import unittest
from unittest import mock

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from childfirsttransitionsinsubchart.childfirsttransitionsinsubchart_statemachine import ChildFirstTransitionsInSubchart
from tests.vtimer.virtual_timer import *

# Unit TestCase for ChildFirstTransitionsInSubchart
class ChildfirsttransitionsinsubchartTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = ChildFirstTransitionsInSubchart()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.sci_interface.operationCallback = mock.Mock()
		self.statemachine.init()

	def tearDown(self):
		self.statemachine.sci_interface.operationCallback = None
		self.timer.stop()
		self.statemachine.exit()
	
	def set_up(self):
		self.statemachine.sci_interface.cnt = 0
		
	def checkA(self, ret):
		self.statemachine.sci_interface.cnt = self.statemachine.sci_interface.cnt+1
		self.statemachine.sci_interface.a_check = self.statemachine.sci_interface.cnt
		return ret
		
	def checkAA(self, ret):
		self.statemachine.sci_interface.cnt = self.statemachine.sci_interface.cnt+1
		self.statemachine.sci_interface.aa_check = self.statemachine.sci_interface.cnt
		return ret
		
	def checkAB(self, ret):
		self.statemachine.sci_interface.cnt = self.statemachine.sci_interface.cnt+1
		self.statemachine.sci_interface.ab_check = self.statemachine.sci_interface.cnt
		return ret
		
	def checkAC(self, ret):
		self.statemachine.sci_interface.cnt = self.statemachine.sci_interface.cnt+1
		self.statemachine.sci_interface.ac_check = self.statemachine.sci_interface.cnt
		return ret
		
	def checkAD(self, ret):
		self.statemachine.sci_interface.cnt = self.statemachine.sci_interface.cnt+1
		self.statemachine.sci_interface.ad_check = self.statemachine.sci_interface.cnt
		return ret
		
	def checkC(self, ret):
		self.statemachine.sci_interface.cnt = self.statemachine.sci_interface.cnt+1
		self.statemachine.sci_interface.c_check = self.statemachine.sci_interface.cnt
		return ret
		
	def nextCounter(self):
		self.statemachine.sci_interface.cnt = self.statemachine.sci_interface.cnt+1
		return self.statemachine.sci_interface.cnt
		
	def test_executionOrderWithNoTransitionInOrthogonalSubstates(self):
		def check_side_effect(*args, **kwargs):
			if args == ("C"):
				return checkC(False)
			if args == ("AD"):
				return checkAD(False)
			if args == ("AC"):
				return checkAC(False)
			if args == ("AB"):
				return checkAB(False)
			if args == ("AA"):
				return checkAA(False)
			if args == ("A"):
				return checkA(False)
			
		def next_side_effect(*args, **kwargs):
			return nextCounter()
			
		self.set_up()
		self.statemachine.sci_interface.operationCallback.check = mock.Mock(side_effect=check_side_effect)
		self.statemachine.sci_interface.operationCallback.next = mock.Mock(side_effect=next_side_effect)
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.aa_check == 1)
		self.assertTrue(self.statemachine.sci_interface.aa_local == 2)
		self.assertTrue(self.statemachine.sci_interface.ac_check == 3)
		self.assertTrue(self.statemachine.sci_interface.ac_local == 4)
		self.assertTrue(self.statemachine.sci_interface.a_check == 5)
		self.assertTrue(self.statemachine.sci_interface.a_local == 6)
		self.assertTrue(self.statemachine.sci_interface.c_check == 7)
		self.assertTrue(self.statemachine.sci_interface.c_local == 8)
		self.assertTrue(self.statemachine.sci_interface.sm_local == 9)
		
	def test_executionOrderWithTransitionInFirstSubRegion(self):
		def check_side_effect(*args, **kwargs):
			if args == ("C"):
				return checkC(False)
			if args == ("AD"):
				return checkAD(False)
			if args == ("AC"):
				return checkAC(False)
			if args == ("AB"):
				return checkAB(False)
			if args == ("AA"):
				return checkAA(True)
			if args == ("A"):
				return checkA(False)
			
		def next_side_effect(*args, **kwargs):
			return nextCounter()
			
		self.set_up()
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.aa_check == 1)
		self.assertTrue(self.statemachine.sci_interface.aa_local == 0)
		self.assertTrue(self.statemachine.sci_interface.ac_check == 2)
		self.assertTrue(self.statemachine.sci_interface.ac_local == 3)
		self.assertTrue(self.statemachine.sci_interface.a_check == 4)
		self.assertTrue(self.statemachine.sci_interface.a_local == 5)
		self.assertTrue(self.statemachine.sci_interface.c_check == 6)
		self.assertTrue(self.statemachine.sci_interface.c_local == 7)
		self.assertTrue(self.statemachine.sci_interface.sm_local == 8)
		
	def test_executionOrderWithTransitionInLastSubRegion(self):
		def check_side_effect(*args, **kwargs):
			if args == ("C"):
				return checkC(False)
			if args == ("AD"):
				return checkAD(False)
			if args == ("AC"):
				return checkAC(True)
			if args == ("AB"):
				return checkAB(False)
			if args == ("AA"):
				return checkAA(False)
			if args == ("A"):
				return checkA(False)
			
		def next_side_effect(*args, **kwargs):
			return nextCounter()
			
		self.set_up()
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.aa_check == 1)
		self.assertTrue(self.statemachine.sci_interface.aa_local == 2)
		self.assertTrue(self.statemachine.sci_interface.ac_check == 3)
		self.assertTrue(self.statemachine.sci_interface.ac_local == 0)
		self.assertTrue(self.statemachine.sci_interface.a_check == 0)
		self.assertTrue(self.statemachine.sci_interface.a_local == 4)
		self.assertTrue(self.statemachine.sci_interface.c_check == 5)
		self.assertTrue(self.statemachine.sci_interface.c_local == 6)
		self.assertTrue(self.statemachine.sci_interface.sm_local == 7)
		
	def test_executionOrderWithTransitionInAllSubRegion(self):
		def check_side_effect(*args, **kwargs):
			if args == ("C"):
				return checkC(False)
			if args == ("AD"):
				return checkAD(False)
			if args == ("AC"):
				return checkAC(True)
			if args == ("AB"):
				return checkAB(False)
			if args == ("AA"):
				return checkAA(True)
			if args == ("A"):
				return checkA(False)
			
		def next_side_effect(*args, **kwargs):
			return nextCounter()
			
		self.set_up()
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.aa_check == 1)
		self.assertTrue(self.statemachine.sci_interface.aa_local == 0)
		self.assertTrue(self.statemachine.sci_interface.a_local == 3)
		self.assertTrue(self.statemachine.sci_interface.ac_check == 2)
		self.assertTrue(self.statemachine.sci_interface.ac_local == 0)
		self.assertTrue(self.statemachine.sci_interface.a_check == 0)
		self.assertTrue(self.statemachine.sci_interface.a_local == 3)
		self.assertTrue(self.statemachine.sci_interface.c_check == 4)
		self.assertTrue(self.statemachine.sci_interface.c_local == 5)
		self.assertTrue(self.statemachine.sci_interface.sm_local == 6)
		
