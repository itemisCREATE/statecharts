
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from entryreactionaction.entryreactionaction_statemachine import EntryReactionAction
from tests.vtimer.virtual_timer import *

# Unit TestCase for EntryReactionAction
class EntryreactionactionTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = EntryReactionAction()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_entryTransitionActionOnStatechartEnter(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.sci_interface.enteredr1)
		self.assertTrue(self.statemachine.sci_interface.enteredr2)
		self.assertTrue(self.statemachine.sci_interface.enteredbdefault)
		self.assertTrue(not self.statemachine.sci_interface.enteredbother)
		
	def test_entryOnRTS(self):
		self.init()
		self.statemachine.sci_interface.raise_b()
		self.timer.cycle_leap(1)
		self.assertTrue(not self.statemachine.sci_interface.enteredr1)
		self.assertTrue(not self.statemachine.sci_interface.enteredr2)
		self.assertTrue(not self.statemachine.sci_interface.enteredbdefault)
		self.assertTrue(self.statemachine.sci_interface.enteredbother)
		
	def test_noEntryTransitionActionOnHistory(self):
		self.init()
		self.statemachine.sci_interface.raise_d()
		self.timer.cycle_leap(1)
		self.assertTrue(not self.statemachine.sci_interface.enteredr1)
		self.assertTrue(not self.statemachine.sci_interface.enteredr2)
		self.assertTrue(not self.statemachine.sci_interface.enteredbdefault)
		self.assertTrue(not self.statemachine.sci_interface.enteredbother)
		
	def init(self):
		self.statemachine.enter()
		self.statemachine.sci_interface.raise_b()
		self.timer.cycle_leap(1)
		self.statemachine.sci_interface.raise_d()
		self.timer.cycle_leap(1)
		self.statemachine.sci_interface.enteredr1 = False
		self.statemachine.sci_interface.enteredr2 = False
		self.statemachine.sci_interface.enteredbdefault = False
		self.statemachine.sci_interface.enteredbother = False
		
