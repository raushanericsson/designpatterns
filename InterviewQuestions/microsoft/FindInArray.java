class FindInArray{

	public static void main(String[] args){
		int[] arr = {1,2,3,5,2,3,5};
		System.out.println(getSingleEntry(arr));


	}


	private static int getSingleEntry(int[] arr){

		int sum = 0;
		for(int i=0;i<arr.length;i++){

			sum = sum ^ arr[i];

		}

		return sum;

	}

}