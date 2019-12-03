import java.util.*;

public class leet1061{
	
	static HashMap<Character,node> hm=new HashMap<Character,node>();
	static class node{

		char c;
		node parent;
		int rank;

		node(char c){

			this.c=c;
			this.parent=this;
			this.rank=(int)c;
		}
	}
	public static void main(String[] args){

		String A="abc";
		String B="xyz";
		String C="yzp";
		String res=A+B+C;
		for(int i=0;i<res.length();i++){
			char c=res.toCharArray()[i];
			hm.put(c,new node(c));
		}

		Solve(A,B,C);

	}

	public static void Solve(String a,String b,String c){

		char[] A=a.toCharArray();
		char[] B=b.toCharArray();

		for(int i=0;i<A.length;i++){

			union(A[i],B[i]);
		}

		for(int j=0;j< c.length();j++){

			System.out.print(find(c.toCharArray()[j]).c);
		}
	}

	public static void union(char a,char b){

		node p1=find(a);
		node p2=find(b);

		if(p1.rank<=p2.rank) p2.parent=p1;
		else p1.parent=p2;

	}

	public static node find(char a){

		node current=hm.get(a);
		while(current.parent!=current){
			current=current.parent;

		}
		return current;
	}


}