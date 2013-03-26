package graph;

public class Test2 {

	/**
	 * @param args
	 * @throws EdgeVerticeNotFound 
	 */
	public static void main(String[] args) throws EdgeVerticeNotFound {
		test1();
	}
	
	public static void test1() throws EdgeVerticeNotFound{
		GraphWithWeight<Character> graph=new GraphWithWeight<Character>();
		for(char start='A';start<='F';start++){
			graph.addVertice(start);
		}
		
		graph.addEdge('A', 'B', 4);
		graph.addEdge('A', 'C', 1);
		graph.addEdge('A', 'D', 3);
		graph.addEdge('B', 'A', 4);
		graph.addEdge('B', 'C', 4);
		graph.addEdge('B', 'D', 4);
		graph.addEdge('C', 'A', 1);
		graph.addEdge('C', 'B', 4);
		graph.addEdge('C', 'D', 2);
		graph.addEdge('C', 'F', 4);
		graph.addEdge('D', 'A', 3);
		graph.addEdge('D', 'B', 4);
		graph.addEdge('D', 'C', 2);
		graph.addEdge('D', 'F', 6);
		graph.addEdge('E', 'F', 5);
		graph.addEdge('F', 'C', 4);
		graph.addEdge('F', 'D', 6);
		graph.addEdge('F', 'E', 5);
		
		MST<Character> mst=new MST<Character>(graph);
		mst.printMST();
	}

}
