import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumSubArraySum {
  public static int sequence(int[] arr) {   
    List<List<Integer>> layers = new LinkedList<>();

      layers.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));

      for (int i = 0; i < arr.length -1; i++) {
          List<Integer> layer = new LinkedList<>();

          for (int j = i+1, layerIndex = 0; j < arr.length; j++, layerIndex++) {
              int total = layers.get(layers.size() -1).get(layerIndex) + arr[j];
              layer.add(total);
          }

          layers.add(layer);
      }

      int largest = layers.stream().flatMap(List::stream).max(Integer::compareTo).orElse(0);
      return largest > 0 ? largest : 0;
  }

  public static void main(String[] args) {
      System.out.println("Example array should have a max of 6");
      System.out.println(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }
}