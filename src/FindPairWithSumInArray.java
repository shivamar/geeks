
public class FindPairWithSumInArray {
	
	/*
	 * 3,2,1,4,5 : sum : 7 
	 * result : 4,3
	 * 
	 * complexity: O(n)
	 */

	public static int[] findPair(int[] arr, int sum)
	{
		boolean[] helper = new boolean[sum];
		
		for(int i=0; i < arr.length; i++)
		{
			int elem = arr[i];
			int rem_pair = sum - arr[i];
			
			if(rem_pair > 0) helper[elem] = true;
			
			if(rem_pair > 0 && helper[rem_pair] == true)
			{
				int[] ans = {elem, rem_pair}; 
				return ans;
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,5,22,56};
		int[] ans = findPair(arr,25);
		
		if(ans != null) System.out.print(ans[0] +" "+ans[1]);

	}

}
