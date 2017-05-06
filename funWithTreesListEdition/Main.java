import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(17, new ListNode(1));
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(16);
        ListNode l6 = new ListNode(7, new ListNode(3));
        TreeNode root = new TreeNode(l1, new TreeNode(l2, new TreeNode(l4), null), new TreeNode(l3, new TreeNode(l5), new TreeNode(l6)));

        String output = "";
        ListNode myLn = flatten(root);
        while (myLn != null) {
            System.out.println(myLn.data);
            myLn = myLn.next;
        }
    }

    static ListNode flatten(TreeNode root) {
        List<Integer> treeDataValues = new LinkedList<>();
        List<TreeNode> layer = new LinkedList<>();
        layer.add(root);

	// Add all data values for each layer
        while (!layer.isEmpty()) {
            List<TreeNode> nextLayer = new LinkedList<>();
            nextLayer.clear();
            for (TreeNode aNode : layer)  {
                if (aNode.left != null) nextLayer.add(aNode.left);
                if (aNode.right != null) nextLayer.add(aNode.right);
                if (aNode.value != null) {
                    ListNode myLn = aNode.value;
                    while (myLn != null) {
                        treeDataValues.add(myLn.data);
                        myLn = myLn.next;
                    }
                }
                layer = nextLayer;
            }
        }

	// Build return list, distinct and ordered.
        List<Integer> testList = treeDataValues.stream().distinct().sorted().collect(Collectors.toList());
        ListNode head = new ListNode(testList.get(0));
        ListNode tail= head;

        for (int i = 1; i < testList.size(); i++) {
            ListNode middle = tail;
            tail = new ListNode(testList.get(i));
            middle.next = tail;
        }

        return head;
    }
}