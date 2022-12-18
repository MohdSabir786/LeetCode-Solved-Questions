//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int ways_memo(int arr[][], int i,int j,int dp[][]){
        int r= arr.length; 
        int c= arr[0].length; 
        if(j==c-1){
             return dp[i][j]=arr[i][j];
        }
        if(dp[i][j]!=0) return dp[i][j];
        int up =0,down=0, frd=0;
        
        if(i-1>=0 )
            up =ways_memo(arr, i-1, j+1,dp);
            
            frd=ways_memo(arr, i, j+1,dp);
            
        if(i+1<r)
            down=ways_memo(arr, i+1, j+1,dp);
            
        
        return dp[i][j] = arr[i][j]+Math.max(Math.max(up,down),frd);
        
        
    }
    // recursion way
    static int ways(int arr[][], int i,int j){
        int r= arr.length; 
        int c= arr[0].length; 
        if(j==c-1){
             return arr[i][j];
        }
        
        int up =0,down=0, frd=0;
        
        if(i-1>=0 )
            up =ways(arr, i-1, j+1);
            
            frd=ways(arr, i, j+1);
            
        if(i+1<r)
            down=ways(arr, i+1, j+1);
            
        return arr[i][j]+Math.max(Math.max(up,down),frd);
    }
    static int maxGold(int n, int m, int M[][])
    {
        // code here
        // --> recursion way
        // int max=0;
        // for(int i=0; i<n; i++){
        //     int ans = ways(M,i,0);
        //     max = Math.max(ans, max);
        // }
        // return max;
        
        int dp[][]= new int[n+1][m+1];
        int max=0;
        for(int i=0; i<n; i++){
            int ans = ways_memo(M,i,0,dp);
            max = Math.max(ans, max);
        }
        return max;
        // return ways_memo(M,0,0,dp);
        
    }
}