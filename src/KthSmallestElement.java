import java.util.Random;
import java.util.TreeSet;


public class KthSmallestElement {
	
	//quicksort stops when the pivot element is kth position
	//this is better than nlogn!!
	public static int quickSort_Select(int[] arr, int l, int r, int k)
	{
		int ret = partition(arr,l ,r);
		
		if(ret == k) return arr[k];
		else
		{
			if(ret > k) return quickSort_Select(arr,l,ret-1,k);			
			else return quickSort_Select(arr, ret+1, r, k);							
		}		
	}
	
	public static int partition(int[] arr, int l , int r)
	{			
		Random ra = new Random();
		int pivotIndex = l+ ra.nextInt(r-l+1);
		int pivot = arr[pivotIndex];
		
		swap(pivotIndex,r,arr);
		
		pivotIndex = r;
		
		int i = l;
		while(l <= r-1)
		{
			if(arr[l] < pivot)
			{				
				swap(l,i, arr);
				i++;
			}
			
			l++;
		}		
		
		swap(i, pivotIndex, arr);
		
		return i;
	}

	private static void swap(int i, int j, int[] arr)
	{
	
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;		
	}

	public static int kthSmallest(int[] arr)
	{			
		TreeSet<Integer> tr = new TreeSet<Integer>();
		
		for(int i=0; i < arr.length; i++)
		{			
			checkWithSet(arr[i], tr);		
		}
		
		return tr.last();		
	}
	
	public static void checkWithSet(int a, TreeSet<Integer> tr)
	{
		if(tr.size() < 3)
		{
			tr.add(a);
		}		
		else
		{
			if(a < tr.last()) {

				tr.remove(tr.last());
				tr.add(a);
			}
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int[] arr = {5,6,7,3,2,4,10};
		
		System.out.println(kthSmallest(arr));
		int k = 3;
		System.out.println(quickSort_Select(arr,0,arr.length - 1, k-1));
	}	
}
