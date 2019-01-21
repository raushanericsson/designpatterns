class CountPath{

	public static void main(String[] args){
		int[][] arr = new int[][]{{1,3,5},{7,9,10},{2,3,4}};
		System.out.println(getPathCount(arr,2,3));
		int[][] M = new int[3][4];
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				if(i == 0 || j == 0){
					M[i][j] = 1;
				}else{
					M[i][j] = 0;	
				}
				
			}
		}
		System.out.println(getPathCountMemoization(M,arr,2,3));
		System.out.println(getPathCountDP(arr,2,3));
	}

	public static int getPathCount(int[][] arr,int m,int n){
		if(m == 0 ||  n == 0){
			return 1;

		}else{
			return getPathCount(arr,m-1,n) + getPathCount(arr,m,n-1);
		}
	}


// Use memoization 

	public static int getPathCountMemoization(int[][] mem,int[][] arr,int m,int n){
		if(m == 0 || n == 0){
			return mem[m][n];
		}else if (mem[m][n] != 0){
			return mem[m][n];
		}
		else{
			mem[m][n] = getPathCountMemoization(mem,arr,m-1,n) + getPathCountMemoization(mem,arr,m,n-1);		
		}
		return mem[m][n];
		
	}

	// Use Dynamic Programming
	public static int getPathCountDP(int[][] arr,int m,int n){
		int[][] cache = new int[m+1][n+1];
		cache[0][0] = 0;
		for(int i=1;i<=m;i++){
			cache[i][0] = 1;
		}
		for(int i=0;i<=n;i++){
			cache[0][i]= 1;
		}
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				cache[i][j] = cache[i-1][j] + cache[i][j-1];
			}
		}

		return cache[m][n];
	}



}


