
import unittest
from unittest import mock

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from operations.operations_statemachine import Operations
from tests.vtimer.virtual_timer import *

# Unit TestCase for Operations
class OperationstestTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = Operations()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.operationCallback = mock.Mock()
		self.statemachine.sci_interface.operationCallback = mock.Mock()
		self.statemachine.operationCallback = mock.Mock()
		self.statemachine.sci_interface1.operationCallback = mock.Mock()
		self.statemachine.init()

	def tearDown(self):
		self.statemachine.sci_interface.operationCallback = None
		self.statemachine.internalOperationCallback = None
		self.statemachine.sci_interface1.operationCallback = None
		self.timer.stop()
		self.statemachine.exit()
	
	def test_operationsCalled(self):
		def alwaysTrue_side_effect(*args, **kwargs):
			return True
			
		self.statemachine.sci_interface.operationCallback.alwaysTrue = mock.Mock(side_effect=alwaysTrue_side_effect)
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		self.statemachine.operationCallback.internalOperation1.assert_called()
		self.statemachine.operationCallback.internalOperation3.assert_called()
		self.statemachine.operationCallback.internalOperation4.assert_called()
		self.statemachine.operationCallback.internalOperation5.assert_called()
		self.statemachine.sci_interface.raise_ev()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_c))
		self.statemachine.sci_interface1.operationCallback.interfaceOperation1.assert_called()
		self.statemachine.sci_interface1.operationCallback.interfaceOperation3.assert_called()
		self.statemachine.sci_interface1.operationCallback.interfaceOperation4.assert_called()
		self.statemachine.sci_interface1.operationCallback.interfaceOperation5.assert_called()
		self.statemachine.sci_interface.raise_ev()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_d))
		self.statemachine.sci_interface.operationCallback.unnamedInterfaceOperation1.assert_called()
		self.statemachine.sci_interface.operationCallback.unnamedOperation3.assert_called()
		self.statemachine.sci_interface.operationCallback.unnamedOperation4.assert_called()
		self.statemachine.sci_interface.operationCallback.unnamedOperation5.assert_called()
		
	def test_operationsNotCalled(self):
		def alwaysTrue_side_effect(*args, **kwargs):
			return True
			
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.statemachine.operationCallback.internalOperation1.assert_called()
		self.statemachine.operationCallback.internalOperation3.assert_called()
		self.statemachine.operationCallback.internalOperation4.assert_called()
		self.statemachine.operationCallback.internalOperation5.assert_called()
		self.statemachine.sci_interface.raise_ev()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		self.statemachine.sci_interface1.operationCallback.interfaceOperation1.assert_called()
		self.statemachine.sci_interface1.operationCallback.interfaceOperation3.assert_called()
		self.statemachine.sci_interface1.operationCallback.interfaceOperation4.assert_called()
		self.statemachine.sci_interface1.operationCallback.interfaceOperation5.assert_called()
		self.statemachine.sci_interface.raise_ev()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_c))
		self.statemachine.sci_interface.operationCallback.unnamedInterfaceOperation1.assert_called()
		self.statemachine.sci_interface.operationCallback.unnamedOperation3.assert_called()
		self.statemachine.sci_interface.operationCallback.unnamedOperation4.assert_called()
		self.statemachine.sci_interface.operationCallback.unnamedOperation5.assert_called()
		
