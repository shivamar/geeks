import java.util.Random;


public class quickSort_RandomisedPivot {

	
	public static void quickSort(int[] arr, int l, int r)
	{
		int ret = partition(arr,l ,r);
		
		if(ret > l) quickSort(arr,l,ret-1);			
		if(ret < r) quickSort(arr,ret+1, r);									
	}
	
	//select a random pivot and swap it with last or first element
	//in this case it is last! but u can do it either way!
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

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,5,6,7,23,100,32};
		quickSort(arr,0,arr.length-1);
		
		for(int a : arr)
		System.out.println(a);
	}

}
