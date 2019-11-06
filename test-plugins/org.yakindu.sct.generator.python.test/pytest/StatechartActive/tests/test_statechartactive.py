
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from statechartactive.statechartactive_statemachine import StatechartActive
from tests.vtimer.virtual_timer import *

# Unit TestCase for StatechartActive
class StatechartactiveTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = StatechartActive()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_inactiveBeforeEnter(self):
		self.assertTrue(not self.statemachine.is_active())
		
	def test_activeAfterEnter(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_active())
		
	def test_inactiveAfterExit(self):
		self.statemachine.enter()
		self.statemachine.exit()
		self.assertTrue(not self.statemachine.is_active())
		
	def test_activeAfterReenter(self):
		self.statemachine.enter()
		self.statemachine.exit()
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_active())
		
