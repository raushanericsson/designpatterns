
class FindSum{

	public static void main(String[] args){
		int[] arr = {10,2,3,4,5,9,7,8};
		int K = 23;
		//System.out.println(
		String output = "";
		getFourSumNumbers(arr,K,arr.length-1);

	}


	public static int getFourSumNumbers(int[] arr,int k,int m){
		//System.out.println(k + " " + m);
		if(k == 0){
			System.out.print("$");
			return 1;
		}else if(k < 0 || m <0){
			return 0;
		} 

		int a = getFourSumNumbers(arr,k,m-1); 
		int b = getFourSumNumbers(arr,k-arr[m],m-1);
		if(b ==1){
			System.out.print(arr[m] + " ");	
		}
		//return getFourSumNumbers(arr,k,m-1) + getFourSumNumbers(arr,k-arr[m],m-1);
		return a+b;
	}

}