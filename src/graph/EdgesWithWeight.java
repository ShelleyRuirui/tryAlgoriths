package graph;

import java.util.ArrayList;

public class EdgesWithWeight<T> extends Edges<T> {

	ArrayList<Integer> weight=new ArrayList<Integer>();
	
	public EdgesWithWeight(T vertice){
		this(vertice,0);
	}
	
	public EdgesWithWeight(T vertice,int w){
		super(vertice);
		weight.add(w);
	}
	
	public int getWeight(T vertice) throws EdgeVerticeNotFound{
		int index=containsEnd(vertice);
		if(index!=-1){
			return weight.get(index);
		}
		throw new EdgeVerticeNotFound("In addEndVertice:Edge start vertice not found");
	}
	
	public void addEndVertice(T v,int w) throws EdgeVerticeNotFound{
		addEndVertice(v);
		weight.add(w);
	}
	
	public ArrayList<Integer> getWeight(){
		return weight;
	}
	
}
