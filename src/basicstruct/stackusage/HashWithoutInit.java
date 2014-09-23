package basicstruct.stackusage;

//Problem 11.4 from "Introduction to algorithms"
public class HashWithoutInit {

	//Note that hash is very large and may not be initialized properly
	public int search(int[] hash,int[] stack,int value){
		int p=hash[value];
		if(p>0 && p<=stack.length && stack[p]==value) return p;
		return 0;
	}
	
	public int insert(int[] hash,int[] stack,int value){
		int exist=search(hash,stack,value);
		if(exist!=0){
			System.out.println("Already exist");
			return 0;
		}
		stack[0]++;
		stack[stack[0]]=value;
		hash[value]=stack[0];
		return stack[0];
	}
	
	public int delete(int[] hash,int[] stack,int value){
		int exist=search(hash,stack,value);
		if(exist==0){
			System.out.println("Not exist");
			return 0;
		}
		stack[exist]=stack[stack[0]]; //Fill original blank with last element
		hash[stack[exist]]=exist;
		stack[0]--;
		return exist;
	}
}
