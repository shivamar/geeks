
public class FindMissingNumber {
	
	//O(n) solution using helper array
	// find missing number in array from n1......n2 e.g.1,2,3,5,6,7 ans  = 4 
	public static int findMissing(int[] arr)
	{
		boolean[] arr_bool = new boolean[arr.length+1];
		
		int low = arr[0];
		int high = arr[arr.length-1];
		
		for(int i=0;i < arr.length;i++)
		{
			arr_bool[arr[i]-low] = true;
		}
		
		for(int i = 0; i < arr_bool.length; i++)
		{
			if(arr_bool[i] == false) return i+low;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {1,2,3,4,5,7,8,9};
		System.out.println(findMissing(a));
	}

}
