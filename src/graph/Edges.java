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
	
	public void removeEdge(T v) throws EdgeVerticeNotFound{
		if(edges.size()<1)
			throw new EdgeVerticeNotFound("In removeEdge");
		for(int i=1;i<edges.size();i++){
			if(edges.get(i).equals(v)){
				edges.remove(i);
				return;
			}
		}
		
	}
	
	public int containsEnd(T v) throws EdgeVerticeNotFound{
		if(edges.size()<1)
			throw new EdgeVerticeNotFound("In removeEdge");
		for(int i=1;i<edges.size();i++){
			if(edges.get(i).equals(v)){
				return i;
			}
		}
		return -1;
	}
	

	public ArrayList<T> getEdges(){
		return edges;
	}

}
