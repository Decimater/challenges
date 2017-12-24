import java.util.*;
import java.util.stream.Collectors;

public class StockList {
	public static void main(String[] args) {
		String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
    	String cd[] = new String[] {"A", "B"};
		System.out.println(StockList.stockSummary(art, cd));
		// "(A : 200) - (B : 1140)"
	}
	
	public static String stockSummary(String[] stockCategoryQuantity, String[] cd) {
    if (cd.length == 0 || stockCategoryQuantity.length == 0) return "";
    
		Map<String, List<Integer>> catOrderMap = new HashMap<>();
    Arrays.stream(cd).forEach(s -> catOrderMap.put(s, new LinkedList<Integer>()));
    
    for (String catWord: cd) {
      for (String scq : stockCategoryQuantity) {
        if (catWord.charAt(0) == scq.charAt(0)) {
            Integer quantity = Integer.parseInt(scq.split(" ")[1]);
            catOrderMap.get(catWord).add(quantity);
        }
      }
    }
    
    return Arrays.stream(cd)
                .map(s -> String.format("(%s : %d)", s, catOrderMap.get(s).stream().mapToInt(Integer::intValue).sum()))
                .collect(Collectors.joining(" - "));
	}
}
