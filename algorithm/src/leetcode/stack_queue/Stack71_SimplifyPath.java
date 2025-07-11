package leetcode.stack_queue;

import java.util.*;

public class Stack71_SimplifyPath {
    /*
        Unix 스타일 파일 시스템을 위한 절대 경로가 주어지며, 이는 항상 슬래시 '/'로 시작합니다.
        이 절대 경로를 단순화된 정규 경로로 변환하는 것이 당신의 과제입니다.
        Unix 스타일 파일 시스템의 규칙은 다음과 같습니다:

        단일 마침표 '.'는 현재 디렉토리를 나타냅니다.
        이중 마침표 '..'는 이전/상위 디렉토리를 나타냅니다.
        '//'와 '///'같은 연속된 여러 개의 슬래시는 단일 슬래시 '/'로 취급됩니다.
        위의 규칙과 일치하지 않는 마침표들의 시퀀스는 유효한 디렉토리 또는 파일 이름으로 취급되어야 합니다.
        예를 들어, '...'와 '....'는 유효한 디렉토리나 파일 이름입니다.

        단순화된 정규 경로는 다음 규칙을 따라야 합니다:

        경로는 반드시 하나의 슬래시 '/'로 시작해야 합니다.
        경로 내의 디렉토리들은 정확히 하나의 슬래시 '/'로 구분되어야 합니다.
        루트 디렉토리가 아닌 경우, 경로는 슬래시 '/'로 끝나서는 안 됩니다.
        경로에는 현재 또는 상위 디렉토리를 나타내는 단일 또는 이중 마침표('.'와 '..')가 사용되어서는 안 됩니다.

        단순화된 정규 경로를 반환하세요.
     */

    static public String simplifyPath(String path) {

        if(path.length() == 1 ) return path;

        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));

        for(String str : path.split("/")) {
            if(str.equals("..") && !stack.isEmpty()) stack.pop();
            else if(!skip.contains(str)) stack.push(str);
        }

        String ans = "";
        for(String str : stack) {
            ans = "/" + str + ans;
        }

        return ans.isEmpty() ? "/" : ans;

    }

    static public String simplifyPath2(String path) {

        String[] strings = Arrays.stream(path.split("/")).filter(s -> !s.isEmpty()).toArray(String[]::new);

        if(strings.length == 1){
            if(strings[0].equals("..")){
                return "/";
            } else if(strings[0].equals(".")){
                return "/";
            } else {
                return "/" + strings[0];
            }
        }

        Stack<String> beforeStack = new Stack<>();

        for (int i = strings.length - 1; i >= 0; i--) {

            if (strings[i].equals("..")) {
                beforeStack.add(strings[i]);
                strings[i] = "";
            } else if (strings[i].equals(".")) {
                strings[i] = "";
            } else {

                if (!beforeStack.isEmpty()) {
                    System.out.println(strings[i]);
                    strings[i] = "";
                    beforeStack.pop();
                }
            }
        }

        strings = Arrays.stream(strings).filter(s -> !s.isEmpty()).toArray(String[]::new);

        if(strings.length == 0) {
            return "/";
        }

        StringBuilder result = new StringBuilder();

        for (String string : strings) {

            if (!string.isEmpty()) {
                result.append("/").append(string);
            }
        }

        return result.toString();
    }
}
