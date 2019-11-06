
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from typealias.typealias_statemachine import TypeAlias
from tests.vtimer.virtual_timer import *

# Unit TestCase for TypeAlias
class TypealiasTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = TypeAlias()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_typeAliasTest(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_start))
		self.assertTrue(self.statemachine.sci_interface.myvar == 1)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_mid))
		self.assertTrue(self.statemachine.sci_interface.mystring == "TypeSystem")
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_mid2))
		self.statemachine.sci_interface.raise_myevent()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_end))
		
