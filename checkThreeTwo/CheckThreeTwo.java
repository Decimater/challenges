import java.nio.CharBuffer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckThreeTwo {
	public static void main(String[] args) {
		System.out.println(checkThreeAndTwo(new char[] { 'a', 'a', 'b', 'b', 'b' }));
		System.out.println(checkThreeAndTwo(new char[] { 'a', 'c', 'a', 'c', 'b' }));
		System.out.println(checkThreeAndTwo(new char[] { 'a', 'a', 'a', 'a', 'a' }));
	}
	
	/***
	* With or without streams the solution is messy
	*/
    public static boolean checkThreeAndTwo(char[] chars) {
      return CharBuffer.wrap(chars)
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .values()
                    .stream()
                    .filter(i -> i == 2 || i == 3)
                    .collect(Collectors.toSet())
						.size() == 2;
    }
}