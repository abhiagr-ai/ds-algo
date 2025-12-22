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
public class d_reverse_stack_o_1 {
    static void main() {
        Stack<Integer> st = new Stack<>();
        st.addAll(List.of(4, 5, 6, 7));
        System.out.println("before: " + st);
        reverse(st);
        System.out.println("after " + st);
    }

    private static void reverse(Stack<Integer> st) {
        if (st.empty()) {
            return;
        }
        int top = st.pop();
        reverse(st);
        insertBottom(st, top);
    }

    private static void insertBottom(Stack<Integer> st, int e) {
        if (st.empty()) {
            st.push(e);
            return;
        }
        int top = st.pop();
        insertBottom(st, e);
        st.push(top);
    }
}
