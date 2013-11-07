package problems;

import java.util.ArrayList;

/*
 * n=4, m=3,连招公式为:ABC→D,ABC→C,CCA→A,BCC→A。
 * 连招公式的意思是:A、B、C 可以连出 C,也可连出 D,C、C、A 可以连出 A,B、C、A、
 * 可以连出 B。这时候可以得到最长连招公式: ABC→C→A→A,
 * 即最长连招公式长度为 6 
 */

public class MaxSequenceOfRules {

	private int  m=3;
	private int n=4;
	private String[] rules={"ABCD","ABCC","CCAA","BCCA"};
	
	public String findLongestRule(){
		String result=null;
		
		return result;
	}
	
	public void test1(){
		System.out.println(naiveFind());
	}
	
	private String naiveFind(){
		ArrayList<String> results=new ArrayList<String>();
		for(String rule:rules){
			results.add(naiveFind(rule));
		}
		return getBestResult(results);
	}
	
	private String naiveFind(String current){
		String newPrefix=current.substring(current.length()-3,current.length());
		ArrayList<String> allResults=new ArrayList<String>();
		//First iterate all recursively to find the possible results
		for(int i=0;i<n;i++){
			String curPrefix=rules[i].substring(0, m);
			if(newPrefix.equals(curPrefix)){
				String newCurrent=current+rules[i].charAt(m);
				allResults.add(naiveFind(newCurrent));
			}
		}
		
		//Compare the results
		if(allResults.size()==0)
			return current;
		
		return getBestResult(allResults);
	}
	
	private String getBestResult(ArrayList<String> results){
		String maxStr=null;
		int maxLength=0;
		for(String res:results){
			if(res.length()>maxLength){
				maxStr=res;
				maxLength=res.length();
			}
		}
		return maxStr;
	}
	
	public static void main(String[] args) {
		MaxSequenceOfRules main=new MaxSequenceOfRules();
		main.test1();
	}

}
