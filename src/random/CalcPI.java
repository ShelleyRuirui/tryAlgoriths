package random;

import java.text.DecimalFormat;
import java.text.NumberFormat;

//This program will try to calc the value of PI
public class CalcPI {

	public static void main(String[] args) {
//		Random r=new Random(1);
//		double counter=0;
//		double insideCounter=0;
//		for(int i=0;i<100000000;i++)
//		{
//			double x=r.nextDouble();
//			double y=r.nextDouble();
//			if(x*x+y*y <= 1)
//				insideCounter ++;
//			counter++;
//		}
//		double pi=(insideCounter/counter)*4;
//		System.out.println("PI="+pi);
		double d1=(double)2/(double)2340;
		NumberFormat formatter = new DecimalFormat("##.####");
		String re=formatter.format(d1);
		System.out.println(re);
	}
}
