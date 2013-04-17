package graph;

public class EndAndWeight<T> {

	T node;
	int weight;
	public EndAndWeight(T node, int weight) {
		super();
		this.node = node;
		this.weight = weight;
	}
	public T getNode() {
		return node;
	}
	public void setNode(T node) {
		this.node = node;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	};
	
	
	
}
