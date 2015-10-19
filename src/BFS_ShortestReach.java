import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Problem Statement Hackerrank

Given a graph consisting N nodes (labelled 1 to N) where a specific given node S represents the start position and an edge between any two nodes is of length 6 units in the graph.

It is required to calculate the shortest distance from start position (Node S) to all of the other nodes in the graph.

Note 1: If a node is unreachable , the distance is assumed as −1.
Note 2: The length of each edge in the graph is 6 units.

Input Format

The first line contains T, denoting the number of test cases.
First line of each test case has two integers N, denoting the number of nodes in the graph and M, denoting the number of edges in the graph.
The next M lines each consist of two space separated integers x y, where x and y denote the two node between which the edge exists.
The last line has an integer S, denoting the starting position.

Constraints
1≤T≤10
2≤N≤1000
1≤M≤N×(N−1)2
1≤x,y,S≤N

If there are edges between the same pair of nodes with different weights, the last one (most recent) is to be considered as the only edge between them.

Output Format

For each of T test cases, print a single line consisting of N−1 space separated integers, denoting the shortest distances of the N-1 nodes from starting position S.

For unreachble nodes, print −1.

Sample Input

1
4 2
1 2
1 3
1

Sample Output

6 6 -1

Explanation

The graph given in the test case is shown as :

Graph

S denotes the node 1 in the test case and B,C and D denote 2,3 and 4. Since S is the starting node and the shortest distances from it are (1 edge, 1 egde, Infinity) to the nodes B,C and D (2,3 and 4) respectively.

Node D is unreachable, hence -1 is printed (not Infinity)
 */
public class BFS_ShortestReach {

    public static void main(String[] args) {                
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        BFS_ShortestReach ans = new BFS_ShortestReach();
        ans.SolutionA();
    }
    
        public void setEdge(int[][] adjacency_matrix, int from_vertex, int to_vertex, int edge) 

    {
            adjacency_matrix[from_vertex][to_vertex] = edge;
    }
    
    private void SolutionA()
    {        
        Scanner in = new Scanner(System.in);
        int T = 0;
        int N = 0;
        int M = 0;
        int S = 0;
        T = in.nextInt();
        N = in.nextInt();
        M = in.nextInt();
        int[][] adjacency_matrix = new int[N+1][N+1];
        
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
            {
                adjacency_matrix[i][j]=-1;
        }
                        
        for(int i = 0;i < M;i++)
        {
            int one = in.nextInt();
            int two = in.nextInt();
            
            adjacency_matrix[one][two] = 6;
            adjacency_matrix[two][one] = 6;
        }
        
        S = in.nextInt();     
        
        int[] result = bfs(N, adjacency_matrix, S);
           
        for(int i = 0; i < result.length;i++)
        {
            if(i==S || i == 0) continue;
            
            System.out.print(result[i] == 0 ? -1 : result[i] +" ");
        
        }
  }
    private int[] bfs(int vectorSize,int[][] adjacency_matrix, int source){
        Queue<Integer> queue = new LinkedList<Integer>();
        
        int[] distance_vector_from_source = adjacency_matrix[source];//new int[vectorSize];
        int[] visited = new int[vectorSize+1];
               
        queue.add(source);
       // visited[source] = 1;
        
        while(!queue.isEmpty())
        {
            int element = queue.remove();
            
            if(visited[element] == 0)
            {
                for(int i=0;i< vectorSize+1;i++)
                {
                    if(adjacency_matrix[element][i] > 0 && visited[i] == 0) {
                        queue.add(i);
                        
                        if(element==source) continue;
                        
                         if(adjacency_matrix[source][i]== 0 && adjacency_matrix[source][element] > 0)                          { distance_vector_from_source[i] = adjacency_matrix[source][element] +      adjacency_matrix[element][i];
                                                                                                                                adjacency_matrix[source][i] = distance_vector_from_source[i];
                                                                                                                         }
                    }
                }                
            }
            
             visited[element] = 1;
        }
        
        return distance_vector_from_source;
    }
}