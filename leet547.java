import java.util.*;

public class leet547{
	
	static HashMap<Integer,node> hm=new HashMap<Integer,node>();
	public static void main(String[] args){

		int[][] M= {
						{1,1,0},
						{1,1,0},
						{0,0,1}


		           };

		 int cnt=solve(M);
		 System.out.println(cnt);
	}

	public static int solve(int[][] M){

		int N=M.length;

		for(int i=0;i<N;i++){
			hm.put(i,new node(i));
		}

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(M[i][j]==1) {if(i!=j)union(i,j);}
			}
		}
		int count=0;

		for(int j=0;j<N;j++){

			if(find(j)==hm.get(j)) count++;
		}

		return count;


	}

	public static void union(int u,int v){

		node p1=find(u);
		node p2=find(v);
		if(p1==p2) return;

		if(p1.rank>=p2.rank){
			p2.parent=p1;
			p1.rank++;
		}
		else{
			p1.parent=p2;
			p2.rank++;
		}

	}

	public static node find(int a){

		node current=hm.get(a);
		while(current!=current.parent){
			current=current.parent;

		}
		return current;
	}

	static class node{
		int val;
		node parent;
		int rank;

		node(int val){
			this.val=val;
			this.parent=this;
			this.rank=0;
		}
	}
}