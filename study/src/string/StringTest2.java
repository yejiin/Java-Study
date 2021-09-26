package string;

public class StringTest2 {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello");
		String s4 = new String("hello");

		if (s1 == s2)
			System.out.println("s1와 s2는 같다"); // X
		if (s1 == s3)
			System.out.println("s1와 s3는 같다"); // X
		if (s1 == s4)
			System.out.println("s1와 s4는 같다"); // X
		if (s2 == s3)
			System.out.println("s2와 s3는 같다"); // X
		if (s2 == s4)
			System.out.println("s2와 s4는 같다"); // X
		if (s3 == s4)
			System.out.println("s3와 s4는 같다"); // X

		System.out.println("=============================");

		if (s1.equals(s2))
			System.out.println("s1와 s2는 같다"); // O
		if (s1.equals(s3))
			System.out.println("s1와 s3는 같다"); // O
		if (s1.equals(s4))
			System.out.println("s1와 s4는 같다"); // O
		if (s2.equals(s3))
			System.out.println("s2와 s3는 같다"); // O
		if (s2.equals(s4))
			System.out.println("s2와 s4는 같다"); // O
		if (s3.equals(s4))
			System.out.println("s3와 s4는 같다"); // O

	}
}
