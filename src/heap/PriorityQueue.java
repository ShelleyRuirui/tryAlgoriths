package heap;

public interface PriorityQueue {

	public void insert(int x);
	public int maximum();
	public int extractMax();
	public void increaseKey(int x,int k);
}
