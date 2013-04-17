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
	
	public void decreaseOrDeleteEdge(T node,int value){
		for(int i=1;i<edges.size();i++){
			if(edges.get(i).equals(node)){
				int curweight=weight.get(i);
				if(curweight==value){
					weight.remove(i);
					edges.remove(i);
				}else{
					weight.set(i, curweight-value);
				}
			}
		}
	}
	
	public void addOrIncreaseReverseEdge(T node,int value) throws EdgeVerticeNotFound{
		for(int i=1;i<edges.size();i++){
			if(edges.get(i).equals(node)){
				weight.set(i, weight.get(i)+value);
				return;
			}
		}
		addEndVertice(node,value);
	}
	
}
