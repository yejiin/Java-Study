package exception;

import java.io.*;

public class Login {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("아이디 : ");
		String id = in.readLine();
		System.out.print("비밀번호 : ");
		String pass = in.readLine();

		String name;
		try {
			name = login(id, pass);
			System.out.println(name + "님 안녕하세요.");
		} catch (PasswordNotMatchException e) {
			e.printStackTrace();
		} catch (IdNotMatchException2 e) {
			e.printStackTrace();
		}
	}

	private static String login(String id, String pass) throws PasswordNotMatchException, IdNotMatchException2 {
		if (id.equals("hello")) {
			if (pass.equals("1234")) {
				return "홍길동";
			}
			throw new PasswordNotMatchException("비밀번호가 틀렸습니다");
		} else {
			throw new IdNotMatchException2("아이디가 틀렸습니다.");
		}
	}
}
