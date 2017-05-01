import java.util.*;
import java.util.stream.IntStream;

public class JosephusSurvivor {
  public static void main(String[] args) {
    System.out.println(josephusSurvivor(7, 3));
  }

  public static int josephusSurvivor(final int n, final int k) {
    List<Integer> values = new LinkedList<>();
    IntStream.rangeClosed(1, n).forEach(values::add);

    int indexToRemove = k-1;

    while (values.size() > 1) {
        if (indexToRemove > values.size()-1) {
            indexToRemove %= values.size();
        }
        values.remove(indexToRemove);
        indexToRemove += k-1;
    }
    
    return values.get(0);
  }  
}