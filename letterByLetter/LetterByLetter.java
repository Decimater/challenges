public class LetterByLetter {
	public static void main (String[] args) {
		
		//two strings which will always be the same length
		StringBuilder sb1 = new StringBuilder("a fall to the floor");
		StringBuilder sb2 = new StringBuilder("braking the door in");
		
		//iterate over the first changing the second, print each change as full string
		System.out.println(sb1);
		for (int i = 0; i < sb1.length(); i++) {
			sb1.setCharAt(i, sb2.charAt(i));
			System.out.println(sb1);
		}
	}
}