//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minInsertions(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int minInsertions(int arr[], int n) 
	{ 
        //code here.
        int ans=0;
        int lis[] = new int[n];
		for(int i=0; i<n ;i++){
			lis[i]=1; 
			for(int j=i-1; j>=0; j--){
				if(arr[i]>=arr[j]) 
					lis[i] = Math.max(lis[i],lis[j]+1);
			}
			ans = Math.max(lis[i],ans);
		}
		return n-ans;
	} 
}
