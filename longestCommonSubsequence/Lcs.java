class Lcs {
	static String lcs(String a, String b) {
		int[][] L = new int[a.length()+1][b.length()+1];

	        for (int i = 1; i <= a.length(); i++) {
        	    for (int j = 1; j <= b.length(); j++) {
                	if (a.charAt(i-1) == b.charAt(j-1)) {
	                    L[i][j] = L[i-1][j-1] + 1;
	                } else {
	                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
        	        }
	            }
        	}

		int i = a.length(), j = b.length();
		StringBuilder output = new StringBuilder();

	        while (i > 0 && j > 0) {
	            if (a.charAt(i-1) == b.charAt(j-1)) {
	                output.append(a.charAt(i-1));
	                i--;
	                j--;
	            } else if (L[i-1][j] > L[i][j-1]) {
	                i--;
	            } else {
	                j--;
	            }
	        }
        
	       return output.reverse().toString();
	}
}