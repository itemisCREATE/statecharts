
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from choice.choice_statemachine import Choice
from tests.vtimer.virtual_timer import *

# Unit TestCase for Choice
class ChoiceTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = Choice()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_elseChoiceUsingNonDefaultTransition(self):
		self.initForEventE(True)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_c))
		
	def test_elseChoiceUsingDefaultTransition(self):
		self.initForEventE(False)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		
	def test_defaultChoiceUsingNonDefaultTransition(self):
		self.initForEventG(True)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_c))
		
	def test_defaultChoiceUsingDefaultTransition(self):
		self.initForEventG(False)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		
	def test_uncheckedChoiceUsingNonDefaultTransition(self):
		self.initForEventF(True)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_c))
		
	def test_uncheckedChoiceUsingDefaultTransition(self):
		self.initForEventF(False)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		
	def test_alwaysTrueTransitionInChoice(self):
		self.initForEventH(True)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_c))
		
	def initForEventE(self, valueForC):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.c = valueForC
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		
	def initForEventF(self, valueForC):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.c = valueForC
		self.statemachine.sci_interface.raise_f()
		self.timer.cycle_leap(1)
		
	def initForEventG(self, valueForC):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.c = valueForC
		self.statemachine.sci_interface.raise_g()
		self.timer.cycle_leap(1)
		
	def initForEventH(self, valueForC):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.sci_interface.c = valueForC
		self.statemachine.sci_interface.raise_h()
		self.timer.cycle_leap(1)
		
