import java.util.Arrays;

class CoinChange{

	public static void main(String[] args){

		int[] arr = {1,2,3};
		int sum = 4;
		System.out.println(getWaysOfSum(arr,sum));
		System.out.println(getWaysOfSumDP(arr,sum));

	}

	public static int getWaysOfSum(int[] arr,int sum){

		if(sum == 0){
			return 1;
		}else if(sum < 0){
			return 0;
		}
		int count = 0;
		for(int i=0;i<arr.length;i++){

			if(sum >= arr[i]){
				count = count + getWaysOfSum(arr,sum-arr[i]);
			}else{
			//	System.out.println("Count = " + count);
				return count;
			}

		}
		return count;
	}


	public static int getWaysOfSumDP(int[] arr,int sum){
		int[] result = new int[sum+1];
		Arrays.fill(result,0);
		result[0] = 1;


		for(int j=1;j<=sum;j++){

			for(int i=0;i<arr.length;i++){
				if(j - arr[i] >= 0){
					result[j] += result[j-arr[i]];
				}else{
					break;
				}

			}

		}
		//System.out.println("=======");

		for(int i : result){
		//	System.out.print(" == " + i);
		}

		return result[sum];
	}

}