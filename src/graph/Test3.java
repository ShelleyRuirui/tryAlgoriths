package graph;

import linearPlanning.MaximumNetFlow;

public class Test3 {

	/**
	 * @param args
	 * @throws EdgeVerticeNotFound 
	 */
	public static void main(String[] args) throws EdgeVerticeNotFound {
		// TODO Auto-generated method stub
//		GraphWithWeight<Character> g=prepare();
//		test1(g);
		
		GraphWithWeight<Character> g=prepare2();
		test2(g);
	}
	
	public static GraphWithWeight<Character> prepare() throws EdgeVerticeNotFound{
		GraphWithWeight<Character> g=new GraphWithWeight<Character>();
		for(char start='A';start<='F';start++){
			g.addVertice(start);
		}
		g.addVertice('S');
		g.addEdge('S', 'A', 3);
		g.addEdge('S', 'C', 2);
		g.addEdge('S', 'D', 2);
		g.addEdge('S', 'E', 2);
		g.addEdge('A', 'B', 2);
		g.addEdge('B', 'C', 2);
		g.addEdge('D', 'E', 2);
		
		return g;
	}
	
	public static GraphWithWeight<Character> prepare2() throws EdgeVerticeNotFound{
		GraphWithWeight<Character> g=new GraphWithWeight<Character>();
		for(char start='A';start<='E';start++){
			g.addVertice(start);
		}
		g.addVertice('S');
		g.addVertice('T');
		g.addEdge('S', 'A', 3);
		g.addEdge('S', 'B', 3);
		g.addEdge('S', 'C', 4);
		g.addEdge('A', 'D', 2);
		g.addEdge('B', 'A', 10);
		g.addEdge('B', 'D', 1);
		g.addEdge('C', 'E', 5);
		g.addEdge('D', 'C', 1);
		g.addEdge('D', 'E', 1);
		g.addEdge('D', 'T', 2);
		g.addEdge('E', 'T', 5);
		return g;
	}
	
	public static void test1(GraphWithWeight<Character> g) throws EdgeVerticeNotFound{
		BFS<Character> bfs=new BFS<Character>(g);
		bfs.printPath('A', 'D');
	}
	
	public static void test2(GraphWithWeight<Character> g) throws EdgeVerticeNotFound{
		MaximumNetFlow f=new MaximumNetFlow(g);
		f.calcMaximumNetFlow('S', 'T');
	}

}
