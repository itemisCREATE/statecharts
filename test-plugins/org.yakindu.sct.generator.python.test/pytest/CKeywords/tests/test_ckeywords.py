
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from ckeywords.ckeywords_statemachine import CKeywords
from tests.vtimer.virtual_timer import *

# Unit TestCase for CKeywords
class CkeywordsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = CKeywords()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_cKeywordsTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.auto_char))
		self.statemachine.sci_interface.raise_auto()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.auto_loop))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.auto_loop_switch_case))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.auto_loop_switch_case_enum_asm))
		
