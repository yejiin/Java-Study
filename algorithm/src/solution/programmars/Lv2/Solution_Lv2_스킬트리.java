package solution.programmars.Lv2;

public class Solution_Lv2_스킬트리 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            String temp = skill_tree;

            for (int i = 0; i < skill_tree.length(); i++) {
                String s = Character.toString(skill_tree.charAt(i));

                if (!skill.contains(s))
                    temp = temp.replace(s, ""); // skill 에 포함 안 되는 값 지우기
            }

            if (skill.indexOf(temp) == 0) // 새로 만든 문자열이 skill 의 처음 문자가 포함된 문자열인지 확인
                answer++;
        }
        return answer;
    }
}
