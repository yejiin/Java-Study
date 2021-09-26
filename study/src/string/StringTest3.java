package string;

import java.util.Arrays;

public class StringTest3 {
	public static void main(String[] args) {
		String str = "hello kim !!!";
		char c = str.charAt(1);
		System.out.println("c : " + c);

		System.out.println(str.concat("000"));
		System.out.println(str);

		// equals : =
		// contains : like (wildcard : % _ )
		if (str.contains("ss")) {
			System.out.println("ss 포함");
		}

		if (str.startsWith("hello"))
			System.out.println("hello로 시작!!!");
		if (str.endsWith("!"))
			System.out.println("!로 끝!!!");

		System.out.println(str + "에서 s는 " + (str.indexOf('s') + 1) + "번째 있습니다.");
		System.out.println(str + "에서 마지막 s는 " + (str.lastIndexOf('s') + 1) + "번째 있습니다.");
		System.out.println(str + "에서 ssafy는 " + (str.indexOf("ssafy") + 1) + "번째 있습니다.");

		str = " ";
		System.out.println("str 문자열 길이 : " + str.length());
		System.out.println("str은 빈문자열?? " + str.isEmpty());

		str = "  he   ll  o  k i   m     ";
		System.out.println("str 문자열 길이 : " + str.length());
		System.out.println("str 문자열 길이 : " + str.trim().length()); // trim : 앞 뒤 공백제거. 중간 공백은 제거 못함

		str = "hello jaba !!!";
		System.out.println(str.replace('b', 'v'));
		System.out.println(str.replace("jaba", "java"));
		System.out.println(str.replaceAll("jaba", "java"));
		System.out.println(str);

		String s[] = str.split(" ");
		System.out.println(Arrays.toString(s));

		System.out.println(str.substring(6, 10));
		System.out.println(str.substring(6));
	}

}