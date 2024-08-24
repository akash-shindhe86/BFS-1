// Time Complexity : O(n)
// Space Complexity : O(1) for dfs, O(h) for bfs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : nope

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
    //bfs
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                li.add(cur.val);

                if(cur.left != null){
                    q.add(cur.left);
                }

                if(cur.right != null){
                    q.add(cur.right);
                }
            }

            result.add(li);
        }
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root,0);
        return result;
    }

    void helper(TreeNode root, int level){
        if(root == null) return;

        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}