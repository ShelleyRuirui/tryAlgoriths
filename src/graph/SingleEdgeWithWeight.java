package graph;

public class SingleEdgeWithWeight<T> {

	private T from;
	private T to;
	private int weight;
	

	public T getFrom() {
		return from;
	}
	public void setFrom(T from) {
		this.from = from;
	}
	public T getTo() {
		return to;
	}
	public void setTo(T to) {
		this.to = to;
	}
	public SingleEdgeWithWeight(T from, T to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
