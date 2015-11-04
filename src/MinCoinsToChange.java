import java.util.ArrayList;
import java.util.List;


public class MinCoinsToChange {
	/*
	 * {1,5,10} change = 10cents
	 * answer = 1 coin to make change 10cents  {10}
	 * 
	 * complexity analysis
	 *  brute force = 2^n
	 *  d.p=mV i.e V=change m-noOfCoins
	 *  
	 */
	public static int giveMinCoinsToChange(int[] coins, int change)
	{
		MinCoinsToChange[] s = new MinCoinsToChange[change+1];
		return 0;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class helperClass 
{
	List<Integer> listOfCoins;	
	
	public void helperClass(){};
	
	public void helperClass(int a){
		if(listOfCoins == null)
			listOfCoins = new ArrayList<Integer>();
		
		listOfCoins.add(a);
	}
	
	private List<Integer> getList(){
		return listOfCoins
				;
	}
}