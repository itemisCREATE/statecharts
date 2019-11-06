
import queue
import threading
import functools

class VirtualTimer:

	"""A `virtual`timer that actually doesn't use real time.
	Instead all the processing is done via PriorityQueue.
	"""

	def __init__(self, cycle_period=0):
		self.stop_time = 0
		self.current_time = 0
		self.cycle_period = cycle_period
		self.schedule_count = 0
		self.tasks = queue.PriorityQueue()
	
	def time_leap(self, ms):
		self.stop_time = self.current_time + ms
		self.process_tasks()
	
	def cycle_leap(self, cycles):
		for x in range(cycles):
			self.time_leap(self.cycle_period)
	
	def set_timer(self, callback, event_id, duration, is_periodical):
		if duration <= 0:
			duration = 1
		time_event_task = VirtualTimeEventTask(callback, event_id)
		if is_periodical:
			self.schedule_periodical_task(time_event_task, duration, duration)
		else:
			self.schedule_task(time_event_task, duration)
	
	def unset_timer(self, callback, event_id):
		"""This method could be optimized in terms of performance.
		"""
		# find task
		task_found = None
		temp_task_list = []
		for i in range(self.tasks.qsize()):
			temp = self.tasks.get()
			temp_task_list.append(temp)
			self.tasks.task_done()
			if not isinstance(temp, VirtualTimeEventTask):
				continue
			if temp.event_id == event_id:
				task_found = temp
				break
		# add all removed tasks to queue
		for task in temp_task_list:
			self.tasks.put(task)
		# process rest
		if task_found is not None:
			task_found.cancel()
			self.tasks.put(task_found)
			return True
		else:
			return False
	
	def schedule_task(self, task, interval):
		task.interval = interval
		self.schedule_internal(task, self.current_time + interval, -1)
	
	def schedule_periodical_task(self, task, interval, period):
		self.schedule_internal(task, self.current_time + interval, period)
	
	def schedule_internal(self, task, time, period):
		task.next_execution_time = time
		task.period = period
		task.schedule_order = self.schedule_count
		self.schedule_count += 1
		self.tasks.put(task)
	
	def process_tasks(self):
		process = not self.tasks.empty()
		while (not self.tasks.empty()) and (process == True):
			task = self.tasks.get()
			if task is None:
				self.tasks.task_done()
				break
			if task.is_canceled == True:
				self.tasks.task_done()
				continue
			if task.next_execution_time <= self.stop_time:
				self.current_time = task.next_execution_time
				task.run()
				if task.period > -1:
					self.schedule_periodical_task(task, task.period, task.period)
				self.tasks.task_done()
			else:
				self.tasks.task_done()
				self.tasks.put(task)
				self.current_time = self.stop_time
				process = False
	
	def stop(self):
		temp_task_list = []
		for i in range(self.tasks.qsize()):
			temp = self.tasks.get()
			temp.cancel()
			temp_task_list.append(temp)
			self.tasks.task_done()
		for task in temp_task_list:
			self.tasks.put(task)
	
	def cancel(self):
		for i in range(self.tasks.qsize()):
			self.tasks.get()
			self.tasks.task_done()
	
@functools.total_ordering
class VirtualTimeTask:

	def __init__(self):
		self.next_execution_time = 0
		self.interval = 0
		self.period = -1
		self.schedule_order = 0
		self.is_canceled = False
	
	def __eq__(self, other):
		return (self.next_execution_time == other.next_execution_time)\
				and (isinstance(other, CycleTimeEventTask) and isinstance(self, CycleTimeEventTask))\
				and (self.period == other.period)\
				and (self.schedule_order == other.schedule_order)
	
	def __lt__(self, other):
		if self.next_execution_time != other.next_execution_time:
			return (self.next_execution_time - other.next_execution_time) < 0
		elif isinstance(other, CycleTimeEventTask) and not isinstance(self, CycleTimeEventTask):
			return True
		elif not isinstance(other, CycleTimeEventTask) and isinstance(self, CycleTimeEventTask):
			return False
		elif self.period != other.period:
			return (self.period - other.period) < 0
		else:
			return (self.schedule_order - other.schedule_order) < 0
	
	def cancel(self):
		self.is_canceled = True

class VirtualTimeEventTask(VirtualTimeTask):

	def __init__(self, callback, event_id):
		self.callback = callback
		self.event_id = event_id
		super().__init__()
	
	def run(self):
		self.callback.time_elapsed(self.event_id)
		
class CycleTimeEventTask(VirtualTimeTask):

	def __init__(self, statemachine):
		self.statemachine = statemachine
		super().__init__()
	
	def run(self):
		self.statemachine.run_cycle()

