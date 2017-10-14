import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ThreeAmigos {
  public static void main(String[] args) {
	  System.out.println(Arrays.toString(ThreeAmigos.threeAmigos(new int[]{1, 2, 34, 2, 1, 5, 3, 5, 7, 234, 2, 1}))); // [5, 3, 5]
	  System.out.println(Arrays.toString(ThreeAmigos.threeAmigos(new int[]{2, 4, 6, 8, 10, 2, 2, 2, 1, 1, 1, 5, 3}))); // [2, 2, 2]
	  System.out.println(Arrays.toString(ThreeAmigos.threeAmigos(new int[]{2, 4, 5, 3, 6, 3, 1, 56, 7, 6, 3, 12}))); // []
  }

  public static int[] threeAmigos(final int[] numbers) {
    List<List<Integer>> lists = new LinkedList<>();
    IntStream.range(0, numbers.length -2).forEach(i -> lists.add(Arrays.asList(numbers[i], numbers[i+1], numbers[i+2])));
    
    List<Integer> output = lists.stream()
                        .filter(ThreeAmigos::hasParity)
                        .min(Comparator.comparingLong(ThreeAmigos::range))
                        .orElse(new LinkedList<>());
                 
    return output.stream().mapToInt(Integer::intValue).toArray();
  }
  
  public static boolean hasParity(List<Integer> numbers) {
      long countEven = numbers.stream().filter(i -> i % 2 == 0).count();
      return countEven == 0 || countEven == numbers.size();
  }

  public static long range(List<Integer> numbers) {
      long range = numbers.stream().max(Integer::compareTo).get() - numbers.stream().min(Integer::compare).get();
      return Math.abs(range);
  }
}