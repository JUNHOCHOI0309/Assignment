package day0807;

import java.util.Stack;

public class Stack1 {
    public static String checkBracket(String str){
        Stack<Character> stack = new Stack<>();

        for(char ch: str.toCharArray()){
            if(ch=='('){
                stack.push(ch);
            } else if (ch == ')') {
                if(stack.empty()){
                    return "잘못된 괄호입니다.";
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? "올바른 괄호입니다." : "잘못된 괄호입니다.";
    }

    public static void main(String[] args) {
        System.out.println(checkBracket("(()())"));
        System.out.println(checkBracket("((())"));
    }
}
