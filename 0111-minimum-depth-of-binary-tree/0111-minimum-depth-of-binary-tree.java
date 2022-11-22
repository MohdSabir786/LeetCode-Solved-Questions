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
    public int minDepth(TreeNode root) {
         if(root == null) return 0;
         int left_ht=0,right_ht=0;
        
         // it will give me higth of left subtree
         left_ht = minDepth(root.left);
        
         // ans its right subtree
         right_ht= minDepth(root.right);
        
         // minimum of both subtree heigth
         if(left_ht==0) return right_ht+1;
         if(right_ht==0) return left_ht+1;
         return Math.min(left_ht, right_ht)+1;
    }
}