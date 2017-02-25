import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Routes {
    public static void main(String[] args) {
        //String[][] routes = {{"MNL", "TAG"}, {"CEB", "TAC"}, {"TAG", "CEB"}, {"TAC", "BOR"}};
        String[][] routes = new String[][]{{"Chicago", "Winnipeg"}, {"Halifax", "Montreal"}, {"Montreal", "Toronto"}, {"Toronto", "Chicago"}, {"Winnipeg", "Seattle"}};

        List<String[]> routeBin = new ArrayList<>();
        IntStream.range(1, routes.length).forEach(i -> routeBin.add(routes[i]));

        List<String[]> routesSorted = new ArrayList<>();
        routesSorted.add(routes[0]);

        String[] routeToRemove = null;
        while (!routeBin.isEmpty()) {
            for (String[] route : routeBin) {
                if (routesSorted.get(0)[0] == route[1]) {
                    routesSorted.add(0, route);
                    routeToRemove = route;
                    break;
                } else if (routesSorted.get(routesSorted.size()-1)[1] == route[0]) {
                    routesSorted.add(route);
                    routeToRemove = route;
                    break;
                }
            }
            routeBin.remove(routeToRemove);
        }

        String output = routesSorted.stream().map(i -> i[0]).collect(Collectors.joining(", "));
        System.out.println(output + ", " + routesSorted.get(routesSorted.size()-1)[1]);
    }
}