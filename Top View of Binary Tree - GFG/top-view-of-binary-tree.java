//{ Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Info{
    Node root;
    int ht;
    Info(Node r, int h){
        root = r;
        ht = h;
    }
}

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        TreeMap<Integer,Node> hm = new TreeMap<>();
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root,0));
        // int min = Integer.MAX_VALUE;
        // int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                Info rd = q.remove();
                Node rn = rd.root;
                int ht = rd.ht;
                // min = Math.min(min,ht);
                // max = Math.max(max,ht);
                if(rn.left!=null) q.add(new Info(rn.left,ht-1));
                if(rn.right!=null) q.add(new Info(rn.right,ht+1));
                if(!hm.containsKey(ht))
                    hm.put(ht,rn);
            }
        }
        // for(int i=min; i<=max; i++){
        //     Node rn = hm.get(i);
        //     res.add(rn.data);
        //     // res.add(hm.get(i).data);
        // }
        for(int ht : hm.keySet()){
            res.add(hm.get(ht).data);
        }
        return res;
        
    }
}
