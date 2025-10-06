import java.util.LinkedList;
import java.util.Queue;

public class inversetree{

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }
    static class Solution {

        public TreeNode invertTreeRecursive(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = invertTreeRecursive(root.left);
            TreeNode right = invertTreeRecursive(root.right);
            

            root.left = right;
            root.right = left;
            
            return root;
        }

     
        public TreeNode invertTreeIterative(TreeNode root) {
            if (root == null) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                
                
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;
                
                
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            return root;
        }
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.print("[");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println("]");
    }


    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.print("original tree: ");
        printTree(root);

        Solution solution = new Solution();
        solution.invertTreeRecursive(root); 

        System.out.print("inverted tree: ");
        printTree(root);
    }
}