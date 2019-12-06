import java.util.*;
import java.io.*;

public class cfa6dec{

	public static void main(String[] args){
	
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T=Integer.parseInt(sc.nextLine());
		
			
		while(T-->0){
		boolean flag=true;
		String s=sc.nextLine();
		
		char[] c=s.toCharArray();
		int len=c.length;
		for(int i=0;i<c.length;i++){
			List<Character> al=new ArrayList<Character>();
			al.add('a');
			al.add('b');
			al.add('c');
			if(i-1>=0 && c[i]==c[i-1]) { System.out.println (-1);flag=false;break;}
			if(c[i]=='?'){
				if(c.length==1) c[i]='a';
				if(i-1 <0 && i+1 <c.length) {
					
					c[i]= (c[i+1]=='a' ? 'b' : (c[i+1]=='b' ? 'c' :'a')) ;
				}
				if(i-1>=0  && i+1 ==c.length) {
					
					c[i]= c[i-1]=='a' ? 'b' : (c[i-1]=='b' ? 'c' :'a') ;
				}
				
				if((i-1)>= 0 && i+1<c.length){
					
					al.remove(Character.valueOf(c[i-1]));
					al.remove(Character.valueOf(c[i+1]));
					c[i]=al.get(0);
					
					
				}
				
				
				
			}
			
			
		}
		if(flag) System.out.println(String.valueOf(c));
	}
	}

}
