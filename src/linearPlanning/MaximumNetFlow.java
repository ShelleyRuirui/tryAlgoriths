package linearPlanning;

import graph.BFS;
import graph.EdgeVerticeNotFound;
import graph.EndAndWeight;
import graph.GraphWithWeight;

import java.util.ArrayList;

public class MaximumNetFlow {

	GraphWithWeight<Character> g;
	public MaximumNetFlow(GraphWithWeight<Character> graph){
		g=graph;
	}
	
	public GraphWithWeight<Character> calcMaximumNetFlow(Character start,Character end) throws EdgeVerticeNotFound{
		GraphWithWeight<Character> result=new GraphWithWeight<Character>();
		
		BFS<Character> bfs=new BFS<Character>(g);
		ArrayList<EndAndWeight<Character>> path=bfs.BFSPath(start, end);
		int totalFlow=0;
		
		while(path!=null&&path.size()!=0){
			//find the min flow in the path and add the value to the total flow
			int min=findMinWeight(path);
			totalFlow+=min;
			// modify the graph:1.reduce the flow in the prev edge,if it's zero,remove it and 
			// 2.increase the flow to the reversed edge
			for(int i=0;i<path.size()-1;i++){
				EndAndWeight<Character> edge=path.get(i);
				g.decreaseOrDeleteEdge(path.get(i+1).getNode(), edge.getNode(), min);
				g.addOrIncreaseReverseEdge(path.get(i+1).getNode(), edge.getNode(), min);
			}
			//TODO: needs to deep clone the original graph and then compute the final graph
			g.printGraph();
			path=bfs.BFSPath(start, end);
		}
		
		System.out.println(totalFlow);
		return result;
	}
	
	private int findMinWeight(ArrayList<EndAndWeight<Character>> path){
		int min=path.get(0).getWeight();
		for(int i=1;i<path.size()-1;i++){ //The last is the start itself, so it will not be counted
			if(path.get(i).getWeight()<min)
				min=path.get(i).getWeight();
		}
		return min;
	}
	
}
