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
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        List<List<Integer>> ans =new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null) return ans;
        
        q.offer(root);
      
        
        while(q.size()>0){
           int count = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<count; i++){
                TreeNode rn = q.poll();
                level.add(rn.val);
                
                if(rn.left != null) q.add(rn.left);
                if(rn.right != null) q.add(rn.right);
            }
            ans.add(level);
        }
        return ans;
    }
}