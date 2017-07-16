import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

class MiddlePermutation {   
    public static String findMidPerm(String strng) {
       List<BigInteger> factorials = new ArrayList<>();

        BigInteger total = BigInteger.valueOf(1);
        for (int i = 1; i <= strng.length(); i++) {
            total = total.multiply(BigInteger.valueOf(i));
            factorials.add(total);
        }

        List<Character> chars = new ArrayList<>();
        IntStream.range(0, strng.length()).forEach(c -> chars.add(strng.charAt(c)));
        Collections.sort(chars);

        StringBuilder output = new StringBuilder();

        BigInteger aTotal = factorials.get(strng.length()-1).divide(BigInteger.valueOf(2));

        outer : for (int i = 0; i < strng.length(); i++) {
            for (int j = factorials.size()-1; j >= 0; j--) {
                if ( factorials.get(j).compareTo(aTotal) <= 0) {
                    if (chars.size() == 1) {
                        output.append(chars.get(0));
                        break outer;
                    }
                    final int u = j;
                    final BigInteger newTotal = aTotal;
                    int multiplier = IntStream.range(1, 100)
                            .filter(m -> (factorials.get(u).multiply(BigInteger.valueOf(m)).compareTo(newTotal)) < 0 )
                            .max()
                            .orElse(0);
                    output.append(chars.get(multiplier));
                    aTotal = aTotal.subtract(factorials.get(j).multiply(BigInteger.valueOf(multiplier)));
                    chars.remove(multiplier);
                }
            }
        }

        return output.toString();
    }   
}