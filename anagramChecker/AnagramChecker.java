import java.util.List;
import java.util.stream.Collectors;

public class AnagramChecker {
	public static void main(String[] args) {
		System.out.println(isAnagram("foefet", "toffee"));
		System.out.println(isAnagram("Buckethead", "DeathCubeK"));
		System.out.println(isAnagram("Twoo", "Woot"));
		System.out.println(isAnagram("apple", "pale"));
	}
	
  public static boolean isAnagram(String test, String original) {
    if (test.length() != original.length()) return false;
  
    List<Integer> letters = original.toLowerCase().chars().boxed().collect(Collectors.toList());

    for (char letter : test.toLowerCase().toCharArray()) {
        letters.remove(new Integer(letter));
    }
    
    return letters.isEmpty();
  }
}