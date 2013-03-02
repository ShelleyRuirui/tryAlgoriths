package dynamic;

import java.util.ArrayList;

public class CaclCommonSubStr {
	
	public static ArrayList<String> computeCommonSubStr (String s1,String s2){
		ArrayList<String> result=new ArrayList<String>();
		int length1=s1.length();
		int length2=s2.length();
		int[][] midResult=new int[length1+1][length2+1];
		for(int i=0;i<length1+1;i++)
			midResult[i][0]=0;
		for(int j=0;j<length2+1;j++)
			midResult[0][j]=0;
		
		for(int i=1;i<length1+1;i++){
			for(int j=1;j<length2+1;j++){
				if(s1.charAt(i-1)==s2.charAt(j-1))
					midResult[i][j]=midResult[i-1][j-1]+1;
				else
					midResult[i][j]=0;
			}
		}
		
		for(int i=0;i<length1+1;i++){
			for(int j=0;j<length2+1;j++){
				System.out.print(midResult[i][j]);
			}
			System.out.println();
		}
		
		for(int i=length1;i>0;i--){
			for(int j=length2;j>0;j--){
				int temp=midResult[i][j];
				if(temp!=0){
					StringBuilder builder=new StringBuilder("");
					int tempi=i;
					int tempj=j;
					for(int k=temp;k>=1;k--){
						builder.insert(0, s1.charAt(tempi-1));
						midResult[tempi][tempj]=0;
						midResult[tempi-1][tempj]=0;
						midResult[tempi][tempj-1]=0;
						tempi--;
						tempj--;
					}
					result.add(builder.toString());
				}
			}
		}
		
		for(String s:result){
			System.out.println(s);
		}
		
//		for(int i=0;i<length1+1;i++){
//			for(int j=0;j<length2+1;j++){
//				System.out.print(midResult[i][j]);
//			}
//			System.out.println();
//		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		computeCommonSubStr("asnnowy","bvsunneowy");
	}

}
