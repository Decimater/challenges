import java.util.*;
import java.util.stream.Collectors;

public class CountIPAddresses {
	public static void main(String[] args) {
		System.out.println(ipsBetween("10.0.0.0", "10.0.0.50")); // 50
		System.out.println(ipsBetween("20.0.0.10", "20.0.1.0")); // 246
	}

	/*
	*	IP v4 addresses are 32 bit numbers 4 bytes separated by '.' and are unsigned
	*/
	public static long ipsBetween(String start, String end) {
		System.out.println("s: " + start + "\te:" + end);
		
		String startIP = Arrays.stream(start.split("\\."))
					.map(Integer::parseInt)
					.map(i -> String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0') )
					.collect(Collectors.joining());
				  
		String endIP = Arrays.stream(end.split("\\."))
					.map(Integer::parseInt)
					.map(i -> String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0') )
					.collect(Collectors.joining());
					
		return Long.parseLong(endIP, 2) - Long.parseLong(startIP, 2);
	}
}