package heap;

import java.util.ArrayList;

//It's a complete binary tree
public class Heap {

	int[] contents;
	int heapSize;
	
	public Heap(int[] heap){
		contents=heap;
		heapSize=heap.length;
	}
	
	
	public int parent(int childIndex){
		if(childIndex==0) return -1;
		return  (childIndex-1)/2;
	}
	
	public int left(int parentIndex){
		int res=2*parentIndex+1;
		if(res>=heapSize)
			return -1;
		return res;
	}
	
	public int right(int parentIndex){
		int res=2*parentIndex+2;
		if(res>=heapSize)
			return -1;
		return res;
	}
	
	//This is O(n): n/2^(h+1) * O(h)
	public void buildHeap(){
		for(int i=heapSize/2;i>=0;i--)
			maxHeapify(i);
	}
	
	public void heapSort(){
		buildHeap();
		for(int i=heapSize-1;i>=1;i--){
			swap(0,i);
			heapSize--;
			maxHeapify(0);
		}
	}
	
	//i and its left right child meets requirements
	public void maxHeapify(int i){
		if(i>=contents.length) return;
		int left=left(i);
		int right=right(i);
		if(left==-1) return;
		if(right==-1){
			if(contents[i]<contents[left]){
				swap(i,left);
			}
			return;
		}
		
		if(contents[i]>=contents[left] && contents[i]>=contents[right]) return;
		
		if(contents[left]<contents[right]){
			//Swap right
			swap(i,right);
			maxHeapify(right);
		}else{
			//Swap left
			swap(i,left);
			maxHeapify(left);
		}
	}
	
	public void print(){
		int height= (int) (Math.log(contents.length+1)/Math.log(2));
		int lastLength=2*(int)(Math.pow(2, height-1));
		StringBuilder result=new StringBuilder();
		ArrayList<Integer> pos=new ArrayList<Integer>();
		for(int i=0;i<lastLength;i+=2){
			pos.add(i);
		}
		//TODO append last line
		int index=0;
		int curHeight=height-1;
		int curItemCount=lastLength/2;
		while(curHeight>0){
			StringBuilder curLine=new StringBuilder();
			int prev=0;
			for(int i=0;i<curItemCount;i++){
				int left=pos.remove(0);
				int right=pos.remove(0);
				int curLocation=(left+right)/2;
				for(int j=0;j<curLocation;j++){
					curLine.append(" ");
				}
				curLine.append(contents[index]);
				prev=curLocation+1;
				pos.add(curLocation);
			}
		}
	}
	
	public void printPlain(){
		for(int i:contents){
			System.out.print(i+" ");
		}
	}
	
	private void swap(int i,int j){
		if(i!=j){
			int tmp=contents[i];
			contents[i]=contents[j];
			contents[j]=tmp;
		}
	}
	
	public static void main(String[] args){
		int[] numbers=new int[]{1,2,3,4,5,6};
		Heap h=new Heap(numbers);
		h.heapSort();
		h.printPlain();
	}
}
