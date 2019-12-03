
/*
In a social group, there are N people, with unique integer ids from 0 to N-1.

We have a list of logs, where each logs[i] = [timestamp, id_A, id_B] contains a non-negative integer timestamp, and the ids of two different people.

Each log represents the time in which two different people became friends.  Friendship is symmetric: if A is friends with B, then B is friends with A.

Let's say that person A is acquainted with person B if A is friends with B, or A is a friend of someone acquainted with B.

Return the earliest time for which every person became acquainted with every other person. Return -1 if there is no such earliest time.

 

Example 1:

Input: logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
Output: 20190301

*/

import java.util.*;
import java.io.*;

public class leet1101{

	static HashMap<Integer,node> rooted_tree=new HashMap<Integer,node>();

	static class node{
	
		int val;
		int rank;
		node parent;
		
		node(int val){
		
			this.val=val;
			this.rank=0;
			this.parent=this;
		
		}
	
	}
	
	static node find(int u){
	
		node n=rooted_tree.get(u);
		while(n.parent!=n){
		
			n=n.parent;
		
		}
		
		return n;
	
	
	}
	
	static int union(int u,int v){
	
		node p1=find(u);
		node p2=find(v);
		int highest_rank=0;
		
		if(p1.rank >= p2.rank){
		
			p2.parent=p1;
			p1.rank++;
			highest_rank=p1.rank;
		
		}
		else{
			p1.parent=p2;
			p2.rank++;
			highest_rank=p2.rank;
		
		}
		
		return highest_rank;
	
	}
	
	

	public static void main(String[] args){
	
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int N=sc.nextInt();
		for(int i=0;i<N;i++){
		
			rooted_tree.put(i,new node(i));
			
		}
		int q=8;
		
		while(q-->0){
			long timestamp=sc.nextLong();
			int u=sc.nextInt();
			int v=sc.nextInt();
			
			int R=union(u,v);
			//System.out.println(R);
			if(R+1==N-1){
				System.out.println(timestamp);
				break;
			}
			
		}
		
	
	}


}
