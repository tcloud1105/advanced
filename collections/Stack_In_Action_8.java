package collections;

import java.util.Stack;

public class Stack_In_Action_8 {
    public static void main(String args[]){
        Stack<String> st = new Stack<>();
        st.push("bottom");
        printStack(st);
        st.push("second");
        printStack(st);
        st.push("third");
        printStack(st);

        st.pop();
        printStack(st);
        st.pop();
        printStack(st);
        st.pop();
        printStack(st);
    }

    private static void printStack(Stack<String> st) {
        if(st.isEmpty()){
            System.out.println("stack is empty");
        }else{
            System.out.printf("%s TOP\n", st);
        }
    }
}
