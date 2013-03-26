package graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

	Map<String,DisjointSetNode> nodes=new HashMap<String,DisjointSetNode>();
	public void makeSet(String str){
		DisjointSetNode root=new DisjointSetNode(str);
		nodes.put(str, root);
	}
	
	public DisjointSetNode findRoot(String content){
		DisjointSetNode current=nodes.get(content);
		while(current.getParent()!=null)
			current=current.getParent();
		return current;
	}
	
	public void union(String node1,String node2){
		DisjointSetNode root1=findRoot(node1);
		DisjointSetNode root2=findRoot(node2);		
		if(root1.equals(root2))
			return;
		if(root1.getRank() > root2.getRank())
			root2.setParent(root1);
		else
			root1.setParent(root2);
		if(root1.getRank()==root2.getRank())
			root2.setRank(root2.getRank()+1);
	}
	
	public boolean inSameSet(String node1,String node2){
		DisjointSetNode root1=findRoot(node1);
		DisjointSetNode root2=findRoot(node2);		
		if(root1.equals(root2))
			return true;
		return false;
	}

}
