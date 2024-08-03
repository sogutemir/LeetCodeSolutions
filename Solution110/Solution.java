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
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root).isBalanced;
    }
    
    private BalanceStatusWithHeight checkBalance(TreeNode node) {
        if (node == null) {
            return new BalanceStatusWithHeight(true, 0);
        }
        
        BalanceStatusWithHeight leftResult = checkBalance(node.left);
        if (!leftResult.isBalanced) {
            return new BalanceStatusWithHeight(false, 0);
        }
        
        BalanceStatusWithHeight rightResult = checkBalance(node.right);
        if (!rightResult.isBalanced) {
            return new BalanceStatusWithHeight(false, 0);
        }
        
        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        
        return new BalanceStatusWithHeight(isBalanced, height);
    }
    
    private static class BalanceStatusWithHeight {
        boolean isBalanced;
        int height;
        
        BalanceStatusWithHeight(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
