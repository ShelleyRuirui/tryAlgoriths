package dynamic;

import java.util.ArrayList;

public class LongestPanlidromeSubSeq {

	public int longestPanlidromeSeq(String input){
		if(input == null || input.length()==0) return 0;
		if(input.length()==1) return 1;
		
		int[][] lengths=new int[input.length()][input.length()];
		for(int i=0;i<=input.length()-1;i++){
			lengths[i][i]=1;
		}
		for(int i=input.length()-2;i>=0;i--){
			for(int j=i+1;j<input.length();j++){
				int candidate=Math.max(lengths[i][j-1], lengths[i+1][j]);
				if(i<=j-2 && input.charAt(i)==input.charAt(j))
					lengths[i][j]=Math.max(lengths[i+1][j-1]+2, candidate);
				else if(i==j-1&&input.charAt(i)==input.charAt(j))
					lengths[i][j]=2;
				else
					lengths[i][j]=candidate;
			}
		}
		return lengths[0][input.length()-1];
	}
	
	
	public String longestSeq(String input){
		if(input == null || input.length()==0 || input.length()==1) return input;
		String[][] subs=new String[input.length()][input.length()];
		int[][] lengths=new int[input.length()][input.length()];
		for(int i=0;i<=input.length()-1;i++){
			subs[i][i]=input.substring(i,i+1);
			lengths[i][i]=1;
		}
		for(int i=input.length()-2;i>=0;i--){
			for(int j=i+1;j<input.length();j++){
				int candidate=Math.max(lengths[i][j-1], lengths[i+1][j]);
				if(i<=j-2 && input.charAt(i)==input.charAt(j)){
					lengths[i][j]=Math.max(lengths[i+1][j-1]+2, candidate);
					if(lengths[i][j]==lengths[i][j-1])
						subs[i][j]=subs[i][j-1];
					else if(lengths[i][j]==lengths[i+1][j])
						subs[i][j]=subs[i+1][j];
					else
						subs[i][j]=input.charAt(i)+subs[i+1][j-1]+input.charAt(j);
				}
					
				else if(i==j-1&&input.charAt(i)==input.charAt(j)){
					lengths[i][j]=2;
					subs[i][j]=input.substring(i,i+2);
				}
				else{
					lengths[i][j]=candidate;
					if(lengths[i][j]==lengths[i][j-1])
						subs[i][j]=subs[i][j-1];
					else
						subs[i][j]=subs[i+1][j];
				}
					
			}
		}
		return subs[0][input.length()-1];
	}
	
	public static void main(String[] args){
		LongestPanlidromeSubSeq l=new LongestPanlidromeSubSeq();
		System.out.println(l.longestPanlidromeSeq("ACGTGTCAAAATCG"));
		System.out.println(l.longestSeq("ACGTGTCAAAATCG"));
	}
}
