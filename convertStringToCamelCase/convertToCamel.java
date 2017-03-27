import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class convertToCamel {
	public static void main(String[] args) {
		// returns "theStealthWarrior"
		System.out.println(toCamelCase("the-stealth-warrior")); 

		// returns "TheStealthWarrior"
		System.out.println(toCamelCase("The_Stealth_Warrior"));
	}

	static String toCamelCase(String s){
		if (s == null || s.isEmpty()) return "";
    
		//should have used matcher append replacement
    		List<StringBuilder> words = Arrays.stream(s.toLowerCase().split("[-_]"))
                	                  .map(StringBuilder::new)
                        	          .collect(Collectors.toList());
		words.stream().forEach(i -> i.setCharAt(0, Character.toUpperCase(i.charAt(0))));
		words.get(0).setCharAt(0, s.charAt(0));
		return words.stream().collect(Collectors.joining(""));
	}
}