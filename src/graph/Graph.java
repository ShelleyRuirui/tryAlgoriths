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
	
	public void addEdgeInIndex(int i1,int i2) throws EdgeVerticeNotFound{
		Edges<T> edges=vertices.get(i1);
		edges.addEndVertice(vertices.get(i2).getStartVertice());
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
	
	public void deleteVerticeByIndex(int index) throws EdgeVerticeNotFound{
		T ver=vertices.get(index).getStartVertice();
		vertices.remove(index);
		for(Edges<T> edges:vertices){
			edges.removeEdge(ver);
		}
	}
	
	public Graph<T> createReversedGraph() throws EdgeVerticeNotFound{
		Graph<T> graph=new Graph<T>();
		ArrayList<T> allVertices=getAllVertices();
		for(T ver:allVertices){
			graph.addVertice(ver);
		}
		for(Edges<T> edges:vertices){
			T startVer=edges.getStartVertice();
			ArrayList<T> vers=edges.edges;
			for(int i=1;i<vers.size();i++){
				graph.addEdgeWithDirection(vers.get(i),startVer);
			}
		}
		return graph;
	}
	
	public boolean containsEdge(T v1,T v2) throws EdgeVerticeNotFound{
		Edges<T> edges=findVerEdges(v1);
		return edges.containsEnd(v2)!=-1;
	}

	/**
	 * @param args
	 * @throws EdgeVerticeNotFound 
	 */
	public static void main(String[] args) throws EdgeVerticeNotFound {
		test2();
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
	
	public static void test2() throws EdgeVerticeNotFound{
		Graph<Character> graph=new Graph<Character>();
		graph.addVertice('A');
		graph.addVertice('C');
		graph.addVertice('D');
		graph.addVertice('B');
		
		graph.addEdgeWithDirection('A', 'C');
		graph.addEdgeWithDirection('A', 'D');
		graph.addEdgeWithDirection('A', 'B');
		
		graph.addEdgeWithDirection('B', 'A');
		graph.addEdgeWithDirection('B', 'C');
		graph.addEdgeWithDirection('C', 'A');
		graph.addEdgeWithDirection('C', 'B');
		graph.addEdgeWithDirection('C', 'D');
		graph.addEdgeWithDirection('D', 'A');
		graph.addEdgeWithDirection('D', 'C');
		
		DFS<Character> dfs=new DFS<Character>();
		dfs.DFSSearch(graph);

	}

}
