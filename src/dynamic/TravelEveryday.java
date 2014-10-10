package dynamic;

/*
 *  gas stations: a1,a2...an and 200 miles every day, panelty (200-x)^2
 *  Prob 6.2 from algorithms
 */
public class TravelEveryday {

	public String minPenalty(int[] stations,int maxPerday){
		int length=stations.length;
		int penalties[]=new int[length]; //Penalty if stop in ai
		int[] result=new int[length];
		penalties[0]=0;
		for(int i=1;i<length;i++){
			penalties[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<length-1;i++){
			//Update possible places
			for(int j=i+1;j<length;j++){
				int dist=stations[j]-stations[i];
				if(dist<=maxPerday){
					int candidate=penalties[i]+(maxPerday-dist)*(maxPerday-dist);
					if(candidate< penalties[j]){
						penalties[j]=candidate;
						result[j]=i;
					}
				}else
					break;
			}
		}
		
		StringBuilder sb=new StringBuilder();
		int prev=result[length-1];
		while(prev!=0){
			sb.insert(0, prev+" ");
			prev=result[prev];
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		TravelEveryday t=new TravelEveryday();
		int[] s=new int[]{0,10,19,25,39,45,50,65};
		System.out.println(t.minPenalty(s, 20));
	}
}
