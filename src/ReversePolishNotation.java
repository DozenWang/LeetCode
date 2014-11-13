import java.util.HashSet;
import java.util.Stack;


public class ReversePolishNotation {
	public static int evalRPN(String[] tokens) {
		HashSet<String> operators = new HashSet<String>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
		Stack<String> stack = new Stack<String>();
		int i = 0;
		while(i < tokens.length) {
			int ret = Integer.MIN_VALUE;
			if(operators.contains(tokens[i])) {
				int secondNum = Integer.valueOf(stack.pop());
				int firstNum = Integer.valueOf(stack.pop());
				if(tokens[i].equals("+")) {
					ret = firstNum + secondNum;
				} else if(tokens[i].equals("-")) {
					ret = firstNum - secondNum;
				} else if(tokens[i].equals("*")) {
					ret = firstNum * secondNum;
				} else if(tokens[i].equals("/")) {
					ret = firstNum / secondNum;
				}
			} else {
				ret = Integer.valueOf(tokens[i]);
			}
			stack.push(String.valueOf(ret));
			i++;
		}
		int ret = Integer.valueOf(stack.pop());
		return ret;
	}

//	public static void main(String[] args) {
//		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//		int ret = evalRPN(tokens);
//		System.out.println(ret);
//	}
}
