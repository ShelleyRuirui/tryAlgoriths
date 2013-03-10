package graph;

public class Test {

	/**
	 * @param args
	 * @throws EdgeVerticeNotFound 
	 */
	public static void main(String[] args) throws EdgeVerticeNotFound {
		test2();
	}
	
	//Test reversed graph
	public static void test1() throws EdgeVerticeNotFound{
		Graph<Character> graph=new Graph<Character>();
		for(char start='A';start<='F';start++){
			graph.addVertice(start);
		}
		graph.addEdgeWithDirection('A', 'C');
		graph.addEdgeWithDirection('B', 'A');
		graph.addEdgeWithDirection('B', 'D');
		graph.addEdgeWithDirection('C', 'E');
		graph.addEdgeWithDirection('C', 'F');
		graph.addEdgeWithDirection('D', 'C');
		
		
		graph.printGraph();
		
		Graph<Character> reversed=graph.createReversedGraph();
		reversed.printGraph();
	}

	//Test find strong components
		public static void test2() throws EdgeVerticeNotFound{
			Graph<Character> graph=new Graph<Character>();
			for(char start='A';start<='F';start++){
				graph.addVertice(start);
			}
//			graph.addEdgeWithDirection('A', 'C');
//			graph.addEdgeWithDirection('B', 'A');
//			graph.addEdgeWithDirection('B', 'D');
//			graph.addEdgeWithDirection('C', 'E');
//			graph.addEdgeWithDirection('C', 'F');
//			graph.addEdgeWithDirection('D', 'C');
			
			graph.addEdgeWithDirection('A', 'B');
			graph.addEdgeWithDirection('B', 'C');
			graph.addEdgeWithDirection('B', 'D');
			graph.addEdgeWithDirection('B', 'E');
			graph.addEdgeWithDirection('C', 'F');
			graph.addEdgeWithDirection('E', 'B');
			graph.addEdgeWithDirection('E', 'F');
			graph.addEdgeWithDirection('F', 'C');
			graph.printGraph();
			System.out.println("******************");
			FindStrongComponent<Character> fc=new FindStrongComponent<Character>();
			Graph<String> components=fc.findStrongComponent(graph);
			components.printGraph();
		}
}
