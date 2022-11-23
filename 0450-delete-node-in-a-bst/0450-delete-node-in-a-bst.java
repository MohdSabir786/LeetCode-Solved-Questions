/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int max(TreeNode root){
        TreeNode temp = root;
        while(temp.right!= null) temp = temp.right;
        return temp.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val == key){
            // 0-child
            if(root.left == null && root.right == null) return null;
            
            // 1-child in LC
            if(root.left != null && root.right == null) return root.left;
            
            // 1-child in RC
            if(root.left == null && root.right != null) return root.right;
            
            // 2-child (both)
            int leftSubTreeMax =  max(root.left);
            root.val = leftSubTreeMax;
            root.left = deleteNode(root.left, leftSubTreeMax);
            return root;
        }
        else if( key > root.val) root.right = deleteNode(root.right, key);
        else root.left = deleteNode( root.left, key);
        return root;
    }
}