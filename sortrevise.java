import java.util.*;
public class sortrevise{
	

	public static void main(String[] args){

		int[] arr={10,83,12,45,67,345,12,45,6,34,23};

		bubblesort(arr);

		System.out.println("BubbleSort Result:  "+Arrays.toString(arr));

		arr=new int[] {10,83,12,45,67,345,12,45,6,34,23};

		selectionsort(arr);

		System.out.println("selectionsort Result:  "+Arrays.toString(arr));

		arr=new int[] {10,83,12,45,67,345,12,45,6,34,23};

		mergesort(arr);

		System.out.println("mergesort Result:  "+Arrays.toString(arr));


	}


	public static void mergesort(int[] a){

		int low=0;
		int high=a.length-1;
		mergesortutil(a,low,high);
	}

	public static void mergesortutil(int[] a,int l,int h){
		int low=l;
		int high=h;
		if(l<h){
			int mid=(low+high)/2;
			System.out.println(l+" "+mid+" "+h);
			mergesortutil(a,low,mid);
			mergesortutil(a,mid+1,high);
			merge(a,low,mid,high);

		}

	}

	public static void merge(int[] a,int l,int m,int h){
		System.out.println(Arrays.toString(a)+"      "+l+" "+m+" "+h);
		int[] lr=new int[m-l+1];
		int[] rr=new int[h-m];

		for(int i=0;i<lr.length;i++){
			lr[i]=a[i+l];
		}
		for(int i=0;i<rr.length;i++){
			rr[i]=a[i+m+1];
		}
		int l1=0,k=0,low=0;
		while(l1<lr.length && k<rr.length){
			if(lr[l1]<=rr[k]){
				a[low]=lr[l1];
				l1++;low++;
			}
			else{
				a[low]=rr[k];
				k++;low++;
			}

		}
		while(l1<lr.length){
			a[low]=lr[l1];
			l1++;low++;
		}
		while(k<rr.length){
			a[low]=rr[k];
			k++;low++;
		}
	}

	public static void selectionsort(int[] a){


		for(int i=0;i<a.length;i++){
			int min=i;
			for(int j=i;j<a.length;j++){
				if(a[j]<a[min]) min=j;
			}
			int temp=a[i];
			a[i]=a[min];
			a[min]=temp;
			//System.out.println(Arrays.toString(a));
		}
	}


	public static void  bubblesort(int[] a){

		for(int i=0;i<a.length;i++){
			for(int j=i;j<a.length;j++){

				if(a[i]>a[j]){

					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;

				}
				

			}
			//System.out.println(Arrays.toString(a));
		}
	}
}