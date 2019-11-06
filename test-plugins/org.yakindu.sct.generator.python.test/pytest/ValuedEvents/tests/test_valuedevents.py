
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from valuedevents.valuedevents_statemachine import ValuedEvents
from tests.vtimer.virtual_timer import *

# Unit TestCase for ValuedEvents
class ValuedeventsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = ValuedEvents()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_valuedEventsTest(self):
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_interface.mystring == "sct")
		self.statemachine.sci_interface.raise_integerevent(23)
		self.statemachine.sci_interface.raise_booleanevent(False)
		self.statemachine.sci_interface.raise_realevent(20)
		self.statemachine.sci_interface.raise_stringevent("tool")
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.integer_region_d))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.string_region_d))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.boolean_region_d))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.real_region_d))
		self.assertTrue(self.statemachine.sci_interface.myint == 23)
		self.assertTrue(self.statemachine.sci_interface.mybool == False)
		self.assertTrue(self.statemachine.sci_interface.myreal == 20)
		self.assertTrue(self.statemachine.sci_interface.mystring == "tool")
		
