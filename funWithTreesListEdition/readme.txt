https://www.codewars.com/kata/fun-with-trees-lists-edition/train/java

Fun with trees: lists edition

You are given a binary tree, where every node points to a head of an integer linked list. Implement the method flatten which returns a sorted linked list from the values of all the lists, without duplicates.

For example, given the following tree:

    17->1
   /  \
  3    1
 /    / \
2    16  7->3

The method should return 1 -> 2 -> 3 -> 7 -> 16 -> 17.

The classes TreeNode & ListNode are available for you:

class TreeNode {
  public TreeNode left;
  public TreeNode right;
  public ListNode value;

  TreeNode(ListNode value, TreeNode left, TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  TreeNode(ListNode value) {
    this(value, null, null);
  }
}

class ListNode {
  public int data;
  public ListNode next;

  ListNode(int data, ListNode next) {
    this.data = data;
    this.next = next;
  }

  ListNode(int data) {
    this(data, null);
  }
}