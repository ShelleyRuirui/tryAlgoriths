package others;

import java.util.ArrayList;

public class FindMaxGrowSequence {

	public static ArrayList<Integer> findMaxGrowSeq(ArrayList<Integer> input){
		ArrayList<Integer> result=new ArrayList<Integer>();
		ArrayList<Integer> temp=new ArrayList<Integer>();		
		int max=0;
		int current=1;
		temp.add(input.get(0));
		for(int i=0;i<input.size()-1;i++){
			if(input.get(i)<=input.get(i+1)){
				current++;
				temp.add(input.get(i+1));
			}else{
				if(max<current){
					result=temp;					
					max=current;
				}
				current=1;
				temp=new ArrayList<Integer>();
				temp.add(input.get(i+1));
			}
		}
		
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> input=new ArrayList<Integer>();
		input.add(3);
		input.add(8);
		input.add(9);
		input.add(7);
		input.add(1);
		input.add(4);
		input.add(3);
		input.add(4);
		input.add(7);
		input.add(5);
		
		ArrayList<Integer> result=findMaxGrowSeq(input);
		for(int i:result){
			System.out.print(i+" ");
		}
	}

}
