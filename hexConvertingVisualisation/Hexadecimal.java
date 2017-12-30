import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hexadecimal {
	public static void main(String[] args) {
		System.out.println(Hexadecimal.showHexConversion(1000));
		// Expected "1000/16=62 R  8\n  62/16= 3 R 14\n   3/16= 0 R  3\nResult=3E8"
	}
	
	public static String showHexConversion(int number) {
        if (number <= 1) return "Result=0";
      
        int divisor = 16;
        int numeratorWidth = Integer.toString(number).length();
        int quotientWidth = Integer.toString(number/divisor).length();
        int remainderWidth = IntStream.iterate(number, i -> i > 0 ? i/divisor: 0)
                .limit(31) // Maximum amount of divisions of Integer.MAX_VALUE that is not one
                .filter(i -> i > 0)
                .map(i -> Integer.toString(i%divisor).length())
                .max()
                .getAsInt(); // learning streams and cheap to do

        StringBuilder output = new StringBuilder();
        String formatString = "%" + numeratorWidth + "d/" + divisor + "=" + "%" + quotientWidth + "d R " + "%" + remainderWidth + "d\n";
        List<Integer> results = new LinkedList<>();

        while (number > 0) {
            results.add(0, number%divisor);
            String line = String.format(formatString, number, number/divisor, number%divisor);
            output.append(line);
            number /= divisor;
        }

        String resultString = results.stream().map(Integer::toHexString).collect(Collectors.joining()).toUpperCase();
        output.append("Result=" + resultString);
		
		return output.toString();
	}
}