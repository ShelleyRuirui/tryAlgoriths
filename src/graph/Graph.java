package graph;

import java.util.ArrayList;

public class Graph<T> {
	
	ArrayList<Edges<T>> vertices=new ArrayList<Edges<T>>();
	
	public void addVertice(T ver){
		Edges<T> e=new Edges<T>(ver);
		vertices.add(e);
	}
	
	public void addEdgeWithDirection(T v1,T v2) throws EdgeVerticeNotFound{
		Edges<T> edges=findVerEdges(v1);
		if(edges==null){
			throw new EdgeVerticeNotFound("Edge vertice not found for "+v1.toString()+" "+v2.toString());
		}else{
			edges.addEndVertice(v2);
		}
	}
	
	private Edges<T> findVerEdges(T v) throws EdgeVerticeNotFound{
		for(Edges<T> edge:vertices){
			if(v.equals(edge.getStartVertice())){
				return edge;
			}
		}
		return null;
	}
	
	public Edges<T> findVerEdges(int index){
		return vertices.get(index);
	}
	
	public int findVerIndex(T ver) throws EdgeVerticeNotFound{
		for(int i=0;i<vertices.size();i++){
			if(vertices.get(i).getStartVertice().equals(ver))
				return i;
		}
		throw new EdgeVerticeNotFound("In findVerIndex");
	}
	
	public ArrayList<T> getAllVertices() throws EdgeVerticeNotFound{
		ArrayList<T> result=new ArrayList<T>();
		for(Edges<T> edge:vertices){
			result.add(edge.getStartVertice());
		}
		return result;
	}
	
	public void printGraph(){
		for(Edges<T> edge:vertices){
			for(T t:edge.edges){
				System.out.print(t+"->");
			}
			System.out.println();
		}
	}

	/**
	 * @param args
	 * @throws EdgeVerticeNotFound 
	 */
	public static void main(String[] args) throws EdgeVerticeNotFound {
		test1();
	}
	
	public static void test1() throws EdgeVerticeNotFound{
		Graph<Character> graph=new Graph<Character>();
		for(char start='A';start<='L';start++){
			graph.addVertice(start);
		}
		graph.addEdgeWithDirection('A', 'B');
		graph.addEdgeWithDirection('A', 'C');
		graph.addEdgeWithDirection('A', 'D');
		graph.addEdgeWithDirection('B', 'A');
		graph.addEdgeWithDirection('B', 'E');
		graph.addEdgeWithDirection('B', 'F');
		graph.addEdgeWithDirection('C', 'A');
		graph.addEdgeWithDirection('C', 'F');
		graph.addEdgeWithDirection('D', 'A');
		graph.addEdgeWithDirection('D', 'G');
		graph.addEdgeWithDirection('D', 'H');
		graph.addEdgeWithDirection('E', 'B');
		graph.addEdgeWithDirection('E', 'I');
		graph.addEdgeWithDirection('E', 'J');
		graph.addEdgeWithDirection('F', 'B');
		graph.addEdgeWithDirection('F', 'C');
		graph.addEdgeWithDirection('G', 'D');
		graph.addEdgeWithDirection('G', 'H');
		graph.addEdgeWithDirection('H', 'D');
		graph.addEdgeWithDirection('H', 'G');
		graph.addEdgeWithDirection('I', 'E');
		graph.addEdgeWithDirection('I', 'J');
		graph.addEdgeWithDirection('J', 'I');
		graph.addEdgeWithDirection('K', 'L');
		graph.addEdgeWithDirection('L', 'K');
		
		graph.printGraph();
		
		DFS<Character> dfs=new DFS<Character>();
//		dfs.DFSSearch(graph);
//		dfs.printTick();
		
//		dfs.printTopologyOrder(graph);
		dfs.DFSSearch(graph);
	}
	
	public static void test2(){
		
	}

}
