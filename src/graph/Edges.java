package graph;

import java.util.ArrayList;

public class Edges<T> {
	ArrayList<T> edges=new ArrayList<T>();
	
	public Edges(T vertice){
		edges.add(vertice);
	}
	
	public T getStartVertice() throws EdgeVerticeNotFound{
		if(edges.size()==0){
			throw new EdgeVerticeNotFound("In getStartVertice:Edge start vertice not found");
		}			
		else
			return edges.get(0);
	}
	
	public void addEndVertice(T v) throws EdgeVerticeNotFound{
		if(edges.size()<1)
			throw new EdgeVerticeNotFound("In addEndVertice:Edge start vertice not found");
		edges.add(v);
	}
	

	

}
