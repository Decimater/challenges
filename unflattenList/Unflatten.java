import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Unflatten {

    public static void main(String[] args) {
        int[] input = new int[] { 1, 4, 5, 2, 1, 2, 4, 5, 2, 6, 2, 3, 3 };

        Object[] expected = new Object[] { 1, new int[] { 4,5,2,1 }, 2, new int[] { 4,5,2,6 }, 2, new int[] { 3, 3 } };

        System.out.println(
                Arrays.deepToString(expected)
        );

        System.out.println(
                Arrays.deepToString(unflatten(input))
        );
    }

    public static Object[] unflatten(int[] flatArray) {
        if (flatArray == null || flatArray.length == 0) return new Object[0];

        List<Object> output = new ArrayList<>(flatArray.length);

        for (int i = 0; i < flatArray.length; i++) {
            if (flatArray[i] < 3) {
                output.add(flatArray[i]);
            } else {
                int newArrayLength = (flatArray[i] + i) < flatArray.length ? flatArray[i] : flatArray.length - i;
                int[] arrayToAdd = new int[newArrayLength];

                for (int j = 0; j < arrayToAdd.length; j++, i++) {
                    arrayToAdd[j] = flatArray[i];
                }

                i--;
                output.add(arrayToAdd);
            }
        }

        return output.toArray();
    }

}