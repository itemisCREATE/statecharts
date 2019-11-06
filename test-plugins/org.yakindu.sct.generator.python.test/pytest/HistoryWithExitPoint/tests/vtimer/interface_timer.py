
# abstract base class
import abc


class ITimer(object, metaclass=abc.ABCMeta):

	"""
	
	Interface a timer has to implement.
	Use to implement your own timer service.
	
	"""

	@abc.abstractmethod
	def set_timer(self, callback, event_id, time, is_periodic):
		"""
		Starts the timing for a given time event id.
		
		Keyword arguments:
		[ITimerCallback]
		callback    -- The target callback where the time event has to be raised.
		[int]
		event_id    -- The eventID the timer should use if timed out.
		[long]
		time        -- Time in milliseconds after the given time event should be triggered.
		[boolean]
		is_periodic -- Set to true if the time event should be triggered periodically.
		"""
		raise NotImplementedError('user must define set_timer() to use this base class')

	@abc.abstractmethod
	def unset_timer(self, callback, event_id):
		"""
		Unset a time event.
		
		Keyword arguments:
		[ITimerCallback]
		callback -- The target callback for which the time event has to be unset.
		[int]
		event_id -- The time event id.
		"""
		raise NotImplementedError('user must define unset_timer() to use this base class')
	
	@abc.abstractmethod
	def cancel(self):
		"""
		Cancel Timer. Use this to end possible timing threads
		and free memory resources
		"""
		raise NotImplementedError('user must define cancel() to use this base class')
