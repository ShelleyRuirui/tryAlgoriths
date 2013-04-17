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
	
	public EdgesWithWeight<T> findVerEdges(T v) throws EdgeVerticeNotFound{
		for(EdgesWithWeight<T> edge:vertices){
			if(v.equals(edge.getStartVertice())){
				return edge;
			}
		}
		return null;
	}
	
	public void decreaseOrDeleteEdge(T start,T end,int value) throws EdgeVerticeNotFound{
		EdgesWithWeight<T> edges=findVerEdges(start);
		edges.decreaseOrDeleteEdge(end, value);
	}
	
	public void addOrIncreaseReverseEdge(T start,T end,int value) throws EdgeVerticeNotFound{
		EdgesWithWeight<T> edges=findVerEdges(end);
		edges.addOrIncreaseReverseEdge(start, value);
	}
	
	public void printGraph(){
		for(EdgesWithWeight<T> edge:vertices){
			for(int i=0;i<edge.edges.size();i++){
				int weight=edge.weight.get(i);
				System.out.print(edge.edges.get(i)+"->("+weight+")");
			}
			System.out.println();
		}
	}
	
} 
