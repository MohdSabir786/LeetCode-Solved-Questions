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
//     public int height(TreeNode root){
//         if(root== null) return 0;
        
//         int left = height(root.left);
//         int right = height(root.right);
//         return Math.max(left, right)+1;
//     }
    /*
    
    class Solution {

	static class data {
		int ht;
		int dia;
		data (int dia, int ht){
			this.dia = dia;
			this.ht = ht;
		}
	}
	
	public static data diameterNode(Node root){
		if(root == null) return new data(0,0);

		data left_Dia = diameterNode(root.left);
		data right_Dia = diameterNode(root.right);

		int height = left_Dia.ht+ right_Dia.ht+1;
		int dia = Math.max(height, Math.max(left_Dia.dia, right_Dia.dia));
		int ht = Math.max ( left_Dia.ht, right_Dia.ht)+1;
		return new data(dia, ht);
	}
   
    public static int diameter(Node root) {
        
		data res = diameterNode(root);
		return res.dia;
    }
	 
}
    */
    
    
    static class info{
        int ht;
        int dia;
        
        info(int ht, int dia){
            this.ht = ht;
            this.dia = dia;
        }
    }
    
    public info diameter(TreeNode root){
        if(root == null) return new info(0,0);
        
        info leftDia = diameter(root.left);
        info rightDia = diameter(root.right);
        
        int dia = Math.max(Math.max(leftDia.dia, rightDia.dia), leftDia.ht + rightDia.ht );
        int ht = Math.max(leftDia.ht, rightDia.ht)+1;
        return new info(ht, dia);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        info data = diameter(root);
        return data.dia;
        
        // Approch-1
//         if(root == null) return 0;
        
//         int leftDia = diameterOfBinaryTree(root.left);
//         int ht_left = height(root.left);
//         int rightDia = diameterOfBinaryTree(root.right);
//         int ht_right = height(root.right);
        
//         int selfDia = ht_left+ ht_right;
//         return Math.max(selfDia, Math.max(leftDia, rightDia));
    }
}