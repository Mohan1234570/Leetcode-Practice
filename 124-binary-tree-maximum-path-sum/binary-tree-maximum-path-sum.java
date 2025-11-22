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
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxRec(root);
        return maxSum;
    }

    private int maxRec(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int left = Math.max(maxRec(node.left),0);
        int right = Math.max(maxRec(node.right),0);
        

        int newPathMax = node.val+left+right;
        maxSum = Math.max(maxSum, newPathMax);
        return node.val+Math.max(left,right);  
    }
}