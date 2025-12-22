package recursion;

import java.util.List;
import java.util.Stack;

/**
 * youtube.com/watch?v=YtxlDPr4kso&list=PLpIkg8OmuX-IBcXsfITH5ql0Lqci1MYPM&index=5
 * 7
 * 6
 * 5
 */
public class c_insert_at_bottom_of_stack_o_1 {
    static void main() {
        Stack<Integer> st = new Stack<>();
        // 7 -> 6 -> 5
        st.addAll(List.of(5, 6, 7));
        System.out.println("before: " + st);
        insertBottom(st, 4);
        // 7 -> 6 -> 5 > 4
        System.out.println("after " + st);
    }

    private static void insertBottom(Stack<Integer> st, int element) {
        if (st.empty()) {
            st.push(element);
            return;
        }
        int top = st.pop();
        insertBottom(st, element);
        st.push(top);
    }
}
