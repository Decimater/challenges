import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
	Solution fails due to time contraint and euclidiean distance not being taken into account
	I did learn about flood fill so added as a failure that has some value attached.
*/
public class FloodFillSlow {
    private static List<int[]> validPaths = new LinkedList<>();
    private static int validPathsLength = Integer.MAX_VALUE;
    private static Predicate<int[]> isValidPoint = null;
    private static char[][] map = null;
    private static char start = 'S', blocked = 'X', goal = 'G', pathway = 'P';
    private static int[] startingPoint = null, endPoint = null;

    public static void main(String[] args) {
        String existingWires =
                "XX.S.XXX..\n" +
                "XXXX.X..XX\n" +
                "...X.XX...\n" +
                "XX...XXX.X\n" +
                "....XXX...\n" +
                "XXXX...XXX\n" +
                "X...XX...X\n" +
                "X...X...XX\n" +
                "XXXXXXXX.X\n" +
                "G........X";

	System.out.println(existingWires);
	System.out.println("\n\n\n");

        map =  Arrays.stream(existingWires.split("\n")).map(String::toCharArray).toArray(char[][]::new);

        startingPoint = findPoint(start);endPoint = findPoint(goal);

        isValidPoint = a -> a[0] >= 0 && a[1] >= 0 && a[0] < map.length && a[1] < map[0].length && map[a[0]][a[1]] != blocked;
        long startTime = System.currentTimeMillis();
        pathFinder(startingPoint, new LinkedList<>());
        System.out.println(System.currentTimeMillis() - startTime + "ms");

        validPaths.remove(startingPoint);
        validPaths.forEach(a -> map[a[0]][a[1]] = pathway);
        String output = Arrays.stream(map).map(String::new).collect(Collectors.joining("\n"));
        System.out.println(output);
    }

    public static void pathFinder(int[] startingPoint, List<int[]> currentPath) {
        if (!isValidPoint.test(startingPoint) || currentPath.stream().anyMatch(a -> Arrays.equals(a, startingPoint))) {
            return;
        }
        if (map[startingPoint[0]][startingPoint[1]] == goal && validPathsLength > currentPath.size()) {
            validPathsLength = currentPath.size();
            validPaths = currentPath;
            return;
        }

        currentPath.add(startingPoint);

        pathFinder(new int[] {startingPoint[0]+1, startingPoint[1]+1}, new LinkedList<>(currentPath));
        pathFinder(new int[] {startingPoint[0]-1, startingPoint[1]}, new LinkedList<>(currentPath));
        pathFinder(new int[] {startingPoint[0], startingPoint[1]-1}, new LinkedList<>(currentPath));
        pathFinder(new int[] {startingPoint[0], startingPoint[1]+1}, new LinkedList<>(currentPath));
        pathFinder(new int[] {startingPoint[0]-1, startingPoint[1]+1}, new LinkedList<>(currentPath));
        pathFinder(new int[] {startingPoint[0]-1, startingPoint[1]-1}, new LinkedList<>(currentPath));
        pathFinder(new int[] {startingPoint[0]+1, startingPoint[1]}, new LinkedList<>(currentPath));
        pathFinder(new int[] {startingPoint[0]+1, startingPoint[1]-1}, new LinkedList<>(currentPath));

    }

    public static int[] findPoint(char place) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == place) {
                    return new int[] {i, j};
                }
            }
        }

        throw new IllegalStateException("No starting point!");
    }
}