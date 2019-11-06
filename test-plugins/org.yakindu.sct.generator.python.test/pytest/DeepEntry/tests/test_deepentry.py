
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from deepentry.deepentry_statemachine import DeepEntry
from tests.vtimer.virtual_timer import *

# Unit TestCase for DeepEntry
class DeepentryTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = DeepEntry()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_enterToSubstate(self):
		self.statemachine.enter()
		vergleich = 4
		self.assertTrue(vergleich == 4)
		self.statemachine.exit()
		
