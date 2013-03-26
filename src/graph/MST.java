package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MST<T> {

	GraphWithWeight<T> graph;
	ArrayList<SingleEdgeWithWeight<T>> edges=new ArrayList<SingleEdgeWithWeight<T>>();
	DisjointSet set=new DisjointSet();
	
	public MST(GraphWithWeight<T> g){
		graph=g;
	}
	
	public void printMST(){
		Set<String> finalPath=new HashSet<String>();
		constructOrderedSingleEdges();
		int handleCount=0;
		while(handleCount<graph.vertices.size()-1){
			SingleEdgeWithWeight<T> smallest=edges.remove(0);
			String from=smallest.getFrom().toString();
			String to=smallest.getTo().toString();
			if(!set.inSameSet(from,to )){
				handleCount++;
				finalPath.add(from+"->"+to+"("+smallest.getWeight()+")");
				System.out.println(from+"->"+to+"("+smallest.getWeight()+")");
				set.union(from, to);
			}
		}
	}
	
	private void constructOrderedSingleEdges(){
		ArrayList<EdgesWithWeight<T>> vertices=graph.getVertices();
		for(EdgesWithWeight<T> edges:vertices){
			ArrayList<T> curEdges=edges.getEdges();
			T start=curEdges.get(0);
			set.makeSet(start.toString());
			ArrayList<Integer> weights=edges.getWeight();
			for(int i=1;i<curEdges.size();i++){
				T end=curEdges.get(i);
				int weight=weights.get(i);
				SingleEdgeWithWeight<T> s=new SingleEdgeWithWeight<T>(start,end,weight);
				insertIntEdgesList(s);
			}
		}
	}
	
	private void insertIntEdgesList(SingleEdgeWithWeight<T> single){
		for(int i=0;i<edges.size();i++){
			if(edges.get(i).getWeight()>=single.getWeight()){
				edges.add(i, single);
				return;
			}
		}
		edges.add(single);
	}
	
	
}
