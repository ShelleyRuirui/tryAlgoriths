package dynamic;

public class MaxSumSubArray {

	public int maxSumDynamic(int[] array){
		if(array==null || array.length==0 ) return 0;
		if(array.length==1) return Math.max(array[0], 0);
		
		int max=0;
		int[] end=new int[array.length+1];
		end[0]=0;
		for(int i=0;i<array.length;i++){
			//calc sequence that end at i
			end[i+1]=end[i]<0?array[i]:end[i]+array[i];
			if(end[i+1]>max)
				max=end[i+1];
		}
		
		return max;
	}
	
	public static void main(String[] args){
		MaxSumSubArray m=new MaxSumSubArray();
		int[] input={5,15,-30,10,-5,40,10};
		System.out.println(m.maxSumDynamic(input));
	}
	
	
}
