import java.util.*;

public class Main {

    /**
     * 강의.
     * 겹쳐진 압축 해제 ( 자료구조 활용 )
     */
    public String solution(String s){
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack();

        for (char c : s.toCharArray()) {
            stack.add(c);

            if (stack.peek() == ')') {
                stack.pop();
                StringBuilder strB = new StringBuilder();
                while (stack.peek() != '(') {
                    strB.append(stack.pop());
                }
                stack.pop();
                strB.reverse();
                String tmp = strB.toString();
                int cnt;
                if (stack.isEmpty() || stack.peek() == '(') {
                    for (int i = 0; i < strB.length(); i++) {
                        stack.add(strB.toString().charAt(i));
                    }
                    continue;
                } else {
                    StringBuilder sCnt = new StringBuilder();
                    while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                        sCnt.insert(0, stack.pop());
                    }
                    cnt = Integer.parseInt(sCnt.toString());
                }
                for (int i = 1; i < cnt; i++) {
                    strB.append(tmp);
                }
                for (int i = 0; i < strB.length(); i++) {
                    stack.add(strB.toString().charAt(i));
                }
            }
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        return answer.reverse().toString();
    }

    public String solution(String s, int version){
        String answer = "";
        Stack<String> st = new Stack<>();
        for(Character x : s.toCharArray()){
            if(x == ')'){
                String tmp = "";
                while(!st.empty()){
                    String c = st.pop();
                    if(c.equals("(")){
                        String num = "";
                        while(!st.empty() && Character.isDigit(st.peek().charAt(0))){
                            num = st.pop() + num;
                        }
                        String res = "";
                        int cnt = 0;
                        if(num.equals("")) cnt = 1;
                        else cnt = Integer.parseInt(num);
                        for(int i = 0; i < cnt; i++) res += tmp;
                        st.push(res);
                        break;
                    }
                    tmp = c + tmp;
                }
            }
            else st.push(String.valueOf(x));
        }
        for(String x : st) answer += x;
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution("(10(cd))"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}