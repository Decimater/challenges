import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;

public class BCalc {

    static Set<String> bananas(final String s) {
        //Check if worth working on
        if (s.length() < 6 || !Pattern.compile("b+.*a+.*n+.*a+.*n+.*a+.*").matcher(s).matches()) {
            return Collections.EMPTY_SET;
        }

        if (s.equals("banana")) {
            return new HashSet(Arrays.asList("banana"));
        }

        Set<String> possibleBananas = new HashSet<>(Arrays.asList(s));

        int blanks = s.length() - 6;
        for(int i = 0; i < blanks; i++) {
            runningBlank(possibleBananas);
        }

        return possibleBananas.stream()
                .parallel()
                .filter(i -> i.replaceAll("-", "").equals("banana"))
                .collect(Collectors.toSet());
    }

    static void runningBlank(Set<String> aSet) {
        Set<String> mySet = new HashSet<>(aSet);
        for (String word : mySet) {
            StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                char swap = sb.charAt(i);
                sb.setCharAt(i, '-');
                aSet.add(sb.toString());
                sb.setCharAt(i, swap);
            }
        }
    }

    static Set<String> testCalc (String inputString) {
        List<String> possibleBananas = new LinkedList<>();

	// Possibilities are two values per char blank or what it was whic is 2 to the power string length, or 1<<string length
        for (int i = 0; i < (int) Math.pow(2, inputString.length()); i++) {
            StringBuilder sb = new StringBuilder(inputString);
            char[] itemsToSwap = Integer.toBinaryString(i).toCharArray();
            for (int j = 0; j < itemsToSwap.length; j++) {
                if (itemsToSwap[itemsToSwap.length -j-1] == '1') {
                    sb.setCharAt(j, '-');
                }
            }
            possibleBananas.add(sb.toString());
        }

        return possibleBananas.stream().filter(s -> s.replaceAll("-", "").equals("banana")).collect(Collectors.toSet());
    }
}