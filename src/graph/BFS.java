package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFS<T> {
	GraphWithWeight<T> graph;
	
	public BFS(GraphWithWeight<T> g){
		graph=g;
	}
	
	//The result stores the reversed order of the path
	public ArrayList<EndAndWeight<T>> BFSPath(T start,T end) throws EdgeVerticeNotFound{
		Map<T,ArrayList<EndAndWeight<T>>> map=new HashMap<T,ArrayList<EndAndWeight<T>>>();
		
		Queue<T> queue=new LinkedList<T>();
		queue.add(start);
		ArrayList<EndAndWeight<T>> startList=new ArrayList<EndAndWeight<T>>();
		startList.add(new EndAndWeight<T>(start,0));
		map.put(start, startList);
		
		while(queue.size()!=0){
			T currentVertice=queue.poll();
			
			EdgesWithWeight<T> nextVertices=graph.findVerEdges(currentVertice);
			for(int i=1;i<nextVertices.edges.size();i++){
				T nextVertice=nextVertices.edges.get(i);
				int toNextWeight=nextVertices.weight.get(i);
				if(map.get(nextVertice)!=null)
					continue;
				ArrayList<EndAndWeight<T>> nextPath=new ArrayList<EndAndWeight<T>>();
				nextPath.add(new EndAndWeight<T>(nextVertice,toNextWeight));
				ArrayList<EndAndWeight<T>> currentPath=map.get(currentVertice);
				if(currentPath==null)
					System.err.println("Err:current path doesn't exist");
				nextPath.addAll(currentPath);
				map.put(nextVertice, nextPath);
				queue.offer(nextVertice);
				if(nextVertice.equals(end))
					return nextPath;
			}
		}
		return null;
	}
	
	public void printPath(T start,T end) throws EdgeVerticeNotFound{
		ArrayList<EndAndWeight<T>> path=BFSPath(start,end);
		if(path==null)
			return;
		for(int i=path.size()-1;i>=0;i--){
			System.out.print(path.get(i).node+"->("+path.get(i).weight+")");
		}
	}
}
