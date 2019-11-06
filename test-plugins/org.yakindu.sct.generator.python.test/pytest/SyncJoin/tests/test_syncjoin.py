
import unittest

import sys, os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from syncjoin.syncjoin_statemachine import SyncJoin
from tests.vtimer.virtual_timer import *

# Unit TestCase for SyncJoin
class SyncjoinTestCase(unittest.TestCase):
	
	
	def setUp(self):
		self.statemachine = SyncJoin()
		self.timer = VirtualTimer(200)
		self.timer.schedule_periodical_task(CycleTimeEventTask(self.statemachine), 200, 200)
		self.statemachine.init()

	def tearDown(self):
		self.timer.stop()
		self.statemachine.exit()
	
	def test_syncJoin_C2_Waits(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c1))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r2_d1))
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c2))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r2_d1))
		self.statemachine.sci_interface.raise_jc()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c2))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r2_d1))
		self.statemachine.sci_interface.raise_jd()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c2))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r2_d1))
		self.statemachine.sci_interface.raise_jc()
		self.statemachine.sci_interface.raise_jd()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c2))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r2_d1))
		self.statemachine.sci_interface.raise_f()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c2))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r2_d2))
		self.statemachine.sci_interface.raise_jc()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c2))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r2_d2))
		self.statemachine.sci_interface.raise_jd()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c2))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r2_d2))
		self.statemachine.sci_interface.raise_jc()
		self.statemachine.sci_interface.raise_jd()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		
	def test_syncJoin_D2_Waits(self):
		self.statemachine.enter()
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c1))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r2_d1))
		self.statemachine.sci_interface.raise_f()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c1))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r2_d2))
		self.statemachine.sci_interface.raise_jc()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c1))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r2_d2))
		self.statemachine.sci_interface.raise_jd()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c1))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r2_d2))
		self.statemachine.sci_interface.raise_jc()
		self.statemachine.sci_interface.raise_jd()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c1))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r2_d2))
		self.statemachine.sci_interface.raise_e()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r1_c2))
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_b_r2_d2))
		
	def test_doubleEntryActionBug(self):
		self.statemachine.enter()
		self.statemachine.sci_interface.raise_e()
		self.statemachine.sci_interface.raise_f()
		self.timer.cycle_leap(1)
		self.statemachine.sci_interface.raise_jc()
		self.statemachine.sci_interface.raise_jd()
		self.timer.cycle_leap(1)
		self.assertTrue(self.statemachine.is_state_active(self.statemachine.State.main_region_a))
		self.assertTrue(self.statemachine.sci_interface.x == 1)
		
