class PatternPrint{

	public static void main(String[] args){
		printWithoutLoop(16,11,4);

	}


	public static void printWithoutLoop(int n,int k,int count){
		if(count < 0)
			return;
		count--;
		System.out.print(n + " " + k + " ");
		if(k == 11){
			printWithoutLoop(n-10,1,count);
		}else{
			printWithoutLoop(n+10,11,count);
		}

	}
	
}