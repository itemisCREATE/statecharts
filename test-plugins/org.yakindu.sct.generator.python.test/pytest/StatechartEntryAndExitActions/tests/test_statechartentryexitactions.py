
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from statechartentryandexitactions.statechartentryandexitactions_statemachine import StatechartEntryAndExitActions
from tests.vtimer.virtual_timer import *

# Unit TestCase for StatechartEntryAndExitActions
class StatechartentryexitactionsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = StatechartEntryAndExitActions()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_entryActionsAreExecutedOnEnteringStatechart(self):
		self.assertTrue(self.statemachine.sci_interface.x == 0)
		self.assertTrue(self.statemachine.sci_interface.y == 0)
		self.statemachine.sci_interface.b = True
		self.statemachine.enter()
		self.assertTrue(self.statemachine.sci_interface.x == 5)
		self.assertTrue(self.statemachine.sci_interface.y == 3)
		
	def test_exitActionsAreExecutedOnEnteringStatechart(self):
		self.statemachine.enter()
		self.statemachine.exit()
		self.assertTrue(self.statemachine.sci_interface.x == 6)
		self.assertTrue(self.statemachine.sci_interface.y == 2)
		
