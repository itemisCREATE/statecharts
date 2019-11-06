
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from guardedentry.guardedentry_statemachine import GuardedEntry
from tests.vtimer.virtual_timer import *

# Unit TestCase for GuardedEntry
class GuardedentryTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = GuardedEntry()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_entryNotTakenOnStatechartEnter(self):
		self.assertTrue(self.statemachine.sci_interface.guard == False)
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.assertTrue(self.statemachine.sci_interface.done == False)
		
	def test_entryTakenOnStatechartEnter(self):
		self.statemachine.sci_interface.guard = True
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.assertTrue(self.statemachine.sci_interface.done == True)
		
	def test_entryTakenInTransition(self):
		self.initEntryInTransition(True,False)
		self.assertTrue(self.statemachine.sci_interface.done)
		
	def test_entryNotTakenInTransition(self):
		self.initEntryInTransition(False,False)
		self.assertTrue(not self.statemachine.sci_interface.done)
		
	def initEntryInTransition(self, guardVar, doneVar):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		self.statemachine.sci_interface.guard = guardVar
		self.statemachine.sci_interface.done = doneVar
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		
