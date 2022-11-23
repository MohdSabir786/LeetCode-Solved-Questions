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
    public boolean isMirror(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        
        if(r1.val != r2.val) return false;
        return isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);
    }
    public boolean isSymmetric(TreeNode root) {
//      This Solution have space O(n)   
        
        // Queue <TreeNode> q = new LinkedList<>();
        // q.offer(root.left);
        // q.offer(root.right);
        // while(!q.isEmpty()){
        //     TreeNode n1 = q.poll();
        //     TreeNode n2 = q.poll();
        //     if(n1 == null && n2== null) continue;
        //     if(n1 ==null ||  n2 == null || n1.val != n2.val) return false;
        //     q.offer(n1.left);
        //     q.offer(n2.right);
        //     q.offer(n1.right);
        //     q.offer(n2.left);
        // }
        // return true;
        return root == null || isMirror(root.left, root.right); 
    }
}