package graph;

import java.util.ArrayList;

public class FindStrongComponent<T> extends DFS<T> {

	public Graph<String> findStrongComponent(Graph<T> g) throws EdgeVerticeNotFound{
		Graph<String> graph=new Graph<String>();
		DFS<T> dfs=new DFS<T>();
		dfs.DFSSearch(g);
		
		ArrayList<Integer> origPostClock=new ArrayList<Integer>();
		for(int temp:dfs.clock2){
			origPostClock.add(temp);
		}
		
		int count=0;
		Graph<T> reversedGraph=g.createReversedGraph();
		ArrayList<T> prevTs=new ArrayList<T>();
		ArrayList<T> currentTs=new ArrayList<T>();
		ArrayList<ArrayList<T>> allTs=new ArrayList<ArrayList<T>>();
		while(count!=g.vertices.size()){
			int maxIndex=findMaxIndex(origPostClock);
			if(maxIndex==-1)
				throw new EdgeVerticeNotFound("In findStrongComponent");			
			
			DFS<T> dfs2=new DFS<T>(reversedGraph);
			dfs2.explore(reversedGraph, reversedGraph.vertices.get(maxIndex).getStartVertice());
			
			ArrayList<Integer> toDelete=new ArrayList<Integer>();
			
			for(int i=0;i<dfs2.visited.length;i++){
				if(dfs2.visited[i]){
					T current=reversedGraph.vertices.get(i).getStartVertice();
					currentTs.add(current);
					
					toDelete.add(i);
					
					count++;
				}					
			}
			allTs.add(currentTs);
			int modifyCount=0;
			for(int i=0;i<toDelete.size();i++){
				reversedGraph.deleteVerticeByIndex(toDelete.get(i)-modifyCount);
				origPostClock.remove(toDelete.get(i)-modifyCount);
				modifyCount++;
			}
			
			StringBuilder newNode=new StringBuilder("");
			for(T ver:currentTs){
				newNode.append(ver);
			}
			String newNodeStr=newNode.toString();
			graph.addVertice(newNodeStr);			
		
			prevTs=currentTs;
			currentTs=new ArrayList<T>();
		}
		
		for(int i=0;i<allTs.size();i++){
			ArrayList<T> first=allTs.get(i);
next:	for(int j=i+1;j<allTs.size();j++){
				ArrayList<T> second=allTs.get(j);
				for(int k1=0;k1<first.size();k1++){
					for(int k2=0;k2<second.size();k2++){
						if(g.containsEdge(first.get(k1), second.get(k2))){
							graph.addEdgeInIndex(i, j);
							continue next;
						}
					}
				}
			}
		}
		
		return graph;
	}
	
	private int findMaxIndex(ArrayList<Integer> input){
		int max=0;
		int maxIndex=-1;
		for(int i=0;i<input.size();i++){
			if(max<input.get(i)){
				max=input.get(i);
				maxIndex=i;
			}
		}
		return maxIndex;
	}
}
