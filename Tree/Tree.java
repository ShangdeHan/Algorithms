public class Tree {
    /*
    101. Symmetric Tree
    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
    Example:
    Input: root = [1,2,2,3,4,4,3]
    Output: true

    Example2;
    Input: root = [1,2,2,null,3,null,3]
    Output: false
     */



      public class TreeNode { int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
     }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if(left==null && right==null)return true;
        if(left==null && right!=null)return false;
        if(left!=null && right==null)return false;
        int valr = right.val;
        int vall = left.val;
        return (valr==vall) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
