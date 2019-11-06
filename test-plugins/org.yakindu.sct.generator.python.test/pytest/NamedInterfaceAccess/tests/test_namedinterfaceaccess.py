
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from namedinterfaceaccess.namedinterfaceaccess_statemachine import NamedInterfaceAccess
from tests.vtimer.virtual_timer import *

# Unit TestCase for NamedInterfaceAccess
class NamedinterfaceaccessTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = NamedInterfaceAccess()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_safeOpenSuccess(self):
		self.statemachine.enter()
		self.timer.cycle_leap(1)
		self.statemachine.sci_user.raise_numberpressed(3)
		self.timer.cycle_leap(1)
		self.statemachine.sci_user.raise_numberpressed(7)
		self.timer.cycle_leap(1)
		self.statemachine.sci_user.raise_numberpressed(5)
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.sci_safe.open)
		
