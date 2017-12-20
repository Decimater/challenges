import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.AbstractMap.SimpleEntry;

public class ColouredTriangle {
	public static final Map<String, String> COLOURS = Collections.unmodifiableMap(Stream.of(
            new SimpleEntry<>("BG", "R"),
            new SimpleEntry<>("GB", "R"),
            new SimpleEntry<>("BR", "G"),
            new SimpleEntry<>("RB", "G"),
            new SimpleEntry<>("RG", "B"),
            new SimpleEntry<>("GR", "B")
    ).collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue)));
	
	public static void main(String[] args) {
		ColouredTriangle ct = new ColouredTriangle();
		
		System.out.println(ct.triangle("RRR")); // R
		System.out.println(ct.triangle("RBRGBRB")); // G
		System.out.println(ct.triangle("RBRGBRBGGRRRBGBBBGG")); // G
	}

	public static char triangle(final String row) {
		if(row.length() <= 1) return row.charAt(0);
		
		StringBuilder nextRow = new StringBuilder();

		for (int i = 0; i < row.length()-1; i++) {
			if (row.charAt(i) == row.charAt(i+1)) {
				nextRow.append(row.charAt(i));
			} else {
				nextRow.append(COLOURS.get(row.substring(i, i+2)));
			}
		}
		
		return triangle(nextRow.toString());
	} 
}