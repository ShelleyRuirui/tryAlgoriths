package devideAndConquer;

public class CalcNthInArray {

	public static int findNth(int[] input,int number){
		int inputLength=input.length;
		if(number>inputLength || inputLength==0)
			return -1;
		
		int pivotIndex=0;
		int pivot=input[0];
		int i=1;
		int j=inputLength-1;
		while(i<j){
			while(i<inputLength && input[i]<=pivot)
				i++;
			while(j>=1 &&input[j]>=pivot)
				j--;
			if(i<j){
				//swap
				int temp=input[i];
				input[i]=input[j];
				input[j]=temp;
				i++;
				j--;
			}
		}
		
		int leftSize=Math.min(i, j);
		if(leftSize+1==number)
			return pivot;
		
		if(leftSize+1>number){
			int[] newInput=new int[leftSize];
			for(int k=0;k<leftSize;k++){
				newInput[k]=input[k+1];
			}
			return findNth(newInput,number);
		}else{
			int[] newInput=new int[inputLength-1-leftSize];
			int rightIndex=Math.max(i, j);
			for(int k=rightIndex;k<inputLength;k++){
				newInput[k-rightIndex]=input[k];
			}
			return findNth(newInput,number-1-leftSize);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={32,4,3,5,24,7,8,2,12,8,5,9};
		System.out.println(findNth(input,10));
	}

}
