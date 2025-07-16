package softeer.lv2;

import leetcode.stack_queue.prev.Stack143_RecorderList;

import java.util.*;

public class YeahButHow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] splitStr = line.split("");

        Stack<String> stack = new Stack<>();

        List<Stack143_RecorderList.ListNode> nodeList = new LinkedList<>();

        String result = "";
        String before = "";

        for (String str : splitStr) {

            if (str.equals("(")) {
                if (before.equals(")")) {
                    result += "+";
                }
                stack.push(str);
                result += str;
            }

            if (str.equals(")")) {
                if (before.equals(")")) {
                    result += "+";
                }
                if (stack.size() > 1) {
                    result += "1)";
                    stack.pop();
                } else {
                    result += "1)";
                    stack.pop();
                }

            }

            before = str;

        }

        System.out.println(result);
    }

}
