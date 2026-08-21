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
 */class Solution {
    HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    
    public int amountOfTime(TreeNode root, int start) {
        TreeNode startNode = findStart(root, start);
        
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> vis = new HashSet<>();
        
        q.offer(startNode);
        vis.add(startNode);
        
        int time = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            boolean infected = false;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                if (node.left != null && !vis.contains(node.left)) {
                    vis.add(node.left);
                    q.offer(node.left);
                    infected = true;
                }
                
                if (node.right != null && !vis.contains(node.right)) {
                    vis.add(node.right);
                    q.offer(node.right);
                    infected = true;
                }
                
                if (parent.containsKey(node) && !vis.contains(parent.get(node))) {
                    TreeNode p = parent.get(node);
                    vis.add(p);
                    q.offer(p);
                    infected = true;
                }
            }
            
            if (infected) {
                time++;
            }
        }
        
        return time;
    }
    
    private TreeNode findStart(TreeNode root, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            
            if (node.val == start) {
                return node;
            }
            
            if (node.left != null) {
                parent.put(node.left, node);
                q.offer(node.left);
            }
            
            if (node.right != null) {
                parent.put(node.right, node);
                q.offer(node.right);
            }
        }
        
        return null;
    }
}