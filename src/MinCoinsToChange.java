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
		//MinCoinsToChange[] s = new MinCoinsToChange[change+1];
		int[] minCoin = new int[change+1];
		minCoin[0] = 0;
		
		for(int i=1 ; i < change+1; i ++)
			minCoin[i] = -1;
		
		for(int i=1; i <= change; i++)
		{
			for(int coinIndex=0;coinIndex < coins.length;coinIndex++)
			{
				if(i >= coins[coinIndex])
					minCoin[i] = Math.min(minCoin[i]==-1? Integer.MAX_VALUE:minCoin[i] , minCoin[i-coins[coinIndex]] == -1? -1 : 1+minCoin[i-coins[coinIndex]]); 							
			}
		}
		
		return minCoin[change];				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {2,5,10};
		System.out.println(giveMinCoinsToChange(coins,30));
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