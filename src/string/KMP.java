package string;

import java.util.HashSet;

public class KMP{
	
	public static int indexOfSubString(String str,String sub){
		int curIndex=0;
		int subIndex=0;
		boolean fastMove=false;
		while(curIndex<str.length() && subIndex<sub.length()){
			//If it matches
			if(str.charAt(curIndex)==sub.charAt(subIndex)){
				curIndex++;
				subIndex++;
				continue;
			}else{
				//If it doesn't match, calc new curIndex and new subIndex
				if(subIndex==0){   //The first doesn't match
					curIndex++;  
					continue;
				}else{       //Match to some point
					if(!fastMove){
						subIndex=calcNewPos(subIndex,sub);
						fastMove=true;
						continue;
					}else{
						subIndex=0;
						fastMove=false;
						continue;
					}
					
				}
			}
		}
		if(subIndex==sub.length()){
			return curIndex-subIndex;
		}
		
		return -1;
	}
	
	private static int calcNewPos(int matchLen,String sub){
		String matchStr=sub.substring(0, matchLen);
		
		//Calc the prefix-suffix table
		HashSet<String> prefix=new HashSet<String>();
		for(int i=1;i<matchStr.length();i++){
			prefix.add(matchStr.substring(0, i));
		}
		
		HashSet<String> suffix=new HashSet<String>();
		for(int i=1;i<matchStr.length();i++){
			suffix.add(matchStr.substring(i));
		}
		
		HashSet<String> intersect=new HashSet<String>();
		intersect.addAll(prefix);
		intersect.retainAll(suffix);
//		System.out.println("Intersect:"+intersect);
		
		int maxLength=0;
		for(String s:intersect){
			maxLength=Math.max(maxLength, s.length());
		}
		return maxLength;
	}
	
	private static void testCalcPos(){
		System.out.println(calcNewPos(5,"abcdabd"));
	}
	
	private static void test1(){
//		System.out.println(indexOfSubString("aabc","abc"));
		System.out.println(indexOfSubString("abbaaca","aac"));
		System.out.println(indexOfSubString("baababa","ababa"));
		System.out.println(indexOfSubString("abcdcabcdabcd","abcdab"));
		System.out.println(indexOfSubString("bbc abcdab abcdabcdabde","abcdabd"));
	}
	
	public static void main(String[] args) {
//		testCalcPos();
		test1();
	}
}