import java.util.*;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toSet;

public class SumOfK {
    public static void main(String[] args) {
	System.out.println(chooseBestSum(163, 3, new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58))));
	System.out.println(chooseBestSum(163, 3, new ArrayList<>(Arrays.asList(50))));
	System.out.println(chooseBestSum(230, 3, new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87))));
    }
    
    public static Integer chooseBestSum(int maxDistance, int totalPlacesToVisit, List<Integer> ls) {
        List<Integer> distances = new ArrayList<>(ls);
        distances.removeIf(i -> i == null || i < 0);
		
		final boolean cannotVisitAllPoints = totalPlacesToVisit > distances.size();
        if (cannotVisitAllPoints) {
          return null;
        }
        
        final boolean sameAmountOfDistancesAndPoints = totalPlacesToVisit == distances.size();
        if (sameAmountOfDistancesAndPoints) {
          int totalDistance = distances.stream().mapToInt(Integer::intValue).sum();
          return totalDistance <= maxDistance ? totalDistance : null;
        }
        
        //Get all combinations
        Set<String> distinctBinaryCombinations = IntStream.range(1, 1 << distances.size())
                .filter(i -> Integer.bitCount(i) == totalPlacesToVisit)
                .mapToObj(i -> String.format("%" + distances.size() + "s", Integer.toBinaryString(i)).replace(' ', '0'))
                .collect(toSet());
                
        // add up all the groups
        List<Integer> totals = new LinkedList<>();

        for (String bin : distinctBinaryCombinations) {
            int total = 0;
            for(int i = 0; i < bin.length(); i++) {
                if (bin.charAt(i) == '1') {
                    total+= distances.get(i);
                }
            }

            totals.add(total);
        }
        
        // return closest if not possible null
        return totals.stream().filter(i -> i <= maxDistance)
                .sorted( Comparator.comparingInt(i -> maxDistance - i))
                .findFirst().orElse(null);
    }
}