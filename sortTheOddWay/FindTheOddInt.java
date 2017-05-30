import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheOddInt {
   public static void main(String[] args) {
       int[] A = new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5};

       Map<Integer, Long> myMap = Arrays.stream(A)
               .boxed()
               .collect(
               Collectors.groupingBy( Function.identity(), Collectors.counting() )
       );

       int aValue = myMap.keySet().stream().filter(k -> myMap.get(k) % 2 == 1).findFirst().get();

       System.out.println(aValue);
   }
}