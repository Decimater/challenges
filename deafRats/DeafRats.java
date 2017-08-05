public class DeafRats {
	
	public static void main(String [] args) {
		System.out.println(DeafRats.countDeafRats("~O~O~O~O P")); // 0
		System.out.println(DeafRats.countDeafRats("P O~ O~ ~O O~")); // 1
		System.out.println(DeafRats.countDeafRats("~O~O~O~OP~O~OO~")); // 2
	}
	
	public static int countDeafRats(final String town) {
		String leftOfPiper = town.substring(0, town.indexOf('P')).replaceAll("[P ]", "");
		String rightOfPiper = town.substring(town.indexOf('P')).replaceAll("[P ]", "");

		int deafRats = 0;
		for (int i = 0; i < leftOfPiper.length()-1; i+=2) {
			if (leftOfPiper.substring(i, i+2).equals("O~")) { deafRats++; }
		}

		for (int i = 0; i < rightOfPiper.length()-1; i+= 2) {
			if (rightOfPiper.substring(i, i+2).equals("~O")) { deafRats++;}
		}

		return deafRats;
	}
}