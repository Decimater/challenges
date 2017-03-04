import java.util.*;

public class SumGroups {
    public static void main(String[] args) {
        System.out.println(sumGroups(new int[] {2, 1, 2, 2, 6, 5, 0, 2, 0, 5, 5, 7, 7, 4, 3, 3, 9})); // 6
        System.out.println(sumGroups(new int[] {2, 1, 2, 2, 6, 5, 0, 2, 0, 3, 3, 3, 9, 2})); // 5
        System.out.println(sumGroups(new int[] {2})); // 1
        System.out.println(sumGroups(new int[] {1,2})); // 2
    }

    public static int sumGroups(int[] arr) {
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int oddEven = arr[i] % 2 == 0 ? 0 : 1;
            while (i < arr.length && arr[i] % 2 == oddEven) {
                sum += arr[i];
                i++;
            }
            output.add(sum);
            i--;
        }

        Integer[] processedArray = output.toArray(new Integer[output.size()]);
        return (zigZagChecker(processedArray)) ? processedArray.length : sumGroups(Arrays.stream(processedArray).mapToInt(Integer::intValue).toArray());
    }

    public static boolean zigZagChecker(Integer[] someArray) {
        Boolean[] bArray = Arrays.stream(someArray).map(i -> i % 2 == 0).toArray(Boolean[]::new);
        Boolean compare = bArray[0];
        for (int i = 1; i < bArray.length; i++) {
            if(compare == bArray[i]) {
                return false;
            } else {
                compare = !compare;
            }
        }

        return true;
    }
}