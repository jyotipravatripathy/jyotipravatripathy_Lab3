package balancingbrackets;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {
	static boolean findBalance(String input){
		boolean rtnValue = false;
		
		if(input.length() %2 != 0)
			return rtnValue;
		
		Stack<Character> brakets = new Stack<>();
		
		for(int index=0; index < input.length(); index++) {
			char readChar = input.charAt(index);
			
			if(readChar == '{' || readChar == '[' || readChar == '(') {
				brakets.push(readChar);
				continue;
			}
			
			if(brakets.isEmpty()){
				rtnValue = false;
				break;
			}
			if(readChar == '}') {
				char popChar = brakets.pop();
				if(popChar == '{')
					rtnValue = true;
				else {
					rtnValue= false;
					break;
				}
			}
			
			if(readChar == ']') {
				char popChar = brakets.pop();
				if(popChar == '[')
					rtnValue = true;
				else {
					rtnValue= false;
					break;
				}
			}
			
			if(readChar == ')') {
				char popChar = brakets.pop();
				if(popChar == '(')
					rtnValue = true;
				else {
					rtnValue= false;
					break;
				}
			}
		}
		return rtnValue;
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your string");
		String braces = scan.nextLine();
		if(findBalance(braces)) {
			System.out.println("The entered String has Balanced Brackets");
		}
		else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}
}