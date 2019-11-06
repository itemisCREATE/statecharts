
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from declarations.declarations_statemachine import Declarations
from tests.vtimer.virtual_timer import *

# Unit TestCase for Declarations
class DeclarationsTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = Declarations()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_declarationsTest(self):
		self.statemachine.enter()
		
