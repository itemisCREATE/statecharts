
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from constonlydefaultscope.constonlydefaultscope_statemachine import ConstOnlyDefaultScope
from tests.vtimer.virtual_timer import *

# Unit TestCase for ConstOnlyDefaultScope
class ConstonlydefaultscopeTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = ConstOnlyDefaultScope()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_statechartEntry(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.constonlydefaultscope_main_region_a))
		
	def test_stateTransition(self):
		self.statemachine.enter()
		self.statemachine.sci_a.raise_e(1)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.constonlydefaultscope_main_region_b))
		
