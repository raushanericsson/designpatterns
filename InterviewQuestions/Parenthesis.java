import java.util.Stack;
import java.util.ArrayList;

class Parenthesis {
	public static void main(String[] args){

		String test = args[0];
		String test1 = args[1];
		System.out.println(checkValidity(test));
	}



// O(n) = n . Visiting data once in a lifecycle 
	private static boolean checkValidity (String input){

		Stack<Character> stack = new Stack<Character>();

		for(int i=0;i<input.length();i++){
			//System.out.println(stack);

			if(input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '('){
				stack.push(input.charAt(i));
			}else if(!stack.isEmpty()){
				
				char c = input.charAt(i);
				if(c == '}'){
					c = '{';
				}else if(c == ']'){
					c = '[';
				}else if(c == ')'){
					c = '(';
				}

				if(stack.peek() == c){
					stack.pop();
					continue;
				}
				return false;
			}else{
				return false;
			}
		}
		return true;
	}
}