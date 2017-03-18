import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pandigitals {
    public static void main(String[] args) {
        //List<String> panDigitals = IntStream.rangeClosed(1400, 2000).mapToObj(i -> romanNumeralGenerator(i)).filter(isPandigital()).collect(Collectors.toList());
        List<Integer> panDigitalInDecimal = IntStream.rangeClosed(1400, 2000)
												.filter(i -> isPandigital().test(romanNumeralGenerator(i)))
												.boxed()
												.collect(Collectors.toList());

        System.out.println(panDigitalInDecimal);
    }

    public static Predicate<String> isPandigital() {
        return i -> i.length() == 7 && i.contains("M") && i.contains("C") && i.contains("X")
                && i.contains("L") && i.contains("V") && i.contains("I") && i.contains("D") ;
    }

    private static Map<Integer, String> numerals = new HashMap<>();
    private static List<Integer> sortedNumeralKeys = new LinkedList<>();
    static {
        numerals.put(1000, "M");
        numerals.put(100, "C");
        numerals.put(500, "D");
        numerals.put(50, "L");
        numerals.put(10, "X");
        numerals.put(5, "V");
        numerals.put(1, "I");

        numerals.put(4, "IV");
        numerals.put(9, "IX");
        numerals.put(40, "XL");
        numerals.put(90, "XC");
        numerals.put(400, "CD");
        sortedNumeralKeys = numerals.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    private static String romanNumeralGenerator(int toConvert) {
        StringBuilder output = new StringBuilder();
        for (Integer amount : sortedNumeralKeys) {
            int divideQuantity = toConvert / amount;
            int minusAmount = divideQuantity * amount;

            while (divideQuantity > 0) {
                output.append(numerals.get(amount));
                divideQuantity--;
            }
            toConvert -= minusAmount;
        }

        return output.toString();
    }
}