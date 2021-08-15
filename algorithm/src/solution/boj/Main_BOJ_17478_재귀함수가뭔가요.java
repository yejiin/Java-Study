package solution.boj;

import java.util.Scanner;

public class Main_BOJ_17478_재귀함수가뭔가요 {

    private static StringBuilder sb = new StringBuilder();

    private static String str1 = "\"재귀함수가 뭔가요?\"";
    private static String str2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    private static String str3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    private static String str4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    private static String str5 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    private static String str6 = "라고 답변하였지.";

    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        sb.append(str1 + "\n");
        sb.append(str2 + "\n");
        sb.append(str3 + "\n");
        sb.append(str4 + "\n");

        recursion(1);

        sb.append(str6);
        System.out.println(sb.toString());
    }

    public static void recursion(int count) {

        String dash = "____";

        for (int i = 1; i < count; i++) {
            dash += "____";
        }

        sb.append(dash + str1 + "\n");

        if (count == n) {
            sb.append(dash + str5 + "\n");
            sb.append(dash + str6 + "\n");
            return;
        } else {

            sb.append(dash + str2 + "\n");
            sb.append(dash + str3 + "\n");
            sb.append(dash + str4 + "\n");

            recursion(count + 1);

            sb.append(dash + str6 + "\n");
        }

    }
}
