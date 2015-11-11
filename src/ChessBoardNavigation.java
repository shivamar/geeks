
import java.util.ArrayList;
import java.util.Arrays;


public class ChessBoardNavigation {
		
	/*
	 * Given a source 0,0 and N,N of a chess board size N
	 * Find the min distance for the knight from source to destination
	 */
	public static int findMinDistance(Integer[] source,Integer[] destination,int[][] board,int[][] visitedVector,ArrayList<Integer[]> blocked){
		if(Arrays.equals(source,destination)) {
			visitedVector[source[0]][source[1]] = 1;
			board[source[0]][source[1]] = 0;	
			
			return 0;
		}

		//mark current spot as visited
		visitedVector[source[0]][source[1]] = 1;		
		
		//get all possible adjacent cells for the node in the graph/next moves on chess board
		ArrayList<Integer[]> moves = getNextMoves(source,board, blocked);		
		
		//its a dead end if there can be no further moves, mark the current spot as -1 
		if(moves.size() > 0)
		{
			//iterate all possible valid next-moves and update the source on board
			//with min distance as min distance from all of nxt move to the destination + 1			
			int distFromPrevStep=0;
			for(int i=0;i<moves.size();i++)
			{
				Integer[] step = moves.get(i);	
				
				//don't step into already visited spots
				if(visitedVector[step[0]][step[1]] == 1)continue;				
				
				distFromPrevStep = findMinDistance(step, destination, board, visitedVector, blocked);				
					
				//update the min distance value only if its not a dead end or a spot leading to dead end 
				if(distFromPrevStep != Integer.MAX_VALUE) board[source[0]][source[1]] = Math.min(board[source[0]][source[1]],1+distFromPrevStep);									
			}												
		}		
				
		return board[source[0]][source[1]];		
	}

	private static ArrayList<Integer[]> getNextMoves(Integer[] source, int[][] board,ArrayList<Integer[]> blocked) {
		// TODO Auto-generated method stub
		int[] xMove = {2,-2,1,-1,2,-2,1,-1};
		int[] yMove={1,-1,2,-2,-1,1,-2,2};
		
		ArrayList<Integer[]> nextMoves = new  ArrayList<Integer[]>();
		//calculate next move
		for(int i=0;i<xMove.length;i++){
			int nextX = source[0] + xMove[i];
			int nextY = source[1]+ yMove[i];
		
			//check if the next move is within board and not a blocked point on board 
			if(isSafe(nextX,nextY,board.length-1,blocked)){
				Integer[] arr = {nextX,nextY};
				nextMoves.add(arr);
			}					
		}
				
		return nextMoves;
	}

	private static boolean isSafe(int nextX, int nextY, int length,
			ArrayList<Integer[]> blocked) {
		// TODO Auto-generated method stub
		

		if(nextX >= 0 && nextX <= length && 
		   nextY >= 0 && nextY <= length )
		{
		for(Integer[] blockedPoint : blocked)
		{
			if(blockedPoint[0] == nextX && blockedPoint[1] == nextY)
				return false;
		}
			return true;
		}
		else		
		return false;
	}

 /* A utility function to print solution matrix
    sol[N][N] */
	static void printSolution(int sol[][])
 {
     for (int i = 0; i < sol.length; i++)
     {
         for (int j = 0; j < sol.length; j++)
             System.out.print(" " + sol[i][j] +
                              " ");
         System.out.println();
     }
 }
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len = 8;
		int[][] board = new int[len][len];
		int[][] vis = new int[len][len];
		
		//Initialize board with int.max in all spaces
		for(int i=0;i<board.length;i++)
			for(int j=0;j<board.length;j++)
				board[i][j]= Integer.MAX_VALUE;
		
		// visited matrix with all 0s	
		Integer[] s = {0,0};
		Integer[] b = {len-1,len-1};
		
		ArrayList<Integer[]>blocked = new ArrayList<Integer[]>();
		Integer[] e = {0,2};		
		blocked.add(e);
		
		int ans = findMinDistance(s,b,board,vis,blocked);
		
		printSolution(board);
		
		System.out.println(ans);		
	}

}
