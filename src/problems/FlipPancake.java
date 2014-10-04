package problems;

import java.util.ArrayList;

public class FlipPancake {

	int searchCount;
	ArrayList<Integer> curPancakes;
	ArrayList<Integer> steps;
	ArrayList<Integer> finalResults;
	ArrayList<Integer> swapResults;
	int minSwap;
	
	private void init(int[] cakes){
		curPancakes=new ArrayList<Integer>();
		steps=new ArrayList<Integer>();
		finalResults=new ArrayList<Integer>();
		swapResults=new ArrayList<Integer>();
		minSwap=2*cakes.length;
		for(int cake:cakes)
			curPancakes.add(cake);
		
	}
	
	public void flip(int[] cakes){
		init(cakes);
		search(0);
		printResults();
	}
	
	public void printResults(){
		System.out.println("final cakes:");
		for(int i:finalResults){
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("steps:");
		for(int i:swapResults){
			System.out.print(i+" ");
		}
	}
	
	private int lowerBound(ArrayList<Integer> cakes){
		int res=0;
		for(int i=0;i<cakes.size()-1;i++){
			if(Math.abs(cakes.get(i)-cakes.get(i+1))!=1){
				res++;
			}
		}
		return res;
	}
	
	private void search(int step){
		searchCount++;
		if(searchCount%100000==0){
			System.out.println("Search count:"+searchCount);
		}
		
		int estimate=lowerBound(curPancakes);
		if(step+estimate>curPancakes.size()*2) return;
		
		
		if(isSorted(curPancakes) && step<minSwap){
			minSwap=step;
			finalResults=new ArrayList<Integer>();
			swapResults=new ArrayList<Integer>();
			for(int i:curPancakes){
				finalResults.add(i);
			}
			for(int i=0;i<step;i++){
				swapResults.add(steps.get(i));
			}
			return;
		}
		
		for(int i=1;i<curPancakes.size();i++){
			reverse(curPancakes,i);
			if(steps.size()>step)
				steps.set(step, i);
			else
				steps.add(i);
			search(step+1);
			
			reverse(curPancakes,i);
		}
	}
	
	private void reverse(ArrayList<Integer> cakes,int index){
		if(index==0) return;
		int i=0;
		int j=index;
		for(;i<j;i++,j--){
			int temp=cakes.get(i);
			cakes.set(i, cakes.get(j));
			cakes.set(j, temp);
		}
	}
	
	private boolean isSorted(ArrayList<Integer> cakes){
		for(int i=0;i<cakes.size()-1;i++){
			if(cakes.get(i)>cakes.get(i+1))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		FlipPancake f=new FlipPancake();
		int[] cakes=new int[]{3,2,1,6,5,4,9,8,7,0};
//		int[] cakes=new int[]{6,3,1,2};
		f.flip(cakes);
	}
}
