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
    public TreeNode bstFromPreorder(int[] p) {
       return bstFromPreorder(p,Integer.MAX_VALUE,new int[]{0});
        
    }
    public TreeNode  bstFromPreorder(int[] p,int bound,int[] i){
        if(i[0]==p.length || p[i[0]]>bound){
            return null;
        }
        TreeNode root=new TreeNode(p[i[0]++]);
        root.left=bstFromPreorder(p,root.val,i);
        root.right=bstFromPreorder(p,bound,i);

        return root;
    }
}