import java.util.*;

class Solution {
    private static final String[] OPERATORS = {"+", "-", "*"};
    private ArrayList<String> operators;
    private ArrayList<Long> numbers;
    
    public long solution(String expression) {
        operators = new ArrayList<>();
        numbers = new ArrayList<>();
        
        StringBuilder number = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c >= '0' && c <= '9') {
                number.append(c);
            } else {
                numbers.add(Long.parseLong(number.toString()));
                number = new StringBuilder();
                operators.add(String.valueOf(c));
            }
        }
        numbers.add(Long.parseLong(number.toString()));
        
        long answer = 0;
        String[][] operatorPriorities = {
            {"+", "-", "*"}, {"+", "*", "-"}, 
            {"-", "+", "*"}, {"-", "*", "+"}, 
            {"*", "+", "-"}, {"*", "-", "+"}
        };
        
        for (String[] priority : operatorPriorities) {
            answer = Math.max(answer, Math.abs(calculate(priority)));
        }
        
        return answer;
    }
    
    private long calculate(String[] priority) {
        ArrayList<String> expressionOperators = new ArrayList<>(operators);
        ArrayList<Long> expressionNumbers = new ArrayList<>(numbers);
        
        for (String operator : priority) {
            for (int i = 0; i < expressionOperators.size(); i++) {
                if (expressionOperators.get(i).equals(operator)) {
                    long result = calculateByOperator(
                        expressionNumbers.get(i),
                        expressionNumbers.get(i + 1),
                        operator
                    );
                    expressionNumbers.remove(i + 1);
                    expressionNumbers.set(i, result);
                    expressionOperators.remove(i);
                    i--;
                }
            }
        }
        
        return expressionNumbers.get(0);
    }
    
    private long calculateByOperator(long a, long b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            default:
                return a * b;
        }
    }
}