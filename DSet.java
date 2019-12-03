/*

Disjoint Set data structure implementation has two ways

1.LinkedList Implementation
2.Tree Implementation


Optimization techniques are wighted union, 

Algo:





*/

import java.util.*;
public class DSet{
	
	
	static HashMap<Integer,node> rooted_tree=new HashMap<Integer,node>();
	static class node{
		
		int val;
		node parent;
		int rank;
		boolean visited;
		
		node(int val){
			
			this.val=val;
			this.parent=this;
			this.rank=0;
		}
		
		
	}
	
	public static node find(node u1){
		
		while(u1.parent!=u1){
			u1=u1.parent;
		}
		
		return u1;
		
	}
	
	public static void  union(int u,int v){
		
		node u1=rooted_tree.get(u);
		node v1=rooted_tree.get(v);
		
		node p1=find(u1);
		node p2=find(v1);
		
		if(p1.rank>=p2.rank) {p2.parent=p1;p1.rank++;}
		else {p1.parent=p2;p2.rank++;}
		
		
	}
	
	
	public static void main(String[] args){
		
		HashMap<Integer,ArrayList<Integer>> hm=new HashMap<Integer,ArrayList<Integer>> ();
		int[] v={1,2,3,4,5};
		int[][] e={ {1,2} , {2,4} ,{1,5} };
		
		for(int i=0;i<v.length;i++){
			
			rooted_tree.put(v[i],new node(v[i]));
			
		}
		
		for(int i=0;i<e.length;i++){
			
			union(e[i][0],e[i][1]);
			
		}
		
		for(int i=0;i<v.length;i++){
			/*for(int j=i+1;j<v.length;j++){
				
				if(find(rooted_tree.get(v[i]))==find(rooted_tree.get(v[j]))) System.out.println(v[i]+ " and "+ v[j]+" are connected");
				else System.out.println(v[i]+ " and "+ v[j]+" are not connected");
				
				
				
			}
			*/
			node p=find(rooted_tree.get(v[i]));
			if(hm.containsKey(p.val)) hm.get(p.val).add(v[i]);
			else {
				ArrayList<Integer> al=new ArrayList<Integer>();
				al.add(v[i]);
				hm.put(p.val,al);
				
			}
			
			
		}
		
		System.out.println(hm.entrySet());
		
		
		
		
		
	}
	
	
	
	
	
}
