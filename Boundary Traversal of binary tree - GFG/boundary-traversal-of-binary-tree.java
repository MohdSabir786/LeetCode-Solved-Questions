//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    boolean isLeaf(Node root){
        // if(root==null) return false;
        if(root.left == null && root.right==null) return true;
        return false;
    }
    
	void rightBoundary(Node root,ArrayList <Integer>ans){
	    Stack<Integer> s = new Stack<>();
	    Node rn = root.right;
	    while(rn!=null){
    	    if(!isLeaf(rn)){
    	        s.push(rn.data);
    	    }
    	    if(rn.right!=null) rn = rn.right;
    	    else rn = rn.left;
	    }
	    while(!s.isEmpty()){
	        ans.add(s.pop());
	    }
	}
	
	void leftBoundary(Node root,ArrayList <Integer>ans){
	    Node rn = root.left;
	    while(rn!= null){
    	    if(!isLeaf(rn)){
    	        ans.add(rn.data);
    	    }
    	    if(rn.left!=null) rn = rn.left;
    	    else rn = rn.right;
	    }
	}
	void leafBoundary(Node root, ArrayList<Integer>ans){
	    if(root==null) return;
	    if(isLeaf(root)) ans.add(root.data);
	    leafBoundary(root.left,ans);
	    leafBoundary(root.right,ans);
	}
	ArrayList <Integer> boundary(Node root)
	{
	    ArrayList <Integer> ans = new ArrayList <Integer>();
	    if(isLeaf(root)) {
	        ans.add(root.data);
	        return ans;
	    }
	    ans.add(root.data);
	    leftBoundary(root,ans);
	    leafBoundary(root,ans);
	    rightBoundary(root,ans);
	    return ans;
	}
}
