package graph;

import java.util.ArrayList;

public class GraphWithWeight<T>  {

	ArrayList<EdgesWithWeight<T>> vertices=new ArrayList<EdgesWithWeight<T>>();
	
	public ArrayList<EdgesWithWeight<T>> getVertices(){
		return vertices;
	}
	
	public void addVertice(T v){
		EdgesWithWeight<T> e=new EdgesWithWeight<T>(v);
		vertices.add(e);
	}
	
	public void addEdge(T v1,T v2,int weight) throws EdgeVerticeNotFound{
		EdgesWithWeight<T> edges=findVerEdges(v1);
		if(edges==null){
			throw new EdgeVerticeNotFound("Edge vertice not found for "+v1.toString()+" "+v2.toString());
		}else{
			edges.addEndVertice(v2,weight);
		}
	}
	
	private EdgesWithWeight<T> findVerEdges(T v) throws EdgeVerticeNotFound{
		for(EdgesWithWeight<T> edge:vertices){
			if(v.equals(edge.getStartVertice())){
				return edge;
			}
		}
		return null;
	}
	
} 
