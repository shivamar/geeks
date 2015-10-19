
public class quickSort {

	public quickSort() {
		
	}
	
	static int Order = 0;
	public int[] do_(int[] arr,int low ,int high)
	{
		int mid = partition_Arr(arr, low, high);		
		
		if(mid-1 > 0)do_(arr,0,mid-1);
		if(high > mid+1)do_(arr,mid+1,high);
		
		return arr;
	}
	
	public int partition_Arr(int[] arr,int low,int  high)
	{
		Order++;
		int len = high;
		int pivot_pos = len/2; //best run time; int pivot_pos = low; worstcase run time
		
		
		int pivot_elem = arr[pivot_pos];
		
		while(high > low)
		{
			while(low < arr.length && arr[low] < pivot_elem)
				low++;
			
			while(high >= 0 && arr[high] >= pivot_elem)
				high--;
			
			if(high > low)swap(arr,high,low);
		}
				
		return low;
	}
		
	private void swap(int[] arr, int high, int low) {
		int l = arr[low];
		arr[low] = arr[high];
		arr[high] = l;
	}

	public static void main(String[] args) {
		int[] arr = {4,3,2,1,5,6,7,8,9,10,11,12,13,14,15,16,17};
		
		quickSort quic = new quickSort();
		quic.do_(arr, 0, arr.length - 1);

		for(int ar:arr)
		System.out.println(ar);
		
		System.out.print("Order is "+ Order);
		Order = 0;
	}

}
