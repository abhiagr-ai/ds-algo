package recursion;

import java.util.List;
import java.util.Stack;

/**
 * youtube.com/watch?v=YtxlDPr4kso&list=PLpIkg8OmuX-IBcXsfITH5ql0Lqci1MYPM&index=5
 * 7
 * 6
 * 5
 * 4
 */
public class b_reverse_stack_o_n {
    static void main() {
        Stack<Integer> st = new Stack<>();
        st.addAll(List.of(4,5,6,7));
        System.out.println("before: "+st);
        reverse(st);
        System.out.println("after "+st);
    }

    private static void reverse(Stack<Integer> st) {
        if(st.empty()){
            System.out.println("base-case hit ");
            return;
        }
        System.out.println("---------------");
        Integer top = st.pop();
        System.out.println("top>> "+top + " remaining "+st);
        reverse(st);
        //insert at bottom
        System.out.println("insert at bottom of reversed>> "+st);
        Stack<Integer> temp = new Stack<>();
        while (!st.empty()){
            temp.push(st.pop());
        }
        st.push(top);
        while (!temp.empty()){
            st.push(temp.pop());
        }
        System.out.println("inserted at bottom of reversed>> "+st);
        System.out.println("---------------");
    }
}
