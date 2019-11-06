
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from shadowvalueparameter.shadowvalueparameter_statemachine import ShadowValueParameter
from tests.vtimer.virtual_timer import *

# Unit TestCase for ShadowValueParameter
class ShadowvalueparameterTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = ShadowValueParameter()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_shadowValueParameterTest(self):
		self.statemachine.enter()
		self.statemachine.sci_interface.value = 2
		self.assertTrue((self.statemachine.sci_interface.value == 2))
		self.statemachine.exit()
		
