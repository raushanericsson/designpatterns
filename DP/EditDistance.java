import java.util.Scanner;
class EditDistance{

	// Finding Edit Distance Between two String
	//private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		String first = "SATURDAY";
		String second = "SUNDAY";
		int m = first.length();
		int n = second.length();
		System.out.println(findEditDistance(first,second,m-1,n-1));
		System.out.println(findEditDistanceByDp(first,second,m,n));

	}



// Time Complexity 
	//O(N) = O(n) + O(m) + O(n^3)
	//O(N) = O(n^3);

	private static int findEditDistance(String first,String second,int m,int n){
		if(m < 0 && n < 0){
			return 0;
		}else if (m == -1){
			return n+1;
		}else if (n == -1){
			return m+1;
		}
		if(first.charAt(m) == second.charAt(n)){
			return findEditDistance(first,second,m-1,n-1);
		}
		else {
			return 1 + Math.min(findEditDistance(first,second,m-1,n-1),Math.min(findEditDistance(first,second,m-1,n),findEditDistance(first,second,m,n-1)));
		}

	}

	// Solve by Dynamic Programming 
	// Compare from 0--->n and 0---->m
	// Filling Table of siz m * n = m^2 worst case
	//O(n) = O(m*n)

	private static int findEditDistanceByDp(String first,String second,int m,int n){
		int[][] save = new int[m+1][n+1];
		save[0][0] = 0;
		for(int i=1;i<=n;i++){
			save[0][i] = save[0][i-1] +1;
		}
		for(int i=1;i<=m;i++){
			save[i][0] = save[i-1][0] +1;
		}

		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(first.charAt(i-1) == second.charAt(j-1)){
					save[i][j] = save[i-1][j-1];
				}else{
					save[i][j] = 1 + Math.min(save[i-1][j-1],Math.min(save[i-1][j],save[i][j-1]));
				}
			}
		}
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				System.out.print(save[i][j] + " ");
			}
			System.out.println();

		}
		return save[m][n];
	}
	
}

