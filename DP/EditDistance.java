import java.util.Scanner;
class EditDistance{

	// Finding Edit Distance Between two String
	//private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		String first = "ABC";
		String second = "ABD";
		int m = first.length();
		int n = second.length();
		System.out.println(findEditDistance(first,second,m-1,n-1));
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
	
}

