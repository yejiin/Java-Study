package solution.programmars.Lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution_Lv2_수식최대화_stack {
    private final String[] OP = {"+", "-", "*"};
    private long[] numbers;
    private String[] operators;
    
    private boolean[] selected = new boolean[OP.length];
    private Map<String, Integer> order = new HashMap<>();  // <연산자, 우선순위>, 숫자가 낮을수록 우선순위가 높음


    public long solution(String expression) {
        numbers = Arrays.stream(expression.split("[+\\-*]"))
                .mapToLong(Long::parseLong)
                .toArray();
        operators = expression.split("[0-9]+");
        return findMaxResult(0);
    }

    // Operator 우선 순위 정하기 (순열)
    private long findMaxResult(int priority) {
        long result = 0L;
        if (priority > 2){
            return calculate();
        }

        for (int i = 0; i < OP.length; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            order.put(OP[i], priority);
            result = Math.max(result, findMaxResult(priority + 1));
            selected[i] = false;
        }
        return result;
    }
    
    private long calculate() {
        Stack<Long> numStack = new Stack<>();
        Stack<String> opStack = new Stack<>();
        
        numStack.push(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            Long num = numStack.pop();
            while (!opStack.isEmpty()
                    && order.get(operators[i]) >= order.get(opStack.peek())) { // op 스택에 있는 연산자가 현재(i) 연산자 우선순위보다 높으면 loop, 계산
                num = calculate(numStack.pop(), num, opStack.pop());  // pop 한 것이 더 앞선 숫자이므로 연산의 첫번째 인자로 넣어준다.
            }
            numStack.push(num);
            numStack.push(numbers[i]);
            opStack.push(operators[i]);
        }

        Long result = numStack.pop();
        while (!opStack.isEmpty()) {
            result = calculate(numStack.pop(), result, opStack.pop());
        }

        return Math.abs(result);
    }
    
    private long calculate(long n1, long n2, String op) {
        switch (op) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            default:
                return 0;
        }
    }
}
