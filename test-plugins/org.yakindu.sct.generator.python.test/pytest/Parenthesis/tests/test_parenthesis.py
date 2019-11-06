
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from parenthesis.parenthesis_statemachine import Parenthesis
from tests.vtimer.virtual_timer import *

# Unit TestCase for Parenthesis
class ParenthesisTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = Parenthesis()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_simple(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.mainregion_a))
		self.assertTrue(self.statemachine.sci_interface.erg == 8)
		
