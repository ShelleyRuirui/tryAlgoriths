package graph;

import java.util.ArrayList;
import java.util.Stack;

public class DFS<T> {
	boolean visited[];
	int clock[];
	int clock2[];
	int tick=0;
	StringBuilder currentPath=new StringBuilder("");

	public void DFSSearch(Graph<T> g) throws EdgeVerticeNotFound{
		ArrayList<T> vertices=g.getAllVertices();
		
		int size=vertices.size();
		visited=new boolean[size];
		clock=new int[size];
		clock2=new int[size];
		for(int i=0;i<size;i++){
			visited[i]=false;
		}
		
		for(int i=0;i<size;i++){
			if(!visited[i])
				explore(g,vertices.get(i));
		}
	}
	
	public void explore(Graph<T> g,T vertice) throws EdgeVerticeNotFound{
		int index=g.findVerIndex(vertice);
		if(!visited[index]){
			previsit(vertice,index);
			visited[index]=true;
			Edges<T> curEdges=g.findVerEdges(index);
			for(int i=1;i<curEdges.edges.size();i++){
				T end=curEdges.edges.get(i);
				int previousIndex=findPreviousInPath(end);
				if( previousIndex != -1){
					System.out.println("Circle detected");
					System.out.println(currentPath.toString().substring(previousIndex));
				}
				explore(g,end);
			}
			postvisit(vertice,index);
		}
		
	}
	
	private void previsit(T v,int index){
		System.out.println("previsit:"+v);
		clock[index]=tick;
		tick++;
		currentPath.append(v.toString());
		//To see if a graph is connected, use a counter here +1
	}
	
	private void postvisit(T v,int index){
		System.out.println("postvisit:"+v);
		clock2[index]=tick;
		tick++;
		currentPath.deleteCharAt(currentPath.length()-1);
	}
	
	private int findPreviousInPath(T value){
		int result=-1;
		for(int i=0;i<currentPath.length()-2;i++){
			if((currentPath.charAt(i)+"").equals(value.toString()))
				return i;
		}
		return result;
	}
	
	public void printTick(){
		System.out.println("******************");
		System.out.println("Print tick:");
		for(int i=0;i<clock.length;i++)
			System.out.print("\t"+clock[i]+"\t");
		System.out.println();
		for(int i=0;i<clock.length;i++)
			System.out.print("\t"+clock2[i]+"\t");
	}
	
	public void printTopologyOrder(Graph<T> g) throws EdgeVerticeNotFound{
		DFSSearch(g);
		ArrayList<Integer> result=new ArrayList<Integer>();
		ArrayList<Integer> newInput=new ArrayList<Integer>();
		for(int i:clock2){
			newInput.add(i);
		}
		
		while(result.size()!=clock2.length){
			int max=0;
			int maxIndex=-1;
			for(int i=0;i<newInput.size();i++){
				if(newInput.get(i)>max){
					max=newInput.get(i);
					maxIndex=i;
				}
			}
			result.add(maxIndex);
			newInput.set(maxIndex, 0);
		}
		
		for(int i:result){
			System.out.println(g.vertices.get(i).getStartVertice());
		}
	}
	
}
