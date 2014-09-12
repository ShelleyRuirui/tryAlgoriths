package basicstruct.stackusage;

import java.util.Stack;

//The problem is to calc the maximum area of a histogram
//This is a solution from leetcode https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
public class MaxHistoArea {

	public int largestRectangleArea(int[] height){
		if(height==null || height.length==0) return 0;
		if(height.length==1) return height[0];
		
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(-1);
		
		int max=0;
		for(int i=0;i<height.length;i++){
			int curHeight=height[i];
			int peekIndex=stack.peek();
			
			while(peekIndex!=-1 && height[peekIndex]>curHeight){
				//Meet smaller value, can calculate
				stack.pop();
				int newPeek=stack.peek();
				//Next peek till current pop are all larger than current pop
				max=Math.max(max, height[peekIndex]*(i-newPeek-1));
				peekIndex=newPeek;
			}
			
			stack.push(i);
		}
		
		while(stack.peek()!=-1){
			int top=stack.pop();
			max=Math.max(max, height[top]*(height.length-1-stack.peek()));
		}
		
		return max;
	}
	
	public static void main(String[] args){
		MaxHistoArea m=new MaxHistoArea();
		int[] histo=new int[]{2,1,5,6,2,3};
		System.out.println(m.largestRectangleArea(histo));
	}
}
