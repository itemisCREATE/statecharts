
import unittest
from unittest import mock

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from childfirstorthogonalreactions.childfirstorthogonalreactions_statemachine import ChildFirstOrthogonalReactions
from tests.vtimer.virtual_timer import *

# Unit TestCase for ChildFirstOrthogonalReactions
class ChildfirstorthogonalreactionsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = ChildFirstOrthogonalReactions()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.sci_interface.operationCallback = mock.Mock()
		self.statemachine.init()

	def tearDown(self):
		self.statemachine.sci_interface.operationCallback = None
		self.timer.stop()
		self.statemachine.exit()
	
	def checkA(self, ret):
		self.statemachine.sci_interface.cnt = self.statemachine.sci_interface.cnt+1
		self.statemachine.sci_interface.a_check = self.statemachine.sci_interface.cnt
		return ret
		
	def checkAA(self, ret):
		self.statemachine.sci_interface.cnt = self.statemachine.sci_interface.cnt+1
		self.statemachine.sci_interface.aa_check = self.statemachine.sci_interface.cnt
		return ret
		
	def checkAAA(self, ret):
		self.statemachine.sci_interface.cnt = self.statemachine.sci_interface.cnt+1
		self.statemachine.sci_interface.aaa_check = self.statemachine.sci_interface.cnt
		return ret
		
	def checkAAC(self, ret):
		self.statemachine.sci_interface.cnt = self.statemachine.sci_interface.cnt+1
		self.statemachine.sci_interface.aac_check = self.statemachine.sci_interface.cnt
		return ret
		
	def checkAC(self, ret):
		self.statemachine.sci_interface.cnt = self.statemachine.sci_interface.cnt+1
		self.statemachine.sci_interface.ac_check = self.statemachine.sci_interface.cnt
		return ret
		
	def checkC(self, ret):
		self.statemachine.sci_interface.cnt = self.statemachine.sci_interface.cnt+1
		self.statemachine.sci_interface.c_check = self.statemachine.sci_interface.cnt
		return ret
		
	def nextCounter(self):
		self.statemachine.sci_interface.cnt = self.statemachine.sci_interface.cnt+1
		return self.statemachine.sci_interface.cnt
		
	def test_executionOrder(self):
		def next_side_effect(*args, **kwargs):
			return nextCounter()
			
		def check_side_effect(*args, **kwargs):
			if args == ("C"):
				return checkC(False)
			if args == ("AC"):
				return checkAC(False)
			if args == ("AAC"):
				return checkAAC(False)
			if args == ("AAA"):
				return checkAAA(False)
			if args == ("AA"):
				return checkAA(False)
			if args == ("A"):
				return checkA(False)
			
		self.statemachine.sci_interface.operationCallback.check = mock.Mock(side_effect=check_side_effect)
		self.statemachine.sci_interface.operationCallback.next = mock.Mock(side_effect=next_side_effect)
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.aaa_check == 1)
		self.assertTrue(self.statemachine.sci_interface.aaa_local == 2)
		self.assertTrue(self.statemachine.sci_interface.aac_check == 3)
		self.assertTrue(self.statemachine.sci_interface.aac_local == 4)
		self.assertTrue(self.statemachine.sci_interface.aa_check == 5)
		self.assertTrue(self.statemachine.sci_interface.aa_local == 6)
		self.assertTrue(self.statemachine.sci_interface.ac_check == 7)
		self.assertTrue(self.statemachine.sci_interface.ac_local == 8)
		self.assertTrue(self.statemachine.sci_interface.a_check == 9)
		self.assertTrue(self.statemachine.sci_interface.a_local == 10)
		self.assertTrue(self.statemachine.sci_interface.c_check == 11)
		self.assertTrue(self.statemachine.sci_interface.c_local == 12)
		self.assertTrue(self.statemachine.sci_interface.sm_local == 13)
		
	def test_executionOrderWIthFirstLeafTransition(self):
		def next_side_effect(*args, **kwargs):
			return nextCounter()
			
		def check_side_effect(*args, **kwargs):
			if args == ("C"):
				return checkC(False)
			if args == ("AC"):
				return checkAC(False)
			if args == ("AAC"):
				return checkAAC(False)
			if args == ("AAA"):
				return checkAAA(True)
			if args == ("AA"):
				return checkAA(False)
			if args == ("A"):
				return checkA(False)
			
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.aaa_check == 1)
		self.assertTrue(self.statemachine.sci_interface.aaa_local == 0)
		self.assertTrue(self.statemachine.sci_interface.aac_check == 0)
		self.assertTrue(self.statemachine.sci_interface.aac_local == 0)
		self.assertTrue(self.statemachine.sci_interface.aa_check == 0)
		self.assertTrue(self.statemachine.sci_interface.aa_local == 0)
		self.assertTrue(self.statemachine.sci_interface.ac_check == 0)
		self.assertTrue(self.statemachine.sci_interface.ac_local == 0)
		self.assertTrue(self.statemachine.sci_interface.a_check == 0)
		self.assertTrue(self.statemachine.sci_interface.a_local == 0)
		self.assertTrue(self.statemachine.sci_interface.c_check == 2)
		self.assertTrue(self.statemachine.sci_interface.c_local == 3)
		self.assertTrue(self.statemachine.sci_interface.sm_local == 4)
		
	def test_executionOrderWIthFirstParentTransition(self):
		def next_side_effect(*args, **kwargs):
			return nextCounter()
			
		def check_side_effect(*args, **kwargs):
			if args == ("C"):
				return checkC(False)
			if args == ("AC"):
				return checkAC(False)
			if args == ("AAC"):
				return checkAAC(False)
			if args == ("AAA"):
				return checkAAA(False)
			if args == ("AA"):
				return checkAA(True)
			if args == ("A"):
				return checkA(False)
			
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.aaa_check == 1)
		self.assertTrue(self.statemachine.sci_interface.aaa_local == 2)
		self.assertTrue(self.statemachine.sci_interface.aac_check == 3)
		self.assertTrue(self.statemachine.sci_interface.aac_local == 4)
		self.assertTrue(self.statemachine.sci_interface.aa_check == 5)
		self.assertTrue(self.statemachine.sci_interface.aa_local == 0)
		self.assertTrue(self.statemachine.sci_interface.ac_check == 0)
		self.assertTrue(self.statemachine.sci_interface.ac_local == 0)
		self.assertTrue(self.statemachine.sci_interface.a_check == 0)
		self.assertTrue(self.statemachine.sci_interface.a_local == 0)
		self.assertTrue(self.statemachine.sci_interface.c_check == 6)
		self.assertTrue(self.statemachine.sci_interface.c_local == 7)
		self.assertTrue(self.statemachine.sci_interface.sm_local == 8)
		
	def test_executionOrderWIthFirstGrandParentTransition(self):
		def next_side_effect(*args, **kwargs):
			return nextCounter()
			
		def check_side_effect(*args, **kwargs):
			if args == ("C"):
				return checkC(False)
			if args == ("AC"):
				return checkAC(False)
			if args == ("AAC"):
				return checkAAC(False)
			if args == ("AAA"):
				return checkAAA(False)
			if args == ("AA"):
				return checkAA(False)
			if args == ("A"):
				return checkA(True)
			
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.aaa_check == 1)
		self.assertTrue(self.statemachine.sci_interface.aaa_local == 2)
		self.assertTrue(self.statemachine.sci_interface.aac_check == 3)
		self.assertTrue(self.statemachine.sci_interface.aac_local == 4)
		self.assertTrue(self.statemachine.sci_interface.aa_check == 5)
		self.assertTrue(self.statemachine.sci_interface.aa_local == 6)
		self.assertTrue(self.statemachine.sci_interface.ac_check == 7)
		self.assertTrue(self.statemachine.sci_interface.ac_local == 8)
		self.assertTrue(self.statemachine.sci_interface.a_check == 9)
		self.assertTrue(self.statemachine.sci_interface.a_local == 0)
		self.assertTrue(self.statemachine.sci_interface.c_check == 10)
		self.assertTrue(self.statemachine.sci_interface.c_local == 11)
		self.assertTrue(self.statemachine.sci_interface.sm_local == 12)
		
	def test_executionOrderWithLastLeafTransition(self):
		def next_side_effect(*args, **kwargs):
			return nextCounter()
			
		def check_side_effect(*args, **kwargs):
			if args == ("C"):
				return checkC(True)
			if args == ("AC"):
				return checkAC(False)
			if args == ("AAC"):
				return checkAAC(False)
			if args == ("AAA"):
				return checkAAA(False)
			if args == ("AA"):
				return checkAA(False)
			if args == ("A"):
				return checkA(False)
			
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.aaa_check == 1)
		self.assertTrue(self.statemachine.sci_interface.aaa_local == 2)
		self.assertTrue(self.statemachine.sci_interface.aac_check == 3)
		self.assertTrue(self.statemachine.sci_interface.aac_local == 4)
		self.assertTrue(self.statemachine.sci_interface.aa_check == 5)
		self.assertTrue(self.statemachine.sci_interface.aa_local == 6)
		self.assertTrue(self.statemachine.sci_interface.ac_check == 7)
		self.assertTrue(self.statemachine.sci_interface.ac_local == 8)
		self.assertTrue(self.statemachine.sci_interface.a_check == 9)
		self.assertTrue(self.statemachine.sci_interface.a_local == 10)
		self.assertTrue(self.statemachine.sci_interface.c_check == 11)
		self.assertTrue(self.statemachine.sci_interface.c_local == 0)
		self.assertTrue(self.statemachine.sci_interface.sm_local == 12)
		
