package BinaryTreeInfixParser;

import java.io.IOException;
import java.util.List;
import java.util.Queue;

public class BinaryTreeExpressions {
    public static void main(String[] args) throws IOException {
        InputHandler inputHandler = new InputHandler();
        List<Queue<String>> expressions = inputHandler.getInputFromTextFile();
        InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter();
        ExpressionTree expressionTree = new ExpressionTree();

        for(Queue<String> s : expressions){
            String[] postfixString = infixToPostfixConverter.convertInfixToPostfix(s).split(" ");
            System.out.println(expressionTree.eval(expressionTree.constructTree(postfixString)));
        }

    }
}
