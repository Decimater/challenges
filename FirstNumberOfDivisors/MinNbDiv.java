import java.util.HashMap;
import java.util.Map;

public class MinNbDiv {
    public static Map<Integer, Integer> computedValues = new HashMap<>();

    public static int findMinNum(int num) {
        if (computedValues.containsKey(num)) {
            return computedValues.get(num);
        } else {
            return calc(num);
        }
    }

    public static int calc(int num) {
        int amountOfDivisors = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            for (int j = i; j > 0; j--) {
                if (i % j == 0) {
                    amountOfDivisors++;
                }
            }

            computedValues.putIfAbsent(amountOfDivisors, i);

            if (amountOfDivisors == num) {
                return i;
            }

            amountOfDivisors = 0;
        }

        return 0;
    }
}