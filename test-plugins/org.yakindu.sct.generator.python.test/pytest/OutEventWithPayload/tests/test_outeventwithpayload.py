
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from outeventwithpayload.outeventwithpayload_statemachine import OutEventWithPayload
from tests.vtimer.virtual_timer import *

# Unit TestCase for OutEventWithPayload
class OuteventwithpayloadTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = OutEventWithPayload()
		self.statemachine.init()

	def tearDown(self):
		self.statemachine.exit()
	
	def test_out_events_must_have_payload(self):
		self.statemachine.enter()
		self.statemachine.sci_interface.raise_i(21)
		self.assertTrue(self.statemachine.sci_interface.o)
		self.assertTrue(# org.yakindu.sct.model.stext.stext.impl.EventValueReferenceExpressionImpl@77efc298 not implemented - sorry :( == 42)
		self.statemachine.exit()
		
