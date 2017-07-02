import java.util.*;

class TreeMaxPathFinder {
    static int maxSum(TreeNode root) {
        if (root == null) return 0;
        
        List<List<Integer>> head = new LinkedList<>();
        pathFinder(root, new LinkedList<Integer>(), head);
        
        return head.stream()
                .mapToInt(i -> i.stream().reduce((a, b) -> a+b).get())
                .max()
                .getAsInt();
    }
    
    public static void pathFinder(TreeNode aNode, List<Integer> aList, List<List<Integer>> head) {
      aList.add(aNode.value);
    
      if (aNode.left == null || aNode.right == null) { 
          head.add(aList); 
      }  
      
      if (aNode.left != null) {
          pathFinder(aNode.left, new LinkedList(aList), head);
      }
      
      if (aNode.right != null) {
          pathFinder(aNode.right, new LinkedList(aList), head);
      }

      return;
    }
}