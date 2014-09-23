package problems;

public class CellphoneNumToChar {

	public String[] mapping=new String[]{"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
	
	public void printAllCombinationsRecur(String number){
		printRecur(number,0,"");
	}
	
	public void printRecur(String number,int index,String prefix){
		if(index==number.length()){
			System.out.println(prefix);
			return;
		}
		
		for(int i=0;i<mapping[Integer.parseInt(number.substring(index,index+1))].length();i++){
			printRecur(number,index+1,prefix+mapping[Integer.parseInt(number.substring(index,index+1))].substring(i,i+1));
		}
	}
	
	public void printAllCombinationNonRecur(String number){
		int[] answer=new int[number.length()];
		for(int i=0;i<answer.length;i++){
			answer[i]=0;
		}
		while(true){
			for(int i=0;i<number.length();i++){
				System.out.print(mapping[Integer.parseInt(number.substring(i,i+1))].charAt(answer[i]));
			}
			System.out.println();
			int k=number.length()-1;
			while(k>=0){
				if(answer[k]<mapping[Integer.parseInt(number.substring(k,k+1))].length()-1){
					answer[k]++;
					break;
				}else{
					answer[k]=0;
					k--;
				}
			}
			if(k<0) break;
		}
		
	}
	
	public void printLen3Combination(String number){
		if(number.length()!=3) return;
		for(int i=0;i<mapping[Integer.parseInt(number.substring(0,1))].length();i++){
			for(int j=0;j<mapping[Integer.parseInt(number.substring(1,2))].length();j++){
				for(int k=0;k<mapping[Integer.parseInt(number.substring(2,3))].length();k++){
					String first=mapping[Integer.parseInt(number.substring(0,1))].substring(i,i+1);
					String second=mapping[Integer.parseInt(number.substring(1,2))].substring(j,j+1);
					String third=mapping[Integer.parseInt(number.substring(2,3))].substring(k,k+1);
					
					System.out.println(first+" "+second+" "+third);
				}
			}
		}
	}
	
	public static void main(String[] args){
		CellphoneNumToChar c=new CellphoneNumToChar();
		//c.printLen3Combination("234");
		//c.printAllCombinationsRecur("2345");
		c.printAllCombinationNonRecur("23");
	}
}
