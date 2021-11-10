Time Complexity : O(N);
Space Complexity : O(N);


class Solution{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        solve(root, res, 0);
        return res;
    }

    void solve(TreeNode root, List<List<Integer>> res, int level) {
        if(root == null) return;
        if(level == res.size()) {
            res.add(new ArrayList());
        }
        res.get(level).add(root.val);
        solve(root.left, res, level+1);
        solve(root.right, res, level+1);
    }
}