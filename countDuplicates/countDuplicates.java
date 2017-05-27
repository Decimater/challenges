import java.util.*;

public class countDuplicates {
   public static void main(String[] args) {
       String text = "Indivisibilities";
       text = text.toLowerCase();

       Map<Character, Integer> counts = new HashMap<>();

       for (Character aCharacter :  text.toCharArray()) {
            if (counts.keySet().contains(aCharacter)) {
                counts.put(aCharacter, counts.get(aCharacter)+1);
            } else {
                counts.put(aCharacter, 0);
            }
       }

       long repeatingCharacters = counts.values().stream().filter(i -> i >= 1).count();

       System.out.println(repeatingCharacters);
   }
}