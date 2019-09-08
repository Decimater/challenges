import java.util.*;
import java.util.stream.Collectors;

class Permutations {
    public static Set<String> visited;
    
    public static List<String> singlePermutations(String s) {
        visited = new HashSet<>();
        generatePermutations(s);
        return visited.stream().collect(Collectors.toList());
    }
    
    public static void generatePermutations(String s) {
        if(visited.contains(s)) {
            return;
        }

        visited.add(s);

        for (int i = 0; i < s.length()-1; i++) {
            StringBuilder swappedChars = new StringBuilder(s);
            char temp = s.charAt(i);
            swappedChars.setCharAt(i, swappedChars.charAt(i+1));
            swappedChars.setCharAt(i+1, temp);

            generatePermutations(swappedChars.toString());
        }
    } 
}
