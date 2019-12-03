import java.util.*;
import java.io.*;
public class leet959{

  static HashMap<Integer,node> hm=new HashMap<Integer,node>();
  static class node{
  
    int val;
    int parent;
    int rank
    
    node(int val){
    
      this.val=val;
      this.parent=this;
      this.rank=0;
    }
  
  }

	public static void main(String[] args){
	
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int N=3;
		String[] grid={"/\ ","\/ ","   "};
		solve(grid);
	
	}
	
	public static solve(String[] grid){
  
  int N=grid.length;
  
  for(int i=0;i<(N*N*4);i++){
  
    hm.put(i,new node(i));
  
  }
  //to be continued
  
  
  }


}
