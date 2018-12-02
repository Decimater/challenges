import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BallotsCounter {

    public static String getWinner(final List<String> listOfBallots) {
      return listOfBallots.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
		.stream()
                	.filter(e -> e.getValue() > listOfBallots.size() /2L)
	                .findFirst()
        	        .map(Map.Entry::getKey)
                	.orElse(null);
    }
}