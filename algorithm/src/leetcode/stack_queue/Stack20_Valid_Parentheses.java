package leetcode.stack_queue;

import java.util.Stack;
import java.util.regex.Pattern;

public class Stack20_Valid_Parentheses {
    /*
        문자 '(', ')', '{', '}', '[', ']'만을 포함하는 문자열 s가 주어질 때, 입력 문자열이 유효한지 판단하세요.
        입력 문자열이 유효하려면 다음 조건을 만족해야 합니다:

        여는 괄호는 같은 종류의 괄호로 닫혀야 합니다.
        여는 괄호는 올바른 순서로 닫혀야 합니다.
        모든 닫는 괄호는 같은 종류의 여는 괄호와 짝을 이루어야 합니다.
     */
    public static boolean isValid2(String s) {
        if(s.length() <= 1) return false;

        String[] strings = s.split("");
        Stack<String> stack = new Stack<>();

        for(String str : strings) {

            if((str.startsWith("}") || str.endsWith(")") || str.startsWith("]"))) {

                if(stack.isEmpty()) return false;

                String str2 = stack.peek();

                if(str.equals("}") && !str2.equals("{")) {

                    return false;
                }

                if(str.equals(")") && !str2.equals("(")) {

                    return false;
                }

                if(str.equals("]") && !str2.equals("[")) {
                    return false;
                }

                stack.pop();

            } else {

                stack.push(str);

            }

        }

        if(stack.size() > 0) return false;

        return true;

    }

    public static boolean isValid(String s) {

        /*
            들어온 순서대로 나가야 합니다.
            순서대로 stack으로 쌓고, 괄호가 달라질 때마다 위에서부터 하나씩 제거하는데 제거에 실패하면 false
         */

        String[] strings = s.split("");
        Stack<String> stack = new Stack<>();

        Pattern left = Pattern.compile("^[({\\[]+$");

        for(String str : strings) {

            if(left.matcher(str).matches()) {
                stack.push(str);
            } else {

                if(stack.isEmpty()) {
                    return false;
                }

                if(str.equals("]")) {
                    if(!stack.peek().equals("[")){
                        return false;
                    } else {
                        stack.pop();
                    }
                } else if (str.equals("}")) {
                    if(!stack.peek().equals("{")){
                        return false;
                    } else {
                        stack.pop();
                    }
                } else {
                    if(!stack.peek().equals("(")){
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
