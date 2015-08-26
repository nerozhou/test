package design.pattern.adapter;

public abstract class AbstactClient implements Client {
	protected long currentTime = System.currentTimeMillis();
}
