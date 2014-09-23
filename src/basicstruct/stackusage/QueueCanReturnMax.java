package basicstruct.stackusage;

//A queue that is easy to locate max value
public class QueueCanReturnMax {

	private Stack input=new Stack(100);
	private Stack output=new Stack(100);
	
	public int max(){
		return Math.max(input.max(), output.max());
	}
	
	public void enqueue(int value){
		input.push(value);
	}
	
	public int dequeue(){
		if(output.size()>0) return output.pop();
		while(input.size()>0){
			output.push(input.pop());
		}
		return output.pop();
	}
	
	public class Stack{
		int[] stack;
		int[] maxRelation;
		int curMaxIndex;
		int top;
		int curMax;
		
		public Stack(int capacity){
			stack=new int[capacity];
			maxRelation=new int[capacity];
			top=-1;
			curMaxIndex=-1;
			curMax=Integer.MIN_VALUE;
		}
		
		public void push(int value){
			//TODO: capacity check
			top++;
			stack[top]=value;
			if(value>curMax){
				maxRelation[top]=curMaxIndex;
				curMaxIndex=top;
				curMax=value;
			}
		}
		
		public int pop(){
			//TODO: empty check
			int result=stack[top];
			
			if(curMaxIndex==top){
				curMaxIndex=maxRelation[top];
				if(curMaxIndex!=-1)
					curMax=stack[curMaxIndex];
			}
			
			top--;
			return result;
		}
		
		public int max(){
			//TODO: check empty
			return curMax;
		}
		
		public int size(){
			return top+1;
		}
		
	}
	
	public void testStack(){
		Stack s=new Stack(100);
		s.push(0);
		s.push(10);
		s.push(5);
		s.push(20);
		System.out.println(s.max());
		s.pop();
		System.out.println(s.max());
		s.pop();
		System.out.println(s.max());
		s.pop();
		System.out.println(s.max());
	}
	
	public static void main(String[] args){
		QueueCanReturnMax q=new QueueCanReturnMax();
		q.enqueue(1);
		q.enqueue(5);
		q.enqueue(3);
		q.enqueue(4);
		
//		q.testStack();
		
		System.out.println(q.max());
		System.out.println(q.dequeue());
		System.out.println(q.max());
		System.out.println(q.dequeue());
		System.out.println(q.max());
		System.out.println(q.dequeue());
		System.out.println(q.max());
	}
}
