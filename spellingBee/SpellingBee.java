import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpellingBee {

   public static final List<String> bees = new ArrayList<>(Arrays.asList("bee", "eeb"));

   public static void main(String[] args) {
       final char hive[][] = new char[][] {
               "bee.bee".toCharArray(),
               "e.e.e.e".toCharArray(),
               "eeb.eeb".toCharArray()
       }; // returns 8

       int count = 0;
       //horizontal
       for (char[] word : hive) {
           String horizontalHive = new String(word);
           //count += (int) Arrays.stream(horizontalHive.split("\\.")).filter(s -> s.contains("bee") || s.contains("eeb")).count();
           count += Arrays.stream(horizontalHive.split("\\.")).mapToInt(SpellingBee::beesInString).sum();
       }

       //vertical
       for (int i = 0; i < hive[0].length; i++) {
	   StringBuilder verticalLine = new StringBuilder();

           for (int j = 0; j < hive.length; j++) {
               verticalLine.append(hive[j][i]);
           }

           count += (Arrays.stream(verticalLine.toString().split("\\."))).mapToInt(SpellingBee::beesInString).sum();
       }

       System.out.println(count);
   }

   public static int beesInString(String line) {
       if (line.length() < 3) return 0;

       int count = bees.contains(line.substring(0, 3)) ? 1 : 0;
       return count + beesInString(line.substring(1));
   }
}