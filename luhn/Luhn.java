import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Luhn {
	public static void main(String[] args) {
		System.out.println(validate("891")); //false
		System.out.println(validate("1230")); //true
	}

	public static boolean validate(String n){
		int startIndex = n.length() % 2 == 0 ? 0 : 1;
        	List<Integer> numbers = IntStream.range(0, n.length()).map(i -> Character.getNumericValue(n.charAt(i)))
                	.boxed()
                	.collect(Collectors.toList());

        	for (int i = startIndex; i < n.length(); i+=2) {
	            int temp = numbers.get(i)*2;
        	    numbers.set(i, temp > 9 ? temp-9 : temp);
	        }

        	return numbers.stream().reduce((a,b) -> a+b).orElse(0) % 10 == 0;
	}
}