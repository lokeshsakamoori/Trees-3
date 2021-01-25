Time: O(n)
 Space:O(1)



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
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if(root == null) return result;
        target = sum;
        backTrack(root,0,new ArrayList<>());
        return result;
    }
    
    
    private void backTrack(TreeNode root, int currSum, List<Integer> path ){
          
        if(root ==null) return;
        
        currSum+=root.val;
        path.add(root.val);
        if(root.left==null && root.right == null){
            if(currSum == target){
            result.add(new ArrayList<>(path));
         }
        
        }
        
        backTrack(root.left, currSum,path );
        backTrack(root.right, currSum,path );
        path.remove(path.size()-1);
    }
}
