public class Main {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(10);

		System.out.println("Max sum: " + TreeMaxPathFinder.maxSum(root));
	}
}