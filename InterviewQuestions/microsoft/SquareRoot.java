class SquareRoot{

	public static void main(String[] args){

		int input = Integer.ParseInt(args[0]);
		System.out.println(getSquareRoot(input));

	}


	public static float getSquareRoot(int n){
		float start = 1;
		float div = 0.0001;
		for(float i=start;i <= n/2;){
			double temp = (i) * (i);
			if(temp == n){
				return temp;
			}else if(temp > n){
				div = div/10;
			}
			i = i+div;
		}
	}

}