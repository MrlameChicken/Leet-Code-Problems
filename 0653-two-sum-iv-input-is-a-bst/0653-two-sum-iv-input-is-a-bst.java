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

// public boolean findTarget(TreeNode root, int k) {
//        return findTarget(root, k, new HashSet<>());
//     }

//     private boolean findTarget(TreeNode root, int k, Set<Integer> seen) {
//        if (root == null)
//         return false;
//        if (seen.contains(k - root.val))
//         return true;

//        seen.add(root.val);

//        return findTarget(root.left, k, seen) 
//            || findTarget(root.right, k, seen);
//      }
class Solution {
    public boolean findTarget(TreeNode root, int k) {
            BSTIterator i = new BSTIterator(root);
       
        ArrayList<Integer> arr = new ArrayList<>();
            while (i.hasNext()) {
                arr.add(i.next());
            }
         int start = 0;
        int end = arr.size() - 1;
        while(end > 0 && start < arr.size() - 1 && start != end) {
            if (arr.get(start) + arr.get(end) == k) {
                return true;
            }
            if (arr.get(start) + arr.get(end) > k) {
                end--;
            }
            if (arr.get(start) + arr.get(end) < k) {
                start ++;
            }
            }
        return false;
        }
}

public class BSTIterator {
    private final Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        
        // Traversal cur node's right branch
        TreeNode cur = node.right;
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        
        return node.val;
    }
}