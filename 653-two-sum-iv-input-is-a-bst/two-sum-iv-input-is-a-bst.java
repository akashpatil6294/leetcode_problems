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
 class BSTIterator{
    Stack<TreeNode> stack=new Stack<TreeNode>();
    boolean rev=false;
    public BSTIterator(TreeNode root,boolean isReverse){
        rev=isReverse;
        pushAll(root);
    }
    public boolean hasNext(){
        return !stack.isEmpty();
    }
    public int next(){
        TreeNode tmp=stack.pop();
        if(rev==false){
            pushAll(tmp.right);
        }
        else{
            pushAll(tmp.left);
        }
        return tmp.val;
    }
    private void pushAll(TreeNode node){
        while(node!=null){
            stack.push(node);
            if(rev==true){
                node=node.right;
            }
            else{
                node=node.left;
            }
        }
    }
 }
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);

        int i=l.next();
        int j=r.next();

        while(i<j){
            if(i+j==k){
                return true;
            }
            else if(i+j<k) i=l.next();
        
        else{
            j=r.next();
        }
        }
        return false;  
    }
}