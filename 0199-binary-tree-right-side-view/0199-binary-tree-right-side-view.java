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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int height=0;
        right(root, list, height);
        return list;
    }
    public void right(TreeNode root, List<Integer> list, int height){
        if(root == null) return;
        if(height == list.size())
            list.add(root.val);
      
            right(root.right, list, height+1);
            right(root.left, list, height+1);
        
    }
}