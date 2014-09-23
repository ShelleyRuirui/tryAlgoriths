package others;

public class ExpressionCalc {

	String expression;
	int p;
	
	public ExpressionCalc(String e,int pointer){
		expression=e;
		p=pointer;
	}
	
	public double expr(){
		double num1,num2;
		num1=term();
		char op;
		while(p<expression.length() && (expression.charAt(p)=='+' || expression.charAt(p)=='-')){
			op=expression.charAt(p);
			p++;
			num2=term();
			num1= op=='+'?num1+num2:num1-num2;
		}
		return num1;
	}
	
	public double term(){
		double num1,num2;
		num1=value();
		char op;
		while(p<expression.length() && (expression.charAt(p)=='*' || expression.charAt(p)=='/')){
			op=expression.charAt(p);
			p++;
			num2=value();
			num1= op=='*'?num1*num2:num1/num2;
		}
		return num1;
	}
	
	public double value(){
		double value=0;
		if(expression.charAt(p)=='('){
			p++;
			value=expr();
			if(expression.charAt(p) != ')'){
				System.err.println("Error!");
				System.exit(-1);
			}
			p++;
		}else{
			StringBuilder sb=new StringBuilder();
			char c=expression.charAt(p);
			while(isDigit(c)){
				sb.append(c);
				p++;
				if(p>=expression.length()-1)
					break;
				c=expression.charAt(p);
			}
			value=Integer.parseInt(sb.toString());
		}
		return value;
	}
	
	private boolean isDigit(char c){
		return c>='0' && c<= '9';
	}
	
	public static void main(String[] args){
		ExpressionCalc e=new ExpressionCalc("10/(3+2)*3",0);
		System.out.println(e.expr());
	}
}
