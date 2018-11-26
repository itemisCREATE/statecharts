package tracingjava;

public interface ITracing<T> {
	abstract void stateEntered(T state);
	abstract void stateExited(T state);
}
