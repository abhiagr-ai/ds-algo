package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class j_generate_parentheses {
    static void main() {
        SolutionGP s = new SolutionGP();
        // n=2 means two pairs are given
        // '(', '(' , ')', ')'
        List<String> list =s.generate(3);
        System.out.println(list);
    }
}

class SolutionGP {
    List<String> result = new ArrayList<>();
    List<String> generate(int n){
        append("",n);
        return result;
    }

    void append(String c, int n){
        // Base Case
        if(c.length()>=2*n){
            if(isValid(c)){
                result.add(c);
            };
            return;
        }
        // recursion left
        // append '(' open
        append(c+"(",n);
        // recursion right choice
        // append ')' close
        append(c+")",n);
    }

    boolean isValid(String parentheses){
        // when open and close count not equal
        int open =0;
        int close =0;
        for(Character t: parentheses.toCharArray() ){
            if(t.equals('(')){
                open++;
            } else {
                close++;
            }
        }
        if (open!= close){
            return false;
        }

        // when start with close
        if(parentheses.charAt(0)==')'){
            return false;
        }

        // when open and close count equal
        Stack<Character> st = new Stack<>();
        for(Character t: parentheses.toCharArray() ){
            if(t.equals('(')){
                st.push(t);
            } else {
                if(!st.empty()){
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}
