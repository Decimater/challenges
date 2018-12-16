import java.util.*;
import java.util.stream.Collectors;

public class Numericals {
    public static String numericals(String s) {
        Map<Integer, Integer> streamCounts = new HashMap<>();
        
        return s.chars()
                .mapToObj(i -> streamCounts.merge(i, 1, Integer::sum))
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}