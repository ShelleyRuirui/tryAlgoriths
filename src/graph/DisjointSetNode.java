package graph;

public class DisjointSetNode {

	private DisjointSetNode parent;
	private String content;
	private int rank;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public DisjointSetNode(String content){
		this(null,content);
		rank=0;
	}
	
	public DisjointSetNode(DisjointSetNode parent, String content) {
		super();
		this.parent = parent;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public DisjointSetNode getParent() {
		return parent;
	}

	public void setParent(DisjointSetNode parent) {
		this.parent = parent;
	}
	
}
