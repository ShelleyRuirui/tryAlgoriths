package dynamic;

public class MaxProdSubArray {

	public int maxProduct(int[] A) {
        if(A==null || A.length==0) return 0;
        if(A.length==1) return A[0];
        
        int max=A[0];
        int[] endMax=new int[A.length];
        int[] endMin=new int[A.length];
        endMax[0]=A[0];
        endMin[0]=A[0];
        for(int i=1;i<A.length;i++){
        	int candiMax=Math.max(endMax[i-1]*A[i], endMin[i-1]*A[i]);
        	int candiMin=Math.min(endMax[i-1]*A[i], endMin[i-1]*A[i]);
        	endMax[i]=Math.max(candiMax, A[i]);
        	endMin[i]=Math.min(candiMin, A[i]);
        	if(endMax[i]>max) max=endMax[i];
        }
        
        
        return max;
    }
	
	public static void main(String[] args){
		MaxProdSubArray s=new MaxProdSubArray();
		int[] input=new int[]{-5,2,3,-2,4};
		System.out.println(s.maxProduct(input));
	}
	
	
}
