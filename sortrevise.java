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

        arr=new int[] {10,83,12,45,67,345,12,45,6,34,23};

        quicksort(arr,0,arr.length-1);

        System.out.println("Quicksort Result: "+Arrays.toString(arr));
        



	}


	private static void quicksort(int[] arr, int low, int high) {

            if(low<high){
                int p=pivot(arr,low,high);
                quicksort(arr, low, p-1);
                quicksort(arr, p+1, high);
            }

    }

    private static int pivot(int[] arr, int low, int high) {
        int p=high;
        int i=-1;
        //int cnt;

        for(int j=0;j<high;j++){
            if(arr[j]<=arr[p]){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,p,i+1);
        return i+1;
    }

    private static void swap(int[] arr, int p, int i) {

        int temp=arr[p];
        arr[p]=arr[i];
        arr[i]=temp;
    }

    public static void mergesort(int[] a) {

		int low=0;
		int high=a.length-1;
		mergesortutil(a,low,high);
	}

	public static void mergesortutil(int[] a,int l,int h){
		
		if(l<h){
			int mid=(l+h)/2;
			//System.out.println(l+" "+mid+" "+h);
			mergesortutil(a,l,mid);
			mergesortutil(a,mid+1,h);
			merge(a,l,mid,h);

		}

	}

	public static void merge(int[] a,int l,int m,int h){
		//System.out.println(Arrays.toString(a)+"      "+l+" "+m+" "+h);
		int[] lr=new int[m-l+1];
		int[] rr=new int[h-m];

		for(int i=0;i<lr.length;i++){
			lr[i]=a[i+l];
        }
        //System.out.println(Arrays.toString(lr));
		for(int j=0;j<rr.length;j++){
			rr[j]=a[j+m+1];
        }
        //System.out.println(Arrays.toString(rr));
		int l1=0,k=0,low=l;
		while(l1<lr.length && k<rr.length){
			if(lr[l1]<=rr[k]){
				a[low]=lr[l1];
				l1++;
			}
			else{
				a[low]=rr[k];
				k++;
            }
            low++;
           //System.out.println("while "+ Arrays.toString(a)); 
		}
		while(l1<lr.length){
			a[low]=lr[l1];
			l1++;low++;
		}
		while(k<rr.length){
			a[low]=rr[k];
			k++;low++;
        }
        //System.out.println(Arrays.toString(a));
        //Scanner sc=new Scanner(System.in);
	    //String n1=sc.nextLine();
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