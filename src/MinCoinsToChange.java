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
		
		for(int i=1 ; i < change+1; i++)
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

	
	public static int giveMinCoinsToChange_Values(int[] coins, int change)
	{
		//MinCoinsToChange[] s = new MinCoinsToChange[change+1];
		helperClass[] helper = new helperClass[change+1];
		int io = change+1;
		while(io-- > 0)
			helper[io] = new helperClass();
		
		int[] minCoin = new int[change+1];
		minCoin[0] = 0;
		
		for(int i=1 ; i < change+1; i++)
			minCoin[i] = -1;
		
		for(int i=1; i <= change; i++)
		{
			for(int coinIndex=0;coinIndex < coins.length;coinIndex++)
			{
				if(i >= coins[coinIndex]){
					
					int val = Math.min(minCoin[i]==-1? Integer.MAX_VALUE:minCoin[i] , minCoin[i-coins[coinIndex]] == -1? -1 : 1+minCoin[i-coins[coinIndex]]);
					if(minCoin[i] != val ){
						minCoin[i] = val;
						
						helper[i].CountOfCoins = null;
						helper[i].listOfCoins = null;
						
						helper[i].putCoins(coins[coinIndex]);
						helper[i].putCount(1);
						
						if(helper[i-coins[coinIndex]].getListOfCoins() != null)
							helper[i].putCoins(helper[i-coins[coinIndex]].getListOfCoins());
						
						if(helper[i-coins[coinIndex]].getCountOfCoins() != null)
							helper[i].putCount(helper[i-coins[coinIndex]].getCountOfCoins());
					}
				}
			}
		}
		
		System.out.println("The coins are" + helper[change].listOfCoins.toString());
		System.out.println("The counts are" + helper[change].CountOfCoins.toString());
		
		return minCoin[change];				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {2,5,10};
		System.out.println(giveMinCoinsToChange_Values(coins,29));		
	}

}

class helperClass 
{
	public List<Integer> listOfCoins;
	public List<Integer> CountOfCoins;	
	
	public void helperClass(){};
	
	public void helperClass(int a){
		if(listOfCoins == null)
			listOfCoins = new ArrayList<Integer>();
		
		listOfCoins.add(a);
	}
	
	public ArrayList<Integer> getListOfCoins(){
		return (ArrayList)listOfCoins;
	}
	
	public ArrayList<Integer> getCountOfCoins(){
		return (ArrayList)CountOfCoins;
	}
	
	public void putCoins(int a){
		if(listOfCoins == null)
			listOfCoins = new ArrayList<Integer>();
		
		listOfCoins.add(a);
	}
	
	public void putCoins(ArrayList<Integer> li){
		if(listOfCoins == null)
			listOfCoins = new ArrayList<Integer>();
		
		listOfCoins.addAll(li);
	}
	
	public void putCount(int a){
		if(CountOfCoins == null)
			CountOfCoins = new ArrayList<Integer>();
		
		CountOfCoins.add(a);
	}
	
	public void putCount(ArrayList<Integer> li){
		if(CountOfCoins == null)
			CountOfCoins = new ArrayList<Integer>();
		
		CountOfCoins.addAll(li);
	}
}