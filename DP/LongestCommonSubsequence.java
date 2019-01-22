class LongestCommonSubsequence{
	public static void main(String[] args){
		String first = args[0];
		String second = args[1];
		System.out.println(LCS(first,second,first.length()-1,second.length()-1));
		int m = first.length();
		int n = second.length();
		// Memoization Table
		int[][] mem = new int[m][n];



	}


	// Each time recursion is splitting into two
	//O(n) = n^3
	private static int LCS(String first,String second,int m,int n){
		if(m == -1 || n == -1){
			return 0;
		}
		if(first.charAt(m) == second.charAt(n)){
			return 1 + LCS(first,second,m-1,n-1);
		}else{
			return Math.max(LCS(first,second,m-1,n),LCS(first,second,m,n-1));	
		}
		
	}


	private static int LCSM(String first,String second,int m,int n,int[][] mem){
		if( m == -1 || n == -1){
			return 0;
		}else if (first.charAt(m) == second.charAt(n)){
			mem[m][n] = 1 + LCS(first,second,m-1,n-1,mem);
		}else{
			mem[m][n] = Math.max(LCS(first,second,m-1,n),LCS(first,second,m,n-1));	
		}
		return mem[first.length()][second.length()];

	}







}