
import unittest
from unittest import mock

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from statechartkeywords.statechartkeywords_statemachine import StatechartKeywords
from tests.vtimer.virtual_timer import *

# Unit TestCase for StatechartKeywords
class StatemachinekeywordsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = StatechartKeywords()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.set_timer(self.timer)
		self.statemachine.operationCallback = mock.Mock()
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.unset_timer()
		self.statemachine.exit()
	
	def test_statemachineKeywords(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_timer))
		
