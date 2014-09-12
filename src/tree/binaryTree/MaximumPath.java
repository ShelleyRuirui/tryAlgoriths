package tree.binaryTree;
 
//Maximum path in a tree problem 3.8 from <bian cheng zhi mei>
public class MaximumPath {

	int maxPath=0;
	public class TreeNode{
		TreeNode leftChild;
		TreeNode rightChild;
		int leftMaxDepth;
		int rightMaxDepth;
		String content;
	}
	
	public void longestPath(TreeNode root){
		if(root==null) return;
		if(root.leftChild!=null)
			longestPath(root.leftChild);
		
		if(root.rightChild!=null)
			longestPath(root.rightChild);
		
		if(root.leftChild!=null){
			root.leftMaxDepth=Math.max(root.leftChild.leftMaxDepth, root.leftChild.rightMaxDepth)+1;
		}else{
			root.leftMaxDepth=0;
		}
		
		if(root.rightChild!=null){
			root.rightMaxDepth=Math.max(root.rightChild.leftMaxDepth, root.rightChild.rightMaxDepth)+1;
		}else{
			root.rightMaxDepth=0;
		}
		
		int candidate=root.leftMaxDepth+root.rightMaxDepth+1;
		if(candidate>maxPath)
			maxPath=candidate;
	}
}
