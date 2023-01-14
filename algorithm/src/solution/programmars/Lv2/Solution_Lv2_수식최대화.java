package solution.programmars.Lv2;

import java.util.*;

/**
 * **문제 분석**
 * - 문자열 분할
 * - Union Find 알고리즘
 *
 * **문제 풀이**
 * 1. 주어진 문자열 분할
 *     - 숫자 뽑아내기 (숫자 배열)
 *     - 연산자 인덱스 뽑아내기 (연산자별 index 순서 저장, Map<String, List<Integer>> → <연산자, index 순서 리스트>
 * 2. 연산자 우선순위 정하기
 *     - +, -, * 연산자으로만 이루어졌으므로 하드코딩으로 해결
 * 3. 우선순위에 따라 연산하기
 *     - 연산자별로 계산 후 숫자 배열, parents 배열 update
 *         ex) A * B 연산일 때, 결과값을 A가 있었던 숫자 배열에 저장하고 B의 parent를 A로 바꿔준다.
 */
public class Solution_Lv2_수식최대화 {

    static String[][] priorities = {
            {"+", "-", "*"},
            {"+", "*", "-"},
            {"-", "+", "*"},
            {"-", "*", "+"},
            {"*", "+", "-"},
            {"*", "-", "+"},
    };

    public long solution(String expression) {
        long answer = 0;

        Map<String, List<Integer>> operatorMap = new HashMap<>();  // 연산자별 index 순서 저장
        List<Long> numbers = new ArrayList<>();
        int expressionLength = expression.length();

        int index = 0;
        for (int i = 0; i < expressionLength; i++) {
            for (int j = i; j < expressionLength; j++) {
                if (expression.charAt(j) == '-' || expression.charAt(j) == '*' || expression.charAt(j) == '+'){
                    numbers.add(Long.parseLong(expression.substring(i, j)));
                    operatorMap.computeIfAbsent(String.valueOf(expression.charAt(j)), value -> new ArrayList<>()).add(index++);
                    i = j;
                    break;
                }

                if (j == expressionLength - 1) {  // 마지막 숫자 저장
                    numbers.add(Long.parseLong(expression.substring(i, j + 1)));
                    i = j;
                }
            }
        }

        int[] parents = new int[numbers.size()];
        for (String[] priority : priorities) {
            Long[] numbersArray = numbers.toArray(new Long[numbers.size()]);
            settingParents(parents);

            for (String operator : priority) {
                List<Integer> idxList = operatorMap.getOrDefault(operator, new ArrayList<>());
                for (Integer idx : idxList) {
                    long result = calculate(operator, numbersArray[find(parents, idx)], numbersArray[find(parents, idx + 1)]);
                    numbersArray[find(parents, idx)] = result;
                    union(parents, idx, idx + 1);
                }
            }
            answer = Long.max(answer, Math.abs(numbersArray[find(parents, 0)]));
        }
        return answer;
    }

    private void settingParents(int[] parents) {
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }
    
    private boolean union(int[] parents, int a, int b) {
        int aRoot = find(parents, a);
        int bRoot = find(parents, b);
        
        if (aRoot == bRoot)
            return false;
        
        if (aRoot < bRoot)
            parents[bRoot] = aRoot;
        else
            parents[aRoot] = bRoot;

        return true;
    }
    
    private int find(int[] parents, int x) {
        if (x == parents[x])
            return x;
        else
            return parents[x] = find(parents, parents[x]);
    }

    private long calculate(String prefix, long number1, long number2) {
        if (prefix.equals("*")) {
            return number1 * number2;
        } else if (prefix.equals("+")) {
            return number1 + number2;
        } else if (prefix.equals("-")) {
            return number1 - number2;
        }
        return 0;
    }
}
