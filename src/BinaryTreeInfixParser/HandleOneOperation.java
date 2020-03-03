package BinaryTreeInfixParser;

public class HandleOneOperation {
    // handles operands and operator
    public static Integer handleOneOperation(Integer leftVal, Integer rightVal, String oper){
        Integer leftInt = leftVal;
        Integer rightInt = rightVal;
        String operator = oper;

        Integer result = -1;

        // perform operations
        if(operator.equals("+")) {
            result = leftInt + rightInt;
        } else if (operator.equals("-")){
            result = leftInt - rightInt;
        } else if (operator.equals("*")){
            result = leftInt * rightInt;
        } else if (operator.equals("/")){
            if (rightInt == 0) {
              System.out.println("Divide by zero not allowed, evaluation of expression invalid.");
              result = 0;
            } else {
              result = leftInt / rightInt;
            }
        } else if (operator.equals("^")){
            result = (int)Math.pow(leftInt,rightInt);
        } else if (operator.equals("%")){
            result = leftInt % rightInt;
        } else if (operator.equals(">")){
            if(leftInt > rightInt){
                result = 1;
            } else {
                result = 0;
            }
        } else if (operator.equals("<")){
            if(leftInt < rightInt){
                result = 1;
            } else {
                result = 0;
            }
        }else if (operator.equals(">=")){
            if(leftInt > rightInt){
                result = 1;
            } else {
                result = 0;
            }
        } else if (operator.equals("<=")){
            if(leftInt < rightInt){
                result = 1;
            } else {
                result = 0;
            }
        }else if (operator.equals("==")){
            if(leftInt == rightInt){
                result = 1;
            } else {
                result = 0;
            }
        }else if (operator.equals("!=")){
            if(leftInt != rightInt){
                result = 1;
            } else {
                result = 0;
            }
        }else if (operator.equals("&&")){
            if(leftInt != 0 && rightInt != 0){
                result = 1;
            } else {
                result = 0;
            }
        }else if (operator.equals("||")){
            if(leftInt != 0 || rightInt != 0){
                result = 1;
            } else {
                result = 0;
            }
        }
        // return the result
        return result;
    }
}
