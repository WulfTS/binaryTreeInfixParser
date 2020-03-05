package BinaryTreeInfixParser;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://www.geeksforgeeks.org/expression-tree/ was used to make this class
// Java program for expression tree
class Node {

    String value;
    Node left, right;

    Node(String item) {
        value = item;
        left = right = null;
    }
}

public class ExpressionTree {
    List<String> operators = Arrays.asList("+","-","*","/","^","%",">","<",">=","<=","==","!=", "||", "&&");


    boolean isOperator(String s) throws ArithmeticException{
        return operators.contains(s);
    }
    //https://www.geeksforgeeks.org/evaluation-of-expression-tree/ converted from C++ to java code
    public int eval(Node root){
            // empty tree
            if (root == null){
                return 0;
            }

            // leaf node i.e, an integer
            if ((root.left == null) && (root.right == null)) {
                return Integer.parseInt(root.value);
            }

            // Evaluate left subtree
            int l_val = eval(root.left);

            // Evaluate right subtree
            int r_val = eval(root.right);

            // divide by zero found
            if (r_val == 0 && root.value == "/"){
            throw new ArithmeticException();
            }
            return HandleOneOperation.handleOneOperation(l_val, r_val, root.value);
    }

    // Returns root of constructed tree for given
    // postfix expression
    Node constructTree(String[] postfixString) {
        Stack<Node> st = new Stack();
        Node t, t1, t2;

        // Traverse through every character of
        // input expression
        for (String postfixPart : postfixString) {

            // If operand, simply push into stack
            if (!isOperator(postfixPart)) {
                t = new Node(postfixPart);
                st.push(t);
            } else // operator
            {
                t = new Node(postfixPart);

                // Pop two top nodes
                // Store top
                t1 = st.pop();      // Remove top
                t2 = st.pop();

                // make them children
                t.right = t1;
                t.left = t2;

                // System.out.println(t1 + "" + t2);
                // Add this subexpression to stack
                st.push(t);
            }
        }

        //  only element will be root of expression
        // tree
        t = st.peek();
        st.pop();

        return t;
    }
}
