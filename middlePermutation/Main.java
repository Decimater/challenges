public class Main {
	public static void main(String[] args) {
		System.out.println(MiddlePermutation.findMidPerm("abc")); // bac
		System.out.println(MiddlePermutation.findMidPerm("abcd")); // bdca
		System.out.println(MiddlePermutation.findMidPerm("abcdx")); // cbxda
		System.out.println(MiddlePermutation.findMidPerm("abcdxg")); // cxgdba
		System.out.println(MiddlePermutation.findMidPerm("abcdxgz")); // dczxgba
	}
}